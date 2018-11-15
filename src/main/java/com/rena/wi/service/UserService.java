package com.rena.wi.service;

import com.rena.wi.vo.UserVO;

/**
 * description
 *
 * @author rena
 * @date 2018/11/11 22:14
 **/
public interface UserService {
    boolean login(UserVO uservo);
    void register(UserVO uservo);
}
