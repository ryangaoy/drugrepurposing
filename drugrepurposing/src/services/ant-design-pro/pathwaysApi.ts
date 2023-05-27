// @ts-ignore
/* eslint-disable */
import { request } from 'umi';

/** 获取当前的用户 GET /api/currentUser */

type PathwaysType = {
  drugbankId: string;
  generalName: string;
  knownAs: string;
  passwayId: string;
  pathwayDesc: string;
  falseDiscoveryRate: string;
  labels: string;
  labelsIds: string;
  pdbids: string;
  pdbidsList: string;
  pdbidAll: string;
};

type PathwaysResult = {
  code: number;
  data: PathwaysType[];
  msg: string;
};

export async function getPathway(
  params: {
    id: string;
  },
  options?: { [key: string]: any },
) {
  return request<PathwaysResult>('/admin-api/redrug/pathways/listByDrug', {
    method: 'GET',
    params: {
      id: params,
    },
    ...(options || {}),
  });
}
