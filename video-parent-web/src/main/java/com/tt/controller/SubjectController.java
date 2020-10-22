package com.tt.controller;

import com.tt.pojo.Subject;
import com.tt.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author Zeux
 * @Create by 2020/10/20 16:16
 */

@Controller
@RequestMapping("subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;


    @RequestMapping("/selectAll")
    public String selectAll(HttpServletRequest request) {
        ServletContext servletContext = request.getSession().getServletContext();
        List<Subject> subjectList = subjectService.selectAll();
        servletContext.setAttribute("subjectList", subjectList);
        return "/before/index.jsp";
    }
}