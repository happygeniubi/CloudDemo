package net.happygeniubi.controller;

import net.happygeniubi.domain.Video;
import net.happygeniubi.domain.VideoOrder;
import net.happygeniubi.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("api/v1/video_order")
public class OrderController {

//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Autowired
//    private DiscoveryClient discoveryClient;

    @Autowired
    VideoService videoService;

    @RequestMapping("/find_by_id")
    public Object findById(int videoId) {
//        Video video = restTemplate.getForObject("http://localhost:9000/api/v1/video/find_by_id?videoId="
//                + videoId, Video.class);

        // 集群的话有可能拿到多个.
//        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("cloud-video-service");
//        ServiceInstance serviceInstance = serviceInstanceList.get(0);

//        Video video = restTemplate.getForObject("http://cloud-video-service/api/v1/video/find_by_id?videoId="
//                + videoId, Video.class);

        Video video = videoService.findById(videoId);

        VideoOrder videoOrder = new VideoOrder();
        videoOrder.setVideoId(video.getId());
        videoOrder.setVideoTitle(video.getTitle());
        videoOrder.setCreateTime(new Date());
        videoOrder.setServerInfo(video.getServeInfo());
        return videoOrder;
    }

    /**
     * 测试feign 使用post方式传输对象
     * @param video
     * @return
     */
    @RequestMapping("/save")
    public Object Save(@RequestBody Video video) {
        int row = videoService.save(video);
        HashMap<String, Object> map = new HashMap<>();
        map.put("row", row);
        return map;
    }

    /**
     * 测试Sentinel流控(通过线程数)
     * @return
     */
    @RequestMapping("/list")
    public Object list() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, String> map = new HashMap<>();
        map.put("title1", "alibaba");
        map.put("title2", "happygeniubi");
        return map;
    }
}
