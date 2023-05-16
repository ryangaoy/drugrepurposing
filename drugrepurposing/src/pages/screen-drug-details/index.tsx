import { GridContent, PageContainer, ProCard } from '@ant-design/pro-components';
import React, { useEffect, useState } from 'react';
// @ts-ignore
import { useIntl } from '@@/plugin-locale/localeExports';
import { useParams } from 'umi';
import { Card, Col, Descriptions, Empty, Row } from 'antd';
import type {
  IpaDiseaseAllType,
  IpaDiseaseSingleType,
  ScreenDrugType,
  ScreenSType,
} from '@/pages/screen-drug-details/data';
import {
  getScreenDrug,
  getScreenS,
  ipaDiseaseAllList,
  ipaDiseaseSingleList,
} from '@/pages/screen-drug-details/service';
import IpaAllTable from '@/pages/screen-drug-details/components/IpaAllTable';
import ScreenSTable from '@/pages/screen-drug-details/components/ScreenSTable';

const ScreenDrugDetails: React.FC = () => {
  const params = useParams();

  // @ts-ignore
  const drugId = params.id;

  const intl = useIntl();

  const [ipaAData, setIpaAData] = useState<IpaDiseaseAllType[]>([]);
  const [screenSData, setScreenSData] = useState<ScreenSType[]>([]);

  const [ipaSData, setIpaSData] = useState<IpaDiseaseSingleType>({
    dfunction: '',
    disease: '',
    drugbankId: '',
    gene: '',
  });

  const [screenDData, setScreenDData] = useState<ScreenDrugType>({
    absorption: '',
    casNumber: '',
    clearance: '',
    description: '',
    drugbankId: '',
    groups: '',
    halfLife: '',
    indication: '',
    manufacturers: '',
    metabolism: '',
    molecular: '',
    name: '',
    pharmacodynamics: '',
    proteinBinding: '',
    pubmedGene: '',
    routeOfElimination: '',
    synthesisReference: '',
    volumeOfDistribution: '',
  });

  const joinPub = (sd: ScreenSType[]) => {
    const sdd: (string | undefined)[] = [];
    sd.map((item) => {
      if (item.uniprotTgnameMedList !== '') {
        sdd.push(item.uniprotTgnameMedList);
      }
      if (item.alternativeNameMedList !== '') {
        sdd.push(item.alternativeNameMedList);
      }
      if (item.uniprotDiseaseMedList !== '') {
        sdd.push(item.uniprotDiseaseMedList);
      }
      if (item.uniprotGeneMedList !== '') {
        sdd.push(item.uniprotGeneMedList);
      }
      if (item.uniprotTgshortMedList !== '') {
        sdd.push(item.uniprotTgshortMedList);
      }
    });
    return sdd.join(',');
  };

  useEffect(() => {
    ipaDiseaseAllList(drugId).then((r) => {
      // @ts-ignore
      setIpaAData(r.data);
    });

    ipaDiseaseSingleList(drugId).then((r) => {
      // @ts-ignore
      setIpaSData(r.data);
    });

    getScreenDrug(drugId).then((r) => {
      // @ts-ignore
      setScreenDData(r.data);
    });

    getScreenS(drugId).then((r) => {
      // @ts-ignore
      setScreenSData(r.data);
    });

    // @ts-ignore
  }, [drugId, params.id]);

  return (
    <PageContainer>
      <GridContent>
        <Card title="Identification" style={{ marginBottom: 24 }}>
          <Row>
            <Col span={12}>
              <ProCard
                title={intl.formatMessage({
                  id: 'pages.prodescriptions.composition',
                  defaultMessage: 'Conformation',
                })}
                colSpan="50%"
              >
                {ipaAData !== null && ipaAData.length !== 0 ? (
                  <img
                    alt={`${screenDData.drugbankId}`}
                    src={`/redrugfiles/files/ipa_img/${screenDData.drugbankId}_600dpi.jpg`}
                    style={{ width: 500 }}
                  />
                ) : (
                  <img
                    alt={`${screenDData.drugbankId}`}
                    src={`/redrugfiles/files/ipa_img/${screenDData.drugbankId}_structure.png`}
                  />
                )}
              </ProCard>
            </Col>
            <Col span={12}>
              <ProCard
                title={intl.formatMessage({
                  id: 'pages.prodescriptions.info',
                  defaultMessage: 'Enquiry form',
                })}
              >
                <Descriptions bordered layout={'vertical'}>
                  <Descriptions.Item label="DrugBank ID">
                    {screenDData.drugbankId}
                  </Descriptions.Item>
                  <Descriptions.Item label="Name">{screenDData.name}</Descriptions.Item>
                  <Descriptions.Item label="Known As">
                    {screenDData.monoisotopicMass}
                  </Descriptions.Item>
                  <Descriptions.Item label="Group">{screenDData.groups}</Descriptions.Item>
                  <Descriptions.Item label="Molecular">{screenDData.molecular}</Descriptions.Item>
                  <Descriptions.Item label="AtomicN">{screenDData.atomicN}</Descriptions.Item>
                </Descriptions>
              </ProCard>
            </Col>
          </Row>
        </Card>
        <Card title="Pharmacology" style={{ marginBottom: 24 }} bordered={false}>
          {/* @ts-ignore */}
          <ScreenSTable data={screenSData} />
          {ipaAData !== null && ipaAData.length !== 0 ? (
            // @ts-ignore
            <IpaAllTable data={ipaAData} />
          ) : // @ts-ignore
          ipaSData !== '' && ipaSData !== null ? (
            <Descriptions bordered layout={'vertical'} column={1}>
              <Descriptions.Item label="DrugBank ID">{ipaSData.drugbankId}</Descriptions.Item>
              <Descriptions.Item label="Function">{ipaSData.dfunction}</Descriptions.Item>
              <Descriptions.Item label="Disease">{ipaSData.disease}</Descriptions.Item>
              <Descriptions.Item label="Gene">{ipaSData.gene}</Descriptions.Item>
            </Descriptions>
          ) : (
            <Empty />
          )}
        </Card>
        <Card title="Documents" style={{ marginBottom: 24 }} bordered={false}>
          <Descriptions bordered layout={'vertical'} column={1}>
            <Descriptions.Item label="PubMed">{joinPub(screenSData)}</Descriptions.Item>
          </Descriptions>
        </Card>
      </GridContent>
    </PageContainer>
  );
};

export default ScreenDrugDetails;
