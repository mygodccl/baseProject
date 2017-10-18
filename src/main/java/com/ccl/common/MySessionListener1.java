package com.ccl.common;
//package com.ccl.common;
//
//import org.apache.shiro.session.Session;
//import org.apache.shiro.session.SessionListener;
//
///**
// * 这个类实现session的监听, 可以进行日志记录什么的
// * @author ccl
// *
// */
//public class MySessionListener1 implements SessionListener {
//	@Override
//	public void onStart(Session session) {// 会话创建时触发
//		System.out.println("会话创建：" + session.getId());
//	}
//
//	@Override
//	public void onExpiration(Session session) {// 会话过期时触发
//		System.out.println("会话过期：" + session.getId());
//	}
//
//	@Override
//	public void onStop(Session session) {// 退出/会话过期时触发
//		System.out.println("会话停止：" + session.getId());
//	}
//}