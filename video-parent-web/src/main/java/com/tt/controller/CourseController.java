package com.tt.controller;

import com.tt.pojo.Course;
import com.tt.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Course)表控制层
 *
 * @author makejava
 * @since 2020-10-20 15:13:19
 */
@Controller
@RequestMapping("course")
public class CourseController {
    /**
     * 服务对象
     */
    @Autowired
    private CourseService courseService;

    @RequestMapping("selectOne")
    public Course selectOne(Integer id) {
        return this.courseService.queryById(id);
    }

}