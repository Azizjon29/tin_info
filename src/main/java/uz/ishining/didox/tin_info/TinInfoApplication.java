package uz.ishining.didox.tin_info;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import uz.ishining.didox.tin_info.service.TaxService;

@SpringBootApplication
public class TinInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TinInfoApplication.class, args);
    }

    @Value("${tax.url}")
    private String taxUrl;

    @Bean
    public TaxService taxService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(taxUrl)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        return retrofit.create(TaxService.class);
    }

}
