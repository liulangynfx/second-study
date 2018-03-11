package com.rainea.ssm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.rainea.ssm.exception.CustomeException;
import com.rainea.ssm.mapper.ItemsMapper;
import com.rainea.ssm.mapper.ItemsMapperCustome;
import com.rainea.ssm.po.ItemQueryVo;
import com.rainea.ssm.po.Items;
import com.rainea.ssm.po.ItemsCustome;
import com.rainea.ssm.service.ItemService;

/**
 * <p>Title: ItemServiceImpl.java</p>
 * <p>Description: </p>
 * @author liulang
 * @date   Apr 12, 2017
 * @version 
 */
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemsMapperCustome itemsMapperCustome;
    
    @Autowired
    private ItemsMapper itemsMapper;
    
    @Override
    public List<ItemsCustome> listItems(ItemQueryVo itemQueryVo) throws Exception {
        //通过itemsMapperCustome查询数据库
        return itemsMapperCustome.listItems(itemQueryVo);
    }

    @Override
    public ItemsCustome getItemByID(Integer id) throws Exception {
        Items items = itemsMapper.selectByPrimaryKey(id);
        ItemsCustome itemsCustome = new ItemsCustome();
        //拷贝属性
        BeanUtils.copyProperties(items, itemsCustome);
        return itemsCustome; 
    }

    @Override
    public void updateItem(Integer id, Items items) throws Exception {
        if(id == null) {
            throw new Exception("id不可为空!");
        }
        items.setId(id);
        itemsMapper.updateByPrimaryKeyWithBLOBs(items);
        
    }

}
