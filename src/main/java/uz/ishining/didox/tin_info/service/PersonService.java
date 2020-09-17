package uz.ishining.didox.tin_info.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import uz.ishining.didox.tin_info.dto.response.IndividualPersonResponse;
import uz.ishining.didox.tin_info.dto.response.LegalPersonResponse;
import uz.ishining.didox.tin_info.dto.response.NdsInfoResponse;
import uz.ishining.didox.tin_info.enums.Lang;
import uz.ishining.didox.tin_info.model.LegalPersonUz;
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

    public PersonService(TaxService taxService,
                         LegalPersonRuRepository legalPersonRuRepository, LegalPersonUzRepository legalPersonUzRepository,
                         IndividualPersonRuRepository individualPersonRuRepository, IndividualPersonUzRepository individualPersonUzRepository,
                         PersonRuRepository personRuRepository, PersonUzRepository personUzRepository) {
        this.taxService = taxService;
        this.legalPersonRuRepository = legalPersonRuRepository;
        this.legalPersonUzRepository = legalPersonUzRepository;
        this.individualPersonRuRepository = individualPersonRuRepository;
        this.individualPersonUzRepository = individualPersonUzRepository;
        this.personRuRepository = personRuRepository;
        this.personUzRepository = personUzRepository;
    }

    public Serializable getInfo(String tin, Lang lang) throws IOException {

        switch (lang) {
            case UZ -> {
                Call<LegalPersonResponse> legalRequest = taxService.getLegalPersonByTin(lang.toValue(), tin);
                Call<IndividualPersonResponse> individualRequest = taxService.getIndividualPersonByTin(lang.toValue(), tin);
                Call<NdsInfoResponse> ndsRequest = taxService.getNdsInfoByTin(tin);
                return legalRequest.execute().body();
            }
            default -> {
                Call<LegalPersonResponse> legalRequest = taxService.getLegalPersonByTin(lang.toValue(), tin);
                Call<IndividualPersonResponse> individualRequest = taxService.getIndividualPersonByTin(lang.toValue(), tin);
                Call<NdsInfoResponse> ndsRequest = taxService.getNdsInfoByTin(tin);
                return legalRequest.execute().body();
            }
        }
    }
}
