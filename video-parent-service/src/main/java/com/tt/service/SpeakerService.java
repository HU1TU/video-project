package com.tt.service;

import com.tt.pojo.Speaker;
import java.util.List;

/**
 * (Speaker)表服务接口
 *
 * @author makejava
 * @since 2020-10-20 15:13:19
 */
public interface SpeakerService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Speaker queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Speaker> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param speaker 实例对象
     * @return 实例对象
     */
    void insert(Speaker speaker);

    /**
     * 修改数据
     *
     * @param speaker 实例对象
     */
    void update(Speaker speaker);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    int deleteById(Integer id);

    List<Speaker> findAll();


    Speaker findById(Integer id);
}