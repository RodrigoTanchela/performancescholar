import { Footer } from "../../Layout/Footer"
import { Heading } from "../../Layout/Heading"
import { Card } from "../../UI/Card"

export const TurmaPage = () => {
    return(
        <section className="turmaPage-container">
            <Heading text={"Bem-vindo à Página Principal"}></Heading>
            <Card />
        <Footer></Footer>
        </section>  
    )
}