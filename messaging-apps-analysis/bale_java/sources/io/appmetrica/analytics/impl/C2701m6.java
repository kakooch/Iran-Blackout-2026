package io.appmetrica.analytics.impl;

import android.content.Context;

/* renamed from: io.appmetrica.analytics.impl.m6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2701m6 {
    public final U9 a;
    public final C2558g6 b;
    public final Context c;
    public final T9 d;

    public C2701m6(Context context) {
        this(context, new U9(), new C2558g6(), T9.a(context));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:5|(5:(9:7|(2:10|(1:12)(1:27))|15|23|16|25|17|18|29)(1:13)|25|17|18|29)|(1:28)|15|23|16) */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0097, code lost:
    
        r0 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(io.appmetrica.analytics.impl.Ng r6) {
        /*
            r5 = this;
            android.content.Context r0 = r5.c
            java.io.File r0 = io.appmetrica.analytics.coreutils.internal.io.FileUtils.getCrashesDirectory(r0)
            io.appmetrica.analytics.impl.g6 r1 = r5.b
            r1.getClass()
            if (r0 != 0) goto Lf
            goto L9e
        Lf:
            boolean r1 = r0.exists()
            if (r1 == 0) goto L27
            boolean r1 = r0.isDirectory()
            if (r1 == 0) goto L1c
            goto L2d
        L1c:
            boolean r1 = r0.delete()
            if (r1 == 0) goto L9e
            boolean r1 = r0.mkdir()
            goto L2b
        L27:
            boolean r1 = r0.mkdir()
        L2b:
            if (r1 == 0) goto L9e
        L2d:
            io.appmetrica.analytics.impl.Wg r1 = r6.e
            io.appmetrica.analytics.impl.Oe r1 = r1.a
            android.content.ContentValues r2 = r1.a
            java.lang.String r3 = "PROCESS_CFG_PROCESS_ID"
            java.lang.Integer r2 = r2.getAsInteger(r3)
            android.content.ContentValues r1 = r1.a
            java.lang.String r3 = "PROCESS_CFG_PROCESS_SESSION_ID"
            java.lang.String r1 = r1.getAsString(r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            java.lang.String r2 = "-"
            r3.append(r2)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            io.appmetrica.analytics.impl.T9 r2 = r5.d
            io.appmetrica.analytics.impl.q9 r2 = r2.a(r1)
            java.util.concurrent.locks.ReentrantLock r3 = r2.a     // Catch: java.lang.Throwable -> L97
            r3.lock()     // Catch: java.lang.Throwable -> L97
            io.appmetrica.analytics.impl.S9 r3 = r2.b     // Catch: java.lang.Throwable -> L97
            r3.a()     // Catch: java.lang.Throwable -> L97
            io.appmetrica.analytics.impl.U9 r3 = r5.a     // Catch: java.lang.Throwable -> L97
            r3.getClass()     // Catch: java.lang.Throwable -> L97
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L97
            r3.<init>(r0, r1)     // Catch: java.lang.Throwable -> L97
            java.io.PrintWriter r0 = new java.io.PrintWriter     // Catch: java.lang.Throwable -> L97
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L97
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L97
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L97
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L97
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L97
            io.appmetrica.analytics.impl.bb r1 = new io.appmetrica.analytics.impl.bb     // Catch: java.lang.Throwable -> L98
            io.appmetrica.analytics.impl.Q5 r3 = r6.a     // Catch: java.lang.Throwable -> L98
            io.appmetrica.analytics.impl.Wg r4 = r6.e     // Catch: java.lang.Throwable -> L98
            java.util.HashMap r6 = r6.d     // Catch: java.lang.Throwable -> L98
            r1.<init>(r3, r4, r6)     // Catch: java.lang.Throwable -> L98
            java.lang.String r6 = r1.k()     // Catch: java.lang.Throwable -> L98
            r0.write(r6)     // Catch: java.lang.Throwable -> L98
            io.appmetrica.analytics.impl.hn.a(r0)
            r2.c()
            goto L9e
        L97:
            r0 = 0
        L98:
            io.appmetrica.analytics.impl.hn.a(r0)
            r2.c()
        L9e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.appmetrica.analytics.impl.C2701m6.a(io.appmetrica.analytics.impl.Ng):void");
    }

    public C2701m6(Context context, U9 u9, C2558g6 c2558g6, T9 t9) {
        this.c = context;
        this.a = u9;
        this.b = c2558g6;
        this.d = t9;
    }
}
