package uz.ishining.didox.tin_info.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import uz.ishining.didox.tin_info.dto.response.IndividualPersonResponse;
import uz.ishining.didox.tin_info.dto.response.LegalPersonResponse;
import uz.ishining.didox.tin_info.dto.response.NdsInfoResponse;

public interface TaxService {

    @GET("/my/services/np1/bytin/factura")
    Call<LegalPersonResponse> getLegalPersonByTin(@Query("lang") String lang, @Query("tin") String tin);

    @GET("/my/services/np1/phisbytin/factura")
    Call<IndividualPersonResponse> getIndividualPersonByTin(@Query("lang") String lang, @Query("tin") String tin);

    @GET("/my/services/nds/reference")
    Call<NdsInfoResponse> getNdsInfoByTin(@Query("tin") String tin);
}
