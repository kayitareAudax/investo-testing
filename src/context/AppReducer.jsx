export default (state, action) => {
    switch (action.type) {
        
        case 'GET_COMPANIES':
            console.log("reached reducer");
            return{
                ...state,
                companies:action.payload
            }
        // case 'ADD_COMPANY':
        //     return {
        //         ...state,
        //         companies: [...state.companies, action.payload]
        //     };
        // case 'EDIT_COMPANY':
        //     const updatedCompany = action.payload;

        //     const updatedCompanies = state.companies.map(company => {
        //         if (company.id === updatedCompany.id) {
        //             return updatedCompanies;
        //         }
        //         return company;
        //     });

        //     return {
        //         ...state,
        //         companies: updatedCompanies
        //     };
        default: return state;
    }
}