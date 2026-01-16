package androidMessenger.network;

import androidMessenger.helper.AppPreferences;
import androidMessenger.utilites.MyLog;
import com.facebook.stetho.server.http.HttpHeaders;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import ir.aaap.messengercore.network.Network;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import org.rbmain.messenger.AccountInstance;
import org.rbmain.messenger.UserConfig;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/* loaded from: classes.dex */
public class FileRequestMessangerRx {
    static volatile FileRequestMessangerRx instance;
    static RestApiMessangerRx restApiService;
    Interceptor interCeptor = new Interceptor() { // from class: androidMessenger.network.FileRequestMessangerRx$$ExternalSyntheticLambda0
        @Override // okhttp3.Interceptor
        public final Response intercept(Interceptor.Chain chain) {
            return this.f$0.lambda$new$0(chain);
        }
    };
    public String messengerUrl;
    public Network.NetworkErrorListener urlChangeListener;

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
            if (requestBuild.header("access-hash-rec") != null) {
                increaseCdnCounterIfNeeded(requestBuild.url().toString());
            }
            if (responseProceed != null && e == null && (iCode = responseProceed.code()) >= 500 && iCode < 600) {
                e = new IOException(responseProceed.body() != null ? responseProceed.body().string() : "Null Error Body");
            }
            if (e != null) {
                throw e;
            }
        }
        return responseProceed;
    }

    private void increaseCdnCounterIfNeeded(String str) {
        Network.NetworkErrorListener networkErrorListener = this.urlChangeListener;
        if (networkErrorListener != null) {
            networkErrorListener.onGetFileError(str);
        }
    }

    public void setNetworkErrorListener(Network.NetworkErrorListener networkErrorListener) {
        this.urlChangeListener = networkErrorListener;
    }

    public void init(String str) {
        setMessengerUrl(str);
    }

    public void setRestApiService() {
        if (restApiService != null) {
            return;
        }
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

    public static FileRequestMessangerRx getInstance() {
        FileRequestMessangerRx fileRequestMessangerRx = instance;
        if (fileRequestMessangerRx == null) {
            synchronized (AppPreferences.class) {
                fileRequestMessangerRx = instance;
                if (fileRequestMessangerRx == null) {
                    fileRequestMessangerRx = new FileRequestMessangerRx();
                    instance = fileRequestMessangerRx;
                }
            }
        }
        return fileRequestMessangerRx;
    }

    public Observable<retrofit2.Response<ResponseBody>> getFile(String str, HashMap<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        return restApiService.getFile(str, map);
    }

    public Observable<retrofit2.Response<ResponseBody>> getFileCdn(final String str, final String str2, final HashMap<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        return Observable.just(0).flatMap(new Function<Integer, ObservableSource<retrofit2.Response<ResponseBody>>>() { // from class: androidMessenger.network.FileRequestMessangerRx.1
            @Override // io.reactivex.functions.Function
            public ObservableSource<retrofit2.Response<ResponseBody>> apply(Integer num) throws Exception {
                return FileRequestMessangerRx.restApiService.getFile(FileRequestMessangerRx.this.getCdnUrl(str, str2), map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getCdnUrl(String str, String str2) {
        String urlByCdnTag = AccountInstance.getInstance(UserConfig.selectedAccount).getCoreMainClass().getUrlByCdnTag(str, str2);
        return urlByCdnTag == null ? BuildConfig.FLAVOR : urlByCdnTag;
    }

    public Observable<retrofit2.Response<ResponseBody>> getExternalFile(String str) {
        return restApiService.getExternalFile(str);
    }

    public Observable<retrofit2.Response<ResponseBody>> sendFile(String str, RequestBody requestBody, HashMap<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        return restApiService.sendFile(str, requestBody, map);
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
