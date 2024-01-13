/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

/**
 *
 * @author DELL
 */
public class SearchPosts {
    private String mySearch;
    private String desc,stat,spec,hash;
    private int post,sell,price;
    private DatabaseHandler db;
    public SearchPosts(String have,DatabaseHandler dbh,String get){
        try{
        db = dbh;
        mySearch = have.split(" ")[1];
        Posts po = db.getOnePost(mySearch);
           
        post = po.getPost();

        sell = po.getSeller();

        desc = po.getDescription();

        price =po.getPrice();

        stat = po.getStatus();

        spec = po.getSpecs();

        hash = po.getHash();
            
        }catch(Exception e){
            System.err.println("Search Function Error !\n"+e);
        }
        
    }
    
    
}
