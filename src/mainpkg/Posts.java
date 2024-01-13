
package mainpkg;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class Posts {

    private int post;
    private int seller;
    private String desc;
    private int price;
    private String status;
    private String specs;
    private String hash;

    Posts(int post, int seller, String desc, int price, String status, String specs, String hash) {
        this.post = post;
        this.seller = seller;
        this.desc = desc;
        this.price = price;
        this.status = status;
        this.specs = specs;
        this.hash = hash;
    }

    public int getPost() {
        return post;
    }

    public void setPost(int inv) {
        post = inv;
    }

    public int getSeller() {
        return seller;
    }

    public void setSeller(int list) {
        seller = list;
    }

    public String getDescription() {
        return desc;
    }

    public void setDescription(String descr) {
        desc = descr;
    }

    public int getPrice(){
        return price;
    }
    public void setPrice(int prz){
        price = prz;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String stat) {
        status = stat;
    }
     public String getSpecs() {
        return status;
    }

    public void setSpecs(String sp) {
        specs = sp;
    }
    
     public String getHash() {
        return hash;
    }

    public void setHash(String h) {
        hash = h;
    }
    public String toString(){
        return "POST:[ "+ post + " ] SELLER:[ "+ seller +" ] DESCRIPTION:[ "+ desc + " ] PRICE:[ "+ price + " ] STATUS:[ "+ status +" ] SPECIFICATIONS:[ "+ specs + " ] HASHTAGS:[ "+ hash +" ]";
     }
}
