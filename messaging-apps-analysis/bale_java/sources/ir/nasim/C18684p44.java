package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.p44, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C18684p44 {
    private int a;
    private String b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C18684p44(int i, String str, int i2, int i3, int i4) {
        this(i, str, i2, i3, i4, 0, 32, null);
        AbstractC13042fc3.i(str, "title");
    }

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.f;
    }

    public final int c() {
        return this.e;
    }

    public final int d() {
        return this.a;
    }

    public final int e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C18684p44)) {
            return false;
        }
        C18684p44 c18684p44 = (C18684p44) obj;
        return this.a == c18684p44.a && AbstractC13042fc3.d(this.b, c18684p44.b) && this.c == c18684p44.c && this.d == c18684p44.d && this.e == c18684p44.e && this.f == c18684p44.f;
    }

    public final String f() {
        return this.b;
    }

    public final int g() {
        return this.d;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Integer.hashCode(this.f);
    }

    public String toString() {
        return "MenuItem(id=" + this.a + ", title=" + this.b + ", startIconRes=" + this.c + ", titleColor=" + this.d + ", iconColor=" + this.e + ", endIconRes=" + this.f + Separators.RPAREN;
    }

    public C18684p44(int i, String str, int i2, int i3, int i4, int i5) {
        AbstractC13042fc3.i(str, "title");
        this.a = i;
        this.b = str;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
    }

    public /* synthetic */ C18684p44(int i, String str, int i2, int i3, int i4, int i5, int i6, ED1 ed1) {
        this(i, str, (i6 & 4) != 0 ? 0 : i2, (i6 & 8) != 0 ? C5495Jo7.a.g0() : i3, (i6 & 16) != 0 ? C5495Jo7.a.o0() : i4, (i6 & 32) != 0 ? 0 : i5);
    }
}
