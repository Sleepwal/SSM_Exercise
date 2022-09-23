package com.pojo;

public class SelectUserOrdersById {
    private long uid;
    private String username;
    private String gender;
    private long id;
    private String ordersn;

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrdersn() {
        return ordersn;
    }

    public void setOrdersn(String ordersn) {
        this.ordersn = ordersn;
    }


    @Override
    public String toString() {
        return "SelectUserOrdersById{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", gender='" + gender + '\'' +
                ", id=" + id +
                ", ordersn='" + ordersn + '\'' +
                '}';
    }
}
