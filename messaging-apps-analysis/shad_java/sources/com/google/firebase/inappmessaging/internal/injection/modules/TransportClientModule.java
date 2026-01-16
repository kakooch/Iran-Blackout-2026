package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import com.google.firebase.inappmessaging.internal.MetricsLoggerClient;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.installations.FirebaseInstallationsApi;

/* loaded from: classes3.dex */
public class TransportClientModule {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ byte[] lambda$providesMetricsLoggerClient$0(byte[] bArr) {
        return bArr;
    }

    static MetricsLoggerClient providesMetricsLoggerClient(FirebaseApp firebaseApp, TransportFactory transportFactory, AnalyticsConnector analyticsConnector, FirebaseInstallationsApi firebaseInstallationsApi, Clock clock, DeveloperListenerManager developerListenerManager) {
        final Transport transport = transportFactory.getTransport("FIREBASE_INAPPMESSAGING", byte[].class, new Transformer() { // from class: com.google.firebase.inappmessaging.internal.injection.modules.TransportClientModule$$ExternalSyntheticLambda0
            @Override // com.google.android.datatransport.Transformer
            public final Object apply(Object obj) {
                return TransportClientModule.lambda$providesMetricsLoggerClient$0((byte[]) obj);
            }
        });
        return new MetricsLoggerClient(new MetricsLoggerClient.EngagementMetricsLoggerInterface(transport) { // from class: com.google.firebase.inappmessaging.internal.injection.modules.TransportClientModule$$ExternalSyntheticLambda1
        }, analyticsConnector, firebaseApp, firebaseInstallationsApi, clock, developerListenerManager);
    }
}
