package ir.resaneh1.iptv.api;

import androidMessenger.utilites.AppFavorUtils;
import com.facebook.stetho.common.Utf8Charset;
import com.facebook.stetho.server.http.HttpHeaders;
import ir.resaneh1.iptv.apiIPTV.CallbackWithRetry;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.StatusOutput;
import java.io.IOException;
import java.nio.charset.Charset;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* loaded from: classes3.dex */
public class ApiRequest {
    static ApiRequest instance;
    private static RestApi restApiService;

    static {
        Charset.forName(Utf8Charset.NAME);
    }

    public ApiRequest() {
        setRestApiService();
    }

    public RestApi getRestApiService() {
        return restApiService;
    }

    public void setRestApiService() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        if (MyLog.isDebugAble) {
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        restApiService = (RestApi) new Retrofit.Builder().baseUrl(AppFavorUtils.baseUrlOld).addConverterFactory(GsonConverterFactory.create()).client(new OkHttpClient.Builder().addInterceptor(new Interceptor(this) { // from class: ir.resaneh1.iptv.api.ApiRequest.1
            @Override // okhttp3.Interceptor
            public Response intercept(Interceptor.Chain chain) throws IOException {
                return chain.proceed(chain.request().newBuilder().addHeader(HttpHeaders.CONTENT_TYPE, "application/json").build());
            }
        }).addInterceptor(httpLoggingInterceptor).build()).build().create(RestApi.class);
    }

    public static ApiRequest getInstance() {
        if (instance == null) {
            instance = new ApiRequest();
        }
        return instance;
    }

    public Call<StatusOutput> callUrl(String str) {
        String property = System.getProperty("http.agent");
        if (property == null || property.isEmpty()) {
            property = "Mozilla/5.0";
        }
        Call<StatusOutput> callCallUrl = getRestApiService().callUrl(str, property);
        callCallUrl.enqueue(new CallbackWithRetry<StatusOutput>(this, callCallUrl) { // from class: ir.resaneh1.iptv.api.ApiRequest.2
            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<StatusOutput> call, Throwable th) {
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<StatusOutput> call, retrofit2.Response<StatusOutput> response) {
            }
        });
        return callCallUrl;
    }
}
