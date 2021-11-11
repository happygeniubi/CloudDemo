package net.happygeniubi.service.fallback;

import net.happygeniubi.domain.Video;
import net.happygeniubi.service.VideoService;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceFallback implements VideoService {

    @Override
    public Video findById(int videoId) {
        Video video = new Video();
        video.setTitle("fallBack默认视频");
        return video;
    }

    @Override
    public int save(Video video) {
        return -100;
    }
}
