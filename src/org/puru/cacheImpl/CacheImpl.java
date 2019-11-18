package org.puru.cacheImpl;

import java.util.Optional;

import org.puru.cache.api.Cache;
import org.puru.cache.api.EvictionPolicy;
import org.puru.cache.enties.CacheData;

public class CacheImpl implements Cache {

	private Cache level1;
	private Cache level2;
	private Cache level3;
	
	private int totalReadtime=0;
	private int numberOfread=0;
	private int totalNumberWriteTime=0;
	private int  numberofWrite=0;

	private EvictionPolicy policy;

	public CacheImpl() {
		level1 = new Level1Cache();
		level2 = new Level2Cache();
		level3 = new Level3Cache();
		setPolicy(new FIFO());

	}

	@Override
	public Optional<CacheData> get(String key) {
		numberOfread=numberOfread+1;
		Optional<CacheData> layer1Data = level1.get(key);

		if (layer1Data.isPresent()) {
			totalReadtime=totalReadtime+layer1Data.get().getAccessTime();
			return layer1Data;
		}
		Optional<CacheData> layer2Data = level2.get(key);

		if (layer2Data.isPresent()) {
			CacheData cacheData = layer2Data.get();
			cacheData.setAccessTime(3);
			totalReadtime=totalReadtime+cacheData.getAccessTime();
			return Optional.of(cacheData);
		}

		Optional<CacheData> layer3Data = level3.get(key);

		if (layer3Data.isPresent()) {
			CacheData cacheData = layer3Data.get();
			cacheData.setAccessTime(6);
			totalReadtime=totalReadtime+cacheData.getAccessTime();
			return Optional.of(cacheData);
		}

		return null;

	}

	@Override
	public int set(String key, String value) {
		numberofWrite=numberofWrite+1;
		int totTimeOperation = 0;
		int l1 = level1.set(key, value);
		int l2 = level2.set(key, value);
		int l3 = level3.set(key, value);
		totTimeOperation = l1 + l2 + l3;
		totalNumberWriteTime=totalNumberWriteTime+totTimeOperation;
		return totTimeOperation;

	}

	public void setPolicy(EvictionPolicy policy) {
		this.policy = policy;
		level1.setPolicy(policy);
		level2.setPolicy(policy);
		level3.setPolicy(policy);
	}
	
	public void getStats() {
		System.out.println("Level1  1 :: "  + level1.getFreePercentage());
		System.out.println("Level1  2 ::"  + level2.getFreePercentage());
		System.out.println("Level1  3 ::"  + level3.getFreePercentage());
		
		System.out.println("Avg read time :" +totalReadtime/numberOfread);
		
		System.out.println("Avg write  time : " +totalNumberWriteTime/numberofWrite);
		
		System.out.println("Eviction count :: " +policy.getEvictionCnt());
	}

	@Override
	public int getFreePercentage() {
		// TODO Auto-generated method stub
		return 0;
	}

}
