package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class kq {
    public final int a;
    public final byte[] b;
    public final int c;
    public final int d;

    public kq(int i, byte[] bArr, int i2, int i3) {
        this.a = i;
        this.b = bArr;
        this.c = i2;
        this.d = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && kq.class == obj.getClass()) {
            kq kqVar = (kq) obj;
            if (this.a == kqVar.a && this.c == kqVar.c && this.d == kqVar.d && Arrays.equals(this.b, kqVar.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.a * 31) + Arrays.hashCode(this.b)) * 31) + this.c) * 31) + this.d;
    }
}
