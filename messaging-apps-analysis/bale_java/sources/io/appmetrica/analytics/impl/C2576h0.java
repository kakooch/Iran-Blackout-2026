package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Handler;
import io.appmetrica.analytics.AppMetrica;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.impl.C2576h0;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
import io.appmetrica.analytics.logger.common.BaseReleaseLogger;
import java.util.regex.Pattern;

/* renamed from: io.appmetrica.analytics.impl.h0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2576h0 implements InterfaceC2920va {
    public final Context a;
    public final IHandlerExecutor b;
    public final C2771p4 c = new C2771p4();
    public final Handler d = f().getHandler();
    public final T1 e = new T1();
    public final C2465cb f = new C2465cb();
    public boolean g;

    public C2576h0(Context context, C2556g4 c2556g4) {
        this.a = context;
        this.b = c2556g4.a();
        BaseReleaseLogger.init(context);
        f().execute(new Runnable() { // from class: ir.nasim.ee8
            @Override // java.lang.Runnable
            public final void run() {
                C2576h0.e();
            }
        });
        a().a();
        W3.a().onCreate();
    }

    public static final void e() {
        Pattern pattern = AbstractC2904ui.a;
        ImportantLogger.INSTANCE.info("AppMetrica", "Initializing of AppMetrica, " + StringUtils.capitalize("release") + " type, Version 7.1.0, API Level " + AppMetrica.getLibraryApiLevel() + ", Dated 21.08.2024.", new Object[0]);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2920va
    public final C2771p4 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2920va
    public final Handler b() {
        return this.d;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2920va
    public final T1 c() {
        return this.e;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2920va
    public final C2465cb d() {
        return this.f;
    }

    public final IHandlerExecutor f() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2920va
    public final ICommonExecutor getDefaultExecutor() {
        return this.b;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002b A[Catch: all -> 0x000e, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:6:0x0007, B:8:0x000b, B:11:0x0010, B:14:0x0017, B:19:0x0034, B:21:0x0038, B:22:0x003a, B:25:0x0041, B:28:0x004e, B:26:0x0047, B:15:0x001d, B:17:0x002b), top: B:33:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0034 A[Catch: all -> 0x000e, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:6:0x0007, B:8:0x000b, B:11:0x0010, B:14:0x0017, B:19:0x0034, B:21:0x0038, B:22:0x003a, B:25:0x0041, B:28:0x004e, B:26:0x0047, B:15:0x001d, B:17:0x002b), top: B:33:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047 A[Catch: all -> 0x000e, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:6:0x0007, B:8:0x000b, B:11:0x0010, B:14:0x0017, B:19:0x0034, B:21:0x0038, B:22:0x003a, B:25:0x0041, B:28:0x004e, B:26:0x0047, B:15:0x001d, B:17:0x002b), top: B:33:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004e A[Catch: all -> 0x000e, TRY_LEAVE, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:6:0x0007, B:8:0x000b, B:11:0x0010, B:14:0x0017, B:19:0x0034, B:21:0x0038, B:22:0x003a, B:25:0x0041, B:28:0x004e, B:26:0x0047, B:15:0x001d, B:17:0x002b), top: B:33:0x0001 }] */
    @Override // io.appmetrica.analytics.impl.InterfaceC2920va
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void a(io.appmetrica.analytics.AppMetricaConfig r3, io.appmetrica.analytics.impl.Na r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.g     // Catch: java.lang.Throwable -> Le
            if (r0 != 0) goto L51
            if (r3 == 0) goto L1d
            java.lang.Boolean r0 = r3.crashReporting     // Catch: java.lang.Throwable -> Le
            if (r0 != 0) goto L10
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> Le
            goto L10
        Le:
            r3 = move-exception
            goto L53
        L10:
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> Le
            if (r0 == 0) goto L17
            goto L1d
        L17:
            io.appmetrica.analytics.impl.cb r4 = r2.f     // Catch: java.lang.Throwable -> Le
            r4.a()     // Catch: java.lang.Throwable -> Le
            goto L32
        L1d:
            io.appmetrica.analytics.impl.cb r0 = r2.f     // Catch: java.lang.Throwable -> Le
            r0.b()     // Catch: java.lang.Throwable -> Le
            io.appmetrica.analytics.impl.cb r0 = r2.f     // Catch: java.lang.Throwable -> Le
            android.content.Context r1 = r2.a     // Catch: java.lang.Throwable -> Le
            r0.a(r1, r4)     // Catch: java.lang.Throwable -> Le
            if (r3 == 0) goto L32
            io.appmetrica.analytics.impl.cb r0 = r2.f     // Catch: java.lang.Throwable -> Le
            android.content.Context r1 = r2.a     // Catch: java.lang.Throwable -> Le
            r0.a(r1, r3, r4)     // Catch: java.lang.Throwable -> Le
        L32:
            if (r3 == 0) goto L47
            java.lang.Boolean r4 = r3.appOpenTrackingEnabled     // Catch: java.lang.Throwable -> Le
            if (r4 != 0) goto L3a
            java.lang.Boolean r4 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> Le
        L3a:
            boolean r4 = r4.booleanValue()     // Catch: java.lang.Throwable -> Le
            if (r4 == 0) goto L41
            goto L47
        L41:
            io.appmetrica.analytics.impl.T1 r4 = r2.e     // Catch: java.lang.Throwable -> Le
            r4.c()     // Catch: java.lang.Throwable -> Le
            goto L4c
        L47:
            io.appmetrica.analytics.impl.T1 r4 = r2.e     // Catch: java.lang.Throwable -> Le
            r4.b()     // Catch: java.lang.Throwable -> Le
        L4c:
            if (r3 == 0) goto L51
            r3 = 1
            r2.g = r3     // Catch: java.lang.Throwable -> Le
        L51:
            monitor-exit(r2)
            return
        L53:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.appmetrica.analytics.impl.C2576h0.a(io.appmetrica.analytics.AppMetricaConfig, io.appmetrica.analytics.impl.Na):void");
    }
}
