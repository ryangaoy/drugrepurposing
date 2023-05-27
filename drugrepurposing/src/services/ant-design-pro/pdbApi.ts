// @ts-ignore
/* eslint-disable */
import { request } from 'umi';

type pdbType = {
  pdb: string;
  uniprotId: string;
  geneNames: string;
  organism: string;
  proteinNames: string;
  lengths: string;
  ecNumber: string;
  functions: string;
  pubmedId: string;
  entrys: string;
};

type PdbResult = {
  code?: number;
  data?: { list: pdbType[]; total: number };
  msg?: string;
};

/** 获取当前的用户 GET /api/currentUser */
export async function getPdb(
  params: {
    id: string;
  },
  options?: { [key: string]: any },
) {
  return request<PdbResult>('/admin-api/redrug/targets/getByPdb', {
    method: 'GET',
    params: {
      id: params.id,
    },
    ...(options || {}),
  });
}
