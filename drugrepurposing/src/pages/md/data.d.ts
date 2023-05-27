export interface MdReqPageType {
  id?: number;
  drugbankId?: string;
  entrys?: string;
  proteinNames?: string;
  pdb?: string;
  uniprotId?: string;
  organism?: string;
  lengths?: number;
  pageNo: number;
  pageSize: number;
}

export interface MdPageDataType {
  id?: number;
  drugbankId?: string;
  entrys?: string;
  proteinNames?: string;
  pdb?: string;
  uniprotId?: string;
  organism?: string;
  lengths?: number;
}

export interface MdPageResultType {
  code?: number;
  data?: { list: MdPageDataType[]; total: number };
  msg?: string;
}
