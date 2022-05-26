import React, {useEffect, useState} from "react";
import '../../App.css';


export default function UserDetails() {

    const [userDetails, allUserDetails] = useState([]);


    useEffect(() => {
        fetch(`http://localhost:8080/get-user-details?userId=${localStorage.getItem("userID")}`,
            {
                method: "GET",
                headers: {
                    'Authorization': 'Bearer ' + localStorage.getItem("token"),
                    "Content-Type": "application/json"
                }
            }
        )
            .then(response => response.json())
            .then((response) => {
                allUserDetails(response)
            })
    }, []);



    return (


        <div className="container mx-auto px-4 sm:px-8 max-w-3xl">
            <div className="py-8">
                <div className="flex flex-row mb-1 sm:mb-0 justify-between w-full">
                    <h2 className="text-2xl leading-tight">
                        User Details
                    </h2>

                </div>
                <div className="-mx-4 sm:-mx-8 px-4 sm:px-8 py-4 overflow-x-auto">
                    <div className="inline-block min-w-full shadow rounded-lg overflow-hidden">
                        <table className="min-w-full leading-normal">
                            <thead>
                            <tr>
                                <th scope="col"
                                    className="px-5 py-3 bg-white  border-b border-gray-200 text-gray-800  text-left text-sm uppercase font-normal">
                                    Email
                                </th>
                                <th scope="col"
                                    className="px-5 py-3 bg-white  border-b border-gray-200 text-gray-800  text-left text-sm uppercase font-normal">
                                    Phone Number
                                </th>
                                <th scope="col"
                                    className="px-5 py-3 bg-white  border-b border-gray-200 text-gray-800  text-left text-sm uppercase font-normal">
                                    Registered property codes
                                </th>

                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td className="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                                    <div className="flex items-center">

                                        <div className="ml-3">
                                            <p className="text-gray-900 whitespace-no-wrap">
                                                {userDetails[0]}
                                            </p>
                                        </div>
                                    </div>
                                </td>
                                <td className="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                                    <div className="flex items-center">

                                        <div className="ml-3">
                                            <p className="text-gray-900 whitespace-no-wrap">
                                                {userDetails[1]}
                                            </p>
                                        </div>
                                    </div>
                                </td>
                                <td className="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                                    <div className="flex items-center">

                                        <div className="ml-3">
                                            <p className="text-gray-900 whitespace-no-wrap">
                                                {userDetails[2]}
                                            </p>
                                        </div>
                                    </div>
                                </td>

                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>


    )


}


