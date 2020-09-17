package uz.ishining.didox.tin_info.dto.response;

import lombok.Data;

@Data
public class NdsInfoResponse {

    private Boolean success;

    private String reason;

    private Data data;

    @lombok.Data
    static class Data{

        private String tin;

        private String name;

        private String address;

        private String regCode;

        private String regDate;

        private String dateFrom;

        private String fileGuid;

        private Integer basisType;

        private String targetPay;

        private String appDueDate;
    }
}
