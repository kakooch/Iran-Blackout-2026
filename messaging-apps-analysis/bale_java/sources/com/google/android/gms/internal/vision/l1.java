package com.google.android.gms.internal.vision;

/* loaded from: classes3.dex */
abstract class l1 {
    l1() {
    }

    abstract int a(int i, byte[] bArr, int i2, int i3);

    abstract int b(CharSequence charSequence, byte[] bArr, int i, int i2);

    final boolean c(byte[] bArr, int i, int i2) {
        return a(0, bArr, i, i2) == 0;
    }

    abstract String d(byte[] bArr, int i, int i2);
}
