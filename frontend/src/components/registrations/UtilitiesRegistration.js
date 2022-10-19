import '../../App.css';
import ProfilePic from '../../assets/profilePic.png';
import React, {useEffect, useState} from "react";
import {useNavigate} from "react-router-dom";
import {toast} from "react-toastify";
import {validateEmail} from "./EmailFormatValidator";


export function UtilitiesRegistration() {
    let navigate = useNavigate();
    const UTILITIES_REGISTRATION_URL = 'http://localhost:8080/registration/utilities';
    const [allocatedCompanyIds, allAllocatedCompanyIds] = useState([]);
    useEffect(() => {

        fetch(`http://localhost:8080/registration/check-companyAllocatedIds`,
            {
                method: "GET",
                headers: {
                    "Content-Type": "application/json"
                }
            }
        )
            .then(response => response.json())
            .then((response) => {
                allAllocatedCompanyIds(response)
            })
    }, [])
    const onSubmit = (e) => {
        e.preventDefault();
        const formData = new FormData(e.target);
        if (formData.get('email') !== "" &&
            formData.get('password') !== "" &&
            formData.get('firstName') !== "" &&
            formData.get('lastName') !== "" &&
            formData.get('phonenumber') !== "" &&
            formData.get('contractId') !== "" &&
            formData.get('companyName') !== "") {
            if (formData.get('password') !== formData.get('confirmpassword')) {
                toast.error('Passwords do not match !', {
                    position: "top-center",
                    autoClose: false,
                    hideProgressBar: false,
                    closeOnClick: true,
                    pauseOnHover: true,
                    draggable: true,
                    progress: undefined,
                });
            } else if (!validateEmail(formData.get('email'))) {
                toast.error('Please provide a valid email !', {
                    position: "top-center",
                    autoClose: false,
                    hideProgressBar: false,
                    closeOnClick: true,
                    pauseOnHover: true,
                    draggable: true,
                    progress: undefined,
                });
            } else if (!allocatedCompanyIds.includes(formData.get('contractId'))) {
                toast.error('The contract Id was not found !', {
                    position: "top-center",
                    autoClose: false,
                    hideProgressBar: false,
                    closeOnClick: true,
                    pauseOnHover: true,
                    draggable: true,
                    progress: undefined,
                });
            } else {
                fetch(UTILITIES_REGISTRATION_URL, {
                    method: "POST",
                    headers: {
                        // Accept: "application/json",
                        "Content-type": "application/json",
                    },
                    body: JSON.stringify({
                        email: formData.get('email'),
                        password: formData.get('password'),
                        firstName: formData.get('firstName'),
                        lastName: formData.get('lastName'),
                        phonenumber: formData.get('phonenumber'),
                        contractId: formData.get('contractId'),
                        companyName: formData.get('companyName'),
                    }),
                })
                    .then((response) => response.json())
                    .catch(function () {
                    })
                    .then(() => {
                        toast.success('Account created successfully !', {
                            position: "top-center",
                            autoClose: false,
                            hideProgressBar: false,
                            closeOnClick: true,
                            pauseOnHover: true,
                            draggable: true,
                            progress: undefined,
                        });
                        navigate('/')
                    })
            }
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
                      method="POST" onSubmit={onSubmit} action="/registration/utilities">
                    <div className="space-y-6 bg-white">
                        <div className="items-center w-full p-4 space-y-4 text-gray-500 md:inline-flex md:space-y-0">
                            <h2 className="max-w-sm mx-auto md:w-1/3 text-lg">
                                Enter your email
                            </h2>
                            <div className="max-w-sm mx-auto md:w-2/3">
                                <div className=" relative ">
                                    <input type="text" id="user-utilities-info-email"
                                           className=" rounded-lg border-transparent flex-1 appearance-none border border-violet-700 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent"
                                           placeholder="Email"
                                           name="email"/>
                                </div>
                            </div>
                        </div>
                        <hr/>
                        <div className="items-center w-full p-4 space-y-4 text-gray-500 md:inline-flex md:space-y-0">
                            <h2 className="max-w-sm mx-auto md:w-1/3 text-lg">
                                Personal info
                            </h2>
                            <div className="max-w-sm mx-auto space-y-5 md:w-2/3">
                                <div>
                                    <div className=" relative ">
                                        <input type="text" id="user-utilities-info-first-name"
                                               className=" rounded-lg border-transparent flex-1 appearance-none border border-violet-700 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent"
                                               placeholder="First Name"
                                               name="firstName"/>
                                    </div>
                                    <div className=" relative ">
                                        <input type="text" id="user-utilities-info-last-name"
                                               className=" rounded-lg border-transparent flex-1 appearance-none border border-violet-700 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent"
                                               placeholder="Last Name"
                                               name="lastName"/>
                                    </div>
                                </div>
                                <div>
                                    <div className=" relative ">
                                        <input type="text" id="user-utilities-info-phone"
                                               className=" rounded-lg border-transparent flex-1 appearance-none border border-violet-700 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent"
                                               placeholder="Phone number"
                                               name="phonenumber"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="items-center w-full p-4 space-y-4 text-gray-500 md:inline-flex md:space-y-0">
                            <div className="h-full">
                                <h2 className="max-w-sm mx-auto md:w-1/3 text-lg">
                                    Company Name
                                </h2>
                            </div>

                            <div className="max-w-sm mx-auto space-y-5 md:w-2/3">
                                <div>
                                    <div className=" relative ">
                                        <input type="text" id="user-utilities-info-company-name"
                                               className=" rounded-lg border-transparent flex-1 appearance-none border border-violet-700 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent"
                                               placeholder="Company Name"
                                               name="companyName"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="items-center w-full p-4 space-y-4 text-gray-500 md:inline-flex md:space-y-0">
                            <div className="h-full">
                                <h2 className="max-w-sm mx-auto md:w-1/3 text-lg">
                                    Professional Contract ID
                                </h2>
                                <h3 className="text-sm">Please enter the company ID provided in the company
                                    contract.</h3>
                            </div>
                            <div className="max-w-sm mx-auto space-y-5 md:w-2/3">
                                <div>
                                    <div className=" relative ">
                                        <input type="text" id="user-utilities-company-ID"
                                               className=" rounded-lg border-transparent flex-1 appearance-none border border-violet-700 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent"
                                               placeholder="ID"
                                               name="contractId"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <hr/>
                        <div className="items-center w-full p-8 space-y-4 text-gray-500 md:inline-flex md:space-y-0">
                            <h2 className="max-w-sm mx-auto md:w-4/12 text-lg">
                                Create password
                            </h2>
                            <div className="w-full max-w-sm pl-2 mx-auto space-y-5 md:w-5/12 md:pl-9 md:inline-flex">
                                <div className=" relative ">
                                    <input type="text" id="user-info-password"
                                           className=" rounded-lg border-transparent flex-1 appearance-none border border-violet-700 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent"
                                           placeholder="Password"
                                           name="password"/>
                                </div>
                            </div>
                            <div className="w-full max-w-sm pl-2 mx-auto space-y-5 md:w-5/12 md:pl-9 md:inline-flex">
                                <div className=" relative ">
                                    <input type="text" id="user-info-password"
                                           className=" rounded-lg border-transparent flex-1 appearance-none border border-violet-700 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent"
                                           placeholder="Password"
                                           name="confirmpassword"/>
                                </div>
                            </div>
                        </div>
                        <div className="items-center w-full p-4 space-y-4 text-gray-500 md:inline-flex md:space-y-0">
                            <div className="max-w-sm mx-auto md:w-1/4">
                                <button
                                    className="py-2 px-4  bg-red-600 hover:bg-pink-700 focus:ring-pink-500 focus:ring-offset-pink-200 text-white w-full transition ease-in duration-200 text-center text-base font-semibold shadow-md focus:outline-none focus:ring-2 focus:ring-offset-2  rounded-lg "
                                    onClick={() => navigate("/")}>
                                    Back
                                </button>
                            </div>
                            <div className="max-w-sm mx-auto md:w-1/4">
                                <button type="submit"
                                        className="py-2 px-4  bg-green-600 hover:bg-green-700 focus:ring-green-500 focus:ring-offset-green-200 text-white w-full transition ease-in duration-200 text-center text-base font-semibold shadow-md focus:outline-none focus:ring-2 focus:ring-offset-2  rounded-lg ">
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