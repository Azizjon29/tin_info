package uz.ishining.didox.tin_info.dto.response;

import lombok.Data;

@Data
public class IndividualPersonResponse {

    private Integer ns10Code;

    private Integer ns11Code;

    private String tin;

    private String fullName;

    private String passSeries;

    private String passNumber;

    private String passOrg;

    private String passIssueDate;

    private String address;

    private Boolean isItd;
}
