public class Failed extends RuntimeException{

    public Failed(String message){
        super(message);
        super.setStackTrace(new StackTraceElement[0]);
    }// End Failed()
}// End Failed