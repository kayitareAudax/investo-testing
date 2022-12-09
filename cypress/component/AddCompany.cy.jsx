import { AddCompany } from "../../src/components/AddCompany"

describe('AddCompany.cy.js', () => {
  it('playground', () => {
    cy.mount(<AddCompany/>)
    cy.get("#name").type("BOOKINGA");
    cy.get("#shareValue").type(10);
    cy.get("#shares").type(4);
    cy.get("#total").type(100);    
    cy.contains("[type='submit']","Add Company");
    cy.get("[type='submit']").should("be.visible")
  })
})