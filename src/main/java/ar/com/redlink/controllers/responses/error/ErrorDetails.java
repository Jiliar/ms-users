package ar.com.redlink.controllers.responses.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {
    private String error_code;
    private String error_message;
    private String error_detail;
    private ErrorMetaData meta_data;
}
