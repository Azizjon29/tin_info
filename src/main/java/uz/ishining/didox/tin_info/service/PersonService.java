package uz.ishining.didox.tin_info.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import retrofit2.Call;
import uz.ishining.didox.tin_info.dto.response.IndividualPersonResponse;
import uz.ishining.didox.tin_info.dto.response.LegalPersonResponse;
import uz.ishining.didox.tin_info.dto.response.NdsInfoResponse;
import uz.ishining.didox.tin_info.enums.Lang;
import uz.ishining.didox.tin_info.mapper.ModelDtoMapperRu;
import uz.ishining.didox.tin_info.model.LegalPersonRu;
import uz.ishining.didox.tin_info.model.LegalPersonUz;
import uz.ishining.didox.tin_info.model.PersonRu;
import uz.ishining.didox.tin_info.model.PersonUz;
import uz.ishining.didox.tin_info.repository.IndividualPersonRuRepository;
import uz.ishining.didox.tin_info.repository.IndividualPersonUzRepository;
import uz.ishining.didox.tin_info.repository.LegalPersonRuRepository;
import uz.ishining.didox.tin_info.repository.LegalPersonUzRepository;
import uz.ishining.didox.tin_info.repository.PersonRuRepository;
import uz.ishining.didox.tin_info.repository.PersonUzRepository;

import java.io.IOException;
import java.io.Serializable;

@Service
public class PersonService {

    private TaxService taxService;

    private LegalPersonRuRepository legalPersonRuRepository;

    private LegalPersonUzRepository legalPersonUzRepository;

    private IndividualPersonRuRepository individualPersonRuRepository;

    private IndividualPersonUzRepository individualPersonUzRepository;

    private PersonRuRepository personRuRepository;

    private PersonUzRepository personUzRepository;

    private ModelDtoMapperRu modelDtoMapperRu;

    public PersonService(TaxService taxService,
                         LegalPersonRuRepository legalPersonRuRepository, LegalPersonUzRepository legalPersonUzRepository,
                         IndividualPersonRuRepository individualPersonRuRepository, IndividualPersonUzRepository individualPersonUzRepository,
                         PersonRuRepository personRuRepository, PersonUzRepository personUzRepository,
                         ModelDtoMapperRu modelDtoMapperRu) {
        this.taxService = taxService;
        this.legalPersonRuRepository = legalPersonRuRepository;
        this.legalPersonUzRepository = legalPersonUzRepository;
        this.individualPersonRuRepository = individualPersonRuRepository;
        this.individualPersonUzRepository = individualPersonUzRepository;
        this.personRuRepository = personRuRepository;
        this.personUzRepository = personUzRepository;
        this.modelDtoMapperRu = modelDtoMapperRu;
    }

    @Transactional
    public Serializable getInfo(String tin, Lang lang) throws IOException {
        if (lang == Lang.UZ) {
           return searchTinRu(tin);
        } else {
            return searchTinRu(tin);
        }
    }

    private Serializable searchTinRu(String tin) throws IOException {

        PersonRu personRu = personRuRepository.findByTin(tin);
        if(personRu==null){
            Call<LegalPersonResponse> legalRequest = taxService.getLegalPersonByTin(Lang.RU.toValue(), tin);
            LegalPersonResponse legalResponse = legalRequest.execute().body();
            if(legalResponse.getTin() != null){
                LegalPersonRu legalPersonRu = modelDtoMapperRu.legalDtoToModel(legalResponse);
                NdsInfoResponse ndsInfo = searchNdsInfo(tin);
                if(ndsInfo!=null){
                    modelDtoMapperRu.updateNdsInfo(legalPersonRu,ndsInfo);
                }
                legalPersonRuRepository.save(legalPersonRu);
                return modelDtoMapperRu.modelToDto(legalPersonRu);
            }
            Call<IndividualPersonResponse> individualRequest = taxService.getIndividualPersonByTin(Lang.RU.toValue(), tin);
            IndividualPersonResponse individualPersonResponse = individualRequest.execute().body();
            if(individualPersonResponse.getTin() != null){
                return null;
            }

        }
        return modelDtoMapperRu.modelToDto((LegalPersonRu)personRu);

    }

    private NdsInfoResponse searchNdsInfo(String tin) throws IOException {
        Call<NdsInfoResponse> ndsRequest = taxService.getNdsInfoByTin(tin);
        NdsInfoResponse result = ndsRequest.execute().body();
        if(result.getSuccess()){
            return result;
        }else {
            return null;
        }
    }
    private Serializable searchTinUz(String tin) throws IOException {
        Call<LegalPersonResponse> legalRequest = taxService.getLegalPersonByTin(Lang.UZ.toValue(), tin);
        Call<IndividualPersonResponse> individualRequest = taxService.getIndividualPersonByTin(Lang.UZ.toValue(), tin);
        Call<NdsInfoResponse> ndsRequest = taxService.getNdsInfoByTin(tin);
        return legalRequest.execute().body();
    }
}
