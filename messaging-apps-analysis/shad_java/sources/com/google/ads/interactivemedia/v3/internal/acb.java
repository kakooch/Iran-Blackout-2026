package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class acb {
    public final Uri a;
    public final int b;
    public final byte[] c;
    public final Map<String, String> d;
    public final long e;
    public final long f;
    public final String g;
    public final int h;

    private acb(Uri uri, int i, byte[] bArr, Map<String, String> map, long j, long j2, String str, int i2) {
        boolean z = j >= 0;
        ary.o(z);
        ary.o(z);
        ary.o(j2 > 0 || j2 == -1);
        this.a = uri;
        this.b = i;
        this.c = null;
        this.d = Collections.unmodifiableMap(new HashMap(map));
        this.e = j;
        this.f = j2;
        this.g = str;
        this.h = i2;
    }

    /* synthetic */ acb(Uri uri, int i, byte[] bArr, Map map, long j, long j2, String str, int i2, byte[] bArr2) {
        this(uri, 1, null, map, j, j2, str, i2);
    }

    public static String a(int i) {
        if (i == 1) {
            return "GET";
        }
        throw new IllegalStateException();
    }

    public final boolean b(int i) {
        return (this.h & i) == i;
    }

    public final acb c(long j) {
        long j2 = this.f;
        long j3 = j2 != -1 ? j2 - j : -1L;
        return (j == 0 && j2 == j3) ? this : new acb(this.a, this.b, null, this.d, this.e + j, j3, this.g, this.h);
    }

    public final String toString() {
        String strA = a(this.b);
        String strValueOf = String.valueOf(this.a);
        long j = this.e;
        long j2 = this.f;
        String str = this.g;
        int i = this.h;
        int length = String.valueOf(strA).length();
        StringBuilder sb = new StringBuilder(length + 70 + strValueOf.length() + String.valueOf(str).length());
        sb.append("DataSpec[");
        sb.append(strA);
        sb.append(" ");
        sb.append(strValueOf);
        sb.append(", ");
        sb.append(j);
        sb.append(", ");
        sb.append(j2);
        sb.append(", ");
        sb.append(str);
        sb.append(", ");
        sb.append(i);
        sb.append("]");
        return sb.toString();
    }

    public acb(Uri uri, long j, long j2) {
        this(uri, 1, null, Collections.emptyMap(), j, j2, null, 0);
    }
}
