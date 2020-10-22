package com.tt.controller;

import com.tt.pojo.Subject;
import com.tt.service.CourseService;
import com.tt.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author Zeux
 * @Create by 2020/10/20 16:09
 */

@Controller
@RequestMapping("course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private SubjectService subjectService;


    @RequestMapping("course/{subjectId}")
    public ModelAndView course(@PathVariable String subjectId, ModelAndView modelAndView) {

        Subject subject = subjectService.selectSubjectById(subjectId);

        modelAndView.addObject("subject", subject);

        modelAndView.setViewName("before/course.jsp");

        return modelAndView;
    }
}

