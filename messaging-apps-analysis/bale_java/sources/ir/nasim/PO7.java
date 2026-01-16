package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC14472hy4;
import ir.nasim.InterfaceC19114po0;

/* loaded from: classes4.dex */
public final class PO7 {
    private final boolean a;
    private final boolean b;
    private final boolean c;
    private final int d;
    private final C23868xf0 e;
    private final InterfaceC19114po0 f;
    private final AbstractC14472hy4 g;
    private final Integer h;
    private final String i;

    public PO7(boolean z, boolean z2, boolean z3, int i, C23868xf0 c23868xf0, InterfaceC19114po0 interfaceC19114po0, AbstractC14472hy4 abstractC14472hy4, Integer num, String str) {
        AbstractC13042fc3.i(interfaceC19114po0, "confirmButtonState");
        AbstractC13042fc3.i(abstractC14472hy4, "passwordState");
        AbstractC13042fc3.i(str, "descriptionText");
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = i;
        this.e = c23868xf0;
        this.f = interfaceC19114po0;
        this.g = abstractC14472hy4;
        this.h = num;
        this.i = str;
    }

    public final C23868xf0 a() {
        return this.e;
    }

    public final InterfaceC19114po0 b() {
        return this.f;
    }

    public final String c() {
        return this.i;
    }

    public final int d() {
        return this.d;
    }

    public final boolean e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PO7)) {
            return false;
        }
        PO7 po7 = (PO7) obj;
        return this.a == po7.a && this.b == po7.b && this.c == po7.c && this.d == po7.d && AbstractC13042fc3.d(this.e, po7.e) && AbstractC13042fc3.d(this.f, po7.f) && AbstractC13042fc3.d(this.g, po7.g) && AbstractC13042fc3.d(this.h, po7.h) && AbstractC13042fc3.d(this.i, po7.i);
    }

    public final AbstractC14472hy4 f() {
        return this.g;
    }

    public final Integer g() {
        return this.h;
    }

    public final boolean h() {
        return this.b;
    }

    public int hashCode() {
        int iHashCode = ((((((Boolean.hashCode(this.a) * 31) + Boolean.hashCode(this.b)) * 31) + Boolean.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31;
        C23868xf0 c23868xf0 = this.e;
        int iHashCode2 = (((((iHashCode + (c23868xf0 == null ? 0 : c23868xf0.hashCode())) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        Integer num = this.h;
        return ((iHashCode2 + (num != null ? num.hashCode() : 0)) * 31) + this.i.hashCode();
    }

    public String toString() {
        return "ValidatePasswordUiState(passwordCanBeChanged=" + this.a + ", validationCompleted=" + this.b + ", localPasswordIsNotValid=" + this.c + ", maxPasswordLength=" + this.d + ", biometricButtonState=" + this.e + ", confirmButtonState=" + this.f + ", passwordState=" + this.g + ", snackbarMessage=" + this.h + ", descriptionText=" + this.i + Separators.RPAREN;
    }

    public /* synthetic */ PO7(boolean z, boolean z2, boolean z3, int i, C23868xf0 c23868xf0, InterfaceC19114po0 interfaceC19114po0, AbstractC14472hy4 abstractC14472hy4, Integer num, String str, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? true : z, (i2 & 2) != 0 ? false : z2, (i2 & 4) == 0 ? z3 : false, (i2 & 8) != 0 ? Integer.MAX_VALUE : i, (i2 & 16) != 0 ? null : c23868xf0, (i2 & 32) != 0 ? InterfaceC19114po0.a.C1453a.a : interfaceC19114po0, (i2 & 64) != 0 ? new AbstractC14472hy4.c(null, null, null, 7, null) : abstractC14472hy4, (i2 & 128) == 0 ? num : null, (i2 & 256) != 0 ? "" : str);
    }
}
