import React, {useEffect, useState} from "react";
import '../../App.css';


export default function UserDetails() {

    const [userDetails, allUserDetails] = useState([]);


    let userId = localStorage.getItem("userID");

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

    let list = document.getElementById("userDetails");
    userDetails.forEach((item) => {
        let li = document.createElement("li");
        li.innerText = item;
        list.appendChild(li);
    });

    return (
        <div className="container mx-auto px-4 sm:px-8 max-w-3xl">
            <ul id="userDetails"></ul>
        </div>
    )


}


{/*{userDetails.map((UD) =>*/
}
{/*    <div className="text-xs text-slate-500 italic">{UD.email}</div>*/
}
{/*)}*/
}