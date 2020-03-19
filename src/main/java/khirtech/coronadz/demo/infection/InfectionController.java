package khirtech.coronadz.demo.infection;

import khirtech.coronadz.demo.utils.ResponseBuilder;
import khirtech.coronadz.demo.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class InfectionController {

    private final InfectionService infectionService;

    @Autowired
    public InfectionController(InfectionService infectionService) {
        this.infectionService = infectionService;
    }

    @GetMapping("/infection")
    public ResponseEntity getAll() {
        List<Infection> result = this.infectionService.findAll();
        ResponseBuilder builder = ResponseBuilder.builder()
                .response(result)
                .status(HttpStatus.OK.value())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(builder);
    }

    @PostMapping("/infection")
    public ResponseEntity addOne(@RequestBody Infection infection) {
        Optional<Infection> result  = this.infectionService.save(infection);
        ResponseBuilder builder = ResponseBuilder.builder()
                .response(result)
                .status(HttpStatus.OK.value())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(builder);
    }

    @PutMapping("/infection/{id}")
    public ResponseEntity updateOne(@RequestBody Infection infection, @PathVariable String id){
        Optional<Infection> result  = this.infectionService.update(id,infection);
        ResponseBuilder builder = ResponseBuilder.builder()
                .response(result)
                .status(HttpStatus.OK.value())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(builder);
    }

    @GetMapping("/infection/find")
    public ResponseEntity findOneByID(@RequestParam("query") String query, @RequestParam("param") String param) {

        if (query.equals(Utils.ID_INFECTION)) {
            Optional<Infection> result = this.infectionService.findOne(param);
            ResponseBuilder builder = ResponseBuilder.builder().response(result.get()).status(HttpStatus.OK.value()).build();
            return ResponseEntity.status(HttpStatus.OK).body(builder);
        }

        if (query.equals(Utils.ID_WILAYA)) {
            List<Infection> result = this.infectionService.findByIDWilaya(param);
            ResponseBuilder builder = ResponseBuilder.builder().response(result).status(HttpStatus.OK.value()).build();
            return ResponseEntity.status(HttpStatus.OK).body(builder);
        }

        if (query.equals(Utils.ID_COMMOM)) {
            List<Infection> result = this.infectionService.findByIDCommon(param);
            ResponseBuilder builder = ResponseBuilder.builder().response(result).status(HttpStatus.OK.value()).build();
            return ResponseEntity.status(HttpStatus.OK).body(builder);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseBuilder.builder().status(HttpStatus.BAD_REQUEST.value()));
    }

}
