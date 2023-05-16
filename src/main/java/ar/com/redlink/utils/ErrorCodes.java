package ar.com.redlink.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
public enum ErrorCodes {

    NOT_EMPTY_VALIDATION("01.01.01","A problem has occurred in the field, the data cannot be empty."),
    NOT_NULL_VALIDATION("01.01.02","A problem has occurred in the field, the data cannot be null."),
    SIZE_VALIDATION("01.01.03","A problem has occurred in the field, the size is not allowed"),
    USER_NOT_FOUND("01.01.04","User doesn't found"),
    USER_EXISTS("01.01.05","The user has been created before"),
    GENDER_NOT_FOUND("01.01.06","Gender doesn't found"),
    USER_TYPE_ID_NOT_FOUND("01.01.07","User type id doesn't found");

    public final String code;
    public final String message;

}
