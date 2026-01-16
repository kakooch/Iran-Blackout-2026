package io.appmetrica.analytics.impl;

import android.util.Base64;
import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;

/* renamed from: io.appmetrica.analytics.impl.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2428b implements InterfaceC3014z8 {
    public final AESEncrypter a;

    public C2428b() {
        this(new C2403a(C2586ha.h().e()));
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    @Override // io.appmetrica.analytics.impl.InterfaceC3014z8
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final io.appmetrica.analytics.impl.C2870t8 a(io.appmetrica.analytics.impl.Q5 r3) {
        /*
            r2 = this;
            java.lang.String r0 = r3.getValue()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L1e
            java.lang.String r1 = "UTF-8"
            byte[] r0 = r0.getBytes(r1)     // Catch: java.lang.Throwable -> L1e
            io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter r1 = r2.a     // Catch: java.lang.Throwable -> L1e
            byte[] r0 = r1.encrypt(r0)     // Catch: java.lang.Throwable -> L1e
            if (r0 == 0) goto L1e
            r1 = 0
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r1)     // Catch: java.lang.Throwable -> L1e
            goto L1f
        L1e:
            r0 = 0
        L1f:
            r3.setValue(r0)
            io.appmetrica.analytics.impl.t8 r0 = new io.appmetrica.analytics.impl.t8
            io.appmetrica.analytics.impl.B8 r1 = io.appmetrica.analytics.impl.B8.AES_VALUE_ENCRYPTION
            r0.<init>(r3, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.appmetrica.analytics.impl.C2428b.a(io.appmetrica.analytics.impl.Q5):io.appmetrica.analytics.impl.t8");
    }

    public C2428b(C2403a c2403a) {
        this(new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, c2403a.b(), c2403a.a()));
    }

    public C2428b(AESEncrypter aESEncrypter) {
        this.a = aESEncrypter;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC3014z8
    public final byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (bArr == null || bArr.length <= 0) {
            return bArr2;
        }
        try {
            return this.a.decrypt(Base64.decode(bArr, 0));
        } catch (Throwable unused) {
            return bArr2;
        }
    }

    public final B8 a() {
        return B8.AES_VALUE_ENCRYPTION;
    }
}
