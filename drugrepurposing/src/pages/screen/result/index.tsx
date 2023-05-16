import { Card, List, Typography } from 'antd';
import type { FC } from 'react';
import { useState } from 'react';
import { screenDrugsPage } from './service';
import styles from './style.less';
import { useEffect } from 'react';
import type { screenDrugType } from './data.d';
import type { ScreenDrugResult } from './data.d';
import { ProBreadcrumb, ProForm, ProFormText, QueryFilter } from '@ant-design/pro-components';
import './screen.less';
import {getScreenSearch} from "@/pages/screen-drug-details/service";

const { Paragraph } = Typography;

const Projects: FC = () => {
  const [screenDrugData, setScreenDrugData] = useState<ScreenDrugResult>({});
  const [screenDrugReq, setScreenDrugReq] = useState<screenDrugType>({});
  const [total, setTotal] = useState(0);

  const screenParams = localStorage.getItem('screenParam');
  let screenParam = {}
  if (screenParams !== null) {
    screenParam = JSON.parse(screenParams);
  }

  useEffect(() => {
    getScreenSearch({
      ...screenParam,
      pageNo: 1,
      pageSize: 40,
    }).then((r) => {
      // @ts-ignore
      setScreenDrugData(r.data);
      localStorage.removeItem('screenParam');
      // @ts-ignore
      setTotal(r.data.total);
    });
  }, []);

  // @ts-ignore
  const list = screenDrugData?.list || [];

  const cardList = list && (
    <List<screenDrugType>
      rowKey="id"
      loading={list.length <= 0}
      grid={{
        gutter: 16,
        xs: 1,
        sm: 2,
        md: 3,
        lg: 3,
        xl: 4,
        xxl: 4,
      }}
      dataSource={list}
      pagination={{
        position: 'both',
        total: total,
        showTotal: (totals, range) => `${range[0]}-${range[1]} of ${totals} items`,
        defaultPageSize: 40,
        defaultCurrent: 1,
        pageSizeOptions: [40, 80, 100],
        onChange: (page, pageSize) => {
          screenDrugsPage({
            pageNo: page,
            pageSize: pageSize,
          }).then((r) => {
            // @ts-ignore
            setScreenDrugData(r.data);
            // @ts-ignore
            setTotal(r.data.total);
          });
        },
      }}
      renderItem={(item) => (
        <List.Item style={{ marginTop: 24 }}>
          <Card
            className={styles.card}
            hoverable
            cover={<img alt={item.drugbankId} src={`/redrugfiles/files/drugbank_img/${item.drugbankId}.jpg`} />}
          >
            <Card.Meta
              title={<a href={`/screenDrug/${item.drugbankId}`}>{item.drugbankId}</a>}
              description={
                <Paragraph className={styles.item} ellipsis={{ rows: 2 }}>
                  {item.description}
                </Paragraph>
              }
            />
            <div className={styles.cardItemContent} />
          </Card>
        </List.Item>
      )}
    />
  );

  return (
    <div className={styles.coverCardList}>
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
            setScreenDrugReq({ ...values });
            screenDrugsPage({
              ...values,
              pageNo: 1,
              pageSize: 40,
            }).then((r) => {
              // @ts-ignore
              setScreenDrugData(r.data);
              // @ts-ignore
              setTotal(r.data.total);
            });
          }}
          initialValues={{
            ...screenDrugReq,
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
            <ProFormText name="name" width="md" label="Name" placeholder="Please enter" />
          </ProForm.Group>
          <ProForm.Group>
            <ProFormText width="sm" name="groups" label="Group" />
          </ProForm.Group>
          <ProFormText width="sm" name="molecular" label="Molecular" />
          <ProFormText width="sm" name="atomicN" label="Atomic" />
        </QueryFilter>
      </Card>
      <div className={styles.cardList}>{cardList}</div>
    </div>
  );
};

export default Projects;
