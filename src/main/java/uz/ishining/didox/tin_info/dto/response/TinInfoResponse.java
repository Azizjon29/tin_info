package uz.ishining.didox.tin_info.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class TinInfoResponse implements Serializable {

    private String dcreated;

    private String dmodified;

    private String ddeleted;

    private String tin;

    private String shortName;

    private String name;

    private String address;

    private String account;

    private String mfo;

    private String oked;

    private String regCode;

    private String director;

    private String directorTin;

    private String accountant;

    private String passport;

    private String passOrg;

    private String passIssueDate;

    private String districtId;

    private Integer ns11Code;

    private String ns10Code;

    private Boolean company;

}
