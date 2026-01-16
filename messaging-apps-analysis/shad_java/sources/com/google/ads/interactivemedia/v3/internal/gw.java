package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class gw extends Exception {
    public gw(gv gvVar) {
        String strValueOf = String.valueOf(gvVar);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 18);
        sb.append("Unhandled format: ");
        sb.append(strValueOf);
        super(sb.toString());
    }
}
