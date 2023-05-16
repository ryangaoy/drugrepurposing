import { Settings as LayoutSettings } from '@ant-design/pro-components';

const Settings: LayoutSettings & {
  pwa?: boolean;
  logo?: string;
} = {
  navTheme: 'light',
  // 拂晓蓝
  primaryColor: '#1A3D68',
  layout: 'top',
  contentWidth: 'Fixed',
  fixedHeader: true,
  fixSiderbar: true,
  colorWeak: false,
  title: 'Drug Repurposing',
  pwa: false,
  logo: '/icons/logo.png',
  menu: {
    locale: false,
  },
  iconfontUrl: '',
  headerHeight: 90,
};

export default Settings;
