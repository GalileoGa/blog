package com.ning.blog.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum ReturnCode {
    SUCCESS("000000", "success", "成功"),
    ERROR("000001", "error", "失败");
//    ERROR("000001", "error", "失败"),
//    ERROR("000001", "error", "失败"),
//    ERROR("000001", "error", "失败"),
//    ERROR("000001", "error", "失败"),
//    ERROR("000001", "error", "失败"),
//    ERROR("000001", "error", "失败"),
//    ERROR("000001", "error", "失败"),
//    ERROR("000001", "error", "失败"),
//    ERROR("000001", "error", "失败"),
//    ERROR("000001", "error", "失败"),
//    ERROR("000001", "error", "失败"),
//    ERROR("000001", "error", "失败"),
//    ERROR("000001", "error", "失败"),
//    ERROR("000001", "error", "失败"),
//    ERROR("000001", "error", "失败"),
//    ERROR("000001", "error", "失败"),
//    ERROR("000001", "error", "失败"),
//    ERROR("000001", "error", "失败"),
//    ERROR("000001", "error", "失败"),
//    ERROR("000001", "error", "失败"),
//    ERROR("000001", "error", "失败"),
//    ERROR("000001", "error", "失败"),
//    ERROR("000001", "error", "失败"),
//    ERROR("000001", "error", "失败"),
//    ERROR("000001", "error", "失败"),
//    ERROR("000001", "error", "失败"),
//    ERROR("000001", "error", "失败"),
//    ERROR("000001", "error", "失败"),
//    ERROR("000001", "error", "失败"),
//    ERROR("000001", "error", "失败"),
//    ERROR("000001", "error", "失败"),
//    ERROR("000001", "error", "失败"),
//    ERROR("000001", "error", "失败"),
//    ERROR("000001", "error", "失败");

    private String code;
    private String englishDesc;
    private String chineseDesc;

    public static String str2JsonStr(final Object type) {
            if (null == type || type.equals(""))
            return "{'code':'-100000','chineseDesc':'类型为空','englishDesc':'type is null'}";
        for (ReturnCode code : ReturnCode.values()) {
            if (code.getCode().equals(type.toString())) {
                return "{'code':'" + code.getCode()
                        + "','chineseDesc':'" + code.getChineseDesc()
                        + "','englishDesc':'" + code.getEnglishDesc()
                        + "'}";
            }
        }
        return "{'code':'-200000','chineseDesc':'参数类型错误 ','englishDesc':'parameter is error'}";
    }
}
