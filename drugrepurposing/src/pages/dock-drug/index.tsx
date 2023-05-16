import { addRule, dockByDrug, removeRule, updateRule } from '@/services/ant-design-pro/api';
import { PlusOutlined } from '@ant-design/icons';
import type { ActionType, ProColumns } from '@ant-design/pro-components';
import {
  FooterToolbar,
  ModalForm,
  PageContainer,
  ProFormText,
  ProFormTextArea,
  ProTable,
} from '@ant-design/pro-components';
import { Button, message } from 'antd';
import React, { useRef, useState } from 'react';
import { FormattedMessage, useIntl, useParams } from 'umi';
import UpdateForm from './components/UpdateForm';

/**
 * @en-US Add node
 * @zh-CN 添加节点
 * @param fields
 */
const handleAdd = async (fields: API.DockListItem) => {
  const hide = message.loading('正在添加');
  try {
    await addRule({ ...fields });
    hide();
    message.success('Added successfully');
    return true;
  } catch (error) {
    hide();
    message.error('Adding failed, please try again!');
    return false;
  }
};

/**
 * @en-US Update node
 * @zh-CN 更新节点
 *
 * @param fields
 */
const handleUpdate = async (fields: Partial<API.RuleListItem>) => {
  const hide = message.loading('Configuring');
  try {
    await updateRule({
      name: fields.name,
      desc: fields.desc,
      key: fields.key,
    });
    hide();

    message.success('Configuration is successful');
    return true;
  } catch (error) {
    hide();
    message.error('Configuration failed, please try again!');
    return false;
  }
};

/**
 *  Delete node
 * @zh-CN 删除节点
 *
 * @param selectedRows
 */
const handleRemove = async (selectedRows: API.DockListItem[]) => {
  const hide = message.loading('正在删除');
  if (!selectedRows) return true;
  try {
    await removeRule({
      key: selectedRows.map((row) => row._id),
    });
    hide();
    message.success('Deleted successfully and will refresh soon');
    return true;
  } catch (error) {
    hide();
    message.error('Delete failed, please try again');
    return false;
  }
};

const TableList: React.FC = () => {
  const paramss = useParams();
  // @ts-ignore
  const drugId = paramss.id;

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

  const [showDetail] = useState<boolean>(false);

  const actionRef = useRef<ActionType>();
  const [currentRow, setCurrentRow] = useState<API.DockListItem>();
  const [selectedRowsState, setSelectedRows] = useState<API.DockListItem[]>([]);

  /**
   * @en-US International configuration
   * @zh-CN 国际化配置
   * */
  const intl = useIntl();

  const columns: ProColumns<API.DockListItem>[] = [
    // {
    //   title: (
    //     <FormattedMessage
    //       id="pages.searchTable.updateForm.ruleName.nameLabel"
    //       defaultMessage="Rule name"
    //     />
    //   ),
    //   dataIndex: 'target',
    //   tip: 'The rule name is the unique key',
    //   render: (dom, entity) => {
    //     return (
    //       <a
    //         onClick={() => {
    //           setCurrentRow(entity);
    //           setShowDetail(true);
    //         }}
    //       >
    //         {dom}
    //       </a>
    //     );
    //   },
    // },
    {
      title: 'Ligand ID',
      dataIndex: 'ligand_id',
      valueType: 'textarea',
      render: (_, record) => <>{record.ligand_id?.substring(0, 7)}</>,
    },
    {
      title: 'Target ID',
      dataIndex: 'target_id',
      valueType: 'textarea',
      render: (_, record) => <>{record.target_id?.substring(0, 4).toUpperCase()}</>,
    },
    {
      title: 'Score',
      dataIndex: 'score',
      valueType: 'textarea',
    },
    {
      title: 'Efficiency',
      dataIndex: 'efficiency',
      valueType: 'textarea',
    },
    // {
    //   title: (
    //     <FormattedMessage
    //       id="pages.searchTable.titleCallNo"
    //       defaultMessage="Number of service calls"
    //     />
    //   ),
    //   dataIndex: 'callNo',
    //   sorter: true,
    //   hideInForm: true,
    //   renderText: (val: string) =>
    //     `${val}${intl.formatMessage({
    //       id: 'pages.searchTable.tenThousand',
    //       defaultMessage: ' 万 ',
    //     })}`,
    // },
    // {
    //   title: <FormattedMessage id="pages.searchTable.titleStatus" defaultMessage="Status" />,
    //   dataIndex: 'status',
    //   hideInForm: true,
    //   valueEnum: {
    //     0: {
    //       text: (
    //         <FormattedMessage
    //           id="pages.searchTable.nameStatus.default"
    //           defaultMessage="Shut down"
    //         />
    //       ),
    //       status: 'Default',
    //     },
    //     1: {
    //       text: (
    //         <FormattedMessage id="pages.searchTable.nameStatus.running" defaultMessage="Running" />
    //       ),
    //       status: 'Processing',
    //     },
    //     2: {
    //       text: (
    //         <FormattedMessage id="pages.searchTable.nameStatus.online" defaultMessage="Online" />
    //       ),
    //       status: 'Success',
    //     },
    //     3: {
    //       text: (
    //         <FormattedMessage
    //           id="pages.searchTable.nameStatus.abnormal"
    //           defaultMessage="Abnormal"
    //         />
    //       ),
    //       status: 'Error',
    //     },
    //   },
    // },
    // {
    //   title: (
    //     <FormattedMessage
    //       id="pages.searchTable.titleUpdatedAt"
    //       defaultMessage="Last scheduled time"
    //     />
    //   ),
    //   sorter: true,
    //   dataIndex: 'updatedAt',
    //   valueType: 'dateTime',
    //   renderFormItem: (item, { defaultRender, ...rest }, form) => {
    //     const status = form.getFieldValue('status');
    //     if (`${status}` === '0') {
    //       return false;
    //     }
    //     if (`${status}` === '3') {
    //       return (
    //         <Input
    //           {...rest}
    //           placeholder={intl.formatMessage({
    //             id: 'pages.searchTable.exception',
    //             defaultMessage: 'Please enter the reason for the exception!',
    //           })}
    //         />
    //       );
    //     }
    //     return defaultRender(item);
    //   },
    // },
    {
      title: <FormattedMessage id="pages.searchTable.titleOption" defaultMessage="Operating" />,
      dataIndex: 'option',
      valueType: 'option',
      render: (_, record) => [
        // <a key="detail" href="https://procomponents.ant.design/">
        // @ts-ignore
        <a key="detail" href={`/dock/${btoa(record.result_id)}`}>
          <FormattedMessage id="pages.searchTable.detail" defaultMessage="Subscribe to alerts" />
        </a>,
      ],
    },
  ];

  return (
    <PageContainer>
      <ProTable<API.DockListItem, API.PageParams>
        headerTitle={intl.formatMessage({
          id: 'pages.searchTable.title',
          defaultMessage: 'Enquiry form',
        })}
        actionRef={actionRef}
        rowKey="_id"
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
        //@ts-ignore
        request={async (
          // 第一个参数 params 查询表单和 params 参数的结合
          // 第一个参数中一定会有 pageSize 和  current ，这两个参数是 antd 的规范
          params: {
            id: string;
            pageSize: number;
            current: number;
          },
          sort,
          filter,
        ) => {
          // 这里需要返回一个 Promise,在返回之前你可以进行数据转化
          // 如果需要转化参数可以在这里进行修改
          const msg = await dockByDrug({
            id: drugId,
            current: params.current,
            pageSize: params.pageSize,
          });
          return {
            data: msg.data?.data,
            // success 请返回 true，
            // 不然 table 会停止解析数据，即使有数据
            success: msg.data?.success,
            // 不传会使用 data 的长度，如果是分页一定要传
            total: msg.data?.total,
          };
        }}
        columns={columns}
        // pagination={{
        //   pageSize: 20,
        //   onChange: (page) => console.log(page),
        // }}
        rowSelection={{
          onChange: (_, selectedRows) => {
            setSelectedRows(selectedRows);
          },
        }}
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
              {/*<span>*/}
              {/*  <FormattedMessage*/}
              {/*    id="pages.searchTable.totalServiceCalls"*/}
              {/*    defaultMessage="Total number of service calls"*/}
              {/*  />{' '}*/}
              {/*  {selectedRowsState.reduce((pre, item) => pre + item.callNo!, 0)}{' '}*/}
              {/*  <FormattedMessage id="pages.searchTable.tenThousand" defaultMessage="万" />*/}
              {/*</span>*/}
            </div>
          }
        >
          <Button
            onClick={async () => {
              await handleRemove(selectedRowsState);
              setSelectedRows([]);
              actionRef.current?.reloadAndRest?.();
            }}
          >
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
        onFinish={async (value) => {
          const success = await handleAdd(value as API.RuleListItem);
          if (success) {
            handleModalVisible(false);
            if (actionRef.current) {
              actionRef.current.reload();
            }
          }
        }}
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
        onSubmit={async (value) => {
          const success = await handleUpdate(value);
          if (success) {
            handleUpdateModalVisible(false);
            setCurrentRow(undefined);
            if (actionRef.current) {
              actionRef.current.reload();
            }
          }
        }}
        onCancel={() => {
          handleUpdateModalVisible(false);
          if (!showDetail) {
            setCurrentRow(undefined);
          }
        }}
        updateModalVisible={updateModalVisible}
        values={currentRow || {}}
      />

      {/*<Drawer*/}
      {/*  width={600}*/}
      {/*  visible={showDetail}*/}
      {/*  onClose={() => {*/}
      {/*    setCurrentRow(undefined);*/}
      {/*    setShowDetail(false);*/}
      {/*  }}*/}
      {/*  closable={false}*/}
      {/*>*/}
      {/*  {currentRow?.name && (*/}
      {/*    <ProDescriptions<API.RuleListItem>*/}
      {/*      column={2}*/}
      {/*      title={currentRow?.name}*/}
      {/*      request={async () => ({*/}
      {/*        data: currentRow || {},*/}
      {/*      })}*/}
      {/*      params={{*/}
      {/*        id: currentRow?.name,*/}
      {/*      }}*/}
      {/*      columns={columns as ProDescriptionsItemProps<API.RuleListItem>[]}*/}
      {/*    />*/}
      {/*  )}*/}
      {/*</Drawer>*/}
    </PageContainer>
  );
};

export default TableList;
