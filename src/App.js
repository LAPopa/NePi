import logo from './logo.svg';
import './App.css';
import communityLogo from './assets/communityRoutes.png';

import React from "react";

import {BrowserRouter as Router, Route, Navigate, Link, NavLink} from "react-router-dom";
import {Routes} from "react-router";
import CommunityRegisterLogin from './components/generalUsers';
import LandingPage from "./components/LandingPage";
import Footer from "./components/Footer";

function App() {
    return (

        <div className="App">
            <Router>
                <LandingPage/>
                <CommunityRegisterLogin/>
                <Link to={"/first"}>The first link</Link>|{" "}|
                <Link to={"/next"}>The next link</Link>
                <Link to={"/community"}><a ><img className="community-register-login" src={communityLogo}/></a></Link>
                <Footer/>

                <Routes>
                    <Route exact path={"/first"} element={<SomeLink/>}>
                    </Route>
                    <Route exact path={"/next"} element={<NextLink/>}>
                    </Route>
                    <Route exact path={"/community"} element={<DisplayCommunityBlob/>}/>
                </Routes>
            </Router>


        </div>
    );
}

function SomeLink() {
    return <h2>You clicked the first link</h2>;
}

function NextLink() {
    return <h2>You clicked the second link</h2>;
}

function DisplayCommunityBlob(){
    return <h2>Community hub accessed</h2>;
}

export default App;



