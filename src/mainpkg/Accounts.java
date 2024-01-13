package mainpkg;


public class Accounts {

    private int invoice;
    private int listPrice;
    private int soldPrice;
    private int profit;
    private String desc;
    private String status;

    Accounts(int invoice, int listPrice, int soldPrice, int profit, String desc, String status) {
        this.invoice = invoice;
        this.listPrice = listPrice;
        this.soldPrice = soldPrice;
        this.profit = profit;
        this.desc = desc;
        this.status = status;
    }

    
    public int getInvoice() {
        return invoice;
    }

    public void setInvoice(int inv) {
        invoice = inv;
    }

    public int getListPrice() {
        return listPrice;
    }

    public void setListPrice(int list) {
        listPrice = list;
    }

    public int getSoldPrice() {
        return soldPrice;
    }

    public void setSoldPrice(int sold) {
        soldPrice = sold;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int prof) {
        profit = prof;
    }

    public String getDescription() {
        return desc;
    }

    public void setDescription(String descr) {
        desc = descr;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String stat) {
        status = stat;
    }


    public String toString() {
        return "INVOICE_NUM:[ " + invoice + " ] PRICE_LISTED:[ " + listPrice + " ] PRICE_SOLD:[ " + soldPrice + " ] PROFIT_MADE:[ " + profit + " ] DESCRIPTION:[ " + desc + " ] STATUS:[ " + status+" ]";
    }

}
