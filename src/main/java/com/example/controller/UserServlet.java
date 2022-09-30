package com.example.controller;

import com.example.pojo.User;
import com.example.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author code clone detection group
 * @version 1.0
 * @email martinchan709@gmail.com
 */
//@WebServlet("/user")
@WebServlet(name = "user", value = "/user")
public class UserServlet extends HttpServlet {

    private UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("UTF-8");//防止中文乱码

        String method = req.getParameter("method");
        if (method == null){
            method="findAll";
        }
        switch (method){
            case "findAll":
                List<User> list = userDao.findAll();
                req.setAttribute("list",list);
                req.getRequestDispatcher("/index.jsp").forward(req,resp);
                break;
            case "delete"://删除操作
                String idStr=req.getParameter("id");
                Integer id=Integer.parseInt(idStr);
                userDao.deleteById(id);//根据id删除
                resp.sendRedirect("/user");
                break;
            case "findById":
                idStr=req.getParameter("id");
                id=Integer.parseInt(idStr);
                req.setAttribute("user",userDao.findById(id));
                req.getRequestDispatcher("/update.jsp").forward(req,resp);
                break;
            case "add":
                req.getRequestDispatcher("add.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("UTF-8");//防止中文乱码
        String method=req.getParameter("method");
        switch (method){
            case "add"://添加操作
                //获取前端传来的数据
                String idStr=req.getParameter("id");
                String name=req.getParameter("name");
                Integer id=Integer.parseInt(idStr);//转化为整型
                userDao.add(id,name);//调用add方法
                break;
            case "update"://更新操作
                idStr=req.getParameter("id");
                name=req.getParameter("name");
                id=Integer.parseInt(idStr);
                userDao.update(id, name);
                break;
        }
        resp.sendRedirect("/user");//重定向到index.jsp页面
    }
}
