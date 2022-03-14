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
import TestComponent from "./components/TestComponent";

function App() {
    return (

        <div className="App">
            <Router>
                <Header/>




                <Routes>

                    <Route exact path={"/"} element={<LandingPage/>}>
                    </Route>
                    <Route exact path={"/community-register"} element={<CommunityRegistrationSelector/>}/>
                    <Route exact path={"/registration/owners"} element={<OwnerRegistration/>}/>
                    <Route exact path={"/registration/tenants"} element={<RenterRegistration/>}/>
                    <Route exact path={"/registration/utilities"} element={<UtilitiesRegistration/>}/>
                    <Route exact path={"/test-get-all"} element = {<TestComponent/>}/>


                </Routes>
                <Footer/>
            </Router>


        </div>
    );
}



export default App;



