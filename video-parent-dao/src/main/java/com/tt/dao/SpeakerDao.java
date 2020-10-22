package com.tt.dao;

import com.tt.pojo.Speaker;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Speaker)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-20 15:13:19
 */
public interface SpeakerDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Speaker queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Speaker> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param speaker 实例对象
     * @return 对象列表
     */
    List<Speaker> queryAll(Speaker speaker);

    /**
     * 新增数据
     *
     * @param speaker 实例对象
     * @return 影响行数
     */
    int insert(Speaker speaker);

    /**
     * 修改数据
     *
     * @param speaker 实例对象
     * @return 影响行数
     */
    int update(Speaker speaker);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}