import { GridContent, PageContainer, ProCard } from '@ant-design/pro-components';
import React, { useEffect, useState } from 'react';
// @ts-ignore
import { useIntl } from '@@/plugin-locale/localeExports';
import * as NGL from 'ngl';
import { getDrug } from '@/services/ant-design-pro/api';
import { useParams } from 'umi';
import { Button, Card, Col, Descriptions, Empty, Row, Space } from 'antd';
import { DownloadOutlined } from '@ant-design/icons';
import { drugPdb } from '@/services/ant-design-pro/drugPdbApi';
import DrugPdbTable from '@/pages/drug-details/components/DrugPdbTable';
import OldTargetsTable from '@/pages/drug-details/components/OldTargetsTable';
import { getPathway } from '@/services/ant-design-pro/pathwaysApi';
import PathwaysTable from '@/pages/drug-details/components/PathwaysTable';
type PathwaysType = {
  id: number;
  drugbankId: string;
  generalName: string;
  knownAs: string;
  passwayId: string;
  pathwayDesc: string;
  falseDiscoveryRate: string;
  labels: string;
  labelsIds: string;
  pdbids: string;
  pdbidsList: string;
  pdbidAll: string;
};

type Drugs = {
  drugbankId: string;
  generalName: string;
  knownAs: string;
  groups: string;
  molecular: string;
  atomicN: string;
  structure: string;
  manufacturers: string;
  indication: string;
  targets: string;
  uniprotId: string;
};

type DrugPdb = {
  id: number;
  drugbankId: string;
  pdbId: string;
  score: string;
  bindingRate: string;
};

const DrugDetails: React.FC = () => {
  const params = useParams();

  // @ts-ignore
  const drugId = params.id;

  const intl = useIntl();

  const [drugaData, setDrugData] = useState<Drugs>({
    drugbankId: '',
    generalName: '',
    knownAs: '',
    groups: '',
    molecular: '',
    atomicN: '',
    structure: '',
    manufacturers: '',
    indication: '',
    targets: '',
    uniprotId: '',
  });

  // @ts-ignore
  const [drugPdbData, setDrugPdbData] = useState<DrugPdb[]>([]);
  const [pathwaysData, setPathwaysData] = useState<PathwaysType[]>([]);

  const [dpLoading, setDpLoading] = useState(false);
  const [dgLoading, setDgLoading] = useState(false);

  const listTarget = (dgd: Drugs) => {
    const targetListAll = dgd.uniprotId.replace('[{', '').replace('}]', '').split('}, {');

    return targetListAll.map((v: string, i: number) => {
      const str = '{"id": "' + (i + 1) + '", ' + v.replaceAll("'", '"').replaceAll('，', ',') + '}';
      // @ts-ignore
      return JSON.parse(str);
    });
  };

  useEffect(() => {
    // create a `stage` object
    const stage = new NGL.Stage('viewport');
    // @ts-ignore
    stage.loadFile(`/redrugfiles/files/drugbank_sdf/${drugId}.sdf`).then(function (component) {
      // @ts-ignore
      component.addRepresentation('ball+stick');
      // @ts-ignore
      component.autoView();
    });

    getDrug({
      // @ts-ignore
      id: drugId,
    }).then((r) => {
      setDgLoading(true);
      // @ts-ignore
      setDrugData(r.data);
      setDgLoading(false);
    });

    drugPdb(drugId).then((r) => {
      setDpLoading(true);
      // @ts-ignore
      setDrugPdbData(r.data);
      setDpLoading(false);
    });

    getPathway(drugId).then((r) => {
      // @ts-ignore
      setPathwaysData(r.data);
    });
    // @ts-ignore
  }, [params.id]);

  return (
    <PageContainer>
      <GridContent>
        <Card title="Identification" style={{ marginBottom: 24 }}>
          <Row>
            <Col span={9}>
              <ProCard
                title={intl.formatMessage({
                  id: 'pages.prodescriptions.composition',
                  defaultMessage: 'Conformation',
                })}
                colSpan="50%"
              >
                <div id="viewport" style={{ width: '35vh', height: '35vh' }} />
              </ProCard>
            </Col>
            <Col span={15}>
              <ProCard
                title={intl.formatMessage({
                  id: 'pages.prodescriptions.info',
                  defaultMessage: 'Information',
                })}
              >
                <Descriptions bordered layout={'vertical'}>
                  <Descriptions.Item label="DrugBank ID">{drugaData.drugbankId}</Descriptions.Item>
                  <Descriptions.Item label="Name">{drugaData.generalName}</Descriptions.Item>
                  <Descriptions.Item label="Known As">{drugaData.knownAs}</Descriptions.Item>
                  <Descriptions.Item label="Group">{drugaData.groups}</Descriptions.Item>
                  <Descriptions.Item label="Molecular">{drugaData.molecular}</Descriptions.Item>
                  <Descriptions.Item label="AtomicN">{drugaData.atomicN}</Descriptions.Item>
                </Descriptions>
                <Space wrap>
                  <Button
                    type="primary"
                    icon={<DownloadOutlined />}
                    shape="round"
                    size={'large'}
                    style={{ marginTop: 24, width: 145 }}
                    href={`/redrugfiles/files/drugbank_sdf/${drugId}.sdf`}
                  >
                    SDF File
                  </Button>
                  <Button
                    type="primary"
                    icon={<DownloadOutlined />}
                    shape="round"
                    size={'large'}
                    style={{ marginTop: 24, width: 145 }}
                    href={`/redrugfiles/files/drugbank_pdbqt/${drugId}.pdbqt`}
                  >
                    PDBQT File
                  </Button>
                </Space>
              </ProCard>
            </Col>
          </Row>
        </Card>
        <Card title="Molecular Docking" style={{ marginBottom: 24 }} bordered={false}>
          {/*@ts-ignore*/}
          <DrugPdbTable data={drugPdbData} loading={dpLoading} />
        </Card>
        <Card title="Molecular Dynamics Simulation" style={{ marginBottom: 24 }} bordered={false}>
          <Empty />
        </Card>
        <Card title="Pharmacology" style={{ marginBottom: 24 }} bordered={false}>
          {/*@ts-ignore*/}
          <Descriptions style={{ marginBottom: 24 }} column={1} bordered>
            <Descriptions.Item label="Manufacturers">{drugaData.manufacturers}</Descriptions.Item>
            <Descriptions.Item label="Indication">{drugaData.indication}</Descriptions.Item>
          </Descriptions>
          {drugaData.uniprotId === '' ? (
            // @ts-ignore
            <OldTargetsTable data={[]} loading={dgLoading} />
          ) : (
            // @ts-ignore
            <OldTargetsTable data={listTarget(drugaData)} loading={dgLoading} />
          )}
        </Card>
        <Card title="Pathways" style={{ marginBottom: 24 }} bordered={false}>
          {/*@ts-ignore*/}
          <PathwaysTable data={pathwaysData} />
          <Descriptions
            style={{ marginBottom: 24 }}
            column={1}
            bordered
            layout={'vertical'}
            title={'Target in the pathways'}
          >
            {pathwaysData.length != null && pathwaysData.length > 0 ? (
              <Descriptions.Item label="PDB">
                {pathwaysData[0].pdbidAll.replaceAll('[', '').replaceAll(']', '') !== '' ? (
                  pathwaysData[0].pdbidAll
                    .replaceAll('[', '')
                    .replaceAll(']', '')
                    .replaceAll("'", '')
                ) : (
                  <Empty />
                )}
              </Descriptions.Item>
            ) : (
              <Descriptions.Item label="PDB">
                <Empty />
              </Descriptions.Item>
            )}
          </Descriptions>
        </Card>
      </GridContent>
    </PageContainer>
  );
};

export default DrugDetails;
