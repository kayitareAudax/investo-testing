describe('company list tests', () => {
  beforeEach(()=>{
    cy.visit(`http://127.0.0.1:5173`)
  })
  it("tests presence of companies",()=>{
    cy.get("#companies>#company")
    cy.get("#company").should("contain","BOOKINGA")
  });
  // it('test delete',()=>{
  //   cy.get('.removeBtn:first').click();
  //   cy.get("#company").should("not.have.text","BOOKINGA")
  // })
  it('test edit',()=>{
    cy.get("#edit").click();
    cy
  })
})