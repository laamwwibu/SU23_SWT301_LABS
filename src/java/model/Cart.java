/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author Inspiron
 */
public class Cart extends MarketItems{
    int id;
    int buyer_id;

    public Cart(int id, int buyer_id, int market) {
        super(market, null, 0, 0, null, null, 0, null, null, null, null, null, null);
        this.id = id;
        this.buyer_id = buyer_id;
    }
   
    public Cart(int id, int buyer_id, int mid, String game, int user_id, double price, String begindate, String enddate, int gid, String skin_name, String item_name, String type, String rarity, String exterior, String img) {
        super(mid, game, user_id, price, begindate, enddate, gid, skin_name, item_name, type, rarity, exterior, img);
        this.id = id;
        this.buyer_id = buyer_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(int buyer_id) {
        this.buyer_id = buyer_id;
    }
    
    public int getMarketItemId() {
        return super.getId();
    }
@Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Cart item = (Cart) o;
            return id == item.getId() &&
                    buyer_id == item.getBuyer_id() &&
                    getMarketItemId() == item.getMarketItemId();
        }

}
