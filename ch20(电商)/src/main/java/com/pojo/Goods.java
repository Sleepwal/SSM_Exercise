package com.pojo;


import org.springframework.web.multipart.MultipartFile;

public class Goods {

  private Long id;
  private String gname;
  private double grprice;
  private double goprice;
  private long gstore;
  private MultipartFile logoImage;
  private String gpicture;
  private long goodstypeId;
  private String typename;//查询时使用

  public MultipartFile getLogoImage() {
    return logoImage;
  }

  public void setLogoImage(MultipartFile logoImage) {
    this.logoImage = logoImage;
  }

  public String getTypename() {
    return typename;
  }

  public void setTypename(String typename) {
    this.typename = typename;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public String getGname() {
    return gname;
  }

  public void setGname(String gname) {
    this.gname = gname;
  }


  public double getGrprice() {
    return grprice;
  }

  public void setGrprice(double grprice) {
    this.grprice = grprice;
  }


  public double getGoprice() {
    return goprice;
  }

  public void setGoprice(double goprice) {
    this.goprice = goprice;
  }


  public long getGstore() {
    return gstore;
  }

  public void setGstore(long gstore) {
    this.gstore = gstore;
  }


  public String getGpicture() {
    return gpicture;
  }

  public void setGpicture(String gpicture) {
    this.gpicture = gpicture;
  }


  public long getGoodstypeId() {
    return goodstypeId;
  }

  public void setGoodstypeId(long goodstypeId) {
    this.goodstypeId = goodstypeId;
  }

}
