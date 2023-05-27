import React from 'react';
import type { ProColumns } from '@ant-design/pro-components';
import { ProTable } from '@ant-design/pro-components';
import { Button } from 'antd';
type DrugPdb = {
  id: number;
  drugbankId: string;
  pdbId: string;
  score: string;
  bindingRate: string;
};

const columns: ProColumns<DrugPdb>[] = [
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
    title: 'PDB ID',
    dataIndex: 'pdbId',
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
  },
];

// @ts-ignore
const DrugPdbTable: React.FC = ({ data, loading, style }) => (
  <ProTable<DrugPdb>
    columns={columns}
    dataSource={data}
    loading={loading}
    pagination={false}
    style={style}
    search={false}
    headerTitle="Top 10"
    toolbar={{
      actions: [
        data.length > 0 ? (
          <Button key="list" type="primary" href={`/dockdrug/${data[0].drugbankId}`}>
            More
          </Button>
        ) : (
          <>
            <Button key="list" type="primary">
              More
            </Button>
          </>
        ),
      ],
    }}
  />
);

export default DrugPdbTable;
