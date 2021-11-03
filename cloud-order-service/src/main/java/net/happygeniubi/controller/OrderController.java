package net.happygeniubi.controller;

import net.happygeniubi.domain.Video;
import net.happygeniubi.domain.VideoOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@RestController
@RequestMapping("api/v1/video_order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/save")
    public Object save(int videoId) {
        Video video = restTemplate.getForObject("http://localhost:9000/api/v1/video/find_by_id?videoId="
                + videoId, Video.class);

        VideoOrder videoOrder = new VideoOrder();
        videoOrder.setVideoId(video.getId());
        videoOrder.setVideoTitle(video.getTitle());
        videoOrder.setCreateTime(new Date());
        return videoOrder;
    }
}
