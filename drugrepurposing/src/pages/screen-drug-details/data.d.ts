export interface IpaDiseaseAllType {
  id?: number;
  drugbankId: string;
  fromM: string;
  typeM: string;
  toM: string;
  catalyst: string;
}

export interface IpaDiseaseSingleType {
  id?: number;
  drugbankId: string;
  gene: string;
  dfunction: string;
  disease: string;
}

export interface IpaDiseaseAllResult {
  code: number;
  data: IpaDiseaseAllType[];
  msg: string;
}

export interface IpaDiseaseSingleResult {
  code: number;
  data: IpaDiseaseSingleType[];
  msg: string;
}

export interface ScreenDrugType {
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
  pubmedGene?: '';
}

export interface ScreenDrugResult {
  code: number;
  data: ScreenDrugType;
  msg: string;
}

export interface ScreenSType {
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
}

export interface ScreenSResult {
  code: number;
  data: ScreenSType[];
  msg: string;
}
