package com;

/** 
 * 与ThreadLocal有关的实体对象 
 * @author kang 
 * 
 */
public class MyThreadScopeData
{
    
    //声明一个ThreacLoacl  
    private static ThreadLocal<MyThreadScopeData> map = new ThreadLocal<MyThreadScopeData>();
    
    //通过单例模式来获取对象实例  
    private MyThreadScopeData()
    {
    }
    
    public static MyThreadScopeData getThreadInstance()
    {
        MyThreadScopeData instance = map.get();
        if (instance == null)
        {
            instance = new MyThreadScopeData();
            map.set(instance);
        }
        return instance;
    }
    
    private String name;
    
    private int age;
    
    public static ThreadLocal<MyThreadScopeData> getMap()
    {
        return map;
    }
    
    public static void setMap(ThreadLocal<MyThreadScopeData> map)
    {
        MyThreadScopeData.map = map;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public int getAge()
    {
        return age;
    }
    
    public void setAge(int age)
    {
        this.age = age;
    }
    
}