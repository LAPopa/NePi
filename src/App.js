import './App.css';

import React from "react";

import {BrowserRouter as Router, Route, Navigate, Link, NavLink} from "react-router-dom";
import {Routes} from "react-router";
import LandingPage from "./components/LandingPage";
import Footer from "./components/Footer";
import Header from './components/Header';
import {CommunityRegistrationSelector} from "./components/CommunityRegistrationSelector";
import {OwnerRegistration} from "./components/OwnerRegistration";
import {RenterRegistration} from "./components/RenterRegistration";
import {UtilitiesRegistration} from "./components/UtilitiesRegistration";
<<<<<<< HEAD
=======
import TestComponent from "./components/testingStuff/TestComponent";
import TestFormService from "./components/testingStuff/TestFormService";
import LoginSuccessTest from "./components/LoginSuccessTest";
import UserRegistrationSuccessTest from "./components/UserRegistrationSuccessTest";
>>>>>>> sprint_2/development

function App() {
    return (

        <div className="App">
            <Router>
                <Header/>


<<<<<<< HEAD


                <Routes>

                    <Route exact path={"/"} element={<LandingPage/>}>
                    </Route>
                    <Route exact path={"/community-register"} element={<CommunityRegistrationSelector/>}/>
                    <Route exact path={"/registration/owners"} element={<OwnerRegistration/>}/>
                    <Route exact path={"/registration/tenants"} element={<RenterRegistration/>}/>
                    <Route exact path={"/registration/utilities"} element={<UtilitiesRegistration/>}/>

=======
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
>>>>>>> sprint_2/development

                </Routes>
                <Footer/>
            </Router>


        </div>
    );
}


<<<<<<< HEAD

=======
>>>>>>> sprint_2/development
export default App;



