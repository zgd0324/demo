package com.epf.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.epf.demo.entity.User;
import com.epf.demo.service.UserService;
import com.epf.demo.util.UuidUtil;

@Controller
@RequestMapping("/user")
public class LoginController {
	
	@Autowired
    private UserService userService;
	
 
	//跳转首页（登录页）
    @GetMapping("/index")
    public String index(){
        return "login";
    }
 
    //登录操作
    @ResponseBody
    @PostMapping("/login")
    public String login(User user, HttpServletRequest request){
    	String imgcode = (String) request.getSession().getAttribute("imgcode");
    	if(!imgcode.equals(user.getImgcode())){
    		return "codeerror";
    	}
        
    	User u = userService.login(user);
        if (u == null){
            return "usererror";
        }else{
        	//登录成功后将用户放入session中，用于拦截
            request.getSession().setAttribute("user",user);
            return "success";
        }
    }

    //测试未登陆能否拦截主页面
    @GetMapping("/home")
    public String home(Model model, HttpServletRequest request){
    	model.addAttribute("username", ((User) request.getSession().getAttribute("user")).getUsername());
        return "home";
    }
 
    //退出登录
    @GetMapping("/out")
    public void out(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("user");
        response.sendRedirect("/user/index");
    }
    
    //跳转注册页面
    @GetMapping("/toRegister")
    public String toRegister() throws IOException {
        return "register";
    }
    
    //注册操作
    @ResponseBody
    @PostMapping("/register")
    public String register(User user){
    	User u = userService.login(user);
    	if(u != null){
    		return "usererror";
    	}
    	
    	user.setId(UuidUtil.get32UUID());
        int result = userService.register(user);
        if(result == 0){
        	return "servererror";
        }
        
        return "success";
    }
    
}
