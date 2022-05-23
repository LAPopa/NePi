import '../../App.css';
import React from "react";
import axios from 'axios';


const TEST_GET_API_URL = 'http://localhost:8080/testing-route';

class TestingComponentService {

    getElements(){
        console.log(axios.get(TEST_GET_API_URL));
        return axios.get(TEST_GET_API_URL);
    }
}

export default new TestingComponentService();