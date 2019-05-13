package org.smart.micro.controller;

import org.smart.micro.bean.UserInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author jiangsida
 * @VERSION 1.0
 */
@RestController
public class UserController {

    /**
     * 资源api
     * @return
     */
    @RequestMapping("/api/userinfo")
    public ResponseEntity<UserInfo> getUserInfo(){

        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username=userInfo.getName()+"springtoAuth2";
          UserInfo  userInfo1 = new UserInfo();
         userInfo1.setName(username);
         userInfo1.setEmail(userInfo.getEmail());

      return    ResponseEntity.ok(userInfo1);
    }
}
