import { useDispatch } from "react-redux";
import { AppDispatch } from "../../redux/store";
import { useNavigate } from "react-router-dom";
import { logout } from "../../redux/Reducers/auth/authSlice";
import PollComponent from "../Components/PollComponent";

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
            <PollComponent pollId={1}/>
            <button onClick={onSubmit} className="bg-blue-indigo mt-2">
                Cerras session
            </button>
        </div>
    )
}
