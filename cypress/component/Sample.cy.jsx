import { Sample } from "../../src/components/Sample"

describe('Sample.cy.jsx', () => {
  it('playground', () => {
    cy.mount(<Sample/>)
  })
})