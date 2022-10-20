import '../App.css';
import {CommunityBlobLoginModal} from "./logins/CommunityBlobLoginModal";
import React from "react";
import {UtilitiesBlobLoginModal} from "./logins/UtilitiesBlobLoginModal";
import {useNavigate} from "react-router-dom";

export default function LandingPage() {
    let navigate = useNavigate();
    return (
        <div>
            <section className="text-gray-600 body-font">
                <div className="container px-5 py-24 mx-auto">
                    <div className="flex flex-wrap -mx-4 -mb-10 text-center">
                        <div className="sm:w-1/2 mb-10 px-4">
                            <div className="rounded-lg h-fit overflow-hidden">
                                <h2 className="title-font text-2xl font-medium text-gray-900 mt-6 mb-3">I live / own
                                    property here</h2>
                                <CommunityBlobLoginModal/>
                            </div>
                            <button type="button"
                                    className="text-white bg-green-500 hover:bg-green-800 focus:ring-4 focus:outline-none focus:ring-green-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center inline-flex items-center mr-2 dark:bg-green-600 dark:hover:bg-green-700 dark:focus:ring-green-800">
                                <svg aria-hidden="true" className="mr-2 -ml-1 w-5 h-5" fill="currentColor"
                                     viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
                                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
                                         stroke-width="1.5" stroke="currentColor" className="w-6 h-6">
                                        <path stroke-linecap="round" stroke-linejoin="round"
                                              d="M3 16.5v2.25A2.25 2.25 0 005.25 21h13.5A2.25 2.25 0 0021 18.75V16.5m-13.5-9L12 3m0 0l4.5 4.5M12 3v13.5"/>
                                    </svg>
                                </svg>
                                General Users Login
                            </button>
                            <div className="container px-5 py-24 mx-auto">
                                <button
                                    className="rounded-lg h-20 overflow-hidden bg-green-500 text-white active:bg-green-700 font-bold uppercase text-sm px-6 py-3 rounded shadow hover:bg-green-600 outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150"
                                    type="button"
                                    onClick={() => navigate("/community-register")}
                                >Register
                                </button>
                            </div>
                        </div>
                        <div className="sm:w-1/2 mb-10 px-4">
                            <div className="rounded-lg h-fit overflow-hidden">
                                <h2 className="title-font text-2xl font-medium text-gray-900 mt-6 mb-3">I am an operator</h2>
                                <UtilitiesBlobLoginModal/>
                            </div>
                            <button type="button"
                                    className="text-white bg-green-500 hover:bg-green-800 focus:ring-4 focus:outline-none focus:ring-green-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center inline-flex items-center mr-2 dark:bg-green-600 dark:hover:bg-green-700 dark:focus:ring-green-800">
                                <svg aria-hidden="true" className="mr-2 -ml-1 w-5 h-5" fill="currentColor"
                                     viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
                                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
                                         stroke-width="1.5" stroke="currentColor" className="w-6 h-6">
                                        <path stroke-linecap="round" stroke-linejoin="round"
                                              d="M3 16.5v2.25A2.25 2.25 0 005.25 21h13.5A2.25 2.25 0 0021 18.75V16.5m-13.5-9L12 3m0 0l4.5 4.5M12 3v13.5"/>
                                    </svg>
                                </svg>
                                Operative Users Login
                            </button>
                            <div className="container px-5 py-24 mx-auto">
                                <button
                                    className="rounded-lg h-20 overflow-hidden bg-green-500 text-white active:bg-green-700 font-bold uppercase text-sm px-6 py-3 rounded shadow hover:bg-green-600 outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150"
                                    id="utilitiesButtonRegister"
                                    onClick={() => navigate("/registration/utilities")}>Register
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    )
}