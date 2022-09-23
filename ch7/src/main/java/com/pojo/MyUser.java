package com.pojo;


import java.util.List;

public class MyUser {

  private long uid;
  private String username;
  private String gender;
  //用户关联的订单
  private List<Orders> ordersList;

  public long getUid() {
    return uid;
  }

  public void setId(long uid) {
    this.uid = uid;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


/*
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public long getAge() {
    return age;
  }

  public void setAge(long age) {
    this.age = age;
  }
*/


  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }


  /*public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }*/

  @Override
  public String toString() {
    return "MyUser{" +
            "id=" + uid +
            ", username='" + username + '\'' +
            ", gender='" + gender + '\'' +
            ", ordersList=" + ordersList +
            '}';
  }
}
