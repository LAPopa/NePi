import '../App.css';
import {CommunityBlobLoginModal} from "./CommunityBlobLoginModal";
import React from "react";
import {UtilitiesBlobLoginModal} from "./UtilitiesBlobLoginModal";
import {CommunityRegistrationSelector} from "./CommunityRegistrationSelector";
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
                            <p className="leading-relaxed text-base">&uarr; log in here !</p>
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
                            <p className="leading-relaxed text-base">&uarr; log in here !</p>
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