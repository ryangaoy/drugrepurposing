import { PageContainer } from '@ant-design/pro-components';
import { Alert, Card, Input, Typography } from 'antd';
import React from 'react';
import { FormattedMessage, useIntl } from 'umi';
import styles from './Welcome.less';

const CodePreview: React.FC = ({ children }) => (
  <pre className={styles.pre}>
    <code>
      <Typography.Text copyable>{children}</Typography.Text>
    </code>
  </pre>
);

const Home: React.FC = () => {
  const intl = useIntl();

  return (
    <PageContainer
      title={false}
      content={
        <div style={{ textAlign: 'center' }}>
          <Input.Search
            placeholder={intl.formatMessage({
              id: 'pages.menu.input',
              defaultMessage: 'Please enter the reason for the exception!',
            })}
            enterButton={intl.formatMessage({
              id: 'pages.menu.search',
              defaultMessage: 'Please enter the reason for the exception!',
            })}
            size="large"
            onSearch={() => {}}
            style={{ maxWidth: 522, width: '100%' }}
          />
        </div>
      }
    >
      <Card>
        <Alert
          message={intl.formatMessage({
            id: 'pages.welcome.alertMessage',
            defaultMessage: 'Faster and stronger heavy-duty components have been released.',
          })}
          type="success"
          showIcon
          banner
          style={{
            margin: -12,
            marginBottom: 24,
          }}
        />
        <Typography.Text strong>
          <a
            href="https://procomponents.ant.design/components/table"
            rel="noopener noreferrer"
            target="__blank"
          >
            <FormattedMessage id="pages.welcome.link" defaultMessage="Index" />
          </a>
        </Typography.Text>
        <CodePreview>yarn add @ant-design/pro-components</CodePreview>
      </Card>
    </PageContainer>
  );
};

export default Home;
