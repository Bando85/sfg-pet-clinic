package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Andras Laczo 2020. 01. 28.
 */

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
