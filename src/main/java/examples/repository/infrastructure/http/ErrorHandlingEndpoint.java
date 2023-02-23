package examples.repository.infrastructure.http;

import examples.repository.infrastructure.http.resources.ErrorHandlerResult;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class ErrorHandlingEndpoint extends ResponseEntityExceptionHandler {


    @ExceptionHandler({ValidationException.class})
    @ResponseStatus(value = BAD_REQUEST)
    @ResponseBody
    public ErrorHandlerResult badRequest(final ValidationException exception, HttpServletRequest request) {
        return new ErrorHandlerResult(request.getRequestURI()).addErrors(exception.getMessage(), BAD_REQUEST.value());
    }
}