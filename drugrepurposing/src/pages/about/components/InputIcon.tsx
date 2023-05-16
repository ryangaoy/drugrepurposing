import * as React from 'react';

const InputIcon = (props: {
  style: React.CSSProperties | undefined;
  ic: boolean | React.ReactChild | React.ReactFragment | React.ReactPortal | null | undefined;
}) => {
  return (
    <div
      style={{
        ...props.style,
        backgroundColor: '#f09965',
        borderRadius: '5px',
        alignItems: 'center',
        display: 'flex',
        justifyContent: 'center',
      }}
    >
      {props.ic}
    </div>
  );
};

export default InputIcon;
