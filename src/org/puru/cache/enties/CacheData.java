package org.puru.cache.enties;

public class CacheData extends Input {
	
	private int accessTime;
	
	
	
	public CacheData(String data,int accesstime) {
		super(data);
		this.accessTime=accesstime;
	}
	
	

	public int getAccessTime() {
		return accessTime;
	}

	public void setAccessTime(int accessTime) {
		this.accessTime = accessTime;
	}
	
	

}
