package ar.com.redlink.utils;

import ar.com.redlink.controllers.responses.Response;
import ar.com.redlink.controllers.responses.error.ErrorDetails;
import ar.com.redlink.controllers.responses.error.ErrorMetaData;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.*;

public class ErrorHandler {

    public static ResponseEntity<?> validate(BindingResult result, String path) {

        List<ErrorDetails> details = new ArrayList<>();

        result.getFieldErrors().forEach(err->{

            ErrorDetails detail = new ErrorDetails();
            ErrorMetaData metaData = new ErrorMetaData();

            detail.setError_code("XXX");
            detail.setError_message("An error has occurred in the field "+err.getField());
            detail.setError_detail(err.getDefaultMessage());

            metaData.setField(err.getField());
            metaData.setReason("Possible failure to insert the information.");
            metaData.setRejectedValue((String) err.getRejectedValue());
            detail.setMeta_data(metaData);
            details.add(detail);

        });
        Response response = new Response(details, path, TimeUtils.currentTimestamp());
        return ResponseEntity.badRequest().body(response);
    }

}
