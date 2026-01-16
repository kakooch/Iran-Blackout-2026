package com.google.ads.interactivemedia.v3.internal;

import android.util.Log;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class vq {
    private final int[] a;
    private final va[] b;

    public vq(int[] iArr, va[] vaVarArr) {
        this.a = iArr;
        this.b = vaVarArr;
    }

    public final int[] a() {
        int[] iArr = new int[this.b.length];
        int i = 0;
        while (true) {
            va[] vaVarArr = this.b;
            if (i >= vaVarArr.length) {
                return iArr;
            }
            iArr[i] = vaVarArr[i].m();
            i++;
        }
    }

    public final void b(long j) {
        for (va vaVar : this.b) {
            vaVar.H(j);
        }
    }

    public final kr c(int i) {
        int i2 = 0;
        while (true) {
            int[] iArr = this.a;
            if (i2 >= iArr.length) {
                StringBuilder sb = new StringBuilder(36);
                sb.append("Unmatched track of type: ");
                sb.append(i);
                Log.e("BaseMediaChunkOutput", sb.toString());
                return new jx();
            }
            if (i == iArr[i2]) {
                return this.b[i2];
            }
            i2++;
        }
    }
}
