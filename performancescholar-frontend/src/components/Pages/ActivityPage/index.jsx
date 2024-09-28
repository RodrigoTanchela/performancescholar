import { Footer } from "../../Layout/Footer"
import { Heading } from "../../Layout/Heading"
import { CardActivity } from "../../UI/CardActivity"
import './styles.css'

export const ActivityPage = () => {
    return(
        <section className="activityPage-container">
            <Heading text={"Bem-vindo à Página Principal"}></Heading>
            <CardActivity />
            <Footer></Footer>
        </section>  
    )
}