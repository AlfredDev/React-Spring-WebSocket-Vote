import { useDispatch } from "react-redux";
import { AppDispatch } from "../../redux/store";
import { useNavigate } from "react-router-dom";
import { logout } from "../../redux/Reducers/auth/authSlice";

export const Home = () => {
    const navigate = useNavigate();

    const dispatch = useDispatch<AppDispatch>();

   
    const onSubmit = (e: React.MouseEvent) => {
        e.preventDefault(); 
        dispatch(logout());
        navigate('/login'); 
    }
    return (
        <div>
            Home
            <button onClick={onSubmit}>
                Cerras session
            </button>
        </div>
    )
}
