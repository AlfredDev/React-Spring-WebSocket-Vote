import { Navigate } from "react-router-dom";


interface PrivateRouterProps {
    children: React.ReactNode;
}

export const PrivateRouter: React.FC<PrivateRouterProps> = ({ children }) => {
    const logged: boolean = false;

    return (logged)
        ? children
        : <Navigate to="/login" />
}
