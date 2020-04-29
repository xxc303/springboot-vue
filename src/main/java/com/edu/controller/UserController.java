package com.edu.controller;

import com.edu.entity.User;
import com.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * @author 123
 * @create 2020/4/17
 */

@RestController
@CrossOrigin  //跨域
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //模糊查询
    @GetMapping("findByNameOrPhone")
    public List<User> findByNameOrPhone(String name, String phone){
        return userService.findByNameOrPhone(name, phone);
    }

    //根据id查询
    @GetMapping("/findUser")
    public User findUser(String id){
        User user = userService.findUserById(id);
        return user;
    }

    //删除用户信息
    @GetMapping("delete")
    public Map<String,Object> delete(String id){
        Map<String,Object> map = new HashMap<>();
        try {
            userService.delete(id);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message","删除失败！");
        }
        return map;
    }

    //保存用户信息
    @PostMapping("save")
    public Map<String, Object> save(@RequestBody User user){
        Map<String, Object> map = new HashMap<>();
        try {
            if (StringUtils.isEmpty(user.getId())){
                userService.save(user);
            }else {
                userService.update(user);
            }
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("message","用户保存或更新失败！");
        }
        return map;
    }


    //查询所有用户

    @GetMapping("findAll")
    public List<User> findAll(){
        List<User> users = userService.findAll();
        return users;
    }
}
