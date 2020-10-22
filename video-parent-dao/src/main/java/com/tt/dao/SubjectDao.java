package com.tt.dao;

import com.tt.pojo.Subject;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Zeux
 * @Create by 2020/10/20 16:55
 */
@Repository
public interface SubjectDao {


    List<Subject> selectAll();

    Subject selectSubjectById(String id);
}