package ar.com.redlink.exceptions;

import ar.com.redlink.exceptions.models.Details;
import ar.com.redlink.exceptions.models.ErrorCodes;
import ar.com.redlink.exceptions.models.MetaData;

import java.util.ArrayList;
import java.util.List;

public class RestException extends Exception{

    private List<Details> details;

    public RestException(String message) {
        super(message);
    }

    public List<Details> addDetail(String error_code, String error_message, String error_detail, MetaData meta_data){
        if(!error_message.isEmpty() || !error_code.isEmpty()){
            details = new ArrayList<>();
            details.add(new Details(error_code, error_message, error_detail, meta_data));
        }
        return details;
    }

    public List<Details> addDetail(ErrorCodes error, String error_detail, MetaData meta_data){
        if(error != null){
            details = new ArrayList<>();
            details.add(new Details(error.getCode(), error.getMessage(), error_detail, meta_data));
        }
        return details;
    }

}
