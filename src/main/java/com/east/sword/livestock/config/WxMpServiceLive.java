package com.east.sword.livestock.config;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @CreateDate 16:28 2020/3/12.
 * @Author ZZD
 */
@Slf4j
@Component
public class WxMpServiceLive extends WxMpServiceImpl implements ApplicationRunner {


    @Override
    public void run(ApplicationArguments args){
        log.info("初始化配置微信信息");
        WxMpDefaultConfigImpl config = new WxMpDefaultConfigImpl();
        config.setAppId("wx508ab5fe325c4ae7"); // 设置微信公众号的appid
        config.setSecret("d2ec810d8f16d2a8e9a995dd6c45a2a7"); // 设置微信公众号的app corpSecret
        config.setToken("wechat"); // 设置微信公众号的token
        config.setAesKey("..."); // 设置微信公众号的EncodingAESKey
        this.setWxMpConfigStorage(config);

    }


}
