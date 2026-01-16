package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class de {
    public static final de a = new de(-9223372036854775807L, -3.4028235E38f, -3.4028235E38f);
    public final long b;
    public final float c;
    public final float d;

    public de(long j, float f, float f2) {
        this.b = j;
        this.c = f;
        this.d = f2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof de)) {
            return false;
        }
        de deVar = (de) obj;
        return this.b == deVar.b && this.c == deVar.c && this.d == deVar.d;
    }

    public final int hashCode() {
        long j = this.b;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        float f = this.c;
        int iFloatToIntBits = (i + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31;
        float f2 = this.d;
        return iFloatToIntBits + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0);
    }
}
