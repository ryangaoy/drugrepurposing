export default [
  {
    path: '/user',
    layout: false,
    routes: [
      {
        name: 'Login',
        path: '/user/login',
        component: './user/Login',
      },
      {
        name: 'Register',
        path: '/user/register',
        component: './user/Register',
        access: 'permitAll'
      },
      {
        component: './404',
      },
    ],
  },
  {
    path: '/home',
    name: 'Home',
    icon: 'home',
    component: './home',
  },
  {
    path: '/browser',
    name: 'Browser',
    component: './browser',
    icon: 'laptop',
    routes: [
      {
        path: '/browser',
        redirect: '/browser/drugs',
      },
      {
        name: 'drugs',
        path: '/browser/drugs',
        component: './browser/drugs',
        hideInMenu: true,
      },
    ],
  },
  {
    path: '/data',
    name: 'Predict Data',
    component: './browser',
    icon: 'database',
    routes: [
      {
        path: '/data',
        redirect: '/data/dock',
      },
      {
        name: 'Molecular Docking',
        icon: 'table',
        path: '/data/dock',
        component: './TableList',
      },
      {
        name: 'Molecular Dynamics Simulation',
        icon: 'table',
        path: '/data/md',
        component: './md',
      },
      {
        name: 'Screen Result',
        icon: 'table',
        path: '/data/screen',
        component: './screen/result',
      },
    ],
  },
  {
    name: 'About Us',
    icon: 'smile',
    path: '/about',
    component: './about',
  },
  {
    name: 'Detail',
    icon: 'table',
    path: '/dock/:id',
    component: './TableList/DockDetail.tsx',
    hideInMenu: true,
  },
  {
    name: 'Detail',
    icon: 'table',
    path: '/mddetail/:id',
    component: './md/MDDetail.tsx',
    hideInMenu: true,
  },
  {
    name: 'Molecular Docking',
    icon: 'table',
    path: '/dockdrug/:id',
    component: './dock-drug',
    hideInMenu: true,
  },
  {
    name: 'Drug Details',
    icon: 'table',
    path: '/drugs/:id',
    component: './drug-details',
    hideInMenu: true,
  },
  {
    name: 'Screen Drug Details',
    icon: 'table',
    path: '/screendrug/:id',
    component: './screen-drug-details',
    hideInMenu: true,
  },
  {
    name: 'Detail',
    icon: 'table',
    path: '/md/:id',
    component: './md/MDDetail.tsx',
    hideInMenu: true,
  },
  {
    path: '/',
    redirect: '/home',
    access: 'permitAll',
  },
  {
    component: './404',
  },
];
