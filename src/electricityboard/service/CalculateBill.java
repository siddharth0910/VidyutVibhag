package electricityboard.service;

/**
 * Creating a class named as CalculateBill and created a static variable
 * Created a method calculate and initialised local variables state and units
 */
public class CalculateBill {
    static double bill;


    public static double calculate(int units, String state) {


        //Passed Switch statement with state as an Expression
        // passed 5 cases inside the switch
        // and it passed conditions for billing as per the units consumed

        switch (state) {
            case "Uttar Pradesh":
                if (units < 100) {
                    bill = 5 * units;
                } else if (units <= 200) {
                    bill = (100 * 5) + (units - 100) * 6;
                } else if (units <= 300) {
                    bill = (100 * 5) + (100 * 6) + (units - 200) * 7;

                } else if (units > 300) {
                    bill = (100 * 5) + (100 * 6) + (100 * 7) + (units - 300) * 8;
                }
                break;

            case "Chhattisgarh":
                if (units <= 100) {
                    bill = 6 * 100;
                } else if (units <= 200) {
                    bill = (100 * 6) + (units - 100) * 7;
                } else if (units <= 300) {
                    bill = (100 * 6) + (100 * 7) + (units - 200) * 8;

                } else if (units > 300) {
                    bill = (100 * 6) + (100 * 7) + (100 * 8) + (units - 300) * 9;
                }
                break;

            case "Madhya Pradesh":
                if (units <= 100) {
                    bill = 3 * 100;
                } else if (units <= 200) {
                    bill = (100 * 3) + (units - 100) * 4;
                } else if (units <= 300) {
                    bill = (100 * 3) + (100 * 4) + (units - 200) * 5;

                } else if (units > 300) {
                    bill = (100 * 3) + (100 * 4) + (100 * 5) + (units - 300) * 6;
                }
                break;

            case "Punjab":
                if (units <= 100) {
                    bill = 4 * 100;
                } else if (units <= 200) {
                    bill = (100 * 4) + (units - 100) * 5;
                } else if (units <= 300) {
                    bill = (100 * 4) + (100 * 5) + (units - 200) * 6;

                } else if (units > 300) {
                    bill = (100 * 4) + (100 * 5) + (100 * 6) + (units - 300) * 7;
                }
                break;

            case "Maharashtra":
                if (units <= 100) {
                    bill = 7 * 100;
                } else if (units <= 200) {
                    bill = (100 * 7) + (units - 100) * 8;
                } else if (units <= 300) {
                    bill = (100 * 7) + (100 * 8) + (units - 200) * 9;

                } else if (units > 300) {
                    bill = (100 * 7) + (100 * 8) + (100 * 9) + (units - 300) * 10;
                }
        }
        return bill;
    }
}