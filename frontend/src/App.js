import './App.css';

import React from "react";

import {BrowserRouter as Router, Route, Navigate, Link, NavLink} from "react-router-dom";
import {Routes} from "react-router";

import {ToastContainer, toast} from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';

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
import TESTDashboard from "./components/pages/Dashboard";
import UserTickets from "./components/userpages/UserTickets";
import PostTicket from "./components/userpages/PostTicket";
import UserDetails from "./components/userpages/UserDetails";
import AssignOperator from "./components/userpages/AssignOperator";

function App() {
    return (

        <div className="App">
            <ToastContainer/>
            <Router>
                <Header/>


                <Routes>

                    <Route path={"/"} element={<LandingPage/>}/>
                    <Route path={"/community-register"} element={<CommunityRegistrationSelector/>}/>
                    <Route path={"/registration/owners"} element={<OwnerRegistration/>}/>
                    <Route path={"/registration/tenants"} element={<RenterRegistration/>}/>
                    <Route path={"/registration/utilities"} element={<UtilitiesRegistration/>}/>
                    <Route path={"/testing-route"} element={<><TestComponent/><TestFormService/></>}/>
                    <Route path={"/login-successful"} element={<LoginSuccessTest/>}/>
                    <Route path={"/registration-successful"} element={<UserRegistrationSuccessTest/>}/>
                    <Route path={"/TEST-DASHBOARD"} element={<TESTDashboard/>}/>
                    <Route path={"/tickets/show"} element={<UserTickets/>} />
                    <Route path={"/tickets/new"} element={<PostTicket/>}/>
                    <Route path={"/get-user-details"} element={<UserDetails/>}/>
                    <Route path={"/tickets/assign-operators"} element={<AssignOperator/>}/>

                </Routes>
                <Footer/>
            </Router>


        </div>
    );
}


export default App;



