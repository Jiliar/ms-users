package ar.com.redlink.exceptions.models;

import ar.com.redlink.utils.TimeUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiException {
    List<?> details;
    private String path;
    private String timestamp;

    public ApiException(List<?> details, String path){
        this.details = details;
        this.path = path;
        this.timestamp = TimeUtils.currentTimestamp();
    }

    public ApiException(List<?> details){
        this.details = details;
        this.timestamp = TimeUtils.currentTimestamp();
    }
}
