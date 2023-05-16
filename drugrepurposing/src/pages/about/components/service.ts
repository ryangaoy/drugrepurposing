// @ts-ignore
import { request } from 'umi';
import type {Message, MessageAddReturnType} from "@/pages/about/components/data";

export async function messageAdd(
  params: Message,
): Promise<MessageAddReturnType> {
  return request('/admin-api/redrug/message/create', {
    method: 'POST',
    data: {
      ...params,
    },
  });
}
