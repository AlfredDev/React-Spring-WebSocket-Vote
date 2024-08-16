import { useDispatch, useSelector } from "react-redux";
import { useForm } from "../../hooks/useForm";
import { AppDispatch, RootState } from "../../redux/store";
import { login } from "../../redux/Reducers/auth/authSlice";
import { useNavigate } from "react-router-dom";
import { useState } from "react";
import { CreateAccountForm } from "../components/CreateAccountForm";
export const LoginPage = () => {
  const navigate = useNavigate();

  const { formState, onInputChange, onResetForm } = useForm({
    email: '',
    password: ''
  });
  const dispatch = useDispatch<AppDispatch>();
  const { loading, error } = useSelector((state: RootState) => state.auth);

  const onSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    dispatch(login({ email: formState.email, password: formState.password }))
      .unwrap()
      .then(() => {
        navigate("/", {
          replace: true,
        });
        onResetForm();
      })
      .catch((err) => {
        console.error("Login failed", err);
      });
  };
  const [isModalOpen, setIsModalOpen] = useState(false);

  const openModal = () => setIsModalOpen(true);
  const closeModal = () => setIsModalOpen(false);

  return (
    <>
      <div className="flex h-screen bg-indigo-700">
        <div className="w-full max-w-xs m-auto bg-indigo-100 rounded-lg p-5">
          <header>
            <img className="w-20 mx-auto mb-5" src="https://img.icons8.com/?size=100&id=jLY6kB04tr7J&format=png&color=000000" />
          </header>
          <form onSubmit={onSubmit}>
            <div>
              <label className="block mb-2 text-indigo-500">Email</label>
              <input
                className="w-full p-2 mb-6 text-indigo-700 border-b-2 border-indigo-500 outline-none focus:bg-gray-300"
                type="email"
                name="email"
                value={formState.email}
                onChange={onInputChange}
              />
            </div>
            <div>
              <label className="block mb-2 text-indigo-500">Password</label>
              <input
                className="w-full p-2 mb-6 text-indigo-700 border-b-2 border-indigo-500 outline-none focus:bg-gray-300"
                type="password"
                name="password"
                value={formState.password}
                onChange={onInputChange}
              />
            </div>
            {error && <p className="text-red-500 mb-4">{error}</p>}
            <div>
              <input
                className="w-full bg-indigo-700 hover:bg-pink-700 text-white font-bold py-2 px-4 mb-6 rounded"
                type="submit"
                value={loading ? "Loading..." : "Login"}
                disabled={loading}
              />
            </div>
          </form>
          <footer>
            <a className="text-indigo-700 hover:text-pink-700 text-sm float-left" href="#">Forgot Password?</a>
            <a className="text-indigo-700 hover:text-pink-700 text-sm float-right" href="#"
              onClick={openModal}
            >Create Account</a>
          </footer>
        </div>
      </div>
      {isModalOpen && (
        <CreateAccountForm closeModal={closeModal} />
      )}
    </>
  );
};
