public class Wallet {

    private int fazCoin;
    private double USDollars;

    public Wallet() {
        fazCoin = 500;
        USDollars = 5;
    }//end constructor

    public Wallet(int fazCoin, double USDollars) {
        this.fazCoin = fazCoin;
        this.USDollars = USDollars;
    }//end constructor

    public int getFazCoin() {
        return fazCoin;
    }//end method

    public void setFazCoin(int fazCoin) {
        this.fazCoin = fazCoin;
    }//end method

    public double getUSDollars() {
        return USDollars;
    }//end method

    public void setUSDollars(double USDollars) {
        this.USDollars = USDollars;
    }//end method


}//end class
