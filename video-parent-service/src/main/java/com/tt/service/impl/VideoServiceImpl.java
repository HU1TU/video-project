package com.tt.service.impl;

import com.tt.dao.VideoDao;
import com.tt.pojo.QueryVo;
import com.tt.pojo.Video;
import com.tt.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Video)表服务实现类
 *
 * @author makejava
 * @since 2020-10-20 15:13:19
 */
@Service
public class VideoServiceImpl implements VideoService {
  @Autowired
  private VideoDao videoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Video queryById(Integer id) {
        return videoDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Video> queryAllByLimit(int offset, int limit) {
        return this.videoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param video 实例对象
     * @return 实例对象
     */
    @Override
    public void insert(Video video) {
        videoDao.insert(video);
    }

    /**
     * 修改数据
     *
     * @param video 实例对象
     * @return 实例对象
     */
    @Override
    public void update(Video video) {
        videoDao.update(video);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer id) {
        return videoDao.deleteById(id);
    }

    @Override
    public List<Video> findAll(QueryVo queryVo) {
        return videoDao.queryAll(queryVo);
    }


    @Override
    public Video findVideo(Integer id) {
        return videoDao.findVideo(id);
    }

    @Override
    public void deleteVideos(String[] ids) {
        videoDao.deleteVideos(ids);
    }
}