package khirtech.coronadz.demo.infection;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InfectionRepository extends MongoRepository<Infection,String> {
    List<Infection> findAll();
    List<Infection> findAllByWilayaID();
    List<Infection> findAllByCommuneID();
    Optional<Infection> findByWilayaID(int s);
    Optional<Infection> findByCommuneID(int s);
}
