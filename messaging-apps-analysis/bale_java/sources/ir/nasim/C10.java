package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes4.dex */
public final class C10 {
    public static final int e = 0;
    private final boolean a;
    private final UA2 b;
    private final boolean c;
    private final boolean d;

    public C10(boolean z, UA2 ua2, boolean z2, boolean z3) {
        AbstractC13042fc3.i(ua2, "onCheckedChange");
        this.a = z;
        this.b = ua2;
        this.c = z2;
        this.d = z3;
    }

    public final boolean a() {
        return this.a;
    }

    public final boolean b() {
        return this.c;
    }

    public final boolean c() {
        return this.d;
    }

    public final UA2 d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C10)) {
            return false;
        }
        C10 c10 = (C10) obj;
        return this.a == c10.a && AbstractC13042fc3.d(this.b, c10.b) && this.c == c10.c && this.d == c10.d;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d);
    }

    public String toString() {
        return "BaleSwitchState(checked=" + this.a + ", onCheckedChange=" + this.b + ", enabled=" + this.c + ", loading=" + this.d + Separators.RPAREN;
    }

    public /* synthetic */ C10(boolean z, UA2 ua2, boolean z2, boolean z3, int i, ED1 ed1) {
        this(z, ua2, (i & 4) != 0 ? true : z2, (i & 8) != 0 ? false : z3);
    }
}
