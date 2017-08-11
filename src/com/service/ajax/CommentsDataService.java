package com.service.ajax;

import com.beans.Comments;
import com.beans.User;
import com.dao.CommentsDao;
import com.dao.UserDao;
import com.utils.CookieUtils;
import com.utils.Encrypt;
import com.utils.Tools;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/*
 * Created by Licoy on 2016/12/28 0028.
 */
public class CommentsDataService {
    /*
    * 存放评论
    * */
    public Map<String,String> saveComments(HttpServletResponse response, int id, int parentId, String text, int newsId){
        Map<String,String> tipsMap = new HashMap<>();
        Comments comments = new Comments();
        text = Tools.matchAbstract(text,255);
        comments.setUser(id);
        comments.setContain(parentId);
        comments.setText(text);
        comments.setNews(newsId);
        int num = new CommentsDao().insertCommentsByObject(comments);
        if(num>0){
            CookieUtils.addCookie("lastCom",System.currentTimeMillis()+"",response);
            User user = new UserDao().selectUserById(id);
            tipsMap.put("code","200");
            tipsMap.put("msg","评论成功!");
            tipsMap.put("username",user.getUsername());
            tipsMap.put("id",user.getId()+"");
            tipsMap.put("grava",user.getGrava());
            tipsMap.put("text",text);
        }else{
            tipsMap.put("code","403");
            tipsMap.put("msg","评论失败!");
        }
        return tipsMap;
    }
}
