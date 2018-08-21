package com.mp.clone;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * Created by minpan on 2018/8/21.
 */
public class BeanTest {

    private static final Logger log = LoggerFactory.getLogger(BeanTest.class);
    public static void main(String[] args) {
        User src = new User();
        User target = new User();
        src.setBirthDay(new Date());
        src.setAddress("武汉中南路");
        src.setCreateTime(new Date());
        src.setDescription("测试function of bean copy!");
        src.setUpdateTime(new Date());
        log.info("src object:{}, target object:{}", src, target);
        BeanUtils.copyProperties(src, target);
        log.info("src object:{}, target object:{}", src, target);
    }

   static class User{
        int id;

        String username;

        String address;

        String description;

        @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
        Date birthDay;
        @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
        Date createTime;
        @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
        Date updateTime;

       public int getId() {
           return id;
       }

       public void setId(int id) {
           this.id = id;
       }

       public String getUsername() {
           return username;
       }

       public void setUsername(String username) {
           this.username = username;
       }

       public String getAddress() {
           return address;
       }

       public void setAddress(String address) {
           this.address = address;
       }

       public String getDescription() {
           return description;
       }

       public void setDescription(String description) {
           this.description = description;
       }

       public Date getBirthDay() {
           return birthDay;
       }

       public void setBirthDay(Date birthDay) {
           this.birthDay = birthDay;
       }

       public Date getCreateTime() {
           return createTime;
       }

       public void setCreateTime(Date createTime) {
           this.createTime = createTime;
       }

       public Date getUpdateTime() {
           return updateTime;
       }

       public void setUpdateTime(Date updateTime) {
           this.updateTime = updateTime;
       }

       @Override
       public String toString() {
           return "User{" +
                   "id=" + id +
                   ", username='" + username + '\'' +
                   ", address='" + address + '\'' +
                   ", description='" + description + '\'' +
                   ", birthDay=" + birthDay +
                   ", createTime=" + createTime +
                   ", updateTime=" + updateTime +
                   '}';
       }
   }
}
