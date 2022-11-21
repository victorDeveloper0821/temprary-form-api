package com.ienglish.controller;

import com.ienglish.model.PersonalInfo;
import com.ienglish.repository.TokenRepository;
import com.ienglish.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
@RequestMapping(value = "/api/v1/token")
public class TokenController {

    @RequestMapping(value = "", method = {RequestMethod.POST})
    @ResponseBody
    public String createTokenInfo(@RequestBody PersonalInfo info) {
        LogUtils.d("Data Payloads",info.toString());
        LogUtils.i("restful api", "create token operation");
        return "create Token Info";
    }

    @RequestMapping(value = "/{token}", method = {RequestMethod.GET, RequestMethod.DELETE})
    @ResponseBody
    public String getTokenInfo(HttpServletRequest req, @PathVariable("token") String token) {
        String method = req.getMethod();
        if (method.equalsIgnoreCase("GET")) {
            LogUtils.i("restful api", "Query Token Information");
        } else {
            LogUtils.i("restful api", "Delete Token Information");
        }
        return "get Token Info";
    }

    @RequestMapping(value = "/{token}", method = {RequestMethod.PUT})
    @ResponseBody
    public String updateTokenInfo(@PathVariable("token") String token, @RequestBody PersonalInfo info) {
        LogUtils.i("restful api", "Update Token Information");
        return "update Token Info";
    }
}
