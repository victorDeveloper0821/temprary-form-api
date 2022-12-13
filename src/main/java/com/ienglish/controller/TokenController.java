package com.ienglish.controller;

import com.ienglish.domain.TokenHistory;
import com.ienglish.domain.TokenInfo;
import com.ienglish.model.APIResponse;
import com.ienglish.model.PersonalInfo;
import com.ienglish.model.TokenVO;
import com.ienglish.service.TokenService;
import com.ienglish.utils.LogUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Api(tags = "Todo list 相關api")
@Controller
@RequestMapping(value = "/api/v1")
public class TokenController {
    private final static Logger logger = LogManager.getLogger(TokenController.class);
    @Autowired
    private TokenService tokenService;


    @RequestMapping(value = "/tokens", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseEntity<APIResponse> createTokenInfo(@RequestBody PersonalInfo info) {
        logger.info("--------- create token here ---------");
        APIResponse response = new APIResponse();
        logger.debug("--------- save token info and history here ---------");
        // create token - return token string if success
        String token = tokenService.createTokenInfo(info);

        logger.debug("--------- represent token latest information here ---------");
        // return latest token information
        TokenVO vo = tokenService.findLatestHistoryByToken(token);
        response.setSuccess(true);
        response.setData(vo);
        response.setMessage("success to create Token Info");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @ApiOperation("取得token完整資訊")
    @ApiResponses({
            @ApiResponse(code=200,message="查詢ok"),
            @ApiResponse(code=204,message="查詢失敗")
    })
    @RequestMapping(value = "/token/{token}", method = {RequestMethod.GET, RequestMethod.DELETE})
    @ResponseBody
    public ResponseEntity<APIResponse> getTokenInfo(HttpServletRequest req, @PathVariable("token") String token) {
        logger.info("--------- fetch token info here ---------");
        String method = req.getMethod();
        Optional<TokenInfo> tokenOpt = tokenService.getTokenInfoByToken(token);
        APIResponse response = new APIResponse();
        if (method.equalsIgnoreCase("GET")) {
            logger.debug("--------- fetch token info and history here ---------");
            if(tokenOpt.isPresent()){
                TokenVO vo = tokenService.findLatestHistoryByToken(token);
                response.setData(vo);
                response.setSuccess(true);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }else{
                response.setSuccess(false);
                response.setData(null);
                return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
            }
        } else {
            logger.debug("--------- delete token info and history here ---------");
            if(tokenOpt.isPresent()){
                TokenVO vo = tokenService.findLatestHistoryByToken(token);
                response.setData(vo);
                response.setSuccess(true);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }else{
                response.setSuccess(false);
                response.setData(null);
                return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
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
/*
    @RequestMapping(value = "/tokenHistories/{token}",method = {RequestMethod.GET})
    @ResponseBody
    public ResponseEntity<APIResponse> findHistoryByToken(@PathVariable("token") String token){
        TokenVO vo = tokenService.findLatestHistoryByToken(token);
        APIResponse response = new APIResponse();
        if(vo.getState() == 3){
            response.setSuccess(false);
            response.setData(vo);
            return new ResponseEntity<>(response,HttpStatus.NO_CONTENT);
        }else{
            response.setSuccess(true);
            response.setData(vo);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
    }*/
}
