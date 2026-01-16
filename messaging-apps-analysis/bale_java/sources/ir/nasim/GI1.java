package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.C13760gm3;
import ir.nasim.C21830uC4;
import ir.nasim.FI1;
import ir.nasim.InterfaceC15194jA0;
import ir.nasim.PJ6;
import ir.nasim.database.dailogLists.DialogEntity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes8.dex */
public final class GI1 extends FI1 implements II1 {
    private final JI1 l;
    private final InterfaceC9173Yu3 m;

    private final class a implements InterfaceC15204jB1 {
        final /* synthetic */ GI1 a;

        /* renamed from: ir.nasim.GI1$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0388a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[EnumC20399rw5.valuesCustom().length];
                iArr[EnumC20399rw5.PRETTY.ordinal()] = 1;
                iArr[EnumC20399rw5.DEBUG.ordinal()] = 2;
                iArr[EnumC20399rw5.NONE.ordinal()] = 3;
                a = iArr;
            }
        }

        public a(GI1 gi1) {
            AbstractC13042fc3.i(gi1, "this$0");
            this.a = gi1;
        }

        private final void t(InterfaceC19199pw5 interfaceC19199pw5, StringBuilder sb, String str) throws IOException {
            int i = C0388a.a[this.a.m0().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                p(interfaceC19199pw5, sb);
            } else {
                this.a.S0(interfaceC19199pw5, sb);
                sb.append(AbstractC13042fc3.q(str, " for "));
                GI1 gi1 = this.a;
                InterfaceC20989sw5 interfaceC20989sw5V = interfaceC19199pw5.V();
                AbstractC13042fc3.h(interfaceC20989sw5V, "descriptor.correspondingProperty");
                gi1.y1(interfaceC20989sw5V, sb);
            }
        }

        public void A(InterfaceC24919zQ7 interfaceC24919zQ7, StringBuilder sb) {
            AbstractC13042fc3.i(interfaceC24919zQ7, "descriptor");
            AbstractC13042fc3.i(sb, "builder");
            this.a.Q1(interfaceC24919zQ7, true, sb, true);
        }

        @Override // ir.nasim.InterfaceC15204jB1
        public /* bridge */ /* synthetic */ Object a(InterfaceC21331tU0 interfaceC21331tU0, Object obj) throws IOException {
            n(interfaceC21331tU0, (StringBuilder) obj);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC15204jB1
        public /* bridge */ /* synthetic */ Object b(AB2 ab2, Object obj) throws IOException {
            p(ab2, (StringBuilder) obj);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC15204jB1
        public /* bridge */ /* synthetic */ Object c(InterfaceC22266uw5 interfaceC22266uw5, Object obj) throws IOException {
            v(interfaceC22266uw5, (StringBuilder) obj);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC15204jB1
        public /* bridge */ /* synthetic */ Object d(InterfaceC22882vy7 interfaceC22882vy7, Object obj) {
            z(interfaceC22882vy7, (StringBuilder) obj);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC15204jB1
        public /* bridge */ /* synthetic */ Object e(InterfaceC7722Sx7 interfaceC7722Sx7, Object obj) {
            y(interfaceC7722Sx7, (StringBuilder) obj);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC15204jB1
        public /* bridge */ /* synthetic */ Object f(InterfaceC20989sw5 interfaceC20989sw5, Object obj) throws IOException {
            u(interfaceC20989sw5, (StringBuilder) obj);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC15204jB1
        public /* bridge */ /* synthetic */ Object g(InterfaceC24340yS4 interfaceC24340yS4, Object obj) {
            r(interfaceC24340yS4, (StringBuilder) obj);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC15204jB1
        public /* bridge */ /* synthetic */ Object h(OS4 os4, Object obj) {
            s(os4, (StringBuilder) obj);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC15204jB1
        public /* bridge */ /* synthetic */ Object i(InterfaceC4146Dw5 interfaceC4146Dw5, Object obj) throws IOException {
            w(interfaceC4146Dw5, (StringBuilder) obj);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC15204jB1
        public /* bridge */ /* synthetic */ Object j(ZI5 zi5, Object obj) {
            x(zi5, (StringBuilder) obj);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC15204jB1
        public /* bridge */ /* synthetic */ Object k(InterfaceC21426te1 interfaceC21426te1, Object obj) throws IOException {
            o(interfaceC21426te1, (StringBuilder) obj);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC15204jB1
        public /* bridge */ /* synthetic */ Object l(InterfaceC8507Wg4 interfaceC8507Wg4, Object obj) {
            q(interfaceC8507Wg4, (StringBuilder) obj);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC15204jB1
        public /* bridge */ /* synthetic */ Object m(InterfaceC24919zQ7 interfaceC24919zQ7, Object obj) {
            A(interfaceC24919zQ7, (StringBuilder) obj);
            return C19938rB7.a;
        }

        public void n(InterfaceC21331tU0 interfaceC21331tU0, StringBuilder sb) throws IOException {
            AbstractC13042fc3.i(interfaceC21331tU0, "descriptor");
            AbstractC13042fc3.i(sb, "builder");
            this.a.Y0(interfaceC21331tU0, sb);
        }

        public void o(InterfaceC21426te1 interfaceC21426te1, StringBuilder sb) throws IOException {
            AbstractC13042fc3.i(interfaceC21426te1, "constructorDescriptor");
            AbstractC13042fc3.i(sb, "builder");
            this.a.d1(interfaceC21426te1, sb);
        }

        public void p(AB2 ab2, StringBuilder sb) throws IOException {
            AbstractC13042fc3.i(ab2, "descriptor");
            AbstractC13042fc3.i(sb, "builder");
            this.a.g1(ab2, sb);
        }

        public void q(InterfaceC8507Wg4 interfaceC8507Wg4, StringBuilder sb) {
            AbstractC13042fc3.i(interfaceC8507Wg4, "descriptor");
            AbstractC13042fc3.i(sb, "builder");
            this.a.q1(interfaceC8507Wg4, sb, true);
        }

        public void r(InterfaceC24340yS4 interfaceC24340yS4, StringBuilder sb) {
            AbstractC13042fc3.i(interfaceC24340yS4, "descriptor");
            AbstractC13042fc3.i(sb, "builder");
            this.a.u1(interfaceC24340yS4, sb);
        }

        public void s(OS4 os4, StringBuilder sb) {
            AbstractC13042fc3.i(os4, "descriptor");
            AbstractC13042fc3.i(sb, "builder");
            this.a.w1(os4, sb);
        }

        public void u(InterfaceC20989sw5 interfaceC20989sw5, StringBuilder sb) throws IOException {
            AbstractC13042fc3.i(interfaceC20989sw5, "descriptor");
            AbstractC13042fc3.i(sb, "builder");
            this.a.y1(interfaceC20989sw5, sb);
        }

        public void v(InterfaceC22266uw5 interfaceC22266uw5, StringBuilder sb) throws IOException {
            AbstractC13042fc3.i(interfaceC22266uw5, "descriptor");
            AbstractC13042fc3.i(sb, "builder");
            t(interfaceC22266uw5, sb, "getter");
        }

        public void w(InterfaceC4146Dw5 interfaceC4146Dw5, StringBuilder sb) throws IOException {
            AbstractC13042fc3.i(interfaceC4146Dw5, "descriptor");
            AbstractC13042fc3.i(sb, "builder");
            t(interfaceC4146Dw5, sb, "setter");
        }

        public void x(ZI5 zi5, StringBuilder sb) {
            AbstractC13042fc3.i(zi5, "descriptor");
            AbstractC13042fc3.i(sb, "builder");
            sb.append(zi5.getName());
        }

        public void y(InterfaceC7722Sx7 interfaceC7722Sx7, StringBuilder sb) {
            AbstractC13042fc3.i(interfaceC7722Sx7, "descriptor");
            AbstractC13042fc3.i(sb, "builder");
            this.a.G1(interfaceC7722Sx7, sb);
        }

        public void z(InterfaceC22882vy7 interfaceC22882vy7, StringBuilder sb) {
            AbstractC13042fc3.i(interfaceC22882vy7, "descriptor");
            AbstractC13042fc3.i(sb, "builder");
            this.a.L1(interfaceC22882vy7, sb, true);
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[CO5.valuesCustom().length];
            iArr[CO5.PLAIN.ordinal()] = 1;
            iArr[CO5.HTML.ordinal()] = 2;
            a = iArr;
            int[] iArr2 = new int[EnumC18351oW4.valuesCustom().length];
            iArr2[EnumC18351oW4.ALL.ordinal()] = 1;
            iArr2[EnumC18351oW4.ONLY_NON_SYNTHESIZED.ordinal()] = 2;
            iArr2[EnumC18351oW4.NONE.ordinal()] = 3;
            b = iArr2;
        }
    }

    static final class c extends AbstractC8614Ws3 implements UA2 {
        c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(InterfaceC3932Cy7 interfaceC3932Cy7) {
            AbstractC13042fc3.i(interfaceC3932Cy7, "it");
            if (interfaceC3932Cy7.b()) {
                return Separators.STAR;
            }
            GI1 gi1 = GI1.this;
            AbstractC4099Dr3 type = interfaceC3932Cy7.getType();
            AbstractC13042fc3.h(type, "it.type");
            String strX = gi1.x(type);
            if (interfaceC3932Cy7.c() == KQ7.INVARIANT) {
                return strX;
            }
            return interfaceC3932Cy7.c() + ' ' + strX;
        }
    }

    static final class d extends AbstractC8614Ws3 implements SA2 {

        static final class a extends AbstractC8614Ws3 implements UA2 {
            public static final a e = new a();

            a() {
                super(1);
            }

            public final void a(II1 ii1) {
                AbstractC13042fc3.i(ii1, "<this>");
                ii1.l(AbstractC4846Gu6.l(ii1.i(), AbstractC9766aX0.e(PJ6.a.C)));
                ii1.p(EnumC19173pu.ALWAYS_PARENTHESIZED);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((II1) obj);
                return C19938rB7.a;
            }
        }

        d() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final GI1 invoke() {
            return (GI1) GI1.this.z(a.e);
        }
    }

    static final class e extends AbstractC8614Ws3 implements UA2 {
        e() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(AbstractC7068Qd1 abstractC7068Qd1) {
            AbstractC13042fc3.i(abstractC7068Qd1, "it");
            return GI1.this.c1(abstractC7068Qd1);
        }
    }

    static final class f extends AbstractC8614Ws3 implements UA2 {
        public static final f e = new f();

        f() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(InterfaceC24919zQ7 interfaceC24919zQ7) {
            return "";
        }
    }

    static final class g extends AbstractC8614Ws3 implements UA2 {
        g() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(AbstractC4099Dr3 abstractC4099Dr3) {
            GI1 gi1 = GI1.this;
            AbstractC13042fc3.h(abstractC4099Dr3, "it");
            return gi1.x(abstractC4099Dr3);
        }
    }

    public GI1(JI1 ji1) {
        AbstractC13042fc3.i(ji1, "options");
        this.l = ji1;
        ji1.k0();
        this.m = AbstractC13269fw3.a(new d());
    }

    private final void A1(InterfaceC14592iA0 interfaceC14592iA0, StringBuilder sb) {
        ZI5 zi5Q = interfaceC14592iA0.Q();
        if (zi5Q != null) {
            V0(sb, zi5Q, EnumC3654Bu.RECEIVER);
            AbstractC4099Dr3 type = zi5Q.getType();
            AbstractC13042fc3.h(type, "receiver.type");
            String strX = x(type);
            if (W1(type) && !AbstractC7497Ry7.l(type)) {
                strX = '(' + strX + ')';
            }
            sb.append(strX);
            sb.append(Separators.DOT);
        }
    }

    private final void B1(InterfaceC14592iA0 interfaceC14592iA0, StringBuilder sb) {
        ZI5 zi5Q;
        if (n0() && (zi5Q = interfaceC14592iA0.Q()) != null) {
            sb.append(" on ");
            AbstractC4099Dr3 type = zi5Q.getType();
            AbstractC13042fc3.h(type, "receiver.type");
            sb.append(x(type));
        }
    }

    private final void C1(StringBuilder sb, XC6 xc6) {
        if (AbstractC13042fc3.d(xc6, AbstractC7497Ry7.b) || AbstractC7497Ry7.k(xc6)) {
            sb.append("???");
            return;
        }
        if (AbstractC14230ha2.t(xc6)) {
            if (C0()) {
                AbstractC18350oW3.a(xc6.K0());
                throw null;
            }
            sb.append("???");
            return;
        }
        if (AbstractC4816Gr3.a(xc6)) {
            e1(sb, xc6);
        } else if (W1(xc6)) {
            h1(sb, xc6);
        } else {
            e1(sb, xc6);
        }
    }

    private final void D1(StringBuilder sb) {
        int length = sb.length();
        if (length == 0 || sb.charAt(length - 1) != ' ') {
            sb.append(' ');
        }
    }

    private final void E1(InterfaceC21331tU0 interfaceC21331tU0, StringBuilder sb) throws IOException {
        if (J0() || AbstractC19738qr3.t0(interfaceC21331tU0.p())) {
            return;
        }
        Collection collectionB = interfaceC21331tU0.j().b();
        AbstractC13042fc3.h(collectionB, "klass.typeConstructor.supertypes");
        if (collectionB.isEmpty()) {
            return;
        }
        if (collectionB.size() == 1 && AbstractC19738qr3.a0((AbstractC4099Dr3) collectionB.iterator().next())) {
            return;
        }
        D1(sb);
        sb.append(": ");
        AbstractC15401jX0.x0(collectionB, sb, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : new g());
    }

    private final void F1(AB2 ab2, StringBuilder sb) {
        p1(sb, ab2.isSuspend(), "suspend");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G1(InterfaceC7722Sx7 interfaceC7722Sx7, StringBuilder sb) {
        W0(this, sb, interfaceC7722Sx7, null, 2, null);
        RI1 visibility = interfaceC7722Sx7.getVisibility();
        AbstractC13042fc3.h(visibility, "typeAlias.visibility");
        T1(visibility, sb);
        l1(interfaceC7722Sx7, sb);
        sb.append(j1("typealias"));
        sb.append(Separators.SP);
        q1(interfaceC7722Sx7, sb, true);
        List listQ = interfaceC7722Sx7.q();
        AbstractC13042fc3.h(listQ, "typeAlias.declaredTypeParameters");
        N1(listQ, sb, false);
        X0(interfaceC7722Sx7, sb);
        sb.append(" = ");
        sb.append(x(interfaceC7722Sx7.t0()));
    }

    private final void J1(StringBuilder sb, AbstractC4099Dr3 abstractC4099Dr3, InterfaceC13882gy7 interfaceC13882gy7) {
        C9888aj5 c9888aj5A = AbstractC3459Ay7.a(abstractC4099Dr3);
        if (c9888aj5A != null) {
            x1(sb, c9888aj5A);
        } else {
            sb.append(I1(interfaceC13882gy7));
            sb.append(H1(abstractC4099Dr3.J0()));
        }
    }

    static /* synthetic */ void K1(GI1 gi1, StringBuilder sb, AbstractC4099Dr3 abstractC4099Dr3, InterfaceC13882gy7 interfaceC13882gy7, int i, Object obj) {
        if ((i & 2) != 0) {
            interfaceC13882gy7 = abstractC4099Dr3.K0();
        }
        gi1.J1(sb, abstractC4099Dr3, interfaceC13882gy7);
    }

    private final String L0() {
        return Q(Separators.GREATER_THAN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L1(InterfaceC22882vy7 interfaceC22882vy7, StringBuilder sb, boolean z) {
        if (z) {
            sb.append(P0());
        }
        if (F0()) {
            sb.append("/*");
            sb.append(interfaceC22882vy7.getIndex());
            sb.append("*/ ");
        }
        p1(sb, interfaceC22882vy7.w(), "reified");
        String strJ = interfaceC22882vy7.m().j();
        boolean z2 = true;
        p1(sb, strJ.length() > 0, strJ);
        W0(this, sb, interfaceC22882vy7, null, 2, null);
        q1(interfaceC22882vy7, sb, z);
        int size = interfaceC22882vy7.getUpperBounds().size();
        if ((size > 1 && !z) || size == 1) {
            AbstractC4099Dr3 abstractC4099Dr3 = (AbstractC4099Dr3) interfaceC22882vy7.getUpperBounds().iterator().next();
            if (!AbstractC19738qr3.j0(abstractC4099Dr3)) {
                sb.append(" : ");
                AbstractC13042fc3.h(abstractC4099Dr3, "upperBound");
                sb.append(x(abstractC4099Dr3));
            }
        } else if (z) {
            for (AbstractC4099Dr3 abstractC4099Dr32 : interfaceC22882vy7.getUpperBounds()) {
                if (!AbstractC19738qr3.j0(abstractC4099Dr32)) {
                    if (z2) {
                        sb.append(" : ");
                    } else {
                        sb.append(" & ");
                    }
                    AbstractC13042fc3.h(abstractC4099Dr32, "upperBound");
                    sb.append(x(abstractC4099Dr32));
                    z2 = false;
                }
            }
        }
        if (z) {
            sb.append(L0());
        }
    }

    private final void M(StringBuilder sb, InterfaceC12795fB1 interfaceC12795fB1) {
        String name;
        if ((interfaceC12795fB1 instanceof InterfaceC24340yS4) || (interfaceC12795fB1 instanceof OS4)) {
            return;
        }
        if (interfaceC12795fB1 instanceof InterfaceC8507Wg4) {
            sb.append(" is a module");
            return;
        }
        InterfaceC12795fB1 interfaceC12795fB1B = interfaceC12795fB1.b();
        if (interfaceC12795fB1B == null || (interfaceC12795fB1B instanceof InterfaceC8507Wg4)) {
            return;
        }
        sb.append(Separators.SP);
        sb.append(m1("defined in"));
        sb.append(Separators.SP);
        C10027ax2 c10027ax2M = OI1.m(interfaceC12795fB1B);
        AbstractC13042fc3.h(c10027ax2M, "getFqName(containingDeclaration)");
        sb.append(c10027ax2M.e() ? "root package" : v(c10027ax2M));
        if (H0() && (interfaceC12795fB1B instanceof InterfaceC24340yS4) && (interfaceC12795fB1 instanceof InterfaceC16386lB1) && (name = ((InterfaceC16386lB1) interfaceC12795fB1).i().b().getName()) != null) {
            sb.append(Separators.SP);
            sb.append(m1("in file"));
            sb.append(Separators.SP);
            sb.append(name);
        }
    }

    private final boolean M0(AbstractC4099Dr3 abstractC4099Dr3) {
        return FB2.o(abstractC4099Dr3) || !abstractC4099Dr3.getAnnotations().isEmpty();
    }

    private final void M1(StringBuilder sb, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            L1((InterfaceC22882vy7) it.next(), sb, false);
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
    }

    private final void N(StringBuilder sb, List list) throws IOException {
        AbstractC15401jX0.x0(list, sb, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : new c());
    }

    private final EnumC11067cg4 N0(InterfaceC21058t24 interfaceC21058t24) {
        if (interfaceC21058t24 instanceof InterfaceC21331tU0) {
            return ((InterfaceC21331tU0) interfaceC21058t24).f() == AU0.INTERFACE ? EnumC11067cg4.ABSTRACT : EnumC11067cg4.FINAL;
        }
        InterfaceC12795fB1 interfaceC12795fB1B = interfaceC21058t24.b();
        InterfaceC21331tU0 interfaceC21331tU0 = interfaceC12795fB1B instanceof InterfaceC21331tU0 ? (InterfaceC21331tU0) interfaceC12795fB1B : null;
        if (interfaceC21331tU0 == null) {
            return EnumC11067cg4.FINAL;
        }
        if (!(interfaceC21058t24 instanceof InterfaceC15194jA0)) {
            return EnumC11067cg4.FINAL;
        }
        InterfaceC15194jA0 interfaceC15194jA0 = (InterfaceC15194jA0) interfaceC21058t24;
        AbstractC13042fc3.h(interfaceC15194jA0.d(), "this.overriddenDescriptors");
        if ((!r1.isEmpty()) && interfaceC21331tU0.r() != EnumC11067cg4.FINAL) {
            return EnumC11067cg4.OPEN;
        }
        if (interfaceC21331tU0.f() != AU0.INTERFACE || AbstractC13042fc3.d(interfaceC15194jA0.getVisibility(), QI1.a)) {
            return EnumC11067cg4.FINAL;
        }
        EnumC11067cg4 enumC11067cg4R = interfaceC15194jA0.r();
        EnumC11067cg4 enumC11067cg4 = EnumC11067cg4.ABSTRACT;
        return enumC11067cg4R == enumC11067cg4 ? enumC11067cg4 : EnumC11067cg4.OPEN;
    }

    private final void N1(List list, StringBuilder sb, boolean z) {
        if (!K0() && (!list.isEmpty())) {
            sb.append(P0());
            M1(sb, list);
            sb.append(L0());
            if (z) {
                sb.append(Separators.SP);
            }
        }
    }

    private final String O() {
        int i = b.a[A0().ordinal()];
        if (i == 1) {
            return Q("->");
        }
        if (i == 2) {
            return "&rarr;";
        }
        throw new NoWhenBranchMatchedException();
    }

    private final boolean O0(InterfaceC21651tu interfaceC21651tu) {
        return AbstractC13042fc3.d(interfaceC21651tu.e(), PJ6.a.D);
    }

    private final void O1(FQ7 fq7, StringBuilder sb, boolean z) {
        if (z || !(fq7 instanceof InterfaceC24919zQ7)) {
            sb.append(j1(fq7.P() ? "var" : "val"));
            sb.append(Separators.SP);
        }
    }

    private final boolean P(String str, String str2) {
        if (!AbstractC13042fc3.d(str, AbstractC20153rZ6.M(str2, Separators.QUESTION, "", false, 4, null)) && (!AbstractC20153rZ6.C(str2, Separators.QUESTION, false, 2, null) || !AbstractC13042fc3.d(AbstractC13042fc3.q(str, Separators.QUESTION), str2))) {
            if (!AbstractC13042fc3.d('(' + str + ")?", str2)) {
                return false;
            }
        }
        return true;
    }

    private final String P0() {
        return Q(Separators.LESS_THAN);
    }

    static /* synthetic */ void P1(GI1 gi1, FQ7 fq7, StringBuilder sb, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        gi1.O1(fq7, sb, z);
    }

    private final String Q(String str) {
        return A0().a(str);
    }

    private final boolean Q0(InterfaceC15194jA0 interfaceC15194jA0) {
        return !interfaceC15194jA0.d().isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Q1(ir.nasim.InterfaceC24919zQ7 r10, boolean r11, java.lang.StringBuilder r12, boolean r13) {
        /*
            r9 = this;
            if (r13 == 0) goto L10
            java.lang.String r0 = "value-parameter"
            java.lang.String r0 = r9.j1(r0)
            r12.append(r0)
            java.lang.String r0 = " "
            r12.append(r0)
        L10:
            boolean r0 = r9.F0()
            if (r0 == 0) goto L27
            java.lang.String r0 = "/*"
            r12.append(r0)
            int r0 = r10.getIndex()
            r12.append(r0)
        */
        //  java.lang.String r0 = "*/ "
        /*
            r12.append(r0)
        L27:
            r5 = 2
            r6 = 0
            r4 = 0
            r1 = r9
            r2 = r12
            r3 = r10
            W0(r1, r2, r3, r4, r5, r6)
            boolean r0 = r10.r0()
            java.lang.String r1 = "crossinline"
            r9.p1(r12, r0, r1)
            boolean r0 = r10.p0()
            java.lang.String r1 = "noinline"
            r9.p1(r12, r0, r1)
            boolean r0 = r9.u0()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L6c
            ir.nasim.iA0 r0 = r10.b()
            boolean r3 = r0 instanceof ir.nasim.InterfaceC18329oU0
            r4 = 0
            if (r3 == 0) goto L56
            ir.nasim.oU0 r0 = (ir.nasim.InterfaceC18329oU0) r0
            goto L57
        L56:
            r0 = r4
        L57:
            if (r0 != 0) goto L5a
            goto L62
        L5a:
            boolean r0 = r0.d0()
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r0)
        L62:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            boolean r0 = ir.nasim.AbstractC13042fc3.d(r4, r0)
            if (r0 == 0) goto L6c
            r8 = r2
            goto L6d
        L6c:
            r8 = r1
        L6d:
            if (r8 == 0) goto L78
            boolean r0 = r9.R()
            java.lang.String r3 = "actual"
            r9.p1(r12, r0, r3)
        L78:
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r12
            r7 = r13
            r3.S1(r4, r5, r6, r7, r8)
            ir.nasim.UA2 r11 = r9.X()
            if (r11 == 0) goto L98
            boolean r11 = r9.j()
            if (r11 == 0) goto L91
            boolean r11 = r10.y0()
            goto L95
        L91:
            boolean r11 = ir.nasim.PI1.a(r10)
        L95:
            if (r11 == 0) goto L98
            r1 = r2
        L98:
            if (r1 == 0) goto Lae
            ir.nasim.UA2 r11 = r9.X()
            ir.nasim.AbstractC13042fc3.f(r11)
            java.lang.Object r10 = r11.invoke(r10)
            java.lang.String r11 = " = "
            java.lang.String r10 = ir.nasim.AbstractC13042fc3.q(r11, r10)
            r12.append(r10)
        Lae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.GI1.Q1(ir.nasim.zQ7, boolean, java.lang.StringBuilder, boolean):void");
    }

    private final void R0(StringBuilder sb, C13893h0 c13893h0) {
        CO5 co5A0 = A0();
        CO5 co5 = CO5.HTML;
        if (co5A0 == co5) {
            sb.append("<font color=\"808080\"><i>");
        }
        sb.append(" /* = ");
        s1(sb, c13893h0.G());
        sb.append(" */");
        if (A0() == co5) {
            sb.append("</i></font>");
        }
    }

    private final void R1(Collection collection, boolean z, StringBuilder sb) {
        boolean zX1 = X1(z);
        int size = collection.size();
        E0().b(size, sb);
        Iterator it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            InterfaceC24919zQ7 interfaceC24919zQ7 = (InterfaceC24919zQ7) it.next();
            E0().a(interfaceC24919zQ7, i, size, sb);
            Q1(interfaceC24919zQ7, zX1, sb, false);
            E0().c(interfaceC24919zQ7, i, size, sb);
            i++;
        }
        E0().d(size, sb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S0(InterfaceC19199pw5 interfaceC19199pw5, StringBuilder sb) {
        l1(interfaceC19199pw5, sb);
    }

    private final void S1(FQ7 fq7, boolean z, StringBuilder sb, boolean z2, boolean z3) {
        AbstractC4099Dr3 type = fq7.getType();
        AbstractC13042fc3.h(type, "variable.type");
        InterfaceC24919zQ7 interfaceC24919zQ7 = fq7 instanceof InterfaceC24919zQ7 ? (InterfaceC24919zQ7) fq7 : null;
        AbstractC4099Dr3 abstractC4099Dr3U0 = interfaceC24919zQ7 != null ? interfaceC24919zQ7.u0() : null;
        AbstractC4099Dr3 abstractC4099Dr3 = abstractC4099Dr3U0 == null ? type : abstractC4099Dr3U0;
        p1(sb, abstractC4099Dr3U0 != null, "vararg");
        if (z3 || (z2 && !z0())) {
            O1(fq7, sb, z3);
        }
        if (z) {
            q1(fq7, sb, z2);
            sb.append(": ");
        }
        sb.append(x(abstractC4099Dr3));
        i1(fq7, sb);
        if (!F0() || abstractC4099Dr3U0 == null) {
            return;
        }
        sb.append(" /*");
        sb.append(x(type));
        sb.append("*/");
    }

    private final void T0(AB2 ab2, StringBuilder sb) {
        boolean z;
        boolean z2 = false;
        if (ab2.isOperator()) {
            Collection collectionD = ab2.d();
            AbstractC13042fc3.h(collectionD, "functionDescriptor.overriddenDescriptors");
            Collection collection = collectionD;
            if (!collection.isEmpty()) {
                Iterator it = collection.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (((AB2) it.next()).isOperator()) {
                        if (S()) {
                            break;
                        }
                    }
                }
                z = false;
            }
            z = true;
        } else {
            z = false;
        }
        if (ab2.isInfix()) {
            Collection collectionD2 = ab2.d();
            AbstractC13042fc3.h(collectionD2, "functionDescriptor.overriddenDescriptors");
            Collection collection2 = collectionD2;
            if (collection2.isEmpty()) {
                z2 = true;
            } else {
                Iterator it2 = collection2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    } else if (((AB2) it2.next()).isInfix()) {
                        if (S()) {
                            break;
                        }
                    }
                }
            }
        }
        p1(sb, ab2.C(), "tailrec");
        F1(ab2, sb);
        p1(sb, ab2.isInline(), "inline");
        p1(sb, z2, "infix");
        p1(sb, z, "operator");
    }

    private final boolean T1(RI1 ri1, StringBuilder sb) {
        if (!g0().contains(HI1.VISIBILITY)) {
            return false;
        }
        if (h0()) {
            ri1 = ri1.f();
        }
        if (!t0() && AbstractC13042fc3.d(ri1, QI1.l)) {
            return false;
        }
        sb.append(j1(ri1.c()));
        sb.append(Separators.SP);
        return true;
    }

    private final List U0(InterfaceC21651tu interfaceC21651tu) {
        InterfaceC18329oU0 interfaceC18329oU0D;
        Map mapJ = interfaceC21651tu.j();
        List listM = null;
        InterfaceC21331tU0 interfaceC21331tU0F = r0() ? PI1.f(interfaceC21651tu) : null;
        List listH = (interfaceC21331tU0F == null || (interfaceC18329oU0D = interfaceC21331tU0F.D()) == null) ? null : interfaceC18329oU0D.h();
        if (listH != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : listH) {
                if (((InterfaceC24919zQ7) obj).y0()) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((InterfaceC24919zQ7) it.next()).getName());
            }
            listM = arrayList2;
        }
        if (listM == null) {
            listM = AbstractC10360bX0.m();
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : listM) {
            AbstractC13042fc3.h((C6432No4) obj2, "it");
            if (!mapJ.containsKey(r5)) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = new ArrayList(AbstractC10976cX0.x(arrayList3, 10));
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            arrayList4.add(AbstractC13042fc3.q(((C6432No4) it2.next()).h(), " = ..."));
        }
        Set<Map.Entry> setEntrySet = mapJ.entrySet();
        ArrayList arrayList5 = new ArrayList(AbstractC10976cX0.x(setEntrySet, 10));
        for (Map.Entry entry : setEntrySet) {
            C6432No4 c6432No4 = (C6432No4) entry.getKey();
            AbstractC7068Qd1 abstractC7068Qd1 = (AbstractC7068Qd1) entry.getValue();
            StringBuilder sb = new StringBuilder();
            sb.append(c6432No4.h());
            sb.append(" = ");
            sb.append(!listM.contains(c6432No4) ? c1(abstractC7068Qd1) : "...");
            arrayList5.add(sb.toString());
        }
        return AbstractC15401jX0.Z0(AbstractC15401jX0.R0(arrayList4, arrayList5));
    }

    private final void U1(List list, StringBuilder sb) throws IOException {
        if (K0()) {
            return;
        }
        ArrayList arrayList = new ArrayList(0);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            InterfaceC22882vy7 interfaceC22882vy7 = (InterfaceC22882vy7) it.next();
            List upperBounds = interfaceC22882vy7.getUpperBounds();
            AbstractC13042fc3.h(upperBounds, "typeParameter.upperBounds");
            for (AbstractC4099Dr3 abstractC4099Dr3 : AbstractC15401jX0.k0(upperBounds, 1)) {
                StringBuilder sb2 = new StringBuilder();
                C6432No4 name = interfaceC22882vy7.getName();
                AbstractC13042fc3.h(name, "typeParameter.name");
                sb2.append(w(name, false));
                sb2.append(" : ");
                AbstractC13042fc3.h(abstractC4099Dr3, "it");
                sb2.append(x(abstractC4099Dr3));
                arrayList.add(sb2.toString());
            }
        }
        if (!arrayList.isEmpty()) {
            sb.append(Separators.SP);
            sb.append(j1("where"));
            sb.append(Separators.SP);
            AbstractC15401jX0.x0(arrayList, sb, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null);
        }
    }

    private final void V0(StringBuilder sb, InterfaceC10612bu interfaceC10612bu, EnumC3654Bu enumC3654Bu) {
        if (g0().contains(HI1.ANNOTATIONS)) {
            Set setI = interfaceC10612bu instanceof AbstractC4099Dr3 ? i() : Z();
            UA2 ua2T = T();
            for (InterfaceC21651tu interfaceC21651tu : interfaceC10612bu.getAnnotations()) {
                if (!AbstractC15401jX0.i0(setI, interfaceC21651tu.e()) && !O0(interfaceC21651tu) && (ua2T == null || ((Boolean) ua2T.invoke(interfaceC21651tu)).booleanValue())) {
                    sb.append(s(interfaceC21651tu, enumC3654Bu));
                    if (Y()) {
                        sb.append('\n');
                        AbstractC13042fc3.h(sb, "append('\\n')");
                    } else {
                        sb.append(Separators.SP);
                    }
                }
            }
        }
    }

    private final String V1(String str, String str2, String str3, String str4, String str5) {
        if (AbstractC20153rZ6.S(str, str2, false, 2, null) && AbstractC20153rZ6.S(str3, str4, false, 2, null)) {
            int length = str2.length();
            if (str == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String strSubstring = str.substring(length);
            AbstractC13042fc3.h(strSubstring, "(this as java.lang.String).substring(startIndex)");
            int length2 = str4.length();
            if (str3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String strSubstring2 = str3.substring(length2);
            AbstractC13042fc3.h(strSubstring2, "(this as java.lang.String).substring(startIndex)");
            String strQ = AbstractC13042fc3.q(str5, strSubstring);
            if (AbstractC13042fc3.d(strSubstring, strSubstring2)) {
                return strQ;
            }
            if (P(strSubstring, strSubstring2)) {
                return AbstractC13042fc3.q(strQ, "!");
            }
        }
        return null;
    }

    static /* synthetic */ void W0(GI1 gi1, StringBuilder sb, InterfaceC10612bu interfaceC10612bu, EnumC3654Bu enumC3654Bu, int i, Object obj) {
        if ((i & 2) != 0) {
            enumC3654Bu = null;
        }
        gi1.V0(sb, interfaceC10612bu, enumC3654Bu);
    }

    private final boolean W1(AbstractC4099Dr3 abstractC4099Dr3) {
        if (FB2.m(abstractC4099Dr3)) {
            List listJ0 = abstractC4099Dr3.J0();
            if (!(listJ0 instanceof Collection) || !listJ0.isEmpty()) {
                Iterator it = listJ0.iterator();
                while (it.hasNext()) {
                    if (((InterfaceC3932Cy7) it.next()).b()) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    private final void X0(NU0 nu0, StringBuilder sb) {
        List listQ = nu0.q();
        AbstractC13042fc3.h(listQ, "classifier.declaredTypeParameters");
        List parameters = nu0.j().getParameters();
        AbstractC13042fc3.h(parameters, "classifier.typeConstructor.parameters");
        if (F0() && nu0.A() && parameters.size() > listQ.size()) {
            sb.append(" /*captured type parameters: ");
            M1(sb, parameters.subList(listQ.size(), parameters.size()));
            sb.append("*/");
        }
    }

    private final boolean X1(boolean z) {
        int i = b.b[k0().ordinal()];
        if (i == 1) {
            return true;
        }
        if (i != 2) {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
        } else if (!z) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y0(InterfaceC21331tU0 interfaceC21331tU0, StringBuilder sb) throws IOException {
        InterfaceC18329oU0 interfaceC18329oU0D;
        boolean z = interfaceC21331tU0.f() == AU0.ENUM_ENTRY;
        if (!z0()) {
            W0(this, sb, interfaceC21331tU0, null, 2, null);
            if (!z) {
                RI1 visibility = interfaceC21331tU0.getVisibility();
                AbstractC13042fc3.h(visibility, "klass.visibility");
                T1(visibility, sb);
            }
            if ((interfaceC21331tU0.f() != AU0.INTERFACE || interfaceC21331tU0.r() != EnumC11067cg4.ABSTRACT) && (!interfaceC21331tU0.f().a() || interfaceC21331tU0.r() != EnumC11067cg4.FINAL)) {
                EnumC11067cg4 enumC11067cg4R = interfaceC21331tU0.r();
                AbstractC13042fc3.h(enumC11067cg4R, "klass.modality");
                n1(enumC11067cg4R, sb, N0(interfaceC21331tU0));
            }
            l1(interfaceC21331tU0, sb);
            p1(sb, g0().contains(HI1.INNER) && interfaceC21331tU0.A(), "inner");
            p1(sb, g0().contains(HI1.DATA) && interfaceC21331tU0.F0(), "data");
            p1(sb, g0().contains(HI1.INLINE) && interfaceC21331tU0.isInline(), "inline");
            p1(sb, g0().contains(HI1.VALUE) && interfaceC21331tU0.k0(), "value");
            p1(sb, g0().contains(HI1.FUN) && interfaceC21331tU0.f0(), "fun");
            Z0(interfaceC21331tU0, sb);
        }
        if (OI1.x(interfaceC21331tU0)) {
            b1(interfaceC21331tU0, sb);
        } else {
            if (!z0()) {
                D1(sb);
            }
            q1(interfaceC21331tU0, sb, true);
        }
        if (z) {
            return;
        }
        List listQ = interfaceC21331tU0.q();
        AbstractC13042fc3.h(listQ, "klass.declaredTypeParameters");
        N1(listQ, sb, false);
        X0(interfaceC21331tU0, sb);
        if (!interfaceC21331tU0.f().a() && V() && (interfaceC18329oU0D = interfaceC21331tU0.D()) != null) {
            sb.append(Separators.SP);
            W0(this, sb, interfaceC18329oU0D, null, 2, null);
            RI1 visibility2 = interfaceC18329oU0D.getVisibility();
            AbstractC13042fc3.h(visibility2, "primaryConstructor.visibility");
            T1(visibility2, sb);
            sb.append(j1("constructor"));
            List listH = interfaceC18329oU0D.h();
            AbstractC13042fc3.h(listH, "primaryConstructor.valueParameters");
            R1(listH, interfaceC18329oU0D.h0(), sb);
        }
        E1(interfaceC21331tU0, sb);
        U1(listQ, sb);
    }

    private final void Z0(InterfaceC21331tU0 interfaceC21331tU0, StringBuilder sb) {
        sb.append(j1(FI1.a.a(interfaceC21331tU0)));
    }

    private final GI1 a0() {
        return (GI1) this.m.getValue();
    }

    private final void b1(InterfaceC12795fB1 interfaceC12795fB1, StringBuilder sb) {
        if (o0()) {
            if (z0()) {
                sb.append("companion object");
            }
            D1(sb);
            InterfaceC12795fB1 interfaceC12795fB1B = interfaceC12795fB1.b();
            if (interfaceC12795fB1B != null) {
                sb.append("of ");
                C6432No4 name = interfaceC12795fB1B.getName();
                AbstractC13042fc3.h(name, "containingDeclaration.name");
                sb.append(w(name, false));
            }
        }
        if (F0() || !AbstractC13042fc3.d(interfaceC12795fB1.getName(), AbstractC23662xI6.c)) {
            if (!z0()) {
                D1(sb);
            }
            C6432No4 name2 = interfaceC12795fB1.getName();
            AbstractC13042fc3.h(name2, "descriptor.name");
            sb.append(w(name2, true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String c1(AbstractC7068Qd1 abstractC7068Qd1) {
        if (abstractC7068Qd1 instanceof WJ) {
            return AbstractC15401jX0.A0((Iterable) ((WJ) abstractC7068Qd1).b(), ", ", "{", "}", 0, null, new e(), 24, null);
        }
        if (abstractC7068Qd1 instanceof C4122Du) {
            return AbstractC20762sZ6.C0(FI1.t(this, (InterfaceC21651tu) ((C4122Du) abstractC7068Qd1).b(), null, 2, null), Separators.AT);
        }
        if (!(abstractC7068Qd1 instanceof C13760gm3)) {
            return abstractC7068Qd1.toString();
        }
        C13760gm3.b bVar = (C13760gm3.b) ((C13760gm3) abstractC7068Qd1).b();
        if (bVar instanceof C13760gm3.b.a) {
            return ((C13760gm3.b.a) bVar).a() + "::class";
        }
        if (!(bVar instanceof C13760gm3.b.C1259b)) {
            throw new NoWhenBranchMatchedException();
        }
        C13760gm3.b.C1259b c1259b = (C13760gm3.b.C1259b) bVar;
        String strB = c1259b.b().b().b();
        AbstractC13042fc3.h(strB, "classValue.classId.asSingleFqName().asString()");
        for (int i = 0; i < c1259b.a(); i++) {
            strB = "kotlin.Array<" + strB + '>';
        }
        return AbstractC13042fc3.q(strB, "::class");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d1(ir.nasim.InterfaceC21426te1 r18, java.lang.StringBuilder r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.GI1.d1(ir.nasim.te1, java.lang.StringBuilder):void");
    }

    private final void e1(StringBuilder sb, AbstractC4099Dr3 abstractC4099Dr3) {
        W0(this, sb, abstractC4099Dr3, null, 2, null);
        if (AbstractC4816Gr3.a(abstractC4099Dr3)) {
            if (!(abstractC4099Dr3 instanceof C13639ga2) || f0()) {
                sb.append(abstractC4099Dr3.K0().toString());
            } else {
                sb.append(((C13639ga2) abstractC4099Dr3).T0());
            }
            sb.append(H1(abstractC4099Dr3.J0()));
        } else {
            K1(this, sb, abstractC4099Dr3, null, 2, null);
        }
        if (abstractC4099Dr3.L0()) {
            sb.append(Separators.QUESTION);
        }
        if (AbstractC24252yI6.c(abstractC4099Dr3)) {
            sb.append("!!");
        }
    }

    private final String f1(List list) {
        return Q(DO5.c(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g1(AB2 ab2, StringBuilder sb) throws IOException {
        if (!z0()) {
            if (!y0()) {
                W0(this, sb, ab2, null, 2, null);
                RI1 visibility = ab2.getVisibility();
                AbstractC13042fc3.h(visibility, "function.visibility");
                T1(visibility, sb);
                o1(ab2, sb);
                if (b0()) {
                    l1(ab2, sb);
                }
                t1(ab2, sb);
                if (b0()) {
                    T0(ab2, sb);
                } else {
                    F1(ab2, sb);
                }
                k1(ab2, sb);
                if (F0()) {
                    if (ab2.B0()) {
                        sb.append("/*isHiddenToOvercomeSignatureClash*/ ");
                    }
                    if (ab2.E0()) {
                        sb.append("/*isHiddenForResolutionEverywhereBesideSupercalls*/ ");
                    }
                }
            }
            sb.append(j1("fun"));
            sb.append(Separators.SP);
            List typeParameters = ab2.getTypeParameters();
            AbstractC13042fc3.h(typeParameters, "function.typeParameters");
            N1(typeParameters, sb, true);
            A1(ab2, sb);
        }
        q1(ab2, sb, true);
        List listH = ab2.h();
        AbstractC13042fc3.h(listH, "function.valueParameters");
        R1(listH, ab2.h0(), sb);
        B1(ab2, sb);
        AbstractC4099Dr3 returnType = ab2.getReturnType();
        if (!I0() && (D0() || returnType == null || !AbstractC19738qr3.J0(returnType))) {
            sb.append(": ");
            sb.append(returnType == null ? "[NULL]" : x(returnType));
        }
        List typeParameters2 = ab2.getTypeParameters();
        AbstractC13042fc3.h(typeParameters2, "function.typeParameters");
        U1(typeParameters2, sb);
    }

    private final void h1(StringBuilder sb, AbstractC4099Dr3 abstractC4099Dr3) {
        C6432No4 c6432No4C;
        int length = sb.length();
        W0(a0(), sb, abstractC4099Dr3, null, 2, null);
        boolean z = true;
        boolean z2 = sb.length() != length;
        boolean zO = FB2.o(abstractC4099Dr3);
        boolean zL0 = abstractC4099Dr3.L0();
        AbstractC4099Dr3 abstractC4099Dr3H = FB2.h(abstractC4099Dr3);
        boolean z3 = zL0 || (z2 && abstractC4099Dr3H != null);
        if (z3) {
            if (zO) {
                sb.insert(length, '(');
            } else {
                if (z2) {
                    AbstractC22039uZ6.u1(sb);
                    if (sb.charAt(AbstractC20762sZ6.f0(sb) - 1) != ')') {
                        sb.insert(AbstractC20762sZ6.f0(sb), "()");
                    }
                }
                sb.append(Separators.LPAREN);
            }
        }
        p1(sb, zO, "suspend");
        if (abstractC4099Dr3H != null) {
            if ((!W1(abstractC4099Dr3H) || abstractC4099Dr3H.L0()) && !M0(abstractC4099Dr3H)) {
                z = false;
            }
            if (z) {
                sb.append(Separators.LPAREN);
            }
            r1(sb, abstractC4099Dr3H);
            if (z) {
                sb.append(Separators.RPAREN);
            }
            sb.append(Separators.DOT);
        }
        sb.append(Separators.LPAREN);
        int i = 0;
        for (InterfaceC3932Cy7 interfaceC3932Cy7 : FB2.j(abstractC4099Dr3)) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append(", ");
            }
            if (l0()) {
                AbstractC4099Dr3 type = interfaceC3932Cy7.getType();
                AbstractC13042fc3.h(type, "typeProjection.type");
                c6432No4C = FB2.c(type);
            } else {
                c6432No4C = null;
            }
            if (c6432No4C != null) {
                sb.append(w(c6432No4C, false));
                sb.append(": ");
            }
            sb.append(y(interfaceC3932Cy7));
            i = i2;
        }
        sb.append(") ");
        sb.append(O());
        sb.append(Separators.SP);
        r1(sb, FB2.i(abstractC4099Dr3));
        if (z3) {
            sb.append(Separators.RPAREN);
        }
        if (zL0) {
            sb.append(Separators.QUESTION);
        }
    }

    private final void i1(FQ7 fq7, StringBuilder sb) {
        AbstractC7068Qd1 abstractC7068Qd1O0;
        if (!e0() || (abstractC7068Qd1O0 = fq7.o0()) == null) {
            return;
        }
        sb.append(" = ");
        sb.append(Q(c1(abstractC7068Qd1O0)));
    }

    private final String j1(String str) {
        int i = b.a[A0().ordinal()];
        if (i == 1) {
            return str;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        if (U()) {
            return str;
        }
        return "<b>" + str + "</b>";
    }

    private final void k1(InterfaceC15194jA0 interfaceC15194jA0, StringBuilder sb) {
        if (g0().contains(HI1.MEMBER_KIND) && F0() && interfaceC15194jA0.f() != InterfaceC15194jA0.a.DECLARATION) {
            sb.append("/*");
            String strName = interfaceC15194jA0.f().name();
            if (strName == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = strName.toLowerCase();
            AbstractC13042fc3.h(lowerCase, "(this as java.lang.String).toLowerCase()");
            sb.append(lowerCase);
            sb.append("*/ ");
        }
    }

    private final void l1(InterfaceC21058t24 interfaceC21058t24, StringBuilder sb) {
        p1(sb, interfaceC21058t24.isExternal(), "external");
        boolean z = false;
        p1(sb, g0().contains(HI1.EXPECT) && interfaceC21058t24.l0(), "expect");
        if (g0().contains(HI1.ACTUAL) && interfaceC21058t24.Y()) {
            z = true;
        }
        p1(sb, z, "actual");
    }

    private final void n1(EnumC11067cg4 enumC11067cg4, StringBuilder sb, EnumC11067cg4 enumC11067cg42) {
        if (s0() || enumC11067cg4 != enumC11067cg42) {
            boolean zContains = g0().contains(HI1.MODALITY);
            String strName = enumC11067cg4.name();
            if (strName == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = strName.toLowerCase();
            AbstractC13042fc3.h(lowerCase, "(this as java.lang.String).toLowerCase()");
            p1(sb, zContains, lowerCase);
        }
    }

    private final void o1(InterfaceC15194jA0 interfaceC15194jA0, StringBuilder sb) {
        if (OI1.J(interfaceC15194jA0) && interfaceC15194jA0.r() == EnumC11067cg4.FINAL) {
            return;
        }
        if (j0() == PN4.RENDER_OVERRIDE && interfaceC15194jA0.r() == EnumC11067cg4.OPEN && Q0(interfaceC15194jA0)) {
            return;
        }
        EnumC11067cg4 enumC11067cg4R = interfaceC15194jA0.r();
        AbstractC13042fc3.h(enumC11067cg4R, "callable.modality");
        n1(enumC11067cg4R, sb, N0(interfaceC15194jA0));
    }

    private final void p1(StringBuilder sb, boolean z, String str) {
        if (z) {
            sb.append(j1(str));
            sb.append(Separators.SP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q1(InterfaceC12795fB1 interfaceC12795fB1, StringBuilder sb, boolean z) {
        C6432No4 name = interfaceC12795fB1.getName();
        AbstractC13042fc3.h(name, "descriptor.name");
        sb.append(w(name, z));
    }

    private final void r1(StringBuilder sb, AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC18174oC7 abstractC18174oC7N0 = abstractC4099Dr3.N0();
        C13893h0 c13893h0 = abstractC18174oC7N0 instanceof C13893h0 ? (C13893h0) abstractC18174oC7N0 : null;
        if (c13893h0 == null) {
            s1(sb, abstractC4099Dr3);
            return;
        }
        if (v0()) {
            s1(sb, c13893h0.G());
            return;
        }
        s1(sb, c13893h0.W0());
        if (w0()) {
            R0(sb, c13893h0);
        }
    }

    private final void s1(StringBuilder sb, AbstractC4099Dr3 abstractC4099Dr3) {
        if ((abstractC4099Dr3 instanceof AbstractC24426yb8) && j() && !((AbstractC24426yb8) abstractC4099Dr3).P0()) {
            sb.append("<Not computed yet>");
            return;
        }
        AbstractC18174oC7 abstractC18174oC7N0 = abstractC4099Dr3.N0();
        if (abstractC18174oC7N0 instanceof AbstractC6200Mp2) {
            sb.append(((AbstractC6200Mp2) abstractC18174oC7N0).U0(this, this));
        } else if (abstractC18174oC7N0 instanceof XC6) {
            C1(sb, (XC6) abstractC18174oC7N0);
        }
    }

    private final void t1(InterfaceC15194jA0 interfaceC15194jA0, StringBuilder sb) {
        if (g0().contains(HI1.OVERRIDE) && Q0(interfaceC15194jA0) && j0() != PN4.RENDER_OPEN) {
            p1(sb, true, "override");
            if (F0()) {
                sb.append("/*");
                sb.append(interfaceC15194jA0.d().size());
                sb.append("*/ ");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u1(InterfaceC24340yS4 interfaceC24340yS4, StringBuilder sb) {
        v1(interfaceC24340yS4.e(), "package-fragment", sb);
        if (j()) {
            sb.append(" in ");
            q1(interfaceC24340yS4.b(), sb, false);
        }
    }

    private final void v1(C9424Zw2 c9424Zw2, String str, StringBuilder sb) {
        sb.append(j1(str));
        C10027ax2 c10027ax2J = c9424Zw2.j();
        AbstractC13042fc3.h(c10027ax2J, "fqName.toUnsafe()");
        String strV = v(c10027ax2J);
        if (strV.length() > 0) {
            sb.append(Separators.SP);
            sb.append(strV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w1(OS4 os4, StringBuilder sb) {
        v1(os4.e(), "package", sb);
        if (j()) {
            sb.append(" in context of ");
            q1(os4.A0(), sb, false);
        }
    }

    private final void x1(StringBuilder sb, C9888aj5 c9888aj5) {
        StringBuilder sb2;
        C9888aj5 c9888aj5C = c9888aj5.c();
        if (c9888aj5C == null) {
            sb2 = null;
        } else {
            x1(sb, c9888aj5C);
            sb.append('.');
            C6432No4 name = c9888aj5.b().getName();
            AbstractC13042fc3.h(name, "possiblyInnerType.classifierDescriptor.name");
            sb.append(w(name, false));
            sb2 = sb;
        }
        if (sb2 == null) {
            InterfaceC13882gy7 interfaceC13882gy7J = c9888aj5.b().j();
            AbstractC13042fc3.h(interfaceC13882gy7J, "possiblyInnerType.classifierDescriptor.typeConstructor");
            sb.append(I1(interfaceC13882gy7J));
        }
        sb.append(H1(c9888aj5.a()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y1(InterfaceC20989sw5 interfaceC20989sw5, StringBuilder sb) throws IOException {
        if (!z0()) {
            if (!y0()) {
                z1(interfaceC20989sw5, sb);
                RI1 visibility = interfaceC20989sw5.getVisibility();
                AbstractC13042fc3.h(visibility, "property.visibility");
                T1(visibility, sb);
                boolean z = false;
                p1(sb, g0().contains(HI1.CONST) && interfaceC20989sw5.c0(), "const");
                l1(interfaceC20989sw5, sb);
                o1(interfaceC20989sw5, sb);
                t1(interfaceC20989sw5, sb);
                if (g0().contains(HI1.LATEINIT) && interfaceC20989sw5.w0()) {
                    z = true;
                }
                p1(sb, z, "lateinit");
                k1(interfaceC20989sw5, sb);
            }
            P1(this, interfaceC20989sw5, sb, false, 4, null);
            List typeParameters = interfaceC20989sw5.getTypeParameters();
            AbstractC13042fc3.h(typeParameters, "property.typeParameters");
            N1(typeParameters, sb, true);
            A1(interfaceC20989sw5, sb);
        }
        q1(interfaceC20989sw5, sb, true);
        sb.append(": ");
        AbstractC4099Dr3 type = interfaceC20989sw5.getType();
        AbstractC13042fc3.h(type, "property.type");
        sb.append(x(type));
        B1(interfaceC20989sw5, sb);
        i1(interfaceC20989sw5, sb);
        List typeParameters2 = interfaceC20989sw5.getTypeParameters();
        AbstractC13042fc3.h(typeParameters2, "property.typeParameters");
        U1(typeParameters2, sb);
    }

    private final void z1(InterfaceC20989sw5 interfaceC20989sw5, StringBuilder sb) {
        if (g0().contains(HI1.ANNOTATIONS)) {
            W0(this, sb, interfaceC20989sw5, null, 2, null);
            InterfaceC25104zk2 interfaceC25104zk2V0 = interfaceC20989sw5.v0();
            if (interfaceC25104zk2V0 != null) {
                V0(sb, interfaceC25104zk2V0, EnumC3654Bu.FIELD);
            }
            InterfaceC25104zk2 interfaceC25104zk2R = interfaceC20989sw5.R();
            if (interfaceC25104zk2R != null) {
                V0(sb, interfaceC25104zk2R, EnumC3654Bu.PROPERTY_DELEGATE_FIELD);
            }
            if (m0() == EnumC20399rw5.NONE) {
                InterfaceC22266uw5 interfaceC22266uw5G = interfaceC20989sw5.g();
                if (interfaceC22266uw5G != null) {
                    V0(sb, interfaceC22266uw5G, EnumC3654Bu.PROPERTY_GETTER);
                }
                InterfaceC4146Dw5 interfaceC4146Dw5J = interfaceC20989sw5.J();
                if (interfaceC4146Dw5J == null) {
                    return;
                }
                V0(sb, interfaceC4146Dw5J, EnumC3654Bu.PROPERTY_SETTER);
                List listH = interfaceC4146Dw5J.h();
                AbstractC13042fc3.h(listH, "setter.valueParameters");
                InterfaceC24919zQ7 interfaceC24919zQ7 = (InterfaceC24919zQ7) AbstractC15401jX0.V0(listH);
                AbstractC13042fc3.h(interfaceC24919zQ7, "it");
                V0(sb, interfaceC24919zQ7, EnumC3654Bu.SETTER_PARAMETER);
            }
        }
    }

    public CO5 A0() {
        return this.l.Z();
    }

    public UA2 B0() {
        return this.l.a0();
    }

    public boolean C0() {
        return this.l.b0();
    }

    public boolean D0() {
        return this.l.c0();
    }

    public FI1.l E0() {
        return this.l.d0();
    }

    public boolean F0() {
        return this.l.e0();
    }

    public boolean G0() {
        return this.l.f0();
    }

    public boolean H0() {
        return this.l.g0();
    }

    public String H1(List list) throws IOException {
        AbstractC13042fc3.i(list, "typeArguments");
        if (list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(P0());
        N(sb, list);
        sb.append(L0());
        String string = sb.toString();
        AbstractC13042fc3.h(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public boolean I0() {
        return this.l.h0();
    }

    public String I1(InterfaceC13882gy7 interfaceC13882gy7) {
        AbstractC13042fc3.i(interfaceC13882gy7, "typeConstructor");
        MU0 mu0T = interfaceC13882gy7.t();
        if (mu0T instanceof InterfaceC22882vy7 ? true : mu0T instanceof InterfaceC21331tU0 ? true : mu0T instanceof InterfaceC7722Sx7) {
            return a1(mu0T);
        }
        if (mu0T == null) {
            return interfaceC13882gy7.toString();
        }
        throw new IllegalStateException(AbstractC13042fc3.q("Unexpected classifier: ", mu0T.getClass()).toString());
    }

    public boolean J0() {
        return this.l.i0();
    }

    public boolean K0() {
        return this.l.j0();
    }

    public boolean R() {
        return this.l.s();
    }

    public boolean S() {
        return this.l.t();
    }

    public UA2 T() {
        return this.l.u();
    }

    public boolean U() {
        return this.l.v();
    }

    public boolean V() {
        return this.l.w();
    }

    public OU0 W() {
        return this.l.x();
    }

    public UA2 X() {
        return this.l.y();
    }

    public boolean Y() {
        return this.l.z();
    }

    public Set Z() {
        return this.l.A();
    }

    @Override // ir.nasim.II1
    public void a(boolean z) {
        this.l.a(z);
    }

    public String a1(MU0 mu0) {
        AbstractC13042fc3.i(mu0, "klass");
        return AbstractC14230ha2.r(mu0) ? mu0.j().toString() : W().a(mu0, this);
    }

    @Override // ir.nasim.II1
    public void b(boolean z) {
        this.l.b(z);
    }

    public boolean b0() {
        return this.l.B();
    }

    @Override // ir.nasim.II1
    public boolean c() {
        return this.l.c();
    }

    public boolean c0() {
        return this.l.C();
    }

    @Override // ir.nasim.II1
    public void d(EnumC18351oW4 enumC18351oW4) {
        AbstractC13042fc3.i(enumC18351oW4, "<set-?>");
        this.l.d(enumC18351oW4);
    }

    public boolean d0() {
        return this.l.D();
    }

    @Override // ir.nasim.II1
    public void e(boolean z) {
        this.l.e(z);
    }

    public boolean e0() {
        return this.l.E();
    }

    @Override // ir.nasim.II1
    public void f(boolean z) {
        this.l.f(z);
    }

    public boolean f0() {
        return this.l.F();
    }

    @Override // ir.nasim.II1
    public void g(CO5 co5) {
        AbstractC13042fc3.i(co5, "<set-?>");
        this.l.g(co5);
    }

    public Set g0() {
        return this.l.G();
    }

    @Override // ir.nasim.II1
    public void h(OU0 ou0) {
        AbstractC13042fc3.i(ou0, "<set-?>");
        this.l.h(ou0);
    }

    public boolean h0() {
        return this.l.H();
    }

    @Override // ir.nasim.II1
    public Set i() {
        return this.l.i();
    }

    public final JI1 i0() {
        return this.l;
    }

    @Override // ir.nasim.II1
    public boolean j() {
        return this.l.j();
    }

    public PN4 j0() {
        return this.l.I();
    }

    @Override // ir.nasim.II1
    public EnumC19173pu k() {
        return this.l.k();
    }

    public EnumC18351oW4 k0() {
        return this.l.J();
    }

    @Override // ir.nasim.II1
    public void l(Set set) {
        AbstractC13042fc3.i(set, "<set-?>");
        this.l.l(set);
    }

    public boolean l0() {
        return this.l.K();
    }

    @Override // ir.nasim.II1
    public void m(Set set) {
        AbstractC13042fc3.i(set, "<set-?>");
        this.l.m(set);
    }

    public EnumC20399rw5 m0() {
        return this.l.L();
    }

    public String m1(String str) {
        AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
        int i = b.a[A0().ordinal()];
        if (i == 1) {
            return str;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return "<i>" + str + "</i>";
    }

    @Override // ir.nasim.II1
    public void n(boolean z) {
        this.l.n(z);
    }

    public boolean n0() {
        return this.l.M();
    }

    @Override // ir.nasim.II1
    public void o(boolean z) {
        this.l.o(z);
    }

    public boolean o0() {
        return this.l.N();
    }

    @Override // ir.nasim.II1
    public void p(EnumC19173pu enumC19173pu) {
        AbstractC13042fc3.i(enumC19173pu, "<set-?>");
        this.l.p(enumC19173pu);
    }

    public boolean p0() {
        return this.l.O();
    }

    @Override // ir.nasim.II1
    public void q(boolean z) {
        this.l.q(z);
    }

    public boolean q0() {
        return this.l.P();
    }

    @Override // ir.nasim.FI1
    public String r(InterfaceC12795fB1 interfaceC12795fB1) {
        AbstractC13042fc3.i(interfaceC12795fB1, "declarationDescriptor");
        StringBuilder sb = new StringBuilder();
        interfaceC12795fB1.q0(new a(this), sb);
        if (G0()) {
            M(sb, interfaceC12795fB1);
        }
        String string = sb.toString();
        AbstractC13042fc3.h(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public boolean r0() {
        return this.l.Q();
    }

    @Override // ir.nasim.FI1
    public String s(InterfaceC21651tu interfaceC21651tu, EnumC3654Bu enumC3654Bu) throws IOException {
        AbstractC13042fc3.i(interfaceC21651tu, "annotation");
        StringBuilder sb = new StringBuilder();
        sb.append('@');
        if (enumC3654Bu != null) {
            sb.append(AbstractC13042fc3.q(enumC3654Bu.a(), ":"));
        }
        AbstractC4099Dr3 type = interfaceC21651tu.getType();
        sb.append(x(type));
        if (c0()) {
            List listU0 = U0(interfaceC21651tu);
            if (d0() || (!listU0.isEmpty())) {
                AbstractC15401jX0.x0(listU0, sb, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : Separators.LPAREN, (124 & 8) == 0 ? Separators.RPAREN : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null);
            }
        }
        if (F0() && (AbstractC4816Gr3.a(type) || (type.K0().t() instanceof C21830uC4.b))) {
            sb.append(" /* annotation class not found */");
        }
        String string = sb.toString();
        AbstractC13042fc3.h(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public boolean s0() {
        return this.l.R();
    }

    public boolean t0() {
        return this.l.S();
    }

    @Override // ir.nasim.FI1
    public String u(String str, String str2, AbstractC19738qr3 abstractC19738qr3) {
        AbstractC13042fc3.i(str, "lowerRendered");
        AbstractC13042fc3.i(str2, "upperRendered");
        AbstractC13042fc3.i(abstractC19738qr3, "builtIns");
        if (P(str, str2)) {
            if (!AbstractC20153rZ6.S(str2, Separators.LPAREN, false, 2, null)) {
                return AbstractC13042fc3.q(str, "!");
            }
            return '(' + str + ")!";
        }
        OU0 ou0W = W();
        InterfaceC21331tU0 interfaceC21331tU0W = abstractC19738qr3.w();
        AbstractC13042fc3.h(interfaceC21331tU0W, "builtIns.collection");
        String strH1 = AbstractC20762sZ6.h1(ou0W.a(interfaceC21331tU0W, this), "Collection", null, 2, null);
        String strV1 = V1(str, AbstractC13042fc3.q(strH1, "Mutable"), str2, strH1, strH1 + "(Mutable)");
        if (strV1 != null) {
            return strV1;
        }
        String strV12 = V1(str, AbstractC13042fc3.q(strH1, "MutableMap.MutableEntry"), str2, AbstractC13042fc3.q(strH1, "Map.Entry"), AbstractC13042fc3.q(strH1, "(Mutable)Map.(Mutable)Entry"));
        if (strV12 != null) {
            return strV12;
        }
        OU0 ou0W2 = W();
        InterfaceC21331tU0 interfaceC21331tU0J = abstractC19738qr3.j();
        AbstractC13042fc3.h(interfaceC21331tU0J, "builtIns.array");
        String strH12 = AbstractC20762sZ6.h1(ou0W2.a(interfaceC21331tU0J, this), "Array", null, 2, null);
        String strV13 = V1(str, AbstractC13042fc3.q(strH12, Q("Array<")), str2, AbstractC13042fc3.q(strH12, Q("Array<out ")), AbstractC13042fc3.q(strH12, Q("Array<(out) ")));
        if (strV13 != null) {
            return strV13;
        }
        return '(' + str + ".." + str2 + ')';
    }

    public boolean u0() {
        return this.l.T();
    }

    @Override // ir.nasim.FI1
    public String v(C10027ax2 c10027ax2) {
        AbstractC13042fc3.i(c10027ax2, "fqName");
        List listH = c10027ax2.h();
        AbstractC13042fc3.h(listH, "fqName.pathSegments()");
        return f1(listH);
    }

    public boolean v0() {
        return this.l.U();
    }

    @Override // ir.nasim.FI1
    public String w(C6432No4 c6432No4, boolean z) {
        AbstractC13042fc3.i(c6432No4, "name");
        String strQ = Q(DO5.b(c6432No4));
        if (!U() || A0() != CO5.HTML || !z) {
            return strQ;
        }
        return "<b>" + strQ + "</b>";
    }

    public boolean w0() {
        return this.l.V();
    }

    @Override // ir.nasim.FI1
    public String x(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "type");
        StringBuilder sb = new StringBuilder();
        r1(sb, (AbstractC4099Dr3) B0().invoke(abstractC4099Dr3));
        String string = sb.toString();
        AbstractC13042fc3.h(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public boolean x0() {
        return this.l.W();
    }

    @Override // ir.nasim.FI1
    public String y(InterfaceC3932Cy7 interfaceC3932Cy7) throws IOException {
        AbstractC13042fc3.i(interfaceC3932Cy7, "typeProjection");
        StringBuilder sb = new StringBuilder();
        N(sb, AbstractC9766aX0.e(interfaceC3932Cy7));
        String string = sb.toString();
        AbstractC13042fc3.h(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public boolean y0() {
        return this.l.X();
    }

    public boolean z0() {
        return this.l.Y();
    }
}
