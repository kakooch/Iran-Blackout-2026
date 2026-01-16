package io.appmetrica.analytics.impl;

import android.content.Context;

/* renamed from: io.appmetrica.analytics.impl.xe, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2972xe implements InterfaceC2617ii {
    public final Context a;
    public final String b = "content://" + a() + "/preload_info";
    public final String c = "tracking_id";
    public final String d = "additional_parameters";

    public C2972xe(Context context) {
        this.a = context;
    }

    public final String a() {
        return "com.yandex.preinstallsatellite.appmetrica.provider";
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0067 A[Catch: all -> 0x00a3, TryCatch #1 {all -> 0x00a3, blocks: (B:8:0x002a, B:10:0x0030, B:19:0x0061, B:21:0x0067, B:24:0x006e, B:25:0x0076, B:18:0x005b, B:28:0x0092, B:29:0x009a, B:12:0x0046, B:15:0x004d, B:16:0x0054), top: B:37:0x0028, inners: #2 }] */
    @Override // io.appmetrica.analytics.impl.InterfaceC2617ii, ir.nasim.SA2
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final io.appmetrica.analytics.impl.Ee invoke() {
        /*
            r10 = this;
            android.content.Context r0 = r10.a
            java.lang.String r1 = "com.yandex.preinstallsatellite.appmetrica.provider"
            boolean r0 = io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils.hasContentProvider(r0, r1)
            r1 = 0
            r2 = 0
            if (r0 != 0) goto L14
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r2 = "Satellite content provider with preload info was not found."
            io.appmetrica.analytics.impl.AbstractC2904ui.a(r2, r0)
            return r1
        L14:
            android.content.Context r0 = r10.a     // Catch: java.lang.Throwable -> La2
            android.content.ContentResolver r3 = r0.getContentResolver()     // Catch: java.lang.Throwable -> La2
            java.lang.String r0 = r10.b     // Catch: java.lang.Throwable -> La2
            android.net.Uri r4 = android.net.Uri.parse(r0)     // Catch: java.lang.Throwable -> La2
            r7 = 0
            r8 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r0 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> La2
            if (r0 == 0) goto L9a
            boolean r3 = r0.moveToFirst()     // Catch: java.lang.Throwable -> La3
            if (r3 == 0) goto L92
            java.lang.String r3 = r10.c     // Catch: java.lang.Throwable -> La3
            int r3 = r0.getColumnIndexOrThrow(r3)     // Catch: java.lang.Throwable -> La3
            java.lang.String r5 = r0.getString(r3)     // Catch: java.lang.Throwable -> La3
            java.lang.String r3 = r10.d     // Catch: java.lang.Throwable -> La3
            int r3 = r0.getColumnIndexOrThrow(r3)     // Catch: java.lang.Throwable -> La3
            java.lang.String r3 = r0.getString(r3)     // Catch: java.lang.Throwable -> La3
            if (r3 == 0) goto L54
            int r4 = r3.length()     // Catch: java.lang.Throwable -> L5b
            if (r4 != 0) goto L4d
            goto L54
        L4d:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L5b
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L5b
            r6 = r4
            goto L61
        L54:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L5b
            r3.<init>()     // Catch: java.lang.Throwable -> L5b
        L59:
            r6 = r3
            goto L61
        L5b:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> La3
            r3.<init>()     // Catch: java.lang.Throwable -> La3
            goto L59
        L61:
            boolean r3 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> La3
            if (r3 != 0) goto L76
            java.lang.Long r3 = io.appmetrica.analytics.coreutils.internal.parsing.ParseUtils.parseLong(r5)     // Catch: java.lang.Throwable -> La3
            if (r3 == 0) goto L6e
            goto L76
        L6e:
            java.lang.String r3 = "Tracking id from Satellite is not a number."
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> La3
            io.appmetrica.analytics.impl.AbstractC2904ui.a(r3, r2)     // Catch: java.lang.Throwable -> La3
            goto La3
        L76:
            java.lang.String r2 = "Preload info from Satellite: {tracking id = %s, additional parameters = %s}"
            java.lang.Object[] r3 = new java.lang.Object[]{r5, r6}     // Catch: java.lang.Throwable -> La3
            io.appmetrica.analytics.impl.AbstractC2904ui.a(r2, r3)     // Catch: java.lang.Throwable -> La3
            io.appmetrica.analytics.impl.Ee r2 = new io.appmetrica.analytics.impl.Ee     // Catch: java.lang.Throwable -> La3
            boolean r3 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> La3
            r7 = r3 ^ 1
            io.appmetrica.analytics.impl.M7 r9 = io.appmetrica.analytics.impl.M7.d     // Catch: java.lang.Throwable -> La3
            r8 = 0
            r4 = r2
            r4.<init>(r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> La3
            io.appmetrica.analytics.impl.hn.a(r0)
            return r2
        L92:
            java.lang.String r3 = "No Preload Info data in Satellite content provider"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> La3
            io.appmetrica.analytics.impl.AbstractC2904ui.a(r3, r2)     // Catch: java.lang.Throwable -> La3
            goto La3
        L9a:
            java.lang.String r3 = "No Satellite content provider found"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> La3
            io.appmetrica.analytics.impl.AbstractC2904ui.a(r3, r2)     // Catch: java.lang.Throwable -> La3
            goto La3
        La2:
            r0 = r1
        La3:
            io.appmetrica.analytics.impl.hn.a(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.appmetrica.analytics.impl.C2972xe.invoke():io.appmetrica.analytics.impl.Ee");
    }
}
