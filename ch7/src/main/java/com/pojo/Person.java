package com.pojo;


public class Person {

  private long id;
  private String name;
  private long age;
  //身份证关联
  private Idcard card;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getAge() {
    return age;
  }

  public void setAge(long age) {
    this.age = age;
  }

  public Idcard getCard() {
    return card;
  }

  public void setCard(Idcard card) {
    this.card = card;
  }

  @Override
  public String toString() {
    return "Person{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", age=" + age +
            ", card=" + card +
            '}';
  }
}
