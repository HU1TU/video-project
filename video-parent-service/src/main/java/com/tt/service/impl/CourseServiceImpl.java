package com.tt.service.impl;

import com.tt.pojo.Course;
import com.tt.dao.CourseDao;
import com.tt.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Course)表服务实现类
 *
 * @author makejava
 * @since 2020-10-20 15:13:19
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public Course queryById(Integer id) {
        return null;
    }

    @Override
    public List<Course> queryAllByLimit(int offset, int limit) {
        return null;
    }

    @Override
    public Course insert(Course course) {
        return null;
    }

    @Override
    public Course update(Course course) {
        return null;
    }

    @Override
    public int deleteById(Integer id) {
        return 0;
    }

    @Override
    public List<Course> findAll() {
        return courseDao.queryAll(null);
    }
}