package khirtech.coronadz.demo.repositories;

import khirtech.coronadz.demo.entities.Infection;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface InfectionRepository extends MongoRepository<Infection,String> {
    List<Infection> findAll();
    List<Infection> findAllByWilayaID();
    List<Infection> findAllByCommuneID();
}
