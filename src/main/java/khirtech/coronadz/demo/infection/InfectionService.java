package khirtech.coronadz.demo.infection;

import khirtech.coronadz.demo.utils.ServiceMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class InfectionService implements ServiceMethods<Infection> {

    private final InfectionRepository infectionRepository;

    @Autowired
    public InfectionService(InfectionRepository infectionRepository) {
        this.infectionRepository = infectionRepository;
    }

    @Override
    public Optional<Infection> findOne(String id) {
        return this.infectionRepository.findById(id);
    }

    @Override
    public List<Infection> findAll() {
        return this.infectionRepository.findAll();
    }

    @Override
    public Optional<Infection> save(Infection model) {
        Instant instant = Instant.now();
        long timeStampMillis = instant.toEpochMilli();
        System.out.println(timeStampMillis);

        Infection infection = Infection.builder()
                .communeID(model.getCommuneID())
                .creationDate(timeStampMillis)
                .latitude(model.getLatitude())
                .longitude(model.getLongitude())
                .ownerId(model.getOwnerId())
                .state(model.getState())
                .wilayaID(model.getWilayaID())
                .build();
        Infection result = this.infectionRepository.save(infection);
        return Optional.of(result);
    }

    @Override
    public Optional<Infection> update(Infection model) {
        Infection result = this.infectionRepository.save(model);
        return Optional.of(result);
    }

    public Optional<Infection> findByIDWilaya(String param) {
        return this.infectionRepository.findByWilayaID(Integer.parseInt(param));
    }

    public Optional<Infection> findByIDCommon(String param) {
        return this.infectionRepository.findByCommuneID(Integer.parseInt(param));
    }
}
