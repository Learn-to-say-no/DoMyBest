package com.example.multiServerLearn.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.multiServerLearn.business.domin.po.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
