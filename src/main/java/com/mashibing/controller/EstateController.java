package com.mashibing.controller;

import com.alibaba.fastjson.JSONObject;
import com.mashibing.bean.FcEstate;
import com.mashibing.bean.TblCompany;
import com.mashibing.returnJson.ReturnObject;
import com.mashibing.service.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EstateController {

    @Autowired
    private EstateService estateService;

    @RequestMapping("/estate/selectCompany")
    public String selectCompany() {
        System.out.println("estate");
        List<TblCompany> companies = estateService.selectCompany();
        return JSONObject.toJSONString(new ReturnObject(companies));
    }

    @RequestMapping("estate/insert")
    public String insertEstate(FcEstate fcEstate){
        System.out.println("insert estate");
        Integer result = estateService.insertEstate(fcEstate);
        System.out.println("result"+result);
        if(result == 0){
            return JSONObject.toJSONString(new ReturnObject("房产已经创建成功",result));
        }
        return JSONObject.toJSONString(new ReturnObject("插入房产成功","1"));
    }

}


