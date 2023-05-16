import React from 'react';
import type { ProColumns } from '@ant-design/pro-components';
import { ProTable } from '@ant-design/pro-components';
type OldTarget = {
  id: number;
  pdb: string;
  geneNames: string;
  uniprotid: string;
  ecNumber: string;
  lengths: string;
  entrys: string;
};

const columns: ProColumns<OldTarget>[] = [
  {
    dataIndex: 'index',
    valueType: 'indexBorder',
    width: 100,
    align: 'center',
  },
  {
    title: 'PDB',
    dataIndex: 'pdb',
    key: 'id',
    align: 'center',
  },
  {
    title: 'UniProt ID',
    dataIndex: 'uniprotId',
    key: 'id',
    align: 'center',
  },
  {
    title: 'Name',
    dataIndex: 'entrys',
    key: 'id',
    align: 'center',
  },
  {
    title: 'Length',
    dataIndex: 'lengths',
    key: 'id',
    align: 'center',
  },
  {
    title: 'Gene',
    dataIndex: 'geneNames',
    key: 'id',
    align: 'center',
  },
  {
    title: 'EC Number',
    dataIndex: 'ecNumber',
    key: 'id',
    align: 'center',
  },
];

// @ts-ignore
const PdbInfoTable: React.FC = ({ data, loading, style }) => {
  return (
    <ProTable<OldTarget>
      columns={columns}
      dataSource={data}
      loading={loading}
      pagination={false}
      style={style}
      search={false}
      headerTitle="Target"
    />
  );
};

export default PdbInfoTable;
