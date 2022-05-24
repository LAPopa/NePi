import React, {useEffect, useState} from "react";

export default function UserTickets() {

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
                </tr>
                )}
                </tbody>
            </table>
        </div>
    )
}