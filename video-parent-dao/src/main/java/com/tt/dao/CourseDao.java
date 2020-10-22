package com.tt.dao;

import com.tt.pojo.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Zeux
 * @Create by 2020/10/20 16:54
 */

@Repository
public interface CourseDao {

    Course selectCourseById(String id);

    List<Course> selectAll();
}