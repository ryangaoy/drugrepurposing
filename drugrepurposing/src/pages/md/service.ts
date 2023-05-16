import { request } from 'umi';
import type { MdReqPageType, MdPageResultType } from '@/pages/md/data';

export async function getMdPage(
  params: MdReqPageType,
  options?: Record<string, any>,
): Promise<MdPageResultType> {
  return request('/admin-api/redrug/md/page', {
    method: 'POST',
    data: {
      ...params,
    },
    ...(options || {}),
  });
}
