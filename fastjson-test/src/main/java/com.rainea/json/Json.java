package com.rainea.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class Json {
    //json字符串-简单对象型
    private static final String  JSON_OBJ_STR = "{\"studentName\":\"lily\",\"studentAge\":12}";
    //json字符串-数组类型
    private static final String  JSON_ARRAY_STR = "[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]";
    //复杂格式json字符串
    private static final String  COMPLEX_JSON_STR = "{\"teacherName\":\"crystall\",\"teacherAge\":27,\"course\":{\"courseName\":\"english\",\"code\":1270},\"students\":[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]}";

    public static void testJSONStrToJSONObject(){

        JSONObject jsonObject = JSON.parseObject(JSON_OBJ_STR);
        //JSONObject jsonObject1 = JSONObject.parseObject(JSON_OBJ_STR); //因为JSONObject继承了JSON，所以这样也是可以的

        System.out.println(jsonObject.getString("studentName")+":"+jsonObject.getInteger("studentAge"));

    }

    public static void main(String[] args) {
//        Json.testJSONStrToJSONObject();

        int a = 0;
        int b = 3;

        double c =  Math.ceil((double)a/b);

        System.out.println(c);
    }
}
