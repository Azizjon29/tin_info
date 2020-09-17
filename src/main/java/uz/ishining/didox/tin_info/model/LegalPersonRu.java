package uz.ishining.didox.tin_info.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("LEGAL")
@Data
@EqualsAndHashCode(callSuper = false)
public class LegalPersonRu extends PersonRu {

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

    private String regDate;

    private String type;

    private String dateCreate;

    private String fileGuid;

    private String basisType;

    private String targetPay;

    private String appDueDate;

    private String dateFrom;
}
