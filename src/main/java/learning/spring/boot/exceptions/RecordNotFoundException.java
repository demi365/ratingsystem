package learning.spring.boot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException {
    
    public RecordNotFoundException() {
        super("Not able to fetch the record, please revalidate the input query");
    }
    
    public RecordNotFoundException(String exception) {
        super(exception);
    }

}