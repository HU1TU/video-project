package com.tt.service.impl;

import com.tt.pojo.Speaker;
import com.tt.dao.SpeakerDao;
import com.tt.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Speaker)表服务实现类
 *
 * @author makejava
 * @since 2020-10-20 15:13:19
 */
@Service
public class SpeakerServiceImpl implements SpeakerService {

    @Autowired
    private SpeakerDao speakerDao;

    @Override
    public Speaker queryById(Integer id) {
        return speakerDao.queryById(id);
    }

    @Override
    public List<Speaker> queryAllByLimit(int offset, int limit) {
        return speakerDao.queryAllByLimit(offset, limit);
    }

    @Override
    public void insert(Speaker speaker) {
        speakerDao.insert(speaker);
    }

    @Override
    public void update(Speaker speaker) {
        Speaker speaker1 = speakerDao.queryById(speaker.getId());

        if (speaker1 == null) {
            speakerDao.insert(speaker);
        } else {
            speakerDao.update(speaker);
        }
    }

    @Override
    public int deleteById(Integer id) {
        return speakerDao.deleteById(id);
    }

    @Override
    public List<Speaker> findAll() {
        return speakerDao.queryAll(null);
    }

    @Override
    public Speaker findById(Integer id) {
        return speakerDao.queryById(id);
    }
}