import '../App.css';
import {CommunityBlobLoginModal} from "./CommunityBlobLoginModal";
import React from "react";
import {UtilitiesBlobLoginModal} from "./UtilitiesBlobLoginModal";
import {CommunityRegistrationSelector} from "./CommunityRegistrationSelector";

export default function LandingPage() {
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
                            <p className="leading-relaxed text-base">some amazing placeholder text</p>
                            <div className="container px-5 py-24 mx-auto">
                                {/*<button*/}
                                {/*    className="flex mx-auto mt-6 text-white bg-green-500 font-bold uppercase border-0 py-2 px-5 focus:outline-none hover:bg-green-600 rounded"*/}
                                {/*    id="communityButtonRegister"*/}
                                {/*    onClick={() => document.getElementById("communityButtonRegister").textContent = "Button was clicked"}>Register*/}
                                {/*</button>*/}
                                <CommunityRegistrationSelector/>

                            </div>
                        </div>
                        <div className="sm:w-1/2 mb-10 px-4">
                            <div className="rounded-lg h-fit overflow-hidden">
                                <h2 className="title-font text-2xl font-medium text-gray-900 mt-6 mb-3">I ensure things
                                    run smoothly for the community</h2>
                                <UtilitiesBlobLoginModal/>

                            </div>
                            <p className="leading-relaxed text-base">another amazing placeholder text.</p>
                            <div className="container px-5 py-24 mx-auto">
                                <button
                                    className="flex mx-auto mt-6 text-white bg-green-500 font-bold uppercase border-0 py-2 px-5 focus:outline-none hover:bg-green-600 rounded"
                                    id="utilitiesButtonRegister"
                                    onClick={() => document.getElementById("utilitiesButtonRegister").textContent = "Button was clicked"}>Register
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    )
}