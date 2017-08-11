package com.controller.user;

import com.beans.User;
import com.dao.UserDao;
import com.utils.CookieUtils;
import com.utils.Encrypt;
import com.utils.Tools;
import org.json.JSONArray;
import org.json.JSONException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet(name = "U_uploadImagesController", urlPatterns = {"/user/U_uploadImagesController"})
@MultipartConfig
public class U_uploadImagesController extends HttpServlet {
    private int fileSize = 1024*1024;
    private String[] allowedType = {"image/gif", "image/jpeg", "image/png" };
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String type = request.getParameter("type");
        Collection<Part> parts = request.getParts();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String nowDate = simpleDateFormat.format(new Date());
        File file = new File(getServletContext().getRealPath(File.separator+"upload"+File.separator+nowDate));
        if(!file.exists() && !file.isDirectory()){
            file.mkdirs();
        }
        for(Part part:parts){
            boolean g = false;
            if("grava".equals(type)){
                g = true;
            }
            this.startUpload(part,request,response,nowDate,g);
        }


    }

    public void startUpload(Part part,HttpServletRequest request,HttpServletResponse response,String nowDate,boolean g) throws IOException {
        boolean allowed = Arrays.asList(this.allowedType).contains(part.getContentType());
        if (!allowed) {
            response.getWriter().write("error|不支持的类型");
            return;
        }
        // 图片大小限制
        if (part.getSize() > this.fileSize) {
            response.getWriter().write("error|图片大小不能超过1M");
            return;
        }
        User user = null;
        UserDao userDao = null;
        if(g){
            Object id = request.getSession().getAttribute("id");
            if(id!=null && Tools.isNumber(id+"")){
                userDao = new UserDao();
                user = userDao.selectUserById(Integer.parseInt(id+""));
                if(user==null){
                    return;
                }
            }else{
                return;
            }
        }
        // 包含原始文件名的字符串
        String fi = part.getHeader("content-disposition");
        // 提取文件拓展名
        String fileNameExtension = fi.substring(fi.indexOf("."), fi.length() - 1);
        // 生成实际存储的真实文件名
        String realName = UUID.randomUUID().toString() + fileNameExtension;
        // 图片存放的真实路径
        String realPath = getServletContext().getRealPath(File.separator+"upload") + File.separator+nowDate+File.separator+ realName;
        // 将文件写入指定路径下
        part.write(realPath);
        // 返回图片的URL地址
        String imgPath = request.getContextPath() +File.separator +"upload" + File.separator+nowDate+File.separator+ realName;
        if(g){
            user.setGrava(imgPath);
            int num = userDao.updateUserByObject(user);
            String s = null;
            Map map = new HashMap();
            if(num>0){
                map.put("code",200);
                map.put("msg","头像更新成功!");
                map.put("url",imgPath);
            }else{
                map.put("code",403);
                map.put("msg","头像更新失败!");
            }
            JSONArray jsonArray = new JSONArray();
            jsonArray.put(map);
            try {
                response.getWriter().write(jsonArray.getString(0));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }else{
            response.getWriter().write(imgPath);
        }
    }
}