package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC24003xs5;
import ir.nasim.LP;

/* renamed from: ir.nasim.gC6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C13427gC6 {
    private final boolean a;
    private final LP b;
    private final boolean c;
    private final long d;
    private final AbstractC24003xs5 e;

    public C13427gC6(boolean z, LP lp, boolean z2, long j, AbstractC24003xs5 abstractC24003xs5) {
        AbstractC13042fc3.i(lp, "error");
        AbstractC13042fc3.i(abstractC24003xs5, "selectedAvatar");
        this.a = z;
        this.b = lp;
        this.c = z2;
        this.d = j;
        this.e = abstractC24003xs5;
    }

    public static /* synthetic */ C13427gC6 b(C13427gC6 c13427gC6, boolean z, LP lp, boolean z2, long j, AbstractC24003xs5 abstractC24003xs5, int i, Object obj) {
        if ((i & 1) != 0) {
            z = c13427gC6.a;
        }
        if ((i & 2) != 0) {
            lp = c13427gC6.b;
        }
        LP lp2 = lp;
        if ((i & 4) != 0) {
            z2 = c13427gC6.c;
        }
        boolean z3 = z2;
        if ((i & 8) != 0) {
            j = c13427gC6.d;
        }
        long j2 = j;
        if ((i & 16) != 0) {
            abstractC24003xs5 = c13427gC6.e;
        }
        return c13427gC6.a(z, lp2, z3, j2, abstractC24003xs5);
    }

    public final C13427gC6 a(boolean z, LP lp, boolean z2, long j, AbstractC24003xs5 abstractC24003xs5) {
        AbstractC13042fc3.i(lp, "error");
        AbstractC13042fc3.i(abstractC24003xs5, "selectedAvatar");
        return new C13427gC6(z, lp, z2, j, abstractC24003xs5);
    }

    public final long c() {
        return this.d;
    }

    public final LP d() {
        return this.b;
    }

    public final AbstractC24003xs5 e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C13427gC6)) {
            return false;
        }
        C13427gC6 c13427gC6 = (C13427gC6) obj;
        return this.a == c13427gC6.a && AbstractC13042fc3.d(this.b, c13427gC6.b) && this.c == c13427gC6.c && this.d == c13427gC6.d && AbstractC13042fc3.d(this.e, c13427gC6.e);
    }

    public final boolean f() {
        return this.c;
    }

    public final boolean g() {
        return this.a;
    }

    public int hashCode() {
        return (((((((Boolean.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + Boolean.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + this.e.hashCode();
    }

    public String toString() {
        return "SignUpState(isLoading=" + this.a + ", error=" + this.b + ", singUpCompleted=" + this.c + ", currentAuthId=" + this.d + ", selectedAvatar=" + this.e + Separators.RPAREN;
    }

    public /* synthetic */ C13427gC6(boolean z, LP lp, boolean z2, long j, AbstractC24003xs5 abstractC24003xs5, int i, ED1 ed1) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? LP.c.b : lp, (i & 4) == 0 ? z2 : false, (i & 8) != 0 ? 0L : j, (i & 16) != 0 ? AbstractC24003xs5.f.a : abstractC24003xs5);
    }
}
