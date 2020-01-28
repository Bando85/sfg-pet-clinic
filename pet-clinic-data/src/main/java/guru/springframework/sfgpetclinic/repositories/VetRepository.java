package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Andras Laczo 2020. 01. 28.
 */

public interface VetRepository extends CrudRepository<Vet, Long> {
}
