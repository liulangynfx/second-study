package com.rainea.ssm.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * <p>Title: CustomeDateConverter.java</p>
 * <p>Description: 自定义日期转换器</p>
 * @author liulang
 * @date   Apr 13, 2017
 * @version 
 */
public class CustomeDateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String sourceString) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf.parse(sourceString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
