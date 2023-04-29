package ar.com.redlink.exceptions.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Details {
    private String error_code;
    private String error_message;
    private String error_detail;
    private MetaData meta_data;
}
