package com.ienglish.controller;

import com.ienglish.domain.TokenHistory;
import com.ienglish.domain.TokenInfo;
import com.ienglish.model.APIResponse;
import com.ienglish.model.PersonalInfo;
import com.ienglish.service.TokenService;
import com.ienglish.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

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
        tokenService.createTokenInfo(info);
        return "create Token Info";
    }

    @RequestMapping(value = "/token/{token}", method = {RequestMethod.GET, RequestMethod.DELETE})
    @ResponseBody
    public ResponseEntity<APIResponse> getTokenInfo(HttpServletRequest req, @PathVariable("token") String token) {
        String method = req.getMethod();
        Optional<TokenInfo> tokenOpt = tokenService.getTokenInfoByToken(token);
        APIResponse response = new APIResponse();
        if (method.equalsIgnoreCase("GET")) {
            if(tokenOpt.isPresent()){
                response.setData(tokenOpt.get());
                response.setSuccess(true);
                return new ResponseEntity<APIResponse>(response, HttpStatus.OK);
            }else{
                response.setSuccess(false);
                response.setData(null);
                return new ResponseEntity<APIResponse>(response, HttpStatus.NOT_FOUND);
            }
        } else {
            if(tokenOpt.isPresent()){
                response.setData(tokenOpt.get());
                response.setSuccess(true);
                return new ResponseEntity<APIResponse>(response, HttpStatus.OK);
            }else{
                response.setSuccess(false);
                response.setData(null);
                return new ResponseEntity<APIResponse>(response, HttpStatus.NOT_FOUND);
            }
        }
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

    @RequestMapping(value = "/tokenHistories",method = {RequestMethod.GET})
    @ResponseBody
    public List<TokenHistory> findAllHistory(){
        return tokenService.findTokenHistory();
    }

    @RequestMapping(value = "/tokenHistories/{token}",method = {RequestMethod.GET})
    @ResponseBody
    public ResponseEntity<APIResponse> findHistoryByToken(@PathVariable("token") String token){
        Optional<TokenHistory> historyOpt = tokenService.findLatestHistoryByToken(token);
        APIResponse response = new APIResponse();
        if(historyOpt.isPresent()){
            response.setSuccess(true);
            response.setData(historyOpt.get());
            return new ResponseEntity<APIResponse>(response,HttpStatus.OK);
        }else{
            response.setSuccess(true);
            return new ResponseEntity<APIResponse>(response,HttpStatus.NOT_FOUND);
        }
    }
}
