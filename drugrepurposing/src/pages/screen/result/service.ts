// @ts-ignore
import { request } from 'umi';
import type { ScreenDrugResult } from './data';

export async function screenDrugsPage(
  params: {
    id?: number;
    drugbankId?: string;
    name?: string;
    description?: string;
    casNumber?: string;
    averageMass?: number;
    monoisotopicMass?: number;
    groups?: string;
    synthesisReference?: string;
    indication?: string;
    pharmacodynamics?: string;
    absorption?: string;
    volumeOfDistribution?: string;
    proteinBinding?: string;
    metabolism?: string;
    routeOfElimination?: string;
    halfLife?: string;
    clearance?: string;
    molecular?: string;
    atomicN?: number;
    manufacturers?: string;
    pubmedGene?: string;
    pageNo: number;
    pageSize: number;
  },
  options?: Record<string, any>,
) {
  return request<ScreenDrugResult>('/admin-api/redrug/screen-drugs/page', {
    method: 'POST',
    data: {
      ...params,
    },
    ...(options || {}),
  });
}
