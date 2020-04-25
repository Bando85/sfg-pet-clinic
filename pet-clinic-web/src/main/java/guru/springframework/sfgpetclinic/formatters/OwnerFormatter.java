package guru.springframework.sfgpetclinic.formatters;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created by Andras Laczo 2020. 04. 25.
 */


//its not useful, deprecated

public class OwnerFormatter implements Formatter<Owner> {

    private OwnerService ownerService;

    public OwnerFormatter(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @Override
    public Owner parse(String s, Locale locale) throws ParseException {
        try{
            Long id = Long.parseLong(s);
            return ownerService.findById(id);
        } catch (NumberFormatException n) {
            throw new ParseException("not a valid id",0);
        }
    }

    @Override
    public String print(Owner owner, Locale locale) {
        return (owner.getFirstName() + " " + owner.getLastName());
    }
}
