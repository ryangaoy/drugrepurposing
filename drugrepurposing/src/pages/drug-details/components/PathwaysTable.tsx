import React from 'react';
import type { ProColumns } from '@ant-design/pro-components';
import { ProTable } from '@ant-design/pro-components';
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

const columns: ProColumns<PathwaysType>[] = [
  {
    dataIndex: 'index',
    valueType: 'indexBorder',
    width: 100,
    align: 'center',
  },
  {
    title: 'Passway ID',
    dataIndex: 'passwayId',
    key: 'id',
    align: 'center',
  },
  {
    title: 'Pathway Description',
    dataIndex: 'pathwayDesc',
    key: 'id',
    align: 'center',
  },
  {
    title: 'False Discovery Rate',
    dataIndex: 'falseDiscoveryRate',
    key: 'id',
    align: 'center',
  },
  {
    title: 'Labels',
    dataIndex: 'labels',
    key: 'id',
    align: 'center',
    render: (_, item) => {
      return item.labels.replaceAll(',', '\n');
    },
  },
];

// @ts-ignore
const PathwaysTable: React.FC = ({ data, loading, style }) => (
  <ProTable<PathwaysType>
    columns={columns}
    dataSource={data}
    loading={loading}
    pagination={false}
    style={style}
    search={false}
    headerTitle="Top 10"
  />
);

export default PathwaysTable;
