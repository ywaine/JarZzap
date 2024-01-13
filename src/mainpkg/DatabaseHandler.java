package mainpkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DELL
 */
public class DatabaseHandler {

    private String url = "jdbc:ucanaccess://IT Matric Project 1.accdb";

    private Connection conn = null;

    /**
     *
     */
    public DatabaseHandler() {
        try {
            conn = connectDatabase();

        } catch (SQLException ex) {
            System.err.println("[DB] - failed to connect to Databas\n" + ex);
        }
    }

    private Connection connectDatabase() throws SQLException {
        Connection c = null;

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            c = DriverManager.getConnection(url);
            System.out.println("[DB] - connected");
        } catch (ClassNotFoundException e) {
            System.err.println("[DB] - driver error\n" + e);
        }
        return c;
    }

    public Accounts[] getAccounts() {
        System.out.println("[DB] - grabbing all accounts");

        Accounts[] list = null;

        try {
            String sql = "SELECT * FROM tblAccounts";

            PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = stmt.executeQuery();
            rs.last();
            int numRecords = rs.getRow();
            rs.beforeFirst();
            list = new Accounts[numRecords];
            int count = 0;
            while (rs.next()) {
                int invoice = rs.getInt("INVOICE_NUM");
                int listPrice = rs.getInt("PRICE_LISTED");
                int soldPrice = rs.getInt("PRICE_SOLD");
                int profit = rs.getInt("PROFIT_MADE");
                String desc = rs.getString("DESCRIPTION");
                String status = rs.getString("STATUS");
                list[count++] = new Accounts(invoice, listPrice, soldPrice, profit, desc, status);
            //       System.out.println(list[count-1].toString());

            }
         
        } catch (Exception e) {
            System.err.println("[DB] - error running query " + e);
        }
        return list;
    }

    public Accounts getOneAccount(String oneAccount) {

        System.out.println("[DB] - grabbing one account - "+oneAccount);

        Accounts out = null;

        try {
            String sql = "SELECT * FROM tblAccounts WHERE INVOICE_NUM = ?";

            PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            stmt.setString(1, oneAccount);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int invoice = rs.getInt("INVOICE_NUM");
                int listPrice = rs.getInt("PRICE_LISTED");
                int soldPrice = rs.getInt("PRICE_SOLD");
                int profit = rs.getInt("PROFIT_MADE");
                String desc = rs.getString("DESCRIPTION");
                String status = rs.getString("STATUS");
                out = new Accounts(invoice, listPrice, soldPrice, profit, desc, status);
            }
            rs.close();

        } catch (Exception e) {
            System.err.println("[DB] - error running query"+oneAccount+" \n" + e);
        }
        return out;
    }

    public Posts[] getPosts() {
        System.out.println("[DB] - grabbing all posts");
//return this full of records later
        Posts[] list = null;

        try {
            String sql = "SELECT * FROM tblPosts";
            //prare the sql statement t0 rub against the database
            PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = stmt.executeQuery();
            // let's check how many we found
            rs.last();
            int numRecords = rs.getRow();
            // reset my cursor
            rs.beforeFirst();
            //initialize my return array
            list = new Posts[numRecords];
            // let's save what we found as objects
            int count = 0;
            while (rs.next()) {
                int post = rs.getInt("POST_ID");
                int seller = rs.getInt("SELLER_ID_FK");
                String desc = rs.getString("DESCRIPTION");
                int price = rs.getInt("PRICE");
                String status = rs.getString("STATUS");
                String specs = rs.getString("SPECIFICATIONS");
                String hash = rs.getString("HASH_TAGS");
                // add posts to the array
                list[count++] = new Posts(post, seller, desc, price, status, specs, hash);
            }

        } catch (Exception e) {
            System.err.println("[DB] - error running query " + e);
        }
        // give me back the list of posts
        return list;
    }

    public Posts getOnePost(String onePost) {
        System.out.println("[DB] - grabbing one post -" +onePost);

        Posts out = null;

        try {
            String sql = "SELECT * FROM tblPosts WHERE POST_ID = ?";

            PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            stmt.setString(1, onePost);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int post = rs.getInt("POST_ID");
                int seller = rs.getInt("SELLER_ID_FK");
                String desc = rs.getString("DESCRIPTION");
                int price = rs.getInt("PRICE");
                String status = rs.getString("STATUS");
                String specs = rs.getString("SPECIFICATIONS");
                String hash = rs.getString("HASH_TAGS");
                out = new Posts(post, seller, desc, price, status, specs, hash);
            }
            rs.close();

        } catch (Exception e) {
            System.err.println("[DB] - error running query "+onePost +"\n"+ e);
        }
        return out;
    }

    

}
