import { request } from 'umi';
import type {
  IpaDiseaseAllResult,
  IpaDiseaseSingleResult,
  ScreenDrugResult,
  ScreenSResult, ScreenSType,
} from '@/pages/screen-drug-details/data';

export async function ipaDiseaseAllList(
  params: {
    id: string;
  },
  options?: Record<string, any>,
) {
  return request<IpaDiseaseAllResult>('/admin-api/redrug/ipa-disease-all/listByDrug', {
    method: 'GET',
    params: {
      id: params,
    },
    ...(options || {}),
  });
}

export async function ipaDiseaseSingleList(
  params: {
    id: string;
  },
  options?: Record<string, any>,
) {
  return request<IpaDiseaseSingleResult>('/admin-api/redrug/ipa-disease-single/getByDrug', {
    method: 'GET',
    params: {
      id: params,
    },
    ...(options || {}),
  });
}

export async function getScreenDrug(
  params: {
    id: string;
  },
  options?: Record<string, any>,
) {
  return request<ScreenDrugResult>('/admin-api/redrug/screen-drugs/getByDrug', {
    method: 'GET',
    params: {
      id: params,
    },
    ...(options || {}),
  });
}

export async function getScreenS(
  params: {
    id: string;
  },
  options?: Record<string, any>,
) {
  return request<ScreenSResult>('/admin-api/redrug/screen/listByDrug', {
    method: 'GET',
    params: {
      id: params,
    },
    ...(options || {}),
  });
}

export async function getScreenSearch(
  params: {
    drugbankId?: string;
    uniprotId?: string;
    tgname?: string;
    pdbid?: string;
    score?: number;
    bindingRate?: number;
    uniprotTgnameMedN?: string;
    uniprotTgnameMedList?: string;
    uniprotTgshortMedN?: number;
    uniprotTgshortMedList?: string;
    alternativeNameMedN?: number;
    alternativeNameMedList?: string;
    uniprotDiseaseMedN?: number;
    uniprotDiseaseMedList?: string;
    uniprotGeneMedN?: number;
    uniprotGeneMedList?: string;
    pdbidMedN?: number;
    pdbidMedList?: string;
    pageNo?: number,
    pageSize?: number,
  },
  options?: Record<string, any>,
) {
  return request<ScreenSType>('/admin-api/redrug/screen-drugs/screensearch', {
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
