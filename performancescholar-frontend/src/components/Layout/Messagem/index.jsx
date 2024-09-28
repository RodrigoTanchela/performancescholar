import { useEffect, useState } from 'react';
import './styles.css';

export const Messagem = (children, type = "info") => {
    const [visible, setVisible] = useState(false)

    useEffect(() => {
        if(!children) {
            setVisible(false)
            return
        }

        setVisible(true)

        const timer = setTimeout(() =>{
            setVisible(false)
        }, 5000)

        return () => clearTimeout(timer);
    }, [children])

    return(
        <div className={`message ${children.type}`}>
            {children.text}
        </div>
    )
}