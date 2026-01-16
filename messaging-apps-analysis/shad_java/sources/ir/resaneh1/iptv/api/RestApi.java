package ir.resaneh1.iptv.api;

import ir.resaneh1.iptv.model.StatusOutput;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Url;

/* loaded from: classes3.dex */
public interface RestApi {
    @GET
    Call<StatusOutput> callUrl(@Url String str, @Header("User-Agent") String str2);
}
