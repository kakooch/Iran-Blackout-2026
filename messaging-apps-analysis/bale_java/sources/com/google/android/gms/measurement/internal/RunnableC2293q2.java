package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import ir.nasim.AbstractC3795Cj5;

/* renamed from: com.google.android.gms.measurement.internal.q2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class RunnableC2293q2 implements Runnable {
    final /* synthetic */ Bundle a;
    final /* synthetic */ G2 b;

    RunnableC2293q2(G2 g2, Bundle bundle) {
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
        String strF = AbstractC3795Cj5.f(bundle.getString("name"));
        if (!g2.a.o()) {
            g2.a.b().v().a("Conditional property not cleared since app measurement is disabled");
            return;
        }
        try {
            g2.a.L().s(new zzac(bundle.getString(CommonUrlParts.APP_ID), "", new zzkw(strF, 0L, null, ""), bundle.getLong("creation_timestamp"), bundle.getBoolean("active"), bundle.getString("trigger_event_name"), null, bundle.getLong("trigger_timeout"), null, bundle.getLong("time_to_live"), g2.a.N().w0(bundle.getString(CommonUrlParts.APP_ID), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), "", bundle.getLong("creation_timestamp"), true, true)));
        } catch (IllegalArgumentException unused) {
        }
    }
}
