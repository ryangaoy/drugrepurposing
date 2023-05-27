import { DefaultFooter } from '@ant-design/pro-components';
import { useIntl } from 'umi';

const Footer: React.FC = () => {
  const intl = useIntl();
  const defaultMessage = intl.formatMessage({
    id: 'app.copyright.produced',
    defaultMessage: 'Faculty of Information Science and Engineering - Ocean University of China',
  });

  const currentYear = new Date().getFullYear();

  return (
    <>
      <div
        style={{
          display: 'flex',
          alignItems: 'center',
          justifyContent: 'center',
          backgroundColor: '#314352',
        }}
      >
        <img src={`/icons/zghy.png`} alt={'中国海洋大学'} style={{ width: 200 }} />
      </div>
      <DefaultFooter copyright={`${currentYear} ${defaultMessage}`} />
    </>
  );
};

export default Footer;
