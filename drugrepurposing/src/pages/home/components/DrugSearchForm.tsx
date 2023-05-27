import {Button, Form, Input} from "antd";
import InputIcon from "@/pages/home/components/InputIcon";
import {SearchOutlined} from "@ant-design/icons";
import {useState} from "react";
import './home_com.less';

const DrugSearchForm = () => {

  type LayoutType = Parameters<typeof Form>[0]['layout'];
  const [form] = Form.useForm();
  const [formLayout] = useState<LayoutType>('inline');

  const onFinish = (values: any) => {
    localStorage.setItem('drugParam', JSON.stringify(values));
    window.location.href = '/browser/drugs';
  };

  const formItemLayout =
    formLayout === 'horizontal' ? { labelCol: { span: 4 }, wrapperCol: { span: 14 } } : null;

  return (
    <div className="header-top-search-wrap shadow">
      <div className="header-top-search">
        <Form
          {...formItemLayout}
          layout={formLayout}
          form={form}
          onFinish={onFinish}
          initialValues={{ layout: formLayout }}
          style={{ padding: 0 }}
        >
          <Form.Item name='generalName'>
            <Input
              placeholder="Drug Name"
              prefix={
                <InputIcon
                  ic={<SearchOutlined style={{ fontSize: '18px', color: '#ffffff' }} />}
                  style={{ width: '30px', height: '30px' }}
                />
              }
              className="header-top-search-button"
            />
          </Form.Item>
          <Form.Item name='molecular'>
            <Input
              placeholder="Molecular"
              prefix={
                <InputIcon
                  ic={<SearchOutlined style={{ fontSize: '18px', color: '#ffffff' }} />}
                  style={{ width: '30px', height: '30px' }}
                />
              }
              className="header-top-search-button"
            />
          </Form.Item>
          <Form.Item name='targets'>
            <Input
              placeholder="Targets"
              prefix={
                <InputIcon
                  ic={<SearchOutlined style={{ fontSize: '18px', color: '#ffffff' }} />}
                  style={{ width: '30px', height: '30px' }}
                />
              }
              className="header-top-search-button"
            />
          </Form.Item>
          <Form.Item style={{ width: '75px', marginRight: 0 }}>
            <Button
              type="primary"
              style={{ width: '75px', height: '60px', borderRadius: '10px 100px 100px 10px' }}
              icon={<SearchOutlined style={{ fontSize: '18px' }} />}
              htmlType="submit"
            />
          </Form.Item>
        </Form>
      </div>
    </div>
  );
}

export default DrugSearchForm;
