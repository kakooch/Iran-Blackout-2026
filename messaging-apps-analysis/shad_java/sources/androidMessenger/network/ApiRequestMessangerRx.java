package androidMessenger.network;

import androidMessenger.helper.AppPreferences;
import androidMessenger.utilites.MyLog;
import com.facebook.stetho.server.http.HttpHeaders;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import ir.aaap.messengercore.network.Network;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import org.json.JSONObject;
import org.rbmain.messenger.AccountInstance;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.UserConfig;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/* loaded from: classes.dex */
public class ApiRequestMessangerRx {
    static volatile ApiRequestMessangerRx instance;
    static RestApiMessangerRx restApiService;
    public String messengerUrl;
    public Network.NetworkErrorListener urlChangeListener;
    Interceptor interCeptor = new Interceptor() { // from class: androidMessenger.network.ApiRequestMessangerRx$$ExternalSyntheticLambda1
        @Override // okhttp3.Interceptor
        public final Response intercept(Interceptor.Chain chain) {
            return this.f$0.lambda$new$0(chain);
        }
    };
    MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Response lambda$new$0(Interceptor.Chain chain) throws IOException {
        int iCode;
        Request requestBuild = chain.request().newBuilder().addHeader(HttpHeaders.CONTENT_TYPE, "application/json").build();
        MyLog.e("ApiReqCore", "url " + requestBuild.url());
        Response responseProceed = null;
        try {
            responseProceed = chain.proceed(requestBuild);
            e = null;
        } catch (IOException e) {
            e = e;
        }
        if (responseProceed == null || !responseProceed.isSuccessful()) {
            increaseApiServerIfNeeded();
            if (responseProceed != null && e == null && (iCode = responseProceed.code()) >= 500 && iCode < 600) {
                e = new IOException(responseProceed.body() != null ? responseProceed.body().string() : "Null Error Body");
            }
            if (e != null) {
                throw e;
            }
        }
        increaseUsage(requestBuild, responseProceed);
        return responseProceed;
    }

    private static void increaseUsage(Request request, Response response) {
        if (request != null) {
            try {
                if (request.body() != null) {
                    AccountInstance.getInstance(UserConfig.selectedAccount).getStatsController().incrementSentBytesCount(ApplicationLoader.getCurrentNetworkType(), 6, request.body().contentLength());
                }
                if (request.headers().byteCount() > 0) {
                    AccountInstance.getInstance(UserConfig.selectedAccount).getStatsController().incrementSentBytesCount(ApplicationLoader.getCurrentNetworkType(), 6, request.headers().byteCount());
                }
            } catch (Exception unused) {
                return;
            }
        }
        if (response == null || response.body() == null || response.body().contentLength() <= 0) {
            return;
        }
        AccountInstance.getInstance(UserConfig.selectedAccount).getStatsController().incrementReceivedBytesCount(ApplicationLoader.getCurrentNetworkType(), 6, response.body().contentLength());
    }

    private void increaseApiServerIfNeeded() {
        Network.NetworkErrorListener networkErrorListener = this.urlChangeListener;
        if (networkErrorListener != null) {
            networkErrorListener.onNetworkError(true);
        }
    }

    public void setNetworkErrorListener(Network.NetworkErrorListener networkErrorListener) {
        this.urlChangeListener = networkErrorListener;
    }

    public void init(String str) {
        setMessengerUrl(str);
    }

    public void setRestApiService() {
        HttpLoggingMessanger httpLoggingMessanger = new HttpLoggingMessanger();
        if (MyLog.isDebugAble) {
            httpLoggingMessanger.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            httpLoggingMessanger.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        OkHttpClient.Builder builderAddInterceptor = new OkHttpClient.Builder().addInterceptor(this.interCeptor).addInterceptor(httpLoggingMessanger);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        restApiService = (RestApiMessangerRx) new Retrofit.Builder().baseUrl(this.messengerUrl).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).client(builderAddInterceptor.connectTimeout(20L, timeUnit).readTimeout(25L, timeUnit).writeTimeout(25L, timeUnit).build()).build().create(RestApiMessangerRx.class);
    }

    public static ApiRequestMessangerRx getInstance() {
        ApiRequestMessangerRx apiRequestMessangerRx = instance;
        if (apiRequestMessangerRx == null) {
            synchronized (AppPreferences.class) {
                apiRequestMessangerRx = instance;
                if (apiRequestMessangerRx == null) {
                    apiRequestMessangerRx = new ApiRequestMessangerRx();
                    instance = apiRequestMessangerRx;
                }
            }
        }
        return apiRequestMessangerRx;
    }

    public Observable<retrofit2.Response<ResponseBody>> send(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        final RequestBody requestBodyCreate = RequestBody.create(this.JSON, jSONObject.toString());
        return Observable.just(0).flatMap(new Function() { // from class: androidMessenger.network.ApiRequestMessangerRx$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ApiRequestMessangerRx.lambda$send$1(requestBodyCreate, (Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ObservableSource lambda$send$1(RequestBody requestBody, Integer num) throws Exception {
        boolean z = MyLog.isDebugAble;
        return restApiService.send(requestBody);
    }

    public Observable<retrofit2.Response<ResponseBody>> sendToUrl(String str, JSONObject jSONObject) {
        return restApiService.sendToUrl(str, RequestBody.create(this.JSON, jSONObject.toString()));
    }

    public void setMessengerUrl(String str) {
        boolean z = MyLog.isDebugAble;
        if (z) {
            str = "https://shadmessenger2.iranlms.ir";
        }
        if (z) {
            MyLog.e("ApiReqCore", "setMessengerUrl " + str);
        }
        this.messengerUrl = str;
        setRestApiService();
    }
}
