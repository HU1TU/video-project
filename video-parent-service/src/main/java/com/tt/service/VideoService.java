package com.tt.service;

import com.tt.pojo.QueryVo;
import com.tt.pojo.Video;
import java.util.List;

/**
 * (Video)表服务接口
 *
 * @author makejava
 * @since 2020-10-20 15:13:19
 */
public interface VideoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Video queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Video> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param video 实例对象
     * @return 实例对象
     */
    void insert(Video video);

    /**
     * 修改数据
     *
     * @param video 实例对象
     */
    void update(Video video);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    int deleteById(Integer id);

    //查询所有视频
    List<Video> findAll(QueryVo queryVo);


    Video findVideo(Integer id);

    void deleteVideos(String[] ids);
}