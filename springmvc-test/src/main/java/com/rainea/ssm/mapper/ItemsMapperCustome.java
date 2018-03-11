package com.rainea.ssm.mapper;

import com.rainea.ssm.po.ItemQueryVo;
import com.rainea.ssm.po.ItemsCustome;
import java.util.List;

public interface ItemsMapperCustome {
    
    /**
     * 商品查询列表
     */
    public List<ItemsCustome> listItems(ItemQueryVo itemQueryVo) throws Exception;
}