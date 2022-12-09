describe('empty spec', () => {
  beforeEach(()=>{
    cy.visit(`http://127.0.0.1:5173/add`)
  })
  it("tests add",(done)=>{
    cy.get("#name").type("BOOKINGA");
    cy.get("#shareValue").type(10);
    cy.get("#shares").type(4);
    cy.get("#total").type(100);    
    cy.contains("[type='submit']","Add Company").click();
    cy.location().should((loc)=>{
      expect(loc.href).to.eq('http://127.0.0.1:5173/')
      done()
    })
  })
})