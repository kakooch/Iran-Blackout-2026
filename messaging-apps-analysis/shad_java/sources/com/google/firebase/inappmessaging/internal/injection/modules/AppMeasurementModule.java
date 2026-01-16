package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inappmessaging.internal.ProxyAnalyticsConnector;
import com.google.firebase.inject.Deferred;

/* loaded from: classes3.dex */
public class AppMeasurementModule {
    private final AnalyticsConnector analyticsConnector;
    private final Subscriber firebaseEventsSubscriber;

    public AppMeasurementModule(Deferred<AnalyticsConnector> deferred, Subscriber subscriber) {
        this.analyticsConnector = new ProxyAnalyticsConnector(deferred);
        this.firebaseEventsSubscriber = subscriber;
    }

    AnalyticsConnector providesAnalyticsConnector() {
        return this.analyticsConnector;
    }

    Subscriber providesSubsriber() {
        return this.firebaseEventsSubscriber;
    }
}
