package com.controller;

import com.bean.Userbean;
import com.service.UserService;
import com.serviceimpl.UserServiceImpl;
import com.utils.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.SQLException;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    //跳转进入signup界面
    @RequestMapping("/signUp")
    public String signUp(){
        return "register";
    }

    //判断可不可用
    @RequestMapping("/signUp/checkExist")
    public @ResponseBody Userbean checkExist(String user_phone){
        Userbean userbean=userService.getUser(user_phone);
        if(userbean!=null){
            System.out.print("号码注册");
            return userbean;
        }else {
            System.out.print("号码可以用");
            return null;
        }
    }

    @RequestMapping("/signUp/save")
    public ModelAndView signupsave(Userbean userbean){
        ModelAndView mv=new ModelAndView();
        if(userService.isExistedByphone(userbean.getUser_phone())==0){
            System.out.println("此时phone为:"+userbean.getUser_phone());
            userbean.setUser_salt(Hashing.salt());
            userbean.setUser_hash(Hashing.SHA(
                    userbean.getUser_password() + userbean.getUser_salt(), "SHA-256"));
            userbean.setUser_money(20000);
            System.out.println(userbean.getUser_password());
            userService.save(userbean);
            mv.setView(new RedirectView("showindex"));//转发
        }else {
            mv.addObject("done",1);//用户已经存在
            mv.setViewName("register");
           }
           return mv;
        }

        @RequestMapping("/signIn/checkExist")
        public @ResponseBody Userbean signCheckexist(String user_phone){
              Userbean userbean=userService.getUser(user_phone);
              if(userbean!=null){
                  return userbean;
              }else
                  return null;
        }
        @RequestMapping("/signIn")
        public ModelAndView signIn(String user_phone,String user_password) {
            String nowhash=null;
            ModelAndView mv=new ModelAndView();
            Userbean userbean=userService.getUser(user_phone);
            if(userbean==null){
                System.out.print("用户不存在");
                mv.addObject("done","用户不存在");
                mv.setViewName("index");
            }else {
                nowhash = Hashing.SHA(user_password + userbean.getUser_salt(), "SHA-256");
                if (nowhash.equals(userbean.getUser_hash())){
                    mv.addObject("done","登录成功");
                    mv.addObject("user",userbean);
                    mv.setViewName("showindex");
                    System.out.print("登录成功");
                }else{
                    mv.addObject("done","用户或密码错误");
                    mv.setViewName("index");
                    System.out.print("用户或密码错误");
                }
            }
            return mv;
        }



    }


