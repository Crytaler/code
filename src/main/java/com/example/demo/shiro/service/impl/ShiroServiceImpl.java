//package com.example.demo.shiro.service.impl;
//
//
//import com.example.demo.shiro.auth.TokenGenerator;
//import com.example.demo.shiro.dao.SysTokenRepository;
//import com.example.demo.shiro.dao.UserRepository;
//import com.example.demo.shiro.entity.SysToken;
//import com.example.demo.shiro.entity.User;
//import com.example.demo.shiro.service.ShiroService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @Author 大誌
// * @Date 2019/3/30 22:18
// * @Version 1.0
// */
//@Service
//public class ShiroServiceImpl implements ShiroService {
//
//    @Autowired
//    MongoTemplate mongoTemplate;
//    //12小时后失效
//    private final static int EXPIRE = 12;
//
//
//    private final UserRepository userRepository;
//    private final SysTokenRepository sysTokenRepository;
//
//    public ShiroServiceImpl(UserRepository userRepository, SysTokenRepository sysTokenRepository) {
//        this.userRepository = userRepository;
//        this.sysTokenRepository = sysTokenRepository;
//    }
//
//    /**
//     * 根据username查找用户
//     *
//     * @param username
//     * @return User
//     */
//    @Override
//    public User findByUsername(String username) {
//        Query query = Query.query(Criteria.where("username").is(username));
//        User user = mongoTemplate.findOne(query, User.class, "user");
//        return user;
//    }
//
//
//    @Override
//    /**
//     * 生成一个token
//     *@param  [userId]
//     *@return Result
//     */
//    public Map<String, Object> createToken(String userId) {
//        Map<String, Object> result = new HashMap<>();
//        //生成一个token
//        String token = TokenGenerator.generateValue();
//        //当前时间
//        LocalDateTime now = LocalDateTime.now();
//        //过期时间
//        LocalDateTime expireTime = now.plusHours(EXPIRE);
//        //判断是否生成过token
//        Query query = Query.query(Criteria.where("userId").is(userId));
//        SysToken tokenEntity = mongoTemplate.findOne(query, SysToken.class, "sysToken");
//        if (tokenEntity == null) {
//            tokenEntity = new SysToken();
//            tokenEntity.setUserId(userId);
//            //保存token
//            tokenEntity.setToken(token);
//            tokenEntity.setUpdateTime(now);
//            tokenEntity.setExpireTime(expireTime);
//        } else {
//            //更新token
//            tokenEntity.setToken(token);
//            tokenEntity.setUpdateTime(now);
//            tokenEntity.setExpireTime(expireTime);
//        }
//        sysTokenRepository.save(tokenEntity);
//        result.put("token", token);
//        result.put("expire", expireTime);
//        return result;
//    }
//
//    /**
//     * 更新数据库的token，使前端拥有的token失效
//     * 防止黑客利用token搞事情
//     *
//     * @param token
//     */
//    @Override
//    public void logout(String token) {
//        SysToken byToken = findByToken(token);
//        //生成一个token
//        token = TokenGenerator.generateValue();
//        //修改token
//        byToken.setToken(token);
//        //使前端获取到的token失效
//        sysTokenRepository.save(byToken);
//    }
//
//    @Override
//    public SysToken findByToken(String accessToken) {
//        Query query = Query.query(Criteria.where("token").is(accessToken));
//        SysToken sysToken = mongoTemplate.findOne(query, SysToken.class, "sysToken");
//        return sysToken;
//
//    }
//
//    @Override
//    public User findByUserId(String userId) {
//        Query query = Query.query(Criteria.where("userId").is(userId));
//        return mongoTemplate.findOne(query,User.class,"user");
//    }
//}
