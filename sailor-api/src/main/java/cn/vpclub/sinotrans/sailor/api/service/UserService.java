package cn.vpclub.sinotrans.sailor.api.service;

import cn.vpclub.sinotrans.sailor.api.client.UserServiceClient;
import cn.vpclub.sinotrans.sailor.feign.domain.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chentao on 2018/6/6.
 */
@Service
@Slf4j
public class UserService {

    @Autowired
    private UserServiceClient userServiceClient;

    /**
     * 根据id查询用户信息
     * @param userId
     * @return
     */
    public User selectByUserId(Long userId) {
        return userServiceClient.selectByUserId(userId);
    }
}
