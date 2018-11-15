package com.rena.wi.dao;

import com.rena.wi.domain.Staff;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * description
 *
 * @author rena
 * @date 2018/11/11 22:51
 **/
public interface StaffDao {

    @Select("SELECT * FROM STAFF WHERE staffname=#{staffname} AND password=#{password}")
    /*关联实体类属性和数据库字段对应
    @Results({
            @Result(property="staffname",column= "staffname"),
            @Result(property="password",column= "password")
    })*/
    List<Staff> checkLogin(Staff staff);

    @Insert("INSERT INTO STAFF (staffname, password) VALUES (#{staffname},#{password})")
    void registerUser(Staff staff);

}
