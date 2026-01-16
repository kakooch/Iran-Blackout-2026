package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC14472hy4;
import ir.nasim.InterfaceC19114po0;

/* renamed from: ir.nasim.ct1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C11367ct1 {
    private final String a;
    private final String b;
    private final Integer c;
    private final boolean d;
    private final boolean e;
    private final boolean f;
    private final int g;
    private final InterfaceC19114po0 h;
    private final AbstractC14472hy4 i;
    private final AbstractC14472hy4 j;

    public C11367ct1(String str, String str2, Integer num, boolean z, boolean z2, boolean z3, int i, InterfaceC19114po0 interfaceC19114po0, AbstractC14472hy4 abstractC14472hy4, AbstractC14472hy4 abstractC14472hy42) {
        AbstractC13042fc3.i(str, "descriptionText");
        AbstractC13042fc3.i(str2, "confirmationMessage");
        AbstractC13042fc3.i(interfaceC19114po0, "buttonStates");
        AbstractC13042fc3.i(abstractC14472hy4, "passwordState");
        AbstractC13042fc3.i(abstractC14472hy42, "secondPasswordState");
        this.a = str;
        this.b = str2;
        this.c = num;
        this.d = z;
        this.e = z2;
        this.f = z3;
        this.g = i;
        this.h = interfaceC19114po0;
        this.i = abstractC14472hy4;
        this.j = abstractC14472hy42;
    }

    public final InterfaceC19114po0 a() {
        return this.h;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.a;
    }

    public final int d() {
        return this.g;
    }

    public final boolean e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C11367ct1)) {
            return false;
        }
        C11367ct1 c11367ct1 = (C11367ct1) obj;
        return AbstractC13042fc3.d(this.a, c11367ct1.a) && AbstractC13042fc3.d(this.b, c11367ct1.b) && AbstractC13042fc3.d(this.c, c11367ct1.c) && this.d == c11367ct1.d && this.e == c11367ct1.e && this.f == c11367ct1.f && this.g == c11367ct1.g && AbstractC13042fc3.d(this.h, c11367ct1.h) && AbstractC13042fc3.d(this.i, c11367ct1.i) && AbstractC13042fc3.d(this.j, c11367ct1.j);
    }

    public final boolean f() {
        return this.d;
    }

    public final AbstractC14472hy4 g() {
        return this.i;
    }

    public final boolean h() {
        return this.f;
    }

    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        Integer num = this.c;
        return ((((((((((((((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + Boolean.hashCode(this.d)) * 31) + Boolean.hashCode(this.e)) * 31) + Boolean.hashCode(this.f)) * 31) + Integer.hashCode(this.g)) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode();
    }

    public final AbstractC14472hy4 i() {
        return this.j;
    }

    public final Integer j() {
        return this.c;
    }

    public String toString() {
        return "CreatePasswordUiState(descriptionText=" + this.a + ", confirmationMessage=" + this.b + ", snackBarMessage=" + this.c + ", onPasswordChanged=" + this.d + ", mustAuthorizeUser=" + this.e + ", passwordsCanBeChanged=" + this.f + ", maxPasswordLength=" + this.g + ", buttonStates=" + this.h + ", passwordState=" + this.i + ", secondPasswordState=" + this.j + Separators.RPAREN;
    }

    public /* synthetic */ C11367ct1(String str, String str2, Integer num, boolean z, boolean z2, boolean z3, int i, InterfaceC19114po0 interfaceC19114po0, AbstractC14472hy4 abstractC14472hy4, AbstractC14472hy4 abstractC14472hy42, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) == 0 ? str2 : "", (i2 & 4) != 0 ? null : num, (i2 & 8) != 0 ? false : z, (i2 & 16) == 0 ? z2 : false, (i2 & 32) != 0 ? true : z3, (i2 & 64) != 0 ? Integer.MAX_VALUE : i, (i2 & 128) != 0 ? InterfaceC19114po0.a.C1453a.a : interfaceC19114po0, (i2 & 256) != 0 ? new AbstractC14472hy4.c(null, null, null, 7, null) : abstractC14472hy4, (i2 & 512) != 0 ? new AbstractC14472hy4.d(null, null, null, 7, null) : abstractC14472hy42);
    }
}
