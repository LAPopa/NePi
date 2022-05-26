import React, {useEffect, useState} from "react";
import '../../App.css';
import {useNavigate} from "react-router-dom";

export default function UserTickets() {
    let navigate = useNavigate();
    const [tickets, allTickets] = useState([]);

    useEffect(() => {

        fetch(`http://localhost:8080/tickets/show?userId=${localStorage.getItem("userID")}`,
            {
                method : "GET",
                headers : {
                    'Authorization' : 'Bearer ' + localStorage.getItem("token"),
                    "Content-Type" : "application/json"
                }
            }
            )
            .then(response => response.json())
            .then((response) => {
                allTickets(response)
            })
    }, []);

    return (
        <div className="container mx-auto px-4 sm:px-8 max-w-3xl">
            <table className="min-w-full leading-normal">
                <thead>
                <tr>
                    <th scope="col" className="px-5 py-3 bg-white  border-b border-gray-200 text-gray-800  text-left text-sm uppercase font-normal">
                        Name
                    </th>
                    <th scope="col" className="px-5 py-3 bg-white  border-b border-gray-200 text-gray-800  text-left text-sm uppercase font-normal">
                        Description
                    </th>
                    <th scope="col" className="px-5 py-3 bg-white  border-b border-gray-200 text-gray-800  text-left text-sm uppercase font-normal">
                        Type
                    </th>
                    <th scope="col" className="px-5 py-3 bg-white  border-b border-gray-200 text-gray-800  text-left text-sm uppercase font-normal">
                        Property Id
                    </th>
                    <th scope="col" className="px-5 py-3 bg-white  border-b border-gray-200 text-gray-800  text-left text-sm uppercase font-normal">
                        Status
                    </th>
                    <th scope="col" className="px-5 py-3 bg-white  border-b border-gray-200 text-gray-800  text-left text-sm uppercase font-normal">
                        Posted At
                    </th>
                </tr>
                </thead>
                <tbody>
                {tickets.map((ticket)=>
                <tr>
                    <td className="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                        <div className="flex items-center">
                            <div>
                                <p className="text-gray-900 whitespace-no-wrap">
                                    {ticket.name}
                                </p>
                            </div>
                        </div>
                    </td>
                    <td className="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                        <div className="flex items-center">
                            <div>
                                <p className="text-gray-900 whitespace-no-wrap">
                                    {ticket.description}
                                </p>
                            </div>
                        </div>
                    </td>
                    <td className="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                        <div className="flex items-center">
                            <div>
                                <p className="text-gray-900 whitespace-no-wrap">
                                    {ticket.type}
                                </p>
                            </div>
                        </div>
                    </td>
                    <td className="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                        <div className="flex items-center">
                            <div>
                                <p className="text-gray-900 whitespace-no-wrap">
                                    {ticket.propertyId}
                                </p>
                            </div>
                        </div>
                    </td>
                    <td className="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                        <div className="flex items-center">
                            <div>
                                <p className="text-gray-900 whitespace-no-wrap">
                                    {ticket.status.toString()}
                                </p>
                            </div>
                        </div>
                    </td>
                    <td className="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                        <div className="flex items-center">
                            <div>
                                <p className="text-gray-900 whitespace-no-wrap">
                                    {ticket.postedAt}
                                </p>
                            </div>
                        </div>
                    </td>
                </tr>
                )}
                </tbody>
            </table>
            <div className="max-w-sm mx-auto md:w-1/4">
                <button
                    className="py-2 px-4  bg-red-600 hover:bg-pink-700 focus:ring-pink-500 focus:ring-offset-pink-200 text-white w-full transition ease-in duration-200 text-center text-base font-semibold shadow-md focus:outline-none focus:ring-2 focus:ring-offset-2  rounded-lg "
                    onClick={() => navigate("/TEST-DASHBOARD")}>
                    Back
                </button>
            </div>
        </div>
    )
}