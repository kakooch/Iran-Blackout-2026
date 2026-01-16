package com.google.android.gms.internal.vision;

/* loaded from: classes3.dex */
final class S {
    private final zzii a;
    private final byte[] b;

    private S(int i) {
        byte[] bArr = new byte[i];
        this.b = bArr;
        this.a = zzii.d(bArr);
    }

    public final K a() {
        this.a.J();
        return new U(this.b);
    }

    public final zzii b() {
        return this.a;
    }

    /* synthetic */ S(int i, J j) {
        this(i);
    }
}
