package uz.ishining.didox.tin_info.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import uz.ishining.didox.tin_info.dto.response.IndividualPersonResponse;
import uz.ishining.didox.tin_info.dto.response.LegalPersonResponse;
import uz.ishining.didox.tin_info.dto.response.NdsInfoResponse;
import uz.ishining.didox.tin_info.dto.response.TinInfoResponse;
import uz.ishining.didox.tin_info.model.IndividualPersonUz;
import uz.ishining.didox.tin_info.model.LegalPersonUz;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Mapper(componentModel = "spring")
public abstract class ModelDtoMapperUz {


    protected static final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    protected static final SimpleDateFormat sdfWithTime = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

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
            @Mapping(ignore = true, target = "ddeleted"),
            @Mapping(ignore = true, target = "dateFrom")
    })
    public abstract LegalPersonUz legalDtoToModel(LegalPersonResponse dto);

    @Mappings({
            @Mapping(source = "dto.data.tin",target = "tin"),
            @Mapping(source = "dto.data.name",target = "name"),
            @Mapping(source = "dto.data.address",target = "address"),
            @Mapping(source = "dto.data.regCode",target = "regCode"),
            @Mapping(source = "dto.data.regDate",target = "regDate"),
            @Mapping(source = "dto.data.dateFrom",target = "dateFrom"),
            @Mapping(source = "dto.data.type",target = "type"),
            @Mapping(source = "dto.data.dateCreate",target = "dateCreate"),
            @Mapping(source = "dto.data.fileGuid",target = "fileGuid"),
            @Mapping(source = "dto.data.basisType",target = "basisType"),
            @Mapping(source = "dto.data.targetPay",target = "targetPay"),
            @Mapping(source = "dto.data.appDueDate",target = "appDueDate"),
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
    public abstract LegalPersonUz ndsDtoToModel(NdsInfoResponse dto);

    @Mappings({
            @Mapping(source = "dto.tin",target = "tin"),
            @Mapping(source = "dto.ns10Code",target = "ns10Code"),
            @Mapping(source = "dto.ns11Code",target = "ns11Code"),
            @Mapping(source = "dto.address",target = "address"),
            @Mapping(source = "dto.fullName",target = "fullName"),
            @Mapping(source = "dto.passSeries",target = "passSeries"),
            @Mapping(source = "dto.passNumber",target = "passNumber"),
            @Mapping(source = "dto.passOrg",target = "passOrg"),
            @Mapping(expression = "java(dto.getPassIssueDate()!=null?sdf.parse(dto.getPassIssueDate()):null)",target = "passIssueDate"),
            @Mapping(source = "dto.isItd",target = "isItd"),
            @Mapping(ignore = true, target = "id"),
            @Mapping(ignore = true, target = "dcreated"),
            @Mapping(ignore = true, target = "dmodified"),
            @Mapping(ignore = true, target = "ddeleted")
    })
    public abstract IndividualPersonUz individualPersonDtoToModel(IndividualPersonResponse dto) throws ParseException;


    @Mappings({
            @Mapping(source = "dto.data.regCode", target = "model.regCode"),
            @Mapping(expression = "java(dto.getData().getRegDate()!=null?sdf.parse(dto.getData().getRegDate()):null)", target = "regDate"),
            @Mapping(expression = "java(dto.getData().getDateFrom()!=null?sdf.parse(dto.getData().getDateFrom()):null)", target = "dateFrom"),
            @Mapping(source = "dto.data.fileGuid", target = "model.fileGuid"),
            @Mapping(source = "dto.data.appDueDate", target = "model.appDueDate"),
            @Mapping(source = "dto.data.basisType", target = "model.basisType"),
            @Mapping(source = "dto.data.targetPay", target = "model.targetPay"),
            @Mapping(source = "dto.data.type", target = "model.type"),
            @Mapping(expression = "java(dto.getData().getDateCreate()!=null?sdfWithTime.parse(dto.getData().getDateCreate()):null)", target = "dateCreate"),
            @Mapping(ignore = true, target = "id"),
            @Mapping(ignore = true, target = "dcreated"),
            @Mapping(ignore = true, target = "dmodified"),
            @Mapping(ignore = true, target = "ddeleted"),
            @Mapping(ignore = true, target = "tin"),
            @Mapping(ignore = true, target = "ns10Code"),
            @Mapping(ignore = true, target = "ns11Code"),
            @Mapping(ignore = true, target = "address"),
            @Mapping(ignore = true, target = "shortName"),
            @Mapping(ignore = true, target = "name"),
            @Mapping(ignore = true, target = "statusCode"),
            @Mapping(ignore = true, target = "statusName"),
            @Mapping(ignore = true, target = "mfo"),
            @Mapping(ignore = true, target = "account"),
            @Mapping(ignore = true, target = "directorTin"),
            @Mapping(ignore = true, target = "director"),
            @Mapping(ignore = true, target = "accountant"),
            @Mapping(ignore = true, target = "isBudget"),
            @Mapping(ignore = true, target = "oked")
    })
    public abstract void updateNdsInfo(@MappingTarget LegalPersonUz model, NdsInfoResponse dto) throws ParseException;

    @Mappings({
            @Mapping(source = "model.tin", target = "tin"),
            @Mapping(source = "model.shortName", target = "shortName"),
            @Mapping(source = "model.name", target = "name"),
            @Mapping(source = "model.address", target = "address"),
            @Mapping(source = "model.account", target = "account"),
            @Mapping(source = "model.mfo", target = "mfo"),
            @Mapping(source = "model.oked", target = "oked"),
            @Mapping(source = "model.director", target = "director"),
            @Mapping(source = "model.directorTin", target = "directorTin"),
            @Mapping(source = "model.accountant", target = "accountant"),
            @Mapping(source = "model.ns10Code", target = "ns10Code"),
            @Mapping(source = "model.ns11Code", target = "ns11Code"),
            @Mapping(expression = "java(true)", target = "company"),
            @Mapping(ignore = true, target = "passport"),
            @Mapping(ignore = true, target = "passOrg"),
            @Mapping(ignore = true, target = "passIssueDate"),
            @Mapping(ignore = true, target = "districtId")
    })
    public abstract TinInfoResponse modelToDto(LegalPersonUz model);
    @Mappings({
            @Mapping(source = "model.tin", target = "tin"),
            @Mapping(source = "model.fullName", target = "shortName"),
            @Mapping(source = "model.fullName", target = "name"),
            @Mapping(source = "model.address", target = "address"),
            @Mapping(source = "model.fullName", target = "director"),
            @Mapping(source = "model.fullName", target = "accountant"),
            @Mapping(source = "model.passport", target = "passport"),
            @Mapping(source = "model.passOrg", target = "passOrg"),
            @Mapping(expression = "java(model.getPassIssueDate()!=null?sdf.format(model.getPassIssueDate()):null)", target = "passIssueDate"),
            @Mapping(source = "model.ns10Code", target = "ns10Code"),
            @Mapping(source = "model.ns11Code", target = "ns11Code"),
            @Mapping(expression = "java(false)", target = "company"),
            @Mapping(ignore = true, target = "account"),
            @Mapping(ignore = true, target = "mfo"),
            @Mapping(ignore = true, target = "oked"),
            @Mapping(ignore = true, target = "regCode"),
            @Mapping(ignore = true, target = "directorTin"),
            @Mapping(ignore = true, target = "districtId")
    })
    public abstract TinInfoResponse modelToDto(IndividualPersonUz model);
}
