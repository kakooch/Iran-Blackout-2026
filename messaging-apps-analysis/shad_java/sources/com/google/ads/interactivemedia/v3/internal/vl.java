package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.util.Arrays;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class vl {
    public final int a;
    public final Uri[] b;
    public final int[] c;
    public final long[] d;

    public vl() {
        ary.o(true);
        this.a = -1;
        this.c = new int[0];
        this.b = new Uri[0];
        this.d = new long[0];
    }

    public final int a() {
        return b(-1);
    }

    public final int b(int i) {
        int i2;
        int i3 = i + 1;
        while (true) {
            int[] iArr = this.c;
            if (i3 >= 0 || (i2 = iArr[i3]) == 0 || i2 == 1) {
                break;
            }
            i3++;
        }
        return i3;
    }

    public final boolean c() {
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && vl.class == obj.getClass()) {
            vl vlVar = (vl) obj;
            if (Arrays.equals(this.b, vlVar.b) && Arrays.equals(this.c, vlVar.c) && Arrays.equals(this.d, vlVar.d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((Arrays.hashCode(this.b) - 31) * 31) + Arrays.hashCode(this.c)) * 31) + Arrays.hashCode(this.d);
    }
}
