/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kirui.Dao;

import com.kirui.Model.Item;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author CKIRUI
 */
public interface ItemDao extends CrudRepository<Item, Integer>  {
    
    Item findByItemID(String itemID);
    
}
