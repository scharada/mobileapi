package org.mobileapi.helper;

public class ZookeeperKeyFilter {
	
	public static boolean doFilter(String key)
	{
		if(key.equals("zookeeper"))
		{
			return true;
		}
		if(key.equals("updated"))
		{
			return true;
		}
		return false;
	}
}
