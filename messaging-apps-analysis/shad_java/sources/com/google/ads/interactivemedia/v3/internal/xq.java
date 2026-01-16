package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import io.github.inflationx.calligraphy3.BuildConfig;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class xq {
    public final long a;
    public final long b;
    private final String c;
    private int d;

    public xq(String str, long j, long j2) {
        this.c = str == null ? BuildConfig.FLAVOR : str;
        this.a = j;
        this.b = j2;
    }

    public final Uri a(String str) {
        return atv.i(str, this.c);
    }

    public final String b(String str) {
        return atv.j(str, this.c);
    }

    public final xq c(xq xqVar, String str) {
        String strB = b(str);
        if (xqVar != null && strB.equals(xqVar.b(str))) {
            long j = this.b;
            if (j != -1) {
                long j2 = this.a;
                if (j2 + j == xqVar.a) {
                    long j3 = xqVar.b;
                    return new xq(strB, j2, j3 != -1 ? j + j3 : -1L);
                }
            }
            long j4 = xqVar.b;
            if (j4 != -1) {
                long j5 = xqVar.a;
                if (j5 + j4 == this.a) {
                    return new xq(strB, j5, j != -1 ? j4 + j : -1L);
                }
            }
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && xq.class == obj.getClass()) {
            xq xqVar = (xq) obj;
            if (this.a == xqVar.a && this.b == xqVar.b && this.c.equals(xqVar.c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.d;
        if (i != 0) {
            return i;
        }
        int iHashCode = ((((((int) this.a) + 527) * 31) + ((int) this.b)) * 31) + this.c.hashCode();
        this.d = iHashCode;
        return iHashCode;
    }

    public final String toString() {
        String str = this.c;
        long j = this.a;
        long j2 = this.b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 81);
        sb.append("RangedUri(referenceUri=");
        sb.append(str);
        sb.append(", start=");
        sb.append(j);
        sb.append(", length=");
        sb.append(j2);
        sb.append(")");
        return sb.toString();
    }
}
