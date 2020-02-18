package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    Owner owner1;


    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        owner1 = Owner.builder().lastName("Thompson").build();
        ownerMapService.save(owner1);
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
        assertEquals(owner1.getId(),ownerMapService.findById(owner1.getId()).getId());

    }

    @Test
    void save() {
        Owner owner2 = Owner.builder().firstName("Bela").build();
        Owner savedOwner = ownerMapService.save(owner2);
        assertEquals(owner2.getId(),savedOwner.getId());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {
        ownerMapService.delete(owner1);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(owner1.getId());
        assertNull(ownerMapService.findById(owner1.getId()));
        assertEquals(ownerMapService.findAll().size(), 0);
    }

    @Test
    void findByLastName() {
        assertEquals(owner1.getId(), ownerMapService.findByLastName("Thompson").getId() );
    }

    @Test
    void findByLastNameNull() {
        assertNull(ownerMapService.findByLastName("Thompso"));
    }
}