import '../../App.css';
import CommunityBlob from '../../assets/communityRoutes.png';
import {LoginForm} from "./LoginForm";
import React from "react";
import {ReactComponent as CommunityBlobNew} from "../../assets/CommunityLoginBlob1.svg";

export function CommunityBlobLoginModal() {
    const [showModal, setShowModal] = React.useState(false);

    return (
        <div>
            <button
                className=" h-96 overflow-hidden text-white active:bg-green-700 font-bold uppercase text-sm px-6 py-3 hover:bg-green-600  mr-1 mb-1 ease-linear transition-all duration-150 rounded-full"
                type="button"
                onClick={() => setShowModal(true)}
            ><CommunityBlobNew/>
                {/*<img alt="content" className="object-fill object-center h-full w-full"*/}
                {/*  src={CommunityBlob}/>*/}

            </button>
            {showModal ? (
                <>
                    <div
                        className="justify-center items-center flex overflow-x-hidden overflow-y-auto fixed inset-0 z-50 outline-none focus:outline-none"
                    >
                        <div className="relative w-auto my-6 mx-auto max-w-3xl">
                            {/*content*/}
                            <div className="border-0 rounded-lg shadow-lg relative flex flex-col w-full bg-white outline-none focus:outline-none">
                                {/*header*/}
                                <div className="flex items-start justify-between p-5 border-b border-solid border-blueGray-200 rounded-t">
                                    <LoginForm/>

                                </div>

                                <div className="flex items-center justify-end p-6 border-t border-solid border-blueGray-200 rounded-b">
                                    <button
                                        className="text-red-500 background-transparent font-bold uppercase px-6 py-2 text-sm outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150"
                                        type="button"
                                        onClick={() => setShowModal(false)}
                                    >
                                        Cancel
                                    </button>
                                    {/*<button*/}
                                    {/*    className="bg-emerald-500 text-white active:bg-emerald-600 font-bold uppercase text-sm px-6 py-3 rounded shadow hover:shadow-lg outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150"*/}
                                    {/*    type="button"*/}
                                    {/*    onClick={() => setShowModal(false)}*/}
                                    {/*>*/}
                                    {/*    Login*/}
                                    {/*</button>*/}
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="opacity-25 fixed inset-0 z-40 bg-black"/>
                </>
            ) : null}


        </div>
    )
}