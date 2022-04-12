import '../App.css';
import React from "react";
import {useNavigate} from "react-router-dom";


export function LoginForm() {
    let navigate = useNavigate();
    const LOGIN_FORM_URL = 'http://localhost:8080/';

    const onSubmit = (e) => {
        e.preventDefault();

        const formData = new FormData(e.target);

        fetch(LOGIN_FORM_URL, {
            method: "POST",
            headers: {
                // Accept: "application/json",
                "Content-type": "application/json",
            },
            body: JSON.stringify({
                email: formData.get('email'),
                password: formData.get('password'),
            }),
        })
            .then((response) => response.json())
            .catch(function (){})
            .then(() => {
                // alert("Success!");
                navigate('/login-successful')
            })
        // window.location.reload();

    }


    return (
        <div className="block p-6 rounded-lg bg-white max-w-sm">
            <form id="login-form" method="POST" onSubmit={onSubmit} action="/">
                <div className="form-group mb-6">
                    <label htmlFor="exampleInputEmail2" className="form-label inline-block mb-2 text-gray-700">Email
                        address</label>
                    <input name="email" type="email" className="form-control
        block
        w-full
        px-3
        py-1.5
        text-base
        font-normal
        text-gray-700
        bg-white bg-clip-padding
        border border-solid border-gray-300
        rounded
        transition
        ease-in-out
        m-0
        focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none" id="exampleInputEmail2"
                           aria-describedby="emailHelp" placeholder="Enter email"/>
                </div>
                <div className="form-group mb-6">
                    <label htmlFor="exampleInputPassword2"
                           className="form-label inline-block mb-2 text-gray-700">Password</label>
<<<<<<< HEAD
                    <input type="password" className="form-control block
=======
                    <input name="password" type="password" className="form-control block
>>>>>>> sprint_2/development
        w-full
        px-3
        py-1.5
        text-base
        font-normal
        text-gray-700
        bg-white bg-clip-padding
        border border-solid border-gray-300
        rounded
        transition
        ease-in-out
        m-0
        focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none" id="exampleInputPassword2"
                           placeholder="Password"/>
                </div>
                <div className="flex justify-between items-center mb-6">
                    <div className="form-group form-check">
                        <input type="checkbox"
                               className="form-check-input appearance-none h-4 w-4 border border-gray-300 rounded-sm bg-white checked:bg-blue-600 checked:border-blue-600 focus:outline-none transition duration-200 mt-1 align-top bg-no-repeat bg-center bg-contain float-left mr-2 cursor-pointer"
                               id="exampleCheck2"/>
                            <label className="form-check-label inline-block text-gray-800" htmlFor="exampleCheck2">Remember
                                me</label>
                        <br/>
                        <a href="#!"
                           className="text-blue-600 hover:text-blue-700 focus:text-blue-700 transition duration-200 ease-in-out">Forgot
                            password?</a>
<<<<<<< HEAD
=======
                        <button
                            className="bg-emerald-500 text-white active:bg-emerald-600 font-bold uppercase text-sm px-6 py-3 rounded shadow hover:shadow-lg outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150"
                            type="submit">
                            Login
                        </button>
>>>>>>> sprint_2/development
                    </div>


                </div>

            </form>
        </div>
    )
}