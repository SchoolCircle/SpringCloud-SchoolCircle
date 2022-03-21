/**
 *
 * @author KEPADEDAIDAI
 * @date 2022/3/10 16:16
 */
package com.example.service;

import com.example.entity.Result;
import com.example.entity.User;
import com.example.repository.LoginRepository;
import com.example.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;
    public Result<List<User>> login(String email, String pass){
        if(email.isEmpty()||pass.isEmpty())
            return new Result<>("传入参数为空",201);
        List<User> list = loginRepository.getUserByEmail(email);
        if(list.isEmpty())
            return new Result<>("用户不存在", 201);
        String pas = Md5.md5(pass, email);
        assert pas != null;
        if(!pas.equals(list.get(0).getPass()))
            return new Result<>("密码错误", 201);
        else return new Result<>(list);
    }
}
