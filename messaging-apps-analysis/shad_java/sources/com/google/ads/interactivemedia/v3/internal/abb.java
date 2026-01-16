package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class abb {
    public final int a;
    private final aba[] b;
    private int c;

    public abb(aba... abaVarArr) {
        this.b = abaVarArr;
        this.a = abaVarArr.length;
    }

    public final aba a(int i) {
        return this.b[i];
    }

    public final aba[] b() {
        return (aba[]) this.b.clone();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || abb.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.b, ((abb) obj).b);
    }

    public final int hashCode() {
        int i = this.c;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.b) + 527;
        this.c = iHashCode;
        return iHashCode;
    }
}
