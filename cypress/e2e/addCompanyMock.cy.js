
describe("add company mock tests",()=>{
    beforeEach(()=>{
        cy.visit('http://127.0.0.1:5173/add')
    })
    it('adds company',()=>{
        cy.get("#name").type("BOOKINGA");
        cy.get("#shareValue").type(10);
        cy.get("#shares").type(4);
        cy.get("#total").type(100);    
        cy.contains("[type='submit']","Add Company").click();
        cy.intercept("POST","http://localhost:8080/company",(req)=>{
            req.reply((res)=>{
                res.send({
                        "name": "BOOKINGA",
                        "shareValue": 10,
                        "myShares": 4,
                        "myAmount": 40,
                        "myPercentage": 40,
                        "companyTotalFunds": 100
                })
            })
        })
        cy.location().should((loc)=>{
          expect(loc.href).to.eq('http://127.0.0.1:5173/')
          done()
        })
    })
})