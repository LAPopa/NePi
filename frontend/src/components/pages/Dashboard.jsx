import React, {useState} from 'react';

import Sidebar from '../partials/Sidebar';
import Header from '../partials/Header';
import WelcomeBanner from '../partials/dashboard/WelcomeBanner';
import DashboardCard04 from '../partials/dashboard/DashboardCard04';
import DashboardCard05 from '../partials/dashboard/DashboardCard05';
import DashboardCard06 from '../partials/dashboard/DashboardCard06';
import DashboardCard07 from '../partials/dashboard/DashboardCard07';
import DashboardCard12 from '../partials/dashboard/DashboardCard12';
import {useNavigate} from "react-router-dom";

function Dashboard() {
    let navigate = useNavigate();
    const [sidebarOpen, setSidebarOpen] = useState(false);

    return (
        <div>
            {
                !localStorage.getItem("email") ?
                    <>
                        <a className="flex title-font font-medium items-center text-gray-900 mb-4 md:mb-0"
                           href="/"> Please Log
                            in.</a>
                    </>
                    :
                    <>
                        <div className="flex h-screen overflow-hidden">
                            {/* Sidebar */}
                            <Sidebar sidebarOpen={sidebarOpen} setSidebarOpen={setSidebarOpen}/>
                            {/* Content area */}
                            <div className="relative flex flex-col flex-1 overflow-y-auto overflow-x-hidden">
                                {/*  Site header */}
                                <Header sidebarOpen={sidebarOpen} setSidebarOpen={setSidebarOpen}/>
                                <main>
                                    <div className="px-4 sm:px-6 lg:px-8 py-8 w-full max-w-9xl mx-auto">
                                        {/* Welcome banner */}
                                        <WelcomeBanner/>
                                        <div className="grid grid-cols-12 gap-6">
                                            {localStorage.getItem("roles") === "ROLE_ADMIN" || localStorage.getItem("roles") === "ROLE_OVERSEER" ?
                                                <>
                                                    <DashboardCard04/>
                                                    <DashboardCard05/>
                                                    <DashboardCard06/>
                                                    <DashboardCard07/>
                                                    <DashboardCard12/>
                                                </>
                                                :
                                                <>
                                                </>
                                            }
                                        </div>
                                    </div>
                                </main>
                            </div>
                        </div>
                    </>
            }
        </div>
    )
        ;
}

export default Dashboard;