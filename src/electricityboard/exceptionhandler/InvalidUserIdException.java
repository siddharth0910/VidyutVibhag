package electricityboard.exceptionhandler;

public class InvalidUserIdException extends RuntimeException {

    public InvalidUserIdException() {
        System.out.println();
    }
    public InvalidUserIdException(String message){
        super(message);
    }
    }
