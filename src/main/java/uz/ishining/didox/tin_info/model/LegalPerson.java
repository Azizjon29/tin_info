package uz.ishining.didox.tin_info.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("LEGAL")
@Data
@EqualsAndHashCode(callSuper = false)
public class LegalPerson extends Person {

    private String shortName;

    private String name;

    private String mfo;

    private String account;

    private String oked;

    private String directorTin;

    private String director;

    private String accountant;
}
