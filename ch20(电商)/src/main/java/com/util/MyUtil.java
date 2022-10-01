package com.util;

import com.pojo.Buser;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @package: com.util
 * @className: MyUtil
 * @author: SleepWalker
 * @description: 工具类
 * @date: 21:41
 * @version: 1.0
 */
public class MyUtil {
    /**
     * @param
     * @return String
     * @author SleepWalker
     * @description 获得时间字符串
     * @date  21:49
     */
    public static String getStringID() {
        String id = null;
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        id = simpleDateFormat.format(date);

        return id;
    }

    /**
     * @param session :
     * @return long
     * @author SleepWalker
     * @description 获得前台登录ID
     * @date  21:52
     */
    public static long getUserId(HttpSession session) {
        Buser buser = (Buser)session.getAttribute("bruser");
        return buser.getId();
    }
}
