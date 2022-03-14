import React from "react";
import '../../App.css';
import TestingComponentService from "./TestingComponentService";


class TestComponent extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
            elements:[]
        }
    }

    componentDidMount() {
        TestingComponentService.getElements().then((response) => {
            this.setState({elements : response.data})
        });
    }

    render () {
        return (
            <div>
                <h1 >Current elements</h1>
                <thead>
                <tr>
                    <td>Id</td>
                    <td>Name</td>
                    <td>MagicNumber</td>
                </tr>
                </thead>
                <tbody>
                {this.state.elements.map(
                    elt => <tr key={elt.id}>
                        <td>{elt.id}</td>
                        <td>{elt.name}</td>
                        <td>{elt.magicNumber}</td>
                    </tr>
                )}
                </tbody>
            </div>
        )
    }
}

export default TestComponent