/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kirui.Controller;

import com.kirui.Dao.ItemDao;
import com.kirui.Model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author CKIRUI
 */
@RestController
@Controller
@RequestMapping(path = "/items")
   
public class ItemController {
     @Autowired
    public ItemDao itemDao;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Item> getAllItems(){
        return itemDao.findAll();
    
    }
     @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Item getItemByid(@PathVariable("id") int id){
        return itemDao.findOne(id);
        }
        
        @RequestMapping(path = "/del/{id}", method = RequestMethod.DELETE)
    public void deleteItemById(@PathVariable("id") int id){
        itemDao.delete(id);
    }
    @RequestMapping(value ="/add/",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addItem(@RequestBody Item item){
        this.itemDao.save(item);
    }
}
