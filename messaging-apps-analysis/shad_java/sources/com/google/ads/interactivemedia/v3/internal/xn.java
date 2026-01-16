package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class xn {
    public final rc[] a;
    public final long[] b;
    public final String c;
    public final String d;

    public xn(String str, String str2, long[] jArr, rc[] rcVarArr) {
        this.c = str;
        this.d = str2;
        this.b = jArr;
        this.a = rcVarArr;
    }

    public final String a() {
        String str = this.c;
        String str2 = this.d;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("/");
        sb.append(str2);
        return sb.toString();
    }
}
