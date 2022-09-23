package pojo;

public class TUser {

  private long uid;
  private String username;
  private String password;
  private long age;
  private String gender;
  private String email;


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


  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "TUser{" +
            "id=" + uid +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", age=" + age +
            ", gender='" + gender + '\'' +
            ", email='" + email + '\'' +
            '}';
  }
}
