package com.ienglish.controller;

import com.ienglish.repository.TokenRepository;
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
    public String createTokenInfo(@RequestBody HashMap<String, Object> map) {
        return "create Token Info";
    }

    @RequestMapping(value = "/{token}", method = {RequestMethod.GET, RequestMethod.DELETE})
    @ResponseBody
    public String getTokenInfo(HttpServletRequest req, @PathVariable("token") String token) {
        String method = req.getMethod();
        if (method.equalsIgnoreCase("GET")) {
            System.out.println("HTTP GET");
        } else {
            System.out.println("HTTP DELETE");
        }
        return "get Token Info";
    }

    @RequestMapping(value = "/{token}", method = {RequestMethod.PUT})
    @ResponseBody
    public String updateTokenInfo(@PathVariable("token") String token, @RequestBody HashMap<String, Object> map) {
        return "update Token Info";
    }
}
