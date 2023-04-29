package ar.com.redlink.exceptions;

import ar.com.redlink.exceptions.models.Details;
import ar.com.redlink.exceptions.models.MetaData;
import ar.com.redlink.exceptions.models.ApiException;
import ar.com.redlink.utils.TimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> springHandleNotFound(Exception ex, WebRequest request)
            throws IOException {
        ApiException apiException = new ApiException();
        apiException.setTimestamp(TimeUtils.currentTimestamp());
        List<Details> details = new ArrayList<>();
        Details detail = new Details();
        detail.setError_code(HttpStatus.NOT_FOUND.toString());
        detail.setError_message(ex.getMessage());
        detail.setError_detail(ex.getLocalizedMessage());
        MetaData metadata = new MetaData();
        metadata.setField(null);
        metadata.setReason(null);
        metadata.setRejectedValue(null);
        detail.setMeta_data(metadata);
        details.add(detail);
        apiException.setDetails(details);
        apiException.setPath(((ServletWebRequest)request).getRequest().getRequestURI().toString());
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }

}
