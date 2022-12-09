import React, { Fragment, useState, useContext } from 'react';
import { GlobalContext } from '../context/GlobalState';
import { useHistory } from "react-router-dom";
import { Link } from 'react-router-dom';

export const AddCompany = () => {
    const [name, setName] = useState('');
    const [shareValue, setShareValue] = useState(null);
    const [myShares, setMyShares] = useState(null);
    const [companyTotalFunds,setCompanyTotalFunds]=useState(null);
    const addCompany  = useContext(GlobalContext);
    let history = useHistory();

    const onSubmit = e => {
        e.preventDefault();
        const newCompany = {
            name,
            shareValue,
            myShares,
            companyTotalFunds
        }
        addCompany(newCompany);
        history.push("/");
    }

    return (
        <Fragment>
            <div className="w-full max-w-sm container mt-20 mx-auto">
                <form onSubmit={onSubmit}>
                    <div className="w-full mb-5">
                        <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" htmlFor="name">
                            Name of Company
                        </label>
                        <input className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:text-gray-600" value={name} onChange={(e) => setName(e.target.value)} type="text" id='name' placeholder="Enter name" />
                    </div>
                    <div className="w-full  mb-5">
                        <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" htmlFor="location">
                            share value
                        </label>
                        <input className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:text-gray-600 focus:shadow-outline" value={shareValue} onChange={(e) => setShareValue(e.target.value)} id='shareValue' type="text" placeholder="Enter share value" />
                    </div>
                    <div className="w-full  mb-5">
                        <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" htmlFor="designation">
                            number of shares
                        </label>
                        <input className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:text-gray-600" value={myShares} onChange={(e) => setMyShares(e.target.value)} type="number" id='shares' placeholder="Enter number of shares" />
                    </div>
                    <div className="w-full  mb-5">
                        <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" htmlFor="designation">
                            company total funds
                        </label>
                        <input className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:text-gray-600" value={companyTotalFunds} onChange={(e) => setCompanyTotalFunds(e.target.value)} id="total" type="number" placeholder="Enter total funds" />
                    </div>
                    <div className="flex items-center justify-between">
                        <button type='submit' className="mt-5 addBtn bg-green-400 w-full hover:bg-green-500 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline">
                            Add Company
                        </button>
                    </div>
                    <div className="text-center mt-4 text-gray-500">
                        {/* <Link to='/'>Cancel</Link> */}
                        </div>
                </form>
            </div>
        </Fragment>
    )
}