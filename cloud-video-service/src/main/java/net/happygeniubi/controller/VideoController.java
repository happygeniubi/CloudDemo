package net.happygeniubi.controller;

import net.happygeniubi.domain.Video;
import net.happygeniubi.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/v1/video")
public class VideoController {
    
    @Autowired
    private VideoService videoService;

    @RequestMapping("/find_by_id")
    public Object findById(int videoId, HttpServletRequest request) {
        String serverName = request.getServerName();
        int port = request.getServerPort();
        Video video = videoService.findById(videoId);
        video.setServeInfo(serverName + ":" + port);
        return video;
    }
}
