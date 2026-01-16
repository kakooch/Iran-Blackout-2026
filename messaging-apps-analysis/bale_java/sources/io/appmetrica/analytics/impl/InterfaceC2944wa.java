package io.appmetrica.analytics.impl;

import android.location.Location;
import android.os.Bundle;
import io.appmetrica.analytics.AdvIdentifiersResult;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.DeferredDeeplinkListener;
import io.appmetrica.analytics.DeferredDeeplinkParametersListener;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.StartupParamsCallback;
import java.util.List;
import java.util.Map;

/* renamed from: io.appmetrica.analytics.impl.wa, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public interface InterfaceC2944wa extends InterfaceC2803qc, InterfaceC2964x6, Na {
    /* synthetic */ Ma a();

    /* synthetic */ void a(int i, Bundle bundle);

    @Override // io.appmetrica.analytics.impl.InterfaceC2803qc
    /* synthetic */ void a(Location location);

    void a(AppMetricaConfig appMetricaConfig);

    void a(DeferredDeeplinkListener deferredDeeplinkListener);

    void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener);

    void a(ReporterConfig reporterConfig);

    void a(StartupParamsCallback startupParamsCallback, List<String> list);

    @Override // io.appmetrica.analytics.impl.InterfaceC2803qc
    /* synthetic */ void a(String str, String str2);

    @Override // io.appmetrica.analytics.impl.InterfaceC2803qc
    /* synthetic */ void a(boolean z);

    La c(ReporterConfig reporterConfig);

    @Override // io.appmetrica.analytics.impl.InterfaceC2803qc
    /* synthetic */ void clearAppEnvironment();

    void d();

    String e();

    Map<String, String> g();

    R9 getFeatures();

    AdvIdentifiersResult h();

    Wb i();

    @Override // io.appmetrica.analytics.impl.InterfaceC2803qc
    /* synthetic */ void putAppEnvironmentValue(String str, String str2);

    @Override // io.appmetrica.analytics.impl.InterfaceC2803qc
    /* synthetic */ void setDataSendingEnabled(boolean z);

    @Override // io.appmetrica.analytics.impl.InterfaceC2803qc
    /* synthetic */ void setUserProfileID(String str);
}
