package ar.com.redlink.controllers.responses.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMetaData {
    private String reason;
    private String field;
    private String rejectedValue;
}
