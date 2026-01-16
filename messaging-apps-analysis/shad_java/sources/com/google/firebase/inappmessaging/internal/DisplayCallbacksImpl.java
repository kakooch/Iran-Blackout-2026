package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.RateLimit;

/* loaded from: classes3.dex */
public class DisplayCallbacksImpl implements FirebaseInAppMessagingDisplayCallbacks {
    private final Clock clock;

    DisplayCallbacksImpl(ImpressionStorageClient impressionStorageClient, Clock clock, Schedulers schedulers, RateLimiterClient rateLimiterClient, CampaignCacheClient campaignCacheClient, RateLimit rateLimit, MetricsLoggerClient metricsLoggerClient, DataCollectionHelper dataCollectionHelper, InAppMessage inAppMessage, String str) {
        this.clock = clock;
    }
}
