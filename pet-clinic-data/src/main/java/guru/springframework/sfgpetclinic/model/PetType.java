package guru.springframework.sfgpetclinic.model;

/**
 * Created by Andras Laczo 2019. 12. 05.
 */

public class PetType extends BaseEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
