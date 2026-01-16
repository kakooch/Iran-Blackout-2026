package ir.nasim;

import androidx.compose.ui.e;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Sn6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C7631Sn6 {
    private final e.c a;
    private final boolean b;
    private final C3419Au3 c;
    private final SemanticsConfiguration d;
    private boolean e;
    private C7631Sn6 f;
    private final int g;

    /* renamed from: ir.nasim.Sn6$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ B26 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(B26 b26) {
            super(1);
            this.e = b26;
        }

        public final void a(InterfaceC11943do6 interfaceC11943do6) {
            AbstractC9939ao6.p0(interfaceC11943do6, this.e.p());
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC11943do6) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Sn6$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(1);
            this.e = str;
        }

        public final void a(InterfaceC11943do6 interfaceC11943do6) {
            AbstractC9939ao6.e0(interfaceC11943do6, this.e);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC11943do6) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Sn6$c */
    public static final class c extends e.c implements InterfaceC7163Qn6 {
        final /* synthetic */ UA2 o;

        c(UA2 ua2) {
            this.o = ua2;
        }

        @Override // ir.nasim.InterfaceC7163Qn6
        public void U0(InterfaceC11943do6 interfaceC11943do6) {
            this.o.invoke(interfaceC11943do6);
        }
    }

    public C7631Sn6(e.c cVar, boolean z, C3419Au3 c3419Au3, SemanticsConfiguration semanticsConfiguration) {
        this.a = cVar;
        this.b = z;
        this.c = c3419Au3;
        this.d = semanticsConfiguration;
        this.g = c3419Au3.d();
    }

    private final void B(List list, SemanticsConfiguration semanticsConfiguration) {
        if (this.d.B()) {
            return;
        }
        D(this, list, false, false, 6, null);
        int size = list.size();
        for (int size2 = list.size(); size2 < size; size2++) {
            C7631Sn6 c7631Sn6 = (C7631Sn6) list.get(size2);
            if (!c7631Sn6.y()) {
                semanticsConfiguration.E(c7631Sn6.d);
                c7631Sn6.B(list, semanticsConfiguration);
            }
        }
    }

    public static /* synthetic */ List D(C7631Sn6 c7631Sn6, List list, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = new ArrayList();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        return c7631Sn6.C(list, z, z2);
    }

    private final void b(List list) {
        B26 b26G = AbstractC8104Un6.g(this);
        if (b26G != null && this.d.C() && (!list.isEmpty())) {
            list.add(c(b26G, new a(b26G)));
        }
        SemanticsConfiguration semanticsConfiguration = this.d;
        C8838Xn6 c8838Xn6 = C8838Xn6.a;
        if (semanticsConfiguration.i(c8838Xn6.d()) && (!list.isEmpty()) && this.d.C()) {
            List list2 = (List) AbstractC5719Kn6.a(this.d, c8838Xn6.d());
            String str = list2 != null ? (String) AbstractC15401jX0.s0(list2) : null;
            if (str != null) {
                list.add(0, c(null, new b(str)));
            }
        }
    }

    private final C7631Sn6 c(B26 b26, UA2 ua2) {
        SemanticsConfiguration semanticsConfiguration = new SemanticsConfiguration();
        semanticsConfiguration.I(false);
        semanticsConfiguration.F(false);
        ua2.invoke(semanticsConfiguration);
        C7631Sn6 c7631Sn6 = new C7631Sn6(new c(ua2), false, new C3419Au3(true, b26 != null ? AbstractC8104Un6.h(this) : AbstractC8104Un6.e(this)), semanticsConfiguration);
        c7631Sn6.e = true;
        c7631Sn6.f = this;
        return c7631Sn6;
    }

    private final void d(C3419Au3 c3419Au3, List list, boolean z) {
        C12544en4 c12544en4F0 = c3419Au3.F0();
        Object[] objArr = c12544en4F0.a;
        int iO = c12544en4F0.o();
        for (int i = 0; i < iO; i++) {
            C3419Au3 c3419Au32 = (C3419Au3) objArr[i];
            if (c3419Au32.b() && (z || !c3419Au32.u())) {
                if (c3419Au32.t0().q(AbstractC9572aB4.a(8))) {
                    list.add(AbstractC8104Un6.a(c3419Au32, this.b));
                } else {
                    d(c3419Au32, list, z);
                }
            }
        }
    }

    private final List f(List list, List list2) {
        D(this, list, false, false, 6, null);
        int size = list.size();
        for (int size2 = list.size(); size2 < size; size2++) {
            C7631Sn6 c7631Sn6 = (C7631Sn6) list.get(size2);
            if (c7631Sn6.y()) {
                list2.add(c7631Sn6);
            } else if (!c7631Sn6.d.B()) {
                c7631Sn6.f(list, list2);
            }
        }
        return list2;
    }

    static /* synthetic */ List g(C7631Sn6 c7631Sn6, List list, List list2, int i, Object obj) {
        if ((i & 2) != 0) {
            list2 = new ArrayList();
        }
        return c7631Sn6.f(list, list2);
    }

    public static /* synthetic */ List m(C7631Sn6 c7631Sn6, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = !c7631Sn6.b;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            z3 = false;
        }
        return c7631Sn6.l(z, z2, z3);
    }

    private final boolean y() {
        return this.b && this.d.C();
    }

    public final boolean A() {
        if (!this.e && t().isEmpty()) {
            C3419Au3 c3419Au3A0 = this.c.A0();
            while (true) {
                if (c3419Au3A0 == null) {
                    c3419Au3A0 = null;
                    break;
                }
                SemanticsConfiguration semanticsConfigurationE = c3419Au3A0.e();
                if (semanticsConfigurationE != null && semanticsConfigurationE.C()) {
                    break;
                }
                c3419Au3A0 = c3419Au3A0.A0();
            }
            if (c3419Au3A0 == null) {
                return true;
            }
        }
        return false;
    }

    public final List C(List list, boolean z, boolean z2) {
        if (this.e) {
            return AbstractC10360bX0.m();
        }
        d(this.c, list, z2);
        if (z) {
            b(list);
        }
        return list;
    }

    public final C7631Sn6 a() {
        return new C7631Sn6(this.a, true, this.c, this.d);
    }

    public final XA4 e() {
        if (this.e) {
            C7631Sn6 c7631Sn6R = r();
            if (c7631Sn6R != null) {
                return c7631Sn6R.e();
            }
            return null;
        }
        JG1 jg1F = AbstractC8104Un6.f(this.c);
        if (jg1F == null) {
            jg1F = this.a;
        }
        return KG1.j(jg1F, AbstractC9572aB4.a(8));
    }

    public final CK5 h() {
        InterfaceC11379cu3 interfaceC11379cu3K1;
        C7631Sn6 c7631Sn6R = r();
        if (c7631Sn6R == null) {
            return CK5.e.a();
        }
        XA4 xa4E = e();
        if (xa4E != null) {
            if (!xa4E.b()) {
                xa4E = null;
            }
            if (xa4E != null && (interfaceC11379cu3K1 = xa4E.k1()) != null) {
                return InterfaceC11379cu3.W(KG1.j(c7631Sn6R.a, AbstractC9572aB4.a(8)), interfaceC11379cu3K1, false, 2, null);
            }
        }
        return CK5.e.a();
    }

    public final CK5 i() {
        CK5 ck5B;
        XA4 xa4E = e();
        if (xa4E != null) {
            if (!xa4E.b()) {
                xa4E = null;
            }
            if (xa4E != null && (ck5B = AbstractC12000du3.b(xa4E)) != null) {
                return ck5B;
            }
        }
        return CK5.e.a();
    }

    public final CK5 j() {
        CK5 ck5C;
        XA4 xa4E = e();
        if (xa4E != null) {
            if (!xa4E.b()) {
                xa4E = null;
            }
            if (xa4E != null && (ck5C = AbstractC12000du3.c(xa4E)) != null) {
                return ck5C;
            }
        }
        return CK5.e.a();
    }

    public final List k() {
        return m(this, false, false, false, 7, null);
    }

    public final List l(boolean z, boolean z2, boolean z3) {
        if (!z && this.d.B()) {
            return AbstractC10360bX0.m();
        }
        ArrayList arrayList = new ArrayList();
        return y() ? g(this, arrayList, null, 2, null) : C(arrayList, z2, z3);
    }

    public final SemanticsConfiguration n() {
        if (!y()) {
            return this.d;
        }
        SemanticsConfiguration semanticsConfigurationO = this.d.o();
        B(new ArrayList(), semanticsConfigurationO);
        return semanticsConfigurationO;
    }

    public final int o() {
        return this.g;
    }

    public final InterfaceC16813lu3 p() {
        return this.c;
    }

    public final C3419Au3 q() {
        return this.c;
    }

    public final C7631Sn6 r() {
        C3419Au3 c3419Au3A0;
        C7631Sn6 c7631Sn6 = this.f;
        if (c7631Sn6 != null) {
            return c7631Sn6;
        }
        if (this.b) {
            c3419Au3A0 = this.c.A0();
            while (c3419Au3A0 != null) {
                SemanticsConfiguration semanticsConfigurationE = c3419Au3A0.e();
                if (semanticsConfigurationE != null && semanticsConfigurationE.C()) {
                    break;
                }
                c3419Au3A0 = c3419Au3A0.A0();
            }
            c3419Au3A0 = null;
        } else {
            c3419Au3A0 = null;
        }
        if (c3419Au3A0 == null) {
            c3419Au3A0 = this.c.A0();
            while (true) {
                if (c3419Au3A0 == null) {
                    c3419Au3A0 = null;
                    break;
                }
                if (c3419Au3A0.t0().q(AbstractC9572aB4.a(8))) {
                    break;
                }
                c3419Au3A0 = c3419Au3A0.A0();
            }
        }
        if (c3419Au3A0 == null) {
            return null;
        }
        return AbstractC8104Un6.a(c3419Au3A0, this.b);
    }

    public final long s() {
        XA4 xa4E = e();
        if (xa4E != null) {
            if (!xa4E.b()) {
                xa4E = null;
            }
            if (xa4E != null) {
                return AbstractC12000du3.e(xa4E);
            }
        }
        return ZG4.b.c();
    }

    public final List t() {
        return m(this, false, true, false, 4, null);
    }

    public final long u() {
        XA4 xa4E = e();
        return xa4E != null ? xa4E.a() : C4414Fa3.b.a();
    }

    public final CK5 v() {
        JG1 jg1F;
        if (!this.d.C() || (jg1F = AbstractC8104Un6.f(this.c)) == null) {
            jg1F = this.a;
        }
        return AbstractC7397Rn6.c(jg1F.h(), AbstractC7397Rn6.a(this.d));
    }

    public final SemanticsConfiguration w() {
        return this.d;
    }

    public final boolean x() {
        return this.e;
    }

    public final boolean z() {
        XA4 xa4E = e();
        if (xa4E != null) {
            return xa4E.X2();
        }
        return false;
    }
}
