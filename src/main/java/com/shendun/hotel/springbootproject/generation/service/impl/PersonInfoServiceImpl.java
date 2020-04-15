package com.shendun.hotel.springbootproject.generation.service.impl;

import com.shendun.hotel.springbootproject.generation.entity.PersonInfo;
import com.shendun.hotel.springbootproject.generation.mapper.PersonInfoMapper;
import com.shendun.hotel.springbootproject.generation.service.PersonInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lh
 * @since 2020-04-15
 */
@Service
public class PersonInfoServiceImpl extends ServiceImpl<PersonInfoMapper, PersonInfo> implements PersonInfoService {

}
