package uz.ishining.didox.tin_info.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import uz.ishining.didox.tin_info.dto.response.IndividualPersonResponse;
import uz.ishining.didox.tin_info.dto.response.LegalPersonResponse;
import uz.ishining.didox.tin_info.dto.response.NdsInfoResponse;
import uz.ishining.didox.tin_info.repository.IndividualPersonRepository;
import uz.ishining.didox.tin_info.repository.LegalPersonRepository;
import uz.ishining.didox.tin_info.repository.PersonRepository;

import java.io.IOException;
import java.io.Serializable;

@Service
public class PersonService {

    private TaxService taxService;

    private LegalPersonRepository legalPersonRepository;

    private IndividualPersonRepository individualPersonRepository;

    private PersonRepository personRepository;

    @Autowired
    public PersonService(TaxService taxService, LegalPersonRepository legalPersonRepository, IndividualPersonRepository individualPersonRepository, PersonRepository personRepository) {
        this.taxService = taxService;
        this.legalPersonRepository = legalPersonRepository;
        this.individualPersonRepository = individualPersonRepository;
        this.personRepository = personRepository;
    }

    public Serializable getInfo(String tin, String lang) throws IOException {
        Call<LegalPersonResponse> legalRequest = taxService.getLegalPersonByTin(lang,tin);
        Call<IndividualPersonResponse> individualRequest = taxService.getIndividualPersonByTin(lang,tin);
        Call<NdsInfoResponse> ndsRequest = taxService.getNdsInfoByTin(tin);
        return legalRequest.execute().body();
    }
}
