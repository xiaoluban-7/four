package com.xiaozhang.apple.common;

/**
 * @author : zhanggang
 * @version : v1.0
 * @description 封装api的错误码
 * @date : 2020/12/25 15:48
 */
public interface IErrorCode {
    long getCode();

    String getMessage();
}
