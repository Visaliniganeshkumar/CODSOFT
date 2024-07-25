/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm_interface;

/**
 *
 * @author visal
 */
import java.util.Scanner;

class BankAccount {
    double balance;

    public BankAccount(double initial_balance) {
        this.balance = initial_balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.print("\nDeposit Success!!\nNew balance:$" + balance);
        } else {
            System.out.print("\nInvalid deposit!!");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance = balance - amount;
                System.out.print("\nWithdraw Successful!\nNew Balance:$" + balance);
                return true;
            } else {
                System.out.print("\nInsufficient balance for Withdrawal!!\nCurrent Balance:$" + balance);
            }
        } else {
            System.out.print("\nEnter valid positive withdrawal amount!!");
        }
        return false;
    }
}

class ATM {
    private BankAccount bankAccount;
    private Scanner scan;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.scan = new Scanner(System.in);
    }

    public void run() {
        int choice;
        while (true) {
            System.out.print("\nMenu\n\t1)Deposit\n\t2)Withdraw\n\t3)Check Balance\n\t4)Exit");
            System.out.print("\nEnter your choice:");
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("\nEnter amount to Deposit:$");
                    double dep_am = scan.nextDouble();
                    bankAccount.deposit(dep_am);
                    break;
                case 2:
                    System.out.print("\nEnter amount to Withdraw:$");
                    double withdraw_am = scan.nextDouble();
                    boolean withdrawSuccess = bankAccount.withdraw(withdraw_am);
                    if (withdrawSuccess) {
                        System.out.println("\nWithdraw Success!!");
                    } else {
                        System.out.println("\nWithdraw Failure!!");
                    }
                    break;
                case 3:
                    System.out.print("\nCurrent Balance:$" + bankAccount.getBalance());
                    break;
                case 4:
                    System.out.print("\nThank you for visiting!!\nPlease remove your card!!");
                    return;
                default:
                    System.out.println("Invalid choice!!");
            }
        }
    }
}

public class ATM_interface {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int pass;
        String user;
        boolean auth = false;
        int attempts = 0;

        System.out.println("WELCOME TO ATM!!\nINSERT YOUR CARD!!");

        while (attempts < 3) {
            System.out.print("Enter username:");
            user = scan.nextLine();
            System.out.print("Enter 4-digit password:");
            pass = scan.nextInt();
            scan.nextLine();  // Consume newline

            String[] user_name = {"Ram", "Reena", "Anu"};
            int[] password = {1122, 2345, 4561};

            for (int i = 0; i < user_name.length; i++) {
                if (user.equals(user_name[i]) && pass == password[i]) {
                    auth = true;
                    break;
                }
            }

            if (auth) {
                System.out.println("AUTHENTICATION SUCCESSFUL!! PROCESSING YOUR ACCOUNT!!");
                BankAccount bank = new BankAccount(1000.0);
                ATM atm = new ATM(bank);
                atm.run();
                break;
            } else {
                attempts++;
                if (attempts < 3) {
                    System.out.println("INVALID USERNAME OR PASSWORD!! Try again.");
                } else {
                    System.out.println("INVALID USERNAME OR PASSWORD!! You have exceeded the maximum attempts.");
                }
            }
        }
    }
}
