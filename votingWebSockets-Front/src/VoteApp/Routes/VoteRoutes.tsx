import { Route, Routes } from "react-router-dom"
import { Home } from "../Pages/Home"

export const VoteRoutes = () => {
  return (
    <div>
      <Routes>
        <Route path='/*' element={<Home />} />

      </Routes>
    </div>
  )
}
