package mod3_3;

public class Task1 {
    public static class BankAccount {
        private final int accountNumber;
        private float balance;
        static int totalAccounts = 0;
        public BankAccount(int balance){
            totalAccounts ++;
            this.accountNumber = totalAccounts;
            this.balance = balance;
        }

        public float getBalance() {
            return balance;
        }

        public int getAccountNumber() {
            return accountNumber;
        }

        public static int getTotalAccounts() {
            return totalAccounts;
        }
        public void deposit(float value){
            this.balance += value;
        }
        public void withdraw(float value){
            this.balance -= value;
        }


        public static void main(String[] args) {
            BankAccount account1 = new BankAccount(1000);
            BankAccount account2 = new BankAccount(2000);

            account1.deposit(500);
            account2.withdraw(800);

            System.out.println("Account " + account1.getAccountNumber() + " balance: " + account1.getBalance());
            System.out.println("Account " + account2.getAccountNumber() + " balance: " + account2.getBalance());

            System.out.println("Total number of accounts: " + BankAccount.getTotalAccounts());
        }
    }
}
