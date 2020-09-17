package uz.ishining.didox.tin_info.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class LegalPersonResponse implements Serializable {

    private Integer ns10Code;

    private Integer ns11Code;

    private String shortName;

    private String tin;

    private String name;

    private String statusCode;

    private String statusName;

    private String mfo;

    private String account;

    private String address;

    private String oked;

    private String directorTin;

    private String director;

    private String accountant;

    private Short isBudget;
}
