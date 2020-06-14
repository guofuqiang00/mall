package com.mall.dao.user;

import com.mall.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}