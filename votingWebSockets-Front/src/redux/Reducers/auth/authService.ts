import axios from "axios";

type LoginRequest = {
    email: string;
    password: string;
}

type RegisterRequest = {
    fullName: string;
    email: string;
    password: string;
    role: string;
}

type LoginResponse = {
    token: string;
    role: string;
    email: string;
};



export const loginRequest = async (req: LoginRequest): Promise<LoginResponse | null> => {
    try {
        const response = await axios.post('https://backend-wspq.onrender.com/auth/login', req);
        return response.data;
    }
    catch (err: any) {
        console.error('Login error:', err.response?.data || err.message);
        return null;
    };
}


export const RegisterRequestBack = async (req: RegisterRequest): Promise<LoginResponse | null> => {
    try {
        const response = await axios.post('https://backend-wspq.onrender.com/auth/register', req);
        return response.data;
    } catch (err: any) {
        console.error('Register error:', err.response?.data || err.message);
        throw new Error(err.response?.data.message || err.message);
    }
}


