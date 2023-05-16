import Footer from '@/components/Footer';
import {register} from '@/services/ant-design-pro/api';
import {
  LockOutlined,
  UserOutlined,
} from '@ant-design/icons';
import {
  LoginForm,
  // ProFormCaptcha,
  ProFormCheckbox,
  ProFormText,
} from '@ant-design/pro-components';
import {Alert, message, Form, Progress, Popover} from 'antd';
import React, {useEffect, useState} from 'react';
import { FormattedMessage, history, useIntl } from 'umi';
import styles from './index.less';
import './index.less';

const LoginMessage: React.FC<{
  content: string;
}> = ({ content }) => (
  <Alert
    style={{
      marginBottom: 24,
    }}
    message={content}
    type="error"
    showIcon
  />
);

const passwordStatusMap = {
  ok: (
    <div className={styles.success}>
      <span>Intensity：Strong</span>
    </div>
  ),
  pass: (
    <div className={styles.warning}>
      <span>Intensity：Middle</span>
    </div>
  ),
  poor: (
    <div className={styles.error}>
      <span>Intensity：Too short</span>
    </div>
  ),
};

const passwordProgressMap: {
  ok: 'success';
  pass: 'normal';
  poor: 'exception';
} = {
  ok: 'success',
  pass: 'normal',
  poor: 'exception',
};

const confirmDirty = false;

const Register: React.FC = () => {

  const [visible, setVisible]: [boolean, any] = useState(false);
  const [popover, setPopover]: [boolean, any] = useState(false);

  let interval: number | undefined;
  const [form] = Form.useForm();

  useEffect(
    () => () => {
      clearInterval(interval);
    },
    [interval],
  );

  const getPasswordStatus = () => {
    const value = form.getFieldValue('password');
    if (value && value.length > 9) {
      return 'ok';
    }
    if (value && value.length > 5) {
      return 'pass';
    }
    return 'poor';
  };

  const checkConfirm = (_: any, value: string) => {
    const promise = Promise;
    if (value && value !== form.getFieldValue('password')) {
      return promise.reject('Mismatch between the two entered passwords!');
    }
    return promise.resolve();
  };

  const checkPassword = (_: any, value: string) => {
    const promise = Promise;
    // 没有值的情况
    if (!value) {
      setVisible(!!value);
      return promise.reject('Please enter the password!');
    }
    // 有值的情况
    if (!visible) {
      setVisible(!!value);
    }
    setPopover(!popover);
    if (value.length < 6) {
      return promise.reject('');
    }
    if (value && confirmDirty) {
      form.validateFields(['confirm']);
    }
    return promise.resolve();
  };

  const renderPasswordProgress = () => {
    const value = form.getFieldValue('password');
    const passwordStatus = getPasswordStatus();
    return value && value.length ? (
      <div className={styles[`progress-${passwordStatus}`]}>
        <Progress
          status={passwordProgressMap[passwordStatus]}
          className={styles.progress}
          strokeWidth={6}
          percent={value.length * 10 > 100 ? 100 : value.length * 10}
          showInfo={false}
        />
      </div>
    ) : null;
  };

  const [userLoginState, setUserLoginState] = useState<API.LoginResult>({ code: 0, msg: '' });


  const intl = useIntl();

  const handleSubmit = async (values: API.RegisterParams) => {
    try {
      // 登录
      const msg = await register({ ...values, nickname: values.username });
      if (msg.code === 0) {
        const defaultLoginSuccessMessage = 'Register successful';
        message.success(defaultLoginSuccessMessage);
        history.push('/user/login');
        return;
      }
      console.log(msg);
      // 如果失败去设置用户错误信息
      setUserLoginState(msg);
    } catch (error) {
      const defaultLoginFailureMessage = 'Register failed';
      message.error(defaultLoginFailureMessage);
    }
  };
  const { code, msg } = userLoginState;

  return (
    <div className="login">
      <div className={styles.container}>
        <div className={styles.content}>
          <LoginForm
            form={form}
            logo={<img alt="logo" src="/icons/logo.png" />}
            title="Drug Repurposing"
            subTitle={'Discover new uses for medicines'}
            submitter={{
              searchConfig: {
                submitText: 'Register'
              }
            }}
            initialValues={{
              rememberMe: false,
            }}

            onFinish={async (values) => {
              await handleSubmit(values as API.LoginParams);
            }}
          >
            {code !== 0 && msg !== '' && (
              <LoginMessage
                content={intl.formatMessage({
                  id: 'pages.login.accountLogin.errorMessage',
                  defaultMessage: msg,
                })}
              />
            )}
            <>
              <ProFormText
                name="username"
                fieldProps={{
                  size: 'large',
                  prefix: <UserOutlined className={styles.prefixIcon} />,
                }}
                placeholder={intl.formatMessage({
                  id: 'pages.login.username.placeholder',
                  defaultMessage: '用户名: admin or user',
                })}
                rules={[
                  {
                    required: true,
                    message: (
                      <FormattedMessage
                        id="pages.login.username.required"
                        defaultMessage="请输入用户名!"
                      />
                    ),
                  },
                ]}
              />
              <Popover
                getPopupContainer={(node) => {
                  if (node && node.parentNode) {
                    return node.parentNode as HTMLElement;
                  }
                  return node;
                }}
                content={
                  visible && (
                    <div style={{ padding: '4px 0' }}>
                      {passwordStatusMap[getPasswordStatus()]}
                      {renderPasswordProgress()}
                      <div style={{ marginTop: 10 }}>
                        <span>Please enter at least 6 characters</span>
                      </div>
                    </div>
                  )
                }
                overlayStyle={{ width: 240 }}
                placement="right"
                open={visible}
              >
                <ProFormText.Password
                  name="password"
                  fieldProps={{
                    size: 'large',
                    prefix: <LockOutlined className={styles.prefixIcon} />,
                  }}
                  placeholder={intl.formatMessage({
                    id: 'pages.login.password.placeholder',
                    defaultMessage: '密码: ant.design',
                  })}
                  rules={[
                    {
                      validator: checkPassword,
                    },
                  ]}
                />
              </Popover>
              <ProFormText.Password
                name="confirm"
                fieldProps={{
                  size: 'large',
                  prefix: <LockOutlined className={styles.prefixIcon} />,
                }}
                placeholder={intl.formatMessage({
                  id: 'pages.login.password.placeholder',
                  defaultMessage: '密码: ant.design',
                })}
                rules={[
                  {
                    required: true,
                    message: 'Please enter again',
                  },
                  {
                    validator: checkConfirm,
                  },
                ]}
              />
              <div
                style={{
                  marginBottom: 24,
                }}
              >
                <ProFormCheckbox noStyle name="rememberMe">
                  <FormattedMessage id="pages.login.rememberMe" defaultMessage="自动登录" />
                </ProFormCheckbox>
                <a
                  style={{
                    float: 'right',
                  }}
                  href="/user/login"
                >
                  Login
                </a>
              </div>
            </>
          </LoginForm>
        </div>
        <Footer />
      </div>
    </div>
  );
};

export default Register;
