package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes7.dex */
public final class ZJ1 {
    private final String a;
    private final String b;
    private final long c;
    private final boolean d;
    private final int e;
    private final int f;

    public ZJ1(String str, String str2, long j, boolean z, int i, int i2) {
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(str2, "type");
        this.a = str;
        this.b = str2;
        this.c = j;
        this.d = z;
        this.e = i;
        this.f = i2;
    }

    public final int a() {
        return this.f;
    }

    public final int b() {
        return this.e;
    }

    public final String c() {
        return this.a;
    }

    public final long d() {
        return this.c;
    }

    public final String e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZJ1)) {
            return false;
        }
        ZJ1 zj1 = (ZJ1) obj;
        return AbstractC13042fc3.d(this.a, zj1.a) && AbstractC13042fc3.d(this.b, zj1.b) && this.c == zj1.c && this.d == zj1.d && this.e == zj1.e && this.f == zj1.f;
    }

    public final boolean f() {
        return this.d;
    }

    public int hashCode() {
        return (((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + Long.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Integer.hashCode(this.f);
    }

    public String toString() {
        return "DeviceInfo(name=" + this.a + ", type=" + this.b + ", time=" + this.c + ", isThisDevice=" + this.d + ", id=" + this.e + ", appId=" + this.f + Separators.RPAREN;
    }
}
