package com.ccl.common;
//package com.ccl.common;
//
//import java.io.Serializable;
//
//import org.apache.shiro.session.Session;
//import org.apache.shiro.session.mgt.ValidatingSession;
//import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//
//import com.ccl.common.util.SpringContextHolder;
//
//public class MySessionDAO extends CachingSessionDAO {
//	
//	protected Serializable doCreate(Session session) {
//		return addSessionToRedis(session);
//	}
//
//	protected void doUpdate(Session session) {
//		if (session instanceof ValidatingSession && !((ValidatingSession) session).isValid()) {
//			return; // 如果会话过期/停止 没必要再更新了
//		}
//		addSessionToRedis(session);
//	}
//	
//	private Serializable addSessionToRedis(Session session){
//		Serializable sessionId = session.getId();
//		if(sessionId == null){
//			sessionId = generateSessionId(session);
//			assignSessionId(session, sessionId);
//		} else {
//			RedisTemplate<String, Session> redisTemplate = SpringContextHolder.getBean("redisTemplate");
//			ValueOperations<String, Session> opsForValue = redisTemplate.opsForValue();
//			opsForValue.set(sessionId.toString(), session);
//		}
//		return session.getId();
//	}
//
//	protected void doDelete(Session session) {
//		Serializable sessionId = session.getId();
//		RedisTemplate<String, Session> redisTemplate = SpringContextHolder.getBean("redisTemplate");
//		redisTemplate.delete(sessionId.toString());
//	}
//
//	protected Session doReadSession(Serializable sessionId) {
//		RedisTemplate<String, Session> redisTemplate = SpringContextHolder.getBean("redisTemplate");
//		ValueOperations<String, Session> opsForValue = redisTemplate.opsForValue();
//		Session session = opsForValue.get(sessionId.toString());
//		return session;
//	}
//}