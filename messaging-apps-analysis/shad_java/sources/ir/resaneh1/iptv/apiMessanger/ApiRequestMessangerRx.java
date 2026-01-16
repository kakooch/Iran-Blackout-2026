package ir.resaneh1.iptv.apiMessanger;

import android.os.Build;
import androidMessenger.utilites.AppFavorUtils;
import com.facebook.stetho.common.Utf8Charset;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.facebook.stetho.server.http.HttpHeaders;
import com.facebook.stetho.server.http.HttpStatus;
import com.google.gson.reflect.TypeToken;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import ir.appp.vod.domain.model.input.ActionOnMediaInput;
import ir.appp.vod.domain.model.input.GetCastRelatedInput;
import ir.appp.vod.domain.model.input.GetEpisodesInput;
import ir.appp.vod.domain.model.input.GetMediaInput;
import ir.appp.vod.domain.model.input.GetRelatedInput;
import ir.appp.vod.domain.model.output.GetCastRelatedOutput;
import ir.appp.vod.domain.model.output.GetEpisodesOutput;
import ir.appp.vod.domain.model.output.GetRelatedOutput;
import ir.appp.vod.domain.model.output.VodMediaEntityOutput;
import ir.resaneh1.iptv.appUpdate.UpdateUtils;
import ir.resaneh1.iptv.helper.AppPreferences;
import ir.resaneh1.iptv.helper.CacheDatabaseHelper;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.messanger.DataCenterManager;
import ir.resaneh1.iptv.model.AddEmojiSliderAnswerInput;
import ir.resaneh1.iptv.model.AddPollAnswerInput;
import ir.resaneh1.iptv.model.AddStoryInput;
import ir.resaneh1.iptv.model.AddStoryOutput;
import ir.resaneh1.iptv.model.AddViewStoryInput;
import ir.resaneh1.iptv.model.AddViewStoryOutput;
import ir.resaneh1.iptv.model.ApiCacheObject;
import ir.resaneh1.iptv.model.ClickLinkTrackInput;
import ir.resaneh1.iptv.model.DataOutputV5;
import ir.resaneh1.iptv.model.DeleteStoryInput;
import ir.resaneh1.iptv.model.DeleteStoryOutput;
import ir.resaneh1.iptv.model.GameAddCommentInput;
import ir.resaneh1.iptv.model.GameAddCommentOutput;
import ir.resaneh1.iptv.model.GameGetCommentsInput;
import ir.resaneh1.iptv.model.GameGetCommentsOutput;
import ir.resaneh1.iptv.model.GameInput;
import ir.resaneh1.iptv.model.GameSendAnswerInput;
import ir.resaneh1.iptv.model.GameSendAnswerOutput;
import ir.resaneh1.iptv.model.GameUseReliveChanceInput;
import ir.resaneh1.iptv.model.GameUseReliveChanceOutput;
import ir.resaneh1.iptv.model.GetDynamicPageDataInput;
import ir.resaneh1.iptv.model.GetDynamicPageDataOutput;
import ir.resaneh1.iptv.model.GetDynamicPageViewsInput;
import ir.resaneh1.iptv.model.GetDynamicPageViewsOutput;
import ir.resaneh1.iptv.model.GetEmojiResultsInput;
import ir.resaneh1.iptv.model.GetEndpointDataInput;
import ir.resaneh1.iptv.model.GetEndpointDataOutput;
import ir.resaneh1.iptv.model.GetEndpointViewInput;
import ir.resaneh1.iptv.model.GetEndpointViewOutput;
import ir.resaneh1.iptv.model.GetGameInfoOutput;
import ir.resaneh1.iptv.model.GetGameStatusInput;
import ir.resaneh1.iptv.model.GetGameStatusOutput;
import ir.resaneh1.iptv.model.GetMyStoryListInput;
import ir.resaneh1.iptv.model.GetMyStoryListOutput;
import ir.resaneh1.iptv.model.GetPollResultProfilesInput;
import ir.resaneh1.iptv.model.GetProductDetailInput;
import ir.resaneh1.iptv.model.GetProductDetailOutput;
import ir.resaneh1.iptv.model.GetProductsInput;
import ir.resaneh1.iptv.model.GetProductsOutput;
import ir.resaneh1.iptv.model.GetProfilesStoriesInput;
import ir.resaneh1.iptv.model.GetProfilesStoriesOutput;
import ir.resaneh1.iptv.model.GetProfilesStoryListInput;
import ir.resaneh1.iptv.model.GetProfilesStoryListOutput;
import ir.resaneh1.iptv.model.GetStoreDetailInput;
import ir.resaneh1.iptv.model.GetStoreDetailOutput;
import ir.resaneh1.iptv.model.GetStoryIdsInput;
import ir.resaneh1.iptv.model.GetStoryIdsOutput;
import ir.resaneh1.iptv.model.GetStoryInput;
import ir.resaneh1.iptv.model.GetStoryOutput;
import ir.resaneh1.iptv.model.GetStorySettingInput;
import ir.resaneh1.iptv.model.GetStoryViewersInput;
import ir.resaneh1.iptv.model.GetStoryViewersOutput;
import ir.resaneh1.iptv.model.GetTasksInput;
import ir.resaneh1.iptv.model.GetTasksOutput;
import ir.resaneh1.iptv.model.HomePageModels;
import ir.resaneh1.iptv.model.InstaGetHashTagsOutput;
import ir.resaneh1.iptv.model.InstaGetListInput;
import ir.resaneh1.iptv.model.InstaGetProfilesOutput;
import ir.resaneh1.iptv.model.Link;
import ir.resaneh1.iptv.model.LiveModels;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.MessengerInput;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.RubinoRequestUploadFileInput;
import ir.resaneh1.iptv.model.RubinoRequestUploadFileOutput;
import ir.resaneh1.iptv.model.RubinoUpdateProfilePhotoInput;
import ir.resaneh1.iptv.model.RubinoUpdateProfilePhotoOutput;
import ir.resaneh1.iptv.model.RubinoUploadFileOutput;
import ir.resaneh1.iptv.model.SendDataDynamicPageInput;
import ir.resaneh1.iptv.model.SendDataDynamicPageOutput;
import ir.resaneh1.iptv.model.SetDefaultDeliveryInfoInput;
import ir.resaneh1.iptv.model.SetStorySettingInput;
import ir.resaneh1.iptv.model.ShopModels;
import ir.resaneh1.iptv.model.StorySettingOutput;
import ir.resaneh1.iptv.model.messenger.SendTaskResultInput;
import ir.resaneh1.iptv.model.messenger.SendTaskResultOutput;
import ir.resaneh1.iptv.model.wallet.CashOutInput;
import ir.resaneh1.iptv.model.wallet.CashOutOutput;
import ir.resaneh1.iptv.model.wallet.ChargeWalletByTokenInput;
import ir.resaneh1.iptv.model.wallet.ChargeWalletByTokenOutput;
import ir.resaneh1.iptv.model.wallet.ChargeWalletByUrlInput;
import ir.resaneh1.iptv.model.wallet.ChargeWalletByUrlOutput;
import ir.resaneh1.iptv.model.wallet.CheckAllowReceiveInput;
import ir.resaneh1.iptv.model.wallet.CheckAllowReceiveOutput;
import ir.resaneh1.iptv.model.wallet.GetCurrenciesInput;
import ir.resaneh1.iptv.model.wallet.GetCurrenciesOutput;
import ir.resaneh1.iptv.model.wallet.GetWalletByShareLinkInput;
import ir.resaneh1.iptv.model.wallet.GetWalletByShareLinkOutput;
import ir.resaneh1.iptv.model.wallet.GetWalletShareLinkInput;
import ir.resaneh1.iptv.model.wallet.GetWalletShareLinkOutput;
import ir.resaneh1.iptv.model.wallet.GetWalletStatusInput;
import ir.resaneh1.iptv.model.wallet.GetWalletStatusOutput;
import ir.resaneh1.iptv.model.wallet.GetWalletTransactionsInput;
import ir.resaneh1.iptv.model.wallet.GetWalletTransactionsOutput;
import ir.resaneh1.iptv.model.wallet.TransferCreditInput;
import ir.resaneh1.iptv.model.wallet.TransferCreditOutput;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;
import okio.BufferedSource;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.BaseController;
import org.rbmain.messenger.Utilities;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/* loaded from: classes3.dex */
public class ApiRequestMessangerRx extends BaseController {
    private Charset UTF8;
    public String auth;
    Interceptor interCeptor;
    Boolean isSignOk;
    private long lastTimeIncreased;
    RestApiMessangerRx restApiService;
    static RxHelper rxHelper = new RxHelper();
    static Set<String> showedClientMessagesIds = new HashSet();
    private static final ApiRequestMessangerRx[] Instance = new ApiRequestMessangerRx[3];

    public ApiRequestMessangerRx(int i) {
        super(i);
        this.UTF8 = null;
        this.auth = BuildConfig.FLAVOR;
        this.lastTimeIncreased = 0L;
        this.isSignOk = null;
        this.interCeptor = new Interceptor() { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.3
            @Override // okhttp3.Interceptor
            public Response intercept(Interceptor.Chain chain) throws IOException {
                ApiCacheObject apiCache;
                String str;
                IOException iOException;
                Response responseProceed;
                String str2;
                Request requestBuild = chain.request().newBuilder().addHeader(HttpHeaders.CONTENT_TYPE, "application/json").build();
                int i2 = ApplicationLoader.applicationContext.getApplicationInfo().flags;
                if (!ApiRequestMessangerRx.this.isSigntureOk()) {
                    throw new SocketTimeoutException();
                }
                String appVersion = UpdateUtils.getAppVersion(ApplicationLoader.applicationContext);
                Buffer buffer = new Buffer();
                if (requestBuild.body() != null) {
                    requestBuild.body().writeTo(buffer);
                }
                Charset charset = ApiRequestMessangerRx.this.UTF8;
                String str3 = null;
                MediaType mediaTypeContentType = requestBuild.body() != null ? requestBuild.body().contentType() : null;
                String string = requestBuild.url().toString();
                if (mediaTypeContentType == null || mediaTypeContentType.subtype() == null || !mediaTypeContentType.subtype().equals("json")) {
                    apiCache = null;
                    str = BuildConfig.FLAVOR;
                } else {
                    charset = mediaTypeContentType.charset(ApiRequestMessangerRx.this.UTF8);
                    String string2 = buffer.readString(charset);
                    try {
                        apiCache = CacheDatabaseHelper.getInstance(((BaseController) ApiRequestMessangerRx.this).currentAccount).getApiCache("-", string2, appVersion);
                        str = string2;
                    } catch (Exception unused) {
                        str = string2;
                        apiCache = null;
                    }
                }
                boolean zCanCache = ApiRequestMessangerRx.this.canCache(string);
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
                if (responseProceed == null || !responseProceed.isSuccessful()) {
                    ApiRequestMessangerRx.this.increaseApiServerIfNeeded();
                    if (apiCache != null && (str2 = apiCache.output) != null) {
                        return new Response.Builder().request(requestBuild).protocol(Protocol.HTTP_2).message(BuildConfig.FLAVOR).code(200).body(ResponseBody.create(MediaType.parse("application/json"), str2)).addHeader("fromCache", BuildConfig.FLAVOR).build();
                    }
                    if (iOException == null) {
                        return responseProceed;
                    }
                    throw iOException;
                }
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
                        CacheDatabaseHelper.getInstance(((BaseController) ApiRequestMessangerRx.this).currentAccount).addOrUpdateApiCache(new ApiCacheObject("-", str, appVersion, string3, Long.valueOf(System.currentTimeMillis() + (lValueOf.longValue() * 1000))));
                    }
                }
                return responseProceed;
            }
        };
        this.UTF8 = Build.VERSION.SDK_INT >= 19 ? StandardCharsets.UTF_8 : Charset.forName(Utf8Charset.NAME);
        setRestApiService();
    }

    public <T> ObservableTransformer<T, T> addDecryptor(final Class<?> cls, final String str) {
        return new ObservableTransformer<T, T>(this) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.1
            @Override // io.reactivex.ObservableTransformer
            public ObservableSource<T> apply(Observable<T> observable) {
                return observable.map(new Function<T, T>() { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.1.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // io.reactivex.functions.Function
                    public T apply(T t) throws Exception {
                        if (t instanceof MessangerOutput) {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            ((MessangerOutput) t).makeDataT(cls, str);
                        }
                        return t;
                    }
                });
            }
        };
    }

    public <T> ObservableTransformer<T, T> addDecryptorV5(final TypeToken typeToken, final String str) {
        return new ObservableTransformer<T, T>(this) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.2
            @Override // io.reactivex.ObservableTransformer
            public ObservableSource<T> apply(Observable<T> observable) {
                return observable.map(new Function<T, T>() { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.2.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // io.reactivex.functions.Function
                    public T apply(T t) throws Exception {
                        if (t instanceof MessangerOutput) {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            ((MessangerOutput) t).makeDataV5(typeToken, str);
                        }
                        return t;
                    }
                });
            }
        };
    }

    boolean canCache(String str) {
        return !str.contains(DataCenterManager.getInstance().getApiUrl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isSigntureOk() {
        Boolean bool = this.isSignOk;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            String strMD5 = Utilities.MD5(ApplicationLoader.applicationActivity.getPackageManager().getPackageInfo(ApplicationLoader.applicationActivity.getPackageName(), 64).signatures[0].toCharsString());
            Boolean boolValueOf = Boolean.valueOf("e2f5cf10c6c6b7dde85985d87e9fe79e".equals(strMD5) || "f7921b1cc89cfac2a2a6a6632c2a79d8".equals(strMD5));
            this.isSignOk = boolValueOf;
            return boolValueOf.booleanValue();
        } catch (Exception unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void increaseApiServerIfNeeded() {
        if (System.currentTimeMillis() - this.lastTimeIncreased > 3000) {
            this.lastTimeIncreased = System.currentTimeMillis();
            DataCenterManager.getInstance().increastApiCouner();
            setRestApiService();
        }
    }

    public void setRestApiService() {
        HttpLoggingMessanger httpLoggingMessanger = new HttpLoggingMessanger(this.currentAccount, new HttpLoggingInterceptor.Logger() { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.4
            @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
            public void log(String str) {
                MyLog.e("LogAPIMessenger " + AppPreferences.getInstance(((BaseController) ApiRequestMessangerRx.this).currentAccount).getMyUserGuid(), str);
            }
        });
        if (MyLog.isDebugAble) {
            httpLoggingMessanger.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            httpLoggingMessanger.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        OkHttpClient.Builder builderAddNetworkInterceptor = new OkHttpClient.Builder().addInterceptor(this.interCeptor).addInterceptor(httpLoggingMessanger).addNetworkInterceptor(new StethoInterceptor());
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.restApiService = (RestApiMessangerRx) new Retrofit.Builder().baseUrl(DataCenterManager.getInstance().getApiUrl()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(builderAddNetworkInterceptor.connectTimeout(20L, timeUnit).readTimeout(25L, timeUnit).writeTimeout(25L, timeUnit).build()).build().create(RestApiMessangerRx.class);
    }

    public static ApiRequestMessangerRx getInstance(int i) {
        ApiRequestMessangerRx[] apiRequestMessangerRxArr = Instance;
        ApiRequestMessangerRx apiRequestMessangerRx = apiRequestMessangerRxArr[i];
        if (apiRequestMessangerRx == null) {
            synchronized (ApiRequestMessangerRx.class) {
                apiRequestMessangerRx = apiRequestMessangerRxArr[i];
                if (apiRequestMessangerRx == null) {
                    apiRequestMessangerRx = new ApiRequestMessangerRx(i);
                    apiRequestMessangerRxArr[i] = apiRequestMessangerRx;
                }
            }
        }
        if (apiRequestMessangerRx.auth.length() == 0) {
            apiRequestMessangerRx.auth = apiRequestMessangerRx.getAppPreferences().getAuth();
        }
        return apiRequestMessangerRx;
    }

    public <T> ObservableTransformer<T, T> addServerErrorHandler() {
        return new ObservableTransformer<T, T>() { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.6
            @Override // io.reactivex.ObservableTransformer
            public ObservableSource<T> apply(Observable<T> observable) {
                return observable.map(new Function<T, T>() { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.6.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // io.reactivex.functions.Function
                    public T apply(T t) throws Exception {
                        if (t instanceof MessangerOutput) {
                            ApiRequestMessangerRx.this.handlingOnResponse((MessangerOutput) t);
                        }
                        return t;
                    }
                });
            }
        };
    }

    public void handleClientShowMessage(final MessangerOutput messangerOutput) {
        MessangerOutput.ClientShowMessage clientShowMessage;
        if (messangerOutput == null || (clientShowMessage = messangerOutput.client_show_message) == null) {
            return;
        }
        try {
            String str = clientShowMessage.unique_id;
            if (str != null && !str.isEmpty()) {
                if (showedClientMessagesIds.contains(messangerOutput.client_show_message.unique_id)) {
                    return;
                } else {
                    showedClientMessagesIds.add(messangerOutput.client_show_message.unique_id);
                }
            }
            DisposableObserver disposableObserver = (DisposableObserver) Observable.just(0).delay(500L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Integer>(this) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.7
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                }

                @Override // io.reactivex.Observer
                public void onNext(Integer num) {
                    try {
                        new MainClickHandler().onLinkClick(messangerOutput.client_show_message.link);
                    } catch (Exception unused) {
                    }
                }
            });
            if (ApplicationLoader.applicationActivity != null) {
                ApplicationLoader.applicationActivity.mainCompositeDisposable.add(disposableObserver);
            }
        } catch (Exception unused) {
        }
    }

    public void handleErrors(MessangerOutput messangerOutput) {
        MessangerOutput.EnumStatus enumStatus;
        if (messangerOutput == null) {
            return;
        }
        if (messangerOutput.message_data != null && ((enumStatus = messangerOutput.status) == MessangerOutput.EnumStatus.ERROR_MESSAGE_IGN || enumStatus == MessangerOutput.EnumStatus.ERROR_MESSAGE_TRY)) {
            try {
                if (ApplicationLoader.applicationActivity != null) {
                    final Link link = new Link();
                    link.type = Link.LinkTypeEnum.alert;
                    link.alert_data = messangerOutput.message_data;
                    Observable.just(0).observeOn(AndroidSchedulers.mainThread()).subscribe(new DisposableObserver<Integer>(this) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.8
                        @Override // io.reactivex.Observer
                        public void onComplete() {
                        }

                        @Override // io.reactivex.Observer
                        public void onError(Throwable th) {
                        }

                        @Override // io.reactivex.Observer
                        public void onNext(Integer num) {
                            new MainClickHandler().onLinkClick(ApplicationLoader.applicationActivity.getLastFragment(), link);
                        }
                    });
                    return;
                }
                return;
            } catch (Exception unused) {
                return;
            }
        }
        MessangerOutput.EnumStatus enumStatus2 = messangerOutput.status;
        if (enumStatus2 == MessangerOutput.EnumStatus.ERROR_GENERIC && messangerOutput.status_det == MessangerOutput.EnumStatusDet.TOO_REQUESTS) {
            Observable.just(0).observeOn(AndroidSchedulers.mainThread()).subscribe(new DisposableObserver<Integer>(this) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.9
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                }

                @Override // io.reactivex.Observer
                public void onNext(Integer num) {
                    ToastiLikeSnack.showL(ApplicationLoader.applicationActivity, "استفاده بیش از حد مجاز");
                }
            });
            return;
        }
        MessangerOutput.EnumStatus enumStatus3 = MessangerOutput.EnumStatus.ERROR_ACTION;
        if (!(enumStatus2 == enumStatus3 && messangerOutput.status_det == MessangerOutput.EnumStatusDet.NOT_REGISTERED) && enumStatus2 == enumStatus3 && messangerOutput.status_det == MessangerOutput.EnumStatusDet.INVALID_AUTH) {
            getCoreMainClass().onInvalidAuth();
            this.auth = BuildConfig.FLAVOR;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlingOnResponse(MessangerOutput messangerOutput) throws ApiServerException {
        handleClientShowMessage(messangerOutput);
        if (messangerOutput == null || messangerOutput.status != MessangerOutput.EnumStatus.OK) {
            increaseApiServerIfNeeded();
            handleErrors(messangerOutput);
            throw new ApiServerException(messangerOutput.status, messangerOutput.status_det);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<GetTasksOutput>> getQualityTasks(GetTasksInput getTasksInput) {
        final MessengerInput messengerInput = new MessengerInput(this.auth);
        messengerInput.method = "getQualityTasks";
        messengerInput.data = getTasksInput;
        return Observable.just(0).flatMap(new Function<Integer, Observable<MessangerOutput<GetTasksOutput>>>() { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.10
            @Override // io.reactivex.functions.Function
            public Observable<MessangerOutput<GetTasksOutput>> apply(Integer num) throws Exception {
                messengerInput.makeDataV5();
                MessengerInput<GetTasksInput> messengerInput2 = messengerInput;
                messengerInput2.api_version = "1";
                return ApiRequestMessangerRx.this.restApiService.getTasks(AppFavorUtils.suggested_nquality, messengerInput2);
            }
        }).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addDecryptorV5(new TypeToken<DataOutputV5<GetTasksOutput>>(this) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.11
        }, this.auth)).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<SendTaskResultOutput>> sendTaskResult(SendTaskResultInput sendTaskResultInput) {
        final MessengerInput messengerInput = new MessengerInput(this.auth);
        messengerInput.method = "sendQualityTaskResult";
        messengerInput.data = sendTaskResultInput;
        return Observable.just(0).flatMap(new Function<Integer, Observable<MessangerOutput<SendTaskResultOutput>>>() { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.12
            @Override // io.reactivex.functions.Function
            public Observable<MessangerOutput<SendTaskResultOutput>> apply(Integer num) throws Exception {
                messengerInput.makeDataV5();
                MessengerInput<SendTaskResultInput> messengerInput2 = messengerInput;
                messengerInput2.api_version = "1";
                return ApiRequestMessangerRx.this.restApiService.sendTaskResult(AppFavorUtils.suggested_nquality, messengerInput2);
            }
        }).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addDecryptorV5(new TypeToken<DataOutputV5<SendTaskResultOutput>>(this) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.13
        }, this.auth)).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<GetEndpointViewOutput>> getEndPointView(GetEndpointViewInput getEndpointViewInput, Observable<Object> observable) {
        MessengerInput<GetEndpointViewInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getEndpointView";
        messengerInput.data = getEndpointViewInput;
        messengerInput.setIptvInput();
        return this.restApiService.getEndPointView(AppFavorUtils.iptvUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRetryAndDelay(1, 1)).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput> setDefaultDeliveryInfo(SetDefaultDeliveryInfoInput setDefaultDeliveryInfoInput) {
        MessengerInput<SetDefaultDeliveryInfoInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "setDefaultDeliveryInfo";
        messengerInput.data = setDefaultDeliveryInfoInput;
        messengerInput.setBasketInput();
        return this.restApiService.setDefaultDeliveryInfo(AppFavorUtils.basketUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<GetEndpointDataOutput>> getEndPointData(String str, GetEndpointDataInput getEndpointDataInput) {
        MessengerInput<GetEndpointDataInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getEndpointData";
        messengerInput.data = getEndpointDataInput;
        messengerInput.setIptvInput();
        return this.restApiService.getEndPointData(str, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<GetDynamicPageViewsOutput>> getDynamicPageViews(GetDynamicPageViewsInput getDynamicPageViewsInput, Observable<Object> observable) {
        MessengerInput<GetDynamicPageViewsInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getDynamicPageViews";
        messengerInput.data = getDynamicPageViewsInput;
        messengerInput.setIptvInput();
        return this.restApiService.getDynamicPageViews(AppFavorUtils.iptvUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<GetDynamicPageDataOutput>> getDynamicPageData(String str, GetDynamicPageDataInput getDynamicPageDataInput, Observable<Object> observable) {
        MessengerInput<GetDynamicPageDataInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getDynamicPageData";
        messengerInput.data = getDynamicPageDataInput;
        messengerInput.setIptvInput();
        return this.restApiService.getDynamicPageData(str, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<SendDataDynamicPageOutput>> sendDataDynamicPage(String str, SendDataDynamicPageInput sendDataDynamicPageInput, Observable<Object> observable) {
        MessengerInput<SendDataDynamicPageInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "sendData";
        messengerInput.data = sendDataDynamicPageInput;
        messengerInput.setIptvInput();
        return this.restApiService.sendDataDynamicPage(str, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<GetGameStatusOutput>> getGameStatus(long j, GetGameStatusInput getGameStatusInput) {
        MessengerInput<GetGameStatusInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getGameStatus";
        messengerInput.data = getGameStatusInput;
        messengerInput.setGameInput();
        return this.restApiService.getGameStatus(AppFavorUtils.gameUrl, messengerInput).timeout(6L, TimeUnit.SECONDS).compose(rxHelper.applySchedulers()).compose(rxHelper.addInfiniteRetryAndDelayMiliSecond(j)).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<GameAddCommentOutput>> gameAddComment(GameAddCommentInput gameAddCommentInput) {
        MessengerInput<GameAddCommentInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "addComment";
        messengerInput.data = gameAddCommentInput;
        messengerInput.setGameInput();
        return this.restApiService.gameAddComment(AppFavorUtils.gameUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRetryAndDelay(1, 2)).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<GetGameInfoOutput>> getGameInfo(GameInput gameInput) {
        MessengerInput<GameInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getGameInfo";
        messengerInput.data = gameInput;
        messengerInput.setGameInput();
        return this.restApiService.getGameInfo(AppFavorUtils.gameUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput> exitGame(GameInput gameInput) {
        MessengerInput<GameInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "exitGame";
        messengerInput.data = gameInput;
        messengerInput.setGameInput();
        return this.restApiService.exitGame(AppFavorUtils.gameUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<GameGetCommentsOutput>> gameGetComments(int i, GameGetCommentsInput gameGetCommentsInput) {
        MessengerInput<GameGetCommentsInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getComments";
        messengerInput.data = gameGetCommentsInput;
        messengerInput.setGameInput();
        return this.restApiService.gameGetComments(AppFavorUtils.gameUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addInfiniteRetryAndDelay(i)).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<GameSendAnswerOutput>> gameSendAnswer(GameSendAnswerInput gameSendAnswerInput) {
        MessengerInput<GameSendAnswerInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "sendAnswer";
        messengerInput.data = gameSendAnswerInput;
        messengerInput.setGameInput();
        return this.restApiService.gameSendAnswer(AppFavorUtils.gameUrl, messengerInput).timeout(3L, TimeUnit.SECONDS).compose(rxHelper.applySchedulers()).compose(rxHelper.addRetryAndDelayMilliSecond(20, HttpStatus.HTTP_INTERNAL_SERVER_ERROR)).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<GameUseReliveChanceOutput>> gameUseReliveChance(GameUseReliveChanceInput gameUseReliveChanceInput) {
        MessengerInput<GameUseReliveChanceInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "useReliveChance";
        messengerInput.data = gameUseReliveChanceInput;
        messengerInput.setGameInput();
        return this.restApiService.gameUseReliveChance(AppFavorUtils.gameUrl, messengerInput).timeout(5L, TimeUnit.SECONDS).compose(rxHelper.applySchedulers()).compose(rxHelper.addRetryAndDelay(3, 1)).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput> clickLinkTrack(ClickLinkTrackInput clickLinkTrackInput) {
        MessengerInput<ClickLinkTrackInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "clickLinkTrack";
        messengerInput.data = clickLinkTrackInput;
        messengerInput.setGameInput();
        return this.restApiService.clickLinkTrack(AppFavorUtils.usageUrl, messengerInput).timeout(5L, TimeUnit.SECONDS).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<DeleteStoryOutput>> deleteStory(DeleteStoryInput deleteStoryInput) {
        MessengerInput<DeleteStoryInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "deleteStory";
        messengerInput.data = deleteStoryInput;
        messengerInput.api_version = "0";
        return this.restApiService.deleteStory(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<AddStoryOutput>> addStory(AddStoryInput addStoryInput) {
        MessengerInput<AddStoryInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "addStory";
        messengerInput.data = addStoryInput;
        messengerInput.api_version = "0";
        return this.restApiService.addStory(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<GetProfilesStoriesOutput>> getProfilesStories(GetProfilesStoriesInput getProfilesStoriesInput) {
        MessengerInput<GetProfilesStoriesInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getProfilesStories";
        messengerInput.data = getProfilesStoriesInput;
        messengerInput.api_version = "0";
        return this.restApiService.getProfilesStories(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<GetProfilesStoryListOutput>> getProfilesStoryList(GetProfilesStoryListInput getProfilesStoryListInput) {
        MessengerInput<GetProfilesStoryListInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getProfilesStoryList";
        messengerInput.data = getProfilesStoryListInput;
        messengerInput.api_version = "0";
        return this.restApiService.getProfilesStoryList(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<GetStoryIdsOutput>> getStoryIds(GetStoryIdsInput getStoryIdsInput) {
        MessengerInput<GetStoryIdsInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getStoryIds";
        messengerInput.data = getStoryIdsInput;
        messengerInput.api_version = "0";
        return this.restApiService.getStoryIds(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<GetStoryViewersOutput>> getStoryViewers(GetStoryViewersInput getStoryViewersInput) {
        MessengerInput<GetStoryViewersInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getStoryViewers";
        messengerInput.data = getStoryViewersInput;
        messengerInput.api_version = "0";
        return this.restApiService.getStoryViewers(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<AddViewStoryOutput>> addViewStory(AddViewStoryInput addViewStoryInput) {
        MessengerInput<AddViewStoryInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "addViewStory";
        messengerInput.data = addViewStoryInput;
        messengerInput.api_version = "0";
        return this.restApiService.addViewStory(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<GetMyStoryListOutput>> getMyStoryList(GetMyStoryListInput getMyStoryListInput) {
        MessengerInput<GetMyStoryListInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getMyStoriesList";
        messengerInput.data = getMyStoryListInput;
        messengerInput.api_version = "0";
        return this.restApiService.getMyStoryList(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler()).compose(addDecryptor(GetMyStoryListOutput.class, this.auth));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput> addPollAnswer(AddPollAnswerInput addPollAnswerInput) {
        MessengerInput<AddPollAnswerInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "addPollAnswer";
        messengerInput.data = addPollAnswerInput;
        messengerInput.api_version = "0";
        return this.restApiService.addPollAnswer(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.GetProfileListOutput>> getPollResultProfiles(GetPollResultProfilesInput getPollResultProfilesInput) {
        MessengerInput<GetPollResultProfilesInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getPollResultsProfiles";
        messengerInput.data = getPollResultProfilesInput;
        messengerInput.api_version = "0";
        return this.restApiService.getPollResultProfiles(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.GetEmojiResultsOutput>> getEmojiSliderResults(GetEmojiResultsInput getEmojiResultsInput) {
        MessengerInput<GetEmojiResultsInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getEmojiSliderResults";
        messengerInput.data = getEmojiResultsInput;
        messengerInput.api_version = "0";
        return this.restApiService.getEmojiSliderResults(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput> addEmojiSliderAnswer(AddEmojiSliderAnswerInput addEmojiSliderAnswerInput) {
        MessengerInput<AddEmojiSliderAnswerInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "addEmojiSliderAnswer";
        messengerInput.data = addEmojiSliderAnswerInput;
        messengerInput.api_version = "0";
        return this.restApiService.addEmojiSliderAnswer(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<GetStoryOutput>> getStory(GetStoryInput getStoryInput, boolean z) {
        MessengerInput<GetStoryInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getStory";
        messengerInput.data = getStoryInput;
        messengerInput.api_version = "0";
        return this.restApiService.getStory(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(z ? rxHelper.addRetryAndDelay(0, 2) : rxHelper.addRetryAndDelay(0, 2, 3, 5, 10)).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<StorySettingOutput>> setStorySetting(SetStorySettingInput setStorySettingInput) {
        MessengerInput<SetStorySettingInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "setSetting";
        messengerInput.data = setStorySettingInput;
        messengerInput.api_version = "0";
        return this.restApiService.setStorySetting(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<StorySettingOutput>> getStorySetting(GetStorySettingInput getStorySettingInput) {
        MessengerInput<GetStorySettingInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getSetting";
        messengerInput.data = getStorySettingInput;
        messengerInput.api_version = "0";
        return this.restApiService.getStorySetting(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<RubinoRequestUploadFileOutput>> requestSendFileRubino(RubinoRequestUploadFileInput rubinoRequestUploadFileInput) {
        MessengerInput<RubinoRequestUploadFileInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "requestUploadFile";
        rubinoRequestUploadFileInput.setProfileId(this.currentAccount);
        messengerInput.data = rubinoRequestUploadFileInput;
        messengerInput.api_version = "0";
        return this.restApiService.requestSendFileRubino(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler()).compose(addDecryptor(RubinoRequestUploadFileOutput.class, this.auth));
    }

    public Observable<retrofit2.Response<ResponseBody>> getURl(String str) {
        return this.restApiService.getUrl(str).subscribeOn(Schedulers.io()).doOnNext(new Consumer<retrofit2.Response<ResponseBody>>(this) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.15
            @Override // io.reactivex.functions.Consumer
            public void accept(retrofit2.Response<ResponseBody> response) throws Exception {
                if (!response.isSuccessful()) {
                    throw new Exception(response.errorBody().string());
                }
            }
        });
    }

    public Observable<retrofit2.Response<ResponseBody>> getFileRubino(String str, long j, long j2) {
        return this.restApiService.getFileRubino(str, "bytes=" + j + "-" + j2).subscribeOn(Schedulers.io()).doOnNext(new Consumer<retrofit2.Response<ResponseBody>>(this) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.17
            @Override // io.reactivex.functions.Consumer
            public void accept(retrofit2.Response<ResponseBody> response) throws Exception {
                if (!response.isSuccessful()) {
                    throw new Exception(response.errorBody().string());
                }
            }
        }).compose(rxHelper.addRetryAndDelay(0, 1, 2, 2, 2, 3, 5, 5, 5)).doOnNext(new Consumer<retrofit2.Response<ResponseBody>>() { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.16
            @Override // io.reactivex.functions.Consumer
            public void accept(retrofit2.Response<ResponseBody> response) throws Exception {
                String str2;
                if (response.isSuccessful() && (str2 = response.headers().get("content-type")) != null && str2.trim().toLowerCase().contains("application/json")) {
                    try {
                        final MessangerOutput messangerOutput = (MessangerOutput) ApplicationLoader.getGson().fromJson(response.body().string(), MessangerOutput.class);
                        if (messangerOutput != null) {
                            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.16.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        ApiRequestMessangerRx.this.getApiRequestMessangerRx().handleClientShowMessage(messangerOutput);
                                        ApiRequestMessangerRx.this.getApiRequestMessangerRx().handleErrors(messangerOutput);
                                    } catch (Exception unused) {
                                    }
                                }
                            });
                        }
                    } catch (Exception unused) {
                    }
                    throw new ApiServerException(MessangerOutput.EnumStatus.ERROR_GENERIC, MessangerOutput.EnumStatusDet.SERVER_ERROR);
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<InstaGetProfilesOutput>> rubinoSearchProfiles(InstaGetListInput instaGetListInput) {
        MessengerInput<InstaGetListInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "searchProfile";
        messengerInput.data = instaGetListInput;
        messengerInput.api_version = "0";
        return this.restApiService.searchProfile(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.GetProfileListOutput>> rubinoSearchProfiles2(Rubino.GetListInput getListInput) {
        final MessengerInput messengerInput = new MessengerInput(this.auth);
        messengerInput.method = "searchProfile";
        messengerInput.data = getListInput;
        messengerInput.api_version = "0";
        return Observable.timer(400L, TimeUnit.MILLISECONDS).flatMap(new Function<Long, ObservableSource<MessangerOutput<Rubino.GetProfileListOutput>>>() { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.18
            @Override // io.reactivex.functions.Function
            public ObservableSource<MessangerOutput<Rubino.GetProfileListOutput>> apply(Long l) throws Exception {
                return ApiRequestMessangerRx.this.restApiService.searchProfile2(AppFavorUtils.rubinoUrl, messengerInput).compose(ApiRequestMessangerRx.rxHelper.applySchedulers()).compose(ApiRequestMessangerRx.rxHelper.addRegularRetryAndDelay()).compose(ApiRequestMessangerRx.this.addServerErrorHandler());
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.GetProfileListOutput>> rubinoSearchFollowerProfiles(Rubino.GetListInput getListInput) {
        final MessengerInput messengerInput = new MessengerInput(this.auth);
        messengerInput.method = "searchFollower";
        messengerInput.data = getListInput;
        messengerInput.api_version = "0";
        return Observable.timer(400L, TimeUnit.MILLISECONDS).flatMap(new Function<Long, ObservableSource<MessangerOutput<Rubino.GetProfileListOutput>>>() { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.19
            @Override // io.reactivex.functions.Function
            public ObservableSource<MessangerOutput<Rubino.GetProfileListOutput>> apply(Long l) throws Exception {
                return ApiRequestMessangerRx.this.restApiService.searchFollowerProfile(AppFavorUtils.rubinoUrl, messengerInput).compose(ApiRequestMessangerRx.rxHelper.applySchedulers()).compose(ApiRequestMessangerRx.rxHelper.addRegularRetryAndDelay()).compose(ApiRequestMessangerRx.this.addServerErrorHandler());
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<InstaGetHashTagsOutput>> rubinoSearchHashTag(InstaGetListInput instaGetListInput) {
        final MessengerInput messengerInput = new MessengerInput(this.auth);
        messengerInput.method = "searchHashTag";
        messengerInput.data = instaGetListInput;
        messengerInput.api_version = "0";
        return Observable.timer(400L, TimeUnit.MILLISECONDS).flatMap(new Function<Long, ObservableSource<MessangerOutput<InstaGetHashTagsOutput>>>() { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.20
            @Override // io.reactivex.functions.Function
            public ObservableSource<MessangerOutput<InstaGetHashTagsOutput>> apply(Long l) throws Exception {
                return ApiRequestMessangerRx.this.restApiService.searchHashTag(AppFavorUtils.rubinoUrl, messengerInput).compose(ApiRequestMessangerRx.rxHelper.applySchedulers()).compose(ApiRequestMessangerRx.rxHelper.addRegularRetryAndDelay()).compose(ApiRequestMessangerRx.this.addServerErrorHandler());
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.IsExistUsernameOutput>> rubinoIsExistUsername(Rubino.IsExistUsernameInput isExistUsernameInput) {
        MessengerInput<Rubino.IsExistUsernameInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "isExistUsername";
        messengerInput.data = isExistUsernameInput;
        messengerInput.api_version = "0";
        return this.restApiService.rubinoIsExistUsername(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.AddPostOutput>> rubinoAddPost(Rubino.AddPostInput addPostInput) {
        MessengerInput<Rubino.AddPostInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "addPost";
        messengerInput.data = addPostInput;
        messengerInput.api_version = "0";
        return this.restApiService.rubinoAddPost(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.AddPostOutput>> rubinoPublishPost(Rubino.PublishPostInput publishPostInput) {
        MessengerInput<Rubino.PublishPostInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "publishPost";
        messengerInput.data = publishPostInput;
        messengerInput.api_version = "0";
        return this.restApiService.rubinoPublishPost(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput> rubinoAddFilePost(Rubino.AddFilePostInput addFilePostInput) {
        MessengerInput<Rubino.AddFilePostInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "addFilePost";
        messengerInput.data = addFilePostInput;
        messengerInput.api_version = "0";
        return this.restApiService.rubinoAddFilePost(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput> addPostViewCount(Rubino.AddPostViewCountInput addPostViewCountInput) {
        MessengerInput<Rubino.AddPostViewCountInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "addPostViewCount";
        messengerInput.data = addPostViewCountInput;
        messengerInput.api_version = "0";
        return this.restApiService.addPostViewCount(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput> addPostViewTime(Rubino.AddPostViewTimeInput addPostViewTimeInput) {
        MessengerInput<Rubino.AddPostViewTimeInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "addPostViewTime";
        messengerInput.data = addPostViewTimeInput;
        messengerInput.api_version = "0";
        return this.restApiService.addPostViewTime(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<RubinoRequestUploadFileOutput>> rubinoRequestUploadFile(RubinoRequestUploadFileInput rubinoRequestUploadFileInput) {
        MessengerInput<RubinoRequestUploadFileInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "requestUploadFile";
        messengerInput.data = rubinoRequestUploadFileInput;
        messengerInput.api_version = "0";
        return this.restApiService.rubinoRequestUploadFile(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    public Observable<MessangerOutput<RubinoUploadFileOutput>> rubinoUploadFile(String str, byte[] bArr, int i, int i2, String str2, String str3) {
        return this.restApiService.rubinoUploadFile(str, RequestBody.create(MediaType.parse("application/octet-stream"), bArr), i, i2, this.auth, str2, str3).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<RubinoUpdateProfilePhotoOutput>> rubinoUpdateProfilePhoto(RubinoUpdateProfilePhotoInput rubinoUpdateProfilePhotoInput) {
        MessengerInput<RubinoUpdateProfilePhotoInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "updateProfilePhoto";
        messengerInput.data = rubinoUpdateProfilePhotoInput;
        messengerInput.api_version = "0";
        return this.restApiService.rubinoUpdateProfilePhoto(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<LiveModels.RubinoSendLiveOutput>> rubinoSendLive(LiveModels.RubinoSendLiveInput rubinoSendLiveInput) {
        MessengerInput<LiveModels.RubinoSendLiveInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "sendLive";
        messengerInput.data = rubinoSendLiveInput;
        messengerInput.api_version = "0";
        return this.restApiService.rubinoSendLive(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<LiveModels.RubinoStopLiveOutput>> rubinoStopLive(LiveModels.RubinoStopLiveInput rubinoStopLiveInput) {
        MessengerInput<LiveModels.RubinoStopLiveInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "stopLive";
        messengerInput.data = rubinoStopLiveInput;
        messengerInput.api_version = "0";
        return this.restApiService.rubinoStopLive(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<LiveModels.RubinoGetLiveInfoOutput>> rubinoGetLiveInfo(LiveModels.RubinoGetLiveInfolInput rubinoGetLiveInfolInput) {
        MessengerInput<LiveModels.RubinoGetLiveInfolInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getLiveInfo";
        messengerInput.data = rubinoGetLiveInfolInput;
        messengerInput.api_version = "0";
        return this.restApiService.rubinoGetLivePlayUrl(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<LiveModels.RubinoGetLiveViewersOutput>> rubinoGetLiveViewers(LiveModels.RubinoGetLiveViewersInput rubinoGetLiveViewersInput) {
        MessengerInput<LiveModels.RubinoGetLiveViewersInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getLiveViewers";
        messengerInput.data = rubinoGetLiveViewersInput;
        messengerInput.api_version = "0";
        return this.restApiService.rubinoGetLiveViewer(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<LiveModels.RubinoGetLiveStatusOutput>> rubinoGetLiveStatus(LiveModels.RubinoGetLiveStatusInput rubinoGetLiveStatusInput) {
        MessengerInput<LiveModels.RubinoGetLiveStatusInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getLiveStatus";
        messengerInput.data = rubinoGetLiveStatusInput;
        messengerInput.api_version = "0";
        return this.restApiService.rubinoGetLiveStatus(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<LiveModels.AddLiveCommentOutput>> rubinoAddLiveComment(LiveModels.RubinoAddLiveCommentInput rubinoAddLiveCommentInput) {
        MessengerInput<LiveModels.RubinoAddLiveCommentInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "addLiveComment";
        messengerInput.data = rubinoAddLiveCommentInput;
        messengerInput.api_version = "0";
        return this.restApiService.rubinoAddLiveComment(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<LiveModels.GetLiveCommnetsOutput>> rubinoGetLiveComment(int i, LiveModels.RubinoGetLiveCommnetsInput rubinoGetLiveCommnetsInput) {
        MessengerInput<LiveModels.RubinoGetLiveCommnetsInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getLiveComments";
        messengerInput.data = rubinoGetLiveCommnetsInput;
        messengerInput.api_version = "0";
        return this.restApiService.rubinoGetLiveComment(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addInfiniteRetryAndDelay(i)).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<LiveModels.RubinoSetLiveSettingOutput>> rubinoSetLiveSetting(LiveModels.RubinoSetLiveSettingInput rubinoSetLiveSettingInput) {
        MessengerInput<LiveModels.RubinoSetLiveSettingInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "setLiveSetting";
        messengerInput.data = rubinoSetLiveSettingInput;
        messengerInput.api_version = "0";
        return this.restApiService.rubinoSetLiveSetting(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.GetPostsOutput>> getRecentFollowingPosts(Rubino.GetListInput getListInput) {
        MessengerInput<Rubino.GetListInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getRecentFollowingPosts";
        messengerInput.data = getListInput;
        messengerInput.api_version = "0";
        return this.restApiService.getRecentFollowingPosts(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput> likeCommentAction(Rubino.LikeActionInput likeActionInput) {
        MessengerInput<Rubino.LikeActionInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "likeCommentAction";
        messengerInput.data = likeActionInput;
        messengerInput.api_version = "0";
        return this.restApiService.likeCommentAction(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.AddCommentOutput>> rubinoAddComment(Rubino.AddCommentInput addCommentInput) {
        MessengerInput<Rubino.AddCommentInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "addComment";
        messengerInput.data = addCommentInput;
        messengerInput.api_version = "0";
        return this.restApiService.rubinoAddComment(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRetryAndDelay(0, 2, 5, 5, 10, 10, 10, 10, 10, 10)).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.AddCommentOutput>> rubinoAddReplyComment(Rubino.AddCommentInput addCommentInput) {
        MessengerInput<Rubino.AddCommentInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "addReplyComment";
        messengerInput.data = addCommentInput;
        messengerInput.api_version = "0";
        return this.restApiService.rubinoAddReplyComment(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.GetCommentsOutput>> rubinoGetCommentReplies(Rubino.GetListInput getListInput) {
        MessengerInput<Rubino.GetListInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getCommentReplies";
        messengerInput.data = getListInput;
        messengerInput.api_version = "0";
        return this.restApiService.rubinoGetCommentReplies(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.GetCommentsOutput>> rubinoGetComments(Rubino.GetListInput getListInput) {
        MessengerInput<Rubino.GetListInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getComments";
        messengerInput.data = getListInput;
        messengerInput.api_version = "0";
        return this.restApiService.rubinoGetComments(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.GetPostByShareLinkOutput>> getPostByShareLink(Rubino.GetPostByShareLinkInput getPostByShareLinkInput) {
        MessengerInput<Rubino.GetPostByShareLinkInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getPostByShareLink";
        messengerInput.data = getPostByShareLinkInput;
        messengerInput.api_version = "0";
        return this.restApiService.getPostByShareLink(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.GetPostsOutput>> getHashTagPosts(Rubino.GetListInput getListInput) {
        MessengerInput<Rubino.GetListInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getPostsByHashTag";
        messengerInput.data = getListInput;
        messengerInput.api_version = "0";
        return this.restApiService.getHashTagPosts(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.RemoveRecordOutput>> removeRecord(Rubino.RemoveRecordInput removeRecordInput) {
        MessengerInput<Rubino.RemoveRecordInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "removeRecord";
        messengerInput.data = removeRecordInput;
        messengerInput.api_version = "0";
        return this.restApiService.removeRecord(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput> likePostAction(Rubino.LikeActionInput likeActionInput) {
        MessengerInput<Rubino.LikeActionInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "likePostAction";
        messengerInput.data = likeActionInput;
        messengerInput.api_version = "0";
        return this.restApiService.likePostAction(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput> bookmarkPostAction(Rubino.BookmarkActionInput bookmarkActionInput) {
        MessengerInput<Rubino.BookmarkActionInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "postBookmarkAction";
        messengerInput.data = bookmarkActionInput;
        messengerInput.api_version = "0";
        return this.restApiService.bookmarkPostAction(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.GetPostsOutput>> getProfilePosts(Rubino.GetListInput getListInput) {
        MessengerInput<Rubino.GetListInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getProfilePosts";
        messengerInput.data = getListInput;
        messengerInput.api_version = "0";
        return this.restApiService.getProfilePosts(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput> removeNotification(Rubino.RemoveNotificationInput removeNotificationInput) {
        MessengerInput<Rubino.RemoveNotificationInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "removeNotification";
        messengerInput.data = removeNotificationInput;
        messengerInput.api_version = "0";
        return this.restApiService.removeNotification(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.GetNewEventsOutput>> getNewEvents(Rubino.GetListInput getListInput) {
        MessengerInput<Rubino.GetListInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getNewEvents";
        messengerInput.data = getListInput;
        messengerInput.api_version = "0";
        return this.restApiService.getNewEvents(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.GetPostsOutput>> getBookmarkedPosts(Rubino.GetListInput getListInput) {
        MessengerInput<Rubino.GetListInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getBookmarkedPosts";
        messengerInput.data = getListInput;
        messengerInput.api_version = "0";
        return this.restApiService.getBookmarkedPosts(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.EditPostOutput>> editPost(Rubino.EditPostInput editPostInput) {
        MessengerInput<Rubino.EditPostInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "updatePost";
        messengerInput.data = editPostInput;
        messengerInput.api_version = "0";
        return this.restApiService.editPost(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.GetPostsOutput>> getMyProfilePosts(Rubino.GetListInput getListInput) {
        MessengerInput<Rubino.GetListInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getMyProfilePosts";
        messengerInput.data = getListInput;
        messengerInput.api_version = "0";
        return this.restApiService.getMyProfilePosts(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.GetPostsOutput>> getExplorePosts(Rubino.GetListInput getListInput) {
        MessengerInput<Rubino.GetListInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getExplorePosts";
        messengerInput.data = getListInput;
        messengerInput.api_version = "0";
        return this.restApiService.getExplorePosts(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.GetExploreTopicsOutput>> getExplorePostTopics(Rubino.BaseInput baseInput) {
        MessengerInput<Rubino.BaseInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getExplorePostTopics";
        messengerInput.data = baseInput;
        messengerInput.api_version = "0";
        return this.restApiService.getExplorePostTopics(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.GetRelatedExplorePostsOutput>> getRelatedPosts(Rubino.GetListInput getListInput) {
        MessengerInput<Rubino.GetListInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getRelatedExplorePost";
        messengerInput.data = getListInput;
        messengerInput.api_version = "0";
        return this.restApiService.getRelatedExplorePost(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.GetPostsOutput>> getProfilesPostList(Rubino.GetProfilesPostListInput getProfilesPostListInput) {
        MessengerInput<Rubino.GetProfilesPostListInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getProfilesPostList";
        messengerInput.data = getProfilesPostListInput;
        messengerInput.api_version = "0";
        return this.restApiService.getProfilesPostList(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.GetProfileLinkItemsOutput>> getRubinoProfileLinkItems(Rubino.GetProfileLinkItemsInput getProfileLinkItemsInput) {
        MessengerInput<Rubino.GetProfileLinkItemsInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getProfileLinkItems";
        messengerInput.data = getProfileLinkItemsInput;
        messengerInput.api_version = "0";
        return this.restApiService.getRubinoProfileLinkItems(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.GetProfileInfoOutput>> getProfileInfo(Rubino.GetProfileInfoInput getProfileInfoInput) {
        MessengerInput<Rubino.GetProfileInfoInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getProfileInfo";
        messengerInput.data = getProfileInfoInput;
        messengerInput.api_version = "0";
        return this.restApiService.getProfileInfo(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.GetProfileInfoOutput>> getMyProfileInfo(Rubino.GetProfileInfoInput getProfileInfoInput) {
        MessengerInput<Rubino.GetProfileInfoInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getMyProfileInfo";
        messengerInput.data = getProfileInfoInput;
        messengerInput.api_version = "0";
        return this.restApiService.getMyProfileInfo(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.GetPostShareLinkOutput>> getPostShareLink(Rubino.GetPostShareLinkInput getPostShareLinkInput) {
        MessengerInput<Rubino.GetPostShareLinkInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getShareLink";
        messengerInput.data = getPostShareLinkInput;
        messengerInput.api_version = "0";
        return this.restApiService.getPostShareLink(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.GetProfileListOutput>> getMyProfileList(Rubino.GetListInput getListInput) {
        MessengerInput<Rubino.GetListInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getProfileList";
        messengerInput.data = getListInput;
        messengerInput.api_version = "0";
        return this.restApiService.getMyProfileList(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.GetProfileListOutput>> getProfileFollowers(Rubino.GetListInput getListInput) {
        MessengerInput<Rubino.GetListInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getProfileFollowers";
        messengerInput.data = getListInput;
        messengerInput.api_version = "0";
        return this.restApiService.getProfileFollowers(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.GetProfileListOutput>> getBlockedProfiles(Rubino.GetListInput getListInput) {
        MessengerInput<Rubino.GetListInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getBlockedProfiles";
        messengerInput.data = getListInput;
        messengerInput.api_version = "0";
        return this.restApiService.getProfileFollowers(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.GetHashtagListOutput>> rubinoGetHashTagTrend(Rubino.GetListInput getListInput) {
        MessengerInput<Rubino.GetListInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getHashTagTrend";
        messengerInput.data = getListInput;
        messengerInput.api_version = "0";
        return this.restApiService.getHashTagTrend(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.GetHashtagListOutput>> rubinoSearchHashTag2(Rubino.GetListInput getListInput) {
        MessengerInput<Rubino.GetListInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "searchHashTag";
        messengerInput.data = getListInput;
        messengerInput.api_version = "0";
        return this.restApiService.searchHashTag2(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.GetProfileListOutput>> getPostLikeProfiles(Rubino.GetListInput getListInput) {
        MessengerInput<Rubino.GetListInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getPostLikes";
        messengerInput.data = getListInput;
        messengerInput.api_version = "0";
        return this.restApiService.getPostLikes(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.GetProfileListOutput>> getLikedCommentProfiles(Rubino.GetListInput getListInput) {
        MessengerInput<Rubino.GetListInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getLikedCommentProfiles";
        messengerInput.data = getListInput;
        messengerInput.api_version = "0";
        return this.restApiService.getLikedCommentProfiles(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.GetProfileListOutput>> getSuggestedProfiles(Rubino.GetListInput getListInput) {
        MessengerInput<Rubino.GetListInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getSuggested";
        messengerInput.data = getListInput;
        messengerInput.api_version = "0";
        return this.restApiService.getSuggested(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.GetProfileInfoOutput>> createPage(Rubino.CreateProfileInput createProfileInput) {
        MessengerInput<Rubino.CreateProfileInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "createPage";
        messengerInput.data = createProfileInput;
        messengerInput.api_version = "0";
        return this.restApiService.createPage(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.GetFollowRequestsOutput>> getNewFollowRequests(Rubino.GetListInput getListInput) {
        MessengerInput<Rubino.GetListInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getNewFollowRequests";
        messengerInput.data = getListInput;
        messengerInput.api_version = "0";
        return this.restApiService.getNewFollowRequests(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput> actionOnRequest(Rubino.ActionOnRequestInput actionOnRequestInput) {
        MessengerInput<Rubino.ActionOnRequestInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "actionOnRequest";
        messengerInput.data = actionOnRequestInput;
        messengerInput.api_version = "0";
        return this.restApiService.actionOnRequest(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput> rubinoReportRecord(Rubino.ReportInput reportInput) {
        MessengerInput<Rubino.ReportInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "setReportRecord";
        messengerInput.data = reportInput;
        messengerInput.api_version = "0";
        return this.restApiService.rubinoReportRecord(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput> setBlockProfile(Rubino.BlockInput blockInput) {
        MessengerInput<Rubino.BlockInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "setBlockProfile";
        messengerInput.data = blockInput;
        messengerInput.api_version = "0";
        return this.restApiService.setBlockProfile(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput> requestFollow(Rubino.RequestFollowInput requestFollowInput) {
        MessengerInput<Rubino.RequestFollowInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "requestFollow";
        messengerInput.data = requestFollowInput;
        messengerInput.api_version = "0";
        return this.restApiService.requestFollow(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<VodMediaEntityOutput>> getMedia(GetMediaInput getMediaInput) {
        MessengerInput<GetMediaInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getMedia";
        messengerInput.data = getMediaInput;
        messengerInput.setVodInput();
        return this.restApiService.getMedia("https://vod1.iranlms.ir/", messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<GetEpisodesOutput>> getEpisodes(GetEpisodesInput getEpisodesInput) {
        MessengerInput<GetEpisodesInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getSeasonEpisodes";
        messengerInput.data = getEpisodesInput;
        messengerInput.setVodInput();
        return this.restApiService.getEpisodes("https://vod1.iranlms.ir/", messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<GetRelatedOutput>> getRelated(GetRelatedInput getRelatedInput) {
        MessengerInput<GetRelatedInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getRelated";
        messengerInput.data = getRelatedInput;
        messengerInput.setVodInput();
        return this.restApiService.getRelated("https://vod1.iranlms.ir/", messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Completable actionOnMedia(ActionOnMediaInput actionOnMediaInput) {
        MessengerInput<ActionOnMediaInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "actionOnMedia";
        messengerInput.data = actionOnMediaInput;
        messengerInput.setVodInput();
        return this.restApiService.actionOnMedia("https://vod1.iranlms.ir/", messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler()).flatMapCompletable(new Function() { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ApiRequestMessangerRx.lambda$actionOnMedia$1((MessangerOutput) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ CompletableSource lambda$actionOnMedia$1(MessangerOutput messangerOutput) throws Exception {
        return Completable.complete();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<GetCastRelatedOutput>> getCastMedias(GetCastRelatedInput getCastRelatedInput) {
        MessengerInput<GetCastRelatedInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getCastMedias";
        messengerInput.data = getCastRelatedInput;
        messengerInput.setVodInput();
        return this.restApiService.getCastMedias("https://vod1.iranlms.ir/", messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<HomePageModels.GetSectionDetailsOutput>> getSectionDetails(HomePageModels.GetSectionDetailsInput getSectionDetailsInput) {
        MessengerInput<HomePageModels.GetSectionDetailsInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getSectionDetails";
        messengerInput.data = getSectionDetailsInput;
        messengerInput.makeDataV5();
        messengerInput.setHomePageInput();
        return this.restApiService.getSectionDetails(AppFavorUtils.SERVICE_EXTERNAL_URL, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addDecryptorV5(new TypeToken<DataOutputV5<HomePageModels.GetSectionDetailsOutput>>(this) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.22
        }, messengerInput.auth)).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<HomePageModels.GetHomePageOutput>> getHomePage(HomePageModels.GetHomePageInput getHomePageInput) {
        MessengerInput<HomePageModels.GetHomePageInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getHomePage";
        messengerInput.data = getHomePageInput;
        messengerInput.makeDataV5();
        messengerInput.setHomePageInput();
        return this.restApiService.getHomePage(AppFavorUtils.SERVICE_EXTERNAL_URL, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addDecryptorV5(new TypeToken<DataOutputV5<HomePageModels.GetHomePageOutput>>(this) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.23
        }, messengerInput.auth)).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<HomePageModels.SetUserFavoriteServicesOutput>> setUserFavoriteServices(HomePageModels.SetUserFavoriteServicesInput setUserFavoriteServicesInput) {
        MessengerInput<HomePageModels.SetUserFavoriteServicesInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "setUserFavoriteServices";
        messengerInput.data = setUserFavoriteServicesInput;
        messengerInput.makeDataV5();
        messengerInput.setHomePageInput();
        return this.restApiService.setUserFavoriteServices(AppFavorUtils.SERVICE_EXTERNAL_URL, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addDecryptorV5(new TypeToken<DataOutputV5<HomePageModels.SetUserFavoriteServicesOutput>>(this) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.24
        }, messengerInput.auth)).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<HomePageModels.GetLiveSectionItemsOutput>> getLiveSectionItems(HomePageModels.GetLiveSectionItemsInput getLiveSectionItemsInput) {
        MessengerInput<HomePageModels.GetLiveSectionItemsInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getLiveSectionItems";
        messengerInput.data = getLiveSectionItemsInput;
        messengerInput.makeDataV5();
        messengerInput.setHomePageInput();
        return this.restApiService.getLiveSectionItems(AppFavorUtils.SERVICE_EXTERNAL_URL, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addDecryptorV5(new TypeToken<DataOutputV5<HomePageModels.GetLiveSectionItemsOutput>>(this) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.25
        }, messengerInput.auth)).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<HomePageModels.UserPredictionsOutput>> setUserPredictions(HomePageModels.UserPredictionsInput userPredictionsInput) {
        MessengerInput<HomePageModels.UserPredictionsInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "setUserPredictions";
        messengerInput.data = userPredictionsInput;
        messengerInput.makeDataV5();
        messengerInput.setHomePageInput();
        return this.restApiService.setPrediction(AppFavorUtils.SERVICE_EXTERNAL_URL, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addDecryptorV5(new TypeToken<DataOutputV5<HomePageModels.UserPredictionsOutput>>(this) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.26
        }, messengerInput.auth)).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.GetProfileHighlightsOutput>> getProfileHighlights(Rubino.GetListInput getListInput) {
        MessengerInput<Rubino.GetListInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getProfileHighlights";
        messengerInput.data = getListInput;
        messengerInput.api_version = "0";
        return this.restApiService.getProfileHighlights(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.AddHighlightOutput>> addHighlight(Rubino.AddHighlightInput addHighlightInput) {
        MessengerInput<Rubino.AddHighlightInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "addHighlight";
        messengerInput.data = addHighlightInput;
        messengerInput.api_version = "0";
        return this.restApiService.addHighlight(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.EditHighlightOutput>> editHighlight(Rubino.EditHighlightInput editHighlightInput) {
        MessengerInput<Rubino.EditHighlightInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "editHighlight";
        messengerInput.data = editHighlightInput;
        messengerInput.api_version = "0";
        return this.restApiService.editHighlight(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput> removeHighlightCollection(Rubino.RemoveHighlightCollectionInput removeHighlightCollectionInput) {
        MessengerInput<Rubino.RemoveHighlightCollectionInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "removeHighlightCollection";
        messengerInput.data = removeHighlightCollectionInput;
        messengerInput.api_version = "0";
        return this.restApiService.removeHighlightCollection(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput> highlightStory(Rubino.HighlightStoryInput highlightStoryInput) {
        MessengerInput<Rubino.HighlightStoryInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "highlightStory";
        messengerInput.data = highlightStoryInput;
        messengerInput.api_version = "0";
        return this.restApiService.highlightStory(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<GetStoryIdsOutput>> getHighlightStoryIds(Rubino.GetHighlightStoryIdsInput getHighlightStoryIdsInput) {
        MessengerInput<Rubino.GetHighlightStoryIdsInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getHighlightStoryIds";
        messengerInput.data = getHighlightStoryIdsInput;
        messengerInput.api_version = "0";
        return this.restApiService.getHighlightStoryIds(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<GetStoryOutput>> getHighlightStories(Rubino.GetHighlightStoriesInput getHighlightStoriesInput, boolean z) {
        MessengerInput<Rubino.GetHighlightStoriesInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getHighlightStories";
        messengerInput.data = getHighlightStoriesInput;
        messengerInput.api_version = "0";
        return this.restApiService.getHighlightStories(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(z ? rxHelper.addRetryAndDelay(0, 2) : rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.GetMyArchiveStoriesOutput>> getMyArchiveStories(Rubino.GetListInput getListInput) {
        MessengerInput<Rubino.GetListInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getMyArchiveStories";
        messengerInput.data = getListInput;
        messengerInput.api_version = "0";
        return this.restApiService.getMyArchiveStories(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<ShopModels.GetProductCategoriesOutput>> getProductCategories(ShopModels.EmptyInput emptyInput) {
        MessengerInput<ShopModels.EmptyInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getProductCategories";
        messengerInput.data = emptyInput;
        messengerInput.makeDataV5();
        messengerInput.setShopInput();
        return this.restApiService.getProductCategories(AppFavorUtils.shopUrl, messengerInput).compose(rxHelper.addRegularRetryAndDelay()).compose(addDecryptorV5(new TypeToken<DataOutputV5<ShopModels.GetProductCategoriesOutput>>(this) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.29
        }, messengerInput.auth)).compose(rxHelper.applySchedulers()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<ShopModels.GetColorsOutput>> getColorsShop(ShopModels.EmptyInput emptyInput) {
        MessengerInput<ShopModels.EmptyInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getColors";
        messengerInput.data = emptyInput;
        messengerInput.makeDataV5();
        messengerInput.setShopInput();
        return this.restApiService.getColors(AppFavorUtils.shopUrl, messengerInput).compose(rxHelper.addRegularRetryAndDelay()).compose(addDecryptorV5(new TypeToken<DataOutputV5<ShopModels.GetColorsOutput>>(this) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.30
        }, messengerInput.auth)).compose(rxHelper.applySchedulers()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<ShopModels.AddProductOutput>> addProduct(ShopModels.AddProductInput addProductInput) {
        MessengerInput<ShopModels.AddProductInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "addProduct";
        messengerInput.data = addProductInput;
        messengerInput.makeDataV5();
        messengerInput.setShopInput();
        return this.restApiService.addProduct(AppFavorUtils.shopUrl, messengerInput).compose(rxHelper.addRegularRetryAndDelay()).compose(addDecryptorV5(new TypeToken<DataOutputV5<ShopModels.AddProductOutput>>(this) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.31
        }, messengerInput.auth)).compose(rxHelper.applySchedulers()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<ShopModels.AddProductOutput>> editProduct(ShopModels.EditProductInput editProductInput) {
        MessengerInput<ShopModels.EditProductInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "editProduct";
        messengerInput.data = editProductInput;
        messengerInput.makeDataV5();
        messengerInput.setShopInput();
        return this.restApiService.editProduct(AppFavorUtils.shopUrl, messengerInput).compose(rxHelper.addRegularRetryAndDelay()).compose(addDecryptorV5(new TypeToken<DataOutputV5<ShopModels.AddProductOutput>>(this) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.32
        }, messengerInput.auth)).compose(rxHelper.applySchedulers()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<ShopModels.DeleteProductOutput>> deleteProduct(ShopModels.DeleteProductInput deleteProductInput) {
        MessengerInput<ShopModels.DeleteProductInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "deleteProduct";
        messengerInput.data = deleteProductInput;
        messengerInput.makeDataV5();
        messengerInput.setShopInput();
        return this.restApiService.deleteProduct(AppFavorUtils.shopUrl, messengerInput).compose(rxHelper.addRegularRetryAndDelay()).compose(addDecryptorV5(new TypeToken<DataOutputV5<ShopModels.DeleteProductOutput>>(this) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.33
        }, messengerInput.auth)).compose(rxHelper.applySchedulers()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<ShopModels.ShopRequestUploadFileOutput>> shopRequestUploadFile(ShopModels.ShopRequestUploadFileInput shopRequestUploadFileInput) {
        MessengerInput<ShopModels.ShopRequestUploadFileInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "requestUploadFile";
        messengerInput.data = shopRequestUploadFileInput;
        messengerInput.makeDataV5();
        messengerInput.setShopInput();
        return this.restApiService.shopRequestSendFile(AppFavorUtils.shopUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addDecryptorV5(new TypeToken<DataOutputV5<ShopModels.ShopRequestUploadFileOutput>>(this) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.34
        }, messengerInput.auth)).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<GetProductsOutput>> getProducts(GetProductsInput getProductsInput) {
        MessengerInput<GetProductsInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getProducts";
        messengerInput.data = getProductsInput;
        messengerInput.makeDataV5();
        messengerInput.setShopInput();
        return this.restApiService.getProducts(AppFavorUtils.shopUrl, messengerInput).compose(rxHelper.addRegularRetryAndDelay()).compose(addDecryptorV5(new TypeToken<DataOutputV5<GetProductsOutput>>(this) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.35
        }, messengerInput.auth)).compose(rxHelper.applySchedulers()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<GetStoreDetailOutput>> getStoreDetail(GetStoreDetailInput getStoreDetailInput) {
        MessengerInput<GetStoreDetailInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getStoreDetail";
        messengerInput.data = getStoreDetailInput;
        messengerInput.makeDataV5();
        messengerInput.setShopInput();
        return this.restApiService.getStoreDetail(AppFavorUtils.shopUrl, messengerInput).compose(rxHelper.addRegularRetryAndDelay()).compose(addDecryptorV5(new TypeToken<DataOutputV5<GetStoreDetailOutput>>(this) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.36
        }, messengerInput.auth)).compose(rxHelper.applySchedulers()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<GetProductDetailOutput>> getProductDetail(GetProductDetailInput getProductDetailInput) {
        MessengerInput<GetProductDetailInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getProductDetail";
        messengerInput.data = getProductDetailInput;
        messengerInput.makeDataV5();
        messengerInput.setShopInput();
        return this.restApiService.getProductDetail(AppFavorUtils.shopUrl, messengerInput).compose(rxHelper.addRegularRetryAndDelay()).compose(addDecryptorV5(new TypeToken<DataOutputV5<GetProductDetailOutput>>(this) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.37
        }, messengerInput.auth)).compose(rxHelper.applySchedulers()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<ShopModels.GetPostLinkedProductsOutput>> getPostLinkedProducts(ShopModels.GetPostLinkedProductsInput getPostLinkedProductsInput) {
        MessengerInput<ShopModels.GetPostLinkedProductsInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getPostLinkedProducts";
        messengerInput.data = getPostLinkedProductsInput;
        messengerInput.makeDataV5();
        messengerInput.setShopInput();
        return this.restApiService.getPostLinkedProducts(AppFavorUtils.shopUrl, messengerInput).compose(rxHelper.addRegularRetryAndDelay()).compose(addDecryptorV5(new TypeToken<DataOutputV5<ShopModels.GetPostLinkedProductsOutput>>(this) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.39
        }, messengerInput.auth)).compose(rxHelper.applySchedulers()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.SetPostProductsOutput>> setPostProducts(Rubino.SetPostProductsInput setPostProductsInput) {
        MessengerInput<Rubino.SetPostProductsInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "setPostProducts";
        messengerInput.data = setPostProductsInput;
        messengerInput.setShopInput();
        return this.restApiService.setPostProducts(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.addRegularRetryAndDelay()).compose(rxHelper.applySchedulers()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<ShopModels.GetProductMessageLinkOutput>> getProductMessageLink(ShopModels.GetProductMessageLinkInput getProductMessageLinkInput) {
        MessengerInput<ShopModels.GetProductMessageLinkInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getProductMessageLink";
        messengerInput.data = getProductMessageLinkInput;
        messengerInput.makeDataV5();
        messengerInput.setShopInput();
        return this.restApiService.getProductMessageLink(AppFavorUtils.shopUrl, messengerInput).compose(rxHelper.addRegularRetryAndDelay()).compose(addDecryptorV5(new TypeToken<DataOutputV5<ShopModels.GetProductMessageLinkOutput>>(this) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.40
        }, messengerInput.auth)).compose(rxHelper.applySchedulers()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.GetPostsOutput>> getTaggedPosts(Rubino.GetListInput getListInput) {
        MessengerInput<Rubino.GetListInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getTaggedPosts";
        messengerInput.data = getListInput;
        messengerInput.api_version = "0";
        return this.restApiService.getTaggedPosts(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.GetProfileForTagListOutput>> rubinoSearchProfilesForTag(Rubino.GetProfileForTagListInput getProfileForTagListInput) {
        final MessengerInput messengerInput = new MessengerInput(this.auth);
        messengerInput.method = "searchProfilesForTag";
        messengerInput.data = getProfileForTagListInput;
        messengerInput.api_version = "0";
        return Observable.timer(400L, TimeUnit.MILLISECONDS).flatMap(new Function<Long, ObservableSource<MessangerOutput<Rubino.GetProfileForTagListOutput>>>() { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.41
            @Override // io.reactivex.functions.Function
            public ObservableSource<MessangerOutput<Rubino.GetProfileForTagListOutput>> apply(Long l) throws Exception {
                return ApiRequestMessangerRx.this.restApiService.searchProfilesForTag(AppFavorUtils.rubinoUrl, messengerInput).compose(ApiRequestMessangerRx.rxHelper.applySchedulers()).compose(ApiRequestMessangerRx.rxHelper.addRegularRetryAndDelay()).compose(ApiRequestMessangerRx.this.addServerErrorHandler());
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<Rubino.GetProfileListOutput>> getProfileByIds(Rubino.GetProfileByIdsInput getProfileByIdsInput) {
        MessengerInput<Rubino.GetProfileByIdsInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getProfileByIds";
        messengerInput.data = getProfileByIdsInput;
        messengerInput.api_version = "0";
        return this.restApiService.getProfileByIds(AppFavorUtils.rubinoUrl, messengerInput).compose(rxHelper.applySchedulers()).compose(rxHelper.addRegularRetryAndDelay()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<ChargeWalletByTokenOutput>> chargeWalletByToken(ChargeWalletByTokenInput chargeWalletByTokenInput) {
        MessengerInput<ChargeWalletByTokenInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "chargeWalletByToken";
        messengerInput.data = chargeWalletByTokenInput;
        messengerInput.makeDataV5();
        messengerInput.setWalletInput();
        return this.restApiService.chargeWalletByToken(AppFavorUtils.walletUrl, messengerInput).compose(rxHelper.addRegularRetryAndDelay()).compose(addDecryptorV5(new TypeToken<DataOutputV5<ChargeWalletByTokenOutput>>(this) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.42
        }, messengerInput.auth)).compose(rxHelper.applySchedulers()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<GetWalletStatusOutput>> getWalletStatus(GetWalletStatusInput getWalletStatusInput) {
        MessengerInput<GetWalletStatusInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getWalletStatus";
        messengerInput.data = getWalletStatusInput;
        messengerInput.makeDataV5();
        messengerInput.setWalletInput();
        return this.restApiService.getWalletStatus(AppFavorUtils.walletUrl, messengerInput).compose(rxHelper.addRegularRetryAndDelay()).compose(addDecryptorV5(new TypeToken<DataOutputV5<GetWalletStatusOutput>>(this) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.43
        }, messengerInput.auth)).compose(rxHelper.applySchedulers()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<CheckAllowReceiveOutput>> checkAllowReceive(CheckAllowReceiveInput checkAllowReceiveInput) {
        MessengerInput<CheckAllowReceiveInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "checkAllowReceive";
        messengerInput.data = checkAllowReceiveInput;
        messengerInput.makeDataV5();
        messengerInput.setWalletInput();
        return this.restApiService.checkAllowReceive(AppFavorUtils.walletUrl, messengerInput).compose(rxHelper.addRegularRetryAndDelay()).compose(addDecryptorV5(new TypeToken<DataOutputV5<CheckAllowReceiveOutput>>(this) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.44
        }, messengerInput.auth)).compose(rxHelper.applySchedulers()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<TransferCreditOutput>> transferCredit(TransferCreditInput transferCreditInput) {
        MessengerInput<TransferCreditInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "transferCredit";
        messengerInput.data = transferCreditInput;
        messengerInput.makeDataV5();
        messengerInput.setWalletInput();
        return this.restApiService.transferCredit(AppFavorUtils.walletUrl, messengerInput).compose(rxHelper.addRegularRetryAndDelay()).compose(addDecryptorV5(new TypeToken<DataOutputV5<TransferCreditOutput>>(this) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.45
        }, messengerInput.auth)).compose(rxHelper.applySchedulers()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<GetWalletTransactionsOutput>> getWalletTransactions(GetWalletTransactionsInput getWalletTransactionsInput) {
        MessengerInput<GetWalletTransactionsInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getWalletTransactions";
        messengerInput.data = getWalletTransactionsInput;
        messengerInput.makeDataV5();
        messengerInput.setWalletInput();
        return this.restApiService.getWalletTransactions(AppFavorUtils.walletUrl, messengerInput).compose(rxHelper.addRegularRetryAndDelay()).compose(addDecryptorV5(new TypeToken<DataOutputV5<GetWalletTransactionsOutput>>(this) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.46
        }, messengerInput.auth)).compose(rxHelper.applySchedulers()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<CashOutOutput>> cashOut(CashOutInput cashOutInput) {
        MessengerInput<CashOutInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "cashOut";
        messengerInput.data = cashOutInput;
        messengerInput.makeDataV5();
        messengerInput.setWalletInput();
        return this.restApiService.cashOut(AppFavorUtils.walletUrl, messengerInput).compose(rxHelper.addRegularRetryAndDelay()).compose(addDecryptorV5(new TypeToken<DataOutputV5<CashOutOutput>>(this) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.47
        }, messengerInput.auth)).compose(rxHelper.applySchedulers()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<GetCurrenciesOutput>> getCurrencies(GetCurrenciesInput getCurrenciesInput) {
        MessengerInput<GetCurrenciesInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getCurrencies";
        messengerInput.data = getCurrenciesInput;
        messengerInput.makeDataV5();
        messengerInput.setWalletInput();
        return this.restApiService.getCurrencies(AppFavorUtils.walletUrl, messengerInput).compose(rxHelper.addRegularRetryAndDelay()).compose(addDecryptorV5(new TypeToken<DataOutputV5<GetCurrenciesOutput>>(this) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.48
        }, messengerInput.auth)).compose(rxHelper.applySchedulers()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<GetWalletShareLinkOutput>> getWalletShareLink(GetWalletShareLinkInput getWalletShareLinkInput) {
        MessengerInput<GetWalletShareLinkInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getWalletShareLink";
        messengerInput.data = getWalletShareLinkInput;
        messengerInput.makeDataV5();
        messengerInput.setWalletInput();
        return this.restApiService.getWalletShareLink(AppFavorUtils.walletUrl, messengerInput).compose(rxHelper.addRegularRetryAndDelay()).compose(addDecryptorV5(new TypeToken<DataOutputV5<GetWalletShareLinkOutput>>(this) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.49
        }, messengerInput.auth)).compose(rxHelper.applySchedulers()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<GetWalletByShareLinkOutput>> getWalletByShareLink(GetWalletByShareLinkInput getWalletByShareLinkInput) {
        MessengerInput<GetWalletByShareLinkInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getWalletByShareLink";
        messengerInput.data = getWalletByShareLinkInput;
        messengerInput.makeDataV5();
        messengerInput.setWalletInput();
        return this.restApiService.getWalletByShareLink(AppFavorUtils.walletUrl, messengerInput).compose(rxHelper.addRegularRetryAndDelay()).compose(addDecryptorV5(new TypeToken<DataOutputV5<GetWalletByShareLinkOutput>>(this) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.50
        }, messengerInput.auth)).compose(rxHelper.applySchedulers()).compose(addServerErrorHandler());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Observable<MessangerOutput<ChargeWalletByUrlOutput>> chargeWalletByUrl(ChargeWalletByUrlInput chargeWalletByUrlInput) {
        MessengerInput<ChargeWalletByUrlInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "chargeWalletByUrl";
        messengerInput.data = chargeWalletByUrlInput;
        messengerInput.makeDataV5();
        messengerInput.setWalletInput();
        return this.restApiService.chargeWalletByUrl(AppFavorUtils.walletUrl, messengerInput).compose(rxHelper.addRegularRetryAndDelay()).compose(addDecryptorV5(new TypeToken<DataOutputV5<ChargeWalletByUrlOutput>>(this) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx.51
        }, messengerInput.auth)).compose(rxHelper.applySchedulers()).compose(addServerErrorHandler());
    }
}
