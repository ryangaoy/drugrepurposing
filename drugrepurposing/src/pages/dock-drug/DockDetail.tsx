import { GridContent, PageContainer, ProCard } from '@ant-design/pro-components';
import React, { useEffect, useState } from 'react';
// @ts-ignore
import { useIntl } from '@@/plugin-locale/localeExports';
import * as NGL from 'ngl';
import { useParams } from 'umi';
import { getDrug } from '@/services/ant-design-pro/api';
import { Button, Card, Col, Descriptions, Empty, List, Row, Space } from 'antd';
import { getPdb } from '@/services/ant-design-pro/pdbApi';
import { DownloadOutlined } from '@ant-design/icons';

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

type pdbType = {
  id: number;
  pdb: string;
  uniprotId: string;
  geneNames: string;
  organism: string;
  proteinNames: string;
  lengths: string;
  ecNumber: string;
  functions: string;
  pubmedId: string;
  entrys: string;
};

const DockDetail: React.FC = () => {
  const [loading, setLoading] = useState(false);
  const intl = useIntl();

  const params = useParams();

  // @ts-ignore
  const basestring = params.id;

  const dec = atob(basestring);

  const [pdbid] = useState(dec.split('&&&&')[0].substring(0, 4));
  const [drugid] = useState(dec.split('&&&&')[1].substring(0, 7));

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

  const [pdbData, setPdbData] = useState<pdbType[]>([]);

  useEffect(() => {
    // create a `stage` object
    const stage = new NGL.Stage('viewport');
    // stage.loadFile("rcsb://"+pdbid).then(function (component) {
    stage.loadFile(`/redrugfiles/files/drugbank_pdbqt/${drugid}.pdbqt`).then(function (component) {
      // @ts-ignore
      component.addRepresentation('ball+stick');
      // @ts-ignore
      component.autoView();
    });

    getDrug({
      id: drugid,
    }).then((r) => {
      // @ts-ignore
      setDrugData(r.data);
    });

    getPdb({
      id: pdbid,
    }).then((r) => {
      setLoading(true);
      // @ts-ignore
      setPdbData(r.data);
      setLoading(false);
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
                    href={`/redrugfiles/files/drugbank_pdbqt/${drugid}.pdbqt`}
                  >
                    Drug File
                  </Button>
                  <Button
                    type="primary"
                    icon={<DownloadOutlined />}
                    shape="round"
                    size={'large'}
                    style={{ marginTop: 24, width: 145 }}
                    href={`/redrugfiles/files/protein_pdbqt/${pdbid}_pro.pdbqt`}
                  >
                    Protein File
                  </Button>
                  <Button
                    type="primary"
                    icon={<DownloadOutlined />}
                    shape="round"
                    size={'large'}
                    style={{ marginTop: 24, width: 145 }}
                    href={`/redrugfiles/files/protein_config/${pdbid}_pro.in`}
                  >
                    Config File
                  </Button>
                </Space>
              </ProCard>
            </Col>
          </Row>
        </Card>
        <Card title="Target" style={{ marginBottom: 24 }} bordered={false}>
          {pdbData.length > 0 ? (
            <List<pdbType>
              size="large"
              loading={loading}
              rowKey="id"
              itemLayout="vertical"
              loadMore={false}
              dataSource={pdbData}
              renderItem={(item, index) => (
                <List.Item
                  key={item.id}
                  style={index === 0 ? { marginTop: 24, borderTop: '1px solid #eaeaea' } : {}}
                >
                  <Descriptions bordered layout={'vertical'}>
                    <Descriptions.Item label="Entry">{item.entrys}</Descriptions.Item>
                    <Descriptions.Item label="Organism">{item.organism}</Descriptions.Item>
                    <Descriptions.Item label="Function">{item.functions}</Descriptions.Item>
                    <Descriptions.Item label="Pubmed ID">{item.pubmedId}</Descriptions.Item>
                  </Descriptions>
                </List.Item>
              )}
            />
          ) : (
            <Empty />
          )}
        </Card>
      </GridContent>
    </PageContainer>
  );
};

export default DockDetail;
