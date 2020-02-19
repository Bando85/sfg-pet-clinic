package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME = "Smith";
    public static final String LAST_NAME2 = "Carpenter";
    Owner owner1;
    Owner owner2;

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService service;

    @BeforeEach
    void setUp() {
        owner1 = Owner.builder().lastName(LAST_NAME).build();
        owner2 = Owner.builder().lastName(LAST_NAME2).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(owner1);
        Owner smith = service.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME, smith.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> returnSet = new HashSet<>();
        returnSet.add(owner1);
        returnSet.add(owner2);
        when(ownerRepository.findAll()).thenReturn(returnSet);
        Set<Owner> ownerSet = service.findAll();
        assertEquals(ownerSet, returnSet);
        assertEquals(ownerSet.size(), 2);
        verify(ownerRepository).findAll();
    }

    @Test
    void findById() {
        when(ownerRepository.findById(owner1.getId())).thenReturn(Optional.of(owner1));
        Owner foundOwner = service.findById(owner1.getId());
        assertEquals(foundOwner, owner1);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner foundOwner = service.findById(3L);
        assertNull(foundOwner);
    }

    @Test
    void save() {
        when(ownerRepository.save(any(Owner.class))).thenReturn(owner1);
        Owner savedOwner = service.save(owner1);
        assertEquals(owner1, savedOwner);
        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        service.delete(owner1);
        verify(ownerRepository).delete(any(Owner.class));

    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(ownerRepository).deleteById(1L);

    }
}