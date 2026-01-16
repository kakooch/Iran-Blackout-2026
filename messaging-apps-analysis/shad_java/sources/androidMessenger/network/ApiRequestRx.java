package androidMessenger.network;

import android.os.Build;
import androidMessenger.model.ApiCacheObject;
import androidMessenger.model.GetBaseInfoInput;
import androidMessenger.model.GetBaseInfoOutput;
import androidMessenger.model.GetLinkObjectInput;
import androidMessenger.model.GetLinkObjectOutput;
import androidMessenger.model.GetSettingsInput;
import androidMessenger.model.GetSettingsOutput2;
import androidMessenger.model.MessangerOutput;
import androidMessenger.model.MessengerInput;
import androidMessenger.utilites.AppFavorUtils;
import androidMessenger.utilites.MyLog;
import androidMessenger.utilites.ToastiLikeSnack;
import androidMessenger.utilites.UpdateUtils;
import com.facebook.stetho.common.Utf8Charset;
import com.facebook.stetho.server.http.HttpHeaders;
import com.google.gson.annotations.SerializedName;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import ir.aaap.messengercore.LoadListener;
import ir.aaap.messengercore.exceptions.InputException;
import ir.aaap.messengercore.network.ApiServerException;
import ir.aaap.messengercore.network.Network;
import ir.resaneh1.iptv.model.Link;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;
import okio.BufferedSource;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.BaseController;
import org.rbmain.messenger.Utilities;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/* loaded from: classes.dex */
public class ApiRequestRx extends BaseController {
    static RestApiRx restApiService;
    static RxHelper rxHelper = new RxHelper();
    private Charset UTF8;
    private CompositeDisposable compositeDisposable;
    public int currentAccount;
    private AuthDelegate delegate;
    Interceptor interCeptor;
    private Network.NetworkErrorListener networkErrorListener;

    public interface AuthDelegate {
        String provideAuth();
    }

    public interface ResponseListener<T> {
        void onError(Exception exc);

        void onResponse(T t);
    }

    public static class StatusOutput {

        @SerializedName("errors")
        public ArrayList<Error> errors;

        @SerializedName("status")
        public StatusEnum status = StatusEnum.ok;

        @SerializedName("status_link")
        public Link status_link;

        @SerializedName("status_message")
        public String status_message;

        public class Error {

            @SerializedName("error_message")
            public String errorMessage;
        }
    }

    private void increaseApiServerIfNeeded() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Response lambda$new$0(Interceptor.Chain chain) throws IOException {
        ApiCacheObject apiCache;
        String str;
        IOException iOException;
        Response responseProceed;
        String str2;
        int iCode;
        Request requestBuild = chain.request().newBuilder().addHeader(HttpHeaders.CONTENT_TYPE, "application/json").build();
        String appVersion = UpdateUtils.getAppVersion(ApplicationLoader.applicationContext);
        Buffer buffer = new Buffer();
        if (requestBuild.body() != null) {
            requestBuild.body().writeTo(buffer);
        }
        Charset charset = this.UTF8;
        String str3 = null;
        MediaType mediaTypeContentType = requestBuild.body() != null ? requestBuild.body().contentType() : null;
        String string = requestBuild.url().toString();
        if (mediaTypeContentType == null || mediaTypeContentType.subtype() == null || !mediaTypeContentType.subtype().equals("json")) {
            apiCache = null;
            str = BuildConfig.FLAVOR;
        } else {
            charset = mediaTypeContentType.charset(this.UTF8);
            String string2 = buffer.readString(charset);
            try {
                apiCache = CacheDatabaseHelper.getInstance(this.currentAccount).getApiCache("-", string2, appVersion);
                str = string2;
            } catch (Exception unused) {
                str = string2;
                apiCache = null;
            }
        }
        boolean zCanCache = canCache(string);
        if (zCanCache && apiCache != null && apiCache.output != null && apiCache.expiredTime.longValue() > System.currentTimeMillis()) {
            return new Response.Builder().request(requestBuild).protocol(Protocol.HTTP_2).message(BuildConfig.FLAVOR).code(200).body(ResponseBody.create(MediaType.parse("application/json"), apiCache.output)).addHeader("fromCache", BuildConfig.FLAVOR).build();
        }
        try {
            responseProceed = chain.proceed(requestBuild);
            iOException = null;
        } catch (IOException e) {
            iOException = e;
            responseProceed = null;
        }
        if (responseProceed != null && responseProceed.isSuccessful()) {
            if (zCanCache) {
                BufferedSource bufferedSourceSource = responseProceed.body().source();
                bufferedSourceSource.request(Long.MAX_VALUE);
                String string3 = bufferedSourceSource.buffer().clone().readString(charset);
                try {
                    str3 = ((MessangerOutput) ApplicationLoader.getGson().fromJson(string3, MessangerOutput.class)).cache;
                } catch (Exception unused2) {
                }
                Long lValueOf = 0L;
                if (str3 != null) {
                    try {
                        lValueOf = Long.valueOf(Long.parseLong(str3));
                    } catch (Exception unused3) {
                    }
                    CacheDatabaseHelper.getInstance(this.currentAccount).addOrUpdateApiCache(new ApiCacheObject("-", str, appVersion, string3, Long.valueOf(System.currentTimeMillis() + (lValueOf.longValue() * 1000))));
                }
            }
            return responseProceed;
        }
        increaseApiServerIfNeeded();
        if (responseProceed != null && (iCode = responseProceed.code()) >= 500 && iCode < 600) {
            iOException = new IOException(responseProceed.body() != null ? responseProceed.body().string() : "Null Error Body");
        }
        if (apiCache != null && (str2 = apiCache.output) != null) {
            return new Response.Builder().request(requestBuild).protocol(Protocol.HTTP_2).message(BuildConfig.FLAVOR).code(200).body(ResponseBody.create(MediaType.parse("application/json"), str2)).addHeader("fromCache", BuildConfig.FLAVOR).build();
        }
        if (iOException == null) {
            return responseProceed;
        }
        throw iOException;
    }

    boolean canCache(String str) {
        return !str.contains(getApiUrl());
    }

    public ApiRequestRx(int i) {
        super(i);
        this.UTF8 = null;
        this.interCeptor = new Interceptor() { // from class: androidMessenger.network.ApiRequestRx$$ExternalSyntheticLambda6
            @Override // okhttp3.Interceptor
            public final Response intercept(Interceptor.Chain chain) {
                return this.f$0.lambda$new$0(chain);
            }
        };
        this.currentAccount = i;
        this.UTF8 = Build.VERSION.SDK_INT >= 19 ? StandardCharsets.UTF_8 : Charset.forName(Utf8Charset.NAME);
        setRestApiService();
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
        restApiService = (RestApiRx) new Retrofit.Builder().baseUrl(getApiUrl()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(builderAddInterceptor.connectTimeout(20L, timeUnit).readTimeout(25L, timeUnit).writeTimeout(25L, timeUnit).build()).build().create(RestApiRx.class);
    }

    public String getApiUrl() {
        if (MyLog.isDebugAble) {
            return "https://shadmessenger2.iranlms.ir";
        }
        ArrayList<String> arrayList = AppFavorUtils.MESSENGER_URL_DEFAULT;
        return arrayList.get(Utilities.random.nextInt(arrayList.size()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ObservableSource lambda$addServerErrorHandler$2(Observable observable) {
        return observable.map(new Function() { // from class: androidMessenger.network.ApiRequestRx$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$addServerErrorHandler$1(obj);
            }
        });
    }

    public <T> ObservableTransformer<T, T> addServerErrorHandler() {
        return new ObservableTransformer() { // from class: androidMessenger.network.ApiRequestRx$$ExternalSyntheticLambda0
            @Override // io.reactivex.ObservableTransformer
            public final ObservableSource apply(Observable observable) {
                return this.f$0.lambda$addServerErrorHandler$2(observable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$addServerErrorHandler$1(Object obj) throws Exception {
        if (obj instanceof MessangerOutput) {
            handlingOnResponse((MessangerOutput) obj);
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ObservableSource lambda$addServerErrorHandlerIptv$4(Observable observable) {
        return observable.map(new Function() { // from class: androidMessenger.network.ApiRequestRx$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$addServerErrorHandlerIptv$3(obj);
            }
        });
    }

    public <T> ObservableTransformer<T, T> addServerErrorHandlerIptv() {
        return new ObservableTransformer() { // from class: androidMessenger.network.ApiRequestRx$$ExternalSyntheticLambda1
            @Override // io.reactivex.ObservableTransformer
            public final ObservableSource apply(Observable observable) {
                return this.f$0.lambda$addServerErrorHandlerIptv$4(observable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$addServerErrorHandlerIptv$3(Object obj) throws Exception {
        if (obj instanceof StatusOutput) {
            handlingOnResponseIptv((StatusOutput) obj);
        }
        return obj;
    }

    /* renamed from: androidMessenger.network.ApiRequestRx$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$androidMessenger$network$ApiRequestRx$StatusEnum;

        static {
            int[] iArr = new int[StatusEnum.values().length];
            $SwitchMap$androidMessenger$network$ApiRequestRx$StatusEnum = iArr;
            try {
                iArr[StatusEnum.error.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidMessenger$network$ApiRequestRx$StatusEnum[StatusEnum.invalid_username_or_pass.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidMessenger$network$ApiRequestRx$StatusEnum[StatusEnum.invalid_token.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidMessenger$network$ApiRequestRx$StatusEnum[StatusEnum.show_message.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private void handlingOnResponseIptv(StatusOutput statusOutput) {
        ArrayList<StatusOutput.Error> arrayList;
        if (AnonymousClass3.$SwitchMap$androidMessenger$network$ApiRequestRx$StatusEnum[statusOutput.status.ordinal()] == 1 && (arrayList = statusOutput.errors) != null && arrayList.size() > 0) {
            ToastiLikeSnack.showL(ApplicationLoader.applicationContext, statusOutput.errors.get(0).errorMessage);
        }
    }

    private void handlingOnResponse(MessangerOutput messangerOutput) throws ApiServerException {
        handleClientShowMessage(messangerOutput);
        if (messangerOutput == null || messangerOutput.status != MessangerOutput.EnumStatus.OK) {
            handleErrors(messangerOutput);
            throw new ApiServerException(messangerOutput.status.name(), messangerOutput.status_det.name());
        }
    }

    public void handleClientShowMessage(MessangerOutput messangerOutput) {
        if (messangerOutput != null) {
            getMessagesProxy().handleClientShowMessage(messangerOutput.client_show_message);
        }
    }

    public void handleErrors(MessangerOutput messangerOutput) {
        MessangerOutput.EnumStatus enumStatus;
        if (messangerOutput == null) {
            return;
        }
        ApiServerException apiServerException = new ApiServerException(messangerOutput.status + BuildConfig.FLAVOR, messangerOutput.status_det + BuildConfig.FLAVOR);
        Link.AlertData alertData = messangerOutput.message_data;
        if (alertData != null && ((enumStatus = messangerOutput.status) == MessangerOutput.EnumStatus.ERROR_MESSAGE_IGN || enumStatus == MessangerOutput.EnumStatus.ERROR_MESSAGE_TRY)) {
            try {
                if (ApplicationLoader.applicationActivity != null) {
                    Link link = new Link();
                    link.type = Link.LinkTypeEnum.alert;
                    link.alert_data = messangerOutput.message_data;
                    getMessengerLinkHandler().lambda$showDialogWithLink$30(link);
                    return;
                }
                return;
            } catch (Exception unused) {
                return;
            }
        }
        MessangerOutput.EnumStatus enumStatus2 = messangerOutput.status;
        MessangerOutput.EnumStatus enumStatus3 = MessangerOutput.EnumStatus.ERROR_ACTION;
        if (enumStatus2 == enumStatus3 && messangerOutput.status_det == MessangerOutput.EnumStatusDet.NOT_REGISTERED) {
            Network.NetworkErrorListener networkErrorListener = this.networkErrorListener;
            if (networkErrorListener != null) {
                networkErrorListener.onNotRegistered();
                return;
            }
            return;
        }
        if (enumStatus2 == enumStatus3 && messangerOutput.status_det == MessangerOutput.EnumStatusDet.INVALID_AUTH) {
            Network.NetworkErrorListener networkErrorListener2 = this.networkErrorListener;
            if (networkErrorListener2 != null) {
                networkErrorListener2.onInvalidAuth();
                return;
            }
            return;
        }
        Network.NetworkErrorListener networkErrorListener3 = this.networkErrorListener;
        if (networkErrorListener3 != null) {
            networkErrorListener3.handleError(apiServerException, alertData);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<GetBaseInfoOutput>> getBaseInfo(GetBaseInfoInput getBaseInfoInput) {
        MessengerInput<GetBaseInfoInput> messengerInput = new MessengerInput<>(BuildConfig.FLAVOR);
        messengerInput.method = "getBaseInfo";
        messengerInput.data = getBaseInfoInput;
        messengerInput.setIptvInput();
        return restApiService.getBaseInfo(AppFavorUtils.GATEWAY_URL, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRetryAndDelay(5, 5, 10, 15, 20, 20)).compose(addServerErrorHandler());
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, androidMessenger.model.GetSettingsInput] */
    public void getSettings(final ResponseListener<GetSettingsOutput2> responseListener) {
        AuthDelegate authDelegate = this.delegate;
        if (authDelegate == null) {
            responseListener.onError(new InputException());
            return;
        }
        String strProvideAuth = authDelegate.provideAuth();
        MessengerInput<GetSettingsInput> messengerInput = new MessengerInput<>(strProvideAuth);
        messengerInput.method = "getSettings";
        messengerInput.data = new GetSettingsInput();
        messengerInput.setSettingInput();
        this.compositeDisposable.add((DisposableObserver) restApiService.getSettings(AppFavorUtils.iptvUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler()).compose(addDecrypt(GetSettingsOutput2.class, strProvideAuth)).subscribeWith(new DisposableObserver<MessangerOutput<GetSettingsOutput2>>(this) { // from class: androidMessenger.network.ApiRequestRx.1
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<GetSettingsOutput2> messangerOutput) {
                if (messangerOutput.status == MessangerOutput.EnumStatus.OK) {
                    responseListener.onResponse(messangerOutput.data);
                } else {
                    responseListener.onError(new ApiServerException(messangerOutput.status.name(), messangerOutput.status_det.name()));
                }
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                responseListener.onError(new Exception(th));
            }
        }));
    }

    public void getLinkObject(String str, final LoadListener<GetLinkObjectOutput> loadListener) {
        if (this.delegate == null) {
            loadListener.onError(new InputException());
            return;
        }
        GetLinkObjectInput getLinkObjectInput = new GetLinkObjectInput();
        getLinkObjectInput.share_string = str;
        String strProvideAuth = this.delegate.provideAuth();
        String str2 = AppFavorUtils.baseUrlOld + "/api/v3.0/getLinkObject";
        HashMap<String, String> map = new HashMap<>();
        map.put("username", "android");
        map.put("password", "lid9FS(33dlsdfljf");
        map.put(HttpHeaders.CONTENT_TYPE, "application/json");
        map.put("token", strProvideAuth);
        map.put("app_version", UpdateUtils.getAppVersion(ApplicationLoader.applicationContext));
        this.compositeDisposable.add((DisposableObserver) restApiService.getLinkObject(str2, map, getLinkObjectInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandlerIptv()).subscribeWith(new DisposableObserver<GetLinkObjectOutput>(this) { // from class: androidMessenger.network.ApiRequestRx.2
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(GetLinkObjectOutput getLinkObjectOutput) {
                if (getLinkObjectOutput != null) {
                    loadListener.onDidLoad(getLinkObjectOutput);
                } else {
                    loadListener.onError(new ApiServerException());
                }
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                loadListener.onError(new Exception(th));
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ObservableSource lambda$addDecrypt$6(final Class cls, final String str, Observable observable) {
        return observable.map(new Function() { // from class: androidMessenger.network.ApiRequestRx$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ApiRequestRx.lambda$addDecrypt$5(cls, str, obj);
            }
        });
    }

    public <T> ObservableTransformer<T, T> addDecrypt(final Class<?> cls, final String str) {
        return new ObservableTransformer() { // from class: androidMessenger.network.ApiRequestRx$$ExternalSyntheticLambda2
            @Override // io.reactivex.ObservableTransformer
            public final ObservableSource apply(Observable observable) {
                return ApiRequestRx.lambda$addDecrypt$6(cls, str, observable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$addDecrypt$5(Class cls, String str, Object obj) throws Exception {
        if (obj instanceof MessangerOutput) {
            ((MessangerOutput) obj).makeDataT(cls, str);
        }
        return obj;
    }

    public void init(AuthDelegate authDelegate, Network.NetworkErrorListener networkErrorListener) {
        this.networkErrorListener = networkErrorListener;
        this.delegate = authDelegate;
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        if (compositeDisposable == null || compositeDisposable.isDisposed()) {
            this.compositeDisposable = new CompositeDisposable();
        }
    }

    public void disposeObservables() {
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        if (compositeDisposable == null || compositeDisposable.isDisposed()) {
            return;
        }
        this.compositeDisposable.dispose();
    }

    public void checkDisposables() {
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        if (compositeDisposable == null || compositeDisposable.isDisposed()) {
            this.compositeDisposable = new CompositeDisposable();
        }
    }

    public enum StatusEnum {
        error(0),
        ok(1),
        invalid_token(2),
        invalid_username_or_pass(3),
        invalid_header(4),
        access_denied(5),
        duplicate_request(6),
        show_message(7);

        StatusEnum(int i) {
        }
    }
}
