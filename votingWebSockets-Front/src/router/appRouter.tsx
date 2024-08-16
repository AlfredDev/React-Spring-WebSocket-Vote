import { Route, Routes } from 'react-router-dom';
import { PublicRouter } from './publicRouter';
import { LoginPage } from '../auth/pages/LoginPage';
import { PrivateRouter } from './privateRouter';
import { VoteRoutes } from '../VoteApp/Routes/VoteRoutes';

export const AppRouter = () => {
    return (
        <Routes>
            <Route path='login/*' element={
                <PublicRouter>
                    <Routes>
                        <Route path='/*' element={<LoginPage />} />
                    </Routes>
                </PublicRouter>
            } />
            <Route path='/*' element={
                <PrivateRouter>
                    <VoteRoutes />
                </PrivateRouter>
            } />
        </Routes>
    );
}
