package com.tt.controller;

import com.tt.pojo.Subject;
import com.tt.service.SubjectService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 学科表，存储各个学科的名字(Subject)表控制层
 *
 * @author makejava
 * @since 2020-10-20 15:13:19
 */
@RestController
@RequestMapping("subject")
public class SubjectController {
    /**
     * 服务对象
     */
    @Resource
    private SubjectService subjectService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Subject selectOne(Integer id) {
        return this.subjectService.queryById(id);
    }

}