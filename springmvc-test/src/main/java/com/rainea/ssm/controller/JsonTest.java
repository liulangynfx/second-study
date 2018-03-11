package com.rainea.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rainea.ssm.po.ItemsCustome;

@Controller
public class JsonTest {
    
    /**
     * 请求json返回json
     * @param itemsCustome
     * @return
     * @throws Exception
     */
    @RequestMapping("/jsonTest1")
    public @ResponseBody ItemsCustome jsonTest1(@RequestBody ItemsCustome itemsCustome) throws Exception {
        
        return itemsCustome;
    }
    
    /**
     * 请求key/value，返回json
     * @param itemsCustome
     * @return
     * @throws Exception
     */
    @RequestMapping("/jsonTest2")
    public @ResponseBody ItemsCustome jsonTest2(ItemsCustome itemsCustome) throws Exception {
        
        return itemsCustome;
    }
    
}
