import { NavLinks } from '../../UI/NavLink';
import './styles.css';

const linksData = [
  {
    children: 'Home',
    link: '/turmaPage',
    newTab: false,
  },
  {
    children: 'About',
    link: 'https://github.com/RodrigoTanchela',
    newTab: false,
  },
  {
    children: 'Contact',
    link: 'https://www.instagram.com/rodrigo_martinez_tanchela/',
    newTab: true,
  },
];

export const Heading = () => {
  return (
    <header className="heading-container">
      <img className="logo" src="/../../../src/assets/imagens/Performance scholar.png" alt="logo marca" />
      <NavLinks className="links" links={linksData} />
    </header>
  );
};
