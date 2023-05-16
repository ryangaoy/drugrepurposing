import { Card, List } from 'antd';
import type { FC } from 'react';
import { useEffect, useState } from 'react';
// @ts-ignore
import { useIntl } from 'umi';
import { drugsPage } from '@/services/ant-design-pro/drugsApi';
import { QueryFilter, ProForm, ProFormText, ProBreadcrumb } from '@ant-design/pro-components';
import './browser.less';

type Drugs = {
  drugbankId?: string;
  generalName?: string;
  knownAs?: string;
  groups?: string;
  molecular?: string;
  atomicN?: string;
  structure?: string;
  manufacturers?: string;
  indication?: string;
  targets?: string;
  uniprotId?: string;
};

const Articles: FC = () => {
  // @ts-ignore
  const intl = useIntl();
  // @ts-ignore
  const [current, setCurrent] = useState(1);
  // @ts-ignore
  const [pageSize, setPageSize] = useState(10);
  // @ts-ignore
  const [drugs, setDrugs] = useState<Drugs>({});

  const [drugsData, setDrugsData] = useState<Drugs[]>([]);
  const [loading, setLoading] = useState(false);
  const [total, setTotal] = useState(0);

  const drugParams = localStorage.getItem('drugParam');
  let drugParam = {}
  if (drugParams !== null) {
    drugParam = JSON.parse(drugParams);
  }


  useEffect(() => {
    setLoading(true);
    drugsPage({
      ...drugParam,
      pageNo: current,
      pageSize,
    }).then((r) => {
      if (r.code === 0) {
        // @ts-ignore
        setDrugsData(r.data.list);
        // @ts-ignore
        setTotal(r.data.total);
        localStorage.removeItem('drugParam')
        setLoading(false);
      }
    });
  }, [drugs, current, pageSize]);

  return (
    <>
      <div style={{ paddingBottom: 24 }}>
        <ProBreadcrumb separator={'>'} style={{ maxWidth: 1200 }} />
      </div>
      <Card bordered={false}>
        <QueryFilter
          labelWidth="auto"
          onReset={async () => {
            window.location.reload();
          }}
          onFinish={async (values: any) => {
            setDrugs({ ...values });
            drugsPage({
              ...drugs,
              pageNo: current,
              pageSize,
            }).then((r) => {
              if (r.code === 0) {
                // @ts-ignore
                setDrugsData(r.data.list);
                // @ts-ignore
                setTotal(r.data.total);
                setLoading(false);
              }
            });
          }}
          initialValues={{
            ...drugs,
          }}
        >
          <ProForm.Group>
            <ProFormText
              width="md"
              name="drugbankId"
              label="DrugBank ID"
              placeholder="Please enter"
            />
          </ProForm.Group>
          <ProForm.Group>
            <ProFormText name="generalName" width="md" label="Name" placeholder="Please enter" />
          </ProForm.Group>
          <ProForm.Group>
            <ProFormText width="sm" name="groups" label="Group" />
          </ProForm.Group>
          <ProFormText width="sm" name="molecular" label="Molecular" />
          <ProFormText width="sm" name="atomicN" label="Atomic" />
        </QueryFilter>
      </Card>
      <Card style={{ marginTop: 24 }} bordered={true} bodyStyle={{ padding: '8px 32px 32px 32px' }}>
        <List<Drugs>
          size="large"
          loading={loading}
          rowKey="drugbankId"
          itemLayout="vertical"
          loadMore={false}
          dataSource={drugsData}
          pagination={{
            position: 'both',
            total: total,
            showTotal: (totals, range) => `${range[0]}-${range[1]} of ${totals} items`,
            defaultPageSize: 10,
            defaultCurrent: 1,
            pageSizeOptions: [10, 20, 50, 100],
            onChange: (page, pageSizes) => {
              setLoading(true);
              drugsPage({
                ...drugs,
                // @ts-ignore
                pageNo: page,
                pageSize: pageSizes,
              }).then((r) => {
                if (r.code === 0) {
                  // @ts-ignore
                  setDrugsData(r.data.list);
                  // @ts-ignore
                  setTotal(r.data.total);
                  setCurrent(page);
                  setPageSize(pageSizes);
                  setLoading(false);
                }
              });
            },
          }}
          renderItem={(item, index) => (
            <List.Item
              key={item.drugbankId}
              style={index === 0 ? { marginTop: 24, borderTop: '1px solid #eaeaea' } : {}}
              extra={
                <img
                  width={220}
                  alt="logo"
                  src={`/redrugfiles/files/drugbank_img/${item.drugbankId}.jpg`}
                  style={{ border: '1px solid #eaeaea', borderRadius: '8px' }}
                  className={'shadow'}
                />
              }
            >
              <div style={{ fontSize: '24px', fontWeight: 600 }}>
                <a href={`/drugs/${item.drugbankId}`}>{item.generalName}</a>
              </div>
              <div className="item">
                <span>DrugBank ID:</span>
                <span title={item.drugbankId}>{item.drugbankId}</span>
              </div>
              <div className="item">
                <span>Manufacturers:</span>
                <span title={item.manufacturers}>{item.manufacturers}</span>
              </div>
              <div className="item">
                <span>Group:</span>
                <span title={item.groups}>{item.groups}</span>
              </div>
              <div className="item">
                <span>Atoms:</span>
                <span title={item.atomicN}>{item.atomicN}</span>
              </div>
              <div className="item">
                <span>Indication:</span>
                <span title={item.indication}>{item.indication}</span>
              </div>
            </List.Item>
          )}
        />
      </Card>
    </>
  );
};

export default Articles;
