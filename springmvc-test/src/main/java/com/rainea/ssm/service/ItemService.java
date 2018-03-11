package com.rainea.ssm.service;

import java.util.List;

import com.rainea.ssm.po.ItemQueryVo;
import com.rainea.ssm.po.Items;
import com.rainea.ssm.po.ItemsCustome;

public interface ItemService {
    /**
     * 商品查询service
     */
    public List<ItemsCustome> listItems(ItemQueryVo itemQueryVo) throws Exception;
    
    /**
     * 根据id查询商品
     * @param id
     * @return
     * @throws Exception
     */
    public ItemsCustome getItemByID(Integer id) throws Exception;
    
    /**
     * 更新商品信息
     * @param id
     * @param items
     * @throws Exception
     */
    public void updateItem(Integer id, Items items) throws Exception;
}
