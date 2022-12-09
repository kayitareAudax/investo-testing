import { Companylist } from "../../src/components/Companylist"

describe('test company list', () => {
  it('mounts', () => {
    cy.mount(<Companylist/>)
  })
})