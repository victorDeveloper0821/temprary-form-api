package com.ienglish.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
@RequestMapping(value = "/api/v1/form/")
public class FormController {
    @RequestMapping(value = "", method = {RequestMethod.POST})
    @ResponseBody
    public String createFormInfo(@RequestBody HashMap<String,Object> map){
        return "create Form Info";
    }

    @RequestMapping(value = "/{formId}",method = {RequestMethod.GET,RequestMethod.DELETE})
    @ResponseBody
    public String getFormInfo (HttpServletRequest req, @PathVariable("formId") String formId){
        String method = req.getMethod();
        if (method.equalsIgnoreCase("GET")) {
            System.out.println("HTTP GET");
        } else {
            System.out.println("HTTP DELETE");
        }
        return "get Form Info";
    }

    @RequestMapping(value = "/{formId}", method = {RequestMethod.PUT})
    @ResponseBody
    public String updateFormInfo(@PathVariable("formId") String token, @RequestBody HashMap<String,Object> map){

        return "updateFormInfo" ;
    }
}
