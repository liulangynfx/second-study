package com.rainea.ssm.po;

import java.util.List;

/**
 * <p>Title: ItemQueryVo.java</p>
 * <p>Description: 商品的查询对象</p>
 * @author liulang
 * @date   Apr 12, 2017
 * @version 
 */
public class ItemQueryVo {
    
    private Items items;
    
    private ItemsCustome itemsCustome;
    
    private List<ItemsCustome> itemsList;

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public ItemsCustome getItemsCustome() {
        return itemsCustome;
    }

    public void setItemsCustome(ItemsCustome itemsCustome) {
        this.itemsCustome = itemsCustome;
    }

    public List<ItemsCustome> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<ItemsCustome> itemsList) {
        this.itemsList = itemsList;
    }
    
    
}
