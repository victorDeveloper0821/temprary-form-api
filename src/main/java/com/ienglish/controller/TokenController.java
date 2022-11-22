package com.ienglish.controller;

import com.ienglish.domain.TokenInfo;
import com.ienglish.model.PersonalInfo;
import com.ienglish.service.TokenService;
import com.ienglish.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/api/v1")
public class TokenController {

    @Autowired
    private TokenService tokenService;


    @RequestMapping(value = "/token", method = {RequestMethod.POST})
    @ResponseBody
    public String createTokenInfo(@RequestBody PersonalInfo info) {
        LogUtils.d("Data Payloads",info.toString());
        LogUtils.i("restful api", "create token operation");
        return "create Token Info";
    }

    @RequestMapping(value = "/token/{token}", method = {RequestMethod.GET, RequestMethod.DELETE})
    @ResponseBody
    public TokenInfo getTokenInfo(HttpServletRequest req, @PathVariable("token") String token) {
        String method = req.getMethod();
        TokenInfo aa = tokenService.getTokenInfoByToken(token);
        if (method.equalsIgnoreCase("GET")) {
            LogUtils.i("restful api", "Query Token Information");
        } else {
            LogUtils.i("restful api", "Delete Token Information");
        }
        return aa;
    }

    @RequestMapping(value = "/token/{token}", method = {RequestMethod.PUT})
    @ResponseBody
    public String updateTokenInfo(@PathVariable("token") String token, @RequestBody PersonalInfo info) {
        LogUtils.i("restful api", "Update Token Information");
        return "update Token Info";
    }

    @RequestMapping(value = "/tokens", method = {RequestMethod.GET})
    @ResponseBody
    public List<TokenInfo> findAllRecord(){
        return tokenService.getAllRecord();
    }
}
