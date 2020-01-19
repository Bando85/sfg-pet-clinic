package guru.springframework.sfgpetclinic.model;

/**
 * Created by Andras Laczo 2020. 01. 19.
 */

public class Specialty extends BaseEntity {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
