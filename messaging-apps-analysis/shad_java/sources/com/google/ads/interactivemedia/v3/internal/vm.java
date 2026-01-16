package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class vm {
    public static final vm a = new vm(new long[0]);
    public final int b;
    public final long[] c;
    public final vl[] d;
    public final long e;

    public vm(long... jArr) {
        int length = jArr.length;
        this.b = length;
        this.c = Arrays.copyOf(jArr, length);
        this.d = new vl[length];
        for (int i = 0; i < length; i++) {
            this.d[i] = new vl();
        }
        this.e = 0L;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && vm.class == obj.getClass()) {
            vm vmVar = (vm) obj;
            if (this.b == vmVar.b && Arrays.equals(this.c, vmVar.c) && Arrays.equals(this.d, vmVar.d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.b * 961) + ((int) (-9223372036854775807L))) * 31) + Arrays.hashCode(this.c)) * 31) + Arrays.hashCode(this.d);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AdPlaybackState(adResumePositionUs=");
        sb.append(0L);
        sb.append(", adGroups=[");
        for (int i = 0; i < this.d.length; i++) {
            sb.append("adGroup(timeUs=");
            sb.append(this.c[i]);
            sb.append(", ads=[");
            int[] iArr = this.d[i].c;
            sb.append("])");
            if (i < this.d.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("])");
        return sb.toString();
    }
}
