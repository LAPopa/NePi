import React from "react";
import '../../App.css';
import axios from 'axios';


function TestFormService() {

    const TEST_POST_API_URL = 'http://localhost:8080/testing-route';

    const onSubmit = (e) => {
        e.preventDefault();

        const formData = new FormData(e.target);

        fetch(TEST_POST_API_URL, {
            method: "POST",
            headers: {
                Accept: "application/json",
                "Content-type": "application/json",
            },
            body: JSON.stringify({
                id: formData.get('id'),
                name: formData.get('name'),
                magicNumber: formData.get('magicNumber'),
            }),
        })
            .then((response) => response.json())
            .then((data) => {
                alert("Success!");
            })
    }

    return (
        <div>
            <form id="test-form" method="POST" onSubmit={onSubmit}>
                <div className="field padding-bottom--24">
                    <label htmlFor="id">ID</label>
                    <input type="text" name="id"/>
                </div>
                <div className="field padding-bottom--24">
                    <label htmlFor="name">Name</label>
                    <input type="text" name="name"/>
                </div>
                <div className="field padding-bottom--24">
                    <label htmlFor="magicNumber">MagicNumber</label>
                    <input type="text" name="magicNumber"/>
                </div>
                <div className="field padding-bottom--24">
                    <input type="submit" name="submit" value="Continue"/>
                </div>
            </form>
        </div>
    );
}

export default TestFormService;