package uz.ishining.didox.tin_info.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import uz.ishining.didox.tin_info.dto.response.IndividualPersonResponse;
import uz.ishining.didox.tin_info.dto.response.LegalPersonResponse;
import uz.ishining.didox.tin_info.model.IndividualPersonRu;
import uz.ishining.didox.tin_info.model.LegalPersonRu;

import java.text.SimpleDateFormat;

@Mapper(componentModel = "spring")
public abstract class ModelDtoMapperRu {


    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    private static final SimpleDateFormat sdfWithTime = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    @Mappings({
            @Mapping(source = "dto.tin",target = "tin"),
            @Mapping(source = "dto.ns10Code",target = "ns10Code"),
            @Mapping(source = "dto.ns11Code",target = "ns11Code"),
            @Mapping(source = "dto.address",target = "address"),
            @Mapping(source = "dto.shortName",target = "shortName"),
            @Mapping(source = "dto.name",target = "name"),
            @Mapping(source = "dto.statusCode",target = "statusCode"),
            @Mapping(source = "dto.statusName",target = "statusName"),
            @Mapping(source = "dto.mfo",target = "mfo"),
            @Mapping(source = "dto.account",target = "account"),
            @Mapping(source = "dto.oked",target = "oked"),
            @Mapping(source = "dto.directorTin",target = "directorTin"),
            @Mapping(source = "dto.director",target = "director"),
            @Mapping(source = "dto.accountant",target = "accountant"),
            @Mapping(source = "dto.isBudget",target = "isBudget"),
            @Mapping(ignore = true, target = "regCode"),
            @Mapping(ignore = true, target = "regDate"),
            @Mapping(ignore = true, target = "type"),
            @Mapping(ignore = true, target = "dateCreate"),
            @Mapping(ignore = true, target = "fileGuid"),
            @Mapping(ignore = true, target = "basisType"),
            @Mapping(ignore = true, target = "targetPay"),
            @Mapping(ignore = true, target = "appDueDate"),
            @Mapping(ignore = true, target = "id"),
            @Mapping(ignore = true, target = "dcreated"),
            @Mapping(ignore = true, target = "dmodified"),
            @Mapping(ignore = true, target = "ddeleted")
    })
    public abstract LegalPersonRu legalDtoToModel(LegalPersonResponse dto);

    @Mappings({
            @Mapping(source = "dto.tin",target = "tin"),
            @Mapping(source = "dto.name",target = "name"),
            @Mapping(source = "dto.address",target = "address"),
            @Mapping(source = "dto.regCode",target = "regCode"),
            @Mapping(source = "dto.regDate",target = "regDate"),
            @Mapping(source = "dto.dateFrom",target = "dateFrom"),
            @Mapping(source = "dto.type",target = "type"),
            @Mapping(source = "dto.dateCreate",target = "dateCreate"),
            @Mapping(source = "dto.fileGuid",target = "fileGuid"),
            @Mapping(source = "dto.basisType",target = "basisType"),
            @Mapping(source = "dto.targetPay",target = "targetPay"),
            @Mapping(source = "dto.appDueDate",target = "appDueDate"),
            @Mapping(ignore = true, target = "ns10Code"),
            @Mapping(ignore = true, target = "ns11Code"),
            @Mapping(ignore = true, target = "shortName"),
            @Mapping(ignore = true, target = "statusCode"),
            @Mapping(ignore = true, target = "statusName"),
            @Mapping(ignore = true, target = "mfo"),
            @Mapping(ignore = true, target = "account"),
            @Mapping(ignore = true, target = "oked"),
            @Mapping(ignore = true, target = "directorTin"),
            @Mapping(ignore = true, target = "director"),
            @Mapping(ignore = true, target = "accountant"),
            @Mapping(ignore = true, target = "isBudget"),
            @Mapping(ignore = true, target = "id"),
            @Mapping(ignore = true, target = "dcreated"),
            @Mapping(ignore = true, target = "dmodified"),
            @Mapping(ignore = true, target = "ddeleted")
    })
    public abstract LegalPersonRu ndsDtoToModel(LegalPersonResponse dto);

    @Mappings({
            @Mapping(source = "dto.tin",target = "tin"),
            @Mapping(source = "dto.ns10Code",target = "ns10Code"),
            @Mapping(source = "dto.ns11Code",target = "ns11Code"),
            @Mapping(source = "dto.address",target = "address"),
            @Mapping(source = "dto.fullName",target = "fullName"),
            @Mapping(source = "dto.passSeries",target = "passSeries"),
            @Mapping(source = "dto.passNumber",target = "passNumber"),
            @Mapping(source = "dto.statusName",target = "statusName"),
            @Mapping(source = "dto.passOrg",target = "passOrg"),
            @Mapping(source = "dto.passIssueDate",target = "passIssueDate"),
            @Mapping(source = "dto.isItd",target = "isItd"),
            @Mapping(ignore = true, target = "id"),
            @Mapping(ignore = true, target = "dcreated"),
            @Mapping(ignore = true, target = "dmodified"),
            @Mapping(ignore = true, target = "ddeleted")
    })
    public abstract IndividualPersonRu individualPersonDtoToModel(IndividualPersonResponse dto);



}
