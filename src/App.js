import './App.css';

import React from "react";

import {BrowserRouter as Router, Route, Navigate, Link, NavLink} from "react-router-dom";
import {Routes} from "react-router";
import LandingPage from "./components/LandingPage";
import Footer from "./components/Footer";
import Header from './components/Header';
import {CommunityRegistrationSelector} from "./components/CommunityRegistrationSelector";

function App() {
    return (

        <div className="App">
            <Router>
                <Header/>




                <Routes>

                    <Route exact path={"/"} element={<LandingPage/>}>
                    </Route>
                    <Route exact path={"/community-register"} element={<CommunityRegistrationSelector/>}/>


                </Routes>
                <Footer/>
            </Router>


        </div>
    );
}



export default App;



