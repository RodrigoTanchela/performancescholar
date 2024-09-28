import './styles.css'

const Button = ({ label, style='visualizar', onClick, type = 'button', disabled = false }) => {
  return (
    <button className={style} type={type} onClick={onClick} disabled={disabled}>
      {label}
    </button>
  );
};

export default Button;
