package ma.youcode.rentalhive.web.restControllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Validated
public class ControllerHandlerException {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleException(Exception ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<StringBuilder> handleExceptionArgument(MethodArgumentNotValidException ex){
        StringBuilder errorMsg=new StringBuilder("error validation(s): ");
        BindingResult result = ex.getBindingResult();
        result.getFieldErrors().forEach( fieldError -> {
            errorMsg.append(fieldError.getField())
                    .append(" ").append(fieldError.getDefaultMessage())
                    .append(";");
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMsg);
    }
}
