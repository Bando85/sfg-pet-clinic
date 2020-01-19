package guru.springframework.sfgpetclinic.model;

import java.util.Set;

/**
 * Created by Andras Laczo 2019. 12. 05.
 */

public class Owner extends Person {

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    private Set<Pet> pets;

}
