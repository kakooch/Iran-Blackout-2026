package com.google.firebase.inappmessaging.internal;

import android.text.TextUtils;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inappmessaging.CommonTypesProto$TriggeringCondition;
import com.google.internal.firebase.inappmessaging.v1.CampaignProto$ThickContent;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.flowables.ConnectableFlowable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes3.dex */
public class AnalyticsEventsManager {
    private final AnalyticsConnector analyticsConnector;
    private final ConnectableFlowable<String> flowable;
    private AnalyticsConnector.AnalyticsConnectorHandle handle;

    public AnalyticsEventsManager(AnalyticsConnector analyticsConnector) {
        this.analyticsConnector = analyticsConnector;
        ConnectableFlowable<String> connectableFlowablePublish = Flowable.create(new AnalyticsFlowableSubscriber(), BackpressureStrategy.BUFFER).publish();
        this.flowable = connectableFlowablePublish;
        connectableFlowablePublish.connect();
    }

    public ConnectableFlowable<String> getAnalyticsEventsFlowable() {
        return this.flowable;
    }

    static Set<String> extractAnalyticsEventNames(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        HashSet hashSet = new HashSet();
        Iterator<CampaignProto$ThickContent> it = fetchEligibleCampaignsResponse.getMessagesList().iterator();
        while (it.hasNext()) {
            for (CommonTypesProto$TriggeringCondition commonTypesProto$TriggeringCondition : it.next().getTriggeringConditionsList()) {
                if (!TextUtils.isEmpty(commonTypesProto$TriggeringCondition.getEvent().getName())) {
                    hashSet.add(commonTypesProto$TriggeringCondition.getEvent().getName());
                }
            }
        }
        if (hashSet.size() > 50) {
            Logging.logi("Too many contextual triggers defined - limiting to 50");
        }
        return hashSet;
    }

    public void updateContextualTriggers(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        Set<String> setExtractAnalyticsEventNames = extractAnalyticsEventNames(fetchEligibleCampaignsResponse);
        Logging.logd("Updating contextual triggers for the following analytics events: " + setExtractAnalyticsEventNames);
        this.handle.registerEventNames(setExtractAnalyticsEventNames);
    }

    private class AnalyticsFlowableSubscriber implements FlowableOnSubscribe<String> {
        AnalyticsFlowableSubscriber() {
        }

        @Override // io.reactivex.FlowableOnSubscribe
        public void subscribe(FlowableEmitter<String> flowableEmitter) {
            Logging.logd("Subscribing to analytics events.");
            AnalyticsEventsManager analyticsEventsManager = AnalyticsEventsManager.this;
            analyticsEventsManager.handle = analyticsEventsManager.analyticsConnector.registerAnalyticsConnectorListener("fiam", new FiamAnalyticsConnectorListener(flowableEmitter));
        }
    }
}
