package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Function;

/* renamed from: io.appmetrica.analytics.impl.ed, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2517ed implements Function {
    public final C2541fd a;
    public final C2492dd b;

    public C2517ed(C2541fd c2541fd, C2492dd c2492dd) {
        this.a = c2541fd;
        this.b = c2492dd;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0020 A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:3:0x0001, B:5:0x0007, B:8:0x0015, B:13:0x0020, B:17:0x0027, B:22:0x002e, B:10:0x001a), top: B:26:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    @Override // io.appmetrica.analytics.coreapi.internal.backport.Function
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String apply(java.io.File r5) {
        /*
            r4 = this;
            r0 = 0
            java.lang.String r5 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> L43
            if (r5 == 0) goto L1d
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L43
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L43
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L19
            r5.<init>(r1)     // Catch: java.lang.Throwable -> L19
            byte[] r1 = ir.nasim.AbstractC7873To0.c(r5)     // Catch: java.lang.Throwable -> L1a
            io.appmetrica.analytics.impl.hn.a(r5)     // Catch: java.lang.Throwable -> L43
            goto L1e
        L19:
            r5 = r0
        L1a:
            io.appmetrica.analytics.impl.hn.a(r5)     // Catch: java.lang.Throwable -> L43
        L1d:
            r1 = r0
        L1e:
            if (r1 == 0) goto L43
            int r5 = r1.length     // Catch: java.lang.Throwable -> L43
            r2 = 1
            if (r5 != 0) goto L26
            r5 = r2
            goto L27
        L26:
            r5 = 0
        L27:
            r5 = r5 ^ r2
            if (r5 == 0) goto L2b
            goto L2c
        L2b:
            r1 = r0
        L2c:
            if (r1 == 0) goto L43
            io.appmetrica.analytics.impl.dd r5 = r4.b     // Catch: java.lang.Throwable -> L43
            io.appmetrica.analytics.impl.gd r2 = new io.appmetrica.analytics.impl.gd     // Catch: java.lang.Throwable -> L43
            io.appmetrica.analytics.impl.fd r3 = r4.a     // Catch: java.lang.Throwable -> L43
            r2.<init>(r1, r3)     // Catch: java.lang.Throwable -> L43
            io.appmetrica.analytics.impl.W5 r5 = r5.fromModel(r2)     // Catch: java.lang.Throwable -> L43
            byte[] r5 = io.appmetrica.analytics.protobuf.nano.MessageNano.toByteArray(r5)     // Catch: java.lang.Throwable -> L43
            java.lang.String r0 = io.appmetrica.analytics.coreutils.internal.io.Base64Utils.compressBase64(r5)     // Catch: java.lang.Throwable -> L43
        L43:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.appmetrica.analytics.impl.C2517ed.apply(java.io.File):java.lang.String");
    }
}
