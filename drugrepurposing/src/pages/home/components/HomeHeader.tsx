import React, {useState} from 'react';
import {getWid_Hei} from '@/utils';
import './home_com.less';
import { Tabs } from 'antd';
// @ts-ignore
import { useIntl } from '@@/plugin-locale/localeExports';
import { Typography } from 'antd';
import DrugSearchForm from "@/pages/home/components/DrugSearchForm";
import ScreenSearchForm from "@/pages/home/components/ScreenSearchForm";
import {toNumber} from "lodash";


const HomeHeader: React.FC = () => {
  // @ts-ignore
  const intl = useIntl();
  const { height } = getWid_Hei();

  const { Text } = Typography;

  const TabList = ['Drug', 'Screen'];

  const [formId, setFormId] = useState(0);

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
        <div style={{ position: 'relative' }}>
          <Text className="header-top-title" strong>
            Search drug
          </Text>
          <Text className="header-top-title" strong>
            & protein on
          </Text>
          <Text className="header-top-title" strong style={{ marginBottom: 24 }}>
            Drug Repurposing
          </Text>
          {/*<h1 className='header-top-title'>Search drugs</h1>*/}
          {/*<h1 className='header-top-title'>& protein on</h1>*/}
          {/*<h1 className='header-top-title'>Drug Repurposing</h1>*/}
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="44"
            height="140"
            viewBox="0 0 44 140"
            fill="none"
            className="header-top__arrow"
          >
            <path
              d="M1 2C9.31819 8.79881 19.2533 14.2514 25.9546 22.3964C55.4519 58.2489 41.6204 105.491 6.0824 133.467"
              stroke="#EFA470"
              strokeWidth="3"
              strokeDasharray="8"
            ></path>
            <path
              d="M3.50389 119.867C3.29393 142.458 -4.60351 138.256 18 136.534"
              stroke="#EFA470"
              strokeWidth="3"
            ></path>
          </svg>
          <Tabs
            onChange={(activeKey) => {
              setFormId(toNumber(activeKey));
            }}
            type="card"
            items={new Array(2).fill(null).map((_, i) => {
              const id = String(i);
              return {
                label: `${TabList[id]}`,
                key: id,
                children: ``,
              };
            })}
          />
          {
            formId === 0 ? <DrugSearchForm /> : <ScreenSearchForm />
          }
          <h2 className="header-top-bottom-title">
            Popular&nbsp;drugs:&nbsp;&nbsp;Valsaran,&nbsp;&nbsp;Esmolol,&nbsp;&nbsp;Carbidopa
          </h2>
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
