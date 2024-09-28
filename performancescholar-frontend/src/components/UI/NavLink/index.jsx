import P from 'prop-types';
import { MenuLink } from '../MenuLink';
import './styles.css'

export const NavLinks = ({ links = [] }) => {
  return (
    <nav className = "container-link">
      {links.map((link) => (
        <MenuLink key={link.link} {...link} />
      ))}
    </nav>
  );
};

NavLinks.propTypes = {
  links: P.arrayOf(
    P.shape({
      children: P.string.isRequired,
      link: P.string.isRequired,
      newTab: P.bool,
    }),
  ),
};
