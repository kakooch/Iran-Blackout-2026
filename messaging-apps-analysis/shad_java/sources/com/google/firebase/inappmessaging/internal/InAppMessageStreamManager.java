package com.google.firebase.inappmessaging.internal;

import android.text.TextUtils;
import androidx.constraintlayout.motion.widget.KeyCycleOscillator$1$$ExternalSyntheticBackport0;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.inappmessaging.CommonTypesProto$TriggeringCondition;
import com.google.firebase.inappmessaging.MessagesProto$Content;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import com.google.firebase.inappmessaging.model.ProtoMarshallerClient;
import com.google.firebase.inappmessaging.model.RateLimit;
import com.google.firebase.inappmessaging.model.TriggeredInAppMessage;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.internal.firebase.inappmessaging.v1.CampaignProto$ThickContent;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeOnSubscribe;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.Comparator;
import java.util.Locale;
import org.reactivestreams.Publisher;

/* loaded from: classes3.dex */
public class InAppMessageStreamManager {
    private final AbtIntegrationHelper abtIntegrationHelper;
    private final AnalyticsEventsManager analyticsEventsManager;
    private final ApiClient apiClient;
    private final ConnectableFlowable<String> appForegroundEventFlowable;
    private final RateLimit appForegroundRateLimit;
    private final CampaignCacheClient campaignCacheClient;
    private final Clock clock;
    private final DataCollectionHelper dataCollectionHelper;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final ImpressionStorageClient impressionStorageClient;
    private final ConnectableFlowable<String> programmaticTriggerEventFlowable;
    private final RateLimiterClient rateLimiterClient;
    private final Schedulers schedulers;
    private final TestDeviceHelper testDeviceHelper;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ CampaignProto$ThickContent lambda$createFirebaseInAppMessageStream$10(CampaignProto$ThickContent campaignProto$ThickContent, Boolean bool) throws Exception {
        return campaignProto$ThickContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ CampaignProto$ThickContent lambda$getContentIfNotRateLimited$24(CampaignProto$ThickContent campaignProto$ThickContent, Boolean bool) throws Exception {
        return campaignProto$ThickContent;
    }

    public InAppMessageStreamManager(ConnectableFlowable<String> connectableFlowable, ConnectableFlowable<String> connectableFlowable2, CampaignCacheClient campaignCacheClient, Clock clock, ApiClient apiClient, AnalyticsEventsManager analyticsEventsManager, Schedulers schedulers, ImpressionStorageClient impressionStorageClient, RateLimiterClient rateLimiterClient, RateLimit rateLimit, TestDeviceHelper testDeviceHelper, FirebaseInstallationsApi firebaseInstallationsApi, DataCollectionHelper dataCollectionHelper, AbtIntegrationHelper abtIntegrationHelper) {
        this.appForegroundEventFlowable = connectableFlowable;
        this.programmaticTriggerEventFlowable = connectableFlowable2;
        this.campaignCacheClient = campaignCacheClient;
        this.clock = clock;
        this.apiClient = apiClient;
        this.analyticsEventsManager = analyticsEventsManager;
        this.schedulers = schedulers;
        this.impressionStorageClient = impressionStorageClient;
        this.rateLimiterClient = rateLimiterClient;
        this.appForegroundRateLimit = rateLimit;
        this.testDeviceHelper = testDeviceHelper;
        this.dataCollectionHelper = dataCollectionHelper;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.abtIntegrationHelper = abtIntegrationHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean containsTriggeringCondition(String str, CampaignProto$ThickContent campaignProto$ThickContent) {
        if (isAppForegroundEvent(str) && campaignProto$ThickContent.getIsTestCampaign()) {
            return true;
        }
        for (CommonTypesProto$TriggeringCondition commonTypesProto$TriggeringCondition : campaignProto$ThickContent.getTriggeringConditionsList()) {
            if (hasFiamTrigger(commonTypesProto$TriggeringCondition, str) || hasAnalyticsTrigger(commonTypesProto$TriggeringCondition, str)) {
                Logging.logd(String.format("The event %s is contained in the list of triggers", str));
                return true;
            }
        }
        return false;
    }

    private static boolean hasFiamTrigger(CommonTypesProto$TriggeringCondition commonTypesProto$TriggeringCondition, String str) {
        return commonTypesProto$TriggeringCondition.getFiamTrigger().toString().equals(str);
    }

    private static boolean hasAnalyticsTrigger(CommonTypesProto$TriggeringCondition commonTypesProto$TriggeringCondition, String str) {
        return commonTypesProto$TriggeringCondition.getEvent().getName().equals(str);
    }

    private static boolean isActive(Clock clock, CampaignProto$ThickContent campaignProto$ThickContent) {
        long campaignStartTimeMillis;
        long campaignEndTimeMillis;
        if (campaignProto$ThickContent.getPayloadCase().equals(CampaignProto$ThickContent.PayloadCase.VANILLA_PAYLOAD)) {
            campaignStartTimeMillis = campaignProto$ThickContent.getVanillaPayload().getCampaignStartTimeMillis();
            campaignEndTimeMillis = campaignProto$ThickContent.getVanillaPayload().getCampaignEndTimeMillis();
        } else {
            if (!campaignProto$ThickContent.getPayloadCase().equals(CampaignProto$ThickContent.PayloadCase.EXPERIMENTAL_PAYLOAD)) {
                return false;
            }
            campaignStartTimeMillis = campaignProto$ThickContent.getExperimentalPayload().getCampaignStartTimeMillis();
            campaignEndTimeMillis = campaignProto$ThickContent.getExperimentalPayload().getCampaignEndTimeMillis();
        }
        long jNow = clock.now();
        return jNow > campaignStartTimeMillis && jNow < campaignEndTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int compareByPriority(CampaignProto$ThickContent campaignProto$ThickContent, CampaignProto$ThickContent campaignProto$ThickContent2) {
        if (campaignProto$ThickContent.getIsTestCampaign() && !campaignProto$ThickContent2.getIsTestCampaign()) {
            return -1;
        }
        if (!campaignProto$ThickContent2.getIsTestCampaign() || campaignProto$ThickContent.getIsTestCampaign()) {
            return KeyCycleOscillator$1$$ExternalSyntheticBackport0.m(campaignProto$ThickContent.getPriority().getValue(), campaignProto$ThickContent2.getPriority().getValue());
        }
        return 1;
    }

    public static boolean isAppForegroundEvent(String str) {
        return str.equals("ON_FOREGROUND");
    }

    private boolean shouldIgnoreCache(String str) {
        if (this.testDeviceHelper.isAppInstallFresh()) {
            return isAppForegroundEvent(str);
        }
        return this.testDeviceHelper.isDeviceInTestMode();
    }

    public Flowable<TriggeredInAppMessage> createFirebaseInAppMessageStream() {
        return Flowable.merge(this.appForegroundEventFlowable, this.analyticsEventsManager.getAnalyticsEventsFlowable(), this.programmaticTriggerEventFlowable).doOnNext(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda13
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                InAppMessageStreamManager.lambda$createFirebaseInAppMessageStream$0((String) obj);
            }
        }).observeOn(this.schedulers.io()).concatMap(new Function() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda20
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$createFirebaseInAppMessageStream$21((String) obj);
            }
        }).observeOn(this.schedulers.mainThread());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createFirebaseInAppMessageStream$0(String str) throws Exception {
        Logging.logd("Event Triggered: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Publisher lambda$createFirebaseInAppMessageStream$21(final String str) throws Exception {
        Maybe<FetchEligibleCampaignsResponse> maybeOnErrorResumeNext = this.campaignCacheClient.get().doOnSuccess(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Logging.logd("Fetched from cache");
            }
        }).doOnError(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda14
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                InAppMessageStreamManager.lambda$createFirebaseInAppMessageStream$2((Throwable) obj);
            }
        }).onErrorResumeNext(Maybe.empty());
        Consumer consumer = new Consumer() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f$0.lambda$createFirebaseInAppMessageStream$6((FetchEligibleCampaignsResponse) obj);
            }
        };
        final Function function = new Function() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda19
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$createFirebaseInAppMessageStream$11((CampaignProto$ThickContent) obj);
            }
        };
        final Function function2 = new Function() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda23
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$createFirebaseInAppMessageStream$12(str, (CampaignProto$ThickContent) obj);
            }
        };
        final InAppMessageStreamManager$$ExternalSyntheticLambda28 inAppMessageStreamManager$$ExternalSyntheticLambda28 = new Function() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda28
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return InAppMessageStreamManager.lambda$createFirebaseInAppMessageStream$13((CampaignProto$ThickContent) obj);
            }
        };
        Function<? super FetchEligibleCampaignsResponse, ? extends MaybeSource<? extends R>> function3 = new Function() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda25
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$createFirebaseInAppMessageStream$14(str, function, function2, inAppMessageStreamManager$$ExternalSyntheticLambda28, (FetchEligibleCampaignsResponse) obj);
            }
        };
        Maybe<CampaignImpressionList> maybeOnErrorResumeNext2 = this.impressionStorageClient.getAllImpressions().doOnError(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda15
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                InAppMessageStreamManager.lambda$createFirebaseInAppMessageStream$15((Throwable) obj);
            }
        }).defaultIfEmpty(CampaignImpressionList.getDefaultInstance()).onErrorResumeNext(Maybe.just(CampaignImpressionList.getDefaultInstance()));
        final Maybe maybeObserveOn = Maybe.zip(taskToMaybe(this.firebaseInstallations.getId()), taskToMaybe(this.firebaseInstallations.getToken(false)), new BiFunction() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return InstallationIdResult.create((String) obj, (InstallationTokenResult) obj2);
            }
        }).observeOn(this.schedulers.io());
        Function<? super CampaignImpressionList, ? extends MaybeSource<? extends R>> function4 = new Function() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda22
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$createFirebaseInAppMessageStream$20(maybeObserveOn, (CampaignImpressionList) obj);
            }
        };
        if (shouldIgnoreCache(str)) {
            Logging.logi(String.format("Forcing fetch from service rather than cache. Test Device: %s | App Fresh Install: %s", Boolean.valueOf(this.testDeviceHelper.isDeviceInTestMode()), Boolean.valueOf(this.testDeviceHelper.isAppInstallFresh())));
            return maybeOnErrorResumeNext2.flatMap(function4).flatMap(function3).toFlowable();
        }
        Logging.logd("Attempting to fetch campaigns using cache");
        return maybeOnErrorResumeNext.switchIfEmpty(maybeOnErrorResumeNext2.flatMap(function4).doOnSuccess(consumer)).flatMap(function3).toFlowable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createFirebaseInAppMessageStream$2(Throwable th) throws Exception {
        Logging.logw("Cache read error: " + th.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createFirebaseInAppMessageStream$6(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) throws Exception {
        this.campaignCacheClient.put(fetchEligibleCampaignsResponse).doOnComplete(new Action() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Action
            public final void run() {
                Logging.logd("Wrote to cache");
            }
        }).doOnError(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda16
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                InAppMessageStreamManager.lambda$createFirebaseInAppMessageStream$4((Throwable) obj);
            }
        }).onErrorResumeNext(new Function() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda29
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return InAppMessageStreamManager.lambda$createFirebaseInAppMessageStream$5((Throwable) obj);
            }
        }).subscribe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createFirebaseInAppMessageStream$4(Throwable th) throws Exception {
        Logging.logw("Cache write error: " + th.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ CompletableSource lambda$createFirebaseInAppMessageStream$5(Throwable th) throws Exception {
        return Completable.complete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Maybe lambda$createFirebaseInAppMessageStream$11(final CampaignProto$ThickContent campaignProto$ThickContent) throws Exception {
        if (campaignProto$ThickContent.getIsTestCampaign()) {
            return Maybe.just(campaignProto$ThickContent);
        }
        return this.impressionStorageClient.isImpressed(campaignProto$ThickContent).doOnError(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda17
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                InAppMessageStreamManager.lambda$createFirebaseInAppMessageStream$7((Throwable) obj);
            }
        }).onErrorResumeNext(Single.just(Boolean.FALSE)).doOnSuccess(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                InAppMessageStreamManager.logImpressionStatus(campaignProto$ThickContent, (Boolean) obj);
            }
        }).filter(new Predicate() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda34
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                return InAppMessageStreamManager.lambda$createFirebaseInAppMessageStream$9((Boolean) obj);
            }
        }).map(new Function() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda26
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return InAppMessageStreamManager.lambda$createFirebaseInAppMessageStream$10(campaignProto$ThickContent, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createFirebaseInAppMessageStream$7(Throwable th) throws Exception {
        Logging.logw("Impression store read fail: " + th.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$createFirebaseInAppMessageStream$9(Boolean bool) throws Exception {
        return !bool.booleanValue();
    }

    /* renamed from: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase;

        static {
            int[] iArr = new int[MessagesProto$Content.MessageDetailsCase.values().length];
            $SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase = iArr;
            try {
                iArr[MessagesProto$Content.MessageDetailsCase.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase[MessagesProto$Content.MessageDetailsCase.IMAGE_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase[MessagesProto$Content.MessageDetailsCase.MODAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase[MessagesProto$Content.MessageDetailsCase.CARD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Maybe lambda$createFirebaseInAppMessageStream$13(CampaignProto$ThickContent campaignProto$ThickContent) throws Exception {
        int i = AnonymousClass1.$SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase[campaignProto$ThickContent.getContent().getMessageDetailsCase().ordinal()];
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            return Maybe.just(campaignProto$ThickContent);
        }
        Logging.logd("Filtering non-displayable message");
        return Maybe.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createFirebaseInAppMessageStream$15(Throwable th) throws Exception {
        Logging.logw("Impressions store read fail: " + th.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Maybe lambda$createFirebaseInAppMessageStream$20(Maybe maybe, final CampaignImpressionList campaignImpressionList) throws Exception {
        if (!this.dataCollectionHelper.isAutomaticDataCollectionEnabled()) {
            Logging.logi("Automatic data collection is disabled, not attempting campaign fetch from service.");
            return Maybe.just(cacheExpiringResponse());
        }
        Maybe maybeDoOnSuccess = maybe.filter(new Predicate() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda32
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                return InAppMessageStreamManager.validIID((InstallationIdResult) obj);
            }
        }).map(new Function() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda21
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$createFirebaseInAppMessageStream$16(campaignImpressionList, (InstallationIdResult) obj);
            }
        }).switchIfEmpty(Maybe.just(cacheExpiringResponse())).doOnSuccess(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                InAppMessageStreamManager.lambda$createFirebaseInAppMessageStream$17((FetchEligibleCampaignsResponse) obj);
            }
        }).doOnSuccess(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f$0.lambda$createFirebaseInAppMessageStream$18((FetchEligibleCampaignsResponse) obj);
            }
        });
        final AnalyticsEventsManager analyticsEventsManager = this.analyticsEventsManager;
        analyticsEventsManager.getClass();
        Maybe maybeDoOnSuccess2 = maybeDoOnSuccess.doOnSuccess(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                analyticsEventsManager.updateContextualTriggers((FetchEligibleCampaignsResponse) obj);
            }
        });
        final TestDeviceHelper testDeviceHelper = this.testDeviceHelper;
        testDeviceHelper.getClass();
        return maybeDoOnSuccess2.doOnSuccess(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                testDeviceHelper.processCampaignFetch((FetchEligibleCampaignsResponse) obj);
            }
        }).doOnError(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda18
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                InAppMessageStreamManager.lambda$createFirebaseInAppMessageStream$19((Throwable) obj);
            }
        }).onErrorResumeNext(Maybe.empty());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ FetchEligibleCampaignsResponse lambda$createFirebaseInAppMessageStream$16(CampaignImpressionList campaignImpressionList, InstallationIdResult installationIdResult) throws Exception {
        return this.apiClient.getFiams(installationIdResult, campaignImpressionList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createFirebaseInAppMessageStream$17(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) throws Exception {
        Logging.logi(String.format(Locale.US, "Successfully fetched %d messages from backend", Integer.valueOf(fetchEligibleCampaignsResponse.getMessagesList().size())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createFirebaseInAppMessageStream$18(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) throws Exception {
        this.impressionStorageClient.clearImpressions(fetchEligibleCampaignsResponse).subscribe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createFirebaseInAppMessageStream$19(Throwable th) throws Exception {
        Logging.logw("Service fetch error: " + th.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getContentIfNotRateLimited, reason: merged with bridge method [inline-methods] */
    public Maybe<CampaignProto$ThickContent> lambda$createFirebaseInAppMessageStream$12(String str, final CampaignProto$ThickContent campaignProto$ThickContent) {
        if (!campaignProto$ThickContent.getIsTestCampaign() && isAppForegroundEvent(str)) {
            return this.rateLimiterClient.isRateLimited(this.appForegroundRateLimit).doOnSuccess(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda12
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) throws Exception {
                    InAppMessageStreamManager.lambda$getContentIfNotRateLimited$22((Boolean) obj);
                }
            }).onErrorResumeNext(Single.just(Boolean.FALSE)).filter(new Predicate() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda33
                @Override // io.reactivex.functions.Predicate
                public final boolean test(Object obj) {
                    return InAppMessageStreamManager.lambda$getContentIfNotRateLimited$23((Boolean) obj);
                }
            }).map(new Function() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda27
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return InAppMessageStreamManager.lambda$getContentIfNotRateLimited$24(campaignProto$ThickContent, (Boolean) obj);
                }
            });
        }
        return Maybe.just(campaignProto$ThickContent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getContentIfNotRateLimited$22(Boolean bool) throws Exception {
        Logging.logi("App foreground rate limited ? : " + bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getContentIfNotRateLimited$23(Boolean bool) throws Exception {
        return !bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void logImpressionStatus(CampaignProto$ThickContent campaignProto$ThickContent, Boolean bool) {
        if (campaignProto$ThickContent.getPayloadCase().equals(CampaignProto$ThickContent.PayloadCase.VANILLA_PAYLOAD)) {
            Logging.logi(String.format("Already impressed campaign %s ? : %s", campaignProto$ThickContent.getVanillaPayload().getCampaignName(), bool));
        } else if (campaignProto$ThickContent.getPayloadCase().equals(CampaignProto$ThickContent.PayloadCase.EXPERIMENTAL_PAYLOAD)) {
            Logging.logi(String.format("Already impressed experiment %s ? : %s", campaignProto$ThickContent.getExperimentalPayload().getCampaignName(), bool));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getTriggeredInAppMessageMaybe, reason: merged with bridge method [inline-methods] */
    public Maybe<TriggeredInAppMessage> lambda$createFirebaseInAppMessageStream$14(final String str, Function<CampaignProto$ThickContent, Maybe<CampaignProto$ThickContent>> function, Function<CampaignProto$ThickContent, Maybe<CampaignProto$ThickContent>> function2, Function<CampaignProto$ThickContent, Maybe<CampaignProto$ThickContent>> function3, FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        return Flowable.fromIterable(fetchEligibleCampaignsResponse.getMessagesList()).filter(new Predicate() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda30
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                return this.f$0.lambda$getTriggeredInAppMessageMaybe$25((CampaignProto$ThickContent) obj);
            }
        }).filter(new Predicate() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda31
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                return InAppMessageStreamManager.containsTriggeringCondition(str, (CampaignProto$ThickContent) obj);
            }
        }).flatMapMaybe(function).flatMapMaybe(function2).flatMapMaybe(function3).sorted(new Comparator() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda35
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return InAppMessageStreamManager.compareByPriority((CampaignProto$ThickContent) obj, (CampaignProto$ThickContent) obj2);
            }
        }).firstElement().flatMap(new Function() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda24
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$getTriggeredInAppMessageMaybe$27(str, (CampaignProto$ThickContent) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$getTriggeredInAppMessageMaybe$25(CampaignProto$ThickContent campaignProto$ThickContent) throws Exception {
        return this.testDeviceHelper.isDeviceInTestMode() || isActive(this.clock, campaignProto$ThickContent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: triggeredInAppMessage, reason: merged with bridge method [inline-methods] */
    public Maybe<TriggeredInAppMessage> lambda$getTriggeredInAppMessageMaybe$27(CampaignProto$ThickContent campaignProto$ThickContent, String str) {
        String campaignId;
        String campaignName;
        if (campaignProto$ThickContent.getPayloadCase().equals(CampaignProto$ThickContent.PayloadCase.VANILLA_PAYLOAD)) {
            campaignId = campaignProto$ThickContent.getVanillaPayload().getCampaignId();
            campaignName = campaignProto$ThickContent.getVanillaPayload().getCampaignName();
        } else if (campaignProto$ThickContent.getPayloadCase().equals(CampaignProto$ThickContent.PayloadCase.EXPERIMENTAL_PAYLOAD)) {
            campaignId = campaignProto$ThickContent.getExperimentalPayload().getCampaignId();
            campaignName = campaignProto$ThickContent.getExperimentalPayload().getCampaignName();
            if (!campaignProto$ThickContent.getIsTestCampaign()) {
                this.abtIntegrationHelper.setExperimentActive(campaignProto$ThickContent.getExperimentalPayload().getExperimentPayload());
            }
        } else {
            return Maybe.empty();
        }
        InAppMessage inAppMessageDecode = ProtoMarshallerClient.decode(campaignProto$ThickContent.getContent(), campaignId, campaignName, campaignProto$ThickContent.getIsTestCampaign(), campaignProto$ThickContent.getDataBundleMap());
        if (inAppMessageDecode.getMessageType().equals(MessageType.UNSUPPORTED)) {
            return Maybe.empty();
        }
        return Maybe.just(new TriggeredInAppMessage(inAppMessageDecode, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean validIID(InstallationIdResult installationIdResult) {
        return (TextUtils.isEmpty(installationIdResult.installationId()) || TextUtils.isEmpty(installationIdResult.installationTokenResult().getToken())) ? false : true;
    }

    static FetchEligibleCampaignsResponse cacheExpiringResponse() {
        return FetchEligibleCampaignsResponse.newBuilder().setExpirationEpochTimestampMillis(1L).build();
    }

    private static <T> Maybe<T> taskToMaybe(final Task<T> task) {
        return Maybe.create(new MaybeOnSubscribe() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda2
            @Override // io.reactivex.MaybeOnSubscribe
            public final void subscribe(MaybeEmitter maybeEmitter) throws Exception {
                InAppMessageStreamManager.lambda$taskToMaybe$30(task, maybeEmitter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$taskToMaybe$30(Task task, final MaybeEmitter maybeEmitter) throws Exception {
        task.addOnSuccessListener(new OnSuccessListener() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                InAppMessageStreamManager.lambda$taskToMaybe$28(maybeEmitter, obj);
            }
        });
        task.addOnFailureListener(new OnFailureListener() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                InAppMessageStreamManager.lambda$taskToMaybe$29(maybeEmitter, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$taskToMaybe$28(MaybeEmitter maybeEmitter, Object obj) {
        maybeEmitter.onSuccess(obj);
        maybeEmitter.onComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$taskToMaybe$29(MaybeEmitter maybeEmitter, Exception exc) {
        maybeEmitter.onError(exc);
        maybeEmitter.onComplete();
    }
}
