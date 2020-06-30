package com.offcn.servlet;

import com.offcn.bean.User;
import com.offcn.service.UserService;
import com.offcn.service.impl.UserServiceImpl;
import com.offcn.utils.DateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1 设置请求的编码方式（一定要在获取数据之前）  post请求乱码解决
        request.setCharacterEncoding("UTF-8");

        // 2 获取客户端提交的数据 （从请求 request中去获取数据----------->request.getParameter）
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String sex = request.getParameter("sex");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");

        // 3 封装数据到实体类的对象中（传给service层和dao层）
        User user = new User();
        user.setSex(sex);
        user.setPassword(password);
        user.setName(name);
        user.setEmail(email);
        user.setUsername(username);
        user.setBirthday(DateUtil.stringToDate(birthday));

        //4 调用service层 （Service 层调用DAO层）
        UserService service = new UserServiceImpl();
        int result = service.addUser(user);

        if (result > 0) {
           // System.out.println("添加成功");
            response.sendRedirect("jsp/login.jsp");
        } else {
           // System.out.println("添加失败");
            response.sendRedirect("jsp/register.jsp");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
        // 解决get请求的乱码问题
        // tomcat8.5 已经解决了get请求的乱码问题。如果使用低版本的tomcat如何解决？ 修改tomcat的配置文件 server.xml

        /*
        <Connector port="8888" protocol="HTTP/1.1" URIEncoding="UTF-8"
               connectionTimeout="20000"
               redirectPort="8443" />

        * */

        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String email = request.getParameter("email");

        System.out.println(name + "\t" + age + "\t" + email);


    }
}

