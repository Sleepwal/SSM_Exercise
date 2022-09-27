package com.exception;

/**
 * @package: com.exception
 * @className: UserLoginNoException
 * @author: SleepWalker
 * @description: 用户未登录
 * @date: 17:00
 * @version: 1.0
 */
public class UserLoginNoException extends Exception {
    private static final long serialVersionUID = 1L;

    public UserLoginNoException() {
    }

    public UserLoginNoException(String message) {
        super(message);
    }

}
