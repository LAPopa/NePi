import '../App.css';
import CommunityBlob from '../assets/communityRoutes.png';
import UtilitiesBlob from '../assets/utilitiesBlob.png';
import {CommunityLoginModal} from "./CommunityLoginModal";
import React from "react";

export default function LandingPage() {
    const [showModal, setShowModal] = React.useState(false);
    return (
        <div>
            <section className="text-gray-600 body-font">
                <div className="container px-5 py-24 mx-auto">
                    <div className="flex flex-wrap -mx-4 -mb-10 text-center">
                        <div className="sm:w-1/2 mb-10 px-4">
                            <div className="rounded-lg h-64 overflow-hidden">
                                <h2 className="title-font text-2xl font-medium text-gray-900 mt-6 mb-3">I live / own property here</h2>
                                <img alt="content" className="object-fill object-center h-full w-full"
                                     src={CommunityBlob}/>
                            </div>
                            <p className="leading-relaxed text-base">some amazing placeholder text</p>
                            <button
                                type="button"
                                className="flex mx-auto mt-6 text-white bg-green-500 font-bold uppercase border-0 py-2 px-5 focus:outline-none hover:bg-green-600 rounded"
                                id="communityButtonRegister"
                                onClick={() => document.getElementById("communityButtonRegister").textContent = "Button was clicked"}>Register
                            </button>
                            <br/>

                            <CommunityLoginModal/>
                        </div>
                        <div className="sm:w-1/2 mb-10 px-4">
                            <div className="rounded-lg h-64 overflow-hidden">
                                <h2 className="title-font text-2xl font-medium text-gray-900 mt-6 mb-3">I ensure things run smoothly for the community</h2>
                                <img alt="content" className="object-fill object-center h-full w-full"
                                     src={UtilitiesBlob}/>
                            </div>
                            <p className="leading-relaxed text-base">another amazing placeholder text.</p>
                            <div className="container px-5 py-24 mx-auto">
                                <button
                                    className="flex mx-auto mt-6 text-white bg-green-500 border-0 py-2 px-5 focus:outline-none hover:bg-green-600 rounded"
                                    id="utilitiesButtonRegister"
                                    onClick={() => document.getElementById("utilitiesButtonRegister").textContent = "Button was clicked"}>Register
                                </button>
                                <button
                                    className="flex mx-auto mt-6 text-white bg-green-500 border-0 py-2 px-5 focus:outline-none hover:bg-green-600 rounded"
                                    id="utilitiesButtonLogin"
                                    onClick={() => document.getElementById("utilitiesButtonLogin").textContent = "Button was clicked"}>Login
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    )
}