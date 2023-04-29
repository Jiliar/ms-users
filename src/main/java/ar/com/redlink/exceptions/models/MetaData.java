package ar.com.redlink.exceptions.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MetaData {
    private String reason;
    private String field;
    private String rejectedValue;
}
