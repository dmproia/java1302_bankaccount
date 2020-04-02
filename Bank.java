import java.util.*;

public class Bank {
    
    private String bank_name;
    private Scanner input;

    // create 3 accounts
    private boolean bContinue = true;
    private boolean bAcc = true;

    // constructors
    Bank()  {}
    Bank(String b_name)
    {
        bank_name = b_name;
    }

    int processClients()
    {
        System.out.println("\t" + bank_name.toUpperCase());
        System.out.println("==========================================");
        Account[] pAccounts = new Account[3];
        String tmp_name;
        double tmp_bal;
        long tmp_num;

        input = new Scanner(System.in);
        
        pAccounts[0] = new Account("Joe", 29, 1001);
        pAccounts[1] = new Account("Bob", 40, 1002);
        pAccounts[2] = new Account("Janis", 50, 1003);
        
        while (bContinue)
        {
            int acc;
            System.out.println("Select Account\n==========================================");
            for ( int k = 0; k < pAccounts.length; k++)
            {
                System.out.println(k + " ) " + pAccounts[k].get_name() + " - " + pAccounts[k].get_account_number() );
            }
            acc = input.nextInt();

            while (bAcc)
            {
                System.out.println("Choose Function\n1 ) Deposit\n2 ) Withdraw\n3 ) Balance Enquiry");
                int sel = input.nextInt();
                if ( sel == 1)
                {
                    System.out.println("Enter Amount to Deposit -> ");
                    pAccounts[acc].deposit_funds(input.nextDouble() );
                }
                else if ( sel == 2)
                {
                    System.out.println("Enter Amount To Withdraw -> ");
                    if( pAccounts[acc].withdraw_funds(input.nextDouble() ) == -1)
                    {
                        System.out.println("Insufficient Funds");
                    }
                    else
                        System.out.println("Take your Funds");
                }
                else if ( sel == 3)
                {
                    System.out.println("Balance -> $ " + String.format("%.2f", pAccounts[acc].get_balance()) );
                }
                else
                    System.out.println("Invalid Selection");

                System.out.println("Continue With This Account\n1 ) Yes\n2 ) No");
                if( input.nextInt() == 1)
                        bAcc = true;
                else bAcc = false;
            }
            bAcc = true;
            // now check if to continue
            System.out.println("Would You Like To Continue\n1 ) Yes\n2 ) No");
            if (input.nextInt() == 1) bContinue = true;
            else
                return 0;

        }

        return 0;
    }
    public static void main(String[] args)
    {
        Bank myBank = new Bank("National Australia Bank");
        System.exit( myBank.processClients() );
    }
}

