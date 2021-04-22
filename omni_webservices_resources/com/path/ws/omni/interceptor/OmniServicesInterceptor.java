package com.path.ws.omni.interceptor;

import java.lang.reflect.Method;
import java.security.PublicKey;
import java.sql.Date;
import java.util.logging.Logger;

import javax.crypto.SecretKey;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

//import com.path.bo.omni.common.impl.ChannelLoginBOImpl;
import com.path.lib.common.util.SecurityUtilsExt;

public class OmniServicesInterceptor implements MethodInterceptor {
	
	protected static Logger pathlog;

	SecurityUtilsExt securityUtilsExt;
	int i = 0;

	@Override
	public Object invoke(MethodInvocation method) throws Throwable {
		Object response = null;
		try {

			System.out.println("[OmniServicesInterceptor]  method = " + method.getMethod().toGenericString());
			System.out.println("[OmniServicesInterceptor]  method = " + method.getMethod().toGenericString());
			
			java.util.Date d = new java.util.Date();
			System.out.println(d);
	
			
			
			if (method.getMethod().getName() != "handShake_service") {
				System.out.println("not handShake service");
				
				response = method.proceed();
			}

			else {

				response = method.proceed();
			} 
		} catch (Exception e) {
			pathlog.info(e.getMessage());
		}

		return response;

	}

}