package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.tK4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C21228tK4 {
    private final int a;
    private final String b;
    private final String c;
    private final boolean d;
    private final String e;

    public C21228tK4(int i, String str, String str2, boolean z, String str3) {
        AbstractC13042fc3.i(str, "description");
        AbstractC13042fc3.i(str2, "title");
        AbstractC13042fc3.i(str3, "buttonText");
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = z;
        this.e = str3;
    }

    public final String a() {
        return this.e;
    }

    public final String b() {
        return this.b;
    }

    public final int c() {
        return this.a;
    }

    public final String d() {
        return this.c;
    }

    public final boolean e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C21228tK4)) {
            return false;
        }
        C21228tK4 c21228tK4 = (C21228tK4) obj;
        return this.a == c21228tK4.a && AbstractC13042fc3.d(this.b, c21228tK4.b) && AbstractC13042fc3.d(this.c, c21228tK4.c) && this.d == c21228tK4.d && AbstractC13042fc3.d(this.e, c21228tK4.e);
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + Boolean.hashCode(this.d)) * 31) + this.e.hashCode();
    }

    public String toString() {
        return "OnboardingEmptyStatePeer(peerId=" + this.a + ", description=" + this.b + ", title=" + this.c + ", isBlueTick=" + this.d + ", buttonText=" + this.e + Separators.RPAREN;
    }
}
