package com.google.android.gms.internal.clearcut;

/* renamed from: com.google.android.gms.internal.clearcut.k, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2087k {
    private final zzbn a;
    private final byte[] b;

    private C2087k(int i) {
        byte[] bArr = new byte[i];
        this.b = bArr;
        this.a = zzbn.P(bArr);
    }

    public final AbstractC2081f a() {
        if (this.a.s() == 0) {
            return new C2089m(this.b);
        }
        throw new IllegalStateException("Did not write as much data as expected.");
    }

    public final zzbn b() {
        return this.a;
    }

    /* synthetic */ C2087k(int i, C2083g c2083g) {
        this(i);
    }
}
