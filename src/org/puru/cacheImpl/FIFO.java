package org.puru.cacheImpl;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import org.puru.cache.api.EvictionPolicy;

public class FIFO implements EvictionPolicy {
	
	private int EvictionCnt=0;


	Queue<String> kue = new LinkedBlockingQueue<>();

	@Override
	public String evict() {
		EvictionCnt=EvictionCnt+1;
		return kue.remove();
	}

	@Override
	public void addPolicy(String key) {
		kue.add(key);
		
	}
	
	 public int getEvictionCnt() {
		return EvictionCnt;
	}

	public void setEvictionCnt(int evictionCnt) {
		EvictionCnt = evictionCnt;
	}

}
