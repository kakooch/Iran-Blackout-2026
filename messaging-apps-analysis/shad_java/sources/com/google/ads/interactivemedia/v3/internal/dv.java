package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class dv {
    public static final dv a = new dv(1.0f, 1.0f);
    public final float b;
    public final float c;
    private final int d;

    public dv(float f, float f2) {
        ary.o(f > 0.0f);
        ary.o(f2 > 0.0f);
        this.b = f;
        this.c = f2;
        this.d = Math.round(f * 1000.0f);
    }

    public final long a(long j) {
        return j * this.d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && dv.class == obj.getClass()) {
            dv dvVar = (dv) obj;
            if (this.b == dvVar.b && this.c == dvVar.c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Float.floatToRawIntBits(this.b) + 527) * 31) + Float.floatToRawIntBits(this.c);
    }

    public final String toString() {
        return aeu.E("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.b), Float.valueOf(this.c));
    }
}
