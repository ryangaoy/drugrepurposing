import React from 'react';
import {getWid_Hei} from '@/utils';
import './home_com.less';
import {Button, Form, message} from 'antd';
// @ts-ignore
import { useIntl } from '@@/plugin-locale/localeExports';
import { Typography } from 'antd';
import { ProForm, ProFormText, ProFormTextArea } from '@ant-design/pro-components';
import {Message} from "@/pages/about/components/data";
import {messageAdd} from "@/pages/about/components/service";



const HomeHeader: React.FC = () => {
  // @ts-ignore
  const intl = useIntl();
  const { height } = getWid_Hei();

  const { Text } = Typography;

  // @ts-ignore
  const [form] = Form.useForm();

  return (
    <>
      <div
        style={{
          // backgroundImage: "url('/icons/background.jpg')",
          // backgroundSize: 'cover',
          height: `${height - 90}px`,
          zIndex: 10,
          // backgroundRepeat: 'no-repeat',
        }}
        className="headerbackground"
      >
        <div className="background-overlay" />
        <div style={{ position: 'relative', zIndex: 100 }}>
          <h3 className="about_header_title_h3">How Can We Help?</h3>
          <Text className="header-top-title" strong style={{ marginBottom: 24 }}>
            We Are Ready to Help
          </Text>
          <div className="about-widget-container">
            <p>
              Maecenas tristique feugiat eros, quis porttitor tortor
              <br />
              fringilla quis. Aenean porta vehicula felis, malesuada <br />
              maximus justo egestas non. Duis ultrices euismod
              <br />
              dignissim. Praesent maximus condimentum maximus.
            </p>
          </div>
        </div>
        <div className="about_msg">
          <ProForm<Message>
            layout={'horizontal'}
            onFinish={async (value) => {
              const re = await messageAdd(value);
              if(re.code === 0) {
                message.success("Success");
              }
            }}
             submitter={{
               // 完全自定义整个区域
               render: (props, doms) => {
                 console.log(props);
                 return [
                   <Button type="primary" key="submit" onClick={() => props.form?.submit?.()} size={'large'} style={{borderRadius: '5px'}}>
                     Send
                   </Button>,
                   <Button key="rest" onClick={() => props.form?.resetFields()} size={'large'} style={{borderRadius: '5px'}}>
                     Reset
                   </Button>,
                 ];
               },
             }}
             grid={true}
          >
            <ProForm.Group style={{display: 'flex', justifyContent: 'center', alignItems:'center', marginBottom: '30px'}}>
              <Text className="about-form-h1" strong>
                Send a message
              </Text>
            </ProForm.Group>
            <ProFormText
              name='name'
              placeholder="Name"
              colProps={{ span: 24 }}
            />
            <ProFormText width="sm" name="email" placeholder="Email" colProps={{ xl: 12 }}/>
            <ProFormText width="sm" name="phone" placeholder="Phone" colProps={{ xl: 12 }}/>
            <ProFormTextArea fieldProps={{ autoSize: { minRows: 3, maxRows: 5 } }} colProps={{ span: 24 }}
                             placeholder='Message'
                             style={{padding: '5px'}}
                             name='message'
            />
          </ProForm>
        </div>
        <div className="picture">
          <img src="/icons/background.jpg" alt={'back'} />
        </div>
        <div className="picture2">
          <img src="/icons/back-2.jpg" alt={'back'} />
        </div>
        <div className="picture3">
          <img src="/icons/back-3.jpg" alt={'back'} />
        </div>
      </div>
    </>
  );
};

export default HomeHeader;
