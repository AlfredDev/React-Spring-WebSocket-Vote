import { useSelector } from "react-redux";
import { Navigate } from "react-router-dom";
import { RootState } from "../redux/store";
interface PublicRouterProps {
    children: React.ReactNode;
}

export const PublicRouter: React.FC<PublicRouterProps> = ({ children }) => {

    const isAuthenticated = useSelector((state: RootState) => state.auth.isAuthenticated);
    if (isAuthenticated) {
        return <Navigate to="/home" replace />;
    }

    return <>{children}</>;
}
