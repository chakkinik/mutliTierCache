package org.puru.cache.api;

import java.util.Optional;

import org.puru.cache.enties.CacheData;

public interface Cache {

	public Optional<CacheData> get(String key);

	public int set(String key, String value);

	public void setPolicy(EvictionPolicy policy);

	public int getFreePercentage();

	public void getStats();

}
