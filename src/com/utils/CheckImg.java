package com.utils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

@WebServlet(name = "CheckImg", urlPatterns = {"/CheckImg.do"})
public class CheckImg extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "No-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        int width = 270;
        int height = 60;
        String str = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLNMOPQRSTUVWXYZ";
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics g =  image.getGraphics();

        String imgPath = request.getServletContext().getRealPath("/app/img/bg.jpg");
        Image bg = ImageIO.read(new File(imgPath));
        g.drawImage(bg,0,0,width,height,null);

//        System.out.println(imgPath);
        Font font = new Font("幼圆",Font.BOLD,30);
        g.setFont(font);
        Random r = new Random();
        StringBuffer checkCode = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(str.length()-1);
            char code = str.charAt(index);
            g.setColor(this.getColor());
            g.drawString(code+"", 50+i*20, 30+new Random().nextInt(10));
            g.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width), r.nextInt(height));
            checkCode.append(code);
        }
        g.dispose();
        OutputStream out = response.getOutputStream();
        ImageIO.write(image,"jpg",out);
        out.flush();
        out.close();
        request.getSession().setAttribute("checkCode",checkCode);
    }

    public Color getColor(){
        Random random = new Random();
        int R = 50+random.nextInt(205);
        int G = 50+random.nextInt(205);
        int B = 50+random.nextInt(205);
        Color color = new Color(R,G,B);
        return color;
    }
}