package com.example.demo.util;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName LRUCache
 * @Descriptino  LRU算法demo
 * @Author myzhen
 * @Date 2020/9/9 下午3:39
 * @Version 1.0
 **/
public class LRUCache<K,V> extends LinkedHashMap<K,V> {

    private static final long serialVersionUID = 1L;

    private int CACHE_SIZE;

    // true 表示让linkedHashMap 按照访问顺序来进行排序，最近访问的放在头部，最老访问的放在尾部
    public LRUCache(int cacheSize) {
        super((int)Math.ceil(cacheSize/0.75)+1,0.75f,true);
        this.CACHE_SIZE = cacheSize;
    }

    /***
     *    缓存是否已满
	 */
    protected boolean removeEldestEntry(Map.Entry<K, V>eldest) {

        //当map中的数据量大于指定的缓存个数的时候，就自动删除最老的数据
        boolean bool= size()> CACHE_SIZE;
        if(bool) {
            System.out.println("清除缓存key:"+eldest.getKey());
        }
        return bool;
    }

    public static void main(String[] args) {

        LRUCache<String,String> cache =new LRUCache<String,String>(5);
        cache.put("1", "1");
        cache.put("2", "2");
        cache.put("3", "3");
        cache.put("4", "4");
        cache.put("5", "5");
        System.out.println("初始化: ");
        System.out.println(cache.keySet());
        System.out.println("访问3: ");
        cache.get("3");
        System.out.println(cache.keySet());
        System.out.println("访问2: ");
        cache.get("2");
        System.out.println(cache.keySet());
        System.out.println("增加数据 6,7: ");
        cache.put("6","6");
        cache.put("7","7");
        System.out.println(cache.keySet());


    }
}
