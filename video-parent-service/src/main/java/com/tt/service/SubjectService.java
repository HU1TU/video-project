package com.tt.service;

import com.tt.pojo.Subject;
import java.util.List;

/**
 * @Author Zeux
 * @Create by 2020/10/20 17:16
 */
public interface SubjectService {

    List<Subject> selectAll();

    Subject selectSubjectById(String id);
}