import { ProFormText, ProFormTextArea, StepsForm } from '@ant-design/pro-components';
import { Modal } from 'antd';
import React from 'react';
import { FormattedMessage, useIntl } from 'umi';

export type FormValueType = {
  target?: string;
  template?: string;
  type?: string;
  time?: string;
  frequency?: string;
} & Partial<API.RuleListItem>;

export type UpdateFormProps = {
  onCancel: (flag?: boolean, formVals?: Partial<API.RuleListItem>) => void;
  onSubmit: (values: Partial<API.RuleListItem>) => Promise<void>;
  updateModalVisible: boolean;
  values: Partial<API.DockListItem>;
};

const UpdateForm: React.FC<UpdateFormProps> = (props) => {
  const intl = useIntl();
  return (
    <StepsForm
      stepsProps={{
        size: 'small',
      }}
      stepsFormRender={(dom, submitter) => {
        return (
          <Modal
            width={640}
            bodyStyle={{ padding: '32px 40px 48px' }}
            destroyOnClose
            title={intl.formatMessage({
              id: 'pages.searchTable.updateForm.ruleConfig',
              defaultMessage: '规则配置',
            })}
            visible={props.updateModalVisible}
            footer={submitter}
            onCancel={() => {
              props.onCancel();
            }}
          >
            {dom}
          </Modal>
        );
      }}
      onFinish={props.onSubmit}
    >
      <StepsForm.StepForm
        initialValues={{
          // @ts-ignore
          name: props.values.taregt,
          // @ts-ignore
          desc: props.values.ligand,
        }}
        title={intl.formatMessage({
          id: 'pages.searchTable.updateForm.basicConfig',
          defaultMessage: '基本信息',
        })}
      >
        <ProFormText
          name="target"
          label={intl.formatMessage({
            id: 'pages.searchTable.updateForm.ruleName.nameLabel',
            defaultMessage: '靶点PDB',
          })}
          width="md"
          rules={[
            {
              required: true,
              message: (
                <FormattedMessage
                  id="pages.searchTable.updateForm.ruleName.nameRules"
                  defaultMessage="请输入靶点PDB！"
                />
              ),
            },
          ]}
        />
        <ProFormTextArea
          name="ligand"
          width="md"
          label={intl.formatMessage({
            id: 'pages.searchTable.updateForm.ruleDesc.descLabel',
            defaultMessage: '配体ID',
          })}
          placeholder={intl.formatMessage({
            id: 'pages.searchTable.updateForm.ruleDesc.descPlaceholder',
            defaultMessage: '请输入配体ID',
          })}
          rules={[
            {
              required: true,
              message: (
                <FormattedMessage
                  id="pages.searchTable.updateForm.ruleDesc.descRules"
                  defaultMessage="请输入配体ID！"
                />
              ),
            },
          ]}
        />
      </StepsForm.StepForm>
      <StepsForm.StepForm
        initialValues={{
          target: '0',
          template: '0',
        }}
        title={intl.formatMessage({
          id: 'pages.searchTable.updateForm.ruleProps.title',
          defaultMessage: '配置对接信息',
        })}
      >
        <ProFormText
          name="target"
          label={intl.formatMessage({
            id: 'pages.searchTable.updateForm.ruleName.nameLabel',
            defaultMessage: '靶点来源',
          })}
          width="md"
          rules={[
            {
              required: true,
              message: (
                <FormattedMessage
                  id="pages.searchTable.updateForm.ruleName.nameRules"
                  defaultMessage="请输入靶点来源！"
                />
              ),
            },
          ]}
        />
        <ProFormText
          name="target"
          label={intl.formatMessage({
            id: 'pages.searchTable.updateForm.ruleName.nameLabel',
            defaultMessage: '配体来源',
          })}
          width="md"
          rules={[
            {
              required: true,
              message: (
                <FormattedMessage
                  id="pages.searchTable.updateForm.ruleName.nameRules"
                  defaultMessage="请输入配体来源！"
                />
              ),
            },
          ]}
        />
        <ProFormText
          name="target"
          label={intl.formatMessage({
            id: 'pages.searchTable.updateForm.ruleName.nameLabel',
            defaultMessage: '打分',
          })}
          width="md"
          rules={[
            {
              required: true,
              message: (
                <FormattedMessage
                  id="pages.searchTable.updateForm.ruleName.nameRules"
                  defaultMessage="请输入打分！"
                />
              ),
            },
          ]}
        />
      </StepsForm.StepForm>
    </StepsForm>
  );
};

export default UpdateForm;
