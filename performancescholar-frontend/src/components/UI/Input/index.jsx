const Input = ({label, type, value, updateValue , placeholder, classNome="text", required, name }) => {
  return (
      <>
        <label>{label}</label>
        <input
          type={type}
          value={value}
          onChange={event => updateValue (event.target.value)}
          placeholder={placeholder}
          className={classNome}
          required={required}
          name={name}
        />
     </>
  );
};

export default Input;
