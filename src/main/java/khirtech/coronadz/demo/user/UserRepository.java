package khirtech.coronadz.demo.user;

import khirtech.coronadz.demo.entities.Infection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<Infection,String> {
}
