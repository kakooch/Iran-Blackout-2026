package ir.resaneh1.iptv.apiIPTV;

import android.os.Build;
import android.view.View;
import androidMessenger.utilites.AppFavorUtils;
import com.facebook.stetho.common.Utf8Charset;
import com.facebook.stetho.server.http.HttpHeaders;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.appUpdate.UpdateUtils;
import ir.resaneh1.iptv.dialog.ThreeButtonDialog;
import ir.resaneh1.iptv.enums.EnumActionObject;
import ir.resaneh1.iptv.enums.StatusEnum;
import ir.resaneh1.iptv.helper.CacheDatabaseHelper;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.AODObjectAbs;
import ir.resaneh1.iptv.model.AODObjectDet;
import ir.resaneh1.iptv.model.ActionOnObjectInput;
import ir.resaneh1.iptv.model.ApiCacheObject;
import ir.resaneh1.iptv.model.AppAbsObject;
import ir.resaneh1.iptv.model.BannerObjectAbs;
import ir.resaneh1.iptv.model.CommentObject;
import ir.resaneh1.iptv.model.CourseAbs;
import ir.resaneh1.iptv.model.CourseDet;
import ir.resaneh1.iptv.model.EPGListInput;
import ir.resaneh1.iptv.model.EPGListTVOutput;
import ir.resaneh1.iptv.model.GetBuyServiceInput;
import ir.resaneh1.iptv.model.GetBuyServiceOutput2;
import ir.resaneh1.iptv.model.GetCategoryHighlightListOutput;
import ir.resaneh1.iptv.model.GetCategoryHighlightsInput;
import ir.resaneh1.iptv.model.GetClubInfoOutput;
import ir.resaneh1.iptv.model.GetEPGPageOutput;
import ir.resaneh1.iptv.model.GetListInput;
import ir.resaneh1.iptv.model.GetListOutput;
import ir.resaneh1.iptv.model.GetListPayInput;
import ir.resaneh1.iptv.model.GetListPayOutput2;
import ir.resaneh1.iptv.model.GetNewsCategoryListOutput;
import ir.resaneh1.iptv.model.GetNewsInput;
import ir.resaneh1.iptv.model.GetNewsListInput;
import ir.resaneh1.iptv.model.GetNewsListOutput;
import ir.resaneh1.iptv.model.GetNewsOutput;
import ir.resaneh1.iptv.model.GetObjectInput;
import ir.resaneh1.iptv.model.GetObjectOutput;
import ir.resaneh1.iptv.model.GetPageInput;
import ir.resaneh1.iptv.model.GetPageOutput;
import ir.resaneh1.iptv.model.GetRelatedNewsInput;
import ir.resaneh1.iptv.model.GetStreamUrlInput;
import ir.resaneh1.iptv.model.GetStreamUrlOutput;
import ir.resaneh1.iptv.model.GetTokenPayInput;
import ir.resaneh1.iptv.model.GetTokenPayOutput2;
import ir.resaneh1.iptv.model.JJApiInput;
import ir.resaneh1.iptv.model.JJGetChampionOutput;
import ir.resaneh1.iptv.model.JJGetGroupsTabsOutput;
import ir.resaneh1.iptv.model.JJGetMatchAndTeamListInput;
import ir.resaneh1.iptv.model.JJGetMatchAndTeamListOutput;
import ir.resaneh1.iptv.model.JJGetMatchDetailsInput;
import ir.resaneh1.iptv.model.JJGetMatchDetailsOutput;
import ir.resaneh1.iptv.model.JJGetRankOutput;
import ir.resaneh1.iptv.model.JJGetTableOutput;
import ir.resaneh1.iptv.model.JJSetChampionInput;
import ir.resaneh1.iptv.model.JJSetChampionOutput;
import ir.resaneh1.iptv.model.JJVoteInput;
import ir.resaneh1.iptv.model.JJVoteOutput;
import ir.resaneh1.iptv.model.LinkItem;
import ir.resaneh1.iptv.model.OperatorObject;
import ir.resaneh1.iptv.model.StatusOutput;
import ir.resaneh1.iptv.model.TVChannelAbs;
import ir.resaneh1.iptv.model.TVObjectDet;
import ir.resaneh1.iptv.model.TvEpisodeObjectAbs;
import ir.resaneh1.iptv.model.VChannelItemAbs;
import ir.resaneh1.iptv.model.VODObjectAbs;
import ir.resaneh1.iptv.model.ViewStreamInput;
import ir.resaneh1.iptv.model.VirtualChannelAbs;
import ir.resaneh1.iptv.model.VodObjectDet;
import ir.resaneh1.iptv.musicplayer.NewMusicPlayerService;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.StringTokenizer;
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
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* loaded from: classes3.dex */
public class ApiRequestIPTV extends BaseController {
    private static final ApiRequestIPTV[] Instance = new ApiRequestIPTV[3];
    private static RestApiIPTV restApiIPTVService;
    private Charset UTF8;
    ThreeButtonDialog threeButtonDialog;

    public interface Listener {
        void onFailure(Call call, Throwable th);

        void onResponse(Call call, Response response);
    }

    public static ApiRequestIPTV getInstance(int i) {
        ApiRequestIPTV[] apiRequestIPTVArr = Instance;
        ApiRequestIPTV apiRequestIPTV = apiRequestIPTVArr[i];
        if (apiRequestIPTV == null) {
            synchronized (ApiRequestIPTV.class) {
                apiRequestIPTV = apiRequestIPTVArr[i];
                if (apiRequestIPTV == null) {
                    apiRequestIPTV = new ApiRequestIPTV(i);
                    apiRequestIPTVArr[i] = apiRequestIPTV;
                }
            }
        }
        return apiRequestIPTV;
    }

    public ApiRequestIPTV(int i) {
        super(i);
        this.UTF8 = null;
        this.UTF8 = Build.VERSION.SDK_INT >= 19 ? StandardCharsets.UTF_8 : Charset.forName(Utf8Charset.NAME);
        setRestApiService();
    }

    public RestApiIPTV getRestApiService() {
        return restApiIPTVService;
    }

    public void setRestApiService() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger(this) { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.1
            @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
            public void log(String str) {
                MyLog.e("LogApiIPTV", str);
            }
        });
        if (MyLog.isDebugAble) {
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        restApiIPTVService = (RestApiIPTV) new Retrofit.Builder().baseUrl(AppFavorUtils.baseUrlOld + "/api/v3.0/").addConverterFactory(GsonConverterFactory.create()).client(new OkHttpClient.Builder().addInterceptor(new Interceptor() { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.2
            @Override // okhttp3.Interceptor
            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
                ApiCacheObject apiCache;
                String strNextToken;
                String str;
                okhttp3.Response responseProceed;
                String str2;
                Request.Builder builderAddHeader = chain.request().newBuilder().addHeader("username", "android").addHeader("password", "lid9FS(33dlsdfljf").addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
                if (ApiRequestIPTV.this.getAppPreferences().getAuth() != null) {
                    builderAddHeader.addHeader("token", ApiRequestIPTV.this.getAppPreferences().getAuth());
                }
                builderAddHeader.addHeader("app_version", UpdateUtils.getAppVersion(ApplicationLoader.applicationContext));
                Request requestBuild = builderAddHeader.build();
                CacheDatabaseHelper cacheDatabaseHelper = CacheDatabaseHelper.getInstance(((BaseController) ApiRequestIPTV.this).currentAccount);
                String appVersion = UpdateUtils.getAppVersion(ApplicationLoader.applicationContext);
                Buffer buffer = new Buffer();
                if (requestBuild.body() != null) {
                    requestBuild.body().writeTo(buffer);
                }
                Charset charset = ApiRequestIPTV.this.UTF8;
                IOException iOException = null;
                MediaType mediaTypeContentType = requestBuild.body() != null ? requestBuild.body().contentType() : null;
                if (mediaTypeContentType == null || mediaTypeContentType.subtype() == null || !mediaTypeContentType.subtype().equals("json")) {
                    apiCache = null;
                    strNextToken = BuildConfig.FLAVOR;
                    str = strNextToken;
                } else {
                    charset = mediaTypeContentType.charset(ApiRequestIPTV.this.UTF8);
                    String string = buffer.readString(charset);
                    StringTokenizer stringTokenizer = new StringTokenizer(requestBuild.url().toString(), "/");
                    strNextToken = BuildConfig.FLAVOR;
                    while (stringTokenizer.hasMoreTokens()) {
                        strNextToken = stringTokenizer.nextToken();
                    }
                    try {
                        apiCache = cacheDatabaseHelper.getApiCache(strNextToken, string, appVersion);
                        str = string;
                    } catch (Exception unused) {
                        str = string;
                        apiCache = null;
                    }
                }
                if (apiCache != null && apiCache.output != null && apiCache.expiredTime.longValue() > System.currentTimeMillis()) {
                    return new Response.Builder().request(requestBuild).protocol(Protocol.HTTP_2).message(BuildConfig.FLAVOR).code(200).body(ResponseBody.create(MediaType.parse("application/json"), apiCache.output)).addHeader("fromCache", BuildConfig.FLAVOR).build();
                }
                try {
                    responseProceed = chain.proceed(requestBuild);
                } catch (IOException e) {
                    iOException = e;
                    responseProceed = null;
                }
                if (responseProceed == null || !responseProceed.isSuccessful()) {
                    if (apiCache != null && (str2 = apiCache.output) != null) {
                        return new Response.Builder().request(requestBuild).protocol(Protocol.HTTP_2).message(BuildConfig.FLAVOR).code(200).body(ResponseBody.create(MediaType.parse("application/json"), str2)).addHeader("fromCache", BuildConfig.FLAVOR).build();
                    }
                    if (iOException == null) {
                        return responseProceed;
                    }
                    throw iOException;
                }
                BufferedSource bufferedSourceSource = responseProceed.body().source();
                bufferedSourceSource.request(Long.MAX_VALUE);
                String string2 = bufferedSourceSource.buffer().clone().readString(charset);
                String strHeader = responseProceed.header("cache");
                Long lValueOf = 0L;
                if (strHeader != null) {
                    try {
                        lValueOf = Long.valueOf(Long.parseLong(strHeader));
                    } catch (Exception unused2) {
                    }
                    cacheDatabaseHelper.addOrUpdateApiCache(new ApiCacheObject(strNextToken, str, appVersion, string2, Long.valueOf(System.currentTimeMillis() + (lValueOf.longValue() * 1000))));
                }
                return responseProceed;
            }
        }).addInterceptor(httpLoggingInterceptor).build()).build().create(RestApiIPTV.class);
    }

    private class HandlingResponse {
        public Call call;
        public CallbackWithRetry callbackWithRetry;
        public retrofit2.Response response;

        public HandlingResponse(ApiRequestIPTV apiRequestIPTV, Call call, retrofit2.Response response, CallbackWithRetry callbackWithRetry) {
            this.call = call;
            this.response = response;
            this.callbackWithRetry = callbackWithRetry;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlingOnResponse(HandlingResponse handlingResponse, Listener listener) {
        String str;
        if (ApplicationLoader.applicationActivity != null) {
            if (!handlingResponse.response.isSuccessful()) {
                listener.onFailure(handlingResponse.call, null);
                if (FaildRequestHandler.isConnectedToInternet(ApplicationLoader.applicationActivity)) {
                    FaildRequestHandler.getInstance().ShowServerProblemDialog(ApplicationLoader.applicationActivity, handlingResponse.callbackWithRetry);
                    return;
                } else {
                    FaildRequestHandler.getInstance().ShowNetwrokConnectionProblemDialog(ApplicationLoader.applicationActivity, handlingResponse.callbackWithRetry);
                    return;
                }
            }
        } else {
            listener.onFailure(handlingResponse.call, null);
        }
        final StatusOutput statusOutput = (StatusOutput) handlingResponse.response.body();
        if (statusOutput == null) {
            listener.onFailure(handlingResponse.call, null);
            return;
        }
        StatusEnum statusEnum = statusOutput.status;
        if (statusEnum == null) {
            listener.onFailure(handlingResponse.call, null);
            return;
        }
        int i = AnonymousClass49.$SwitchMap$ir$resaneh1$iptv$enums$StatusEnum[statusEnum.ordinal()];
        if (i == 1) {
            ArrayList<StatusOutput.Error> arrayList = statusOutput.errors;
            if (arrayList != null && arrayList.size() > 0) {
                ToastiLikeSnack.showL(ApplicationLoader.applicationContext, statusOutput.errors.get(0).errorMessage);
            }
            listener.onFailure(handlingResponse.call, null);
            return;
        }
        if (i == 2) {
            listener.onResponse(handlingResponse.call, handlingResponse.response);
            return;
        }
        if (i != 4) {
            if (i == 5 && listener != null) {
                try {
                    listener.onResponse(handlingResponse.call, handlingResponse.response);
                    return;
                } catch (Exception e) {
                    MyLog.handleException(e);
                    return;
                }
            }
            return;
        }
        ThreeButtonDialog threeButtonDialog = this.threeButtonDialog;
        if (threeButtonDialog != null && threeButtonDialog.isShowing()) {
            try {
                this.threeButtonDialog.dismiss();
            } catch (Exception unused) {
            }
        }
        if (ApplicationLoader.applicationActivity != null && (str = statusOutput.status_message) != null && !str.isEmpty()) {
            ThreeButtonDialog threeButtonDialog2 = new ThreeButtonDialog(ApplicationLoader.applicationActivity, statusOutput.status_message);
            this.threeButtonDialog = threeButtonDialog2;
            if (statusOutput.status_link != null) {
                threeButtonDialog2.button1.setText("باشه");
                this.threeButtonDialog.button2.setText("انصراف");
                this.threeButtonDialog.button1.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        try {
                            new MainClickHandler().onLinkClick(ApplicationLoader.applicationActivity.getLastFragment(), statusOutput.status_link);
                            ApiRequestIPTV.this.threeButtonDialog.dismiss();
                        } catch (Exception unused2) {
                        }
                    }
                });
                this.threeButtonDialog.button2.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        try {
                            ApiRequestIPTV.this.threeButtonDialog.dismiss();
                        } catch (Exception unused2) {
                        }
                    }
                });
            } else {
                threeButtonDialog2.button1.setText("باشه");
                this.threeButtonDialog.button1.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        try {
                            ApiRequestIPTV.this.threeButtonDialog.dismiss();
                        } catch (Exception unused2) {
                        }
                    }
                });
            }
        }
        listener.onFailure(handlingResponse.call, null);
    }

    /* renamed from: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV$49, reason: invalid class name */
    static /* synthetic */ class AnonymousClass49 {
        static final /* synthetic */ int[] $SwitchMap$ir$resaneh1$iptv$enums$StatusEnum;

        static {
            int[] iArr = new int[StatusEnum.values().length];
            $SwitchMap$ir$resaneh1$iptv$enums$StatusEnum = iArr;
            try {
                iArr[StatusEnum.error.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$enums$StatusEnum[StatusEnum.invalid_username_or_pass.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$enums$StatusEnum[StatusEnum.invalid_token.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$enums$StatusEnum[StatusEnum.show_message.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$enums$StatusEnum[StatusEnum.ok.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public Call<GetPageOutput> getPage(GetPageInput getPageInput, final Listener listener) {
        String str;
        if (getPageInput.type.startsWith("app")) {
            str = "https://shas.iranlms.ir/api/v1.0/";
        } else {
            str = AppFavorUtils.baseUrlOld + "/api/v3.0/";
        }
        Call<GetPageOutput> page = getRestApiService().getPage(str + "getPagev", getPageInput);
        page.enqueue(new CallbackWithRetry<GetPageOutput>(page) { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.6
            @Override // retrofit2.Callback
            public void onResponse(Call<GetPageOutput> call, retrofit2.Response<GetPageOutput> response) {
                ApiRequestIPTV apiRequestIPTV = ApiRequestIPTV.this;
                apiRequestIPTV.handlingOnResponse(new HandlingResponse(apiRequestIPTV, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<GetPageOutput> call, Throwable th) {
                super.onFailure(call, th);
                listener.onFailure(call, th);
            }
        });
        return page;
    }

    public Call<GetListOutput<VirtualChannelAbs>> getVirtualChannelAbsList(GetListInput getListInput, final Listener listener) {
        Call<GetListOutput<VirtualChannelAbs>> virtualChannelAbs = getRestApiService().getVirtualChannelAbs(getListInput);
        virtualChannelAbs.enqueue(new CallbackWithRetry<GetListOutput<VirtualChannelAbs>>(virtualChannelAbs) { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.7
            @Override // retrofit2.Callback
            public void onResponse(Call<GetListOutput<VirtualChannelAbs>> call, retrofit2.Response<GetListOutput<VirtualChannelAbs>> response) {
                ApiRequestIPTV apiRequestIPTV = ApiRequestIPTV.this;
                apiRequestIPTV.handlingOnResponse(new HandlingResponse(apiRequestIPTV, call, response, this), listener);
                MyLog.e("Apirequest", "onResponse: getVirtualChannelAbsList");
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<GetListOutput<VirtualChannelAbs>> call, Throwable th) {
                listener.onFailure(call, th);
                super.onFailure(call, th);
            }
        });
        return virtualChannelAbs;
    }

    public Call<GetListOutput<AppAbsObject>> getAppAbsList(GetListInput getListInput, final Listener listener) {
        Call<GetListOutput<AppAbsObject>> appAbsList = getRestApiService().getAppAbsList("https://shas.iranlms.ir/api/v1.0/getList", getListInput);
        appAbsList.enqueue(new CallbackWithRetry<GetListOutput<AppAbsObject>>(appAbsList) { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.8
            @Override // retrofit2.Callback
            public void onResponse(Call<GetListOutput<AppAbsObject>> call, retrofit2.Response<GetListOutput<AppAbsObject>> response) {
                ApiRequestIPTV apiRequestIPTV = ApiRequestIPTV.this;
                apiRequestIPTV.handlingOnResponse(new HandlingResponse(apiRequestIPTV, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<GetListOutput<AppAbsObject>> call, Throwable th) {
                listener.onFailure(call, th);
                super.onFailure(call, th);
            }
        });
        return appAbsList;
    }

    public Call<GetListOutput<VODObjectAbs>> getVODObjectAbsList(GetListInput getListInput, final Listener listener) {
        Call<GetListOutput<VODObjectAbs>> vODAbsList = getRestApiService().getVODAbsList(getListInput);
        vODAbsList.enqueue(new CallbackWithRetry<GetListOutput<VODObjectAbs>>(vODAbsList) { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.9
            @Override // retrofit2.Callback
            public void onResponse(Call<GetListOutput<VODObjectAbs>> call, retrofit2.Response<GetListOutput<VODObjectAbs>> response) {
                ApiRequestIPTV apiRequestIPTV = ApiRequestIPTV.this;
                apiRequestIPTV.handlingOnResponse(new HandlingResponse(apiRequestIPTV, call, response, this), listener);
                MyLog.e("Apirequest", "onResponse: getVODObjectAbsList");
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<GetListOutput<VODObjectAbs>> call, Throwable th) {
                MyLog.e("Apirequest", "onFailure: getVODObjectAbsList");
                listener.onFailure(call, th);
                super.onFailure(call, th);
            }
        });
        return vODAbsList;
    }

    public Call<GetListOutput<LinkItem>> getLinkItemList(GetListInput getListInput, final Listener listener) {
        Call<GetListOutput<LinkItem>> linkItemList = getRestApiService().getLinkItemList(getListInput);
        linkItemList.enqueue(new CallbackWithRetry<GetListOutput<LinkItem>>(linkItemList) { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.10
            @Override // retrofit2.Callback
            public void onResponse(Call<GetListOutput<LinkItem>> call, retrofit2.Response<GetListOutput<LinkItem>> response) {
                ApiRequestIPTV apiRequestIPTV = ApiRequestIPTV.this;
                apiRequestIPTV.handlingOnResponse(new HandlingResponse(apiRequestIPTV, call, response, this), listener);
                MyLog.e("Apirequest", "onResponse: getVODObjectAbsList");
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<GetListOutput<LinkItem>> call, Throwable th) {
                MyLog.e("Apirequest", "onFailure: getVODObjectAbsList");
                listener.onFailure(call, th);
                super.onFailure(call, th);
            }
        });
        return linkItemList;
    }

    public Call<GetListOutput<TvEpisodeObjectAbs>> getTVEpisodeObjectAbsList(GetListInput getListInput, final Listener listener) {
        Call<GetListOutput<TvEpisodeObjectAbs>> tVEpisodeAbsList = getRestApiService().getTVEpisodeAbsList(getListInput);
        tVEpisodeAbsList.enqueue(new CallbackWithRetry<GetListOutput<TvEpisodeObjectAbs>>(tVEpisodeAbsList) { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.11
            @Override // retrofit2.Callback
            public void onResponse(Call<GetListOutput<TvEpisodeObjectAbs>> call, retrofit2.Response<GetListOutput<TvEpisodeObjectAbs>> response) {
                ApiRequestIPTV apiRequestIPTV = ApiRequestIPTV.this;
                apiRequestIPTV.handlingOnResponse(new HandlingResponse(apiRequestIPTV, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<GetListOutput<TvEpisodeObjectAbs>> call, Throwable th) {
                listener.onFailure(call, th);
                super.onFailure(call, th);
            }
        });
        return tVEpisodeAbsList;
    }

    public Call<GetListOutput<TVChannelAbs>> getTVChannelAbsList(GetListInput getListInput, final Listener listener) {
        Call<GetListOutput<TVChannelAbs>> tVChannelAbsList = getRestApiService().getTVChannelAbsList(getListInput);
        tVChannelAbsList.enqueue(new CallbackWithRetry<GetListOutput<TVChannelAbs>>(tVChannelAbsList) { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.12
            @Override // retrofit2.Callback
            public void onResponse(Call<GetListOutput<TVChannelAbs>> call, retrofit2.Response<GetListOutput<TVChannelAbs>> response) {
                ApiRequestIPTV apiRequestIPTV = ApiRequestIPTV.this;
                apiRequestIPTV.handlingOnResponse(new HandlingResponse(apiRequestIPTV, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<GetListOutput<TVChannelAbs>> call, Throwable th) {
                listener.onFailure(call, th);
                super.onFailure(call, th);
            }
        });
        return tVChannelAbsList;
    }

    public Call<GetListOutput<AODObjectAbs>> getAODObjectAbsList(GetListInput getListInput, final Listener listener) {
        Call<GetListOutput<AODObjectAbs>> aodAbsList = getRestApiService().getAodAbsList(getListInput);
        aodAbsList.enqueue(new CallbackWithRetry<GetListOutput<AODObjectAbs>>(aodAbsList) { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.13
            @Override // retrofit2.Callback
            public void onResponse(Call<GetListOutput<AODObjectAbs>> call, retrofit2.Response<GetListOutput<AODObjectAbs>> response) {
                ApiRequestIPTV apiRequestIPTV = ApiRequestIPTV.this;
                apiRequestIPTV.handlingOnResponse(new HandlingResponse(apiRequestIPTV, call, response, this), listener);
                MyLog.e("Apirequest", "onResponse: getAODObjectAbsList");
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<GetListOutput<AODObjectAbs>> call, Throwable th) {
                MyLog.e("Apirequest", "onFailure: getAODObjectAbsList");
                listener.onFailure(call, th);
                super.onFailure(call, th);
            }
        });
        return aodAbsList;
    }

    public Call<GetListOutput<BannerObjectAbs>> getLargeBannerList(GetListInput getListInput, final Listener listener) {
        Call<GetListOutput<BannerObjectAbs>> largeBannerList = getRestApiService().getLargeBannerList(getListInput);
        largeBannerList.enqueue(new CallbackWithRetry<GetListOutput<BannerObjectAbs>>(largeBannerList) { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.14
            @Override // retrofit2.Callback
            public void onResponse(Call<GetListOutput<BannerObjectAbs>> call, retrofit2.Response<GetListOutput<BannerObjectAbs>> response) {
                ApiRequestIPTV apiRequestIPTV = ApiRequestIPTV.this;
                apiRequestIPTV.handlingOnResponse(new HandlingResponse(apiRequestIPTV, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<GetListOutput<BannerObjectAbs>> call, Throwable th) {
                listener.onFailure(call, th);
                super.onFailure(call, th);
            }
        });
        return largeBannerList;
    }

    public Call<GetListOutput<OperatorObject>> getOperators(GetListInput getListInput, final Listener listener) {
        Call<GetListOutput<OperatorObject>> operatorList = getRestApiService().getOperatorList(getListInput);
        operatorList.enqueue(new CallbackWithRetry<GetListOutput<OperatorObject>>(operatorList) { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.15
            @Override // retrofit2.Callback
            public void onResponse(Call<GetListOutput<OperatorObject>> call, retrofit2.Response<GetListOutput<OperatorObject>> response) {
                ApiRequestIPTV apiRequestIPTV = ApiRequestIPTV.this;
                apiRequestIPTV.handlingOnResponse(new HandlingResponse(apiRequestIPTV, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<GetListOutput<OperatorObject>> call, Throwable th) {
                listener.onFailure(call, th);
                super.onFailure(call, th);
            }
        });
        return operatorList;
    }

    public Call<GetListOutput<CourseAbs>> getlmsCourceList(GetListInput getListInput, final Listener listener) {
        Call<GetListOutput<CourseAbs>> lmsCourseList = getRestApiService().getLmsCourseList(getListInput);
        lmsCourseList.enqueue(new CallbackWithRetry<GetListOutput<CourseAbs>>(lmsCourseList) { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.16
            @Override // retrofit2.Callback
            public void onResponse(Call<GetListOutput<CourseAbs>> call, retrofit2.Response<GetListOutput<CourseAbs>> response) {
                ApiRequestIPTV apiRequestIPTV = ApiRequestIPTV.this;
                apiRequestIPTV.handlingOnResponse(new HandlingResponse(apiRequestIPTV, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<GetListOutput<CourseAbs>> call, Throwable th) {
                listener.onFailure(call, th);
                super.onFailure(call, th);
            }
        });
        return lmsCourseList;
    }

    public Call<GetObjectOutput<TVObjectDet>> getTVEpisodeDetObject(GetObjectInput getObjectInput, final Listener listener) {
        Call<GetObjectOutput<TVObjectDet>> tVEpisodeDet = getRestApiService().getTVEpisodeDet(getObjectInput);
        tVEpisodeDet.enqueue(new CallbackWithRetry<GetObjectOutput<TVObjectDet>>(tVEpisodeDet) { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.17
            @Override // retrofit2.Callback
            public void onResponse(Call<GetObjectOutput<TVObjectDet>> call, retrofit2.Response<GetObjectOutput<TVObjectDet>> response) {
                ApiRequestIPTV apiRequestIPTV = ApiRequestIPTV.this;
                apiRequestIPTV.handlingOnResponse(new HandlingResponse(apiRequestIPTV, call, response, this), listener);
                MyLog.e("Apirequest", "onResponse: getVirtualChannelDet");
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<GetObjectOutput<TVObjectDet>> call, Throwable th) {
                MyLog.e("Apirequest", "onFailure: getVirtualChannelDet");
                listener.onFailure(call, th);
                super.onFailure(call, th);
            }
        });
        return tVEpisodeDet;
    }

    public Call<GetListOutput<VChannelItemAbs>> getVChannelItemList(GetListInput getListInput, final Listener listener) {
        Call<GetListOutput<VChannelItemAbs>> vChannelItemList = getRestApiService().getVChannelItemList(getListInput);
        vChannelItemList.enqueue(new CallbackWithRetry<GetListOutput<VChannelItemAbs>>(vChannelItemList) { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.18
            @Override // retrofit2.Callback
            public void onResponse(Call<GetListOutput<VChannelItemAbs>> call, retrofit2.Response<GetListOutput<VChannelItemAbs>> response) {
                ApiRequestIPTV apiRequestIPTV = ApiRequestIPTV.this;
                apiRequestIPTV.handlingOnResponse(new HandlingResponse(apiRequestIPTV, call, response, this), listener);
                MyLog.e("Apirequest", "onResponse: getVChannelItemList");
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<GetListOutput<VChannelItemAbs>> call, Throwable th) {
                MyLog.e("Apirequest", "onFailure: getVChannelItemList");
                listener.onFailure(call, th);
                super.onFailure(call, th);
            }
        });
        return vChannelItemList;
    }

    public Call<GetListOutput<CommentObject>> getComments(GetListInput getListInput, final Listener listener) {
        String str;
        if (getListInput.tag.tag_id.startsWith("app")) {
            str = "https://shas.iranlms.ir/api/v1.0/";
        } else {
            str = AppFavorUtils.baseUrlOld + "/api/v3.0/";
        }
        Call<GetListOutput<CommentObject>> commentList = getRestApiService().getCommentList(str + "getList", getListInput);
        commentList.enqueue(new CallbackWithRetry<GetListOutput<CommentObject>>(commentList) { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.19
            @Override // retrofit2.Callback
            public void onResponse(Call<GetListOutput<CommentObject>> call, retrofit2.Response<GetListOutput<CommentObject>> response) {
                ApiRequestIPTV apiRequestIPTV = ApiRequestIPTV.this;
                apiRequestIPTV.handlingOnResponse(new HandlingResponse(apiRequestIPTV, call, response, this), listener);
                MyLog.e("Apirequest", "onResponse: getCommentForPost");
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<GetListOutput<CommentObject>> call, Throwable th) {
                MyLog.e("Apirequest", "onFailure: getCommentForPost");
                listener.onFailure(call, th);
                super.onFailure(call, th);
            }
        });
        return commentList;
    }

    public Call<GetObjectOutput<CourseDet>> getCourseDetObject(GetObjectInput getObjectInput, final Listener listener) {
        Call<GetObjectOutput<CourseDet>> courseObject = getRestApiService().getCourseObject(getObjectInput);
        courseObject.enqueue(new CallbackWithRetry<GetObjectOutput<CourseDet>>(courseObject) { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.20
            @Override // retrofit2.Callback
            public void onResponse(Call<GetObjectOutput<CourseDet>> call, retrofit2.Response<GetObjectOutput<CourseDet>> response) {
                ApiRequestIPTV apiRequestIPTV = ApiRequestIPTV.this;
                apiRequestIPTV.handlingOnResponse(new HandlingResponse(apiRequestIPTV, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<GetObjectOutput<CourseDet>> call, Throwable th) {
                listener.onFailure(call, th);
                super.onFailure(call, th);
            }
        });
        return courseObject;
    }

    public Call<GetObjectOutput<VodObjectDet>> getVodObjectDet(GetObjectInput getObjectInput, final Listener listener) {
        Call<GetObjectOutput<VodObjectDet>> vodDetObject = getRestApiService().getVodDetObject(getObjectInput);
        vodDetObject.enqueue(new CallbackWithRetry<GetObjectOutput<VodObjectDet>>(vodDetObject) { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.22
            @Override // retrofit2.Callback
            public void onResponse(Call<GetObjectOutput<VodObjectDet>> call, retrofit2.Response<GetObjectOutput<VodObjectDet>> response) {
                ApiRequestIPTV apiRequestIPTV = ApiRequestIPTV.this;
                apiRequestIPTV.handlingOnResponse(new HandlingResponse(apiRequestIPTV, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<GetObjectOutput<VodObjectDet>> call, Throwable th) {
                MyLog.e("Apirequest", "onFailure: getVodObjectDet");
                listener.onFailure(call, th);
                super.onFailure(call, th);
            }
        });
        return vodDetObject;
    }

    public Call<GetObjectOutput<AODObjectDet>> getAodObjectDet(GetObjectInput getObjectInput, final Listener listener) {
        Call<GetObjectOutput<AODObjectDet>> aodDetObject = getRestApiService().getAodDetObject(getObjectInput);
        aodDetObject.enqueue(new CallbackWithRetry<GetObjectOutput<AODObjectDet>>(aodDetObject) { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.23
            @Override // retrofit2.Callback
            public void onResponse(Call<GetObjectOutput<AODObjectDet>> call, retrofit2.Response<GetObjectOutput<AODObjectDet>> response) {
                ApiRequestIPTV apiRequestIPTV = ApiRequestIPTV.this;
                apiRequestIPTV.handlingOnResponse(new HandlingResponse(apiRequestIPTV, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<GetObjectOutput<AODObjectDet>> call, Throwable th) {
                MyLog.e("Apirequest", "onFailure: getVodObjectDet");
                listener.onFailure(call, th);
                super.onFailure(call, th);
            }
        });
        return aodDetObject;
    }

    public Call<GetStreamUrlOutput> getStreamUrl(GetStreamUrlInput getStreamUrlInput, final Listener listener) {
        Call<GetStreamUrlOutput> streamUrl2 = getRestApiService().getStreamUrl2(getStreamUrlInput);
        streamUrl2.enqueue(new CallbackWithRetry<GetStreamUrlOutput>(streamUrl2) { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.24
            @Override // retrofit2.Callback
            public void onResponse(Call<GetStreamUrlOutput> call, retrofit2.Response<GetStreamUrlOutput> response) {
                ApiRequestIPTV apiRequestIPTV = ApiRequestIPTV.this;
                apiRequestIPTV.handlingOnResponse(new HandlingResponse(apiRequestIPTV, call, response, this), listener);
                try {
                    if (response.body().status != StatusEnum.ok) {
                        NewMusicPlayerService.staticStopService(ApplicationLoader.applicationContext);
                    }
                } catch (Exception unused) {
                }
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<GetStreamUrlOutput> call, Throwable th) {
                listener.onFailure(call, th);
                super.onFailure(call, th);
            }
        });
        return streamUrl2;
    }

    public Call<StatusOutput> viewStream(ViewStreamInput viewStreamInput, Listener listener) {
        Call<StatusOutput> callViewStream = getRestApiService().viewStream(viewStreamInput);
        callViewStream.enqueue(new CallbackWithRetry<StatusOutput>(this, callViewStream) { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.25
            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<StatusOutput> call, Throwable th) {
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<StatusOutput> call, retrofit2.Response<StatusOutput> response) {
            }
        });
        return callViewStream;
    }

    public Call<StatusOutput> actionOnObject(final ActionOnObjectInput actionOnObjectInput, final Listener listener) {
        String str;
        if (actionOnObjectInput.id.startsWith("app")) {
            str = "https://shas.iranlms.ir/api/v1.0/";
        } else {
            str = AppFavorUtils.baseUrlOld + "/api/v3.0/";
        }
        Call<StatusOutput> callActionOnObject = getRestApiService().actionOnObject(str + "actionOnObject", actionOnObjectInput);
        callActionOnObject.enqueue(new CallbackWithRetry<StatusOutput>(callActionOnObject) { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.26
            @Override // retrofit2.Callback
            public void onResponse(Call<StatusOutput> call, retrofit2.Response<StatusOutput> response) {
                EnumActionObject enumActionObject = actionOnObjectInput.action;
                if (enumActionObject == EnumActionObject.like || enumActionObject == EnumActionObject.remove_like) {
                    return;
                }
                ApiRequestIPTV apiRequestIPTV = ApiRequestIPTV.this;
                apiRequestIPTV.handlingOnResponse(new HandlingResponse(apiRequestIPTV, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<StatusOutput> call, Throwable th) {
                EnumActionObject enumActionObject = actionOnObjectInput.action;
                if (enumActionObject == EnumActionObject.like || enumActionObject == EnumActionObject.remove_like) {
                    return;
                }
                listener.onFailure(call, th);
                super.onFailure(call, th);
            }
        });
        return callActionOnObject;
    }

    public Call<EPGListTVOutput> getEpgList(EPGListInput ePGListInput, final Listener listener) {
        Call<EPGListTVOutput> ePGListTV = getRestApiService().getEPGListTV(ePGListInput);
        ePGListTV.enqueue(new CallbackWithRetry<EPGListTVOutput>(ePGListTV) { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.27
            @Override // retrofit2.Callback
            public void onResponse(Call<EPGListTVOutput> call, retrofit2.Response<EPGListTVOutput> response) {
                ApiRequestIPTV apiRequestIPTV = ApiRequestIPTV.this;
                apiRequestIPTV.handlingOnResponse(new HandlingResponse(apiRequestIPTV, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<EPGListTVOutput> call, Throwable th) {
                listener.onFailure(call, th);
                super.onFailure(call, th);
            }
        });
        return ePGListTV;
    }

    public Call<GetEPGPageOutput> getEpgPage(final Listener listener) {
        Call<GetEPGPageOutput> ePGPageTV = getRestApiService().getEPGPageTV();
        ePGPageTV.enqueue(new CallbackWithRetry<GetEPGPageOutput>(ePGPageTV) { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.28
            @Override // retrofit2.Callback
            public void onResponse(Call<GetEPGPageOutput> call, retrofit2.Response<GetEPGPageOutput> response) {
                ApiRequestIPTV apiRequestIPTV = ApiRequestIPTV.this;
                apiRequestIPTV.handlingOnResponse(new HandlingResponse(apiRequestIPTV, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<GetEPGPageOutput> call, Throwable th) {
                listener.onFailure(call, th);
                super.onFailure(call, th);
            }
        });
        return ePGPageTV;
    }

    public Call<GetClubInfoOutput> getClubInfo(final Listener listener) {
        Call<GetClubInfoOutput> clubInfo = getRestApiService().getClubInfo();
        clubInfo.enqueue(new CallbackWithRetry<GetClubInfoOutput>(clubInfo) { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.30
            @Override // retrofit2.Callback
            public void onResponse(Call<GetClubInfoOutput> call, retrofit2.Response<GetClubInfoOutput> response) {
                ApiRequestIPTV apiRequestIPTV = ApiRequestIPTV.this;
                apiRequestIPTV.handlingOnResponse(new HandlingResponse(apiRequestIPTV, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<GetClubInfoOutput> call, Throwable th) {
                listener.onFailure(call, th);
                super.onFailure(call, th);
            }
        });
        return clubInfo;
    }

    public Call<GetTokenPayOutput2> getTokenPay(GetTokenPayInput getTokenPayInput, final Listener listener) {
        Call<GetTokenPayOutput2> tokenPay = getRestApiService().getTokenPay(AppFavorUtils.payUrlOld + "registerdevice", getTokenPayInput);
        tokenPay.enqueue(new CallbackWithRetry<GetTokenPayOutput2>(tokenPay) { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.31
            @Override // retrofit2.Callback
            public void onResponse(Call<GetTokenPayOutput2> call, retrofit2.Response<GetTokenPayOutput2> response) {
                ApiRequestIPTV apiRequestIPTV = ApiRequestIPTV.this;
                apiRequestIPTV.handlingOnResponse(new HandlingResponse(apiRequestIPTV, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<GetTokenPayOutput2> call, Throwable th) {
                listener.onFailure(call, th);
                super.onFailure(call, th);
            }
        });
        return tokenPay;
    }

    public Call<GetListPayOutput2> getListPay(GetListPayInput getListPayInput, final Listener listener) {
        Call<GetListPayOutput2> listPay = getRestApiService().getListPay(AppFavorUtils.payUrlOld + "getpubliclist", getListPayInput);
        listPay.enqueue(new CallbackWithRetry<GetListPayOutput2>(listPay) { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.32
            @Override // retrofit2.Callback
            public void onResponse(Call<GetListPayOutput2> call, retrofit2.Response<GetListPayOutput2> response) {
                ApiRequestIPTV apiRequestIPTV = ApiRequestIPTV.this;
                apiRequestIPTV.handlingOnResponse(new HandlingResponse(apiRequestIPTV, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<GetListPayOutput2> call, Throwable th) {
                listener.onFailure(call, th);
                super.onFailure(call, th);
            }
        });
        return listPay;
    }

    public Call<GetBuyServiceOutput2> getBuyServicePay(GetBuyServiceInput getBuyServiceInput, final Listener listener) {
        Call<GetBuyServiceOutput2> buyServicePay = getRestApiService().getBuyServicePay(AppFavorUtils.payUrlOld + "service", getBuyServiceInput);
        buyServicePay.enqueue(new CallbackWithRetry<GetBuyServiceOutput2>(buyServicePay) { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.33
            @Override // retrofit2.Callback
            public void onResponse(Call<GetBuyServiceOutput2> call, retrofit2.Response<GetBuyServiceOutput2> response) {
                if (response.isSuccessful()) {
                    ApiRequestIPTV apiRequestIPTV = ApiRequestIPTV.this;
                    apiRequestIPTV.handlingOnResponse(new HandlingResponse(apiRequestIPTV, call, response, this), listener);
                } else {
                    ToastiLikeSnack.showL(ApplicationLoader.applicationContext, "خطا در اتصال");
                }
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<GetBuyServiceOutput2> call, Throwable th) {
                listener.onFailure(call, th);
            }
        });
        return buyServicePay;
    }

    public Call<GetNewsCategoryListOutput> getNewsCategoryList(final Listener listener) {
        Call<GetNewsCategoryListOutput> categoryList = getRestApiService().getCategoryList(AppFavorUtils.newsUrlOld + "getCategoryList");
        categoryList.enqueue(new CallbackWithRetry<GetNewsCategoryListOutput>(categoryList) { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.34
            @Override // retrofit2.Callback
            public void onResponse(Call<GetNewsCategoryListOutput> call, retrofit2.Response<GetNewsCategoryListOutput> response) {
                ApiRequestIPTV apiRequestIPTV = ApiRequestIPTV.this;
                apiRequestIPTV.handlingOnResponse(new HandlingResponse(apiRequestIPTV, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<GetNewsCategoryListOutput> call, Throwable th) {
                listener.onFailure(call, th);
                super.onFailure(call, th);
            }
        });
        return categoryList;
    }

    public Call<GetCategoryHighlightListOutput> getCategoryHighlights(GetCategoryHighlightsInput getCategoryHighlightsInput, final Listener listener) {
        Call<GetCategoryHighlightListOutput> categoryHighlights = getRestApiService().getCategoryHighlights(AppFavorUtils.newsUrlOld + "getCategoryHighlights", getCategoryHighlightsInput);
        categoryHighlights.enqueue(new CallbackWithRetry<GetCategoryHighlightListOutput>(categoryHighlights) { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.35
            @Override // retrofit2.Callback
            public void onResponse(Call<GetCategoryHighlightListOutput> call, retrofit2.Response<GetCategoryHighlightListOutput> response) {
                ApiRequestIPTV apiRequestIPTV = ApiRequestIPTV.this;
                apiRequestIPTV.handlingOnResponse(new HandlingResponse(apiRequestIPTV, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<GetCategoryHighlightListOutput> call, Throwable th) {
                listener.onFailure(call, th);
                super.onFailure(call, th);
            }
        });
        return categoryHighlights;
    }

    public Call<GetNewsListOutput> getNewestNewsList(GetNewsListInput getNewsListInput, final Listener listener) {
        Call<GetNewsListOutput> newestNewsList = getRestApiService().getNewestNewsList(AppFavorUtils.newsUrlOld + "getNewestNewsList", getNewsListInput);
        newestNewsList.enqueue(new CallbackWithRetry<GetNewsListOutput>(newestNewsList) { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.36
            @Override // retrofit2.Callback
            public void onResponse(Call<GetNewsListOutput> call, retrofit2.Response<GetNewsListOutput> response) {
                ApiRequestIPTV apiRequestIPTV = ApiRequestIPTV.this;
                apiRequestIPTV.handlingOnResponse(new HandlingResponse(apiRequestIPTV, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<GetNewsListOutput> call, Throwable th) {
                listener.onFailure(call, th);
                super.onFailure(call, th);
            }
        });
        return newestNewsList;
    }

    public Call<GetNewsListOutput> getMostVisitedNewsList(GetNewsListInput getNewsListInput, final Listener listener) {
        Call<GetNewsListOutput> mostVisitedNewsList = getRestApiService().getMostVisitedNewsList(AppFavorUtils.newsUrlOld + "getMostVisitedNewsList", getNewsListInput);
        mostVisitedNewsList.enqueue(new CallbackWithRetry<GetNewsListOutput>(mostVisitedNewsList) { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.37
            @Override // retrofit2.Callback
            public void onResponse(Call<GetNewsListOutput> call, retrofit2.Response<GetNewsListOutput> response) {
                ApiRequestIPTV apiRequestIPTV = ApiRequestIPTV.this;
                apiRequestIPTV.handlingOnResponse(new HandlingResponse(apiRequestIPTV, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<GetNewsListOutput> call, Throwable th) {
                listener.onFailure(call, th);
                super.onFailure(call, th);
            }
        });
        return mostVisitedNewsList;
    }

    public Call<GetNewsOutput> getNews(GetNewsInput getNewsInput, final Listener listener) {
        Call<GetNewsOutput> news = getRestApiService().getNews(AppFavorUtils.newsUrlOld + "getNews", getNewsInput);
        news.enqueue(new CallbackWithRetry<GetNewsOutput>(news) { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.38
            @Override // retrofit2.Callback
            public void onResponse(Call<GetNewsOutput> call, retrofit2.Response<GetNewsOutput> response) {
                ApiRequestIPTV apiRequestIPTV = ApiRequestIPTV.this;
                apiRequestIPTV.handlingOnResponse(new HandlingResponse(apiRequestIPTV, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<GetNewsOutput> call, Throwable th) {
                listener.onFailure(call, th);
                super.onFailure(call, th);
            }
        });
        return news;
    }

    public Call<GetNewsListOutput> getRelatedNewsList(GetRelatedNewsInput getRelatedNewsInput, final Listener listener) {
        Call<GetNewsListOutput> relatedNews = getRestApiService().getRelatedNews(AppFavorUtils.newsUrlOld + "getRelatedNewsList", getRelatedNewsInput);
        relatedNews.enqueue(new CallbackWithRetry<GetNewsListOutput>(relatedNews) { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.39
            @Override // retrofit2.Callback
            public void onResponse(Call<GetNewsListOutput> call, retrofit2.Response<GetNewsListOutput> response) {
                ApiRequestIPTV apiRequestIPTV = ApiRequestIPTV.this;
                apiRequestIPTV.handlingOnResponse(new HandlingResponse(apiRequestIPTV, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<GetNewsListOutput> call, Throwable th) {
                listener.onFailure(call, th);
                super.onFailure(call, th);
            }
        });
        return relatedNews;
    }

    public Call<JJGetTableOutput> getJJTable(JJApiInput jJApiInput, final Listener listener) {
        Call<JJGetTableOutput> jJTable = getRestApiService().getJJTable(AppFavorUtils.jjUrl + "getTable", jJApiInput);
        jJTable.enqueue(new CallbackWithRetry<JJGetTableOutput>(jJTable) { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.40
            @Override // retrofit2.Callback
            public void onResponse(Call<JJGetTableOutput> call, retrofit2.Response<JJGetTableOutput> response) {
                ApiRequestIPTV apiRequestIPTV = ApiRequestIPTV.this;
                apiRequestIPTV.handlingOnResponse(new HandlingResponse(apiRequestIPTV, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<JJGetTableOutput> call, Throwable th) {
                listener.onFailure(call, th);
                super.onFailure(call, th);
            }
        });
        return jJTable;
    }

    public Call<JJGetMatchDetailsOutput> getJJMatchDetail(JJGetMatchDetailsInput jJGetMatchDetailsInput, final Listener listener) {
        Call<JJGetMatchDetailsOutput> jJMatchDetail = getRestApiService().getJJMatchDetail(AppFavorUtils.jjUrl + "getMatchStats", jJGetMatchDetailsInput);
        jJMatchDetail.enqueue(new CallbackWithRetry<JJGetMatchDetailsOutput>(jJMatchDetail) { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.41
            @Override // retrofit2.Callback
            public void onResponse(Call<JJGetMatchDetailsOutput> call, retrofit2.Response<JJGetMatchDetailsOutput> response) {
                ApiRequestIPTV apiRequestIPTV = ApiRequestIPTV.this;
                apiRequestIPTV.handlingOnResponse(new HandlingResponse(apiRequestIPTV, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<JJGetMatchDetailsOutput> call, Throwable th) {
                listener.onFailure(call, th);
                super.onFailure(call, th);
            }
        });
        return jJMatchDetail;
    }

    public Call<JJGetGroupsTabsOutput> getGroupsTabs(JJApiInput jJApiInput, final Listener listener) {
        Call<JJGetGroupsTabsOutput> jJGroupsTabs = getRestApiService().getJJGroupsTabs(AppFavorUtils.jjUrl + "getGroupsTabs", jJApiInput);
        jJGroupsTabs.enqueue(new CallbackWithRetry<JJGetGroupsTabsOutput>(jJGroupsTabs) { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.42
            @Override // retrofit2.Callback
            public void onResponse(Call<JJGetGroupsTabsOutput> call, retrofit2.Response<JJGetGroupsTabsOutput> response) {
                ApiRequestIPTV apiRequestIPTV = ApiRequestIPTV.this;
                apiRequestIPTV.handlingOnResponse(new HandlingResponse(apiRequestIPTV, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<JJGetGroupsTabsOutput> call, Throwable th) {
                listener.onFailure(call, th);
                super.onFailure(call, th);
            }
        });
        return jJGroupsTabs;
    }

    public Call<JJGetMatchAndTeamListOutput> getJJMatchAndTeamUpdate(JJGetMatchAndTeamListInput jJGetMatchAndTeamListInput, final Listener listener) {
        Call<JJGetMatchAndTeamListOutput> jJMatchAndTeamList = getRestApiService().getJJMatchAndTeamList(AppFavorUtils.jjUrl + "getMatchList", jJGetMatchAndTeamListInput);
        jJMatchAndTeamList.enqueue(new CallbackWithRetry<JJGetMatchAndTeamListOutput>(jJMatchAndTeamList) { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.43
            @Override // retrofit2.Callback
            public void onResponse(Call<JJGetMatchAndTeamListOutput> call, retrofit2.Response<JJGetMatchAndTeamListOutput> response) {
                ApiRequestIPTV apiRequestIPTV = ApiRequestIPTV.this;
                apiRequestIPTV.handlingOnResponse(new HandlingResponse(apiRequestIPTV, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<JJGetMatchAndTeamListOutput> call, Throwable th) {
                listener.onFailure(call, th);
                super.onFailure(call, th);
            }
        });
        return jJMatchAndTeamList;
    }

    public Call<JJGetRankOutput> getJJRank(JJApiInput jJApiInput, final Listener listener) {
        Call<JJGetRankOutput> jJRank = getRestApiService().getJJRank(AppFavorUtils.jjUrl + "getLeaderBoard", jJApiInput);
        jJRank.enqueue(new CallbackWithRetry<JJGetRankOutput>(jJRank) { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.44
            @Override // retrofit2.Callback
            public void onResponse(Call<JJGetRankOutput> call, retrofit2.Response<JJGetRankOutput> response) {
                ApiRequestIPTV apiRequestIPTV = ApiRequestIPTV.this;
                apiRequestIPTV.handlingOnResponse(new HandlingResponse(apiRequestIPTV, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<JJGetRankOutput> call, Throwable th) {
                listener.onFailure(call, th);
                super.onFailure(call, th);
            }
        });
        return jJRank;
    }

    public Call<JJVoteOutput> jjVote(JJVoteInput jJVoteInput, final Listener listener) {
        Call<JJVoteOutput> callJjVote = getRestApiService().jjVote(AppFavorUtils.jjUrl + "voteMatch", jJVoteInput);
        callJjVote.enqueue(new CallbackWithRetry<JJVoteOutput>(callJjVote) { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.45
            @Override // retrofit2.Callback
            public void onResponse(Call<JJVoteOutput> call, retrofit2.Response<JJVoteOutput> response) {
                ApiRequestIPTV apiRequestIPTV = ApiRequestIPTV.this;
                apiRequestIPTV.handlingOnResponse(new HandlingResponse(apiRequestIPTV, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<JJVoteOutput> call, Throwable th) {
                listener.onFailure(call, th);
                super.onFailure(call, th);
            }
        });
        return callJjVote;
    }

    public Call<JJSetChampionOutput> setJJChampionTeam(JJSetChampionInput jJSetChampionInput, final Listener listener) {
        Call<JJSetChampionOutput> callJjSetChampionTeam = getRestApiService().jjSetChampionTeam(AppFavorUtils.jjUrl + "setChampionTeam", jJSetChampionInput);
        callJjSetChampionTeam.enqueue(new CallbackWithRetry<JJSetChampionOutput>(callJjSetChampionTeam) { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.46
            @Override // retrofit2.Callback
            public void onResponse(Call<JJSetChampionOutput> call, retrofit2.Response<JJSetChampionOutput> response) {
                ApiRequestIPTV apiRequestIPTV = ApiRequestIPTV.this;
                apiRequestIPTV.handlingOnResponse(new HandlingResponse(apiRequestIPTV, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<JJSetChampionOutput> call, Throwable th) {
                listener.onFailure(call, th);
                super.onFailure(call, th);
            }
        });
        return callJjSetChampionTeam;
    }

    public Call<JJGetChampionOutput> getJJChampionTeam(JJApiInput jJApiInput, final Listener listener) {
        Call<JJGetChampionOutput> callJjGetChampionTeam = getRestApiService().jjGetChampionTeam(AppFavorUtils.jjUrl + "getChampionTeam", jJApiInput);
        callJjGetChampionTeam.enqueue(new CallbackWithRetry<JJGetChampionOutput>(callJjGetChampionTeam) { // from class: ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.47
            @Override // retrofit2.Callback
            public void onResponse(Call<JJGetChampionOutput> call, retrofit2.Response<JJGetChampionOutput> response) {
                ApiRequestIPTV apiRequestIPTV = ApiRequestIPTV.this;
                apiRequestIPTV.handlingOnResponse(new HandlingResponse(apiRequestIPTV, call, response, this), listener);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.CallbackWithRetry, retrofit2.Callback
            public void onFailure(Call<JJGetChampionOutput> call, Throwable th) {
                listener.onFailure(call, th);
                super.onFailure(call, th);
            }
        });
        return callJjGetChampionTeam;
    }
}
