package com.east.sword.livestock.base;

import com.east.sword.livestock.config.WxMpServiceLive;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @CreateDate 16:00 2020/3/12.
 * @Author ZZD
 */
@Slf4j
@Controller
public class BaseController {

    private static Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();

    @Autowired
    private WxMpServiceLive wxMpService;

    @ResponseBody
    @GetMapping("/")
    public String validateSign(@RequestParam("signature") String signature,
                                @RequestParam("timestamp") String timestamp,
                                @RequestParam("nonce") String nonce,
                                @RequestParam("echostr") String echostr) {

        if (!wxMpService.checkSignature(timestamp, nonce, signature)) {

            // 消息签名不正确，说明不是公众平台发过来的消息
            return "非法请求";
        } else {
            return echostr;
        }
    }

    @ResponseBody
    @PostMapping("/")
    public String validateMessage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        WxMpXmlMessage xmlMessage = WxMpXmlMessage.fromXml(request.getInputStream());

        log.info(xmlMessage.toString());



        return null;

    }
}
