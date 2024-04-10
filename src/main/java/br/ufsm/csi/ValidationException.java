package br.ufsm.csi;

import java.util.List;

public class ValidationException extends RuntimeException{

    public ValidationException(String message){
        super(message);
    }

    public ValidationException(List<String> messages){
        super(messages.toString());
    }
}
