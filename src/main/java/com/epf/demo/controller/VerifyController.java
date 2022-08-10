package com.epf.demo.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.code.kaptcha.impl.DefaultKaptcha;

@Controller
@RequestMapping("/verify")
public class VerifyController {
	
	@Autowired
	private DefaultKaptcha defaultKaptcha;
	
	@GetMapping("/imgcode")
	public void defaultKaptcha(HttpServletRequest request,HttpServletResponse response) throws Exception{
	 	 byte[] captchaChallengeAsJpeg = null;  
         ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();  
        
         try {  
	         //生产验证码字符串并保存到session中
	         String createText = defaultKaptcha.createText();
	         request.getSession().setAttribute("imgcode", createText);
	         //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
	         BufferedImage challenge = defaultKaptcha.createImage(createText);
	         ImageIO.write(challenge, "jpg", jpegOutputStream);
         } catch (IllegalArgumentException e) {  
             response.sendError(response.SC_NOT_FOUND);  
             return;  
         } 
   
         //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
         captchaChallengeAsJpeg = jpegOutputStream.toByteArray();  
         response.setHeader("Cache-Control", "no-store");  
         response.setHeader("Pragma", "no-cache");  
         response.setDateHeader("Expires", 0);  
         response.setContentType("image/jpeg");  
        
         ServletOutputStream sos = response.getOutputStream();  
         sos.write(captchaChallengeAsJpeg);  
         sos.flush();  
         sos.close();  
	}

}
