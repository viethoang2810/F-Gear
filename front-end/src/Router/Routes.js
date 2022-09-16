import routes from './RoutesConfig'
import HomePage from '../Page/HomePage/HomePage'
import StorePage from '../Page/StorePage/StorePage'


const publicRouter = [
    {
        path : routes.home,
        component : HomePage
    },
    {
        path : routes.store,
        component : StorePage
    },
   
]

export default publicRouter ;