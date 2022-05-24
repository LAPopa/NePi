import '../App.css';
import NePiLogo from '../assets/NePiplaceholder.png';
import React from "react";
import {ReactComponent as NePiLogoNew} from "../assets/NePiLogo1.svg";
import {LoginModal} from "../components/logins/LoginModal";
import {useNavigate} from "react-router-dom";


export default function Header() {
    let navigate = useNavigate();
    const handleLogout = () => {
        localStorage.removeItem("userID")
        localStorage.removeItem("firstName")
        localStorage.removeItem("lastName")
        localStorage.removeItem("email")
        localStorage.removeItem("roles")
        localStorage.removeItem("token")
        localStorage.removeItem("role")
        localStorage.removeItem("username")
        localStorage.removeItem("userId")
        navigate('/')
        window.location.reload()
    }


    return (
        <header className="text-gray-600 body-font bg-gray-100">
            <div className="container py-15 mx-auto flex flex-wrap p-5 flex-col md:flex-row items-center ">
                <a className="flex title-font font-medium items-center text-gray-900 mb-4 md:mb-0" href="/">

                    {/*<img src={NePiLogo} height="100" width="100"/>*/}
                    <NePiLogoNew/>
                    <span className="ml-3 text-xl">NePi</span>
                </a>
                <nav className="md:ml-auto flex flex-wrap items-center text-base justify-center">
                    {/*<a className="mr-5 hover:text-gray-900">First Link</a>*/}
                    {/*<a className="mr-5 hover:text-gray-900">Second Link</a>*/}
                    {/*<a className="mr-5 hover:text-gray-900">Third Link</a>*/}
                    {/*<a className="mr-5 hover:text-gray-900">Fourth Link</a>*/}
                </nav>
                {!localStorage.getItem("email") ?
                    <>
                        <a
                            // className="inline-flex items-center bg-gray-100 border-0 py-1 px-3 focus:outline-none hover:bg-gray-200 rounded text-base mt-4 md:mt-0"><LoginModal/>
                            className="inline-flex items-center bg-gray-100 border-0 py-1 px-3 focus:outline-none hover:bg-gray-200 rounded text-base mt-4 md:mt-0">Log In below !

                        </a>
                    </>
                    :
                    <>
                        <p className="mr-5 hover:text-gray-900">Welcome,  {localStorage.getItem("firstName")}</p>
                        <button
                            className="inline-flex items-center bg-gray-100 border-0 py-1 px-3 focus:outline-none hover:bg-gray-200 rounded text-base mt-4 md:mt-0"
                            onClick={handleLogout}>
                            Logout
                        </button>
                    </>
                }
            </div>
        </header>
    )
}