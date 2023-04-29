package ar.com.redlink.exceptions;

import ar.com.redlink.exceptions.models.Details;
import ar.com.redlink.exceptions.models.MetaData;
import ar.com.redlink.exceptions.models.ApiException;
import ar.com.redlink.utils.TimeUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.*;

public class ErrorValidationHandler {

    public static ResponseEntity<?> validate(BindingResult result) {

        List<Details> details = new ArrayList<>();

        result.getFieldErrors().forEach(err->{

            Details detail = new Details();
            MetaData metaData = new MetaData();

            detail.setError_code("XXX");
            detail.setError_message("An error has occurred in the field "+err.getField());
            detail.setError_detail(err.getDefaultMessage());

            metaData.setField(err.getField());
            metaData.setReason("Possible failure to insert the information.");
            metaData.setRejectedValue((String) err.getRejectedValue());
            detail.setMeta_data(metaData);
            details.add(detail);

        });

        ApiException response = new ApiException(details, null, TimeUtils.currentTimestamp());
        return ResponseEntity.badRequest().body(response);
    }

}
