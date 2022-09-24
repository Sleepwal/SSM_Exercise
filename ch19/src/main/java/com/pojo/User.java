package com.pojo;


public class User {

  private long userId;
  private String username;
  private long balance;

  public User() {
  }

  public User(long userId, String username, long balance) {
    this.userId = userId;
    this.username = username;
    this.balance = balance;
  }

  @Override
  public String toString() {
    return "User{" +
            "userId=" + userId +
            ", username='" + username + '\'' +
            ", balance=" + balance +
            '}';
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public long getBalance() {
    return balance;
  }

  public void setBalance(long balance) {
    this.balance = balance;
  }

}
