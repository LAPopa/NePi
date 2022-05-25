import React, {useEffect, useState} from "react";
import '../../App.css';

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
        }


    }


    return (
        <div className="container mx-auto px-4 sm:px-8 max-w-3xl">
            <p>TICKETS</p><br/>
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
                </tr>
                </thead>
                <tbody>
                {tickets.map((ticket) =>
                    <tr>
                        <td className="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                            <div className="flex items-center">
                                <div>
                                    <p className="text-gray-900 whitespace-no-wrap">
                                        {ticket.id}
                                    </p>
                                </div>
                            </div>
                        </td>
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
            <p>OPERATORS</p><br/>
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
                                <div>
                                    <p className="text-gray-900 whitespace-no-wrap">
                                        {operator.id}
                                    </p>
                                </div>
                            </div>
                        </td>
                        <td className="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                            <div className="flex items-center">
                                <div>
                                    <p className="text-gray-900 whitespace-no-wrap">
                                        {operator.firstName}
                                    </p>
                                </div>
                            </div>
                        </td>
                        <td className="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                            <div className="flex items-center">
                                <div>
                                    <p className="text-gray-900 whitespace-no-wrap">
                                        {operator.lastName}
                                    </p>
                                </div>
                            </div>
                        </td>
                        <td className="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                            <div className="flex items-center">
                                <div>
                                    <p className="text-gray-900 whitespace-no-wrap">
                                        {operator.phoneNumber}
                                    </p>
                                </div>
                            </div>
                        </td>
                        <td className="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                            <div className="flex items-center">
                                <div>
                                    <p className="text-gray-900 whitespace-no-wrap">
                                        {operator.email}
                                    </p>
                                </div>
                            </div>
                        </td>
                        <td className="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                            <div className="flex items-center">
                                <div>
                                    <p className="text-gray-900 whitespace-no-wrap">
                                        {operator.contractID}
                                    </p>
                                </div>
                            </div>
                        </td>
                        <td className="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                            <div className="flex items-center">
                                <div>
                                    <p className="text-gray-900 whitespace-no-wrap">
                                        {operator.assignedTickets.length}
                                    </p>
                                </div>
                            </div>
                        </td>


                    </tr>
                )}
                </tbody>
            </table>
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