package khirtech.coronadz.demo.utils;

import java.util.List;
import java.util.Optional;

public interface ServiceMethods<T> {

    public Optional<T> findOne(String id);

    public List<T> findAll();

    public Optional<T> save(T  model);

    public Optional<T> update();
}
