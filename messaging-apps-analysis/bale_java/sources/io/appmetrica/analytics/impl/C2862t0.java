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

/* renamed from: io.appmetrica.analytics.impl.t0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2862t0 implements InterfaceC2944wa {
    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa, io.appmetrica.analytics.impl.InterfaceC2964x6
    public final void a(int i, Bundle bundle) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa
    public final La c(ReporterConfig reporterConfig) {
        return new C2975xh();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa, io.appmetrica.analytics.impl.InterfaceC2803qc
    public final void clearAppEnvironment() {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa
    public final void d() {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa
    public final String e() {
        return null;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa
    public final Map<String, String> g() {
        return null;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa
    public final R9 getFeatures() {
        return new R9();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa
    public final AdvIdentifiersResult h() {
        AdvIdentifiersResult.Details details = AdvIdentifiersResult.Details.INTERNAL_ERROR;
        return new AdvIdentifiersResult(new AdvIdentifiersResult.AdvId(null, details, "Device user is in locked state"), new AdvIdentifiersResult.AdvId(null, details, "Device user is in locked state"), new AdvIdentifiersResult.AdvId(null, details, "Device user is in locked state"));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa
    public final Wb i() {
        C2564gc c2564gc = new C2564gc();
        return new Wb(c2564gc, new C2941w7(c2564gc));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa, io.appmetrica.analytics.impl.InterfaceC2803qc
    public final void putAppEnvironmentValue(String str, String str2) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa, io.appmetrica.analytics.impl.InterfaceC2803qc
    public final void setDataSendingEnabled(boolean z) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa, io.appmetrica.analytics.impl.InterfaceC2803qc
    public final void setUserProfileID(String str) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa, io.appmetrica.analytics.impl.InterfaceC2803qc
    public final void a(Location location) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa
    public final void a(AppMetricaConfig appMetricaConfig) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa
    public final void a(DeferredDeeplinkListener deferredDeeplinkListener) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa
    public final void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa
    public final void a(ReporterConfig reporterConfig) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa, io.appmetrica.analytics.impl.InterfaceC2803qc
    public final void a(String str, String str2) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa, io.appmetrica.analytics.impl.InterfaceC2803qc
    public final void a(boolean z) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa
    public final void a(StartupParamsCallback startupParamsCallback, List<String> list) {
        startupParamsCallback.onRequestError(StartupParamsCallback.Reason.UNKNOWN, null);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa, io.appmetrica.analytics.impl.Na
    public final Ma a() {
        return new Ah();
    }
}
