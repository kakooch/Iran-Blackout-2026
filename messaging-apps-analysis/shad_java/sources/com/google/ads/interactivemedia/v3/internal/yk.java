package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class yk extends wa {
    private byte[] a;

    public yk(abx abxVar, acb acbVar, cy cyVar, int i, Object obj, byte[] bArr) {
        super(abxVar, acbVar, cyVar, i, obj, bArr);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.wa
    protected final void d(byte[] bArr, int i) {
        this.a = Arrays.copyOf(bArr, i);
    }

    public final byte[] e() {
        return this.a;
    }
}
