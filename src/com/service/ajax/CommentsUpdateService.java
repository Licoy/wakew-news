package com.service.ajax;

import com.beans.Comments;
import com.dao.CommentsDao;
import com.utils.Tools;
import org.tuckey.noclash.gzipfilter.org.apache.commons.lang.StringEscapeUtils;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by Licoy on 2016/12/22 0022.
 */
public class CommentsUpdateService {
    private CommentsDao commentsDao  = new CommentsDao();
    /*
    * 查找指定ID的评论
    * */
    public Comments FindCommentsById(int id){
        return commentsDao.selectCommentsById(id);
    }

    /*
    * 获取指定评论的内容
    * */
    public Map<String,String> getCommentsTextById(int id){
        Map<String,String> map = new HashMap<>();
        Comments comments = FindCommentsById(id);
        if(comments==null){
            map.put("code","403");
            map.put("msg","不存在目标评论!");
        }else{
            map.put("code","200");
            map.put("msg","查询成功!");
            map.put("text",comments.getText());
        }
        return map;
    }

    /*
    * 修改指定评论的内容
    * */
    public Map<String,String> updateCommentsTextById(int id,String text){
        Map<String,String> map = new HashMap<>();
        Comments comments = FindCommentsById(id);
        if(comments==null){
            map.put("code","403");
            map.put("msg","不存在目标评论!");
        }else{
            comments.setText(Tools.htmlEscape(text));
            int num = commentsDao.updateCommentsByObject(comments);
            if(num>0){
                map.put("code","200");
                map.put("msg","修改成功!");
            }else{
                map.put("code","403");
                map.put("msg","修改失败!");
            }
        }
        return map;
    }
}
