/*
*Programmer: Nguyễn Hoàng Hiệp 
*Description: This file describes the model of user 
 */
package model;

/**
 *
 * @author Inspiron
 */
public class User {

    private int id;
    private String username;
    private String password;
    private String dob;
    private String email;
    private String gender;
    private String avatar;
    private int roleid;
    private double money;

    public User() {
    }

    public User(int id, String username, String password, String dob, String email, String gender, String avatar, int roleid, double money) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.dob = dob;
        this.email = email;
        this.gender = gender;
        this.avatar = avatar;
        this.roleid = roleid;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
    @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User item = (User) o;
            return id == item.getId() &&
                    getUsername().equals(item.getUsername())&&
                    getPassword().equals(item.getPassword())&&
                    getDob().equals(item.getDob())&&
                    getEmail().equals(item.getEmail())&&
                    getGender().equals(item.getGender())&&
                    getRoleid() == item.getRoleid()&&
                    getMoney() == item.getMoney();
                    
        }
}
