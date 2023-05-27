export type Member = {
  avatar: string;
  name: string;
  id: string;
};

export type screenDrugType = {
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
};

export type ScreenDrugResult = {
  code?: number;
  data?: { list: screenDrugType[]; total: number };
  msg?: string;
};

export interface Params {
  count: number;
}
export interface ListItemDataType {
  id: string;
  owner: string;
  title: string;
  avatar: string;
  cover: string;
  status: 'normal' | 'exception' | 'active' | 'success';
  percent: number;
  logo: string;
  href: string;
  body?: any;
  updatedAt: number;
  createdAt: number;
  subDescription: string;
  description: string;
  activeUser: number;
  newUser: number;
  star: number;
  like: number;
  message: number;
  content: string;
  members: Member[];
}
