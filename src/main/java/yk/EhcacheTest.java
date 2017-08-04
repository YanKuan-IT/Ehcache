package yk;


import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EhcacheTest {
	public static void main(String[] args) {
		//根据ehcache.xml配置文件创建Cache管理器
		CacheManager manager = CacheManager.create("./src/main/resources/ehcache.xml");
		//获取指定cache
		Cache cache = manager.getCache("a");
		//实例化一个元素
		Element element = new Element("hello","world");
		//把一个元素添加到cache中
		cache.put(element);
		
		//根据key获取缓存元素
		Element element2 = cache.get("hello");
		System.out.println(element2);
		System.out.println(element2.getObjectValue());
//		[ key = hello, value=world, version=1, hitCount=1, CreationTime = 1501831986462, LastAccessTime = 1501831986467 ]
//		world
		
		
		//刷新缓存
		cache.flush();
		//关闭缓存管理器
		manager.shutdown();
	}
}
