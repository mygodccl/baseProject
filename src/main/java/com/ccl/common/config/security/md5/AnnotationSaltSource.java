package com.ccl.common.config.security.md5;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.core.userdetails.UserDetails;

import com.ccl.common.config.security.CustomUserDetails;

public class AnnotationSaltSource implements SaltSource {
	
	@Override
	public Object getSalt(UserDetails user) {
		String salt = "";
		CustomUserDetails mUser = (CustomUserDetails)user;
		Field[] fields = mUser.getClass().getDeclaredFields();
		for (Field field : fields) {
			Annotation[] annotations = field.getDeclaredAnnotations();
			for (Annotation annotation : annotations) {
				if (annotation instanceof SaltPropertie) {
					try {
						field.setAccessible(true);
						Object object = field.get(mUser);
						if(object != null) {
							salt += object.toString();
						}
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
		
		return salt;
	}

}
