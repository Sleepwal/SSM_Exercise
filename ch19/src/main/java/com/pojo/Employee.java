package com.pojo;


public class Employee {

  private long empId;
  private String empName;
  private long age;
  private String sex;
  private String email;

  public Employee() {
  }

  public Employee(long empId, String empName, long age, String sex, String email) {
    this.empId = empId;
    this.empName = empName;
    this.age = age;
    this.sex = sex;
    this.email = email;
  }

  public long getEmpId() {
    return empId;
  }

  public void setEmpId(long empId) {
    this.empId = empId;
  }


  public String getEmpName() {
    return empName;
  }

  public void setEmpName(String empName) {
    this.empName = empName;
  }


  public long getAge() {
    return age;
  }

  public void setAge(long age) {
    this.age = age;
  }


  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "Employee{" +
            "empId=" + empId +
            ", empName='" + empName + '\'' +
            ", age=" + age +
            ", sex='" + sex + '\'' +
            ", email='" + email + '\'' +
            '}';
  }
}
