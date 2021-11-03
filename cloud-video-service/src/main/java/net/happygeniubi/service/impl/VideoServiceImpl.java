package net.happygeniubi.service.impl;

import net.happygeniubi.dao.VideoMapper;
import net.happygeniubi.domain.Video;
import net.happygeniubi.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public Video findById(int videoId) {
        return videoMapper.findById(videoId);
    }
}
