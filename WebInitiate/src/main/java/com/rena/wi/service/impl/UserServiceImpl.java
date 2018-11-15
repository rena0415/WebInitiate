package com.rena.wi.service.impl;


import com.rena.wi.dao.StaffDao;
import com.rena.wi.domain.Staff;
import com.rena.wi.service.UserService;
import com.rena.wi.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author rena
 * @date 2018/11/11 22:50
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private StaffDao staffDao;


    @Override
    public boolean login(UserVO userVO) {
        Staff staff = voToDomain(userVO);
        List<Staff> staffList = staffDao.checkLogin(staff);
         return staffList.size() > 0;
    }

    @Override
    public void register(UserVO userVO) {
        Staff staff = voToDomain(userVO);
        staffDao.registerUser(staff);
    }

    private Staff voToDomain(UserVO userVO) {
        Staff staff = new Staff();
        staff.setStaffname(userVO.getUsername());
        staff.setPassword(userVO.getPassword());
        return staff;
    }
}
