package org.puru.cache.api;

public interface EvictionPolicy {

	public String evict();
	
	public void addPolicy(String key);
	
	public int getEvictionCnt();
	
}
