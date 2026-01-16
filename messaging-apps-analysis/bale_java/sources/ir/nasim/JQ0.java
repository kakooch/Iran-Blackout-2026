package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC4571Fr7;
import ir.nasim.InterfaceC10503bj0;

/* loaded from: classes5.dex */
public final class JQ0 {
    private final XV4 a;
    private final Integer b;
    private final XV4 c;
    private final Integer d;
    private final boolean e;
    private final AbstractC4571Fr7 f;
    private final C20021rL0 g;
    private final C19951rD2 h;
    private final Integer i;
    private final InterfaceC4569Fr5 j;
    private final InterfaceC10503bj0 k;
    private final NA3 l;
    private final WO5 m;
    private final C14439hv n;
    private final C6634Oi0 o;
    private final C22132uj0 p;
    private final XV4 q;
    private final AbstractC13210fq4 r;

    public JQ0(XV4 xv4, Integer num, XV4 xv42, Integer num2, boolean z, AbstractC4571Fr7 abstractC4571Fr7, C20021rL0 c20021rL0, C19951rD2 c19951rD2, Integer num3, InterfaceC4569Fr5 interfaceC4569Fr5, InterfaceC10503bj0 interfaceC10503bj0, NA3 na3, WO5 wo5, C14439hv c14439hv, C6634Oi0 c6634Oi0, C22132uj0 c22132uj0, XV4 xv43, AbstractC13210fq4 abstractC13210fq4) {
        AbstractC13042fc3.i(abstractC4571Fr7, "toolbarMode");
        AbstractC13042fc3.i(interfaceC10503bj0, "botMenuState");
        this.a = xv4;
        this.b = num;
        this.c = xv42;
        this.d = num2;
        this.e = z;
        this.f = abstractC4571Fr7;
        this.g = c20021rL0;
        this.h = c19951rD2;
        this.i = num3;
        this.j = interfaceC4569Fr5;
        this.k = interfaceC10503bj0;
        this.l = na3;
        this.m = wo5;
        this.n = c14439hv;
        this.o = c6634Oi0;
        this.p = c22132uj0;
        this.q = xv43;
        this.r = abstractC13210fq4;
    }

    public final JQ0 a(XV4 xv4, Integer num, XV4 xv42, Integer num2, boolean z, AbstractC4571Fr7 abstractC4571Fr7, C20021rL0 c20021rL0, C19951rD2 c19951rD2, Integer num3, InterfaceC4569Fr5 interfaceC4569Fr5, InterfaceC10503bj0 interfaceC10503bj0, NA3 na3, WO5 wo5, C14439hv c14439hv, C6634Oi0 c6634Oi0, C22132uj0 c22132uj0, XV4 xv43, AbstractC13210fq4 abstractC13210fq4) {
        AbstractC13042fc3.i(abstractC4571Fr7, "toolbarMode");
        AbstractC13042fc3.i(interfaceC10503bj0, "botMenuState");
        return new JQ0(xv4, num, xv42, num2, z, abstractC4571Fr7, c20021rL0, c19951rD2, num3, interfaceC4569Fr5, interfaceC10503bj0, na3, wo5, c14439hv, c6634Oi0, c22132uj0, xv43, abstractC13210fq4);
    }

    public final C14439hv c() {
        return this.n;
    }

    public final C6634Oi0 d() {
        return this.o;
    }

    public final InterfaceC10503bj0 e() {
        return this.k;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JQ0)) {
            return false;
        }
        JQ0 jq0 = (JQ0) obj;
        return AbstractC13042fc3.d(this.a, jq0.a) && AbstractC13042fc3.d(this.b, jq0.b) && AbstractC13042fc3.d(this.c, jq0.c) && AbstractC13042fc3.d(this.d, jq0.d) && this.e == jq0.e && AbstractC13042fc3.d(this.f, jq0.f) && AbstractC13042fc3.d(this.g, jq0.g) && AbstractC13042fc3.d(this.h, jq0.h) && AbstractC13042fc3.d(this.i, jq0.i) && AbstractC13042fc3.d(this.j, jq0.j) && AbstractC13042fc3.d(this.k, jq0.k) && this.l == jq0.l && AbstractC13042fc3.d(this.m, jq0.m) && AbstractC13042fc3.d(this.n, jq0.n) && AbstractC13042fc3.d(this.o, jq0.o) && AbstractC13042fc3.d(this.p, jq0.p) && AbstractC13042fc3.d(this.q, jq0.q) && AbstractC13042fc3.d(this.r, jq0.r);
    }

    public final C22132uj0 f() {
        return this.p;
    }

    public final C20021rL0 g() {
        return this.g;
    }

    public final C19951rD2 h() {
        return this.h;
    }

    public int hashCode() {
        XV4 xv4 = this.a;
        int iHashCode = (xv4 == null ? 0 : xv4.hashCode()) * 31;
        Integer num = this.b;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        XV4 xv42 = this.c;
        int iHashCode3 = (iHashCode2 + (xv42 == null ? 0 : xv42.hashCode())) * 31;
        Integer num2 = this.d;
        int iHashCode4 = (((((iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31) + Boolean.hashCode(this.e)) * 31) + this.f.hashCode()) * 31;
        C20021rL0 c20021rL0 = this.g;
        int iHashCode5 = (iHashCode4 + (c20021rL0 == null ? 0 : c20021rL0.hashCode())) * 31;
        C19951rD2 c19951rD2 = this.h;
        int iHashCode6 = (iHashCode5 + (c19951rD2 == null ? 0 : c19951rD2.hashCode())) * 31;
        Integer num3 = this.i;
        int iHashCode7 = (iHashCode6 + (num3 == null ? 0 : num3.hashCode())) * 31;
        InterfaceC4569Fr5 interfaceC4569Fr5 = this.j;
        int iHashCode8 = (((iHashCode7 + (interfaceC4569Fr5 == null ? 0 : interfaceC4569Fr5.hashCode())) * 31) + this.k.hashCode()) * 31;
        NA3 na3 = this.l;
        int iHashCode9 = (iHashCode8 + (na3 == null ? 0 : na3.hashCode())) * 31;
        WO5 wo5 = this.m;
        int iHashCode10 = (iHashCode9 + (wo5 == null ? 0 : wo5.hashCode())) * 31;
        C14439hv c14439hv = this.n;
        int iHashCode11 = (iHashCode10 + (c14439hv == null ? 0 : c14439hv.hashCode())) * 31;
        C6634Oi0 c6634Oi0 = this.o;
        int iHashCode12 = (iHashCode11 + (c6634Oi0 == null ? 0 : c6634Oi0.hashCode())) * 31;
        C22132uj0 c22132uj0 = this.p;
        int iHashCode13 = (iHashCode12 + (c22132uj0 == null ? 0 : c22132uj0.hashCode())) * 31;
        XV4 xv43 = this.q;
        int iHashCode14 = (iHashCode13 + (xv43 == null ? 0 : xv43.hashCode())) * 31;
        AbstractC13210fq4 abstractC13210fq4 = this.r;
        return iHashCode14 + (abstractC13210fq4 != null ? abstractC13210fq4.hashCode() : 0);
    }

    public final NA3 i() {
        return this.l;
    }

    public final Integer j() {
        return this.i;
    }

    public final AbstractC13210fq4 k() {
        return this.r;
    }

    public final Integer l() {
        return this.d;
    }

    public final InterfaceC4569Fr5 m() {
        return this.j;
    }

    public final WO5 n() {
        return this.m;
    }

    public final Integer o() {
        return this.b;
    }

    public final XV4 p() {
        return this.a;
    }

    public final XV4 q() {
        return this.c;
    }

    public final AbstractC4571Fr7 r() {
        return this.f;
    }

    public final XV4 s() {
        return this.q;
    }

    public final boolean t() {
        return this.e;
    }

    public String toString() {
        return "ChatUIState(snackBarMessageResOrString=" + this.a + ", snackBarIcon=" + this.b + ", toastMessageResOrString=" + this.c + ", overlySnackBar=" + this.d + ", isCallRunning=" + this.e + ", toolbarMode=" + this.f + ", chatDialog=" + this.g + ", galleryResult=" + this.h + ", loadingProgressTitle=" + this.i + ", privacyBarStateEvent=" + this.j + ", botMenuState=" + this.k + ", linkStatus=" + this.l + ", replyKeyboardMarkupState=" + this.m + ", answerCallbackQuery=" + this.n + ", botIntroMessage=" + this.o + ", botReviewData=" + this.p + ", voteResult=" + this.q + ", navigateState=" + this.r + Separators.RPAREN;
    }

    public /* synthetic */ JQ0(XV4 xv4, Integer num, XV4 xv42, Integer num2, boolean z, AbstractC4571Fr7 abstractC4571Fr7, C20021rL0 c20021rL0, C19951rD2 c19951rD2, Integer num3, InterfaceC4569Fr5 interfaceC4569Fr5, InterfaceC10503bj0 interfaceC10503bj0, NA3 na3, WO5 wo5, C14439hv c14439hv, C6634Oi0 c6634Oi0, C22132uj0 c22132uj0, XV4 xv43, AbstractC13210fq4 abstractC13210fq4, int i, ED1 ed1) {
        this((i & 1) != 0 ? null : xv4, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : xv42, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? false : z, (i & 32) != 0 ? AbstractC4571Fr7.b.a : abstractC4571Fr7, (i & 64) != 0 ? null : c20021rL0, (i & 128) != 0 ? null : c19951rD2, (i & 256) != 0 ? null : num3, (i & 512) != 0 ? null : interfaceC4569Fr5, (i & 1024) != 0 ? InterfaceC10503bj0.b.a : interfaceC10503bj0, (i & 2048) != 0 ? null : na3, (i & 4096) != 0 ? null : wo5, (i & 8192) != 0 ? null : c14439hv, (i & 16384) != 0 ? null : c6634Oi0, (i & 32768) != 0 ? null : c22132uj0, (i & 65536) != 0 ? null : xv43, (i & 131072) != 0 ? null : abstractC13210fq4);
    }
}
