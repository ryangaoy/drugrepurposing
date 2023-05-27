import React from 'react';
import type { ProColumns } from '@ant-design/pro-components';
import { ProTable } from '@ant-design/pro-components';
import type { ScreenSType } from '@/pages/screen-drug-details/data';

const columns: ProColumns<ScreenSType>[] = [
  {
    dataIndex: 'index',
    valueType: 'indexBorder',
    width: 100,
    align: 'center',
  },
  {
    title: 'Drugbank ID',
    dataIndex: 'drugbankId',
    key: 'id',
    align: 'center',
  },
  {
    title: 'Uniprot ID',
    dataIndex: 'uniprotId',
    key: 'id',
    align: 'center',
  },
  {
    title: 'Protein Name',
    dataIndex: 'tgname',
    key: 'id',
    align: 'center',
  },
  {
    title: 'PDB',
    dataIndex: 'pdbid',
    key: 'id',
    align: 'center',
  },
  {
    title: 'Score',
    dataIndex: 'score',
    key: 'id',
    align: 'center',
  },
  {
    title: 'Binding Rate',
    dataIndex: 'bindingRate',
    key: 'id',
    align: 'center',
    render: (_, record) => (
      // @ts-ignore
      <>{record.bindingRate.toFixed(2)}</>
    ),
  },
];

// @ts-ignore
const IpaAllTable: React.FC = ({ data, loading, style }) => (
  <ProTable<ScreenSType>
    columns={columns}
    dataSource={data}
    loading={loading}
    pagination={false}
    style={style}
    search={false}
    headerTitle="Screen Results"
  />
);

export default IpaAllTable;
