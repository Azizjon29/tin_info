package uz.ishining.didox.tin_info.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("INDIVIDUAL")
@Data
@EqualsAndHashCode(callSuper = false)
public class IndividualPersonRu extends PersonRu{

    private String fullName;

    private String passSeries;

    private String passNumber;

    private String passOrg;

    private Date passIssueDate;

    private Boolean isItd;
}
