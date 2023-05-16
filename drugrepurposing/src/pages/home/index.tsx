import { PageContainer } from '@ant-design/pro-components';
import { Col, Row, Statistic } from 'antd';
import React, { useEffect } from 'react';
// @ts-ignore
import { useIntl } from 'umi';
import './Welcome.less';
import HomeHeader from '@/pages/home/components/HomeHeader';
import * as NGL from 'ngl';

const Home: React.FC = () => {
  // @ts-ignore
  const intl = useIntl();

  useEffect(() => {
    // create a `stage` object
    const stage = new NGL.Stage('viewport');
    // @ts-ignore
    stage.loadFile(`/redrugfiles/files/drugbank_sdf/DB00114.sdf`).then(function (component) {
      // @ts-ignore
      component.addRepresentation('ball+stick');
      // @ts-ignore
      component.autoView();
    });
  }, []);

  return (
    <PageContainer title={false} content={<HomeHeader />} className={'Home'}>
      <div style={{ paddingBottom: 120 }}>
        <Row
          style={{
            marginTop: 120,
            display: 'flex',
            alignItems: 'center',
            justifyContent: 'center',
          }}
          gutter={60}
        >
          {/*<Col span={4}></Col>*/}
          <Col span={12} style={{ textAlign: 'center' }}>
            <Row justify="center" align="middle">
              <div id="viewport" style={{ width: '458px', height: '613px', borderRadius: 10 }} />
            </Row>
          </Col>
          <Col span={12}>
            <h2 className="listivo-heading-v2__text">Explore Listings on Listivo</h2>
            <div className="listivo-content-v1__text">
              Maecenas tristique feugiat eros, quis porttitor tortor fringilla quis. Aenean porta
              vehicula felis, malesuada maximus justo egestas non. Duis ultrices euismod dignissim.
              Praesent maximus condimentum maximus.
              <br />
              Mauris vehicula ligula sem.
            </div>
            <Row style={{ marginTop: 24 }} gutter={60}>
              {/*<Col span={4}></Col>*/}
              <Col span={6} style={{ textAlign: 'center' }}>
                <Row justify="center" align="middle">
                  <img
                    src={`/redrugfiles/files/system/img/pro_num.png`}
                    alt="Protein"
                    style={{ width: '70px' }}
                  />
                  <Statistic title="The Number of Protein" value={10094} />
                </Row>
              </Col>
              <Col span={6} style={{ textAlign: 'center' }}>
                <Row justify="center" align="middle">
                  <img
                    src={`/redrugfiles/files/system/img/mol_num.png`}
                    alt="Drugs"
                    style={{ width: '70px' }}
                  />
                  <Statistic title="The Number of Molecular" value={7162} />
                </Row>
              </Col>
              <Col span={6} style={{ textAlign: 'center' }}>
                <Row justify="center" align="middle">
                  <img
                    src={`/redrugfiles/files/system/img/dock_num.png`}
                    alt="Docking Results"
                    style={{ width: '70px' }}
                  />
                  <Statistic title="Docking Results" value={70} suffix="M+" />
                </Row>
              </Col>
              <Col span={6} style={{ textAlign: 'center' }}>
                <Row justify="center" align="middle">
                  <img
                    src={`/redrugfiles/files/system/img/doc_num.png`}
                    alt="Document"
                    style={{ width: '70px' }}
                  />
                  <Statistic title="The Number of Document" value={100} suffix="K+" />
                </Row>
              </Col>
            </Row>
          </Col>
        </Row>
      </div>
    </PageContainer>
  );
};

export default Home;
