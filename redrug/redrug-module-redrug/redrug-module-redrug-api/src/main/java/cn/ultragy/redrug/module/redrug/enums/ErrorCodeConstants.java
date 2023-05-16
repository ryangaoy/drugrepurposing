package cn.ultragy.redrug.module.redrug.enums;


import cn.ultragy.redrug.framework.common.exception.ErrorCode;

public interface ErrorCodeConstants {
    ErrorCode DRUGS_NOT_EXISTS = new ErrorCode(1500, "药物信息不存在");
    ErrorCode DRUG_PDB_NOT_EXISTS = new ErrorCode(1501, "drug_pdb不存在");
    ErrorCode PATHWAYS_NOT_EXISTS = new ErrorCode(1503, "基因通路不存在");
    ErrorCode TARGETS_NOT_EXISTS = new ErrorCode(1504, "靶点pdb不存在");
    ErrorCode SCREEN_NOT_EXISTS = new ErrorCode(1505, "筛选结果不存在");
    ErrorCode SCREEN_DRUGS_NOT_EXISTS = new ErrorCode(1506, "筛选药物不存在");
    ErrorCode IPA_DISEASE_ALL_NOT_EXISTS = new ErrorCode(1507, "ipa预测适应症all不存在");
    ErrorCode IPA_DISEASE_SINGLE_NOT_EXISTS = new ErrorCode(1508, "ipa预测适应症single不存在");
    ErrorCode MD_NOT_EXISTS = new ErrorCode(1509, "分子动力学模拟结果列不存在");
    ErrorCode MESSAGE_NOT_EXISTS = new ErrorCode(1510, "用户消息不存在");
}