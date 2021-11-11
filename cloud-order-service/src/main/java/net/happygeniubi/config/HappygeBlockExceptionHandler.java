package net.happygeniubi.config;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Sentinel自定义异常返回
 * FlowException //限流异常
 * DegradeException //降级异常
 * ParamFlowException //参数限流异常
 * SystemBlockException //系统负载异常
 * AuthorityException //授权异常
 */
@Component
public class HappygeBlockExceptionHandler implements BlockExceptionHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        Map<String, Object> info = new HashMap<>();
        if(e instanceof FlowException) {
            info.put("code", -100);
            info.put("msg", "限流异常");
        }
        if(e instanceof DegradeException) {
            info.put("code", -200);
            info.put("msg", "降级异常");
        }
        if(e instanceof ParamFlowException) {
            info.put("code", -300);
            info.put("msg", "参数限流异常");
        }
        if(e instanceof SystemBlockException) {
            info.put("code", -400);
            info.put("msg", "系统负载异常");
        }
        if(e instanceof AuthorityException) {
            info.put("code", -500);
            info.put("msg", "授权异常");
        }

        // 设置Json返回
        httpServletResponse.setStatus(200);
        httpServletResponse.setHeader("contentType","application/json;charset=UTF-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(info));
    }
}
