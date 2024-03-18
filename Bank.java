// Xavier De Almeida
//Stu #: 200565791

package Assignment2;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String bankName;
    private BranchLocations branchLocation;
    private List<Account> accounts;

    public enum BranchLocations {
        DOWNTOWN, MIDTOWN, UPTOWN, SUBURB, RURAL
    }

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public Bank(String bankName, String branchLocation) {
        this();
        this.bankName = isValidBankName(bankName) ? bankName : "Default Bank";
        this.branchLocation = BranchLocations.valueOf(branchLocation.toUpperCase());
    }

    public Bank(String bankName, BranchLocations branchLocation) {
        this();
        this.bankName = isValidBankName(bankName) ? bankName : "Default Bank";
        this.branchLocation = branchLocation;
    }

    public String getBankName() {
        return bankName;
    }

    public boolean setBankName(String bankName) {
        if (isValidBankName(bankName)) {
            this.bankName = bankName;
            return true;
        }
        return false;
    }

    public boolean setBranchLocation(String branchLocation) {
        try {
            this.branchLocation = BranchLocations.valueOf(branchLocation.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
    public boolean setBranchLocation(BranchLocations branchLocation) {
        if (branchLocation != null) {
            this.branchLocation = branchLocation;
            return true;
        }
        return false;
    }
    public String getBranchLocation() {
        return branchLocation.name();
    }

    public Account getAccountByNumber(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return new Account();
    }

    public boolean addAccount(Account account) {
        if (!accountExists(account.getAccountNumber())) {
            accounts.add(account);
            return true;
        }
        return false;
    }

    public boolean addAccount(String accountName, int accountNumber, double accountBalance) {
        if (!accountExists(accountNumber)) {
            accounts.add(new Account(accountName, accountNumber, accountBalance));
            return true;
        }
        return false;
    }

    public Account viewAccount(int accountNumber) {
        return getAccountByNumber(accountNumber);
    }

    public Account viewAccount(byte index) {
        if (index >= 0 && index < accounts.size()) {
            return accounts.get(index);
        }
        return new Account(); // return empty object when objec t is invalid
    }

    public boolean deleteAccount(int accountNumber) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNumber() == accountNumber) {
                accounts.remove(i);
                return true; // Account found and dleted
            }
        }
        return false; // Account not found
    }

    public boolean deleteAccount(byte index) {
        if (index >= 0 && index < accounts.size()) {
            accounts.remove(index);
            return true; // account removed by index
        }
        return false; // Index out of bounds
    }

    private boolean accountExists(int accountNumber) {
        return accounts.stream().anyMatch(acc -> acc.getAccountNumber() == accountNumber);
    }

    private boolean isValidBankName(String bankName) {
        return bankName != null && bankName.matches("[a-zA-Z0-9& ]{8,}");
    }

}
