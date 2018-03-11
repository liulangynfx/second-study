package com.rainea.ssm.controller;

import com.rainea.ssm.po.ItemQueryVo;
import com.rainea.ssm.po.ItemsCustome;
import com.rainea.ssm.service.ItemService;
import com.rainea.ssm.validator.ValidatorItems;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;
    
    
    /**
     * 查询商品列表
     * @return
     * @throws Exception
     */
    @RequestMapping("/listItems")
    public ModelAndView listItems(ItemQueryVo itemQueryVo) throws Exception {
      List<ItemsCustome> items = itemService.listItems(itemQueryVo);
      
      ModelAndView mv = new ModelAndView();
      mv.addObject("itemsList", items);
      mv.setViewName("itemsList");
      
      return mv;
    }
    
    /**
     * 根据ID查询商品信息
     */
    @RequestMapping("/getItem")
    public ModelAndView findOneItem(Integer id) throws Exception {
        ItemsCustome item = itemService.getItemByID(id);
        
        ModelAndView mv = new ModelAndView();
        mv.addObject("itemsCustome", item);
        mv.setViewName("editItems");
        
        return mv;
    }
    
    /**
     * 更新商品信息
     */
    @RequestMapping("/updateItem")
    public String updateItem(HttpServletRequest request, Model model, Integer id, @Validated(value={ValidatorItems.class}) ItemsCustome items, BindingResult bindingResult,
            MultipartFile pictureFile) throws Exception {
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            model.addAttribute("allErrors", allErrors);
            for (ObjectError objectError : allErrors) {
                System.out.println(objectError.getDefaultMessage());
            }
            return "editItems";
        } else {
            if (pictureFile != null && !StringUtils.isBlank(pictureFile.getOriginalFilename())) {
                String phyPath="C:\\Users\\liulang\\Desktop\\exercise\\uploadFiles\\pic";
                String oriName = pictureFile.getOriginalFilename();
                String newName = UUID.randomUUID().toString().replace("-", "") + oriName.substring(oriName.lastIndexOf('.')); 
                File file = new File(phyPath + "\\" + newName);
                pictureFile.transferTo(file);
                items.setPic(newName);
            }
            itemService.updateItem(id, items);
            return "success";
        }
        
    }
    
    /**
     * 批量删除商品
     * @param
     * @return
     */
    @RequestMapping("/deleteItemBatch")
    public String deleteItemBatch(Integer[] itemsID) {
        return "success";
    }
    
    /**
     * 查询出要更新的商品
     * @param itemQueryVo
     * @return
     * @throws Exception
     */
    @RequestMapping("/listEditItems")
    public ModelAndView listEditItems(ItemQueryVo itemQueryVo) throws Exception {
      List<ItemsCustome> items = itemService.listItems(itemQueryVo);
      
      ModelAndView mv = new ModelAndView();
      mv.addObject("itemsList", items);
      mv.setViewName("editItemsBatch");
      
      return mv;
    }
    
    /**
     * 批量修改商品信息
     * @return
     */
    @RequestMapping("/updateItemsBatch")
    public String updateItemsBatch(ItemQueryVo itemQueryVo) {
        //service层处理
        
        return "success";
    }
    
    /**
     * restful风格url测试
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping("/getItemRest/{id}")
    public @ResponseBody ItemsCustome getItemRest(@PathVariable("id") Integer itemId) throws Exception {
        return itemService.getItemByID(itemId);
    } 
    
}
