package com.mall.dao.user;

import com.mall.base.BaseMapper;
import com.mall.entity.User;

import java.util.List;
import java.util.Map;

public interface UserMapper extends BaseMapper<User> {

  int  deleteUser(Map<String,Object> map);

  List<User>  selectUserByMap(Map<String,Object> map);
}