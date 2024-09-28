import PropTypes from 'prop-types';

export const Label = ({ htmlFor, children='texto', className='texto' }) => {
  return (
    <label className={className} htmlFor={htmlFor}>{children}</label>
  );
};

