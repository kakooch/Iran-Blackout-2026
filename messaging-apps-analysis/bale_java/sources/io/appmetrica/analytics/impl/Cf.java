package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.MessageNano;

/* loaded from: classes3.dex */
public final class Cf {
    public final String a;
    public final long b;
    public final long c;
    public final Bf d;

    public Cf(byte[] bArr) {
        Df dfA = Df.a(bArr);
        this.a = dfA.a;
        this.b = dfA.c;
        this.c = dfA.b;
        this.d = a(dfA.d);
    }

    public final byte[] a() {
        Df df = new Df();
        df.a = this.a;
        df.c = this.b;
        df.b = this.c;
        int iOrdinal = this.d.ordinal();
        int i = 1;
        if (iOrdinal != 1) {
            i = 2;
            if (iOrdinal != 2) {
                i = 0;
            }
        }
        df.d = i;
        return MessageNano.toByteArray(df);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Cf.class != obj.getClass()) {
            return false;
        }
        Cf cf = (Cf) obj;
        return this.b == cf.b && this.c == cf.c && this.a.equals(cf.a) && this.d == cf.d;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        long j = this.b;
        int i = (iHashCode + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.c;
        return this.d.hashCode() + ((i + ((int) (j2 ^ (j2 >>> 32)))) * 31);
    }

    public final String toString() {
        return "ReferrerInfo{installReferrer='" + this.a + "', referrerClickTimestampSeconds=" + this.b + ", installBeginTimestampSeconds=" + this.c + ", source=" + this.d + '}';
    }

    public Cf(String str, long j, long j2, Bf bf) {
        this.a = str;
        this.b = j;
        this.c = j2;
        this.d = bf;
    }

    public static Bf a(int i) {
        if (i == 1) {
            return Bf.c;
        }
        if (i != 2) {
            return Bf.b;
        }
        return Bf.d;
    }
}
