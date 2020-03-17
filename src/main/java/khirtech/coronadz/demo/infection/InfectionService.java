package khirtech.coronadz.demo.infection;

import khirtech.coronadz.demo.utils.ServiceMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Infection result = this.infectionRepository.save(model);
        return Optional.of(result);
    }

    @Override
    public Optional<Infection> update(Infection model) {
        Infection result = this.infectionRepository.save(model);
        return Optional.of(result);
    }
}
