import '../../App.css';
import LandlordImg from '../../assets/landlord.png';
import TenantImg from '../../assets/tenant.png';
import CommunityBlob from "../../assets/communityRoutes.png";
import React from "react";
import {useNavigate} from "react-router-dom";


export function CommunityRegistrationSelector() {
    let navigate = useNavigate();
    return (
        <div className="flex flex-row content-center justify-center items-center">

            <section className="text-gray-600 body-font">
                <div className="container px-5 py-24">
                    <div className="flex flex-wrap -mx-4 -mb-10 text-center">
                        <div className="sm:w-1/2 mb-10 px-4">
                            <h2 className="title-font text-2xl font-medium text-gray-900 mt-6 mb-3">I own property </h2>
                            <div className="rounded-lg h-64 overflow-hidden">
                                <img alt="content" className=" object-center h-full"
                                     src={LandlordImg}/>
                            </div>
                            <button
                                className="flex mx-auto mt-6 text-white bg-green-500 border-0 py-2 px-5 focus:outline-none hover:bg-green-600 rounded"
                            onClick={() => navigate("/registration/owners")}>Register
                            </button>
                        </div>
                        <div className="sm:w-1/2 mb-10 px-4">
                            <h2 className="title-font text-2xl font-medium text-gray-900 mt-6 mb-3">I pay rent</h2>
                            <div className="rounded-lg h-64 overflow-hidden">
                                <img alt="content" className="object-fill object-center h-full w-full"
                                     src={TenantImg}/>
                            </div>
                            <button
                                className="flex mx-auto mt-6 text-white bg-green-500 border-0 py-2 px-5 focus:outline-none hover:bg-green-600 rounded"
                            onClick={() => navigate("/registration/tenants")}>Register
                            </button>
                        </div>
                        <button
                            className="flex mx-auto mt-6 text-white bg-red-600  hover:bg-pink-700 border-0 py-2 px-5 focus:outline-none  rounded"
                        type="button"
                        onClick={() => navigate("/")}>Back
                        </button>
                    </div>
                </div>
            </section>
        </div>
    )
}