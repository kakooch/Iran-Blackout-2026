package ir.nasim;

import ir.nasim.C14383hp3;
import ir.nasim.C22785vp3;
import ir.nasim.S33;
import org.xbill.DNS.WKSRecord;

/* renamed from: ir.nasim.tp3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C21605tp3 {
    public static final a g = new a(null);
    private static final C21605tp3 h = new C21605tp3(0, null, 0, 0, null, null, null, 127, null);
    private static final C21605tp3 i = new C21605tp3(0, Boolean.FALSE, C22785vp3.b.f(), 0, null, null, null, WKSRecord.Service.ERPC, null);
    private final int a;
    private final Boolean b;
    private final int c;
    private final int d;
    private final Boolean e;
    private final IH3 f;

    /* renamed from: ir.nasim.tp3$a */
    public static final class a {
        private a() {
        }

        public final C21605tp3 a() {
            return C21605tp3.h;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C21605tp3(int i2, Boolean bool, int i3, int i4, AbstractC11853df5 abstractC11853df5, Boolean bool2, IH3 ih3, ED1 ed1) {
        this(i2, bool, i3, i4, abstractC11853df5, bool2, ih3);
    }

    public static /* synthetic */ C21605tp3 c(C21605tp3 c21605tp3, int i2, Boolean bool, int i3, int i4, AbstractC11853df5 abstractC11853df5, Boolean bool2, IH3 ih3, int i5, Object obj) {
        AbstractC11853df5 abstractC11853df52;
        if ((i5 & 1) != 0) {
            i2 = c21605tp3.a;
        }
        if ((i5 & 2) != 0) {
            bool = c21605tp3.b;
        }
        Boolean bool3 = bool;
        if ((i5 & 4) != 0) {
            i3 = c21605tp3.c;
        }
        int i6 = i3;
        if ((i5 & 8) != 0) {
            i4 = c21605tp3.d;
        }
        int i7 = i4;
        if ((i5 & 16) != 0) {
            c21605tp3.getClass();
            abstractC11853df52 = null;
        } else {
            abstractC11853df52 = abstractC11853df5;
        }
        return c21605tp3.b(i2, bool3, i6, i7, abstractC11853df52, (i5 & 32) != 0 ? null : bool2, (i5 & 64) != 0 ? null : ih3);
    }

    private final boolean d() {
        Boolean bool = this.b;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    private final int e() {
        C14383hp3 c14383hp3F = C14383hp3.f(this.a);
        int iL = c14383hp3F.l();
        C14383hp3.a aVar = C14383hp3.b;
        if (C14383hp3.i(iL, aVar.d())) {
            c14383hp3F = null;
        }
        return c14383hp3F != null ? c14383hp3F.l() : aVar.b();
    }

    private final IH3 f() {
        IH3 ih3 = this.f;
        return ih3 == null ? IH3.c.b() : ih3;
    }

    private final int h() {
        C22785vp3 c22785vp3K = C22785vp3.k(this.c);
        int iQ = c22785vp3K.q();
        C22785vp3.a aVar = C22785vp3.b;
        if (C22785vp3.n(iQ, aVar.i())) {
            c22785vp3K = null;
        }
        return c22785vp3K != null ? c22785vp3K.q() : aVar.h();
    }

    public final C21605tp3 b(int i2, Boolean bool, int i3, int i4, AbstractC11853df5 abstractC11853df5, Boolean bool2, IH3 ih3) {
        return new C21605tp3(i2, bool, i3, i4, abstractC11853df5, bool2, ih3, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C21605tp3)) {
            return false;
        }
        C21605tp3 c21605tp3 = (C21605tp3) obj;
        if (!C14383hp3.i(this.a, c21605tp3.a) || !AbstractC13042fc3.d(this.b, c21605tp3.b) || !C22785vp3.n(this.c, c21605tp3.c) || !S33.m(this.d, c21605tp3.d)) {
            return false;
        }
        c21605tp3.getClass();
        return AbstractC13042fc3.d(null, null) && AbstractC13042fc3.d(this.e, c21605tp3.e) && AbstractC13042fc3.d(this.f, c21605tp3.f);
    }

    public final int g() {
        S33 s33J = S33.j(this.d);
        int iP = s33J.p();
        S33.a aVar = S33.b;
        if (S33.m(iP, aVar.i())) {
            s33J = null;
        }
        return s33J != null ? s33J.p() : aVar.a();
    }

    public int hashCode() {
        int iJ = C14383hp3.j(this.a) * 31;
        Boolean bool = this.b;
        int iHashCode = (((((iJ + (bool != null ? bool.hashCode() : 0)) * 31) + C22785vp3.o(this.c)) * 31) + S33.n(this.d)) * 961;
        Boolean bool2 = this.e;
        int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        IH3 ih3 = this.f;
        return iHashCode2 + (ih3 != null ? ih3.hashCode() : 0);
    }

    public final T33 i(boolean z) {
        return new T33(z, e(), d(), h(), g(), null, f(), null);
    }

    public String toString() {
        return "KeyboardOptions(capitalization=" + ((Object) C14383hp3.k(this.a)) + ", autoCorrectEnabled=" + this.b + ", keyboardType=" + ((Object) C22785vp3.p(this.c)) + ", imeAction=" + ((Object) S33.o(this.d)) + ", platformImeOptions=" + ((Object) null) + "showKeyboardOnFocus=" + this.e + ", hintLocales=" + this.f + ')';
    }

    private C21605tp3(int i2, Boolean bool, int i3, int i4, AbstractC11853df5 abstractC11853df5, Boolean bool2, IH3 ih3) {
        this.a = i2;
        this.b = bool;
        this.c = i3;
        this.d = i4;
        this.e = bool2;
        this.f = ih3;
    }

    public /* synthetic */ C21605tp3(int i2, Boolean bool, int i3, int i4, AbstractC11853df5 abstractC11853df5, Boolean bool2, IH3 ih3, int i5, ED1 ed1) {
        this((i5 & 1) != 0 ? C14383hp3.b.d() : i2, (i5 & 2) != 0 ? null : bool, (i5 & 4) != 0 ? C22785vp3.b.i() : i3, (i5 & 8) != 0 ? S33.b.i() : i4, (i5 & 16) != 0 ? null : abstractC11853df5, (i5 & 32) != 0 ? null : bool2, (i5 & 64) == 0 ? ih3 : null, null);
    }
}
