package khirtech.coronadz.demo.infection;

import khirtech.coronadz.demo.utils.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class InfectionController {

    @Autowired
    private InfectionService infectionService;

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
       /* infection.setLocation(new GeoJsonPoint(infection.getLng(), infection.getLat()));
        List<Infection> infectionList = this.infectionRepository.findAll();
        infection.setState(1);
        infection.setCreationDate(LocalDateTime.now(ZoneId.of("UTC+01:00")));
        this.infectionRepository.save(infection);
        return new JSONObject().put("code", 201).put("content", "").toString();*/

       Optional<Infection> result  = this.infectionService.save(infection);
        ResponseBuilder builder = ResponseBuilder.builder()
                .response(result)
                .status(HttpStatus.OK.value())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(builder);
    }


    @GetMapping("/infection/")
    public void findOneByID(@RequestParam("id") String id) {

    }

    @GetMapping("/infection/")
    public void findByWilya(@RequestParam("wilaya") int willayaID) {

    }

    @GetMapping("/infection/")
    public void findByCommon(@RequestParam("common") int commonID) {

    }

    @PutMapping("/infection")
    public void updateOne(@RequestBody Infection infection){

    }

}
