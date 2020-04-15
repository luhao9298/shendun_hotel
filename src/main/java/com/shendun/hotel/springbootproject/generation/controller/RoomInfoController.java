package com.shendun.hotel.springbootproject.generation.controller;


import com.shendun.hotel.springbootproject.generation.entity.RoomInfo;
import com.shendun.hotel.springbootproject.generation.mapper.RoomInfoMapper;
import com.shendun.hotel.springbootproject.generation.service.RoomInfoService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/roomInfo")
public class RoomInfoController {
    @Autowired(required = false)
    private RoomInfoMapper roomInfoMapper;

    @Autowired
    private RoomInfoService roomInfoService;

    //
//    @GetMapping("/selectALL")
//    public Object SelectListAll() {
//        return roomInfoService.list();
//
//    }

    @GetMapping("/selectALL")
    public Object SelectListAll() {
        List<RoomInfo> roomInfos=this.roomInfoMapper.selectList(null);

        return roomInfos;

    }


}
