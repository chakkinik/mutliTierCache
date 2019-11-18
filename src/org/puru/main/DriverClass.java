package org.puru.main;

import java.util.Optional;

import org.puru.cache.api.Cache;
import org.puru.cache.enties.CacheData;
import org.puru.cacheImpl.CacheImpl;

public class DriverClass {
	
	public static void main(String[] args) {
		Cache cache = new CacheImpl();
		
		int operationTimek1 = cache.set("k1","v1");
		
		System.out.println("operation took  " +operationTimek1);
		
		  Optional<CacheData> cacheData = cache.get("k1");
		  CacheData data = cacheData.get();
		  
		  System.out.println(data.getData());
		  
		  System.out.println("operation took for  getting k1 " +data.getAccessTime());
		
		int operationTimek2 = cache.set("k2","v2");
		
		System.out.println("operation took  " +operationTimek2);
		
		int operationTimek3 = cache.set("k3","v2");
		
		System.out.println("operation took  " +operationTimek3);
		
		 Optional<CacheData> cacheDatak1 = cache.get("k1");
		  CacheData datak1 = cacheDatak1.get();
		  
		  System.out.println(datak1.getData());
		  
		  System.out.println("operation took for  getting k1 again " +datak1.getAccessTime());
		
		  cache.getStats();
		  
		  
		  
		  int a=123;
		  
		  
		
		
	}

}
