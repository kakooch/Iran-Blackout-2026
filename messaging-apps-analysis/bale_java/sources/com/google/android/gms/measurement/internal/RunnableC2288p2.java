package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import ir.nasim.AbstractC3795Cj5;

/* renamed from: com.google.android.gms.measurement.internal.p2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class RunnableC2288p2 implements Runnable {
    final /* synthetic */ Bundle a;
    final /* synthetic */ G2 b;

    RunnableC2288p2(G2 g2, Bundle bundle) {
        this.b = g2;
        this.a = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        G2 g2 = this.b;
        Bundle bundle = this.a;
        g2.h();
        g2.i();
        AbstractC3795Cj5.j(bundle);
        String string = bundle.getString("name");
        String string2 = bundle.getString("origin");
        AbstractC3795Cj5.f(string);
        AbstractC3795Cj5.f(string2);
        AbstractC3795Cj5.j(bundle.get("value"));
        if (!g2.a.o()) {
            g2.a.b().v().a("Conditional property not set since app measurement is disabled");
            return;
        }
        zzkw zzkwVar = new zzkw(string, bundle.getLong("triggered_timestamp"), bundle.get("value"), string2);
        try {
            zzaw zzawVarW0 = g2.a.N().w0(bundle.getString(CommonUrlParts.APP_ID), bundle.getString("triggered_event_name"), bundle.getBundle("triggered_event_params"), string2, 0L, true, true);
            g2.a.L().s(new zzac(bundle.getString(CommonUrlParts.APP_ID), string2, zzkwVar, bundle.getLong("creation_timestamp"), false, bundle.getString("trigger_event_name"), g2.a.N().w0(bundle.getString(CommonUrlParts.APP_ID), bundle.getString("timed_out_event_name"), bundle.getBundle("timed_out_event_params"), string2, 0L, true, true), bundle.getLong("trigger_timeout"), zzawVarW0, bundle.getLong("time_to_live"), g2.a.N().w0(bundle.getString(CommonUrlParts.APP_ID), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), string2, 0L, true, true)));
        } catch (IllegalArgumentException unused) {
        }
    }
}
