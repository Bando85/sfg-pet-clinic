package guru.springframework.sfgpetclinic.model;

import java.io.Serializable;

/**
 * Created by Andras Laczo 2019. 12. 10.
 */

public class BaseEntity implements Serializable {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long id;


}
