import './App.css';

import React from "react";

import {BrowserRouter as Router, Route, Navigate, Link, NavLink} from "react-router-dom";
import {Routes} from "react-router";
import LandingPage from "./components/LandingPage";
import Footer from "./components/Footer";
import Header from './components/Header';
import {CommunityRegistrationSelector} from "./components/registrations/CommunityRegistrationSelector";
import {OwnerRegistration} from "./components/registrations/OwnerRegistration";
import {RenterRegistration} from "./components/registrations/RenterRegistration";
import {UtilitiesRegistration} from "./components/registrations/UtilitiesRegistration";
import TestComponent from "./components/testingStuff/TestComponent";
import TestFormService from "./components/testingStuff/TestFormService";
import LoginSuccessTest from "./components/logins/LoginSuccessTest";
import UserRegistrationSuccessTest from "./components/registrations/UserRegistrationSuccessTest";

function App() {
    return (

        <div className="App">
            <Router>
                <Header/>


                <Routes>

                    <Route path={"/"} element={<LandingPage/>}>
                    </Route>
                    <Route path={"/community-register"} element={<CommunityRegistrationSelector/>}/>
                    <Route path={"/registration/owners"} element={<OwnerRegistration/>}/>
                    <Route path={"/registration/tenants"} element={<RenterRegistration/>}/>
                    <Route path={"/registration/utilities"} element={<UtilitiesRegistration/>}/>
                    <Route path={"/testing-route"} element={<><TestComponent/><TestFormService/></>}/>
                    <Route path={"/login-successful"} element={<LoginSuccessTest/>}/>
                    <Route path={"/registration-successful"} element={<UserRegistrationSuccessTest/>}/>

                </Routes>
                <Footer/>
            </Router>


        </div>
    );
}


export default App;



