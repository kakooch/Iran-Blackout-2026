package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC6747Ou5;
import ir.nasim.LP;

/* loaded from: classes4.dex */
public final class TB6 {
    private final boolean a;
    private final LP b;
    private final boolean c;
    private final long d;
    private final String e;
    private final AbstractC6747Ou5 f;

    public TB6(boolean z, LP lp, boolean z2, long j, String str, AbstractC6747Ou5 abstractC6747Ou5) {
        AbstractC13042fc3.i(lp, "error");
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(abstractC6747Ou5, "selectedAvatar");
        this.a = z;
        this.b = lp;
        this.c = z2;
        this.d = j;
        this.e = str;
        this.f = abstractC6747Ou5;
    }

    public static /* synthetic */ TB6 b(TB6 tb6, boolean z, LP lp, boolean z2, long j, String str, AbstractC6747Ou5 abstractC6747Ou5, int i, Object obj) {
        if ((i & 1) != 0) {
            z = tb6.a;
        }
        if ((i & 2) != 0) {
            lp = tb6.b;
        }
        LP lp2 = lp;
        if ((i & 4) != 0) {
            z2 = tb6.c;
        }
        boolean z3 = z2;
        if ((i & 8) != 0) {
            j = tb6.d;
        }
        long j2 = j;
        if ((i & 16) != 0) {
            str = tb6.e;
        }
        String str2 = str;
        if ((i & 32) != 0) {
            abstractC6747Ou5 = tb6.f;
        }
        return tb6.a(z, lp2, z3, j2, str2, abstractC6747Ou5);
    }

    public final TB6 a(boolean z, LP lp, boolean z2, long j, String str, AbstractC6747Ou5 abstractC6747Ou5) {
        AbstractC13042fc3.i(lp, "error");
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(abstractC6747Ou5, "selectedAvatar");
        return new TB6(z, lp, z2, j, str, abstractC6747Ou5);
    }

    public final long c() {
        return this.d;
    }

    public final LP d() {
        return this.b;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TB6)) {
            return false;
        }
        TB6 tb6 = (TB6) obj;
        return this.a == tb6.a && AbstractC13042fc3.d(this.b, tb6.b) && this.c == tb6.c && this.d == tb6.d && AbstractC13042fc3.d(this.e, tb6.e) && AbstractC13042fc3.d(this.f, tb6.f);
    }

    public final AbstractC6747Ou5 f() {
        return this.f;
    }

    public final boolean g() {
        return this.c;
    }

    public final boolean h() {
        return this.a;
    }

    public int hashCode() {
        return (((((((((Boolean.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + Boolean.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    }

    public String toString() {
        return "SignUpModel(isLoading=" + this.a + ", error=" + this.b + ", singUpCompleted=" + this.c + ", currentAuthId=" + this.d + ", name=" + this.e + ", selectedAvatar=" + this.f + Separators.RPAREN;
    }

    public /* synthetic */ TB6(boolean z, LP lp, boolean z2, long j, String str, AbstractC6747Ou5 abstractC6747Ou5, int i, ED1 ed1) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? LP.c.b : lp, (i & 4) == 0 ? z2 : false, (i & 8) != 0 ? 0L : j, (i & 16) != 0 ? "" : str, (i & 32) != 0 ? AbstractC6747Ou5.b.a : abstractC6747Ou5);
    }
}
