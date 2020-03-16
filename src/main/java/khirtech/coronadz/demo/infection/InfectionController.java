package khirtech.coronadz.demo.infection;

import khirtech.coronadz.demo.entities.Infection;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@RestController
public class InfectionController {
    private InfectionRepository infectionRepository;

    public InfectionController(InfectionRepository infectionRepository) {
        this.infectionRepository = infectionRepository;
    }

    @GetMapping("/api/infections")
    public String getAll() {
        List<Infection> infectionList = this.infectionRepository.findAll();

        return new JSONObject().put("code", 201).put("content", infectionList).toString();
    }

    @PostMapping("/api/infections")
    public String addOne(@RequestBody Infection infection) {

        infection.setLocation(new GeoJsonPoint(infection.getLng(), infection.getLat()));


        List<Infection> infectionList = this.infectionRepository.findAll();

        infection.setState(1);
        infection.setCreationDate(LocalDateTime.now(ZoneId.of("UTC+01:00")));

        this.infectionRepository.save(infection);

        return new JSONObject().put("code", 201).put("content", "").toString();
    }

}
