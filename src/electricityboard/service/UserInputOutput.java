package electricityboard.service;

import electricityboard.dao.TransactionDetailsDao;
import electricityboard.dao.UserDetailsDao;
import electricityboard.model.TransactionDetails;
import electricityboard.model.UserDetails;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.UUID;

import static electricityboard.service.CalculateBill.calculate;


public class UserInputOutput {
    public static void UserInput(Scanner sc, String customerId) throws SQLException {

        UserDetailsDao userDetailsDao = new UserDetailsDao();
        TransactionDetailsDao transactionDetailsDao = new TransactionDetailsDao();
        UserDetails userDetails = new UserDetails();
        UserDetails user = userDetailsDao.getById(customerId);
        double bill = calculate(user.getConsumedUnits(), user.getState());
        double totalAmount = (bill * 0.11) + bill;
        System.out.println("Hello,  " + user.getCustomerName() + " Ji!");
        System.out.println("The  amount of units consumed for Customer Id - " + customerId + " are :  " + user.getConsumedUnits());
        System.out.println(" " + "Dear user, " + user.getCustomerName() + ", Would you like to pay the bill now ?" + "\n" + " Kindly enter 'Yes/Y' to proceed or 'No/N' to Exit.");

        String input = sc.next();
        if (input.equalsIgnoreCase("NO") || input.equalsIgnoreCase("N")) {
            System.out.println("Thank you");
            System.out.println("You have exited successfully");
        } else if (input.equalsIgnoreCase("YES") || input.equalsIgnoreCase("Y")) {

            System.out.println("The Electricity bill as per the units consumed  along with state taxes for your state : " + user.getState() + " is Rs " + totalAmount);
            System.out.println("Kindly enter 'Y' to complete the payment or 'N' to Exit :");
            char input1 = sc.next().charAt(0);
            switch (input1) {
                case 'Y':
                case 'y':
                    if (totalAmount > user.getWalletBalance()) {
                        System.out.println("Insufficient balance in your wallet");
                        System.out.println("Kindly add Rs " + (totalAmount - user.getWalletBalance()) + " to pay the bill successfully.");
                        System.out.println("Do you want to add money");
                        System.out.println("Please press Y to add money");
                        char input2 = sc.next().charAt(0);
                        switch (input2) {
                            case 'y':
                            case 'Y':
                                System.out.println("Please Enter card details : ");
                                CardValidation.cardValidation();
                                System.out.println("Kindly enter the amount you want to add to your wallet :");
                                long addToWallet = sc.nextLong();
                                 long updatedWalletBalance = addToWallet + userDetails.getWalletBalance();
                                System.out.println("Now, you have Rs- " + updatedWalletBalance+ "in your wallet.");

                                break;
                            case 'N':
                            case 'n':
                                System.out.println("Thank you *");
                            default:
                                System.out.println("Invalid Entry...");
                                break;
                        }
                    } else if (totalAmount < user.getWalletBalance()) {
                        UUID uuid = UUID.randomUUID();
                        LocalDateTime now = LocalDateTime.now();
                        long remainingAmount = (long) (userDetails.getWalletBalance() - totalAmount);
                        userDetails.setWalletBalance((int) remainingAmount);
                        UserDetailsDao.save(userDetails);
                        TransactionDetails transactionDetails = new TransactionDetails(customerId, uuid.toString(), now.toString(), "Paid", totalAmount);
                        transactionDetailsDao.update(transactionDetails);
                        System.out.println(" The Electricity Bill payment of RS " + totalAmount + " payed successfully *");
                        System.out.println("Your Transaction Id - " + uuid + " Transaction time - " + now + " Transaction Status - success");
                        userDetailsDao.save(userDetails);


                    }
                case 'N':
                case 'n':
                    System.out.println("Thank You *");
                    break;
                default:
                    System.out.println("Invalid Entry...");
                    break;
            }

        } else {
            System.out.println("Invalid entry ...");
        }

    }


}
