package com.is.services;

import com.is.dao.implementation.DefaultUserDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by catal on 1/18/2017.
 */
public class RegisterService {

    @Autowired
    private DefaultUserDao defaultUserDao;

    public void setDefaultUserDao(DefaultUserDao defaultUserDao) {
        this.defaultUserDao = defaultUserDao;
    }

    public boolean registerUser(String username, String password, String firstName, String lastName) {

      return true;

    }

}
