package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto$ThickContent;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpression;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes3.dex */
public class ImpressionStorageClient {
    private static final CampaignImpressionList EMPTY_IMPRESSIONS = CampaignImpressionList.getDefaultInstance();
    private Maybe<CampaignImpressionList> cachedImpressionsMaybe = Maybe.empty();
    private final ProtoStorageClient storageClient;

    ImpressionStorageClient(ProtoStorageClient protoStorageClient) {
        this.storageClient = protoStorageClient;
    }

    public Maybe<CampaignImpressionList> getAllImpressions() {
        return this.cachedImpressionsMaybe.switchIfEmpty(this.storageClient.read(CampaignImpressionList.parser()).doOnSuccess(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.ImpressionStorageClient$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$clearImpressions$3((CampaignImpressionList) obj);
            }
        })).doOnError(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.ImpressionStorageClient$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f$0.lambda$getAllImpressions$2((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getAllImpressions$2(Throwable th) throws Exception {
        clearInMemCache();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initInMemCache, reason: merged with bridge method [inline-methods] */
    public void lambda$clearImpressions$3(CampaignImpressionList campaignImpressionList) {
        this.cachedImpressionsMaybe = Maybe.just(campaignImpressionList);
    }

    private void clearInMemCache() {
        this.cachedImpressionsMaybe = Maybe.empty();
    }

    public Single<Boolean> isImpressed(CampaignProto$ThickContent campaignProto$ThickContent) {
        String campaignId;
        if (campaignProto$ThickContent.getPayloadCase().equals(CampaignProto$ThickContent.PayloadCase.VANILLA_PAYLOAD)) {
            campaignId = campaignProto$ThickContent.getVanillaPayload().getCampaignId();
        } else {
            campaignId = campaignProto$ThickContent.getExperimentalPayload().getCampaignId();
        }
        return getAllImpressions().map(new Function() { // from class: com.google.firebase.inappmessaging.internal.ImpressionStorageClient$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ((CampaignImpressionList) obj).getAlreadySeenCampaignsList();
            }
        }).flatMapObservable(new Function() { // from class: com.google.firebase.inappmessaging.internal.ImpressionStorageClient$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return Observable.fromIterable((List) obj);
            }
        }).map(new Function() { // from class: com.google.firebase.inappmessaging.internal.ImpressionStorageClient$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ((CampaignImpression) obj).getCampaignId();
            }
        }).contains(campaignId);
    }

    public Completable clearImpressions(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        String campaignId;
        final HashSet hashSet = new HashSet();
        for (CampaignProto$ThickContent campaignProto$ThickContent : fetchEligibleCampaignsResponse.getMessagesList()) {
            if (campaignProto$ThickContent.getPayloadCase().equals(CampaignProto$ThickContent.PayloadCase.VANILLA_PAYLOAD)) {
                campaignId = campaignProto$ThickContent.getVanillaPayload().getCampaignId();
            } else {
                campaignId = campaignProto$ThickContent.getExperimentalPayload().getCampaignId();
            }
            hashSet.add(campaignId);
        }
        Logging.logd("Potential impressions to clear: " + hashSet.toString());
        return getAllImpressions().defaultIfEmpty(EMPTY_IMPRESSIONS).flatMapCompletable(new Function() { // from class: com.google.firebase.inappmessaging.internal.ImpressionStorageClient$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$clearImpressions$4(hashSet, (CampaignImpressionList) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CompletableSource lambda$clearImpressions$4(HashSet hashSet, CampaignImpressionList campaignImpressionList) throws Exception {
        Logging.logd("Existing impressions: " + campaignImpressionList.toString());
        CampaignImpressionList.Builder builderNewBuilder = CampaignImpressionList.newBuilder();
        for (CampaignImpression campaignImpression : campaignImpressionList.getAlreadySeenCampaignsList()) {
            if (!hashSet.contains(campaignImpression.getCampaignId())) {
                builderNewBuilder.addAlreadySeenCampaigns(campaignImpression);
            }
        }
        final CampaignImpressionList campaignImpressionListBuild = builderNewBuilder.build();
        Logging.logd("New cleared impression list: " + campaignImpressionListBuild.toString());
        return this.storageClient.write(campaignImpressionListBuild).doOnComplete(new Action() { // from class: com.google.firebase.inappmessaging.internal.ImpressionStorageClient$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Action
            public final void run() throws Exception {
                this.f$0.lambda$clearImpressions$3(campaignImpressionListBuild);
            }
        });
    }
}
