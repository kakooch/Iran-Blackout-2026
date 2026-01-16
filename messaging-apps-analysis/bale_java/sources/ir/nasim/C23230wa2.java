package ir.nasim;

import android.content.Context;
import ir.nasim.Q12;
import ir.nasim.features.root.AbstractC13089g;
import java.util.Locale;

/* renamed from: ir.nasim.wa2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C23230wa2 implements InterfaceC22634va2 {
    private final long a;
    private final boolean b;
    private boolean c;
    private C22044ua2 d;
    private boolean e;
    private boolean f;

    public C23230wa2(String str, long j, long j2, boolean z) {
        AbstractC13042fc3.i(str, "eventBarDataJson");
        this.a = j;
        this.b = z;
        K(str);
        if (U(j2)) {
            j(true);
            T();
        }
    }

    private final boolean B() {
        return (this.d == null || F() || G() || I()) ? false : true;
    }

    private final void C(C19231q00 c19231q00) {
        if (c19231q00.i("enabled", true)) {
            N(c19231q00);
        } else {
            this.c = J(c19231q00);
        }
    }

    private final Long D() {
        C22044ua2 c22044ua2 = this.d;
        if (c22044ua2 != null) {
            return c22044ua2.c();
        }
        return null;
    }

    private final boolean E() {
        C22044ua2 c22044ua2 = this.d;
        return (c22044ua2 != null ? c22044ua2.c() : null) != null;
    }

    private final boolean F() {
        C22044ua2 c22044ua2 = this.d;
        return c22044ua2 != null && c22044ua2.d() == 0;
    }

    private final boolean G() {
        C22044ua2 c22044ua2 = this.d;
        return c22044ua2 != null && this.a == c22044ua2.d();
    }

    private final boolean H() {
        String strE = PH3.e();
        Locale locale = Locale.getDefault();
        AbstractC13042fc3.h(locale, "getDefault(...)");
        String lowerCase = strE.toLowerCase(locale);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        return AbstractC13042fc3.d(lowerCase, "en");
    }

    private final boolean I() {
        if (E()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Long lD = D();
            AbstractC13042fc3.f(lD);
            if (jCurrentTimeMillis > lD.longValue()) {
                return true;
            }
        }
        return false;
    }

    private final boolean J(C19231q00 c19231q00) {
        return c19231q00.m("id", -1L) == 0;
    }

    private final void K(String str) {
        C19231q00 c19231q00;
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = AbstractC13042fc3.k(str.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                } else {
                    length--;
                }
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        if (str.subSequence(i, length + 1).toString().length() > 0) {
            try {
                if (AbstractC20762sZ6.X(str, "|to_json", false, 2, null)) {
                    String strM = AbstractC20153rZ6.M(str, "|to_json", "", false, 4, null);
                    int length2 = strM.length() - 1;
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 <= length2) {
                        boolean z4 = AbstractC13042fc3.k(strM.charAt(!z3 ? i2 : length2), 32) <= 0;
                        if (z3) {
                            if (!z4) {
                                break;
                            } else {
                                length2--;
                            }
                        } else if (z4) {
                            i2++;
                        } else {
                            z3 = true;
                        }
                    }
                    c19231q00 = new C19231q00(strM.subSequence(i2, length2 + 1).toString());
                } else {
                    c19231q00 = new C19231q00(str);
                }
                C(c19231q00);
            } catch (Exception e) {
                C19406qI3.a("EventBarFactoryImpl", e.getMessage(), new Object[0]);
            }
        }
    }

    private final void L(C19231q00 c19231q00) {
        C22044ua2 c22044ua2 = this.d;
        if (c22044ua2 != null) {
            if (c19231q00.q("background_color")) {
                c22044ua2.k(c19231q00.n("background_color"));
            }
            if (c19231q00.q("title_color")) {
                c22044ua2.s(c19231q00.n("title_color"));
            }
            if (c19231q00.q("link_color")) {
                c22044ua2.p(c19231q00.n("link_color"));
            }
            if (c19231q00.q("close_button_color")) {
                c22044ua2.l(c19231q00.n("close_button_color"));
            }
        }
    }

    private final void M(C19231q00 c19231q00) {
        C22044ua2 c22044ua2;
        if (!c19231q00.q("title_emoji") || (c22044ua2 = this.d) == null) {
            return;
        }
        c22044ua2.t(c19231q00.n("title_emoji"));
    }

    private final void N(C19231q00 c19231q00) {
        this.d = new C22044ua2(0L, null, null, null, null, null, null, null, null, null, 1023, null);
        P(c19231q00);
        O(c19231q00);
        o(B());
        if (y() || F()) {
            S(c19231q00);
            R(c19231q00);
            Q(c19231q00);
            M(c19231q00);
            L(c19231q00);
        }
    }

    private final void O(C19231q00 c19231q00) {
        if (c19231q00.q("expire_time_stamp")) {
            long jM = c19231q00.m("expire_time_stamp", -1L);
            C22044ua2 c22044ua2 = this.d;
            if (c22044ua2 != null) {
                c22044ua2.m(Long.valueOf(jM));
            }
        }
    }

    private final void P(C19231q00 c19231q00) {
        if (c19231q00.q("id")) {
            long jM = c19231q00.m("id", -1L);
            C22044ua2 c22044ua2 = this.d;
            if (c22044ua2 != null) {
                c22044ua2.n(jM);
            }
        }
    }

    private final void Q(C19231q00 c19231q00) {
        C22044ua2 c22044ua2;
        if (!c19231q00.q("link_address") || (c22044ua2 = this.d) == null) {
            return;
        }
        c22044ua2.o(c19231q00.n("link_address"));
    }

    private final void R(C19231q00 c19231q00) {
        C22044ua2 c22044ua2;
        if (H() && c19231q00.q("new_link_text_english")) {
            C22044ua2 c22044ua22 = this.d;
            if (c22044ua22 != null) {
                c22044ua22.q(c19231q00.n("new_link_text_english"));
                return;
            }
            return;
        }
        if (!c19231q00.q("new_link_text") || (c22044ua2 = this.d) == null) {
            return;
        }
        c22044ua2.q(c19231q00.n("new_link_text"));
    }

    private final void S(C19231q00 c19231q00) {
        C22044ua2 c22044ua2;
        if (H() && c19231q00.q("title_english")) {
            C22044ua2 c22044ua22 = this.d;
            if (c22044ua22 != null) {
                c22044ua22.r(c19231q00.n("title_english"));
                return;
            }
            return;
        }
        if (!c19231q00.q("title") || (c22044ua2 = this.d) == null) {
            return;
        }
        c22044ua2.r(c19231q00.n("title"));
    }

    private final void T() {
        if (this.d == null) {
            this.d = new C22044ua2(0L, null, null, null, null, null, null, null, null, null, 1023, null);
        }
        C22044ua2 c22044ua2 = this.d;
        if (c22044ua2 != null) {
            Context contextD = C5721Ko.a.d();
            String string = contextD.getString(AbstractC12217eE5.event_bar_update_title_text);
            AbstractC13042fc3.h(string, "getString(...)");
            String string2 = contextD.getString(AbstractC12217eE5.event_bar_update_button_text);
            AbstractC13042fc3.h(string2, "getString(...)");
            String string3 = contextD.getString(AbstractC12217eE5.event_bar_update_link_address);
            AbstractC13042fc3.h(string3, "getString(...)");
            if (!F()) {
                c22044ua2.r(string);
                c22044ua2.q(string2);
                c22044ua2.o(string3);
                return;
            }
            if (!w()) {
                c22044ua2.r(string);
            }
            if (!g()) {
                c22044ua2.q(string2);
            }
            if (s()) {
                return;
            }
            c22044ua2.o(string3);
        }
    }

    private final boolean U(long j) {
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        Q12.a aVar = Q12.b;
        return !y() && !this.c && ((jCurrentTimeMillis > Q12.A(T12.s(5, W12.h)) ? 1 : (jCurrentTimeMillis == Q12.A(T12.s(5, W12.h)) ? 0 : -1)) > 0) && this.b;
    }

    @Override // ir.nasim.InterfaceC22634va2
    public String A() {
        C22044ua2 c22044ua2 = this.d;
        if (c22044ua2 != null) {
            return c22044ua2.b();
        }
        return null;
    }

    @Override // ir.nasim.InterfaceC22634va2
    public int a() {
        return h() ? 58 : 0;
    }

    @Override // ir.nasim.InterfaceC22634va2
    public String b() {
        C22044ua2 c22044ua2 = this.d;
        if (c22044ua2 != null) {
            return c22044ua2.j();
        }
        return null;
    }

    @Override // ir.nasim.InterfaceC22634va2
    public boolean c() {
        String strU = u();
        if (strU == null) {
            return false;
        }
        int length = strU.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = AbstractC13042fc3.k(strU.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String string = strU.subSequence(i, length + 1).toString();
        return string != null && string.length() > 0;
    }

    @Override // ir.nasim.InterfaceC22634va2
    public String d() {
        C22044ua2 c22044ua2 = this.d;
        if (c22044ua2 != null) {
            return c22044ua2.i();
        }
        return null;
    }

    @Override // ir.nasim.InterfaceC22634va2
    public boolean e() {
        return f() || v();
    }

    @Override // ir.nasim.InterfaceC22634va2
    public boolean f() {
        return m() != 0;
    }

    @Override // ir.nasim.InterfaceC22634va2
    public boolean g() {
        String strN = n();
        if (strN == null) {
            return false;
        }
        int length = strN.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = AbstractC13042fc3.k(strN.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String string = strN.subSequence(i, length + 1).toString();
        return string != null && string.length() > 0;
    }

    @Override // ir.nasim.InterfaceC22634va2
    public boolean h() {
        return this.d != null && (x() || y());
    }

    @Override // ir.nasim.InterfaceC22634va2
    public String i() {
        C22044ua2 c22044ua2 = this.d;
        if (c22044ua2 != null) {
            return c22044ua2.h();
        }
        return null;
    }

    @Override // ir.nasim.InterfaceC22634va2
    public void j(boolean z) {
        this.e = z;
    }

    @Override // ir.nasim.InterfaceC22634va2
    public boolean k(int i) {
        return h() && (i == 0 || i == AbstractC13089g.d1 || i == AbstractC13089g.e1);
    }

    @Override // ir.nasim.InterfaceC22634va2
    public String l() {
        C22044ua2 c22044ua2 = this.d;
        if (c22044ua2 != null) {
            return c22044ua2.f();
        }
        return null;
    }

    @Override // ir.nasim.InterfaceC22634va2
    public int m() {
        if (x()) {
            return KB5.ba_logo_bale_eventbar_dark;
        }
        return 0;
    }

    @Override // ir.nasim.InterfaceC22634va2
    public String n() {
        C22044ua2 c22044ua2 = this.d;
        if (c22044ua2 != null) {
            return c22044ua2.g();
        }
        return null;
    }

    @Override // ir.nasim.InterfaceC22634va2
    public void o(boolean z) {
        this.f = z;
    }

    @Override // ir.nasim.InterfaceC22634va2
    public boolean p() {
        String strL = l();
        if (strL == null) {
            return false;
        }
        int length = strL.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = AbstractC13042fc3.k(strL.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String string = strL.subSequence(i, length + 1).toString();
        return string != null && string.length() > 0;
    }

    @Override // ir.nasim.InterfaceC22634va2
    public String q() {
        C22044ua2 c22044ua2 = this.d;
        if (c22044ua2 != null) {
            return c22044ua2.e();
        }
        return null;
    }

    @Override // ir.nasim.InterfaceC22634va2
    public boolean r() {
        String strA = A();
        if (strA == null) {
            return false;
        }
        int length = strA.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = AbstractC13042fc3.k(strA.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String string = strA.subSequence(i, length + 1).toString();
        return string != null && string.length() > 0;
    }

    @Override // ir.nasim.InterfaceC22634va2
    public boolean s() {
        String strQ = q();
        if (strQ == null) {
            return false;
        }
        int length = strQ.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = AbstractC13042fc3.k(strQ.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String string = strQ.subSequence(i, length + 1).toString();
        return string != null && string.length() > 0;
    }

    @Override // ir.nasim.InterfaceC22634va2
    public long t() {
        C22044ua2 c22044ua2 = this.d;
        if (c22044ua2 != null) {
            return c22044ua2.d();
        }
        return 0L;
    }

    @Override // ir.nasim.InterfaceC22634va2
    public String u() {
        C22044ua2 c22044ua2 = this.d;
        if (c22044ua2 != null) {
            return c22044ua2.a();
        }
        return null;
    }

    @Override // ir.nasim.InterfaceC22634va2
    public boolean v() {
        String strB = b();
        if (strB == null) {
            return false;
        }
        int length = strB.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = AbstractC13042fc3.k(strB.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String string = strB.subSequence(i, length + 1).toString();
        return string != null && string.length() > 0;
    }

    @Override // ir.nasim.InterfaceC22634va2
    public boolean w() {
        String strI = i();
        if (strI == null) {
            return false;
        }
        int length = strI.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = AbstractC13042fc3.k(strI.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String string = strI.subSequence(i, length + 1).toString();
        return string != null && string.length() > 0;
    }

    @Override // ir.nasim.InterfaceC22634va2
    public boolean x() {
        return this.e;
    }

    @Override // ir.nasim.InterfaceC22634va2
    public boolean y() {
        return this.f;
    }

    @Override // ir.nasim.InterfaceC22634va2
    public boolean z() {
        String strD = d();
        if (strD == null) {
            return false;
        }
        int length = strD.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = AbstractC13042fc3.k(strD.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String string = strD.subSequence(i, length + 1).toString();
        return string != null && string.length() > 0;
    }
}
