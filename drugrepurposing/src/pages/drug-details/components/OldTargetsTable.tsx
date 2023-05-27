import React from 'react';
import type { ProColumns } from '@ant-design/pro-components';
import { ProTable } from '@ant-design/pro-components';
type OldTarget = {
  id: number;
  uniprotid: string;
  target: string;
  genename: string;
};

const columns: ProColumns<OldTarget>[] = [
  {
    dataIndex: 'index',
    valueType: 'indexBorder',
    width: 100,
    align: 'center',
  },
  {
    title: 'UniProt ID',
    dataIndex: 'uniprotid',
    key: 'id',
    align: 'center',
  },
  {
    title: 'Name',
    dataIndex: 'target',
    key: 'id',
    align: 'center',
  },
  {
    title: 'Gene',
    dataIndex: 'genename',
    key: 'id',
    align: 'center',
  },
];

// @ts-ignore
const OldTargetsTable: React.FC = ({ data, loading, style }) => {
  return (
    <ProTable<OldTarget>
      columns={columns}
      dataSource={data}
      loading={loading}
      pagination={false}
      style={style}
      search={false}
      headerTitle="Targets"
    />
  );
};

export default OldTargetsTable;
