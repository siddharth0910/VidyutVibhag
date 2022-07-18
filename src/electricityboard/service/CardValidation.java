package electricityboard.service;

import electricityboard.dao.AccountDetailsDao;
import electricityboard.exceptionhandler.InvalidCardNumber;
import electricityboard.model.AccountDetails;

import java.sql.SQLException;
import java.util.Scanner;

public class CardValidation {
    public static String cardValidation() throws SQLException {
        //why did I have to initialize cvv like this and other variables just normal
        String cvv;
        String pin;
        String cardNumber;
        AccountDetailsDao accountDetailsDao = new AccountDetailsDao();

        System.out.println("Kindly enter your Card Number : ");
        Scanner sc = new Scanner(System.in);
        cardNumber = Long.toString(sc.nextLong());
        do {
            if (cardNumber.length() != 16) {
                try {
                    throw new InvalidCardNumber("The entered card number is of invalid length");
                } catch (InvalidCardNumber invalidCardNumber) {
                    System.out.println("The entered card is of invalid length, Kindly enter a 16 digit card Number :");
                    cardNumber = Long.toString(sc.nextLong());
                }
            }
            if (accountDetailsDao.getByCardNumber((Long.parseLong(cardNumber))) == null) {
                try {
                    throw new InvalidCardNumber("The entered card number does not exist");
                } catch (InvalidCardNumber invalidCardNumber) {
                    System.out.println("The entered Card number does not exist, Kindly enter a valid card number :");
                    cardNumber = Long.toString(sc.nextLong());
                }
            }
        } while (accountDetailsDao.getByCardNumber(Long.parseLong(cardNumber)) == null);
AccountDetails accountDetails = accountDetailsDao.getByCardNumber(Long.parseLong(cardNumber));
        System.out.println("Kindly enter the cvv number associated with the entered  card: ");
        cvv = Long.toString(sc.nextInt());

        do {
            if (cvv.length() != 3) {

                System.out.println("The entered Cvv is of invalid length, Kindly enter cvv number of valid length :");
                cvv = Long.toString(sc.nextInt());
            }
            if (!cvv.equals(Long.toString(accountDetails.getcvv()))) {
                System.out.println("Incorrect cvv, Please re-entered cvv number");
                cvv = Long.toString(sc.nextInt());
            }
        } while (cvv.length() != 3|| !cvv.equals(Long.toString(accountDetails.getcvv())));


        System.out.println("Kindly enter the pin associated with the entered card number:  ");
        pin = Long.toString(sc.nextInt());
        do {
            if (pin.length() != 4) {
                System.out.println("The entered pin is of invalid length, Kindly enter a 4 digit pin:");
                pin = Long.toString(sc.nextInt());
            }
            if (!pin.equals(Long.toString(accountDetails.getpin()))) {
                System.out.println("Incorrect pin, Kindly enter the correct pin:");
                pin = Long.toString(sc.nextInt());
            }
        } while (pin.length() != 4 ||!pin.equals(Long.toString(accountDetails.getpin())));
        return cardNumber;
    }
}


