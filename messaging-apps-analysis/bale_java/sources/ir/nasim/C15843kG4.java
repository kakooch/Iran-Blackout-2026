package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC14472hy4;
import ir.nasim.IM4;
import ir.nasim.InterfaceC19114po0;

/* renamed from: ir.nasim.kG4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C15843kG4 {
    private final int a;
    private final String b;
    private final boolean c;
    private final boolean d;
    private final boolean e;
    private final IM4 f;
    private final InterfaceC19114po0 g;
    private final AbstractC14472hy4 h;
    private final Integer i;
    private final String j;
    private final String k;

    public C15843kG4(int i, String str, boolean z, boolean z2, boolean z3, IM4 im4, InterfaceC19114po0 interfaceC19114po0, AbstractC14472hy4 abstractC14472hy4, Integer num, String str2, String str3) {
        AbstractC13042fc3.i(str, "otpPattern");
        AbstractC13042fc3.i(im4, "otpCodeState");
        AbstractC13042fc3.i(interfaceC19114po0, "buttonStates");
        AbstractC13042fc3.i(abstractC14472hy4, "textFieldState");
        AbstractC13042fc3.i(str3, "descriptionText");
        this.a = i;
        this.b = str;
        this.c = z;
        this.d = z2;
        this.e = z3;
        this.f = im4;
        this.g = interfaceC19114po0;
        this.h = abstractC14472hy4;
        this.i = num;
        this.j = str2;
        this.k = str3;
    }

    public final C15843kG4 a(int i, String str, boolean z, boolean z2, boolean z3, IM4 im4, InterfaceC19114po0 interfaceC19114po0, AbstractC14472hy4 abstractC14472hy4, Integer num, String str2, String str3) {
        AbstractC13042fc3.i(str, "otpPattern");
        AbstractC13042fc3.i(im4, "otpCodeState");
        AbstractC13042fc3.i(interfaceC19114po0, "buttonStates");
        AbstractC13042fc3.i(abstractC14472hy4, "textFieldState");
        AbstractC13042fc3.i(str3, "descriptionText");
        return new C15843kG4(i, str, z, z2, z3, im4, interfaceC19114po0, abstractC14472hy4, num, str2, str3);
    }

    public final boolean c() {
        return this.e;
    }

    public final InterfaceC19114po0 d() {
        return this.g;
    }

    public final String e() {
        return this.j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C15843kG4)) {
            return false;
        }
        C15843kG4 c15843kG4 = (C15843kG4) obj;
        return this.a == c15843kG4.a && AbstractC13042fc3.d(this.b, c15843kG4.b) && this.c == c15843kG4.c && this.d == c15843kG4.d && this.e == c15843kG4.e && AbstractC13042fc3.d(this.f, c15843kG4.f) && AbstractC13042fc3.d(this.g, c15843kG4.g) && AbstractC13042fc3.d(this.h, c15843kG4.h) && AbstractC13042fc3.d(this.i, c15843kG4.i) && AbstractC13042fc3.d(this.j, c15843kG4.j) && AbstractC13042fc3.d(this.k, c15843kG4.k);
    }

    public final String f() {
        return this.k;
    }

    public final int g() {
        return this.a;
    }

    public final IM4 h() {
        return this.f;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31) + Boolean.hashCode(this.e)) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31;
        Integer num = this.i;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.j;
        return ((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.k.hashCode();
    }

    public final String i() {
        return this.b;
    }

    public final boolean j() {
        return this.c;
    }

    public final boolean k() {
        return this.d;
    }

    public final Integer l() {
        return this.i;
    }

    public final AbstractC14472hy4 m() {
        return this.h;
    }

    public String toString() {
        return "OTPUiState(maxOtpLength=" + this.a + ", otpPattern=" + this.b + ", readyToSetupPassword=" + this.c + ", readyToValidatePassword=" + this.d + ", authorizeCompleted=" + this.e + ", otpCodeState=" + this.f + ", buttonStates=" + this.g + ", textFieldState=" + this.h + ", snackBarMessage=" + this.i + ", confirmationMessage=" + this.j + ", descriptionText=" + this.k + Separators.RPAREN;
    }

    public /* synthetic */ C15843kG4(int i, String str, boolean z, boolean z2, boolean z3, IM4 im4, InterfaceC19114po0 interfaceC19114po0, AbstractC14472hy4 abstractC14472hy4, Integer num, String str2, String str3, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? Integer.MAX_VALUE : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? false : z2, (i2 & 16) == 0 ? z3 : false, (i2 & 32) != 0 ? IM4.a.a : im4, (i2 & 64) != 0 ? InterfaceC19114po0.a.C1453a.a : interfaceC19114po0, (i2 & 128) != 0 ? new AbstractC14472hy4.c(null, null, null, 7, null) : abstractC14472hy4, (i2 & 256) != 0 ? null : num, (i2 & 512) == 0 ? str2 : null, (i2 & 1024) == 0 ? str3 : "");
    }
}
