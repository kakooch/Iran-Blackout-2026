package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;

/* renamed from: io.appmetrica.analytics.impl.q3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2794q3 extends U2 {
    public C2794q3(int i, String str, PublicLogger publicLogger) {
        super(i, str, publicLogger);
    }

    public final int b() {
        return this.a;
    }

    @Override // io.appmetrica.analytics.impl.Hm
    public final byte[] a(byte[] bArr) {
        if (bArr == null) {
            return bArr;
        }
        int length = bArr.length;
        int i = this.a;
        if (length <= i) {
            return bArr;
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        this.c.warning("\"%s\" %s exceeded limit of %d bytes", this.b, bArr, Integer.valueOf(this.a));
        return bArr2;
    }

    public final String a() {
        return this.b;
    }
}
