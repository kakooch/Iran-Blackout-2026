package com.google.android.gms.common;

import java.util.Arrays;

/* loaded from: classes3.dex */
final class o extends n {
    private final byte[] h;

    o(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.h = bArr;
    }

    @Override // com.google.android.gms.common.n
    final byte[] E2() {
        return this.h;
    }
}
