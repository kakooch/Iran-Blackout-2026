package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC22169um7;

/* loaded from: classes7.dex */
public final class C32 {
    public static final a g = new a(null);
    private static final C32 h = new C32("", false, false, null, false, AbstractC22169um7.a.a);
    private final String a;
    private final boolean b;
    private final boolean c;
    private final YF6 d;
    private final boolean e;
    private final AbstractC22169um7 f;

    public static final class a {
        private a() {
        }

        public final C32 a() {
            return C32.h;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C32(String str, boolean z, boolean z2, YF6 yf6, boolean z3, AbstractC22169um7 abstractC22169um7) {
        AbstractC13042fc3.i(str, "textInfo");
        AbstractC13042fc3.i(abstractC22169um7, "textFieldState");
        this.a = str;
        this.b = z;
        this.c = z2;
        this.d = yf6;
        this.e = z3;
        this.f = abstractC22169um7;
    }

    public static /* synthetic */ C32 c(C32 c32, String str, boolean z, boolean z2, YF6 yf6, boolean z3, AbstractC22169um7 abstractC22169um7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = c32.a;
        }
        if ((i & 2) != 0) {
            z = c32.b;
        }
        boolean z4 = z;
        if ((i & 4) != 0) {
            z2 = c32.c;
        }
        boolean z5 = z2;
        if ((i & 8) != 0) {
            yf6 = c32.d;
        }
        YF6 yf62 = yf6;
        if ((i & 16) != 0) {
            z3 = c32.e;
        }
        boolean z6 = z3;
        if ((i & 32) != 0) {
            abstractC22169um7 = c32.f;
        }
        return c32.b(str, z4, z5, yf62, z6, abstractC22169um7);
    }

    public final C32 b(String str, boolean z, boolean z2, YF6 yf6, boolean z3, AbstractC22169um7 abstractC22169um7) {
        AbstractC13042fc3.i(str, "textInfo");
        AbstractC13042fc3.i(abstractC22169um7, "textFieldState");
        return new C32(str, z, z2, yf6, z3, abstractC22169um7);
    }

    public final boolean d() {
        return this.e;
    }

    public final boolean e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C32)) {
            return false;
        }
        C32 c32 = (C32) obj;
        return AbstractC13042fc3.d(this.a, c32.a) && this.b == c32.b && this.c == c32.c && this.d == c32.d && this.e == c32.e && AbstractC13042fc3.d(this.f, c32.f);
    }

    public final boolean f() {
        return this.c;
    }

    public final YF6 g() {
        return this.d;
    }

    public final AbstractC22169um7 h() {
        return this.f;
    }

    public int hashCode() {
        int iHashCode = ((((this.a.hashCode() * 31) + Boolean.hashCode(this.b)) * 31) + Boolean.hashCode(this.c)) * 31;
        YF6 yf6 = this.d;
        return ((((iHashCode + (yf6 == null ? 0 : yf6.hashCode())) * 31) + Boolean.hashCode(this.e)) * 31) + this.f.hashCode();
    }

    public final String i() {
        return this.a;
    }

    public String toString() {
        return "EditInfoUiState(textInfo=" + this.a + ", saveButtonEnable=" + this.b + ", showLoading=" + this.c + ", snackBarState=" + this.d + ", editInfoSuccess=" + this.e + ", textFieldState=" + this.f + Separators.RPAREN;
    }
}
