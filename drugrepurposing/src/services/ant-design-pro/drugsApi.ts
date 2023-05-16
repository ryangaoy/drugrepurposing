// @ts-ignore
/* eslint-disable */
import { request } from 'umi';

/** 获取当前的用户 GET /api/currentUser */

export async function drugsPage(
  params: {
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
    // query
    /** 当前的页码 */
    pageNo?: number;
    /** 页面的容量 */
    pageSize?: number;
  },
  options?: { [key: string]: any },
) {
  return request<API.DrugsResult>('/admin-api/redrug/drugs/page', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: {
      ...params,
    },
    ...(options || {}),
  });
}
