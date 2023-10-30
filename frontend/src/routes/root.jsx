import { createBrowserRouter } from 'react-router-dom'
import AppMain from '../App'

const router = createBrowserRouter([
  {
    path: "/",
    element: <AppMain />
  },

]);

export default router;