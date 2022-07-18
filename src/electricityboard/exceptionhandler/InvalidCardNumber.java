package electricityboard.exceptionhandler;

public class InvalidCardNumber extends RuntimeException{
    public InvalidCardNumber() {
        System.out.println();
    }
    public InvalidCardNumber(String message){
        super(message);
    }
}
