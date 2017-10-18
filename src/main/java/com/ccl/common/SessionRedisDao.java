package com.ccl.common;
//package com.ccl.common;
//
//import java.io.Serializable;
//
//import org.apache.shiro.session.Session;
//import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//
//import com.ccl.common.util.SpringContextHolder;
//
//public class SessionRedisDao extends EnterpriseCacheSessionDAO {
//
//    // 创建session，保存到数据库
//    @Override
//    protected Serializable doCreate(Session session) {
//        Serializable sessionId = super.doCreate(session);
//       
//        RedisTemplate<String, Session> redisTemplate = SpringContextHolder.getBean("redisTemplate");
//		ValueOperations<String, Session> opsForValue = redisTemplate.opsForValue();
//		opsForValue.set(sessionId.toString(), session);
//        
//		return sessionId;
//    }
//
//    // 获取session
//    @Override
//    protected Session doReadSession(Serializable sessionId) {
//        // 先从缓存中获取session，如果没有再去数据库中获取
//        Session session = super.doReadSession(sessionId); 
//        if(session == null){
//        	RedisTemplate<String, Session> redisTemplate = SpringContextHolder.getBean("redisTemplate");
//    		ValueOperations<String, Session> opsForValue = redisTemplate.opsForValue();
//    		session = opsForValue.get(sessionId.toString());
//        }
//        return session;
//    }
//
//    // 更新session的最后一次访问时间
//    @Override
//    protected void doUpdate(Session session) {
//        super.doUpdate(session);
//        RedisTemplate<String, Session> redisTemplate = SpringContextHolder.getBean("redisTemplate");
//		ValueOperations<String, Session> opsForValue = redisTemplate.opsForValue();
//		opsForValue.set(session.getId().toString(), session);
//    }
//
//    // 删除session
//    @Override
//    protected void doDelete(Session session) {
//        super.doDelete(session);
//        RedisTemplate<String, Session> redisTemplate = SpringContextHolder.getBean("redisTemplate");
//        redisTemplate.delete(session.getId().toString());
//    }
//}