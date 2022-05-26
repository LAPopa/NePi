import '../../App.css';
import ProfilePic from '../../assets/profilePic.png';
import React, {useEffect, useState} from "react";
import {useNavigate} from "react-router-dom";
import {toast, ToastContainer} from "react-toastify";


export function OwnerRegistration() {
    let navigate = useNavigate();
    const OWNER_REGISTRATION_URL = 'http://localhost:8080/registration/owners';

    const [enrolledPropertyIds, allEnrolledPropertyIds] = useState([]);

    useEffect(() => {

        fetch(`http://localhost:8080/registration/check-enrolledPropertyIds`,
            {
                method : "GET",
                headers : {
                    "Content-Type": "application/json"
                }
            }
            )
            .then(response => response.json())
            .then((response) => {
                allEnrolledPropertyIds(response)
            })
    },[])


    const onSubmit = (e) => {
        e.preventDefault();
        const formData = new FormData(e.target);

        if (formData.get('email') !== ""
            && formData.get('password') !== ""
            && formData.get('firstName') !== ""
            && formData.get('lastName') !== ""
            && formData.get('phonenumber') !== ""
            && formData.get('streetName') !== ""
            && formData.get('streetNumber') !== ""
            && formData.get('apartment') !== ""
            && formData.get('enrollmentId') !== "") {
            if (formData.get('password') !== formData.get('confirmpassword')) {
                // alert('Passwords do not match !')
                toast.error('Passwords do not match !', {
                    position: "top-center",
                    autoClose: false,
                    hideProgressBar: false,
                    closeOnClick: true,
                    pauseOnHover: true,
                    draggable: true,
                    progress: undefined,
                });
            }else if (!enrolledPropertyIds.includes(formData.get('enrollmentId')) ){
                toast.error('The enrollment Id was not found !', {
                    position: "top-center",
                    autoClose: false,
                    hideProgressBar: false,
                    closeOnClick: true,
                    pauseOnHover: true,
                    draggable: true,
                    progress: undefined,
                });
            }
            else {
                fetch(OWNER_REGISTRATION_URL, {
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
                        streetName: formData.get('streetName'),
                        streetNumber: formData.get('streetNumber'),
                        apartment: formData.get('apartment'),
                        enrollmentId: formData.get('enrollmentId'),

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

            // window.location.reload();

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
            {/*<ToastContainer*/}
            {/*    position="top-center"*/}
            {/*    autoClose={false}*/}
            {/*    newestOnTop={false}*/}
            {/*    closeOnClick*/}
            {/*    rtl={false}*/}
            {/*    pauseOnFocusLoss*/}
            {/*    draggable*/}
            {/*/>*/}
            <section className="h-screen bg-gray-100 bg-opacity-50">
                <form className="container max-w-2xl mx-auto shadow-md md:w-3/4"
                      method="POST" onSubmit={onSubmit} action="/registration/owners">
                    {/*<div className="p-4 bg-gray-100 border-t-2 border-indigo-400 rounded-lg bg-opacity-5">*/}
                    {/*    <div className="max-w-sm mx-auto md:w-full md:mx-0">*/}
                    {/*        <div className="inline-flex items-center space-x-4">*/}
                    {/*            <a href="#" className="block relative">*/}
                    {/*                <img alt="profil" src={ProfilePic}*/}
                    {/*                     className="mx-auto object-cover rounded-full h-16 w-16 "/>*/}
                    {/*            </a>*/}
                    {/*            <h1 className="text-gray-600 text-2xl">*/}
                    {/*                Just_a_Cat*/}
                    {/*            </h1>*/}
                    {/*        </div>*/}
                    {/*    </div>*/}
                    {/*</div>*/}
                    <div className="space-y-6 bg-white">
                        <div
                            className="items-center w-full p-4 space-y-4 text-gray-500 md:inline-flex md:space-y-0">
                            <h2 className="max-w-sm mx-auto md:w-1/3 text-lg">
                                Enter your email
                            </h2>
                            <div className="max-w-sm mx-auto md:w-2/3">
                                <div className=" relative ">
                                    <input type="text" id="user-info-email"
                                           className=" rounded-lg border-transparent flex-1 appearance-none border border-gray-300 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent"
                                           placeholder="Email"
                                           name="email"/>
                                </div>
                            </div>
                        </div>
                        <hr/>
                        <div
                            className="items-center w-full p-4 space-y-4 text-gray-500 md:inline-flex md:space-y-0">
                            <h2 className="max-w-sm mx-auto md:w-1/3 text-lg">
                                Personal info
                            </h2>
                            <div className="max-w-sm mx-auto space-y-5 md:w-2/3">

                                <div className=" relative ">
                                    <input type="text" id="user-info-first-name"
                                           className=" rounded-lg border-transparent flex-1 appearance-none border border-gray-300 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent"
                                           placeholder="First Name"
                                           name="firstName"/>
                                </div>

                                <div className=" relative ">
                                    <input type="text" id="user-info-last-name"
                                           className=" rounded-lg border-transparent flex-1 appearance-none border border-gray-300 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent"
                                           placeholder="Last Name"
                                           name="lastName"/>
                                </div>

                                <div>
                                    <div className=" relative ">
                                        <input type="text" id="user-info-phone"
                                               className=" rounded-lg border-transparent flex-1 appearance-none border border-gray-300 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent"
                                               placeholder="Phone number"
                                               name="phonenumber"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div
                            className="items-center w-full p-4 space-y-4 text-gray-500 md:inline-flex md:space-y-0">
                            <h2 className="max-w-sm mx-auto md:w-1/3 text-lg">
                                Property information
                            </h2>
                            <div className="max-w-sm mx-auto space-y-5 md:w-2/3">
                                <div className=" relative ">
                                    <input type="text" id="user-info-street"
                                           className=" rounded-lg border-transparent flex-1 appearance-none border border-gray-300 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent"
                                           placeholder="Street"
                                           name="streetName"/>
                                </div>
                                <div className=" relative ">
                                    <input type="text" id="user-info-number"
                                           className=" rounded-lg border-transparent flex-1 appearance-none border border-gray-300 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent"
                                           placeholder="Number"
                                           name="streetNumber"/>
                                </div>
                                <div>
                                    <div className=" relative ">
                                        <input type="text" id="user-info-apartment"
                                               className=" rounded-lg border-transparent flex-1 appearance-none border border-gray-300 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent"
                                               placeholder="Apartment"
                                               name="apartment"/>
                                    </div>
                                </div>
                                <div>
                                    <div className=" relative ">
                                        <input type="text" id="user-info-enrollment-id"
                                               className=" rounded-lg border-transparent flex-1 appearance-none border border-gray-300 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent"
                                               placeholder="Enrollment ID"
                                               name="enrollmentId"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <hr/>
                        <div
                            className="items-center w-full p-8 space-y-4 text-gray-500 md:inline-flex md:space-y-0">
                            <h2 className="max-w-sm mx-auto md:w-4/12 text-lg">
                                Create password
                            </h2>
                            <div
                                className="w-full max-w-sm pl-2 mx-auto space-y-5 md:w-5/12 md:pl-9 md:inline-flex">
                                <div className=" relative ">
                                    <input type="text" id="user-info-password"
                                           className=" rounded-lg border-transparent flex-1 appearance-none border border-gray-300 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent"
                                           placeholder="Password"
                                           name="password"/>
                                </div>
                            </div>
                            <div
                                className="w-full max-w-sm pl-2 mx-auto space-y-5 md:w-5/12 md:pl-9 md:inline-flex">
                                <div className=" relative ">
                                    <input type="text" id="user-info-password"
                                           className=" rounded-lg border-transparent flex-1 appearance-none border border-gray-300 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent"
                                           placeholder="Confirm Password"
                                           name="confirmpassword"/>
                                </div>
                            </div>


                        </div>
                        <div
                            className="items-center w-full p-4 space-y-4 text-gray-500 md:inline-flex md:space-y-0">


                            <div className="max-w-sm mx-auto md:w-1/4">
                                <button
                                    className="py-2 px-4  bg-red-600 hover:bg-pink-700 focus:ring-pink-500 focus:ring-offset-pink-200 text-white w-full transition ease-in duration-200 text-center text-base font-semibold shadow-md focus:outline-none focus:ring-2 focus:ring-offset-2  rounded-lg "
                                    onClick={() => navigate("/community-register")}>
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
