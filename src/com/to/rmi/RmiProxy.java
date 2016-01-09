package com.to.rmi;

import java.lang.reflect.Proxy;


public class RmiProxy<T> {
	public static <T>T createRmiProxy(final Class<T> rmiInterface){
		RmiProxyProvider provider=RmiProvierFactory.createProvider(rmiInterface);
		return (T)create(provider,rmiInterface);
	}
	
	
	private static <T>T create(Provider<T> provider,final Class<T> rmiInterface){
		return Proxy.newProxyInstance(
				provider.getInterface().getClassLoader(),
		        new Class<?>[] { rmiInterface },
		        new RmiInnovationHandler(provider)
		        );
		 
	}
}
