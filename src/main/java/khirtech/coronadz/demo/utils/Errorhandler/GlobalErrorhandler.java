package khirtech.coronadz.demo.utils.Errorhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalErrorhandler {


    // TODO: 3/17/20 cach all the Error here and invoke Handlers





    /**
     * Generic method to return a custom Error Response
     * @param status
     * @param e
     * @return
     */
    private ResponseEntity<ErrorBuilder> error(HttpStatus status, Exception e) {
        ErrorBuilder response = ErrorBuilder.builder()
                .error(e.getMessage())
                .status(status.value())
                .build();
        return ResponseEntity.status(status).body(response);
    }


}


