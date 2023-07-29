/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author ksiks
 */
public class SellList extends MarketItems{
    int id;
    int seller_id;
    
    public SellList(int id, int buyer_id, int mid, String game, int user_id, double price, String begindate, String enddate, int gid, String skin_name, String item_name, String type, String rarity, String exterior, String img) {
        super(mid, game, user_id, price, begindate, enddate ,gid, skin_name, item_name, type, rarity, exterior, img);
        this.id = id;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(int seller_id) {
        this.seller_id = seller_id;
    }
    
    public int getSellItemId() {
        return super.getId();
    }

   
}
