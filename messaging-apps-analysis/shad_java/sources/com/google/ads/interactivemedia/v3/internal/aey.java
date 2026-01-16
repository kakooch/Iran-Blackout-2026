package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aey {
    public final String a;

    private aey(String str) {
        this.a = str;
    }

    public static aey a(aee aeeVar) {
        String str;
        aeeVar.k(2);
        int iN = aeeVar.n();
        int i = iN >> 1;
        int iN2 = (aeeVar.n() >> 3) | ((iN & 1) << 5);
        if (i == 4 || i == 5 || i == 7) {
            str = "dvhe";
        } else if (i == 8) {
            str = "hev1";
        } else {
            if (i != 9) {
                return null;
            }
            str = "avc3";
        }
        StringBuilder sb = new StringBuilder(str.length() + 26);
        sb.append(str);
        sb.append(".0");
        sb.append(i);
        sb.append(".0");
        sb.append(iN2);
        return new aey(sb.toString());
    }
}
