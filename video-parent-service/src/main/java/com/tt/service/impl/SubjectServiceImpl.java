package com.tt.service.impl;

import com.tt.pojo.Subject;
import com.tt.dao.SubjectDao;
import com.tt.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 学科表，存储各个学科的名字(Subject)表服务实现类
 *
 * @author makejava
 * @since 2020-10-20 15:13:19
 */
@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectDao subjectDao;

    @Override
    public List<Subject> selectAll() {
        return subjectDao.selectAll();
    }

    @Override
    public Subject selectSubjectById(String id) {
        return subjectDao.selectSubjectById(id);
    }
}