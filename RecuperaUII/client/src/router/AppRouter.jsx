import React from 'react'
import SignInPage from '../modules/auth/SignInPage';
import { useContext } from 'react';
import AuthContext from '../config/context/auth-context';
import { Route, RouterProvider, createBrowserRouter, createRoutesFromElements } from 'react-router-dom';
import AdminLayout from '../components/layout/AdminLayout';

const AppRouter = () => {
    const { user } = useContext(AuthContext);
    const router = createBrowserRouter(
        createRoutesFromElements(
            <>
                {user.signed ? (
                    <>
                        <Route path='/' element={<AdminLayout />}>
                            {user.roles[0]?.name === "ADMIN_ROLE" && (
                                <Route
                                    path="admin"
                                    element={
                                        <>
                                            {user.user.person?.name + " " + user.user.person?.surname + " " + `${user.user.person?.lastname ?? ''}` + " - " + user?.roles[0]?.name
                                            }
                                        </>
                                    }
                                />
                            )}
                            {user.roles[0]?.name === "CLIENT_ROLE" && (
                                <Route
                                    path="client"
                                    element={
                                        <>
                                            {user.user.person?.name + " " + user.user.person?.surname + " " + `${user.user.person?.lastname ?? ''}` + " - " + user?.roles[0]?.name
                                            }
                                        </>
                                    }
                                />
                            )}
                            {user.roles[0]?.name === "USER_ROLE" && (
                                <Route
                                    path="user"
                                    element={
                                        <>
                                            {user.user.person?.name + " " + user.user.person?.surname + " " + `${user.user.person?.lastname ?? ''}` + " - " + user?.roles[0]?.name
                                            }
                                        </>
                                    }
                                />
                            )}
                        </Route>
                    </>
                ) : (
                    <Route path="/" element={<SignInPage />} />
                )}
                <Route path='/*' element={<>404 not found</>} />
            </>
        )
    );
    return (
        < RouterProvider router={router} />
    );
}

export default AppRouter