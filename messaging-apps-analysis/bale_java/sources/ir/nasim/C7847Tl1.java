package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Tl1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C7847Tl1 {
    public static final int e = 8;
    private String a;
    private final int b;
    private final int c;
    private final SA2 d;

    public C7847Tl1(String str, int i, int i2, SA2 sa2) {
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(sa2, "onClick");
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = sa2;
    }

    public static /* synthetic */ C7847Tl1 b(C7847Tl1 c7847Tl1, String str, int i, int i2, SA2 sa2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = c7847Tl1.a;
        }
        if ((i3 & 2) != 0) {
            i = c7847Tl1.b;
        }
        if ((i3 & 4) != 0) {
            i2 = c7847Tl1.c;
        }
        if ((i3 & 8) != 0) {
            sa2 = c7847Tl1.d;
        }
        return c7847Tl1.a(str, i, i2, sa2);
    }

    public final C7847Tl1 a(String str, int i, int i2, SA2 sa2) {
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(sa2, "onClick");
        return new C7847Tl1(str, i, i2, sa2);
    }

    public final int c() {
        return this.b;
    }

    public final int d() {
        return this.c;
    }

    public final String e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C7847Tl1)) {
            return false;
        }
        C7847Tl1 c7847Tl1 = (C7847Tl1) obj;
        return AbstractC13042fc3.d(this.a, c7847Tl1.a) && this.b == c7847Tl1.b && this.c == c7847Tl1.c && AbstractC13042fc3.d(this.d, c7847Tl1.d);
    }

    public final SA2 f() {
        return this.d;
    }

    public int hashCode() {
        return (((((this.a.hashCode() * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "ContextMenuItem(name=" + this.a + ", iconRes=" + this.b + ", id=" + this.c + ", onClick=" + this.d + Separators.RPAREN;
    }

    public /* synthetic */ C7847Tl1(String str, int i, int i2, SA2 sa2, int i3, ED1 ed1) {
        this(str, i, (i3 & 4) != 0 ? 0 : i2, sa2);
    }
}
