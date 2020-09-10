package com.mall.dao.user;

import com.mall.entity.User;
import com.mall.entity.User2;
import com.mall.utils.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper  {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    List<User>  selectUser(Map<String,Object> map);

    List<User>  selectUserByMap(Map<String,Object> map);

    User selectUsername(@Param("username") String username);

    User loginVerify(Map<String,Object> map);
}