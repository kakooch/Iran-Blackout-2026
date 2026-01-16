package androidMessenger.network;

import io.reactivex.Observable;
import java.util.HashMap;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Url;

/* loaded from: classes.dex */
public interface RestApiMessangerRx {
    @GET
    Observable<Response<ResponseBody>> getExternalFile(@Url String str);

    @POST
    Observable<Response<ResponseBody>> getFile(@Url String str, @HeaderMap HashMap<String, String> map);

    @POST("./")
    Observable<Response<ResponseBody>> send(@Body RequestBody requestBody);

    @POST
    Observable<Response<ResponseBody>> sendFile(@Url String str, @Body RequestBody requestBody, @HeaderMap HashMap<String, String> map);

    @POST
    Observable<Response<ResponseBody>> sendToUrl(@Url String str, @Body RequestBody requestBody);
}
