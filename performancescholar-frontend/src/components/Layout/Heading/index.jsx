import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import './styles.css'
import { NavLinks } from '../../UI/NavLink';
const linksData = [
  {
    children: 'Home',
    link: '/home',
    newTab: false,
  },
  {
    children: 'About',
    link: '/about',
    newTab: false,
  },
  {
    children: 'Contact',
    link: '/contact',
    newTab: true, // Este link abrirá em uma nova aba
  },
];



export const Heading = () => {
  return (
    <header className="heading-container">
      <img className="logo" src="/../../../src/assets/imagens/Performance scholar.png" alt="logo marca"></img>
      <Router>
      <NavLinks className="links" links={linksData} /> {}
      <Routes>
        {}
      </Routes>
    </Router>   
    </header>
  );
};

