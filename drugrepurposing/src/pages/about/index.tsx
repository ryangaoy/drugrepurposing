import { PageContainer } from '@ant-design/pro-components';
import React from 'react';
// @ts-ignore
import { useIntl } from 'umi';
import './Welcome.less';
import HomeHeader from '@/pages/about/components/HomeHeader';

const Home: React.FC = () => {
  // @ts-ignore
  const intl = useIntl();

  return (
    <PageContainer
      title={false}
      content={<HomeHeader />}
      className={'About'}
      style={{ paddingBottom: 0 }}
    ></PageContainer>
  );
};

export default Home;
