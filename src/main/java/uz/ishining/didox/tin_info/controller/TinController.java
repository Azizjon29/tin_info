package uz.ishining.didox.tin_info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Call;
import retrofit2.Response;
import uz.ishining.didox.tin_info.dto.response.LegalPersonResponse;
import uz.ishining.didox.tin_info.dto.response.TinInfoResponse;
import uz.ishining.didox.tin_info.service.PersonService;
import uz.ishining.didox.tin_info.service.TaxService;

import java.io.IOException;
import java.io.Serializable;

@RestController
@RequestMapping("/api/v1")
public class TinController {

    private PersonService personService;

    @Autowired
    public TinController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/taxinfo")
    public Serializable getTinInfo(@RequestParam String tin,
                                   @RequestParam(required = false, defaultValue = "ru") String lang) throws IOException {
        return personService.getInfo(tin, lang);
    }
}
