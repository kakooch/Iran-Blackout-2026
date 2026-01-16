package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes6.dex */
public final class PV {
    private final int a;
    private final int b;
    private final int c;
    private final float d;
    private final int e;
    private final long f;
    private final int g;
    private final int h;
    private final int i;
    private final int j;

    public PV(int i, int i2, int i3, float f, int i4, long j, int i5, int i6, int i7, int i8) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = f;
        this.e = i4;
        this.f = j;
        this.g = i5;
        this.h = i6;
        this.i = i7;
        this.j = i8;
    }

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.c;
    }

    public final float c() {
        return this.d;
    }

    public final int d() {
        return this.i;
    }

    public final int e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PV)) {
            return false;
        }
        PV pv = (PV) obj;
        return this.a == pv.a && this.b == pv.b && this.c == pv.c && Float.compare(this.d, pv.d) == 0 && this.e == pv.e && this.f == pv.f && this.g == pv.g && this.h == pv.h && this.i == pv.i && this.j == pv.j;
    }

    public final int f() {
        return this.b;
    }

    public final long g() {
        return this.f;
    }

    public final int h() {
        return this.j;
    }

    public int hashCode() {
        return (((((((((((((((((Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + Float.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31) + Integer.hashCode(this.g)) * 31) + Integer.hashCode(this.h)) * 31) + Integer.hashCode(this.i)) * 31) + Integer.hashCode(this.j);
    }

    public final int i() {
        return this.e;
    }

    public final int j() {
        return this.h;
    }

    public String toString() {
        return "BBR2OptimizerConfiguration(chunkSizeInByte=" + this.a + ", sampleWindowSize=" + this.b + ", cruisingGainInByte=" + this.c + ", drainPacingFactor=" + this.d + ", startupPacingFactor=" + this.e + ", startupBoostRttInMillis=" + this.f + ", maxAcceptableRttInMillis=" + this.g + ", startupResetTimeoutInSecond=" + this.h + ", initialTransferCapacityInByte=" + this.i + ", startupBoostTransferThresholdInByte=" + this.j + Separators.RPAREN;
    }
}
