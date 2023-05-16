// @ts-ignore
/* eslint-disable */

declare namespace API {
  type CurrentUser = {
    name?: string;
    avatar?: string;
    userid?: string;
    email?: string;
    signature?: string;
    title?: string;
    group?: string;
    tags?: { key?: string; label?: string }[];
    notifyCount?: number;
    unreadCount?: number;
    country?: string;
    access?: string;
    geographic?: {
      province?: { label?: string; key?: string };
      city?: { label?: string; key?: string };
    };
    address?: string;
    phone?: string;
  };

  type LoginResult = {
    code?: number;
    data?: LoginResultData;
    msg?: string;
  };

  type DrugsResult = {
    code?: number;
    data?: { list: Drugs[]; total: number };
    msg?: string;
  };

  type LoginResultData = {
    accessToken?: string;
    expiresTime?: number;
    refreshToken?: string;
    userId?: number;
  };

  type PageParams = {
    current?: number;
    pageSize?: number;
  };

  type RuleListItem = {
    key?: number;
    disabled?: boolean;
    href?: string;
    avatar?: string;
    name?: string;
    owner?: string;
    desc?: string;
    callNo?: number;
    status?: number;
    updatedAt?: string;
    createdAt?: string;
    progress?: number;
  };

  type DockListItem = {
    _id?: string;
    target_id?: string;
    ligand_id?: string;
    ligand_dataset?: string;
    protein_dataset?: string;
    score?: number;
    createdAt?: string;

    result_id?: string;
  };

  type DockList = {
    data?: DockListItem[];
    /** 列表的内容总数 */
    total?: number;
    success?: boolean;
  };

  type DockResult = {
    code?: number;
    /** 列表的内容总数 */
    data?: DockList;
    msg?: string;
  };

  type FakeCaptcha = {
    code?: number;
    status?: string;
  };

  type LoginParams = {
    username?: string;
    password?: string;
    rememberMe?: boolean;
  };

  type RegisterParams = {
    username?: string;
    password?: string;
    nickname?: string;
  };

  type ErrorResponse = {
    /** 业务约定的错误码 */
    errorCode: string;
    /** 业务上的错误信息 */
    errorMessage?: string;
    /** 业务上的请求是否成功 */
    success?: boolean;
  };

  type NoticeIconList = {
    data?: NoticeIconItem[];
    /** 列表的内容总数 */
    total?: number;
    success?: boolean;
  };

  type NoticeIconItemType = 'notification' | 'message' | 'event';

  type NoticeIconItem = {
    id?: string;
    extra?: string;
    key?: string;
    read?: boolean;
    avatar?: string;
    title?: string;
    status?: string;
    datetime?: string;
    description?: string;
    type?: NoticeIconItemType;
  };
  type Drugs = {
    drugbankId: string;
    generalName: string;
    knownAs: string;
    groups: string;
    molecular: string;
    atomicN: string;
    structure: string;
    manufacturers: string;
    indication: string;
    targets: string;
    uniprotId: string;
  };
}
