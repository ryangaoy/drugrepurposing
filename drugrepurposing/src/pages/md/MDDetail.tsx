import { GridContent, PageContainer, ProCard } from '@ant-design/pro-components';
import React, { useEffect, useState } from 'react';
import * as NGL from 'ngl';
// @ts-ignore
import { useIntl } from '@@/plugin-locale/localeExports';
import { useParams } from 'umi';
import { getDrug } from '@/services/ant-design-pro/api';
import { getPdb } from '@/services/ant-design-pro/pdbApi';
import { Card, Col, Descriptions, Row } from 'antd';
import PdbInfoTable from '@/pages/md/components/PdbInfoTable';

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

const MDDetail: React.FC = () => {
  const intl = useIntl();
  const params = useParams();

  // @ts-ignore
  const basestring = params.id;

  const dec = atob(basestring);
  const [drugid] = useState(dec.split('_')[0]);
  const [pdbid] = useState(dec.split('_')[1]);

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
  const [loading, setLoading] = useState(false);

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
                  defaultMessage: 'Enquiry form',
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
              </ProCard>
            </Col>
          </Row>
        </Card>
        <Card title="Results" style={{ marginBottom: 24 }} bordered={false}>
          {/*@ts-ignore*/}
          <PdbInfoTable data={pdbData} loading={loading} />
          <Descriptions bordered layout={'vertical'} column={1}>
            <Descriptions.Item label="RMSD">
              <img
                alt={'md'}
                src={`/redrugfiles/files/md_img/${drugid}_${pdbid}/rmsd_l.png`}
                style={{ width: 500 }}
              />
              <img
                alt={'md'}
                src={`/redrugfiles/files/md_img/${drugid}_${pdbid}/rmsd_r.png`}
                style={{ width: 500 }}
              />
              <img
                alt={'md'}
                src={`/redrugfiles/files/md_img/${drugid}_${pdbid}/rmsd_all.png`}
                style={{ width: 500 }}
              />
            </Descriptions.Item>
            <Descriptions.Item label="RMSF">
              <img
                alt={'md'}
                src={`/redrugfiles/files/md_img/${drugid}_${pdbid}/rmsf_l.png`}
                style={{ width: 500 }}
              />
              <img
                alt={'md'}
                src={`/redrugfiles/files/md_img/${drugid}_${pdbid}/rmsf_r.png`}
                style={{ width: 500 }}
              />
              <img
                alt={'md'}
                src={`/redrugfiles/files/md_img/${drugid}_${pdbid}/rmsf_all.png`}
                style={{ width: 500 }}
              />
            </Descriptions.Item>
            <Descriptions.Item label="Hydrogen Bonds">
              <img
                alt={'md'}
                src={`/redrugfiles/files/md_img/${drugid}_${pdbid}/hbond_ac.png`}
                style={{ width: 500 }}
              />
              <img
                alt={'md'}
                src={`/redrugfiles/files/md_img/${drugid}_${pdbid}/hbond_life.png`}
                style={{ width: 500 }}
              />
              <img
                alt={'md'}
                src={`/redrugfiles/files/md_img/${drugid}_${pdbid}/hbond_num.png`}
                style={{ width: 500 }}
              />
            </Descriptions.Item>
            <Descriptions.Item label="Radius of Gyration">
              <img
                alt={'md'}
                src={`/redrugfiles/files/md_img/${drugid}_${pdbid}/gyrate_l.png`}
                style={{ width: 500 }}
              />
              <img
                alt={'md'}
                src={`/redrugfiles/files/md_img/${drugid}_${pdbid}/gyrate_r.png`}
                style={{ width: 500 }}
              />
              <img
                alt={'md'}
                src={`/redrugfiles/files/md_img/${drugid}_${pdbid}/gyrate_all.png`}
                style={{ width: 500 }}
              />
            </Descriptions.Item>
            <Descriptions.Item label="Energy">
              <img
                alt={'md'}
                src={`/redrugfiles/files/md_img/${drugid}_${pdbid}/energy.png`}
                style={{ width: 500 }}
              />
              <img
                alt={'md'}
                src={`/redrugfiles/files/md_img/${drugid}_${pdbid}/sham.png`}
                style={{ width: 500 }}
              />
            </Descriptions.Item>
          </Descriptions>
        </Card>
      </GridContent>
    </PageContainer>
  );
};

export default MDDetail;
