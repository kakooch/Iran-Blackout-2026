package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Li0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5902Li0 {
    private final String a;
    private final boolean b;
    private final boolean c;
    private final C6374Ni0 d;

    public C5902Li0() {
        this(null, false, false, null, 15, null);
    }

    public final String a() {
        return this.a;
    }

    public final C6374Ni0 b() {
        return this.d;
    }

    public final boolean c() {
        return this.b;
    }

    public final boolean d() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5902Li0)) {
            return false;
        }
        C5902Li0 c5902Li0 = (C5902Li0) obj;
        return AbstractC13042fc3.d(this.a, c5902Li0.a) && this.b == c5902Li0.b && this.c == c5902Li0.c && AbstractC13042fc3.d(this.d, c5902Li0.d);
    }

    public int hashCode() {
        String str = this.a;
        int iHashCode = (((((str == null ? 0 : str.hashCode()) * 31) + Boolean.hashCode(this.b)) * 31) + Boolean.hashCode(this.c)) * 31;
        C6374Ni0 c6374Ni0 = this.d;
        return iHashCode + (c6374Ni0 != null ? c6374Ni0.hashCode() : 0);
    }

    public String toString() {
        return "BotExInfo(activeUsers=" + this.a + ", hasMainWebApp=" + this.b + ", hasTimcheProfile=" + this.c + ", botIntro=" + this.d + Separators.RPAREN;
    }

    public C5902Li0(String str, boolean z, boolean z2, C6374Ni0 c6374Ni0) {
        this.a = str;
        this.b = z;
        this.c = z2;
        this.d = c6374Ni0;
    }

    public /* synthetic */ C5902Li0(String str, boolean z, boolean z2, C6374Ni0 c6374Ni0, int i, ED1 ed1) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? null : c6374Ni0);
    }
}
