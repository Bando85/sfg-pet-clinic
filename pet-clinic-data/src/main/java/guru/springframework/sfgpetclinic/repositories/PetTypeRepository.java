package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Andras Laczo 2020. 01. 28.
 */

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
