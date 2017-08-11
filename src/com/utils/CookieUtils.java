package com.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Created by Licoy on 2016/12/20 0020.
 */
public class CookieUtils {
    /*
    * 添加Cookie
    * */
    public static void addCookie(String key, String value, HttpServletResponse response){
        Cookie cookie = new Cookie(key,Encrypt.base64Encode(value));
        cookie.setPath("/");
        cookie.setMaxAge(86400*30);
        response.addCookie(cookie);
    }

    /*
    * 清除Cookie
    * */
    public static void clearCookie(String key,HttpServletResponse response){
        Cookie cookie = new Cookie(key,null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    /*
    * 查找Cookie
    * */
    public static String FindCookie(String key, HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        String str = null;
        if(cookies.length>0){
            for(Cookie c:cookies){
                if(key.equals(c.getName())){
                    str =  c.getValue();
                    break;
                }
            }
        }
        if(str!=null){
            str = Encrypt.base64Decode(str);
        }
        return str;
    }

    /*
    * 获取头像Cookie
    * */
    public static String getGravaCookie(HttpServletRequest request){
        return FindCookie("Grava",request);
    }
}
