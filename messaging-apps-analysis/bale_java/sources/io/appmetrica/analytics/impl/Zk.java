package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.Map;

/* loaded from: classes3.dex */
public final class Zk extends N5 {
    public final Q3 b;

    public Zk(Context context, String str) {
        this(context, str, new SafePackageManager(), C2586ha.h().d());
    }

    @Override // io.appmetrica.analytics.impl.N5, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final C2425al load(M5 m5) {
        C2425al c2425al = (C2425al) super.load(m5);
        C2549fl c2549fl = m5.a;
        c2425al.d = c2549fl.f;
        c2425al.e = c2549fl.g;
        Yk yk = (Yk) m5.componentArguments;
        String str = yk.a;
        if (str != null) {
            c2425al.f = str;
            c2425al.g = yk.b;
        }
        Map<String, String> map = yk.c;
        c2425al.h = map;
        c2425al.i = (I3) this.b.a(new I3(map, M7.c));
        Yk yk2 = (Yk) m5.componentArguments;
        c2425al.k = yk2.d;
        c2425al.j = yk2.e;
        C2549fl c2549fl2 = m5.a;
        c2425al.l = c2549fl2.p;
        c2425al.m = c2549fl2.r;
        long j = c2549fl2.v;
        if (c2425al.n == 0) {
            c2425al.n = j;
        }
        return c2425al;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader
    public final BaseRequestConfig createBlankConfig() {
        return new C2425al();
    }

    public Zk(Context context, String str, SafePackageManager safePackageManager, Q3 q3) {
        super(context, str, safePackageManager);
        this.b = q3;
    }

    public final C2425al a() {
        return new C2425al();
    }
}
