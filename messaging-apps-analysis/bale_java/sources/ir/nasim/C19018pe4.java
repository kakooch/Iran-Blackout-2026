package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.pe4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19018pe4 {
    private final int a;
    private final int b;
    private final long c;
    private final String d;
    private final String e;

    public C19018pe4(int i, int i2, long j, String str, String str2) {
        AbstractC13042fc3.i(str, "osType");
        AbstractC13042fc3.i(str2, "osVersion");
        this.a = i;
        this.b = i2;
        this.c = j;
        this.d = str;
        this.e = str2;
    }

    public final int a() {
        return this.b;
    }

    public final String b() {
        return this.d;
    }

    public final String c() {
        return this.e;
    }

    public final int d() {
        return this.a;
    }

    public final long e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C19018pe4)) {
            return false;
        }
        C19018pe4 c19018pe4 = (C19018pe4) obj;
        return this.a == c19018pe4.a && this.b == c19018pe4.b && this.c == c19018pe4.c && AbstractC13042fc3.d(this.d, c19018pe4.d) && AbstractC13042fc3.d(this.e, c19018pe4.e);
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b)) * 31) + Long.hashCode(this.c)) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }

    public String toString() {
        return "MetaData(sdkVersion=" + this.a + ", appVersion=" + this.b + ", sessionId=" + this.c + ", osType=" + this.d + ", osVersion=" + this.e + Separators.RPAREN;
    }
}
