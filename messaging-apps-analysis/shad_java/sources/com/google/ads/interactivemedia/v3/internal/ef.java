package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ef {
    public static final ef a = new ef(0);
    public final int b;

    public ef(int i) {
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && ef.class == obj.getClass() && this.b == ((ef) obj).b;
    }

    public final int hashCode() {
        return this.b;
    }
}
