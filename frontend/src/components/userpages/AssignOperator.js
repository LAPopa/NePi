import React, {useEffect, useState} from "react";
import '../../App.css';
import {toast} from "react-toastify";

export default function AssignOperator() {

    const [tickets, allTickets] = useState([]);
    const [operators, allOperators] = useState([]);

    useEffect(() => {

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
        fetch(`http://localhost:8080/tickets/operators/all`,
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
                allOperators(response)
            })
    }, []);

    const onSubmit = (e) => {
        e.preventDefault();
        const formData = new FormData(e.target);

        if (formData.get('ticketId') !== ""
            && formData.get('operatorContractId') !== "") {

            fetch(`http://localhost:8080/tickets/assign-operator`, {
                method: "POST",
                headers: {
                    // Accept: "application/json",
                    "Authorization": "Bearer " + localStorage.getItem("token"),
                    "Content-type": "application/json",
                },
                body: JSON.stringify({
                    ticketId: formData.get('ticketId'),
                    operatorContractId: formData.get('operatorContractId'),

                }),
            })
                .then((response) => response.json())
                .catch(function () {
                })
                .then(() => {
                    window.location.reload();
                })
        } else {
            toast.error('Please fill in the ticket id and operator contract id !', {
                position: "top-center",
                autoClose: false,
                hideProgressBar: false,
                closeOnClick: true,
                pauseOnHover: true,
                draggable: true,
                progress: undefined,
            });
        }


    }


    return (

        <div>
            <div className="container mx-auto px-2 sm:px-8 max-w-3xl">
                <div className="py-8">
                    <div className="flex flex-row mb-1 sm:mb-0 justify-between w-full">
                        <h2 className="text-2xl leading-tight">
                            Tickets
                        </h2>

                    </div>
                    <div className="-mx-4 sm:-mx-8 px-4 sm:px-8 py-4 ">
                        <div className="inline-block min-w-full shadow rounded-lg overflow-hidden">
                            <table className="min-w-full leading-normal">
                                <thead>
                                <tr>
                                    <th scope="col"
                                        className="px-5 py-3 bg-white  border-b border-gray-200 text-gray-800  text-left text-sm uppercase font-normal">
                                        Id
                                    </th>
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
                                    <th scope="col"
                                        className="px-5 py-3 bg-white  border-b border-gray-200 text-gray-800  text-left text-sm uppercase font-normal">
                                        Assigned Operator
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                {tickets.map((ticket) =>
                                    <tr>
                                        <td className="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                                            <div className="flex items-center">

                                                <div className="ml-3">
                                                    <p className="text-gray-900 whitespace-no-wrap">
                                                        {ticket.id}
                                                    </p>
                                                </div>
                                            </div>
                                        </td>
                                        <td className="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                                            <div className="flex items-center">

                                                <div className="ml-3">
                                                    <p className="text-gray-900 whitespace-no-wrap">
                                                        {ticket.name}
                                                    </p>
                                                </div>
                                            </div>
                                        </td>
                                        <td className="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                                            <p className="text-gray-900 whitespace-no-wrap">
                                                {ticket.description}
                                            </p>
                                        </td>
                                        <td className="px-5 py-5 border-b border-gray-200 bg-white text-sm">
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
                                        <td className="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                                            <p className="text-gray-900 whitespace-no-wrap">
                                                {ticket.operatorContractId}
                                            </p>
                                        </td>
                                        {/*<td className="px-5 py-5 border-b border-gray-200 bg-white text-sm">*/}
                                        {/*    <a href="#" className="text-indigo-600 hover:text-indigo-900">*/}
                                        {/*        Edit*/}
                                        {/*    </a>*/}
                                        {/*</td>*/}
                                    </tr>
                                )}
                                </tbody>
                            </table>

                        </div>
                    </div>
                </div>
            </div>

            <div className="container mx-auto px-2 sm:px-8 max-w-3xl">
                <div className="py-8">
                    <div className="flex flex-row mb-1 sm:mb-0 justify-between w-full">
                        <h2 className="text-2xl leading-tight">
                            Operators
                        </h2>

                    </div>
                    <div className="-mx-4 sm:-mx-8 px-4 sm:px-8 py-4 ">
                        <div className="inline-block min-w-full shadow rounded-lg overflow-hidden">
                            <table className="min-w-full leading-normal">
                                <thead>
                                <tr>
                                    <th scope="col"
                                        className="px-5 py-3 bg-white  border-b border-gray-200 text-gray-800  text-left text-sm uppercase font-normal">
                                        Id
                                    </th>
                                    <th scope="col"
                                        className="px-5 py-3 bg-white  border-b border-gray-200 text-gray-800  text-left text-sm uppercase font-normal">
                                        First Name
                                    </th>
                                    <th scope="col"
                                        className="px-5 py-3 bg-white  border-b border-gray-200 text-gray-800  text-left text-sm uppercase font-normal">
                                        Last Name
                                    </th>
                                    <th scope="col"
                                        className="px-5 py-3 bg-white  border-b border-gray-200 text-gray-800  text-left text-sm uppercase font-normal">
                                        Phone Number
                                    </th>
                                    <th scope="col"
                                        className="px-5 py-3 bg-white  border-b border-gray-200 text-gray-800  text-left text-sm uppercase font-normal">
                                        Email
                                    </th>
                                    <th scope="col"
                                        className="px-5 py-3 bg-white  border-b border-gray-200 text-gray-800  text-left text-sm uppercase font-normal">
                                        Contract Id
                                    </th>
                                    <th scope="col"
                                        className="px-5 py-3 bg-white  border-b border-gray-200 text-gray-800  text-left text-sm uppercase font-normal">
                                        Assigned Tickets
                                    </th>

                                </tr>
                                </thead>
                                <tbody>
                                {operators.map((operator) =>
                                    <tr>
                                        <td className="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                                            <div className="flex items-center">

                                                <div className="ml-3">
                                                    <p className="text-gray-900 whitespace-no-wrap">
                                                        {operator.id}
                                                    </p>
                                                </div>
                                            </div>
                                        </td>
                                        <td className="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                                            <div className="flex items-center">

                                                <div className="ml-3">
                                                    <p className="text-gray-900 whitespace-no-wrap">
                                                        {operator.firstName}
                                                    </p>
                                                </div>
                                            </div>
                                        </td>
                                        <td className="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                                            <p className="text-gray-900 whitespace-no-wrap">
                                                {operator.lastName}
                                            </p>
                                        </td>
                                        <td className="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                                            <p className="text-gray-900 whitespace-no-wrap">
                                                {operator.phonenumber}
                                            </p>
                                        </td>
                                        <td className="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                                            <p className="text-gray-900 whitespace-no-wrap">
                                                {operator.email}
                                            </p>
                                        </td>
                                        <td className="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                                            <p className="text-gray-900 whitespace-no-wrap">
                                                {operator.contractID}
                                            </p>
                                        </td>
                                        {operator.assignedTickets.length <= 5 ?
                                            <>
                                                <td className="px-5 py-5 border-b border-gray-200 bg-white text-sm">

                                    <span
                                        className="relative inline-block px-3 py-1 font-semibold text-green-900 leading-tight">
                                        <span aria-hidden="true"
                                              className="absolute inset-0 bg-green-200 opacity-50 rounded-full">
                                        </span>
                                        <span className="relative">
                                            {operator.assignedTickets.length}
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
                                            {operator.assignedTickets.length}
                                        </span>
                                    </span>
                                                </td>
                                            </>
                                        }


                                        {/*<td className="px-5 py-5 border-b border-gray-200 bg-white text-sm">*/}
                                        {/*    <a href="#" className="text-indigo-600 hover:text-indigo-900">*/}
                                        {/*        Edit*/}
                                        {/*    </a>*/}
                                        {/*</td>*/}
                                    </tr>
                                )}
                                </tbody>
                            </table>

                        </div>
                    </div>
                </div>
            </div>
            <div>

                <section className="h-screen bg-gray-100 bg-opacity-50">
                    <form className="container max-w-2xl mx-auto shadow-md md:w-3/4"
                          method="POST" onSubmit={onSubmit}>
                        <div
                            className="items-center w-full p-4 space-y-4 text-gray-500 md:inline-flex md:space-y-0">
                            <h2 className="max-w-sm mx-auto md:w-1/3 text-lg">
                                Assign operator
                            </h2>
                            <div className="max-w-sm mx-auto space-y-5 md:w-2/3">

                                <div className=" relative ">
                                    <input type="text" id="user-info-first-name"
                                           className=" rounded-lg border-transparent flex-1 appearance-none border border-gray-300 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent"
                                           placeholder="Enter a ticket Id"
                                           name="ticketId"/>
                                </div>

                                <div className=" relative ">
                                    <input type="text" id="user-info-last-name"
                                           className=" rounded-lg border-transparent flex-1 appearance-none border border-gray-300 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent"
                                           placeholder="Enter an operator contract Id"
                                           name="operatorContractId"/>
                                </div>
                                <div className="max-w-sm mx-auto md:w-1/4">
                                    <button type="submit"
                                            className="py-2 px-4  bg-blue-600 hover:bg-blue-700 focus:ring-blue-500 focus:ring-offset-blue-200 text-white w-full transition ease-in duration-200 text-center text-base font-semibold shadow-md focus:outline-none focus:ring-2 focus:ring-offset-2  rounded-lg ">
                                        Submit
                                    </button>
                                </div>

                            </div>
                        </div>
                    </form>
                </section>
            </div>
        </div>




    )
}