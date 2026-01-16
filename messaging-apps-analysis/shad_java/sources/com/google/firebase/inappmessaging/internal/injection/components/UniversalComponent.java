package com.google.firebase.inappmessaging.internal.injection.components;

import android.app.Application;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inappmessaging.internal.AnalyticsEventsManager;
import com.google.firebase.inappmessaging.internal.CampaignCacheClient;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import com.google.firebase.inappmessaging.internal.ImpressionStorageClient;
import com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers;
import com.google.firebase.inappmessaging.internal.ProviderInstaller;
import com.google.firebase.inappmessaging.internal.RateLimiterClient;
import com.google.firebase.inappmessaging.internal.Schedulers;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.inappmessaging.model.RateLimit;
import io.grpc.Channel;
import io.reactivex.flowables.ConnectableFlowable;

/* loaded from: classes3.dex */
public interface UniversalComponent {
    AnalyticsConnector analyticsConnector();

    AnalyticsEventsManager analyticsEventsManager();

    ConnectableFlowable<String> appForegroundEventFlowable();

    RateLimit appForegroundRateLimit();

    Application application();

    CampaignCacheClient campaignCacheClient();

    Clock clock();

    DeveloperListenerManager developerListenerManager();

    Subscriber firebaseEventsSubscriber();

    Channel gRPCChannel();

    ImpressionStorageClient impressionStorageClient();

    ProviderInstaller probiderInstaller();

    ConnectableFlowable<String> programmaticContextualTriggerFlowable();

    ProgramaticContextualTriggers programmaticContextualTriggers();

    RateLimiterClient rateLimiterClient();

    Schedulers schedulers();
}
