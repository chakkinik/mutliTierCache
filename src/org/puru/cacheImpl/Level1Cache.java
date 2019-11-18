package org.puru.cacheImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.puru.cache.api.Cache;
import org.puru.cache.api.EvictionPolicy;
import org.puru.cache.enties.CacheData;

public class Level1Cache implements Cache {

	private EvictionPolicy policy;
	private static final int CAPACITY = 2;
	private static final int ACCESS_TIME = 1;
	private static final int REFERSH_TIME = 1;

	private Map<String, String> level1Store = new HashMap<>();

	@Override
	public Optional<CacheData> get(String key) {
		if (level1Store.get(key) != null) {

			return Optional.of(new CacheData(level1Store.get(key), ACCESS_TIME));
		}

		return Optional.ofNullable(null);

	}

	@Override
	public int set(String key, String value) {

		if (level1Store.get(key) != null) {
			level1Store.put(key, value);
		}

		if (level1Store.size() >= CAPACITY) {
			String evictedKey = policy.evict();
			level1Store.remove(evictedKey);
		}
		policy.addPolicy(key);
		level1Store.put(key, value);

		return REFERSH_TIME + ACCESS_TIME;

	}

	public EvictionPolicy getPolicy() {
		return policy;
	}

	public void setPolicy(EvictionPolicy policy) {
		this.policy = policy;
	}
	
	
		public int getFreePercentage() {
			int m=level1Store.size() * 100;
			float f = m/CAPACITY;
			return 100- Math.round(f);
	}

	@Override
	public void getStats() {
		// TODO Auto-generated method stub
		
	}

}
