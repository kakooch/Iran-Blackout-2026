package com.google.firebase.remoteconfig.internal;

import com.google.firebase.analytics.connector.AnalyticsConnector;
import j$.util.DesugarCollections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class Personalization {
    private final AnalyticsConnector analyticsConnector;
    private final Map<String, String> loggedChoiceIds = DesugarCollections.synchronizedMap(new HashMap());

    public Personalization(AnalyticsConnector analyticsConnector) {
        this.analyticsConnector = analyticsConnector;
    }
}
