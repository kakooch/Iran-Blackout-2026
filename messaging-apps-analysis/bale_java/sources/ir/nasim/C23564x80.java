package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.x80, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C23564x80 {
    private final String a;
    private final long b;
    private final long c;
    private final long d;
    private final int e;
    public String f;
    public InterfaceC10156bA3 g;

    public C23564x80(String str, long j, long j2, long j3) {
        AbstractC13042fc3.i(str, "adLink");
        this.a = str;
        this.b = j;
        this.c = j2;
        this.d = j3;
        this.e = (str + j + j3).hashCode();
    }

    public final int a() {
        return this.e;
    }

    public final String b() {
        return this.a;
    }

    public final InterfaceC10156bA3 c() {
        InterfaceC10156bA3 interfaceC10156bA3 = this.g;
        if (interfaceC10156bA3 != null) {
            return interfaceC10156bA3;
        }
        AbstractC13042fc3.y("bannerAdLinkAction");
        return null;
    }

    public final long d() {
        return this.c;
    }

    public final long e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C23564x80)) {
            return false;
        }
        C23564x80 c23564x80 = (C23564x80) obj;
        return AbstractC13042fc3.d(this.a, c23564x80.a) && this.b == c23564x80.b && this.c == c23564x80.c && this.d == c23564x80.d;
    }

    public final String f() {
        String str = this.f;
        if (str != null) {
            return str;
        }
        AbstractC13042fc3.y("contentMediaLink");
        return null;
    }

    public final long g() {
        return this.d;
    }

    public final void h(InterfaceC10156bA3 interfaceC10156bA3) {
        AbstractC13042fc3.i(interfaceC10156bA3, "<set-?>");
        this.g = interfaceC10156bA3;
    }

    public int hashCode() {
        return (((((this.a.hashCode() * 31) + Long.hashCode(this.b)) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d);
    }

    public final void i(String str) {
        AbstractC13042fc3.i(str, "<set-?>");
        this.f = str;
    }

    public String toString() {
        return "BannerAd(adLink=" + this.a + ", contentMediaFileId=" + this.b + ", contentMediaAccessHash=" + this.c + ", expireTimeInMills=" + this.d + Separators.RPAREN;
    }
}
