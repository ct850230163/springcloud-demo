package cn.vpclub.sinotrans.sailor.api.web;



import cn.vpclub.demo.common.model.core.enums.ReturnCodeEnum;
import cn.vpclub.demo.common.model.core.model.response.BaseResponse;
import cn.vpclub.wuhan.redis.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 服务基础服务Controller抽象类
 * <p>
 * Created by HJ on 2016/4/19.
 */
@ControllerAdvice
@Slf4j
public abstract class BaseController {
    @Autowired
    private RedisUtils redis;
    /**
     * 异常拦截处理
     *
     * @param exp
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public void handleException(Exception exp, HttpServletRequest request, HttpServletResponse response) {
        BaseResponse respInfo = new BaseResponse();
        Long currentTime = System.currentTimeMillis();
        respInfo.setReturnCode(ReturnCodeEnum.CODE_1004.getCode());
        respInfo.setMessage("服务器繁忙");
        log.error("服务处理异常: " + currentTime + exp.getMessage(), exp);

    }

    /**
     * 请求方的IP地址
     *
     * @param request
     * @return
     */
    public String getRemoteHost(HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
    }

    protected String getLoginInfo() {
        HttpServletRequest request = getRequest();
        String token = request.getHeader("token");
        String getLoginInfo =  redis.get(token);
        return getLoginInfo;
    }


    /**得到request对象
     * @return
     */
    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }
}
