package com.utils;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import org.json.JSONException;
import org.tuckey.noclash.gzipfilter.org.apache.commons.lang.StringUtils;
import sun.security.util.Length;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Created by Licoy on 2016/12/19 0019.
 */
public class Tools {
    /**
    * 格式化日期
     * @param ms
    * */
    public static String dateFormat(long ms){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(new Date(ms));
        return date;
    }

    /**
    * 格式化日期包括时间
     * @param ms
    * */
    public static String dateFormatHasTime(long ms){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(new Date(ms));
        return date;
    }

    /**
    * 判断字符串是否为空
    * */
    public static boolean empty(String str){
        if(str==null){
            return true;
        }else{
            str = str.trim();
            if("".equals(str) || "null".equals(str)){
                return true;
            }
        }
        return false;
    }

    /*
    * 验证验证码是否一致
    * */
    public static boolean isCheckCode(HttpServletRequest request){
        String checkCode = request.getParameter("checkCode").toUpperCase();
        String checkCode_v = (request.getSession().getAttribute("checkCode")+"").toUpperCase();
        return checkCode.equals(checkCode_v);
    }

    /*
    * 获取客户端IP地址
    * */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /*
    * 验证是否是邮箱格式
    * */
    public static boolean isEmail(String email){
        String regEx = "^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /*
    * 验证是否符合注册名
    * */
    public static boolean isRegsterNamePswdModel(String str){
        String regEx = "^[a-zA-z]\\w{5,14}$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    /*
    * 验证是否符合密码的规范
    * */
    public static boolean checkPasswordModel(String password){
        return password.matches("^(\\w){6,15}$");
    }

    /*
    * 对HTML转义
    * */
    public static String htmlEscape(String content){
        if(content==null) return "";
        String html = content;
        html = StringUtils.replace(html, "'", "&apos;");
        html = StringUtils.replace(html, "\"", "&quot;");
        html = StringUtils.replace(html, "\t", "&nbsp;&nbsp;");// 替换跳格
        html = StringUtils.replace(html, " ", "&nbsp;");// 替换空格
        html = StringUtils.replace(html, "<", "&lt;");
        html = StringUtils.replace(html, ">", "&gt;");
        return html;
    }

    /*
    * 验证字符串是否是数字
    * */
    public static boolean isNumber(String number){
        if(number.matches("^[0-9]*$")){
            return true;
        }
        return false;
    }

    /*
    * 判断是否有权限访问此页面
    * */
    public static boolean isLevelOnPage(HttpServletRequest request,String d){
        String level = request.getSession().getAttribute("level")+"";
        String[] s = level.split(",");
        if(Arrays.asList(s).contains(d)){
            return true;
        }
        return false;
    }

    /*
    * 匹配文章的第一张图片，若没有则随机返回一张图片
    * */
    public static String matchFirstImage(String str){
        Pattern p = Pattern.compile("<img.*src\\s*=\\s*\"?(.*?)(\"|>|\\s+)");
        Matcher m = p.matcher(str);
        String imgSrc = null;
        while(m.find()) {
            imgSrc = m.group(1);
            if(imgSrc!=null){
                break;
            }
        }
        if(imgSrc==null){
            imgSrc = "/app/images/random/"+new Random().nextInt(10)+".jpg";
        }
        return imgSrc;
    }

    /*
    * 提取文章摘要
    * */
    public static String matchAbstract(String str,int length){
        if (str == null || str.trim().equals("")) {
            return "";
        }
        // 去掉所有html元素
        str = str.replaceAll("\\&[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "");
        str = str.replaceAll("[(/>)<]", "");
        int len = str.length();
        if (len <= length) {
            return str;
        } else {
            str = str.substring(0, length);
            str += "...";
        }
        return str;
    }
}
