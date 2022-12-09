describe("test get companies with mock",()=>{
    beforeEach(()=>{
        cy.visit("http://127.0.0.1:5173")
    })
    it('gets companies',()=>{
        cy.intercept("GET","http://localhost:8080/company",{
            fixture:"companies.json"
        });
        cy.get("#companies>#company")
        cy.get("#companies").should("contain","BOOKINGA")
    })
})