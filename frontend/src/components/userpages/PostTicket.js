import '../../App.css';
import React, {useEffect, useState} from "react";
import {useNavigate} from "react-router-dom";
import {toast, ToastContainer} from "react-toastify";


export default function PostTicket() {

    let navigate = useNavigate();
    const [userDetails, allUserDetails] = useState([]);

    useEffect(() => {
        fetch(`http://localhost:8080/get-user-details?userId=${localStorage.getItem("userID")}`,
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
                allUserDetails(response)
            })
    }, []);

    const onSubmit = (e) => {
        e.preventDefault();
        const formData = new FormData(e.target);
        if (formData.get('type') !== ""
            && formData.get('name') !== ""
            && formData.get('description') !== ""
            && formData.get('propertyId') !== ""
            && formData.get('userEmail') !== ""
            && formData.get('userPhonenumber') !== "") {
            fetch(`http://localhost:8080/tickets/new?userId=${localStorage.getItem("userID")}`, {
                method: "POST",
                headers: {
                    // Accept: "application/json",
                    "Authorization": "Bearer " + localStorage.getItem("token"),
                    "Content-type": "application/json",
                },
                body: JSON.stringify({
                    type: formData.get('type'),
                    name: formData.get('name'),
                    description: formData.get('description'),
                    propertyId: formData.get('propertyId'),
                    userEmail: formData.get('userEmail'),
                    userPhonenumber: formData.get('userPhonenumber'),
                }),
            })
                .then((response) => response.json())
                .catch(function () {
                })
                .then(() => {
                    navigate('/tickets/show')
                })
        } else {
            toast.error('Please fill in all the fields !', {
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
            <section className="h-screen bg-gray-100 bg-opacity-50">
                <form className="container max-w-2xl mx-auto shadow-md md:w-3/4"
                      method="POST" onSubmit={onSubmit}>
                    <div className="space-y-6 bg-white">
                        <div
                            className="items-center w-full p-4 space-y-4 text-gray-500 md:inline-flex md:space-y-0">
                            <h2 className="max-w-sm mx-auto md:w-1/3 text-lg">
                                Property ids
                            </h2>
                            <div className="max-w-sm mx-auto space-y-5 md:w-2/3">
                                <div className=" relative ">
                                    {userDetails[2]}
                                </div>
                            </div>
                        </div>
                        <div
                            className="items-center w-full p-4 space-y-4 text-gray-500 md:inline-flex md:space-y-0">
                            <h2 className="max-w-sm mx-auto md:w-1/3 text-lg">
                                Ticket type
                            </h2>
                            <div className="max-w-sm mx-auto md:w-2/3">
                                <div className=" relative ">
                                    <input type="text" id="user-info-email"
                                           className=" rounded-lg border-transparent flex-1 appearance-none border border-gray-300 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent"
                                           placeholder="water/electricity/waste"
                                           name="type"/>
                                </div>
                            </div>
                        </div>
                        <hr/>
                        <div
                            className="items-center w-full p-4 space-y-4 text-gray-500 md:inline-flex md:space-y-0">
                            <h2 className="max-w-sm mx-auto md:w-1/3 text-lg">
                                Problem description
                            </h2>
                            <div className="max-w-sm mx-auto space-y-5 md:w-2/3">

                                <div className=" relative ">
                                    <input type="text" id="user-info-first-name"
                                           className=" rounded-lg border-transparent flex-1 appearance-none border border-gray-300 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent"
                                           placeholder="Enter a ticket name"
                                           name="name"/>
                                </div>
                                <div className=" relative ">
                                    <input type="text" id="user-info-last-name"
                                           className=" rounded-lg border-transparent flex-1 appearance-none border border-gray-300 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent"
                                           placeholder="Enter a problem description"
                                           name="description"/>
                                </div>
                                <div>
                                    <div className=" relative ">
                                        <input type="text" id="user-info-phone"
                                               className=" rounded-lg border-transparent flex-1 appearance-none border border-gray-300 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent"
                                               placeholder="Enter the property id"
                                               name="propertyId"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <hr/>
                        <div
                            className="items-center w-full p-8 space-y-4 text-gray-500 md:inline-flex md:space-y-0">
                            <h2 className="max-w-sm mx-auto md:w-4/12 text-lg">
                                User contact details
                            </h2>
                            <div
                                className="w-full max-w-sm pl-2 mx-auto space-y-5 md:w-5/12 md:pl-9 md:inline-flex">
                                <div className=" relative ">
                                    <input type="text" id="user-info-password"
                                           className=" rounded-lg border-transparent flex-1 appearance-none border border-gray-300 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent"
                                           placeholder={localStorage.getItem("email")}
                                           name="userEmail"/>
                                </div>
                            </div>
                            <div
                                className="w-full max-w-sm pl-2 mx-auto space-y-5 md:w-5/12 md:pl-9 md:inline-flex">
                                <div className=" relative ">
                                    <input type="text" id="user-info-password"
                                           className=" rounded-lg border-transparent flex-1 appearance-none border border-gray-300 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent"
                                           placeholder="Phone number"
                                           name="userPhoneNumber"/>
                                </div>
                            </div>
                        </div>
                        <div
                            className="items-center w-full p-4 space-y-4 text-gray-500 md:inline-flex md:space-y-0">
                            <div className="max-w-sm mx-auto md:w-1/4">
                                <button
                                    className="py-2 px-4  bg-red-600 hover:bg-pink-700 focus:ring-pink-500 focus:ring-offset-pink-200 text-white w-full transition ease-in duration-200 text-center text-base font-semibold shadow-md focus:outline-none focus:ring-2 focus:ring-offset-2  rounded-lg "
                                    onClick={() => navigate("/user-dashboard")}>
                                    Back
                                </button>
                            </div>
                            <div className="max-w-sm mx-auto md:w-1/4">
                                <button type="submit"
                                        className="py-2 px-4  bg-blue-600 hover:bg-blue-700 focus:ring-blue-500 focus:ring-offset-blue-200 text-white w-full transition ease-in duration-200 text-center text-base font-semibold shadow-md focus:outline-none focus:ring-2 focus:ring-offset-2  rounded-lg ">
                                    Submit
                                </button>
                            </div>
                        </div>
                        <hr/>
                    </div>
                </form>
            </section>
        </div>
    )
}