package com.tt.controller;

import com.tt.pojo.Admin;
import com.tt.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * (Admin)表控制层
 *
 * @author makejava
 * @since 2020-10-20 15:13:18
 */
@Controller
@RequestMapping("admin")
public class AdminController {
    /**
     * 服务对象
     */
    @Autowired
    private AdminService adminService;


    @RequestMapping("loginView")
    public String loginView() {
        return "/behind/login.jsp";
    }


    @RequestMapping("login")
    @ResponseBody
    public String login(Admin admin, HttpServletRequest request) {
        Admin admin1 = adminService.login(admin);

        if (admin1 == null) {
            return "false";
        } else {
            HttpSession sessionScope = request.getSession();
            sessionScope.setAttribute("userName", admin.getUsername());
            return "success";

        }
    }
        @RequestMapping("exit")
        public String exit() {
            return "redirect:/admin/loginView";
        }

    }

