package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC17757nW1;

/* renamed from: ir.nasim.bJ6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C10240bJ6 {
    private final AbstractC17757nW1.c a;
    private final String b;
    private final int c;
    private final String d;
    private final int e;
    private final int f;
    private final String g;
    private final String h;

    public C10240bJ6(AbstractC17757nW1.c cVar, String str, int i, String str2, int i2, int i3, String str3, String str4) {
        AbstractC13042fc3.i(str, "id");
        AbstractC13042fc3.i(str2, "description");
        this.a = cVar;
        this.b = str;
        this.c = i;
        this.d = str2;
        this.e = i2;
        this.f = i3;
        this.g = str3;
        this.h = str4;
    }

    public final String a() {
        return this.d;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.g;
    }

    public final String d() {
        return this.h;
    }

    public final int e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C10240bJ6)) {
            return false;
        }
        C10240bJ6 c10240bJ6 = (C10240bJ6) obj;
        return AbstractC13042fc3.d(this.a, c10240bJ6.a) && AbstractC13042fc3.d(this.b, c10240bJ6.b) && this.c == c10240bJ6.c && AbstractC13042fc3.d(this.d, c10240bJ6.d) && this.e == c10240bJ6.e && this.f == c10240bJ6.f && AbstractC13042fc3.d(this.g, c10240bJ6.g) && AbstractC13042fc3.d(this.h, c10240bJ6.h);
    }

    public final AbstractC17757nW1.c f() {
        return this.a;
    }

    public final int g() {
        return this.e;
    }

    public final int h() {
        return this.f;
    }

    public int hashCode() {
        AbstractC17757nW1.c cVar = this.a;
        int iHashCode = (((((((((((cVar == null ? 0 : cVar.hashCode()) * 31) + this.b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31) + this.d.hashCode()) * 31) + Integer.hashCode(this.e)) * 31) + Integer.hashCode(this.f)) * 31;
        String str = this.g;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.h;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "Sponsored(picture=" + this.a + ", id=" + this.b + ", peerId=" + this.c + ", description=" + this.d + ", tag1=" + this.e + ", tag2=" + this.f + ", link=" + this.g + ", linkTitle=" + this.h + Separators.RPAREN;
    }
}
