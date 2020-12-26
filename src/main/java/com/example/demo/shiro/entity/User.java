//package com.example.demo.shiro.entity;
//
//import lombok.Data;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//import javax.persistence.FetchType;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import java.util.Set;
//
///**
// * 用户实体类
// * @Author 大誌
// * @Date 2019/4/7 14:44
// * @Version 1.0
// */
//@Data
//@Document
//public class User {
//    @Id
//    private String id;
//    private String userId;
//
//    private String username;
//    private String password;
//
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "userRole",
//            joinColumns = {@JoinColumn(name = "userId", referencedColumnName = "userId")},
//            inverseJoinColumns = {@JoinColumn(name = "roleId", referencedColumnName = "roleId")})
//    private Set<Role> roles;
//
//}
