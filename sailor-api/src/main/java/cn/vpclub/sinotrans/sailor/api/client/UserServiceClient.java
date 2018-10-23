package cn.vpclub.sinotrans.sailor.api.client;

import cn.vpclub.sinotrans.sailor.feign.feignClient.UserClient;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by chentao on 2018/7/25.
 */
@FeignClient("${feign-client.userinfo-server}")
public interface UserServiceClient extends UserClient {
}
