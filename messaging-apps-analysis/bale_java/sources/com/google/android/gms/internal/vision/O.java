package com.google.android.gms.internal.vision;

import java.util.Arrays;

/* loaded from: classes3.dex */
final class O implements P {
    private O() {
    }

    @Override // com.google.android.gms.internal.vision.P
    public final byte[] a(byte[] bArr, int i, int i2) {
        return Arrays.copyOfRange(bArr, i, i2 + i);
    }

    /* synthetic */ O(J j) {
        this();
    }
}
