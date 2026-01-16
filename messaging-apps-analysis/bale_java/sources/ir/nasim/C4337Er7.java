package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Er7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C4337Er7 {
    private final int a;
    private final int b;
    private final UA2 c;

    public C4337Er7(int i, int i2, UA2 ua2) {
        AbstractC13042fc3.i(ua2, "onItemClicked");
        this.a = i;
        this.b = i2;
        this.c = ua2;
    }

    public final int a() {
        return this.b;
    }

    public final UA2 b() {
        return this.c;
    }

    public final int c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4337Er7)) {
            return false;
        }
        C4337Er7 c4337Er7 = (C4337Er7) obj;
        return this.a == c4337Er7.a && this.b == c4337Er7.b && AbstractC13042fc3.d(this.c, c4337Er7.c);
    }

    public int hashCode() {
        return (((Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b)) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "ToolbarItem(titleRes=" + this.a + ", iconRes=" + this.b + ", onItemClicked=" + this.c + Separators.RPAREN;
    }
}
