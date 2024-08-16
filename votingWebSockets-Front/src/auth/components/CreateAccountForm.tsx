import React from 'react';
import { useForm } from '../../hooks/useForm';
import { useDispatch } from 'react-redux';
import { AppDispatch, RootState } from '../../redux/store';
import { useSelector } from 'react-redux';
import { register } from '../../redux/Reducers/auth/authSlice';
import { useNavigate } from 'react-router-dom';

interface CreateAccountFormProps {
    closeModal: () => void;
}

export const CreateAccountForm: React.FC<CreateAccountFormProps> = ({ closeModal }) => {

    const dispatch = useDispatch<AppDispatch>();
    const { loading, error } = useSelector((state: RootState) => state.auth);
    const navigate = useNavigate();
    const { formState, onInputChange, onResetForm } = useForm({
        email: '',
        password: '',
        password2: '',
        fullName: '',
        role: 'ADMIN',
    });

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();

        if (formState.password !== formState.password2) {
            alert('Passwords do not match');
            return;
        }

        try {
            await dispatch(register({
                fullName: formState.fullName,  
                email: formState.email,
                password: formState.password,
                role: formState.role,
            })).unwrap();

            onResetForm();
            navigate("/", {
                replace: true,
            });
        } catch (err) {
            alert(error);
            console.error("Registration failed", err);
        }
    };




    return (
        <div className="fixed inset-0 flex justify-center items-center bg-black bg-opacity-50">
            <div className="bg-white p-6 rounded-lg shadow-lg max-w-sm w-full">
                <h2 className="text-2xl mb-4">Register</h2>
                <form onSubmit={handleSubmit}>

                    <div>
                        <label className="block text-sm font-medium text-gray-700">Full Name</label>
                        <div className="mt-1">
                            <input name="fullName" type="text" required
                                onChange={onInputChange}
                                value={formState.fullname}
                                className="px-2 py-3 mt-1 block w-full rounded-md border border-gray-300 shadow-sm focus:border-sky-500 focus:outline-none focus:ring-sky-500 sm:text-sm" />
                        </div>
                    </div>

                    <div>
                        <label className="block text-sm font-medium text-gray-700">Email</label>
                        <div className="mt-1">
                            <input name="email" type="email-address" required
                                value={formState.email}
                                onChange={onInputChange}
                                className="px-2 py-3 mt-1 block w-full rounded-md border border-gray-300 shadow-sm focus:border-sky-500 focus:outline-none focus:ring-sky-500 sm:text-sm" />
                        </div>
                    </div>

                    <div>
                        <label className="block text-sm font-medium text-gray-700">Password</label>
                        <div className="mt-1">
                            <input name="password" type="password" required
                                value={formState.password}
                                onChange={onInputChange}
                                className="px-2 py-3 mt-1 block w-full rounded-md border border-gray-300 shadow-sm focus:border-sky-500 focus:outline-none focus:ring-sky-500 sm:text-sm" />
                        </div>
                    </div>

                    <div>
                        <label className="block text-sm font-medium text-gray-700">Confirm Password</label>
                        <div className="mt-1">
                            <input name="password2" type="password" required
                                value={formState.password2}
                                onChange={onInputChange}
                                className="px-2 py-3 mt-1 block w-full rounded-md border border-gray-300 shadow-sm focus:border-sky-500 focus:outline-none focus:ring-sky-500 sm:text-sm" />
                        </div>
                    </div>

                    <div className="flex justify-between pt-5">
                        <button
                            type="submit"
                            className="bg-indigo-700 hover:bg-indigo-800 text-white font-bold py-2 px-4 rounded"
                            disabled={loading}
                        >
                            {loading ? "Registering..." : "Register"}
                        </button>
                        <button
                            type="button"
                            onClick={closeModal}
                            className="bg-gray-300 hover:bg-gray-400 text-black py-2 px-4 rounded"
                        >
                            Close
                        </button>
                    </div>
                </form>
            </div>

        </div>
    );
};
