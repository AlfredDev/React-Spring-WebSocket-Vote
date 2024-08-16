import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import { loginRequest, RegisterRequestBack, } from './authService';


interface AuthState {
    isAuthenticated: boolean;
    token: string;
    role: string;
    email: string;
    error: string | null;
    message: string | null;
    loading: boolean;
}


const initialState: AuthState = {
    isAuthenticated: !!localStorage.getItem('authToken'),
    role: '',
    loading: false,
    error: null,
    token: '',
    email: '',
    message: ''
};

export const login = createAsyncThunk(
    'auth/login',
    async (credentials: { email: string; password: string }, { rejectWithValue }) => {
        try {
            const response = await loginRequest(credentials);
            if (response) {
                return response;
            } else {
                return rejectWithValue('Login failed. Please check your credentials.');
            }
        } catch (error: any) {
            return rejectWithValue(error.response?.data || error.message);
        }
    }
);

export const register = createAsyncThunk(
    'auth/register',
    async (RegisterRequest: { fullName: string, email: string, password: string, role: string }, { rejectWithValue }) => {
        try {
            const response = await RegisterRequestBack(RegisterRequest);
            if (response) {
                return response;
            }
            else {
                return rejectWithValue('Register failed. Please check your credentials.');
            }
        }
        catch (error: any) {
            return rejectWithValue(error.response?.data || error.message);
        }
    }
);


export const authSlice = createSlice({
    name: 'auth',
    initialState,
    reducers: {
        logout: (state) => {
            state.isAuthenticated = false;
            state.token = '';
            state.role = '';
            state.email = '';
            state.message = 'Logged out successfully';
            localStorage.removeItem('authToken');
            localStorage.removeItem('userRole');
            localStorage.removeItem('userEmail');
        }
    },
    extraReducers: (builder) => {
        builder
            .addCase(login.pending, (state) => {
                state.loading = true;
                state.error = null;
                state.message = null
            })
            .addCase(login.fulfilled, (state, action) => {
                state.loading = false;
                state.isAuthenticated = true;
                state.token = action.payload.token;
                state.role = action.payload.role;
                state.email = action.payload.email;
                state.message = 'Login successful';

                localStorage.setItem('authToken', action.payload.token);
                localStorage.setItem('userRole', action.payload.role);
                localStorage.setItem('userEmail', action.payload.email);
            })
            .addCase(login.rejected, (state, action) => {
                state.loading = false;
                state.error = action.payload as string;
            })
            .addCase(register.pending, (state) => {
                state.loading = true;
                state.error = null;
                state.message = null;
            })
            .addCase(register.fulfilled, (state, action) => {
                state.loading = false;
                state.isAuthenticated = true;
                state.token = action.payload.token;
                state.role = action.payload.role;
                state.email = action.payload.email;
                state.message = 'Registration successful';

                localStorage.setItem('authToken', action.payload.token);
                localStorage.setItem('userRole', action.payload.role);
                localStorage.setItem('userEmail', action.payload.email);
            })
            .addCase(register.rejected, (state, action) => {
                state.loading = false;
                state.error = action.payload as string;
            });
    }
});

export const { logout } = authSlice.actions;
export default authSlice.reducer;
