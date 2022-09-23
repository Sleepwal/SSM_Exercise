package com.pojo;


public class Idcard {

  private long id;
  private String code;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Override
  public String toString() {
    return "Idcard{" +
            "id=" + id +
            ", code='" + code + '\'' +
            '}';
  }
}
