package org.puru.cache.store;

import java.util.HashMap;
import java.util.Map;

public class DataStore {

 private    Map<String,String> level1Store = new HashMap<>();
 private	Map<String,String> level2Store = new HashMap<>();
 private 	Map<String,String> level3Store = new HashMap<>();
 
 
 public String getValfromLevel1(String key) {
	return level1Store.get(key);
 }
 
 public void storeValInLevel1(String key,String val) {
	 if(level1Store.size()>2) {
		 
	 }
 }
	
}
