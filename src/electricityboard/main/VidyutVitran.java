package electricityboard.main;

import electricityboard.dao.UserDetailsDao;

import electricityboard.exceptionhandler.InvalidUserIdException;
import electricityboard.model.UserDetails;
import electricityboard.service.UserInputOutput;

import java.sql.SQLException;
import java.util.Scanner;

public class VidyutVitran {


//Welcoming the user by using println and asking the user for input by using scanner class and storing the user input in uCustomerId

    public static void main(String[] args) throws SQLException {
        UserDetailsDao userDetailsDao = new UserDetailsDao();
        UserDetails user = new UserDetails();
        System.out.println("" + "\n" + "*****************************************************************************************************************************************" + "\n" + "_*_*_*_*_*_*_*_**_*_*_*_*_*_*_*_*_*_*_  WELCOME TO THE VIDYUT VITRAN VIBHAG  *_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_ " + "\n");
        Scanner sc = new Scanner(System.in);
        System.out.println(" Dear User, Kindly enter your Customer Id : ");
        String customerId = sc.next();
        do {


            try {
                if (customerId.length() != 9) {
                    throw new InvalidUserIdException("The customer Id entered by you is of Invalid length, ");
                }
            } catch (InvalidUserIdException invalidEntry) {
                System.out.println(invalidEntry.getMessage());
            }
            try {
                if (userDetailsDao.getById(customerId) == null) {

                    throw new InvalidUserIdException("The entered customer Id does not exist.");
                }

            } catch (InvalidUserIdException inputNotFound) {

                System.out.println("Please Enter a valid  customerId");
                customerId = sc.next();
            }
            if (userDetailsDao.getById(customerId) == null) {
                System.out.println(" ");
            } else {
                user = userDetailsDao.getById(customerId);
                UserInputOutput.UserInput(sc, customerId);

            }


        } while (userDetailsDao.getById(customerId) == null);
    }
}


