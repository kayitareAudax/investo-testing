import React, { createContext, useReducer } from 'react';
import AppReducer from './AppReducer'
import axios from 'axios'
const initialState = {
    companies: [
        // { id: 1, name: 'Ishan Manandhar', shareValue: 1200, myShares: 10,companyTotalFunds:40000 }
    ]
}

export const GlobalContext = createContext(initialState);
export const GlobalProvider = ({ children }) => {
    const [state, dispatch] = useReducer(AppReducer, initialState);

    function removeCompany(id) {
        const resp=axios.delete(`http://localhost:8080/company/${id}`);
        console.log(resp.data);
        getCompanies();
        dispatch({
            type: 'REMOVE_COMPANY',
            payload: id
        });
    };

    async function addCompany(companies){
        //perform request on to backend;
        const resp=await axios.post("http://localhost:8080/company",companies);
        console.log("reached add");
        const {data}=resp
        dispatch({
            type: 'ADD_COMPANY',
            payload: data
        });
    };

    async function editCompany(id,companies) {
        const res=await axios.put(`http://localhost:8080/company/${id}`,companies)
        console.log(res.data);
        dispatch({
            type: 'EDIT_COMPANY',
            payload: companies
        });
    };
    async function getCompanies(){
        const resp=await axios.get("http://localhost:8080/company");
        const {data}=resp;
        console.log(data);
        dispatch({
            type:'GET_COMPANIES',
            payload:data
        })
    }

    return (<GlobalContext.Provider value={{
        getCompanies,
        companies: state.companies.reverse(),
        removeCompany,
        addCompany,
        editCompany
    }}>
        {children}
    </GlobalContext.Provider>);
}