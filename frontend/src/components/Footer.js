import '../App.css';
import React from "react";
import {ReactComponent as NePiLogoNew} from "../assets/NePiLogoSmall.svg";

export default function Footer() {
    return (
        <footer className="text-gray-600 body-font bg-gray-100">
            <div
                className="container px-5 py-15 mx-auto flex md:items-center lg:items-start md:flex-row md:flex-nowrap flex-wrap flex-col mt-6">
                <div className="w-64 flex-shrink-0 text-center md:text-left mt-4 ml-32">
                    <a className="flex title-font font-medium items-center md:justify-start justify-center text-gray-900">
                        <NePiLogoNew/>
                        <span className="ml-3 text-xl">NePi</span>
                    </a>
                    <p className="mt-2 text-sm text-gray-500">Made by Laura Alexandra Popa
                    @Codecool </p>
                </div>
                <div className="flex-grow flex flex-wrap md:pl-20 -mb-10 md:mt-0 mt-10 md:text-left text-center justify-around" >
                    <div className="lg:w-1/4 md:w-1/2 w-full px-4">
                        <h2 className="title-font font-medium text-gray-900 tracking-widest text-sm mb-3">Info</h2>
                        <nav className="list-none mb-10">
                            <li>
                                <a className="text-gray-600 hover:text-green-300">Frequently Asked Questions</a>
                            </li>
                            <li>
                                <a className="text-gray-600 hover:text-green-300">How to Use the NePi Platform</a>
                            </li>
                            <li>
                                <a className="text-gray-600 hover:text-green-300">Terms of Use</a>
                            </li>
                            <li>
                                <a className="text-gray-600 hover:text-green-300">How to Enroll your Property in NePi</a>
                            </li>
                        </nav>
                    </div>
                    <div className="lg:w-1/4 md:w-1/2 w-full px-4">
                        <h2 className="title-font font-medium text-gray-900 tracking-widest text-sm mb-3">Troubleshooting</h2>
                        <nav className="list-none mb-10">
                            <li>
                                <a className="text-gray-600 hover:text-green-300">Account Issues</a>
                            </li>
                            <li>
                                <a className="text-gray-600 hover:text-green-300">Ticketing System</a>
                            </li>
                            <li>
                                <a className="text-gray-600 hover:text-green-300">Legal</a>
                            </li>
                            <li>
                                <a className="text-gray-600 hover:text-green-300">Other</a>
                            </li>
                        </nav>
                    </div>
                </div>
            </div>
        </footer>
    )
}