package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class CampaignCacheClient {
    private final Application application;
    private FetchEligibleCampaignsResponse cachedResponse;
    private final Clock clock;
    private final ProtoStorageClient storageClient;

    CampaignCacheClient(ProtoStorageClient protoStorageClient, Application application, Clock clock) {
        this.storageClient = protoStorageClient;
        this.application = application;
        this.clock = clock;
    }

    public Completable put(final FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        return this.storageClient.write(fetchEligibleCampaignsResponse).doOnComplete(new Action() { // from class: com.google.firebase.inappmessaging.internal.CampaignCacheClient$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Action
            public final void run() throws Exception {
                this.f$0.lambda$put$0(fetchEligibleCampaignsResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$put$0(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) throws Exception {
        this.cachedResponse = fetchEligibleCampaignsResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ FetchEligibleCampaignsResponse lambda$get$1() throws Exception {
        return this.cachedResponse;
    }

    public Maybe<FetchEligibleCampaignsResponse> get() {
        return Maybe.fromCallable(new Callable() { // from class: com.google.firebase.inappmessaging.internal.CampaignCacheClient$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.lambda$get$1();
            }
        }).switchIfEmpty(this.storageClient.read(FetchEligibleCampaignsResponse.parser()).doOnSuccess(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.CampaignCacheClient$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f$0.lambda$get$2((FetchEligibleCampaignsResponse) obj);
            }
        })).filter(new Predicate() { // from class: com.google.firebase.inappmessaging.internal.CampaignCacheClient$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                return this.f$0.isResponseValid((FetchEligibleCampaignsResponse) obj);
            }
        }).doOnError(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.CampaignCacheClient$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f$0.lambda$get$3((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$get$2(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) throws Exception {
        this.cachedResponse = fetchEligibleCampaignsResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$get$3(Throwable th) throws Exception {
        this.cachedResponse = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isResponseValid(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        long expirationEpochTimestampMillis = fetchEligibleCampaignsResponse.getExpirationEpochTimestampMillis();
        long jNow = this.clock.now();
        File file = new File(this.application.getApplicationContext().getFilesDir(), "fiam_eligible_campaigns_cache_file");
        return expirationEpochTimestampMillis != 0 ? jNow < expirationEpochTimestampMillis : !file.exists() || jNow < file.lastModified() + TimeUnit.DAYS.toMillis(1L);
    }
}
