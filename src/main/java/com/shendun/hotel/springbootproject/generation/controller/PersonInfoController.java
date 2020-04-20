package com.shendun.hotel.springbootproject.generation.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.shendun.hotel.springbootproject.generation.entity.PersonInfo;
import com.shendun.hotel.springbootproject.generation.mapper.PersonInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import static com.shendun.hotel.springbootproject.config.DateTimeUtils.stringToDateTime;

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
        String checkouttime=jsonObject.getString("leavetime");
        personInfo.setIsacc(0);   //住房状态1为在住，0为退房
        personInfo.setCheckouttime(stringToDateTime(checkouttime,"yyyy-MM-dd HH:mm:ss"));
        personInfoMapper.update(personInfo,ew);
    }

    @RequestMapping("/receiveChangedMessage")
    public void ReceiveChangedMessage(@RequestBody String data)throws Exception{
        JSONArray jsonArray = JSONObject.parseArray(data);
        for(int i=0;i<jsonArray.size();i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String identifyid = jsonObject.getString("identifyid");
            String acc_flag = jsonObject.getString("acc_flag");
            Date leave_time = jsonObject.getDate("leave_time");  //Date类型与LocalDateTime转换
            Instant instant = leave_time.toInstant();
            ZoneId zoneId = ZoneId.systemDefault();
            LocalDateTime checkouttime = instant.atZone(zoneId).toLocalDateTime();
            UpdateWrapper<PersonInfo> ew = new UpdateWrapper<>();
            PersonInfo personInfo=new PersonInfo();
            ew.eq("identifyid",jsonObject.getString("identifyid"));  //用身份证号码匹配对应的实体
            personInfo.setIdentifyid(identifyid);
            personInfo.setIsacc(Integer.valueOf(acc_flag));
            personInfo.setCheckouttime(checkouttime);
            personInfoMapper.update(personInfo,ew);
        }
//
    }




}
