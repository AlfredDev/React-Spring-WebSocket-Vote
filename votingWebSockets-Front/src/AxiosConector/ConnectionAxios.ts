import axios, { InternalAxiosRequestConfig } from "axios";

// const URL_BACKEND_VOTE: string = 'https://backend-wspq.onrender.com';

export const axiosInstance = axios.create({
    baseURL: 'https://backend-wspq.onrender.com',
    headers: {
        'Content-Type': 'application/json',
    },
});



axiosInstance.interceptors.request.use(
    (config: InternalAxiosRequestConfig) => {
        const token: string | null = getAuthToken();
        if (token && config.headers) {
            config.headers.Authorization = `Bearer ${token}`;
        }
        return config;
    },
    (error) => {
        return Promise.reject(error);
    }
);



function getAuthToken(): string | null {
    const user = localStorage.getItem('authToken');
    return user;
}
