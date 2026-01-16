package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class gt {
    private final int[] a;
    private final int b;

    static {
        new gt(new int[]{2});
        new gt(new int[]{2, 5, 6});
    }

    public gt(int[] iArr) {
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        this.a = iArrCopyOf;
        Arrays.sort(iArrCopyOf);
        this.b = 8;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof gt) && Arrays.equals(this.a, ((gt) obj).a);
    }

    public final int hashCode() {
        return (Arrays.hashCode(this.a) * 31) + 8;
    }

    public final String toString() {
        String string = Arrays.toString(this.a);
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 67);
        sb.append("AudioCapabilities[maxChannelCount=");
        sb.append(8);
        sb.append(", supportedEncodings=");
        sb.append(string);
        sb.append("]");
        return sb.toString();
    }
}
