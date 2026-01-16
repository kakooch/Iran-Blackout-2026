package io.appmetrica.analytics.impl;

/* renamed from: io.appmetrica.analytics.impl.oi, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2761oi {
    /* JADX WARN: Removed duplicated region for block: B:11:0x001f A[Catch: all -> 0x002f, TRY_LEAVE, TryCatch #3 {all -> 0x002f, blocks: (B:3:0x0003, B:9:0x0011, B:11:0x001f), top: B:33:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0011 A[Catch: all -> 0x002f, TRY_ENTER, TryCatch #3 {all -> 0x002f, blocks: (B:3:0x0003, B:9:0x0011, B:11:0x001f), top: B:33:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static io.appmetrica.analytics.coreapi.internal.model.ScreenInfo a(android.content.Context r5) {
        /*
            r0 = 30
            r1 = 0
            boolean r0 = io.appmetrica.analytics.coreutils.internal.AndroidUtils.isApiAchieved(r0)     // Catch: java.lang.Throwable -> L2f
            if (r0 == 0) goto Le
            android.view.Display r0 = ir.nasim.AbstractC20220re8.a(r5)     // Catch: java.lang.Throwable -> Le
            goto Lf
        Le:
            r0 = r1
        Lf:
            if (r0 != 0) goto L1d
            java.lang.String r0 = "window"
            java.lang.Object r0 = r5.getSystemService(r0)     // Catch: java.lang.Throwable -> L2f
            android.view.WindowManager r0 = (android.view.WindowManager) r0     // Catch: java.lang.Throwable -> L2f
            android.view.Display r0 = r0.getDefaultDisplay()     // Catch: java.lang.Throwable -> L2f
        L1d:
            if (r0 == 0) goto L2f
            java.lang.String r2 = "getting display metrics"
            java.lang.String r3 = "Display"
            io.appmetrica.analytics.impl.ni r4 = new io.appmetrica.analytics.impl.ni     // Catch: java.lang.Throwable -> L2f
            r4.<init>()     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r0 = io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils.accessSystemServiceSafely(r0, r2, r3, r4)     // Catch: java.lang.Throwable -> L2f
            android.graphics.Point r0 = (android.graphics.Point) r0     // Catch: java.lang.Throwable -> L2f
            goto L30
        L2f:
            r0 = r1
        L30:
            if (r0 != 0) goto L33
            return r1
        L33:
            int r1 = r0.x
            int r2 = r0.y
            int r1 = java.lang.Math.max(r1, r2)
            int r2 = r0.x
            int r0 = r0.y
            int r0 = java.lang.Math.min(r2, r0)
            android.content.res.Resources r5 = r5.getResources()     // Catch: java.lang.Throwable -> L50
            android.util.DisplayMetrics r5 = r5.getDisplayMetrics()     // Catch: java.lang.Throwable -> L50
            int r2 = r5.densityDpi     // Catch: java.lang.Throwable -> L50
            float r5 = r5.density     // Catch: java.lang.Throwable -> L51
            goto L52
        L50:
            r2 = 0
        L51:
            r5 = 0
        L52:
            io.appmetrica.analytics.coreapi.internal.model.ScreenInfo r3 = new io.appmetrica.analytics.coreapi.internal.model.ScreenInfo
            r3.<init>(r1, r0, r2, r5)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.appmetrica.analytics.impl.C2761oi.a(android.content.Context):io.appmetrica.analytics.coreapi.internal.model.ScreenInfo");
    }
}
