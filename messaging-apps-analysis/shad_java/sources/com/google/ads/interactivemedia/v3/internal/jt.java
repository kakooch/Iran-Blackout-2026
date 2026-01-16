package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class jt implements ko {
    public final int a;
    public final int[] b;
    public final long[] c;
    public final long[] d;
    public final long[] e;
    private final long f;

    public jt(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.b = iArr;
        this.c = jArr;
        this.d = jArr2;
        this.e = jArr3;
        int length = iArr.length;
        this.a = length;
        if (length <= 0) {
            this.f = 0L;
        } else {
            int i = length - 1;
            this.f = jArr2[i] + jArr3[i];
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ko
    public final boolean a() {
        return true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ko
    public final km b(long j) {
        int iD = d(j);
        kp kpVar = new kp(this.e[iD], this.c[iD]);
        if (kpVar.b >= j || iD == this.a - 1) {
            return new km(kpVar, kpVar);
        }
        int i = iD + 1;
        return new km(kpVar, new kp(this.e[i], this.c[i]));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ko
    public final long c() {
        return this.f;
    }

    public final int d(long j) {
        return aeu.an(this.e, j, true);
    }

    public final String toString() {
        int i = this.a;
        String string = Arrays.toString(this.b);
        String string2 = Arrays.toString(this.c);
        String string3 = Arrays.toString(this.e);
        String string4 = Arrays.toString(this.d);
        int length = String.valueOf(string).length();
        int length2 = String.valueOf(string2).length();
        StringBuilder sb = new StringBuilder(length + 71 + length2 + String.valueOf(string3).length() + String.valueOf(string4).length());
        sb.append("ChunkIndex(length=");
        sb.append(i);
        sb.append(", sizes=");
        sb.append(string);
        sb.append(", offsets=");
        sb.append(string2);
        sb.append(", timeUs=");
        sb.append(string3);
        sb.append(", durationsUs=");
        sb.append(string4);
        sb.append(")");
        return sb.toString();
    }
}
