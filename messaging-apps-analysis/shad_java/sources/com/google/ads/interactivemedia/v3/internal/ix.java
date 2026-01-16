package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ix {
    public final int a = 0;
    public final int b;
    public final int c;

    static {
        new ix(0, 0);
    }

    public ix(int i, int i2) {
        this.b = i;
        this.c = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ix)) {
            return false;
        }
        ix ixVar = (ix) obj;
        int i = ixVar.a;
        return this.b == ixVar.b && this.c == ixVar.c;
    }

    public final int hashCode() {
        return ((this.b + 16337) * 31) + this.c;
    }
}
