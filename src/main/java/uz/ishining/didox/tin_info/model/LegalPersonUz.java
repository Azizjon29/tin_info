package uz.ishining.didox.tin_info.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@DiscriminatorValue("LEGAL")
@Data
@EqualsAndHashCode(callSuper = false)
public class LegalPersonUz extends PersonUz {

    private String shortName;

    private String name;

    private String statusCode;

    private String statusName;

    private String mfo;

    private String account;

    private String oked;

    private String directorTin;

    private String director;

    private String accountant;

    private Short isBudget;

    //nds
    private String regCode;

    @Temporal(TemporalType.DATE)
    private Date regDate;

    private String type;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    private String fileGuid;

    private String basisType;

    private String targetPay;

    private String appDueDate;

    @Temporal(TemporalType.DATE)
    private Date dateFrom;
}
