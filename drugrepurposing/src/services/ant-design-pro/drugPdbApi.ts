// @ts-ignore
/* eslint-disable */
import { request } from 'umi';

/** 获取当前的用户 GET /api/currentUser */

type DrugPdb = {
  drugbankId: string;
  pdbId: string;
  score: string;
  bindingRate: string;
};

type DrugPdbResult = {
  code: number;
  data: DrugPdb[];
  msg: string;
};

export async function drugPdb(
  params: {
    id: string;
  },
  options?: { [key: string]: any },
) {
  return request<DrugPdbResult>('/admin-api/redrug/drug-pdb/listByDrug', {
    method: 'GET',
    params: {
      id: params,
    },
    ...(options || {}),
  });
}
