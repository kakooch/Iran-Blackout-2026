package io.appmetrica.analytics.impl;

/* renamed from: io.appmetrica.analytics.impl.w4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2938w4 {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final Boolean f;

    public C2938w4(C2890u4 c2890u4) {
        this.a = c2890u4.a;
        this.b = c2890u4.b;
        this.c = c2890u4.c;
        this.d = c2890u4.d;
        this.e = c2890u4.e;
        this.f = c2890u4.f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2938w4.class != obj.getClass()) {
            return false;
        }
        C2938w4 c2938w4 = (C2938w4) obj;
        if (this.a != c2938w4.a || this.b != c2938w4.b || this.c != c2938w4.c || this.d != c2938w4.d || this.e != c2938w4.e) {
            return false;
        }
        Boolean bool = this.f;
        Boolean bool2 = c2938w4.f;
        return bool != null ? bool.equals(bool2) : bool2 == null;
    }

    public final int hashCode() {
        int i = (((((((((this.a ? 1 : 0) * 31) + (this.b ? 1 : 0)) * 31) + (this.c ? 1 : 0)) * 31) + (this.d ? 1 : 0)) * 31) + (this.e ? 1 : 0)) * 31;
        Boolean bool = this.f;
        return i + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        return "CollectingFlags{permissionsCollectingEnabled=" + this.a + ", featuresCollectingEnabled=" + this.b + ", googleAid=" + this.c + ", simInfo=" + this.d + ", huaweiOaid=" + this.e + ", sslPinning=" + this.f + '}';
    }
}
