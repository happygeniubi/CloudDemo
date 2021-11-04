package net.happygeniubi.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Video {
    private Integer id;
    private String title;
    private String summary;
    private String coverImg;
    private Integer  price;
    private Date createTime;
    private Double point;

    // 测试使用,表示调用的是哪一个服务(多节点情况下)
    private String serveInfo;
}
