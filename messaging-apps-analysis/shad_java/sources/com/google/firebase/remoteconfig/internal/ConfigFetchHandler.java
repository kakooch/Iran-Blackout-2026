package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.common.util.Clock;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class ConfigFetchHandler {
    private final AnalyticsConnector analyticsConnector;
    private final Map<String, String> customHttpHeaders;
    private final Executor executor;
    private final FirebaseInstallationsApi firebaseInstallations;

    static {
        TimeUnit.HOURS.toSeconds(12L);
    }

    public ConfigFetchHandler(FirebaseInstallationsApi firebaseInstallationsApi, AnalyticsConnector analyticsConnector, Executor executor, Clock clock, Random random, ConfigCacheClient configCacheClient, ConfigFetchHttpClient configFetchHttpClient, ConfigMetadataClient configMetadataClient, Map<String, String> map) {
        this.firebaseInstallations = firebaseInstallationsApi;
        this.analyticsConnector = analyticsConnector;
        this.executor = executor;
        this.customHttpHeaders = map;
    }

    public static class FetchResponse {
        private FetchResponse(Date date, int i, ConfigContainer configContainer, String str) {
        }

        public static FetchResponse forBackendUpdatesFetched(ConfigContainer configContainer, String str) {
            return new FetchResponse(configContainer.getFetchTime(), 0, configContainer, str);
        }

        public static FetchResponse forBackendHasNoUpdates(Date date) {
            return new FetchResponse(date, 1, null, null);
        }
    }
}
