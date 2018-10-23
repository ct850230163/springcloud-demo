package cn.vpclub.sinotrans.sailor.api.web;

import cn.vpclub.demo.common.model.core.enums.ReturnCodeEnum;
import cn.vpclub.demo.common.model.core.model.response.BackResponseUtil;
import cn.vpclub.demo.common.model.core.model.response.BaseResponse;

import cn.vpclub.demo.common.model.utils.common.JsonUtil;

import cn.vpclub.sinotrans.sailor.api.service.UserService;
import cn.vpclub.sinotrans.sailor.feign.domain.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;





/**
 * Created by chentao on 2018/6/6.
 */
@RestController
@Slf4j
@RequestMapping("user")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;



    /**
     * 根据id查询
     * @param userId
     * @author chentao
     */
    @RequestMapping(value = "/getUserById")
    public BaseResponse getUserById(@RequestParam("userId")Long userId){
        log.info("the method getUserById:{}", JsonUtil.objectToJson(userId));
        User user = userService.selectByUserId(userId);
        BaseResponse baseResponse= BackResponseUtil.getBaseResponse(ReturnCodeEnum.CODE_1000.getCode());
        baseResponse.setDataInfo(user);
        return baseResponse;
    }



}
