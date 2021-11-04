package net.happygeniubi.domain;

import lombok.Data;

import java.util.Date;

@Data
public class VideoOrder {
    private Integer id;
    private String outTradeNo;
    private Integer state;
    private Date createTime;
    private  Integer totalFee;
    private Integer videoId;
    private String videoTitle;
    private String videoImg;
    private Integer userId;

    // 测试使用,表示调用的是哪一个服务(多节点情况下)
    private String serverInfo;
}
