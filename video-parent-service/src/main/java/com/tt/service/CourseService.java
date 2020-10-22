package com.tt.service;

import com.tt.pojo.Course;
import java.util.List;

/**
 * @Author Zeux
 * @Create by 2020/10/20 17:12
 */
public interface CourseService {

    Course selectCourseById(String id);

    List<Course> selectAll();
}