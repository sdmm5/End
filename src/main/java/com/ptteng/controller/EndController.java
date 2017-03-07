package com.ptteng.controller;

import com.ptteng.dao.StudentDao;
import com.ptteng.dao.VocationDao;
import com.ptteng.entity.Student;
import com.ptteng.entity.Vocation;
import com.ptteng.util.DESUtil;
import com.ptteng.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by maweijiang on 2017/3/6.
 */
@Controller
public class EndController {
    @Autowired
    private StudentDao dao;

    @Autowired
    private VocationDao vocationDao;

    @Autowired
    private DESUtil desUtil;


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHomeInfo(ModelMap modelMap){
        List<Student> list = dao.findAllGoodStudent();
        modelMap.put("list",list);
        return "home";
    }

    @RequestMapping(value = "/u/courseList", method = RequestMethod.GET)
    public String getTextInfo(ModelMap modelMap){

        List<Vocation> list1 = vocationDao.getVocationsWithDirection(1);
        List<Vocation> list2 = vocationDao.getVocationsWithDirection(2);
        List<Vocation> list3 = vocationDao.getVocationsWithDirection(3);
        List<Vocation> list4 = vocationDao.getVocationsWithDirection(4);
        List<Vocation> list5 = vocationDao.getVocationsWithDirection(5);

        List list = new ArrayList();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        list.add(list5);

        modelMap.put("list",list);

        return "courseList";
    }

    @RequestMapping(value = "/getCourseList",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getCourseList(HttpServletRequest request) throws IOException{
        List<Student> list = vocationDao.getVocationsWithDirection(1);
        Map map = new HashMap<String,Object>();
        map.put("list",list);
        return map;
    }

    @RequestMapping(value = "/regist",method = RequestMethod.GET)
    public String goRegisterJSP(){
        return "register";
    }


    @RequestMapping(value="registAccount",method = RequestMethod.POST)
    public void register(HttpServletRequest request, HttpServletResponse response, @RequestParam("phone") String phone,@RequestParam("password") String password){

        if (phone == null || phone.length() == 0){
            try{
                response.sendRedirect("End/regist");
            }catch (Exception e){

            }
            return;
        }
        Student student = new Student();
        student.setPhone(Long.parseLong(phone));
        student.setPassword(MD5Util.stringToMD5(password));
        student.setStu_name("叶良成");
        dao.addStudent(student);
        try{
            response.sendRedirect("/End/login");
        }catch(Exception e){

        }
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value="/loginIn",method = RequestMethod.POST)
    public String login(HttpServletRequest request,HttpServletResponse response,@RequestParam("phone") String p,@RequestParam String password){

        if (password.length() == 0){
            try{
                response.sendRedirect("/End/login");
            }catch (Exception e){

            }
            return null;
        }
        long phone = Long.parseLong(p);
        Student stu = dao.findStudentByPhone(phone);
        if (!stu.getPassword().equals(MD5Util.stringToMD5(password))){
            return "login";
        }
        request.getSession().setAttribute("student",stu);
        //将token加密存到token里面
        String token = stu.getId()+"|" + System.currentTimeMillis();
        byte[] bytes = desUtil.encrypt(token.getBytes(),"12345678");
        Cookie cookie = new Cookie("token",org.apache.commons.codec.binary.Base64.encodeBase64String(bytes));
        //设置cookie的有效期
        cookie.setMaxAge(60 * 60 * 24 * 7);
        //将cookie写入到客户端浏览器
        response.addCookie(cookie);
        try{
            response.sendRedirect("/End/home");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }



}
