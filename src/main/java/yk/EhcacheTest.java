package yk;


import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EhcacheTest {
	public static void main(String[] args) {
		//����ehcache.xml�����ļ�����Cache������
		CacheManager manager = CacheManager.create("./src/main/resources/ehcache.xml");
		//��ȡָ��cache
		Cache cache = manager.getCache("a");
		//ʵ����һ��Ԫ��
		Element element = new Element("hello","world");
		//��һ��Ԫ����ӵ�cache��
		cache.put(element);
		
		//����key��ȡ����Ԫ��
		Element element2 = cache.get("hello");
		System.out.println(element2);
		System.out.println(element2.getObjectValue());
//		[ key = hello, value=world, version=1, hitCount=1, CreationTime = 1501831986462, LastAccessTime = 1501831986467 ]
//		world
		
		
		//ˢ�»���
		cache.flush();
		//�رջ��������
		manager.shutdown();
	}
}
