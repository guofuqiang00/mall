package com.mall.dao.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.entity.User;
import com.mall.entity.User2;
import com.mall.utils.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper extends BaseMapper<User2> {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    List<User>  selectUser(Map<String,Object> map);

    List<User>  selectUserByMap(Map<String,Object> map);
}