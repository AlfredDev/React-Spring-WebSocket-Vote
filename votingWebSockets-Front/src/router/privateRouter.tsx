import { useSelector } from "react-redux";
import { Navigate } from "react-router-dom";
import { RootState } from "../redux/store";


interface PrivateRouterProps {
    children: React.ReactNode;
}

export const PrivateRouter: React.FC<PrivateRouterProps> = ({ children }) => {
    const isAuthenticated = useSelector((state: RootState) => state.auth.isAuthenticated);

    if (!isAuthenticated) {
        return <Navigate to="/login"  />;
    }

    return <>{children}</>;
}
