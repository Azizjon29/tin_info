package uz.ishining.didox.tin_info.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
import java.util.StringJoiner;

@Entity
@DiscriminatorValue("INDIVIDUAL")
@Data
@EqualsAndHashCode(callSuper = false)
public class IndividualPersonUz extends PersonUz{

    private String fullName;

    private String passSeries;

    private String passNumber;

    private String passOrg;

    private Date passIssueDate;

    private Boolean isItd;

    public String getPassport(){
        StringJoiner joiner = new StringJoiner("");
        joiner.add(passSeries);
        joiner.add(passNumber);
        return joiner.toString();
    }
}
