package com.rena.wi.domain;

/**
 * description
 *
 * @author rena
 * @date 2018/11/9 23:15
 **/
public class Staff {
    private long id;
    private String staffname;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", staffname='" + staffname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
