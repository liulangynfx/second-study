package com.rainea;

import com.alibaba.fastjson.JSON;
import redis.clients.jedis.Jedis;

import java.util.List;

public class BasicExercise {

    private static Jedis jedis;

    static  {
        getJedis();
    }

    public static void main(String[] args) {
//        stringTest();
        listTest();
    }

    /**
     * 连接本地redis
     * @return
     */
    public static Jedis getJedis() {
        //连接本地redis服务
        jedis = new Jedis("localhost");
        System.out.println("redis 连接成功：" + jedis.ping());
        return jedis;
    }

    /**
     * 字符串测试
     */
    public static void stringTest() {

        //设置字符串
        String key = "name";
        jedis.set(key, "liulang");
        String name = jedis.get(key);
        printValue(name);

        jedis.append(key, " is my name");
        printValue(jedis.get(key));

        jedis.del(key);
        printValue(jedis.get(key));

        //s设置多个键值对
        jedis.mset("name", "chenhaoxiang", "age", "20", "email", "chxpostbox@outlook.com");
        jedis.incr("age");//用于将键的整数值递增1。如果键不存在，则在执行操作之前将其设置为0。 如果键包含错误类型的值或包含无法表示为整数的字符串，则会返回错误。此操作限于64位有符号整数。
        System.out.println(jedis.get("name") + " " + jedis.get("age") + " " + jedis.get("email"));

    }

    /**
     * list测试
     */
    public static void listTest() {
        //设置list
        jedis.lpush("list", "11");
        jedis.lpush("list", "22");
        jedis.lpush("list", "33");
        jedis.lpush("list", "44");

        List<String> list = jedis.lrange("list", 0, -1);
        printValue(list);
        printValue(jedis.llen("list"));
        //删除list
        jedis.del("list");
        printValue(jedis.llen("list"));
        printValue(jedis.lrange("list", 0, -1));
    }

    /**
     * 打印
     * @param
     */
    public static void printValue(Object object) {
        System.out.println(JSON.toJSON(object));
    }
}
