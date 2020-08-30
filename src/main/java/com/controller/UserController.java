package com.controller;

import com.Result.Result;
import com.mapper.UserMapper;
import com.pojo.User;
import com.service.UserService;
import com.utils.VerifyCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


//    用户推出
    @RequestMapping("logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/back/login.jsp";
    }

    @RequestMapping("login")
    @ResponseBody
    public Result login(String code,User user,HttpSession session){
        Result result =new Result();
//        取出验证码
        String imagecode = (String) session.getAttribute("code");

        try {
            if (imagecode.equalsIgnoreCase(code)){
                User u = userService.login(user);
                session.setAttribute("user",u);//把用户存到session中
                result.setMsg("登陆成功");
                result.setStatue(true);
                return result;
            }
            throw new RuntimeException("验证码输入错误！！");
        }catch (Exception e){
            e.printStackTrace();
            result.setStatue(false);
            result.setMsg(e.getMessage());
        }
        return result;

    }


    @RequestMapping("register")
    @ResponseBody
    public Result register(User user) {
        Result result = new Result();
        try {
            userService.register(user);
            result.setMsg("注册成功");
            result.setStatue(true);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatue(false);
            result.setMsg(e.getMessage());
            return result;
        }


    }


    //    生成验证码
    @RequestMapping("getImage")
    public void getImage(HttpSession session, HttpServletResponse response) throws IOException {
//        1.获取随机数
        String code = VerifyCodeUtils.generateVerifyCode(4);//获取4位随机数
//        2.将数字存入session中
        session.setAttribute("code", code);
//        3.生成验证码图片
        VerifyCodeUtils.outputImage(120, 43, response.getOutputStream(), code);

    }
}

