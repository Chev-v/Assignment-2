// Xavier De Almeida
//Stu #: 200565791

package Assignment2;

public class Account {
    private String accountName;
    private int accountNumber;
    private double accountBalance;

    public Account() {
    }

    public Account(String accountName, int accountNumber, double accountBalance) {
        this.accountName = isValidAccountName(accountName) ? accountName : "Default Account";
        this.accountNumber = isValidAccountNumber(accountNumber) ? accountNumber : 10000;
        this.accountBalance = accountBalance;
    }

    public String getAccountName() {
        return accountName;
    }

    public boolean setAccountName(String accountName) {
        if (isValidAccountName(accountName)) {
            this.accountName = accountName;
            return true;
        }
        return false;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public boolean setAccountNumber(int accountNumber) {
        if (isValidAccountNumber(accountNumber)) {
            this.accountNumber = accountNumber;
            return true;
        }
        return false;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    private boolean isValidAccountName(String accountName) {
        return accountName != null && accountName.matches("[a-zA-Z-' ]{4,}");
    }

    private boolean isValidAccountNumber(int accountNumber) {
        String numStr = Integer.toString(accountNumber);
        return numStr.length() >= 5 && numStr.length() <= 9 && accountNumber > 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Account)) return false;
        Account other = (Account) obj;
        return this.accountNumber == other.accountNumber && Double.compare(this.accountBalance, other.accountBalance) == 0 && this.accountName.equals(other.accountName);
    }

    @Override
    public String toString() {
        return String.format("Account Name: %s, Account Number: %d, Account Balance: %.2f", accountName, accountNumber, accountBalance);
    }
}
