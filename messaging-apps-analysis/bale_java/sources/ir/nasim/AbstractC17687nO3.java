package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.nO3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC17687nO3 {
    private static final String a = "nO3";
    private static boolean b = false;
    private static a c = a.LEGACY;

    /* renamed from: ir.nasim.nO3$a */
    public enum a {
        LEGACY,
        LATEST
    }

    public static synchronized int a(Context context) {
        return b(context, null, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0051 A[Catch: all -> 0x0024, RemoteException -> 0x0056, TryCatch #3 {RemoteException -> 0x0056, blocks: (B:23:0x004b, B:25:0x0051, B:28:0x0058), top: B:50:0x004b, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007a A[Catch: all -> 0x0024, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x0003, B:7:0x001e, B:13:0x0028, B:14:0x002c, B:16:0x003b, B:18:0x0040, B:23:0x004b, B:25:0x0051, B:28:0x0058, B:31:0x0067, B:33:0x007a, B:30:0x0060, B:37:0x0082, B:38:0x0087, B:40:0x0089), top: B:47:0x0003, inners: #0, #2, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized int b(android.content.Context r5, ir.nasim.AbstractC17687nO3.a r6, ir.nasim.InterfaceC24853zJ4 r7) {
        /*
            java.lang.Class<ir.nasim.nO3> r0 = ir.nasim.AbstractC17687nO3.class
            monitor-enter(r0)
            java.lang.String r1 = "Context is null"
            ir.nasim.AbstractC3795Cj5.k(r5, r1)     // Catch: java.lang.Throwable -> L24
            java.lang.String r1 = ir.nasim.AbstractC17687nO3.a     // Catch: java.lang.Throwable -> L24
            java.lang.String r2 = "preferredRenderer: "
            java.lang.String r3 = java.lang.String.valueOf(r6)     // Catch: java.lang.Throwable -> L24
            java.lang.String r2 = r2.concat(r3)     // Catch: java.lang.Throwable -> L24
            android.util.Log.d(r1, r2)     // Catch: java.lang.Throwable -> L24
            boolean r1 = ir.nasim.AbstractC17687nO3.b     // Catch: java.lang.Throwable -> L24
            r2 = 0
            if (r1 == 0) goto L28
            if (r7 == 0) goto L26
            ir.nasim.nO3$a r5 = ir.nasim.AbstractC17687nO3.c     // Catch: java.lang.Throwable -> L24
            r7.a(r5)     // Catch: java.lang.Throwable -> L24
            goto L26
        L24:
            r5 = move-exception
            goto L8d
        L26:
            monitor-exit(r0)
            return r2
        L28:
            ir.nasim.Cn8 r1 = ir.nasim.AbstractC13755gl8.a(r5, r6)     // Catch: java.lang.Throwable -> L24 com.google.android.gms.common.GooglePlayServicesNotAvailableException -> L88
            ir.nasim.zZ2 r3 = r1.g()     // Catch: java.lang.Throwable -> L24 android.os.RemoteException -> L81
            ir.nasim.OD0.b(r3)     // Catch: java.lang.Throwable -> L24 android.os.RemoteException -> L81
            ir.nasim.Xp8 r3 = r1.m()     // Catch: java.lang.Throwable -> L24 android.os.RemoteException -> L81
            ir.nasim.AbstractC7085Qf0.a(r3)     // Catch: java.lang.Throwable -> L24 android.os.RemoteException -> L81
            r3 = 1
            ir.nasim.AbstractC17687nO3.b = r3     // Catch: java.lang.Throwable -> L24
            r4 = 2
            if (r6 == 0) goto L48
            int r6 = r6.ordinal()     // Catch: java.lang.Throwable -> L24
            if (r6 == 0) goto L4b
            if (r6 == r3) goto L4a
        L48:
            r3 = r2
            goto L4b
        L4a:
            r3 = r4
        L4b:
            int r6 = r1.d()     // Catch: java.lang.Throwable -> L24 android.os.RemoteException -> L56
            if (r6 != r4) goto L58
            ir.nasim.nO3$a r6 = ir.nasim.AbstractC17687nO3.a.LATEST     // Catch: java.lang.Throwable -> L24 android.os.RemoteException -> L56
            ir.nasim.AbstractC17687nO3.c = r6     // Catch: java.lang.Throwable -> L24 android.os.RemoteException -> L56
            goto L58
        L56:
            r5 = move-exception
            goto L60
        L58:
            ir.nasim.XZ2 r5 = ir.nasim.CG4.E2(r5)     // Catch: java.lang.Throwable -> L24 android.os.RemoteException -> L56
            r1.f2(r5, r3)     // Catch: java.lang.Throwable -> L24 android.os.RemoteException -> L56
            goto L67
        L60:
            java.lang.String r6 = ir.nasim.AbstractC17687nO3.a     // Catch: java.lang.Throwable -> L24
            java.lang.String r1 = "Failed to retrieve renderer type or log initialization."
            android.util.Log.e(r6, r1, r5)     // Catch: java.lang.Throwable -> L24
        L67:
            java.lang.String r5 = ir.nasim.AbstractC17687nO3.a     // Catch: java.lang.Throwable -> L24
            java.lang.String r6 = "loadedRenderer: "
            ir.nasim.nO3$a r1 = ir.nasim.AbstractC17687nO3.c     // Catch: java.lang.Throwable -> L24
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch: java.lang.Throwable -> L24
            java.lang.String r6 = r6.concat(r1)     // Catch: java.lang.Throwable -> L24
            android.util.Log.d(r5, r6)     // Catch: java.lang.Throwable -> L24
            if (r7 == 0) goto L7f
            ir.nasim.nO3$a r5 = ir.nasim.AbstractC17687nO3.c     // Catch: java.lang.Throwable -> L24
            r7.a(r5)     // Catch: java.lang.Throwable -> L24
        L7f:
            monitor-exit(r0)
            return r2
        L81:
            r5 = move-exception
            com.google.android.gms.maps.model.RuntimeRemoteException r6 = new com.google.android.gms.maps.model.RuntimeRemoteException     // Catch: java.lang.Throwable -> L24
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L24
            throw r6     // Catch: java.lang.Throwable -> L24
        L88:
            r5 = move-exception
            int r5 = r5.a     // Catch: java.lang.Throwable -> L24
            monitor-exit(r0)
            return r5
        L8d:
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC17687nO3.b(android.content.Context, ir.nasim.nO3$a, ir.nasim.zJ4):int");
    }
}
