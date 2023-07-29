/*
*Programmer: Nguyễn Hoàng Hiệp 
*Description: This file describes the model of items that will appear on the market
 */
package model;

/**
 *
 * @author Inspiron
 */
public class MarketItems extends GameItems {

    private int id;
    private String gameAccountName;
    private int userid;
    private double price;
    private String begindate;
    private String enddate;

    public MarketItems(int id, String gameAccountName, int userid, double price, String begindate, String enddate,
            int gid, String skinname, String itemname, String type, String rarity, String exterior, String img) {
        super(gid, skinname, itemname, type, rarity, exterior, img);
        this.id = id;
        this.gameAccountName = gameAccountName;
        this.userid = userid;
        this.price = price;
        this.begindate = begindate;
        this.enddate = enddate;
    }
    public MarketItems(int id, String gameAccountName, int userid,int item_id, double price, String begindate, String enddate){
        super(item_id,null,null,null,null,null,null);
        this.id = id;
        this.gameAccountName = gameAccountName;
        this.userid = userid;
        this.price = price;
        this.begindate = begindate;
        this.enddate = enddate;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getgameAccountName() {
        return gameAccountName;
    }

    public void setgameAccountName(String gameAccountName) {
        this.gameAccountName = gameAccountName;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBegindate() {
        return begindate;
    }

    public void setBegindate(String begindate) {
        this.begindate = begindate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }
    public int getItemId(){
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
            MarketItems item = (MarketItems) o;
            return id == item.getId() &&
                    getgameAccountName().equals(item.getgameAccountName()) &&
                    getUserid() == item.getUserid() &&
                    getPrice() == item.getPrice() &&
                    getBegindate().equals(getBegindate()) &&
                    getEnddate().equals(item.getEnddate());
        }
}
