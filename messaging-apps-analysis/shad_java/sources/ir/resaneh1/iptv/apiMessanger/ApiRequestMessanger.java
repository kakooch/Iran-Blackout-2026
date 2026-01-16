package ir.resaneh1.iptv.apiMessanger;

import androidMessenger.asemannotification.AsemanNotificationService;
import androidMessenger.utilites.AppFavorUtils;
import com.facebook.stetho.common.Utf8Charset;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.facebook.stetho.server.http.HttpHeaders;
import com.google.firebase.messaging.FirebaseMessaging;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.appp.messenger.SendPostHelper;
import ir.resaneh1.iptv.apiIPTV.CallbackWithRetry;
import ir.resaneh1.iptv.apiIPTV.FaildRequestHandler;
import ir.resaneh1.iptv.appUpdate.UpdateUtils;
import ir.resaneh1.iptv.helper.CacheDatabaseHelper;
import ir.resaneh1.iptv.helper.SendStoryHelper;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.messanger.DataCenterManager;
import ir.resaneh1.iptv.messanger.RubikaNotificationManager;
import ir.resaneh1.iptv.model.AddDeliveryInfoInput;
import ir.resaneh1.iptv.model.AddDeliveryInfoOutput;
import ir.resaneh1.iptv.model.ApiCacheObject;
import ir.resaneh1.iptv.model.ApplyOrderDiscountCodeInput;
import ir.resaneh1.iptv.model.ApplyOrderDiscountCodeOutput;
import ir.resaneh1.iptv.model.ConfirmPaymentInput;
import ir.resaneh1.iptv.model.ConfirmPaymentOutput;
import ir.resaneh1.iptv.model.CreateBasketOrderInput;
import ir.resaneh1.iptv.model.CreateBasketOrderOutput;
import ir.resaneh1.iptv.model.DropBasketInput;
import ir.resaneh1.iptv.model.EmptyInputObject;
import ir.resaneh1.iptv.model.GetAllDeliveryInfoOutput;
import ir.resaneh1.iptv.model.GetBarcodeActionInput;
import ir.resaneh1.iptv.model.GetBarcodeActionOutput;
import ir.resaneh1.iptv.model.GetBasketInput;
import ir.resaneh1.iptv.model.GetBasketListOutput;
import ir.resaneh1.iptv.model.GetBasketOutput;
import ir.resaneh1.iptv.model.GetBasketStatusOutput;
import ir.resaneh1.iptv.model.GetCommentsOutput;
import ir.resaneh1.iptv.model.GetDefaultDeliveryInfoOutput;
import ir.resaneh1.iptv.model.GetDeliverCityInput;
import ir.resaneh1.iptv.model.GetDeliverCityOutput;
import ir.resaneh1.iptv.model.GetDeliverProvinceOutput;
import ir.resaneh1.iptv.model.GetDeliveryTimesInput;
import ir.resaneh1.iptv.model.GetDeliveryTimesOutput;
import ir.resaneh1.iptv.model.GetDeliveryTypeOutput;
import ir.resaneh1.iptv.model.GetDeliveryTypesInput;
import ir.resaneh1.iptv.model.GetListInputByStartId;
import ir.resaneh1.iptv.model.GetOrderPaymentInfoInput;
import ir.resaneh1.iptv.model.GetOrderPaymentInfoOutput;
import ir.resaneh1.iptv.model.GetPaidOrdersOutput;
import ir.resaneh1.iptv.model.GetPaymentOptionInput;
import ir.resaneh1.iptv.model.GetPaymentOptionOutput;
import ir.resaneh1.iptv.model.GetRubikaPaymentOptionInput;
import ir.resaneh1.iptv.model.GetRubikaPaymentOptionOutput;
import ir.resaneh1.iptv.model.GetSearchStructureOutput;
import ir.resaneh1.iptv.model.GetTagListInput;
import ir.resaneh1.iptv.model.GetTagListOutput;
import ir.resaneh1.iptv.model.GetTagObjectsOutput;
import ir.resaneh1.iptv.model.GetTileInput;
import ir.resaneh1.iptv.model.GetTileOutput;
import ir.resaneh1.iptv.model.GetWebAppFunctionInput;
import ir.resaneh1.iptv.model.InataAddPostOutput;
import ir.resaneh1.iptv.model.InstaActionOnRequestInput;
import ir.resaneh1.iptv.model.InstaAddPostInput;
import ir.resaneh1.iptv.model.InstaGetCommentsOutput;
import ir.resaneh1.iptv.model.InstaGetHashTagPostsOutput;
import ir.resaneh1.iptv.model.InstaGetHashTagsOutput;
import ir.resaneh1.iptv.model.InstaGetListInput;
import ir.resaneh1.iptv.model.InstaGetNewEventsOutput;
import ir.resaneh1.iptv.model.InstaGetPostSaleListOutput;
import ir.resaneh1.iptv.model.InstaGetPostsOutput;
import ir.resaneh1.iptv.model.InstaGetProfileInfoInput;
import ir.resaneh1.iptv.model.InstaGetProfileInfoOutput;
import ir.resaneh1.iptv.model.InstaGetProfilesOutput;
import ir.resaneh1.iptv.model.InstaGetPurchaseListOutput;
import ir.resaneh1.iptv.model.InstaGetRelatedExplorePostsOutput;
import ir.resaneh1.iptv.model.InstaGetRelatedProfilesOutput;
import ir.resaneh1.iptv.model.InstaGetSaleListOutput;
import ir.resaneh1.iptv.model.InstaGetTopProfilesInput;
import ir.resaneh1.iptv.model.InstaRemoveNotificationInput;
import ir.resaneh1.iptv.model.InstaReportInput;
import ir.resaneh1.iptv.model.InstaRequestFollowInput;
import ir.resaneh1.iptv.model.InstaSendFileErrorInput;
import ir.resaneh1.iptv.model.InstaSetBlockProfileInput;
import ir.resaneh1.iptv.model.InstaSetReadInput;
import ir.resaneh1.iptv.model.InstaUpdateProfileInput;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.MessengerInput;
import ir.resaneh1.iptv.model.RemoveDeliveryInfoInput;
import ir.resaneh1.iptv.model.RequestSendFileMiniFunctionInput;
import ir.resaneh1.iptv.model.RequestSendFileMiniFunctionOutput;
import ir.resaneh1.iptv.model.RubinoAddFilePostInput;
import ir.resaneh1.iptv.model.RubinoPublishPostInput;
import ir.resaneh1.iptv.model.RubinoPublishPostOutput;
import ir.resaneh1.iptv.model.RubinoRequestUploadFileInput;
import ir.resaneh1.iptv.model.RubinoRequestUploadFileOutput;
import ir.resaneh1.iptv.model.RubinoUpdateProfilePhotoInput;
import ir.resaneh1.iptv.model.RubinoUploadFileOutput;
import ir.resaneh1.iptv.model.SearchQueryInput;
import ir.resaneh1.iptv.model.SearchQueryOutput;
import ir.resaneh1.iptv.model.SendFileMiniFunctionOutput;
import ir.resaneh1.iptv.model.SendFileOutput;
import ir.resaneh1.iptv.model.SetBasketItemCountInput;
import ir.resaneh1.iptv.model.SetBasketItemCountOutput;
import ir.resaneh1.iptv.model.WebAppChangeUserTokenInput;
import ir.resaneh1.iptv.model.WebAppChangeUserTokenOutput;
import ir.resaneh1.iptv.model.WebAppObject;
import java.io.IOException;
import java.nio.charset.Charset;
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
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.BaseController;
import org.rbmain.messenger.Utilities;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* loaded from: classes3.dex */
public class ApiRequestMessanger extends BaseController {
    private static RestApiMessanger restApiService;
    public String auth;
    private static final Charset UTF8 = Charset.forName(Utf8Charset.NAME);
    private static volatile ApiRequestMessanger[] Instance = new ApiRequestMessanger[3];

    public interface Listener {
        void onError(MessangerOutput messangerOutput);

        void onFailure(Call call, Throwable th);

        void onResponse(Call call, Object obj);
    }

    public interface Listener2 extends Listener {
        void onFailure(CallbackWithRetry callbackWithRetry, Throwable th);
    }

    public static ApiRequestMessanger getInstance(int i) {
        ApiRequestMessanger apiRequestMessanger = Instance[i];
        if (apiRequestMessanger == null) {
            synchronized (ApiRequestMessanger.class) {
                apiRequestMessanger = Instance[i];
                if (apiRequestMessanger == null) {
                    ApiRequestMessanger[] apiRequestMessangerArr = Instance;
                    ApiRequestMessanger apiRequestMessanger2 = new ApiRequestMessanger(i);
                    apiRequestMessangerArr[i] = apiRequestMessanger2;
                    apiRequestMessanger = apiRequestMessanger2;
                }
            }
        }
        if (apiRequestMessanger.auth.length() == 0) {
            apiRequestMessanger.auth = apiRequestMessanger.getAppPreferences().getAuth();
        }
        return apiRequestMessanger;
    }

    public ApiRequestMessanger(int i) {
        super(i);
        this.auth = BuildConfig.FLAVOR;
        setRestApiService();
    }

    private RestApiMessanger getRestApiService() {
        return restApiService;
    }

    boolean canCache(String str) {
        if (str.trim().equals(AppFavorUtils.rubinoUrl.trim())) {
            return false;
        }
        if (str.trim().equals(AppFavorUtils.rubinoUrl.trim() + "/") || str.trim().equals(DataCenterManager.getInstance().getApiUrl().trim())) {
            return false;
        }
        String strTrim = str.trim();
        StringBuilder sb = new StringBuilder();
        sb.append(DataCenterManager.getInstance().getApiUrl().trim());
        sb.append("/");
        return !strTrim.equals(sb.toString());
    }

    public void setRestApiService() {
        HttpLoggingMessanger httpLoggingMessanger = new HttpLoggingMessanger(this.currentAccount);
        if (MyLog.isDebugAble) {
            httpLoggingMessanger.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            httpLoggingMessanger.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        OkHttpClient.Builder builderAddNetworkInterceptor = new OkHttpClient.Builder().addInterceptor(new Interceptor() { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.1
            @Override // okhttp3.Interceptor
            public Response intercept(Interceptor.Chain chain) throws IOException {
                ApiCacheObject apiCache;
                String str;
                IOException iOException;
                Response responseProceed;
                String str2;
                Request requestBuild = chain.request().newBuilder().addHeader(HttpHeaders.CONTENT_TYPE, "application/json").build();
                CacheDatabaseHelper cacheDatabaseHelper = CacheDatabaseHelper.getInstance(((BaseController) ApiRequestMessanger.this).currentAccount);
                String appVersion = UpdateUtils.getAppVersion(ApplicationLoader.applicationContext);
                Buffer buffer = new Buffer();
                if (requestBuild.body() != null) {
                    requestBuild.body().writeTo(buffer);
                }
                Charset charset = ApiRequestMessanger.UTF8;
                String str3 = null;
                MediaType mediaTypeContentType = requestBuild.body() != null ? requestBuild.body().contentType() : null;
                boolean zCanCache = ApiRequestMessanger.this.canCache(requestBuild.url().toString());
                if (mediaTypeContentType == null || mediaTypeContentType.subtype() == null || !mediaTypeContentType.subtype().equals("json")) {
                    apiCache = null;
                    str = BuildConfig.FLAVOR;
                } else {
                    charset = mediaTypeContentType.charset(ApiRequestMessanger.UTF8);
                    String string = buffer.readString(charset);
                    if (zCanCache) {
                        try {
                            apiCache = cacheDatabaseHelper.getApiCache("-", string, appVersion);
                        } catch (Exception unused) {
                            str = string;
                            apiCache = null;
                        }
                    } else {
                        apiCache = null;
                    }
                    str = string;
                }
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
                    DataCenterManager.getInstance().increastApiCouner();
                    ApiRequestMessanger.this.setRestApiService();
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
                    String string2 = bufferedSourceSource.buffer().clone().readString(charset);
                    try {
                        str3 = ((MessangerOutput) ApplicationLoader.getGson().fromJson(string2, MessangerOutput.class)).cache;
                    } catch (Exception unused2) {
                    }
                    Long lValueOf = 0L;
                    if (str3 != null) {
                        try {
                            lValueOf = Long.valueOf(Long.parseLong(str3));
                        } catch (Exception unused3) {
                        }
                        cacheDatabaseHelper.addOrUpdateApiCache(new ApiCacheObject("-", str, appVersion, string2, Long.valueOf(System.currentTimeMillis() + (lValueOf.longValue() * 1000))));
                    }
                }
                return responseProceed;
            }
        }).addInterceptor(httpLoggingMessanger).addNetworkInterceptor(new StethoInterceptor());
        TimeUnit timeUnit = TimeUnit.SECONDS;
        restApiService = (RestApiMessanger) new Retrofit.Builder().baseUrl(DataCenterManager.getInstance().getApiUrl()).addConverterFactory(GsonConverterFactory.create()).client(builderAddNetworkInterceptor.connectTimeout(20L, timeUnit).readTimeout(25L, timeUnit).writeTimeout(25L, timeUnit).build()).build().create(RestApiMessanger.class);
    }

    private class HandlingResponse {
        public Call call;
        public CallbackWithRetry callbackWithRetry;
        public retrofit2.Response response;

        public HandlingResponse(ApiRequestMessanger apiRequestMessanger, Call call, retrofit2.Response response, CallbackWithRetry callbackWithRetry) {
            this.call = call;
            this.response = response;
            this.callbackWithRetry = callbackWithRetry;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlingOnResponse(HandlingResponse handlingResponse, Listener listener) {
        if (ApplicationLoader.applicationContext != null && !handlingResponse.response.isSuccessful()) {
            listener.onFailure(handlingResponse.call, null);
            if (FaildRequestHandler.isConnectedToInternet(ApplicationLoader.applicationContext)) {
                FaildRequestHandler.getInstance().ShowServerProblemDialog(ApplicationLoader.applicationContext, handlingResponse.callbackWithRetry);
                return;
            } else {
                FaildRequestHandler.getInstance().ShowNetwrokConnectionProblemDialog(ApplicationLoader.applicationContext, handlingResponse.callbackWithRetry);
                return;
            }
        }
        MessangerOutput messangerOutput = (MessangerOutput) handlingResponse.response.body();
        getApiRequestMessangerRx().handleClientShowMessage(messangerOutput);
        if (messangerOutput != null && messangerOutput.status == MessangerOutput.EnumStatus.OK) {
            listener.onResponse(handlingResponse.call, messangerOutput.data);
        } else {
            getApiRequestMessangerRx().handleErrors(messangerOutput);
            listener.onError(messangerOutput);
        }
    }

    public void localLogout() {
        this.auth = BuildConfig.FLAVOR;
        Utilities.myQueue.postRunnable(new Runnable(this) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    FirebaseMessaging.getInstance().deleteToken();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        getRubinoController().clear();
        getStoryController().clear();
        SendStoryHelper.getInstance(this.currentAccount).clear();
        SendPostHelper.getInstance(this.currentAccount).clear();
        getAppPreferences().clearUserData();
        CacheDatabaseHelper.getInstance(this.currentAccount).removeAll();
        RubikaNotificationManager.getInstance(this.currentAccount).clearNotification();
        getNotificationsController().cancelAllNotifications();
        try {
            AsemanNotificationService asemanNotificationService = AsemanNotificationService.instance;
            if (asemanNotificationService != null) {
                asemanNotificationService.destroyService();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<RubinoPublishPostOutput>> rubinoPublishPost(RubinoPublishPostInput rubinoPublishPostInput, final Listener listener) {
        MessengerInput<RubinoPublishPostInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "publishPost";
        messengerInput.data = rubinoPublishPostInput;
        messengerInput.api_version = "0";
        Call<MessangerOutput<RubinoPublishPostOutput>> callRubinoPublishPost = getRestApiService().rubinoPublishPost(AppFavorUtils.rubinoUrl, messengerInput);
        callRubinoPublishPost.enqueue(new CallbackWithRetry<MessangerOutput<RubinoPublishPostOutput>>(callRubinoPublishPost) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.5
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<RubinoPublishPostOutput>> call, retrofit2.Response<MessangerOutput<RubinoPublishPostOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<RubinoPublishPostOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callRubinoPublishPost;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<InstaGetHashTagPostsOutput>> instaGetHashTagPosts(InstaGetListInput instaGetListInput, final Listener listener) {
        MessengerInput<InstaGetListInput> messengerInput = new MessengerInput<>(this.auth);
        instaGetListInput.setProfileId(this.currentAccount);
        messengerInput.method = "getHashTagPosts";
        messengerInput.data = instaGetListInput;
        messengerInput.api_version = "0";
        Call<MessangerOutput<InstaGetHashTagPostsOutput>> callInstaGetHashTagPosts = getRestApiService().instaGetHashTagPosts(AppFavorUtils.rubinoUrl, messengerInput);
        callInstaGetHashTagPosts.enqueue(new CallbackWithRetry<MessangerOutput<InstaGetHashTagPostsOutput>>(callInstaGetHashTagPosts) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.6
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<InstaGetHashTagPostsOutput>> call, retrofit2.Response<MessangerOutput<InstaGetHashTagPostsOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<InstaGetHashTagPostsOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callInstaGetHashTagPosts;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput> rubinoAddFilePost(RubinoAddFilePostInput rubinoAddFilePostInput, final Listener listener) {
        MessengerInput<RubinoAddFilePostInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "addFilePost";
        messengerInput.data = rubinoAddFilePostInput;
        messengerInput.api_version = "0";
        Call<MessangerOutput> callRubinoAddFilePost = getRestApiService().rubinoAddFilePost(AppFavorUtils.rubinoUrl, messengerInput);
        callRubinoAddFilePost.enqueue(new CallbackWithRetry<MessangerOutput>(callRubinoAddFilePost) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.7
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput> call, retrofit2.Response<MessangerOutput> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callRubinoAddFilePost;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<InstaGetProfilesOutput>> instaGetTopProfiles(InstaGetTopProfilesInput instaGetTopProfilesInput, final Listener listener) {
        MessengerInput<InstaGetTopProfilesInput> messengerInput = new MessengerInput<>(this.auth);
        instaGetTopProfilesInput.setProfileId(this.currentAccount);
        messengerInput.method = "getTopProfiles";
        messengerInput.data = instaGetTopProfilesInput;
        messengerInput.api_version = "0";
        Call<MessangerOutput<InstaGetProfilesOutput>> callInstaGetTopProfiles = getRestApiService().instaGetTopProfiles(AppFavorUtils.rubinoUrl, messengerInput);
        callInstaGetTopProfiles.enqueue(new CallbackWithRetry<MessangerOutput<InstaGetProfilesOutput>>(callInstaGetTopProfiles) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.8
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<InstaGetProfilesOutput>> call, retrofit2.Response<MessangerOutput<InstaGetProfilesOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<InstaGetProfilesOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callInstaGetTopProfiles;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<InstaGetProfilesOutput>> instaSearchProfiles(InstaGetListInput instaGetListInput, final Listener listener) {
        MessengerInput<InstaGetListInput> messengerInput = new MessengerInput<>(this.auth);
        instaGetListInput.setProfileId(this.currentAccount);
        messengerInput.method = "searchProfile";
        messengerInput.data = instaGetListInput;
        messengerInput.api_version = "0";
        Call<MessangerOutput<InstaGetProfilesOutput>> callInstaSearchProfiles = getRestApiService().instaSearchProfiles(AppFavorUtils.rubinoUrl, messengerInput);
        callInstaSearchProfiles.enqueue(new CallbackWithRetry<MessangerOutput<InstaGetProfilesOutput>>(callInstaSearchProfiles) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.9
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<InstaGetProfilesOutput>> call, retrofit2.Response<MessangerOutput<InstaGetProfilesOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<InstaGetProfilesOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callInstaSearchProfiles;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<InstaGetCommentsOutput>> instaGetComments(InstaGetListInput instaGetListInput, final Listener listener) {
        MessengerInput<InstaGetListInput> messengerInput = new MessengerInput<>(this.auth);
        instaGetListInput.setProfileId(this.currentAccount);
        messengerInput.method = "getComments";
        messengerInput.data = instaGetListInput;
        messengerInput.api_version = "0";
        Call<MessangerOutput<InstaGetCommentsOutput>> callInstaGetComments = getRestApiService().instaGetComments(AppFavorUtils.rubinoUrl, messengerInput);
        callInstaGetComments.enqueue(new CallbackWithRetry<MessangerOutput<InstaGetCommentsOutput>>(callInstaGetComments) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.10
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<InstaGetCommentsOutput>> call, retrofit2.Response<MessangerOutput<InstaGetCommentsOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<InstaGetCommentsOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callInstaGetComments;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<InstaGetProfilesOutput>> instaGetPostLikeProfiles(InstaGetListInput instaGetListInput, final Listener listener) {
        MessengerInput<InstaGetListInput> messengerInput = new MessengerInput<>(this.auth);
        instaGetListInput.setProfileId(this.currentAccount);
        messengerInput.method = "getPostLikes";
        messengerInput.data = instaGetListInput;
        messengerInput.api_version = "0";
        Call<MessangerOutput<InstaGetProfilesOutput>> callInstaGetPostLikes = getRestApiService().instaGetPostLikes(AppFavorUtils.rubinoUrl, messengerInput);
        callInstaGetPostLikes.enqueue(new CallbackWithRetry<MessangerOutput<InstaGetProfilesOutput>>(callInstaGetPostLikes) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.11
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<InstaGetProfilesOutput>> call, retrofit2.Response<MessangerOutput<InstaGetProfilesOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<InstaGetProfilesOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callInstaGetPostLikes;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<InstaGetProfilesOutput>> instaGetProfileFollowers(InstaGetListInput instaGetListInput, final Listener listener) {
        MessengerInput<InstaGetListInput> messengerInput = new MessengerInput<>(this.auth);
        instaGetListInput.setProfileId(this.currentAccount);
        messengerInput.method = "getProfileFollowers";
        messengerInput.data = instaGetListInput;
        messengerInput.api_version = "0";
        Call<MessangerOutput<InstaGetProfilesOutput>> callInstaGetProfiles = getRestApiService().instaGetProfiles(AppFavorUtils.rubinoUrl, messengerInput);
        callInstaGetProfiles.enqueue(new CallbackWithRetry<MessangerOutput<InstaGetProfilesOutput>>(callInstaGetProfiles) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.12
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<InstaGetProfilesOutput>> call, retrofit2.Response<MessangerOutput<InstaGetProfilesOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<InstaGetProfilesOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callInstaGetProfiles;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<InstaGetProfileInfoOutput>> instaGetMyProfileInfo(InstaGetProfileInfoInput instaGetProfileInfoInput, final Listener listener) {
        MessengerInput<InstaGetProfileInfoInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getMyProfileInfo";
        messengerInput.data = instaGetProfileInfoInput;
        messengerInput.api_version = "0";
        Call<MessangerOutput<InstaGetProfileInfoOutput>> callInstaGetProfileInfo = getRestApiService().instaGetProfileInfo(AppFavorUtils.rubinoUrl, messengerInput);
        callInstaGetProfileInfo.enqueue(new CallbackWithRetry<MessangerOutput<InstaGetProfileInfoOutput>>(callInstaGetProfileInfo) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.14
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<InstaGetProfileInfoOutput>> call, retrofit2.Response<MessangerOutput<InstaGetProfileInfoOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<InstaGetProfileInfoOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callInstaGetProfileInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<InstaGetProfilesOutput>> instaGetMyProfileList(InstaGetListInput instaGetListInput, final Listener listener) {
        MessengerInput<InstaGetListInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getProfileList";
        messengerInput.data = instaGetListInput;
        messengerInput.api_version = "0";
        Call<MessangerOutput<InstaGetProfilesOutput>> callInstaGetMyProfileList = getRestApiService().instaGetMyProfileList(AppFavorUtils.rubinoUrl, messengerInput);
        callInstaGetMyProfileList.enqueue(new CallbackWithRetry<MessangerOutput<InstaGetProfilesOutput>>(callInstaGetMyProfileList) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.16
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<InstaGetProfilesOutput>> call, retrofit2.Response<MessangerOutput<InstaGetProfilesOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<InstaGetProfilesOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callInstaGetMyProfileList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput> instaRequestFollow(InstaRequestFollowInput instaRequestFollowInput, final Listener listener) {
        MessengerInput<InstaRequestFollowInput> messengerInput = new MessengerInput<>(this.auth);
        instaRequestFollowInput.setProfileId(this.currentAccount);
        messengerInput.method = "requestFollow";
        messengerInput.data = instaRequestFollowInput;
        messengerInput.api_version = "0";
        Call<MessangerOutput> callInstaRequestFollow = getRestApiService().instaRequestFollow(AppFavorUtils.rubinoUrl, messengerInput);
        callInstaRequestFollow.enqueue(new CallbackWithRetry<MessangerOutput>(callInstaRequestFollow) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.17
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput> call, retrofit2.Response<MessangerOutput> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callInstaRequestFollow;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput> instaActionOnRequest(InstaActionOnRequestInput instaActionOnRequestInput, final Listener listener) {
        MessengerInput<InstaActionOnRequestInput> messengerInput = new MessengerInput<>(this.auth);
        instaActionOnRequestInput.setProfileId(this.currentAccount);
        messengerInput.method = "actionOnRequest";
        messengerInput.data = instaActionOnRequestInput;
        messengerInput.api_version = "0";
        Call<MessangerOutput> callInstaActionOnRequest = getRestApiService().instaActionOnRequest(AppFavorUtils.rubinoUrl, messengerInput);
        callInstaActionOnRequest.enqueue(new CallbackWithRetry<MessangerOutput>(callInstaActionOnRequest) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.18
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput> call, retrofit2.Response<MessangerOutput> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callInstaActionOnRequest;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<InstaGetCommentsOutput>> instaGetCommentReplies(InstaGetListInput instaGetListInput, final Listener listener) {
        MessengerInput<InstaGetListInput> messengerInput = new MessengerInput<>(this.auth);
        instaGetListInput.setProfileId(this.currentAccount);
        messengerInput.method = "getCommentReplies";
        messengerInput.data = instaGetListInput;
        messengerInput.api_version = "0";
        Call<MessangerOutput<InstaGetCommentsOutput>> callInstaGetCommentReplies = getRestApiService().instaGetCommentReplies(AppFavorUtils.rubinoUrl, messengerInput);
        callInstaGetCommentReplies.enqueue(new CallbackWithRetry<MessangerOutput<InstaGetCommentsOutput>>(callInstaGetCommentReplies) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.20
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<InstaGetCommentsOutput>> call, retrofit2.Response<MessangerOutput<InstaGetCommentsOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<InstaGetCommentsOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callInstaGetCommentReplies;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<InstaGetProfilesOutput>> instaGetSuggestedProfiles(InstaGetListInput instaGetListInput, final Listener listener) {
        MessengerInput<InstaGetListInput> messengerInput = new MessengerInput<>(this.auth);
        instaGetListInput.setProfileId(this.currentAccount);
        messengerInput.method = "getSuggested";
        messengerInput.data = instaGetListInput;
        messengerInput.api_version = "0";
        Call<MessangerOutput<InstaGetProfilesOutput>> callInstaGetSuggestedProfiles = getRestApiService().instaGetSuggestedProfiles(AppFavorUtils.rubinoUrl, messengerInput);
        callInstaGetSuggestedProfiles.enqueue(new CallbackWithRetry<MessangerOutput<InstaGetProfilesOutput>>(callInstaGetSuggestedProfiles) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.21
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<InstaGetProfilesOutput>> call, retrofit2.Response<MessangerOutput<InstaGetProfilesOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<InstaGetProfilesOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callInstaGetSuggestedProfiles;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<InstaGetSaleListOutput>> instaGetSaleList(InstaGetListInput instaGetListInput, final Listener listener) {
        MessengerInput<InstaGetListInput> messengerInput = new MessengerInput<>(this.auth);
        instaGetListInput.setProfileId(this.currentAccount);
        messengerInput.method = "getSaleList";
        messengerInput.data = instaGetListInput;
        messengerInput.api_version = "0";
        Call<MessangerOutput<InstaGetSaleListOutput>> callInstaGetSaleList = getRestApiService().instaGetSaleList(AppFavorUtils.rubinoUrl, messengerInput);
        callInstaGetSaleList.enqueue(new CallbackWithRetry<MessangerOutput<InstaGetSaleListOutput>>(callInstaGetSaleList) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.22
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<InstaGetSaleListOutput>> call, retrofit2.Response<MessangerOutput<InstaGetSaleListOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<InstaGetSaleListOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callInstaGetSaleList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<InstaGetPurchaseListOutput>> instaGetPurchaseList(InstaGetListInput instaGetListInput, final Listener listener) {
        MessengerInput<InstaGetListInput> messengerInput = new MessengerInput<>(this.auth);
        instaGetListInput.setProfileId(this.currentAccount);
        messengerInput.method = "getPurchaseList";
        messengerInput.data = instaGetListInput;
        messengerInput.api_version = "0";
        Call<MessangerOutput<InstaGetPurchaseListOutput>> callInstaGetPurchaseList = getRestApiService().instaGetPurchaseList(AppFavorUtils.rubinoUrl, messengerInput);
        callInstaGetPurchaseList.enqueue(new CallbackWithRetry<MessangerOutput<InstaGetPurchaseListOutput>>(callInstaGetPurchaseList) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.23
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<InstaGetPurchaseListOutput>> call, retrofit2.Response<MessangerOutput<InstaGetPurchaseListOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<InstaGetPurchaseListOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callInstaGetPurchaseList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<InstaGetPostSaleListOutput>> instaGetPostSaleList(InstaGetListInput instaGetListInput, final Listener listener) {
        MessengerInput<InstaGetListInput> messengerInput = new MessengerInput<>(this.auth);
        instaGetListInput.setProfileId(this.currentAccount);
        messengerInput.method = "getPostSaleList";
        messengerInput.data = instaGetListInput;
        messengerInput.api_version = "0";
        Call<MessangerOutput<InstaGetPostSaleListOutput>> callInstaGetPostSaleList = getRestApiService().instaGetPostSaleList(AppFavorUtils.rubinoUrl, messengerInput);
        callInstaGetPostSaleList.enqueue(new CallbackWithRetry<MessangerOutput<InstaGetPostSaleListOutput>>(callInstaGetPostSaleList) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.24
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<InstaGetPostSaleListOutput>> call, retrofit2.Response<MessangerOutput<InstaGetPostSaleListOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<InstaGetPostSaleListOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callInstaGetPostSaleList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput> instaSetReadSale(InstaSetReadInput instaSetReadInput, final Listener listener) {
        MessengerInput<InstaSetReadInput> messengerInput = new MessengerInput<>(this.auth);
        instaSetReadInput.setProfileId(this.currentAccount);
        messengerInput.method = "setReadSale";
        messengerInput.data = instaSetReadInput;
        messengerInput.api_version = "0";
        Call<MessangerOutput> callInstaSetReadInput = getRestApiService().instaSetReadInput(AppFavorUtils.rubinoUrl, messengerInput);
        callInstaSetReadInput.enqueue(new CallbackWithRetry<MessangerOutput>(callInstaSetReadInput) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.25
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput> call, retrofit2.Response<MessangerOutput> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callInstaSetReadInput;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<InstaGetProfilesOutput>> instaGetLikedCommentProfiles(InstaGetListInput instaGetListInput, final Listener listener) {
        MessengerInput<InstaGetListInput> messengerInput = new MessengerInput<>(this.auth);
        instaGetListInput.setProfileId(this.currentAccount);
        messengerInput.method = "getLikedCommentProfiles";
        messengerInput.data = instaGetListInput;
        messengerInput.api_version = "0";
        Call<MessangerOutput<InstaGetProfilesOutput>> callInstaGetLikedCommentProfiles = getRestApiService().instaGetLikedCommentProfiles(AppFavorUtils.rubinoUrl, messengerInput);
        callInstaGetLikedCommentProfiles.enqueue(new CallbackWithRetry<MessangerOutput<InstaGetProfilesOutput>>(callInstaGetLikedCommentProfiles) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.26
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<InstaGetProfilesOutput>> call, retrofit2.Response<MessangerOutput<InstaGetProfilesOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<InstaGetProfilesOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callInstaGetLikedCommentProfiles;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<InstaGetHashTagsOutput>> instaSearchHashTag(InstaGetListInput instaGetListInput, final Listener listener) {
        MessengerInput<InstaGetListInput> messengerInput = new MessengerInput<>(this.auth);
        instaGetListInput.setProfileId(this.currentAccount);
        messengerInput.method = "searchHashTag";
        messengerInput.data = instaGetListInput;
        messengerInput.api_version = "0";
        Call<MessangerOutput<InstaGetHashTagsOutput>> callInstaSearchHashTags = getRestApiService().instaSearchHashTags(AppFavorUtils.rubinoUrl, messengerInput);
        callInstaSearchHashTags.enqueue(new CallbackWithRetry<MessangerOutput<InstaGetHashTagsOutput>>(callInstaSearchHashTags) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.27
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<InstaGetHashTagsOutput>> call, retrofit2.Response<MessangerOutput<InstaGetHashTagsOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<InstaGetHashTagsOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callInstaSearchHashTags;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<InstaGetHashTagsOutput>> instaGetHashTagTrend(InstaGetListInput instaGetListInput, final Listener listener) {
        MessengerInput<InstaGetListInput> messengerInput = new MessengerInput<>(this.auth);
        instaGetListInput.setProfileId(this.currentAccount);
        messengerInput.method = "getHashTagTrend";
        messengerInput.data = instaGetListInput;
        messengerInput.api_version = "0";
        Call<MessangerOutput<InstaGetHashTagsOutput>> callInstaGetHashTagTrend = getRestApiService().instaGetHashTagTrend(AppFavorUtils.rubinoUrl, messengerInput);
        callInstaGetHashTagTrend.enqueue(new CallbackWithRetry<MessangerOutput<InstaGetHashTagsOutput>>(callInstaGetHashTagTrend) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.28
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<InstaGetHashTagsOutput>> call, retrofit2.Response<MessangerOutput<InstaGetHashTagsOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<InstaGetHashTagsOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callInstaGetHashTagTrend;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput> instaReportRecord(InstaReportInput instaReportInput, final Listener listener) {
        MessengerInput<InstaReportInput> messengerInput = new MessengerInput<>(this.auth);
        instaReportInput.setProfileId(this.currentAccount);
        messengerInput.method = "setReportRecord";
        messengerInput.data = instaReportInput;
        messengerInput.api_version = "0";
        Call<MessangerOutput> callInstaReportRecord = getRestApiService().instaReportRecord(AppFavorUtils.rubinoUrl, messengerInput);
        callInstaReportRecord.enqueue(new CallbackWithRetry<MessangerOutput>(callInstaReportRecord) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.29
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput> call, retrofit2.Response<MessangerOutput> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callInstaReportRecord;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput> instaUpdateProfilePhoto(RubinoUpdateProfilePhotoInput rubinoUpdateProfilePhotoInput, final Listener listener) {
        MessengerInput<RubinoUpdateProfilePhotoInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "updateProfilePhoto";
        messengerInput.data = rubinoUpdateProfilePhotoInput;
        messengerInput.api_version = "0";
        Call<MessangerOutput> callInstaUpdateProfilePhoto = getRestApiService().instaUpdateProfilePhoto(AppFavorUtils.rubinoUrl, messengerInput);
        callInstaUpdateProfilePhoto.enqueue(new CallbackWithRetry<MessangerOutput>(callInstaUpdateProfilePhoto) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.30
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput> call, retrofit2.Response<MessangerOutput> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callInstaUpdateProfilePhoto;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<InstaGetProfileInfoOutput>> instaUpdateProfile(InstaUpdateProfileInput instaUpdateProfileInput, final Listener listener) {
        MessengerInput<InstaUpdateProfileInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "updateProfile";
        messengerInput.data = instaUpdateProfileInput;
        messengerInput.api_version = "0";
        Call<MessangerOutput<InstaGetProfileInfoOutput>> callInstaUpdateProfile = getRestApiService().instaUpdateProfile(AppFavorUtils.rubinoUrl, messengerInput);
        callInstaUpdateProfile.enqueue(new CallbackWithRetry<MessangerOutput<InstaGetProfileInfoOutput>>(callInstaUpdateProfile) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.31
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<InstaGetProfileInfoOutput>> call, retrofit2.Response<MessangerOutput<InstaGetProfileInfoOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<InstaGetProfileInfoOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callInstaUpdateProfile;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput> instaSendFileError(InstaSendFileErrorInput instaSendFileErrorInput, final Listener listener) {
        MessengerInput<InstaSendFileErrorInput> messengerInput = new MessengerInput<>(this.auth);
        instaSendFileErrorInput.setProfileId(this.currentAccount);
        messengerInput.method = "errorSendFile";
        messengerInput.data = instaSendFileErrorInput;
        messengerInput.api_version = "0";
        Call<MessangerOutput> callInstaSendFileError = getRestApiService().instaSendFileError(AppFavorUtils.rubinoUrl, messengerInput);
        callInstaSendFileError.enqueue(new CallbackWithRetry<MessangerOutput>(callInstaSendFileError) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.32
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput> call, retrofit2.Response<MessangerOutput> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callInstaSendFileError;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput> instaSetBlockProfile(InstaSetBlockProfileInput instaSetBlockProfileInput, final Listener listener) {
        MessengerInput<InstaSetBlockProfileInput> messengerInput = new MessengerInput<>(this.auth);
        instaSetBlockProfileInput.setProfileId(this.currentAccount);
        messengerInput.method = "setBlockProfile";
        messengerInput.data = instaSetBlockProfileInput;
        messengerInput.api_version = "0";
        Call<MessangerOutput> callInstaSetBlockProfile = getRestApiService().instaSetBlockProfile(AppFavorUtils.rubinoUrl, messengerInput);
        callInstaSetBlockProfile.enqueue(new CallbackWithRetry<MessangerOutput>(callInstaSetBlockProfile) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.33
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput> call, retrofit2.Response<MessangerOutput> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callInstaSetBlockProfile;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<InataAddPostOutput>> instaAddPost(InstaAddPostInput instaAddPostInput, final Listener listener) {
        MessengerInput<InstaAddPostInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "addPost";
        messengerInput.data = instaAddPostInput;
        messengerInput.api_version = "0";
        Call<MessangerOutput<InataAddPostOutput>> callInstaAddPost = getRestApiService().instaAddPost(AppFavorUtils.rubinoUrl, messengerInput);
        callInstaAddPost.enqueue(new CallbackWithRetry<MessangerOutput<InataAddPostOutput>>(callInstaAddPost) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.34
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<InataAddPostOutput>> call, retrofit2.Response<MessangerOutput<InataAddPostOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<InataAddPostOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callInstaAddPost;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<RubinoRequestUploadFileOutput>> instaRequestUploadFile(RubinoRequestUploadFileInput rubinoRequestUploadFileInput, final Listener listener) {
        MessengerInput<RubinoRequestUploadFileInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "requestUploadFile";
        messengerInput.data = rubinoRequestUploadFileInput;
        messengerInput.api_version = "0";
        Call<MessangerOutput<RubinoRequestUploadFileOutput>> callInstaRequestUploadFile = getRestApiService().instaRequestUploadFile(AppFavorUtils.rubinoUrl, messengerInput);
        callInstaRequestUploadFile.enqueue(new CallbackWithRetry<MessangerOutput<RubinoRequestUploadFileOutput>>(callInstaRequestUploadFile) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.36
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<RubinoRequestUploadFileOutput>> call, retrofit2.Response<MessangerOutput<RubinoRequestUploadFileOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<RubinoRequestUploadFileOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callInstaRequestUploadFile;
    }

    public Call<MessangerOutput<RubinoUploadFileOutput>> instaUploadFile(String str, byte[] bArr, int i, int i2, String str2, String str3, final Listener2 listener2) {
        Call<MessangerOutput<RubinoUploadFileOutput>> callInstaUploadFile = getRestApiService().instaUploadFile(str, RequestBody.create(MediaType.parse("application/octet-stream"), bArr), i, i2, this.auth, str2, str3);
        callInstaUploadFile.enqueue(new CallbackWithRetry<MessangerOutput<RubinoUploadFileOutput>>(callInstaUploadFile) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.37
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<RubinoUploadFileOutput>> call, retrofit2.Response<MessangerOutput<RubinoUploadFileOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener2);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<RubinoUploadFileOutput>> call, Throwable th) {
                listener2.onFailure(this, th);
            }
        });
        return callInstaUploadFile;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<InstaGetNewEventsOutput>> instaGetNewEvents(InstaGetListInput instaGetListInput, final Listener listener) {
        MessengerInput<InstaGetListInput> messengerInput = new MessengerInput<>(this.auth);
        instaGetListInput.setProfileId(this.currentAccount);
        messengerInput.method = "getNewEvents";
        messengerInput.data = instaGetListInput;
        messengerInput.api_version = "0";
        Call<MessangerOutput<InstaGetNewEventsOutput>> callInstaGetNewEvents = getRestApiService().instaGetNewEvents(AppFavorUtils.rubinoUrl, messengerInput);
        callInstaGetNewEvents.enqueue(new CallbackWithRetry<MessangerOutput<InstaGetNewEventsOutput>>(callInstaGetNewEvents) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.38
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<InstaGetNewEventsOutput>> call, retrofit2.Response<MessangerOutput<InstaGetNewEventsOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<InstaGetNewEventsOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callInstaGetNewEvents;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [T, ir.resaneh1.iptv.model.EmptyInputObject] */
    public Call<MessangerOutput<GetSearchStructureOutput>> getSearchStructure(final Listener listener) {
        MessengerInput messengerInput = new MessengerInput(this.auth);
        messengerInput.method = "getSearchStructure";
        messengerInput.data = new EmptyInputObject();
        messengerInput.setIptvInput();
        Call<MessangerOutput<GetSearchStructureOutput>> searchStructure = getRestApiService().getSearchStructure(AppFavorUtils.iptvUrl, messengerInput);
        searchStructure.enqueue(new CallbackWithRetry<MessangerOutput<GetSearchStructureOutput>>(searchStructure) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.39
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<GetSearchStructureOutput>> call, retrofit2.Response<MessangerOutput<GetSearchStructureOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<GetSearchStructureOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return searchStructure;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<InstaGetPostsOutput>> instaGetExplorePosts(InstaGetListInput instaGetListInput, final Listener listener) {
        MessengerInput<InstaGetListInput> messengerInput = new MessengerInput<>(this.auth);
        instaGetListInput.setProfileId(this.currentAccount);
        messengerInput.method = "getExplorePosts";
        messengerInput.data = instaGetListInput;
        messengerInput.api_version = "0";
        Call<MessangerOutput<InstaGetPostsOutput>> callInstaGetExplorePosts = getRestApiService().instaGetExplorePosts(AppFavorUtils.rubinoUrl, messengerInput);
        callInstaGetExplorePosts.enqueue(new CallbackWithRetry<MessangerOutput<InstaGetPostsOutput>>(callInstaGetExplorePosts) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.40
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<InstaGetPostsOutput>> call, retrofit2.Response<MessangerOutput<InstaGetPostsOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<InstaGetPostsOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callInstaGetExplorePosts;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<InstaGetRelatedProfilesOutput>> instaGetRelatedProfiles(InstaGetListInput instaGetListInput, final Listener listener) {
        MessengerInput<InstaGetListInput> messengerInput = new MessengerInput<>(this.auth);
        instaGetListInput.setProfileId(this.currentAccount);
        messengerInput.method = "getRelatedProfiles";
        messengerInput.data = instaGetListInput;
        messengerInput.api_version = "0";
        Call<MessangerOutput<InstaGetRelatedProfilesOutput>> callInstaGetRelatedProfiles = getRestApiService().instaGetRelatedProfiles(AppFavorUtils.rubinoUrl, messengerInput);
        callInstaGetRelatedProfiles.enqueue(new CallbackWithRetry<MessangerOutput<InstaGetRelatedProfilesOutput>>(callInstaGetRelatedProfiles) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.41
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<InstaGetRelatedProfilesOutput>> call, retrofit2.Response<MessangerOutput<InstaGetRelatedProfilesOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<InstaGetRelatedProfilesOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callInstaGetRelatedProfiles;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<InstaGetRelatedExplorePostsOutput>> instaGetRelatedExplorePosts(InstaGetListInput instaGetListInput, final Listener listener) {
        MessengerInput<InstaGetListInput> messengerInput = new MessengerInput<>(this.auth);
        instaGetListInput.setProfileId(this.currentAccount);
        messengerInput.method = "getRelatedExplorePost";
        messengerInput.data = instaGetListInput;
        messengerInput.api_version = "0";
        Call<MessangerOutput<InstaGetRelatedExplorePostsOutput>> callInstaGetRelatedExplorePosts = getRestApiService().instaGetRelatedExplorePosts(AppFavorUtils.rubinoUrl, messengerInput);
        callInstaGetRelatedExplorePosts.enqueue(new CallbackWithRetry<MessangerOutput<InstaGetRelatedExplorePostsOutput>>(callInstaGetRelatedExplorePosts) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.42
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<InstaGetRelatedExplorePostsOutput>> call, retrofit2.Response<MessangerOutput<InstaGetRelatedExplorePostsOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<InstaGetRelatedExplorePostsOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callInstaGetRelatedExplorePosts;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput> instaRemoveNotification(InstaRemoveNotificationInput instaRemoveNotificationInput, final Listener listener) {
        MessengerInput<InstaRemoveNotificationInput> messengerInput = new MessengerInput<>(this.auth);
        instaRemoveNotificationInput.setProfileId(this.currentAccount);
        messengerInput.method = "removeNotification";
        messengerInput.data = instaRemoveNotificationInput;
        messengerInput.api_version = "0";
        Call<MessangerOutput> callInstaRemoveNotification = getRestApiService().instaRemoveNotification(AppFavorUtils.rubinoUrl, messengerInput);
        callInstaRemoveNotification.enqueue(new CallbackWithRetry<MessangerOutput>(callInstaRemoveNotification) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.43
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput> call, retrofit2.Response<MessangerOutput> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callInstaRemoveNotification;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<GetTileOutput>> getTiles(GetTileInput getTileInput, final Listener listener) {
        MessengerInput<GetTileInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getTiles";
        messengerInput.data = getTileInput;
        messengerInput.setIptvInput();
        Call<MessangerOutput<GetTileOutput>> tiles = getRestApiService().getTiles(AppFavorUtils.iptvUrl, messengerInput);
        tiles.enqueue(new CallbackWithRetry<MessangerOutput<GetTileOutput>>(tiles) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.44
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<GetTileOutput>> call, retrofit2.Response<MessangerOutput<GetTileOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<GetTileOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return tiles;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<SearchQueryOutput>> searchQuery(SearchQueryInput searchQueryInput, String str, final Listener listener) {
        MessengerInput<SearchQueryInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "searchQuery";
        messengerInput.data = searchQueryInput;
        messengerInput.setIptvInput();
        Call<MessangerOutput<SearchQueryOutput>> callSearchQuery = getRestApiService().searchQuery(str, messengerInput);
        callSearchQuery.enqueue(new CallbackWithRetry<MessangerOutput<SearchQueryOutput>>(callSearchQuery) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.45
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<SearchQueryOutput>> call, retrofit2.Response<MessangerOutput<SearchQueryOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<SearchQueryOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callSearchQuery;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<GetTagListOutput>> getTagList(GetTagListInput getTagListInput, final Listener listener) {
        MessengerInput<GetTagListInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getTagList";
        messengerInput.data = getTagListInput;
        messengerInput.setIptvInput();
        String str = AppFavorUtils.iptvUrl;
        boolean z = MyLog.isDebugAble;
        Call<MessangerOutput<GetTagListOutput>> tagList = getRestApiService().getTagList(str, messengerInput);
        tagList.enqueue(new CallbackWithRetry<MessangerOutput<GetTagListOutput>>(tagList) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.46
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<GetTagListOutput>> call, retrofit2.Response<MessangerOutput<GetTagListOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<GetTagListOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return tagList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<GetTagObjectsOutput>> getTagObjects(GetListInputByStartId getListInputByStartId, String str, final Listener listener) {
        MessengerInput<GetListInputByStartId> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getTagObjects";
        messengerInput.data = getListInputByStartId;
        messengerInput.setIptvInput();
        Call<MessangerOutput<GetTagObjectsOutput>> tagObjects = getRestApiService().getTagObjects(str, messengerInput);
        tagObjects.enqueue(new CallbackWithRetry<MessangerOutput<GetTagObjectsOutput>>(tagObjects) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.47
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<GetTagObjectsOutput>> call, retrofit2.Response<MessangerOutput<GetTagObjectsOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<GetTagObjectsOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return tagObjects;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<GetBarcodeActionOutput>> getBarcodeAction(GetBarcodeActionInput getBarcodeActionInput, final Listener listener) {
        MessengerInput<GetBarcodeActionInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getBarcodeAction";
        messengerInput.data = getBarcodeActionInput;
        messengerInput.setBarcodeInput();
        Call<MessangerOutput<GetBarcodeActionOutput>> barcodeAction = getRestApiService().getBarcodeAction(AppFavorUtils.barcodeUrl, messengerInput);
        barcodeAction.enqueue(new CallbackWithRetry<MessangerOutput<GetBarcodeActionOutput>>(barcodeAction) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.49
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<GetBarcodeActionOutput>> call, retrofit2.Response<MessangerOutput<GetBarcodeActionOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<GetBarcodeActionOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return barcodeAction;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<WebAppObject>> getWebAppFunction(GetWebAppFunctionInput getWebAppFunctionInput, final Listener listener) {
        MessengerInput<GetWebAppFunctionInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getWebAppFunction";
        messengerInput.data = getWebAppFunctionInput;
        messengerInput.setWebAppInput();
        Call<MessangerOutput<WebAppObject>> webAppFunction = getRestApiService().getWebAppFunction(AppFavorUtils.webAppUrl, messengerInput);
        webAppFunction.enqueue(new CallbackWithRetry<MessangerOutput<WebAppObject>>(webAppFunction) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.50
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<WebAppObject>> call, retrofit2.Response<MessangerOutput<WebAppObject>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<WebAppObject>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return webAppFunction;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<WebAppChangeUserTokenOutput>> webAppChangeUserToken(WebAppChangeUserTokenInput webAppChangeUserTokenInput, final Listener listener) {
        MessengerInput<WebAppChangeUserTokenInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "changeUserToken";
        messengerInput.data = webAppChangeUserTokenInput;
        messengerInput.setWebAppInput();
        Call<MessangerOutput<WebAppChangeUserTokenOutput>> callWebAppChangeUserToken = getRestApiService().webAppChangeUserToken(AppFavorUtils.webAppUrl, messengerInput);
        callWebAppChangeUserToken.enqueue(new CallbackWithRetry<MessangerOutput<WebAppChangeUserTokenOutput>>(callWebAppChangeUserToken) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.52
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<WebAppChangeUserTokenOutput>> call, retrofit2.Response<MessangerOutput<WebAppChangeUserTokenOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<WebAppChangeUserTokenOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callWebAppChangeUserToken;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<GetCommentsOutput>> getComments(GetListInputByStartId getListInputByStartId, final Listener listener) {
        MessengerInput<GetListInputByStartId> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getComments";
        messengerInput.data = getListInputByStartId;
        messengerInput.setCommentInput();
        Call<MessangerOutput<GetCommentsOutput>> comments = getRestApiService().getComments(AppFavorUtils.commentUrl, messengerInput);
        comments.enqueue(new CallbackWithRetry<MessangerOutput<GetCommentsOutput>>(comments) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.57
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<GetCommentsOutput>> call, retrofit2.Response<MessangerOutput<GetCommentsOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<GetCommentsOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return comments;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<GetPaymentOptionOutput>> getPaymentOption(GetPaymentOptionInput getPaymentOptionInput, final Listener listener) {
        MessengerInput<GetPaymentOptionInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getPaymentOption";
        messengerInput.data = getPaymentOptionInput;
        messengerInput.setPaymentInput();
        Call<MessangerOutput<GetPaymentOptionOutput>> paymentOption = getRestApiService().getPaymentOption(AppFavorUtils.paymentUrl, messengerInput);
        paymentOption.enqueue(new CallbackWithRetry<MessangerOutput<GetPaymentOptionOutput>>(paymentOption) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.60
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<GetPaymentOptionOutput>> call, retrofit2.Response<MessangerOutput<GetPaymentOptionOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<GetPaymentOptionOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return paymentOption;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<ConfirmPaymentOutput>> confirmPayment(ConfirmPaymentInput confirmPaymentInput, final Listener listener) {
        MessengerInput<ConfirmPaymentInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "confirmPayment";
        messengerInput.data = confirmPaymentInput;
        messengerInput.setPaymentInput();
        Call<MessangerOutput<ConfirmPaymentOutput>> callConfirmPayment = getRestApiService().confirmPayment(AppFavorUtils.paymentUrl, messengerInput);
        callConfirmPayment.enqueue(new CallbackWithRetry<MessangerOutput<ConfirmPaymentOutput>>(callConfirmPayment) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.61
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<ConfirmPaymentOutput>> call, retrofit2.Response<MessangerOutput<ConfirmPaymentOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<ConfirmPaymentOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callConfirmPayment;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<GetRubikaPaymentOptionOutput>> getRubikaPaymentOption(GetRubikaPaymentOptionInput getRubikaPaymentOptionInput, final Listener listener) {
        MessengerInput<GetRubikaPaymentOptionInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getRubikaPaymentOption";
        messengerInput.data = getRubikaPaymentOptionInput;
        messengerInput.setPaymentInput();
        Call<MessangerOutput<GetRubikaPaymentOptionOutput>> rubikaPaymentOption = getRestApiService().getRubikaPaymentOption(AppFavorUtils.paymentUrl, messengerInput);
        rubikaPaymentOption.enqueue(new CallbackWithRetry<MessangerOutput<GetRubikaPaymentOptionOutput>>(rubikaPaymentOption) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.62
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<GetRubikaPaymentOptionOutput>> call, retrofit2.Response<MessangerOutput<GetRubikaPaymentOptionOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<GetRubikaPaymentOptionOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return rubikaPaymentOption;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<AddDeliveryInfoOutput>> addDeliveryInfo(AddDeliveryInfoInput addDeliveryInfoInput, final Listener listener) {
        MessengerInput<AddDeliveryInfoInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "addDeliveryInfo";
        messengerInput.data = addDeliveryInfoInput;
        messengerInput.setBasketInput();
        Call<MessangerOutput<AddDeliveryInfoOutput>> callAddDeliveryInfo = getRestApiService().addDeliveryInfo(AppFavorUtils.basketUrl, messengerInput);
        callAddDeliveryInfo.enqueue(new CallbackWithRetry<MessangerOutput<AddDeliveryInfoOutput>>(callAddDeliveryInfo) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.64
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<AddDeliveryInfoOutput>> call, retrofit2.Response<MessangerOutput<AddDeliveryInfoOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<AddDeliveryInfoOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callAddDeliveryInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<AddDeliveryInfoOutput>> editDeliveryInfo(AddDeliveryInfoInput addDeliveryInfoInput, final Listener listener) {
        MessengerInput<AddDeliveryInfoInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "editDeliveryInfo";
        messengerInput.data = addDeliveryInfoInput;
        messengerInput.setBasketInput();
        Call<MessangerOutput<AddDeliveryInfoOutput>> callEditDeliveryInfo = getRestApiService().editDeliveryInfo(AppFavorUtils.basketUrl, messengerInput);
        callEditDeliveryInfo.enqueue(new CallbackWithRetry<MessangerOutput<AddDeliveryInfoOutput>>(callEditDeliveryInfo) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.65
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<AddDeliveryInfoOutput>> call, retrofit2.Response<MessangerOutput<AddDeliveryInfoOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<AddDeliveryInfoOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callEditDeliveryInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput> removeDeliveryInfo(RemoveDeliveryInfoInput removeDeliveryInfoInput, final Listener listener) {
        MessengerInput<RemoveDeliveryInfoInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "removeDeliveryInfo";
        messengerInput.data = removeDeliveryInfoInput;
        messengerInput.setBasketInput();
        Call<MessangerOutput> callRemoveDeliveryInfo = getRestApiService().removeDeliveryInfo(AppFavorUtils.basketUrl, messengerInput);
        callRemoveDeliveryInfo.enqueue(new CallbackWithRetry<MessangerOutput>(callRemoveDeliveryInfo) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.66
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput> call, retrofit2.Response<MessangerOutput> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callRemoveDeliveryInfo;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [T, ir.resaneh1.iptv.model.EmptyInputObject] */
    public Call<MessangerOutput<GetAllDeliveryInfoOutput>> getAllDeliveryInfo(final Listener listener) {
        MessengerInput<EmptyInputObject> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getAllDeliveryInfo";
        messengerInput.data = new EmptyInputObject();
        messengerInput.setBasketInput();
        Call<MessangerOutput<GetAllDeliveryInfoOutput>> allDeliveryInfo = getRestApiService().getAllDeliveryInfo(AppFavorUtils.basketUrl, messengerInput);
        allDeliveryInfo.enqueue(new CallbackWithRetry<MessangerOutput<GetAllDeliveryInfoOutput>>(allDeliveryInfo) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.67
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<GetAllDeliveryInfoOutput>> call, retrofit2.Response<MessangerOutput<GetAllDeliveryInfoOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<GetAllDeliveryInfoOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return allDeliveryInfo;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [T, ir.resaneh1.iptv.model.EmptyInputObject] */
    public Call<MessangerOutput<GetDefaultDeliveryInfoOutput>> getDefaultDeliveryInfo(final Listener listener) {
        MessengerInput<EmptyInputObject> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getDefaultDeliveryInfo";
        messengerInput.data = new EmptyInputObject();
        messengerInput.setBasketInput();
        Call<MessangerOutput<GetDefaultDeliveryInfoOutput>> defaultDeliveryInfo = getRestApiService().getDefaultDeliveryInfo(AppFavorUtils.basketUrl, messengerInput);
        defaultDeliveryInfo.enqueue(new CallbackWithRetry<MessangerOutput<GetDefaultDeliveryInfoOutput>>(defaultDeliveryInfo) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.68
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<GetDefaultDeliveryInfoOutput>> call, retrofit2.Response<MessangerOutput<GetDefaultDeliveryInfoOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<GetDefaultDeliveryInfoOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return defaultDeliveryInfo;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [T, ir.resaneh1.iptv.model.EmptyInputObject] */
    public Call<MessangerOutput<GetBasketListOutput>> getBasketList(final Listener listener) {
        MessengerInput messengerInput = new MessengerInput(this.auth);
        messengerInput.method = "getBaskets";
        messengerInput.data = new EmptyInputObject();
        messengerInput.setBasketInput();
        Call<MessangerOutput<GetBasketListOutput>> baskets = getRestApiService().getBaskets(AppFavorUtils.basketUrl, messengerInput);
        baskets.enqueue(new CallbackWithRetry<MessangerOutput<GetBasketListOutput>>(baskets) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.69
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<GetBasketListOutput>> call, retrofit2.Response<MessangerOutput<GetBasketListOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<GetBasketListOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return baskets;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<GetBasketOutput>> getBasket(GetBasketInput getBasketInput, final Listener listener) {
        MessengerInput<GetBasketInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getBasket";
        messengerInput.data = getBasketInput;
        messengerInput.setBasketInput();
        Call<MessangerOutput<GetBasketOutput>> basket = getRestApiService().getBasket(AppFavorUtils.basketUrl, messengerInput);
        basket.enqueue(new CallbackWithRetry<MessangerOutput<GetBasketOutput>>(basket) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.70
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<GetBasketOutput>> call, retrofit2.Response<MessangerOutput<GetBasketOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<GetBasketOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return basket;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<SetBasketItemCountOutput>> setBasketItemCount(SetBasketItemCountInput setBasketItemCountInput, final Listener listener) {
        MessengerInput<SetBasketItemCountInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "setBasketItemCount";
        messengerInput.data = setBasketItemCountInput;
        messengerInput.setBasketInput();
        Call<MessangerOutput<SetBasketItemCountOutput>> basketItemCount = getRestApiService().setBasketItemCount(AppFavorUtils.basketUrl, messengerInput);
        basketItemCount.enqueue(new CallbackWithRetry<MessangerOutput<SetBasketItemCountOutput>>(basketItemCount) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.71
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<SetBasketItemCountOutput>> call, retrofit2.Response<MessangerOutput<SetBasketItemCountOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<SetBasketItemCountOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return basketItemCount;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [T, ir.resaneh1.iptv.model.EmptyInputObject] */
    public Call<MessangerOutput<GetDeliverProvinceOutput>> getDeliveryProvinces(final Listener listener) {
        MessengerInput messengerInput = new MessengerInput(this.auth);
        messengerInput.method = "getDeliveryProvinces";
        messengerInput.data = new EmptyInputObject();
        messengerInput.setBasketInput();
        Call<MessangerOutput<GetDeliverProvinceOutput>> deliverProvince = getRestApiService().getDeliverProvince(AppFavorUtils.basketUrl, messengerInput);
        deliverProvince.enqueue(new CallbackWithRetry<MessangerOutput<GetDeliverProvinceOutput>>(deliverProvince) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.72
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<GetDeliverProvinceOutput>> call, retrofit2.Response<MessangerOutput<GetDeliverProvinceOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<GetDeliverProvinceOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return deliverProvince;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<GetDeliverCityOutput>> getDeliveryCities(GetDeliverCityInput getDeliverCityInput, final Listener listener) {
        MessengerInput<GetDeliverCityInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getDeliveryCities";
        messengerInput.data = getDeliverCityInput;
        messengerInput.setBasketInput();
        Call<MessangerOutput<GetDeliverCityOutput>> deliverCityProvince = getRestApiService().getDeliverCityProvince(AppFavorUtils.basketUrl, messengerInput);
        deliverCityProvince.enqueue(new CallbackWithRetry<MessangerOutput<GetDeliverCityOutput>>(deliverCityProvince) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.73
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<GetDeliverCityOutput>> call, retrofit2.Response<MessangerOutput<GetDeliverCityOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<GetDeliverCityOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return deliverCityProvince;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<GetDeliveryTypeOutput>> getDeliveryTypes(GetDeliveryTypesInput getDeliveryTypesInput, final Listener listener) {
        MessengerInput<GetDeliveryTypesInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getDeliveryTypes";
        messengerInput.data = getDeliveryTypesInput;
        messengerInput.setBasketInput();
        Call<MessangerOutput<GetDeliveryTypeOutput>> deliveryTypes = getRestApiService().getDeliveryTypes(AppFavorUtils.basketUrl, messengerInput);
        deliveryTypes.enqueue(new CallbackWithRetry<MessangerOutput<GetDeliveryTypeOutput>>(deliveryTypes) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.74
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<GetDeliveryTypeOutput>> call, retrofit2.Response<MessangerOutput<GetDeliveryTypeOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<GetDeliveryTypeOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return deliveryTypes;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<GetDeliveryTimesOutput>> getDeliveryTimes(GetDeliveryTimesInput getDeliveryTimesInput, final Listener listener) {
        MessengerInput<GetDeliveryTimesInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getDeliveryTimes";
        messengerInput.data = getDeliveryTimesInput;
        messengerInput.setBasketInput();
        Call<MessangerOutput<GetDeliveryTimesOutput>> deliveryTimes = getRestApiService().getDeliveryTimes(AppFavorUtils.basketUrl, messengerInput);
        deliveryTimes.enqueue(new CallbackWithRetry<MessangerOutput<GetDeliveryTimesOutput>>(deliveryTimes) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.75
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<GetDeliveryTimesOutput>> call, retrofit2.Response<MessangerOutput<GetDeliveryTimesOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<GetDeliveryTimesOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return deliveryTimes;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<CreateBasketOrderOutput>> createBasketOrder(CreateBasketOrderInput createBasketOrderInput, final Listener listener) {
        MessengerInput<CreateBasketOrderInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "createBasketOrder";
        messengerInput.data = createBasketOrderInput;
        messengerInput.setBasketInput();
        Call<MessangerOutput<CreateBasketOrderOutput>> callCreateBasketOrder = getRestApiService().createBasketOrder(AppFavorUtils.basketUrl, messengerInput);
        callCreateBasketOrder.enqueue(new CallbackWithRetry<MessangerOutput<CreateBasketOrderOutput>>(callCreateBasketOrder) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.76
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<CreateBasketOrderOutput>> call, retrofit2.Response<MessangerOutput<CreateBasketOrderOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<CreateBasketOrderOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callCreateBasketOrder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<ApplyOrderDiscountCodeOutput>> applyOrderDiscountCode(ApplyOrderDiscountCodeInput applyOrderDiscountCodeInput, final Listener listener) {
        MessengerInput<ApplyOrderDiscountCodeInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "applyOrderDiscountCode";
        messengerInput.data = applyOrderDiscountCodeInput;
        messengerInput.setBasketInput();
        Call<MessangerOutput<ApplyOrderDiscountCodeOutput>> callApplyOrderDiscountCode = getRestApiService().applyOrderDiscountCode(AppFavorUtils.basketUrl, messengerInput);
        callApplyOrderDiscountCode.enqueue(new CallbackWithRetry<MessangerOutput<ApplyOrderDiscountCodeOutput>>(callApplyOrderDiscountCode) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.77
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<ApplyOrderDiscountCodeOutput>> call, retrofit2.Response<MessangerOutput<ApplyOrderDiscountCodeOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<ApplyOrderDiscountCodeOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callApplyOrderDiscountCode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<GetOrderPaymentInfoOutput>> getOrderPaymentInfo(GetOrderPaymentInfoInput getOrderPaymentInfoInput, final Listener listener) {
        MessengerInput<GetOrderPaymentInfoInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getOrderPaymentInfo";
        messengerInput.data = getOrderPaymentInfoInput;
        messengerInput.setBasketInput();
        Call<MessangerOutput<GetOrderPaymentInfoOutput>> orderPaymentInfo = getRestApiService().getOrderPaymentInfo(AppFavorUtils.basketUrl, messengerInput);
        orderPaymentInfo.enqueue(new CallbackWithRetry<MessangerOutput<GetOrderPaymentInfoOutput>>(orderPaymentInfo) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.78
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<GetOrderPaymentInfoOutput>> call, retrofit2.Response<MessangerOutput<GetOrderPaymentInfoOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<GetOrderPaymentInfoOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return orderPaymentInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<GetPaidOrdersOutput>> getPaidOrders(GetListInputByStartId getListInputByStartId, final Listener listener) {
        MessengerInput<GetListInputByStartId> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getPaidOrders";
        messengerInput.data = getListInputByStartId;
        messengerInput.setBasketInput();
        Call<MessangerOutput<GetPaidOrdersOutput>> paidOrders = getRestApiService().getPaidOrders(AppFavorUtils.basketUrl, messengerInput);
        paidOrders.enqueue(new CallbackWithRetry<MessangerOutput<GetPaidOrdersOutput>>(paidOrders) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.79
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<GetPaidOrdersOutput>> call, retrofit2.Response<MessangerOutput<GetPaidOrdersOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<GetPaidOrdersOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return paidOrders;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [T, ir.resaneh1.iptv.model.EmptyInputObject] */
    public Call<MessangerOutput<GetBasketStatusOutput>> getBasketsStatus(final Listener listener) {
        MessengerInput<EmptyInputObject> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "getBasketsStatus";
        messengerInput.data = new EmptyInputObject();
        messengerInput.setBasketInput();
        Call<MessangerOutput<GetBasketStatusOutput>> basketsStatus = getRestApiService().getBasketsStatus(AppFavorUtils.basketUrl, messengerInput);
        basketsStatus.enqueue(new CallbackWithRetry<MessangerOutput<GetBasketStatusOutput>>(basketsStatus) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.80
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<GetBasketStatusOutput>> call, retrofit2.Response<MessangerOutput<GetBasketStatusOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<GetBasketStatusOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return basketsStatus;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput> dropBasket(DropBasketInput dropBasketInput, final Listener listener) {
        MessengerInput<DropBasketInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "dropBasket";
        messengerInput.data = dropBasketInput;
        messengerInput.setBasketInput();
        Call<MessangerOutput> callDropBasket = getRestApiService().dropBasket(AppFavorUtils.basketUrl, messengerInput);
        callDropBasket.enqueue(new CallbackWithRetry<MessangerOutput>(callDropBasket) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.82
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput> call, retrofit2.Response<MessangerOutput> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callDropBasket;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Call<MessangerOutput<RequestSendFileMiniFunctionOutput>> requestSendFileMiniFunction(String str, RequestSendFileMiniFunctionInput requestSendFileMiniFunctionInput, final Listener listener) {
        MessengerInput<RequestSendFileMiniFunctionInput> messengerInput = new MessengerInput<>(this.auth);
        messengerInput.method = "requestSendFile";
        messengerInput.data = requestSendFileMiniFunctionInput;
        messengerInput.api_version = "0";
        Call<MessangerOutput<RequestSendFileMiniFunctionOutput>> callRequestSendFileMiniFunction = getRestApiService().requestSendFileMiniFunction(str, messengerInput);
        callRequestSendFileMiniFunction.enqueue(new CallbackWithRetry<MessangerOutput<RequestSendFileMiniFunctionOutput>>(callRequestSendFileMiniFunction) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.84
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<RequestSendFileMiniFunctionOutput>> call, retrofit2.Response<MessangerOutput<RequestSendFileMiniFunctionOutput>> response) {
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<RequestSendFileMiniFunctionOutput>> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return callRequestSendFileMiniFunction;
    }

    public Call<MessangerOutput<SendFileMiniFunctionOutput>> sendFileMiniFunction(String str, byte[] bArr, int i, int i2, String str2, String str3, final Listener2 listener2) {
        Call<MessangerOutput<SendFileMiniFunctionOutput>> callSendFileMiniFunction = getRestApiService().sendFileMiniFunction(str, RequestBody.create(MediaType.parse("application/octet-stream"), bArr), i, i2, this.auth, str2, str3);
        callSendFileMiniFunction.enqueue(new CallbackWithRetry<MessangerOutput<SendFileMiniFunctionOutput>>(callSendFileMiniFunction) { // from class: ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.85
            @Override // retrofit2.Callback
            public void onResponse(Call<MessangerOutput<SendFileMiniFunctionOutput>> call, retrofit2.Response<MessangerOutput<SendFileMiniFunctionOutput>> response) {
                if (response.body() != null && response.isSuccessful()) {
                    response.body().makeData(((BaseController) ApiRequestMessanger.this).currentAccount, SendFileOutput.class);
                }
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.this;
                apiRequestMessanger.handlingOnResponse(new HandlingResponse(apiRequestMessanger, call, response, this), listener2);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<MessangerOutput<SendFileMiniFunctionOutput>> call, Throwable th) {
                listener2.onFailure(this, th);
            }
        });
        return callSendFileMiniFunction;
    }
}
