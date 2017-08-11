package com.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

@WebServlet(name = "UploadImages", urlPatterns = {"/UploadImages"})
@MultipartConfig
public class UploadImages extends HttpServlet {
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
        Collection<Part> parts = request.getParts();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String nowDate = simpleDateFormat.format(new Date());
        File file = new File(getServletContext().getRealPath(File.separator+"upload"+File.separator+nowDate));
        if(!file.exists() && !file.isDirectory()){
            file.mkdirs();
        }
        for(Part part:parts){
            this.startUpload(part,request,response,nowDate);
        }


    }

    public void startUpload(Part part,HttpServletRequest request,HttpServletResponse response,String nowDate) throws IOException {
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
        response.getWriter().write(request.getContextPath() +File.separator +"upload" + File.separator+nowDate+File.separator+ realName);

    }
}