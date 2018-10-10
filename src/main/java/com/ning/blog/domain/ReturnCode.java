package com.ning.blog.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public enum ReturnCode {
    SUCCESS("000000", "success", "成功"),
    ERROR("000001", "error", "失败"),
    LOGINERROR("000002", "Incorrect username or password", "账号或密码错误");
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

    public static String str2JsonStr(final String code) {
        if (null == code || code.equals(""))
            return "{\"code\":\"-100000\",\"chineseDesc\":\"类型为空\",\"englishDesc\":\"type is null\"}";
        for (ReturnCode returnCodeode : ReturnCode.values()) {
            if (returnCodeode.getCode().equals(code)) {
                return "{\"code\":\"" + returnCodeode.getCode()
                        + "\",\"chineseDesc\":\"" + returnCodeode.getChineseDesc()
                        + "\",\"englishDesc\":\"" + returnCodeode.getEnglishDesc()
                        + "\"}";
            }
        }
        return "{\"code\":\"-200000\",\"chineseDesc\":\"参数类型错误 \",\"englishDesc\":\"parameter is error\"}";
    }
}
