import '../App.css';
import NePiLogo from '../assets/NePiplaceholder.png';
import React from "react";
import {ReactComponent as NePiLogoNew} from "../assets/NePiLogoSmall.svg";


export default function Footer() {
    return (
        // <footer className="text-gray-600 body-font h-3 pt-10 px-1.5 bg-gray-100">
        <footer className="text-gray-600 body-font">
            <div
                // className="container px-5 py-20 mx-auto flex md:items-center lg:items-start md:flex-row md:flex-nowrap flex-wrap flex-col bg-gray-100">
                className="container px-5 py-24 mx-auto flex md:items-center lg:items-start md:flex-row md:flex-nowrap flex-wrap flex-col">
                <div className="w-64 flex-shrink-0 md:mx-0 mx-auto text-center md:text-left">

                    <a className="flex title-font font-medium items-center md:justify-start justify-center text-gray-900">

                        {/*<img src={NePiLogo} height="50" width="50"/>*/}
                        <NePiLogoNew/>

                        <span className="ml-3 text-xl">NePi</span>


                    </a>
                    <p className="mt-2 text-sm text-gray-500">Made by Laura Alexandra Popa
                    @Codecool </p>
                </div>
                <div className="flex-grow flex flex-wrap md:pl-20 -mb-10 md:mt-0 mt-10 md:text-left text-center">
                    <div className="lg:w-1/4 md:w-1/2 w-full px-4">
                        <h2 className="title-font font-medium text-gray-900 tracking-widest text-sm mb-3">Info</h2>
                        <nav className="list-none mb-10">
                            <li>
                                <a className="text-gray-600 hover:text-gray-800">First Link</a>
                            </li>
                            <li>
                                <a className="text-gray-600 hover:text-gray-800">Second Link</a>
                            </li>
                            <li>
                                <a className="text-gray-600 hover:text-gray-800">Third Link</a>
                            </li>
                            <li>
                                <a className="text-gray-600 hover:text-gray-800">Fourth Link</a>
                            </li>
                        </nav>
                    </div>

                    <div className="lg:w-1/4 md:w-1/2 w-full px-4">
                        <h2 className="title-font font-medium text-gray-900 tracking-widest text-sm mb-3">Troubleshooting</h2>
                        <nav className="list-none mb-10">
                            <li>
                                <a className="text-gray-600 hover:text-gray-800">First Link</a>
                            </li>
                            <li>
                                <a className="text-gray-600 hover:text-gray-800">Second Link</a>
                            </li>
                            <li>
                                <a className="text-gray-600 hover:text-gray-800">Third Link</a>
                            </li>
                            <li>
                                <a className="text-gray-600 hover:text-gray-800">Fourth Link</a>
                            </li>
                        </nav>
                    </div>
                </div>
            </div>
        </footer>
    )
}