package com.google.android.gms.measurement.internal;

import ir.nasim.InterfaceC19683ql8;

/* renamed from: com.google.android.gms.measurement.internal.u2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class RunnableC2312u2 implements Runnable {
    final /* synthetic */ InterfaceC19683ql8 a;
    final /* synthetic */ G2 b;

    RunnableC2312u2(G2 g2, InterfaceC19683ql8 interfaceC19683ql8) {
        this.b = g2;
        this.a = interfaceC19683ql8;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r6 = this;
            com.google.android.gms.measurement.internal.G2 r0 = r6.b
            com.google.android.gms.measurement.internal.H1 r0 = r0.a
            com.google.android.gms.measurement.internal.J3 r0 = r0.M()
            ir.nasim.Tt8.b()
            com.google.android.gms.measurement.internal.H1 r1 = r0.a
            com.google.android.gms.measurement.internal.g r1 = r1.z()
            com.google.android.gms.measurement.internal.R0 r2 = com.google.android.gms.measurement.internal.S0.w0
            r3 = 0
            boolean r1 = r1.B(r3, r2)
            if (r1 == 0) goto L77
            com.google.android.gms.measurement.internal.H1 r1 = r0.a
            com.google.android.gms.measurement.internal.q1 r1 = r1.F()
            ir.nasim.Xh8 r1 = r1.q()
            ir.nasim.Qh8 r2 = ir.nasim.Qh8.ANALYTICS_STORAGE
            boolean r1 = r1.i(r2)
            if (r1 != 0) goto L3d
            com.google.android.gms.measurement.internal.H1 r0 = r0.a
            com.google.android.gms.measurement.internal.d1 r0 = r0.b()
            com.google.android.gms.measurement.internal.b1 r0 = r0.x()
            java.lang.String r1 = "Analytics storage consent denied; will not get session id"
            r0.a(r1)
        L3b:
            r0 = r3
            goto L87
        L3d:
            com.google.android.gms.measurement.internal.H1 r1 = r0.a
            com.google.android.gms.measurement.internal.q1 r1 = r1.F()
            com.google.android.gms.measurement.internal.H1 r2 = r0.a
            ir.nasim.OV0 r2 = r2.c()
            long r4 = r2.currentTimeMillis()
            boolean r1 = r1.v(r4)
            if (r1 != 0) goto L3b
            com.google.android.gms.measurement.internal.H1 r1 = r0.a
            com.google.android.gms.measurement.internal.q1 r1 = r1.F()
            com.google.android.gms.measurement.internal.n1 r1 = r1.p
            long r1 = r1.a()
            r4 = 0
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 != 0) goto L66
            goto L3b
        L66:
            com.google.android.gms.measurement.internal.H1 r0 = r0.a
            com.google.android.gms.measurement.internal.q1 r0 = r0.F()
            com.google.android.gms.measurement.internal.n1 r0 = r0.p
            long r0 = r0.a()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            goto L87
        L77:
            com.google.android.gms.measurement.internal.H1 r0 = r0.a
            com.google.android.gms.measurement.internal.d1 r0 = r0.b()
            com.google.android.gms.measurement.internal.b1 r0 = r0.x()
            java.lang.String r1 = "getSessionId has been disabled."
            r0.a(r1)
            goto L3b
        L87:
            if (r0 == 0) goto L9b
            com.google.android.gms.measurement.internal.G2 r1 = r6.b
            com.google.android.gms.measurement.internal.H1 r1 = r1.a
            com.google.android.gms.measurement.internal.f4 r1 = r1.N()
            ir.nasim.ql8 r2 = r6.a
            long r3 = r0.longValue()
            r1.I(r2, r3)
            return
        L9b:
            ir.nasim.ql8 r0 = r6.a     // Catch: android.os.RemoteException -> La1
            r0.F1(r3)     // Catch: android.os.RemoteException -> La1
            return
        La1:
            r0 = move-exception
            com.google.android.gms.measurement.internal.G2 r1 = r6.b
            com.google.android.gms.measurement.internal.H1 r1 = r1.a
            com.google.android.gms.measurement.internal.d1 r1 = r1.b()
            com.google.android.gms.measurement.internal.b1 r1 = r1.r()
            java.lang.String r2 = "getSessionId failed with exception"
            r1.b(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.RunnableC2312u2.run():void");
    }
}
