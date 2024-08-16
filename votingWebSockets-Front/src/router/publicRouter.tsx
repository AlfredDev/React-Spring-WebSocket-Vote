import { Navigate } from "react-router-dom";
interface PublicRouterProps {
    children: React.ReactNode;
}

export const PublicRouter: React.FC<PublicRouterProps> = ({ children }) => {

    const logged: boolean = false;
    return (!logged)
        ? children
        : <Navigate to="/home" />
}
