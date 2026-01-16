package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.system.PermissionExtractor;
import io.appmetrica.analytics.coreutils.internal.cache.CachedDataProvider;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import java.util.concurrent.TimeUnit;

/* renamed from: io.appmetrica.analytics.impl.mk, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2715mk implements InterfaceC2741nm {
    public static final long d = TimeUnit.SECONDS.toMillis(20);
    public final Context a;
    public final PermissionExtractor b;
    public final CachedDataProvider.CachedData c;

    public C2715mk(Context context) {
        long j = d;
        this.c = new CachedDataProvider.CachedData(j, j, "sim-info");
        this.a = context;
        this.b = C2586ha.h().g();
    }

    public final C2596hk b() {
        return new C2596hk((Integer) SystemServiceUtils.accessSystemServiceByNameSafely(this.a, "phone", "getting SimMcc", "TelephonyManager", new C2619ik()), (Integer) SystemServiceUtils.accessSystemServiceByNameSafely(this.a, "phone", "getting SimMnc", "TelephonyManager", new C2643jk()), ((Boolean) SystemServiceUtils.accessSystemServiceByNameSafelyOrDefault(this.a, "phone", "getting NetworkRoaming", "TelephonyManager", Boolean.FALSE, new C2691lk(this))).booleanValue(), (String) SystemServiceUtils.accessSystemServiceByNameSafely(this.a, "phone", "getting SimOperatorName", "TelephonyManager", new C2667kk()));
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002f A[Catch: all -> 0x001a, TryCatch #0 {all -> 0x001a, blocks: (B:3:0x0001, B:5:0x000b, B:7:0x0011, B:12:0x001c, B:14:0x002f, B:16:0x0037, B:18:0x0043, B:19:0x004c, B:21:0x0052, B:22:0x005a, B:23:0x0061), top: B:28:0x0001 }] */
    @Override // io.appmetrica.analytics.impl.InterfaceC2741nm
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized java.util.List<io.appmetrica.analytics.impl.C2596hk> a() {
        /*
            r4 = this;
            monitor-enter(r4)
            io.appmetrica.analytics.coreutils.internal.cache.CachedDataProvider$CachedData r0 = r4.c     // Catch: java.lang.Throwable -> L1a
            java.lang.Object r0 = r0.getData()     // Catch: java.lang.Throwable -> L1a
            java.util.List r0 = (java.util.List) r0     // Catch: java.lang.Throwable -> L1a
            if (r0 == 0) goto L1c
            boolean r1 = r0.isEmpty()     // Catch: java.lang.Throwable -> L1a
            if (r1 == 0) goto L66
            io.appmetrica.analytics.coreutils.internal.cache.CachedDataProvider$CachedData r1 = r4.c     // Catch: java.lang.Throwable -> L1a
            boolean r1 = r1.shouldUpdateData()     // Catch: java.lang.Throwable -> L1a
            if (r1 == 0) goto L66
            goto L1c
        L1a:
            r0 = move-exception
            goto L68
        L1c:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L1a
            r0.<init>()     // Catch: java.lang.Throwable -> L1a
            io.appmetrica.analytics.impl.ha r1 = io.appmetrica.analytics.impl.C2586ha.C     // Catch: java.lang.Throwable -> L1a
            io.appmetrica.analytics.impl.hl r1 = r1.u     // Catch: java.lang.Throwable -> L1a
            io.appmetrica.analytics.impl.fl r1 = r1.a()     // Catch: java.lang.Throwable -> L1a
            io.appmetrica.analytics.impl.w4 r1 = r1.n     // Catch: java.lang.Throwable -> L1a
            boolean r1 = r1.d     // Catch: java.lang.Throwable -> L1a
            if (r1 == 0) goto L61
            r1 = 23
            boolean r1 = io.appmetrica.analytics.coreutils.internal.AndroidUtils.isApiAchieved(r1)     // Catch: java.lang.Throwable -> L1a
            if (r1 == 0) goto L5a
            io.appmetrica.analytics.coreapi.internal.system.PermissionExtractor r1 = r4.b     // Catch: java.lang.Throwable -> L1a
            android.content.Context r2 = r4.a     // Catch: java.lang.Throwable -> L1a
            java.lang.String r3 = "android.permission.READ_PHONE_STATE"
            boolean r1 = r1.hasPermission(r2, r3)     // Catch: java.lang.Throwable -> L1a
            if (r1 == 0) goto L4c
            android.content.Context r1 = r4.a     // Catch: java.lang.Throwable -> L1a
            java.util.List r1 = io.appmetrica.analytics.impl.C2739nk.a(r1)     // Catch: java.lang.Throwable -> L1a
            r0.addAll(r1)     // Catch: java.lang.Throwable -> L1a
        L4c:
            int r1 = r0.size()     // Catch: java.lang.Throwable -> L1a
            if (r1 != 0) goto L61
            io.appmetrica.analytics.impl.hk r1 = r4.b()     // Catch: java.lang.Throwable -> L1a
            r0.add(r1)     // Catch: java.lang.Throwable -> L1a
            goto L61
        L5a:
            io.appmetrica.analytics.impl.hk r1 = r4.b()     // Catch: java.lang.Throwable -> L1a
            r0.add(r1)     // Catch: java.lang.Throwable -> L1a
        L61:
            io.appmetrica.analytics.coreutils.internal.cache.CachedDataProvider$CachedData r1 = r4.c     // Catch: java.lang.Throwable -> L1a
            r1.setData(r0)     // Catch: java.lang.Throwable -> L1a
        L66:
            monitor-exit(r4)
            return r0
        L68:
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.appmetrica.analytics.impl.C2715mk.a():java.util.List");
    }
}
