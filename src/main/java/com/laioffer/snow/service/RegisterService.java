package com.laioffer.snow.service;

import com.laioffer.snow.dao.RegisterDao;
import com.laioffer.snow.entity.db.User;
import com.laioffer.snow.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Service
public class RegisterService {

    @Autowired
    private RegisterDao registerDao;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public boolean register(User user) throws IOException {
        user.setPassword(Util.encryptPassword(user.getUserId(), user.getPassword()));
        return registerDao.register(user);
    }
}


