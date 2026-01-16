package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;

/* renamed from: io.appmetrica.analytics.impl.wj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2953wj {
    public final sn a;
    public final String b = "startup_state";
    public final AESEncrypter c;

    public C2953wj(sn snVar) {
        this.a = snVar;
        C2403a c2403a = new C2403a(C2586ha.h().e());
        this.c = new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, c2403a.b(), c2403a.a());
    }

    public final void a(Context context) {
        SQLiteDatabase readableDatabase = W6.a(context).h().getReadableDatabase();
        if (readableDatabase != null) {
            try {
                C2825rb c2825rbA = a(readableDatabase);
                C2620il c2620il = new C2620il(new C2938w4(new C2890u4()));
                if (c2825rbA != null) {
                    a(this.a, c2620il, c2825rbA);
                    c2620il.p = c2825rbA.c;
                    c2620il.r = c2825rbA.b;
                }
                C2644jl c2644jl = new C2644jl(c2620il);
                Rl rlA = Ql.a(C2644jl.class);
                rlA.a(context, rlA.d(context)).save(c2644jl);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(sn snVar, C2620il c2620il, C2825rb c2825rb) {
        String strOptStringOrNull;
        synchronized (snVar) {
            strOptStringOrNull = JsonUtils.optStringOrNull(snVar.a.a(), "device_id");
        }
        if (TextUtils.isEmpty(strOptStringOrNull)) {
            if (!TextUtils.isEmpty(c2825rb.d)) {
                snVar.a(c2825rb.d);
            }
            if (!TextUtils.isEmpty(c2825rb.e)) {
                snVar.b(c2825rb.e);
            }
            if (TextUtils.isEmpty(c2825rb.a)) {
                return;
            }
            c2620il.a = c2825rb.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0047 A[Catch: all -> 0x004c, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x004c, blocks: (B:5:0x001b, B:7:0x0022, B:9:0x0028, B:13:0x0047), top: B:21:0x001b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final io.appmetrica.analytics.impl.C2825rb a(android.database.sqlite.SQLiteDatabase r11) {
        /*
            r10 = this;
            java.lang.String r0 = "value"
            r1 = 0
            java.lang.String r3 = "binary_data"
            java.lang.String[] r4 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L4b
            java.lang.String r5 = "data_key = ?"
            java.lang.String r2 = r10.b     // Catch: java.lang.Throwable -> L4b
            java.lang.String[] r6 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L4b
            r8 = 0
            r9 = 0
            r7 = 0
            r2 = r11
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L4b
            if (r11 == 0) goto L45
            int r2 = r11.getCount()     // Catch: java.lang.Throwable -> L4c
            r3 = 1
            if (r2 != r3) goto L45
            boolean r2 = r11.moveToFirst()     // Catch: java.lang.Throwable -> L4c
            if (r2 == 0) goto L45
            int r0 = r11.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L4c
            byte[] r0 = r11.getBlob(r0)     // Catch: java.lang.Throwable -> L4c
            io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter r2 = r10.c     // Catch: java.lang.Throwable -> L4c
            byte[] r0 = r2.decrypt(r0)     // Catch: java.lang.Throwable -> L4c
            io.appmetrica.analytics.impl.rb r2 = new io.appmetrica.analytics.impl.rb     // Catch: java.lang.Throwable -> L4c
            r2.<init>()     // Catch: java.lang.Throwable -> L4c
            io.appmetrica.analytics.protobuf.nano.MessageNano r0 = io.appmetrica.analytics.protobuf.nano.MessageNano.mergeFrom(r2, r0)     // Catch: java.lang.Throwable -> L4c
            io.appmetrica.analytics.impl.rb r0 = (io.appmetrica.analytics.impl.C2825rb) r0     // Catch: java.lang.Throwable -> L4c
            io.appmetrica.analytics.coreutils.internal.io.CloseableUtilsKt.closeSafely(r11)
            return r0
        L45:
            if (r11 == 0) goto L4c
            r11.getCount()     // Catch: java.lang.Throwable -> L4c
            goto L4c
        L4b:
            r11 = r1
        L4c:
            io.appmetrica.analytics.coreutils.internal.io.CloseableUtilsKt.closeSafely(r11)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.appmetrica.analytics.impl.C2953wj.a(android.database.sqlite.SQLiteDatabase):io.appmetrica.analytics.impl.rb");
    }
}
