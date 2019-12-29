package practise.myproman.api.service.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

public class AuthenticationFailedException extends Exception {

    public final String code;
    public final String errorMessage;

    public AuthenticationFailedException(final String code, final String errorMessage) {
        this.code = code;
        this.errorMessage = errorMessage;
    }

    @Override
    public void printStackTrace() {
        // TODO Auto-generated method stub
        super.printStackTrace();
    }

    @Override
    public void printStackTrace(PrintWriter s) {
        // TODO Auto-generated method stub
        super.printStackTrace(s);
    }

    @Override
    public void printStackTrace(PrintStream s) {
        // TODO Auto-generated method stub
        super.printStackTrace(s);
    }

    public final String getCode() {
        return this.code;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

}