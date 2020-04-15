package com.shendun.hotel.springbootproject.generation.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.shendun.hotel.springbootproject.generation.entity.PersonInfo;
import com.shendun.hotel.springbootproject.generation.mapper.PersonInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lh
 * @since 2020-04-15
 */
@RestController
@RequestMapping("/personInfo")
public class PersonInfoController {

    @Autowired(required = false)
    private PersonInfoMapper personInfoMapper;

    @GetMapping("/selectALL")
    public Object SelectListAll() {
        List<PersonInfo> personInfos=this.personInfoMapper.selectList(null);

        return personInfos;

    }

    @RequestMapping("/updateStatus")
    public void UpdateStatus(@RequestBody String data){
        JSONObject jsonObject = JSONObject.parseObject(data);
        UpdateWrapper<PersonInfo> ew = new UpdateWrapper<>();
        ew.eq("identifyid",jsonObject.getString("identifyid"));
        PersonInfo personInfo=new PersonInfo();
        personInfo.setIsacc(0);   //住房状态1为在住，0为退房
        personInfoMapper.update(personInfo,ew);
    }




}
