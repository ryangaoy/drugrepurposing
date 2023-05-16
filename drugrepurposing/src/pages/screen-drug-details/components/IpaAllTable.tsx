import React from 'react';
import type { ProColumns } from '@ant-design/pro-components';
import { ProTable } from '@ant-design/pro-components';
import type { IpaDiseaseAllType } from '@/pages/screen-drug-details/data';

const columns: ProColumns<IpaDiseaseAllType>[] = [
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
    title: 'fromM',
    dataIndex: 'fromM',
    key: 'id',
    align: 'center',
  },
  {
    title: 'typeM',
    dataIndex: 'typeM',
    key: 'id',
    align: 'center',
  },
  {
    title: 'toM',
    dataIndex: 'toM',
    key: 'id',
    align: 'center',
  },
  {
    title: 'catalyst',
    dataIndex: 'catalyst',
    key: 'id',
    align: 'center',
  },
];

// @ts-ignore
const IpaAllTable: React.FC = ({ data, loading, style }) => (
  <ProTable<IpaDiseaseAllType>
    columns={columns}
    dataSource={data}
    loading={loading}
    pagination={false}
    style={style}
    search={false}
    headerTitle="IPA Disease"
  />
);

export default IpaAllTable;
