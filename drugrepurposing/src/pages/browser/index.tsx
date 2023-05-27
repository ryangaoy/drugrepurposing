import { PageContainer } from '@ant-design/pro-layout';
import type { FC } from 'react';
import { useIntl } from 'umi';

type SearchProps = {
  match: {
    url: string;
    path: string;
  };
  location: {
    pathname: string;
  };
};

const Search: FC<SearchProps> = (props) => {
  // @ts-ignore
  const intl = useIntl();

  return (
    <PageContainer className={'browser'} pageHeaderRender={() => {}}>
      {props.children}
    </PageContainer>
  );
};

export default Search;
