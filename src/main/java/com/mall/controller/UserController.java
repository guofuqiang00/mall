package com.mall.controller;

import com.mall.dao.user.UserMapper;
import com.mall.entity.User;
import com.sun.javafx.scene.EnteredExitedHandler;
import javafx.scene.control.Menu;
import jdk.internal.org.objectweb.asm.tree.analysis.SourceInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    //@Autowired按byType自动注入，而@Resource默认按 byName自动注入
    @Resource
    private UserMapper userMapper;

    //使用tk.mybatis

    @PostMapping ("/getUsers")
    public List<User> getUsers(){
        List<User> list = userMapper.selectAll();
        return list;
    }
    @PostMapping ("/getUsersById")
    public User getUsersById(){
        User user = new User();
        user.setUsername("sadsa");
        user.setId(1867494370);
        User user1 = userMapper.selectOne(user);
        return user1;
    }


    /**
     * @description 自定义动态sql查询
     * @param user
     * @return
     */
    @GetMapping("/selectByExample")
    public List selectByExample(@RequestBody User user){
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        if(user!=null){
          if(!StringUtils.isEmpty(user.getId())){
              criteria.andEqualTo("id",user.getId());
          }
          if(!StringUtils.isEmpty(user.getUsername())){
           criteria.andLike("username", "%"+user.getUsername()+"%");

          }
        }
        List<User> list = userMapper.selectByExample(example);
        return list;
    }

    /**
     *
     *   {
     *     "username":{"username":"李四"  },
     *     "id":{"id":2 }
     *   }
     *
     * @param map
     * @return
     */
    @PostMapping("/selectUserByMap")
    public List<User> selectUserByMap(@RequestBody Map<String,Object> map){
      return   userMapper.selectUserByMap(map);
    }



}
