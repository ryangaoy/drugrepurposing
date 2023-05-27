import { PlusOutlined } from '@ant-design/icons';
import type { ActionType, ProColumns, ProDescriptionsItemProps } from '@ant-design/pro-components';
import {
  FooterToolbar,
  ModalForm,
  PageContainer,
  ProBreadcrumb,
  ProDescriptions,
  ProFormText,
  ProFormTextArea,
  ProTable,
} from '@ant-design/pro-components';
import { Button, Drawer } from 'antd';
import React, { useRef, useState } from 'react';
import { FormattedMessage, useIntl } from 'umi';
import UpdateForm from './components/UpdateForm';
import { getMdPage } from '@/pages/md/service';
import type { MdPageDataType, MdReqPageType } from '@/pages/md/data';

const MD: React.FC = () => {
  /**
   * @en-US Pop-up window of new window
   * @zh-CN 新建窗口的弹窗
   *  */
  const [createModalVisible, handleModalVisible] = useState<boolean>(false);
  /**
   * @en-US The pop-up window of the distribution update window
   * @zh-CN 分布更新窗口的弹窗
   * */
  const [updateModalVisible, handleUpdateModalVisible] = useState<boolean>(false);

  const [showDetail, setShowDetail] = useState<boolean>(false);

  const actionRef = useRef<ActionType>();
  const [currentRow, setCurrentRow] = useState<API.RuleListItem>();
  // @ts-ignore
  const [selectedRowsState, setSelectedRows] = useState<API.RuleListItem[]>([]);

  /**
   * @en-US International configuration
   * @zh-CN 国际化配置
   * */
  const intl = useIntl();

  const columns: ProColumns<MdPageDataType>[] = [
    // {
    //   title: <FormattedMessage id="pages.searchTable.titleDesc" defaultMessage="ID" />,
    //   dataIndex: 'id',
    //   valueType: 'textarea',
    // },
    {
      title: 'ID',
      dataIndex: 'id',
      valueType: 'textarea',
    },
    {
      title: 'Drugbank ID',
      dataIndex: 'drugbankId',
      valueType: 'textarea',
    },
    {
      title: 'Protein Name',
      dataIndex: 'proteinNames',
      valueType: 'textarea',
      width: 400,
    },
    {
      title: 'Length',
      dataIndex: 'lengths',
      valueType: 'textarea',
    },
    {
      title: 'Organism',
      dataIndex: 'organism',
      valueType: 'textarea',
    },
    {
      title: 'Entry Name',
      dataIndex: 'entrys',
      valueType: 'textarea',
    },
    {
      title: <FormattedMessage id="pages.searchTable.titleOption" defaultMessage="Operating" />,
      dataIndex: 'option',
      valueType: 'option',
      render: (_, record) => [
        // <a key="detail" href="https://procomponents.ant.design/">
        // @ts-ignore
        <a key="detail" href={`/mddetail/${btoa(record.drugbankId + '_' + record.pdb)}`}>
          <FormattedMessage id="pages.searchTable.detail" defaultMessage="Subscribe to alerts" />
        </a>,
      ],
    },
  ];

  return (
    <PageContainer pageHeaderRender={() => {}}>
      <div style={{ paddingBottom: 24 }}>
        <ProBreadcrumb separator={'>'} style={{ maxWidth: 1200 }} />
      </div>
      <ProTable<MdPageDataType, MdReqPageType>
        headerTitle={'Enquiry'}
        actionRef={actionRef}
        size={'large'}
        rowKey="id"
        search={{
          labelWidth: 120,
        }}
        toolBarRender={() => [
          <Button
            type="primary"
            key="primary"
            onClick={() => {
              handleModalVisible(true);
            }}
          >
            <PlusOutlined /> <FormattedMessage id="pages.searchTable.new" defaultMessage="New" />
          </Button>,
        ]}
        // @ts-ignore
        request={async (
          params: MdPageDataType & {
            pageSize: number;
            current: number;
          },
        ) => {
          const r = await getMdPage({
            id: params.id,
            drugbankId: params.drugbankId,
            entrys: params.entrys,
            proteinNames: params.proteinNames,
            pdb: params.pdb,
            uniprotId: params.uniprotId,
            organism: params.organism,
            lengths: params.lengths,
            pageNo: params.current,
            pageSize: params.pageSize,
          });
          return {
            data: r.data?.list,
            // success 请返回 true，
            // 不然 table 会停止解析数据，即使有数据
            // @ts-ignore
            success: r.data?.list.length > 0,
            // 不传会使用 data 的长度，如果是分页一定要传
            total: r.data?.total,
          };
        }}
        columns={columns}
        // rowSelection={{
        //   onChange: (_, selectedRows) => {
        //     setSelectedRows(selectedRows);
        //   },
        // }}
        pagination={{
          position: ['topRight', 'bottomRight'],
        }}
      />
      {selectedRowsState?.length > 0 && (
        <FooterToolbar
          extra={
            <div>
              <FormattedMessage id="pages.searchTable.chosen" defaultMessage="Chosen" />{' '}
              <a style={{ fontWeight: 600 }}>{selectedRowsState.length}</a>{' '}
              <FormattedMessage id="pages.searchTable.item" defaultMessage="项" />
              &nbsp;&nbsp;
              <span>
                <FormattedMessage
                  id="pages.searchTable.totalServiceCalls"
                  defaultMessage="Total number of service calls"
                />{' '}
                {selectedRowsState.reduce((pre, item) => pre + item.callNo!, 0)}{' '}
                <FormattedMessage id="pages.searchTable.tenThousand" defaultMessage="万" />
              </span>
            </div>
          }
        >
          <Button onClick={async () => {}}>
            <FormattedMessage
              id="pages.searchTable.batchDeletion"
              defaultMessage="Batch deletion"
            />
          </Button>
          <Button type="primary">
            <FormattedMessage
              id="pages.searchTable.batchApproval"
              defaultMessage="Batch approval"
            />
          </Button>
        </FooterToolbar>
      )}
      <ModalForm
        title={intl.formatMessage({
          id: 'pages.searchTable.createForm.newRule',
          defaultMessage: 'New rule',
        })}
        width="400px"
        visible={createModalVisible}
        onVisibleChange={handleModalVisible}
        onFinish={async () => {}}
      >
        <ProFormText
          rules={[
            {
              required: true,
              message: (
                <FormattedMessage
                  id="pages.searchTable.ruleName"
                  defaultMessage="Rule name is required"
                />
              ),
            },
          ]}
          width="md"
          name="name"
        />
        <ProFormTextArea width="md" name="desc" />
      </ModalForm>
      <UpdateForm
        onSubmit={async () => {}}
        onCancel={() => {
          handleUpdateModalVisible(false);
          if (!showDetail) {
            setCurrentRow(undefined);
          }
        }}
        updateModalVisible={updateModalVisible}
        values={currentRow || {}}
      />

      <Drawer
        width={600}
        open={showDetail}
        onClose={() => {
          setCurrentRow(undefined);
          setShowDetail(false);
        }}
        closable={false}
      >
        {currentRow?.name && (
          <ProDescriptions<API.RuleListItem>
            column={2}
            title={currentRow?.name}
            request={async () => ({
              data: currentRow || {},
            })}
            params={{
              id: currentRow?.name,
            }}
            columns={columns as ProDescriptionsItemProps<API.RuleListItem>[]}
          />
        )}
      </Drawer>
    </PageContainer>
  );
};

export default MD;
