package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.coreapi.internal.backport.Provider;

/* renamed from: io.appmetrica.analytics.impl.hh, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2593hh implements Provider {
    public final /* synthetic */ C2743o0 a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ ReporterConfig c;

    public C2593hh(C2743o0 c2743o0, Context context, ReporterConfig reporterConfig) {
        this.a = c2743o0;
        this.b = context;
        this.c = reporterConfig;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Provider
    public final Object get() {
        return C2951wh.a(this.a, this.b, this.c);
    }
}
