public class Account {

    private String name;
    private double balance;
    private long account_number;
    // default constructor
    //Account()   {}
    
    Account( String c_name, double c_balance, long c_num)
    {
        name = c_name;
        balance = c_balance;
        account_number = c_num;
    }

    public void deposit_funds( double p_amount)
    {
        balance += p_amount;
    }

    public int withdraw_funds( double p_amount)
    {
        // check if enough funds
        if ( p_amount > balance )
            return -1;
        else
            balance -= p_amount;
        return 0;
    }

    public double get_balance()
    {
        return balance;
    }
    public String get_name()
    {
        return name;
    }

    public long get_account_number()
    {
        return account_number;
    }
    
}