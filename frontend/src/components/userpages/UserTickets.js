import React, {useEffect, useState} from "react";
import '../../App.css';
import {useNavigate} from "react-router-dom";
import Sidebar from "../partials/Sidebar";

export default function UserTickets() {
    let navigate = useNavigate();
    const [tickets, allTickets] = useState([]);
    const [sidebarOpen, setSidebarOpen] = useState(false);
    useEffect(() => {

        if (localStorage.getItem("roles") === "ROLE_ADMIN" || localStorage.getItem("roles") === "ROLE_OVERSEER") {
            fetch(`http://localhost:8080/tickets/all`,
                {
                    method: "GET",
                    headers: {
                        'Authorization': 'Bearer ' + localStorage.getItem("token"),
                        "Content-Type": "application/json"
                    }
                }
            )
                .then(response => response.json())
                .then((response) => {
                    allTickets(response)
                })
        } else {
            fetch(`http://localhost:8080/tickets/show?userId=${localStorage.getItem("userID")}`, {
                method: "GET", headers: {
                    'Authorization': 'Bearer ' + localStorage.getItem("token"), "Content-Type": "application/json"
                }
            })
                .then(response => response.json())
                .then((response) => {
                    allTickets(response)
                })
        }

    }, []);

    return (
        <div>
            <div className="flex h-screen overflow-hidden">

                <Sidebar sidebarOpen={sidebarOpen} setSidebarOpen={setSidebarOpen}/>

                <div className="container  px-2 sm:px-8 max-w-3xl">
                    <div className="py-8 max-w-2xl">
                        <div className="flex flex-row mb-1 sm:mb-0 justify-between w-full">
                            <h2 className="text-2xl leading-tight">
                                Tickets
                            </h2>
                        </div>
                        <div className="-mx-4 sm:-mx-2 px-4 sm:px-8 py-4 ">
                            <div className="inline-block min-w-max shadow rounded-lg overflow-hidden">
                                <table className="min-w-max leading-normal">
                                    <thead>
                                    <tr>
                                        <th scope="col"
                                            className="px-5 py-3 bg-white  border-b border-gray-200 text-gray-800  text-left text-sm uppercase font-normal">
                                            Name
                                        </th>
                                        <th scope="col"
                                            className="px-5 py-3 bg-white  border-b border-gray-200 text-gray-800  text-left text-sm uppercase font-normal">
                                            Description
                                        </th>
                                        <th scope="col"
                                            className="px-5 py-3 bg-white  border-b border-gray-200 text-gray-800  text-left text-sm uppercase font-normal">
                                            Type
                                        </th>
                                        <th scope="col"
                                            className="px-5 py-3 bg-white  border-b border-gray-200 text-gray-800  text-left text-sm uppercase font-normal">
                                            Property Id
                                        </th>
                                        <th scope="col"
                                            className="px-5 py-3 bg-white  border-b border-gray-200 text-gray-800  text-left text-sm uppercase font-normal">
                                            Status
                                        </th>
                                        <th scope="col"
                                            className="px-5 py-3 bg-white  border-b border-gray-200 text-gray-800  text-left text-sm uppercase font-normal">
                                            Posted At
                                        </th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    {tickets.map((ticket) =>
                                            <tr>
                                                <td className="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                                                    <div className="flex items-center ">

                                                        <div className="ml-3 ">
                                                            <p className="text-gray-900 whitespace-no-wrap ">
                                                                {ticket.name}
                                                            </p>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td className="px-5 py-5 border-b border-gray-200 bg-white text-sm text-left">
                                                    <p className="text-gray-900 whitespace-no-wrap">
                                                        {ticket.description}
                                                    </p>
                                                </td>
                                                <td className="px-5 py-5 border-b border-gray-200 bg-white text-sm text-left">
                                                    <p className="text-gray-900 whitespace-no-wrap">
                                                        {ticket.type}
                                                    </p>
                                                </td>
                                                <td className="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                                                    <p className="text-gray-900 whitespace-no-wrap">
                                                        {ticket.propertyId}
                                                    </p>
                                                </td>
                                                {ticket.status.toString() === "true" ?
                                                    <>
                                                        <td className="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                                    <span
                                        className="relative inline-block px-3 py-1 font-semibold text-green-900 leading-tight">
                                        <span aria-hidden="true"
                                              className="absolute inset-0 bg-green-200 opacity-50 rounded-full">
                                        </span>
                                        <span className="relative">
                                            {ticket.status.toString()}
                                        </span>
                                    </span>
                                                        </td>
                                                    </>
                                                    :
                                                    <>
                                                        <td className="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                                    <span
                                        className="relative inline-block px-3 py-1 font-semibold text-red-700 leading-tight">
                                        <span aria-hidden="true"
                                              className="absolute inset-0 bg-red-500 opacity-50 rounded-full">
                                        </span>
                                        <span className="relative">
                                            {ticket.status.toString()}
                                        </span>
                                    </span>
                                                        </td>
                                                    </>
                                                }
                                                <td className="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                                                    <p className="text-gray-900 whitespace-no-wrap">
                                                        {ticket.postedAt}
                                                    </p>
                                                </td>
                                            </tr>
                                    )}
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}