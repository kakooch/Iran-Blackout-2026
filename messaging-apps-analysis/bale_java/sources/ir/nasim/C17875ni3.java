package ir.nasim;

import ir.nasim.AbstractC8317Vl3;
import ir.nasim.InterfaceC8487We2;
import java.util.List;

/* renamed from: ir.nasim.ni3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C17875ni3 implements InterfaceC8487We2 {
    public static final a a = new a(null);

    /* renamed from: ir.nasim.ni3$a */
    public static final class a {
        private a() {
        }

        private final boolean b(AB2 ab2) {
            if (ab2.h().size() != 1) {
                return false;
            }
            InterfaceC12795fB1 interfaceC12795fB1B = ab2.b();
            InterfaceC21331tU0 interfaceC21331tU0 = interfaceC12795fB1B instanceof InterfaceC21331tU0 ? (InterfaceC21331tU0) interfaceC12795fB1B : null;
            if (interfaceC21331tU0 == null) {
                return false;
            }
            List listH = ab2.h();
            AbstractC13042fc3.h(listH, "f.valueParameters");
            MU0 mu0T = ((InterfaceC24919zQ7) AbstractC15401jX0.V0(listH)).getType().K0().t();
            InterfaceC21331tU0 interfaceC21331tU02 = mu0T instanceof InterfaceC21331tU0 ? (InterfaceC21331tU0) mu0T : null;
            return interfaceC21331tU02 != null && AbstractC19738qr3.x0(interfaceC21331tU0) && AbstractC13042fc3.d(PI1.i(interfaceC21331tU0), PI1.i(interfaceC21331tU02));
        }

        private final AbstractC8317Vl3 c(AB2 ab2, InterfaceC24919zQ7 interfaceC24919zQ7) {
            if (AbstractC6597Oe4.e(ab2) || b(ab2)) {
                AbstractC4099Dr3 type = interfaceC24919zQ7.getType();
                AbstractC13042fc3.h(type, "valueParameterDescriptor.type");
                return AbstractC6597Oe4.g(AbstractC7731Sy7.k(type));
            }
            AbstractC4099Dr3 type2 = interfaceC24919zQ7.getType();
            AbstractC13042fc3.h(type2, "valueParameterDescriptor.type");
            return AbstractC6597Oe4.g(type2);
        }

        public final boolean a(InterfaceC14592iA0 interfaceC14592iA0, InterfaceC14592iA0 interfaceC14592iA02) {
            AbstractC13042fc3.i(interfaceC14592iA0, "superDescriptor");
            AbstractC13042fc3.i(interfaceC14592iA02, "subDescriptor");
            if ((interfaceC14592iA02 instanceof C20848si3) && (interfaceC14592iA0 instanceof AB2)) {
                C20848si3 c20848si3 = (C20848si3) interfaceC14592iA02;
                c20848si3.h().size();
                AB2 ab2 = (AB2) interfaceC14592iA0;
                ab2.h().size();
                List listH = c20848si3.a().h();
                AbstractC13042fc3.h(listH, "subDescriptor.original.valueParameters");
                List listH2 = ab2.a().h();
                AbstractC13042fc3.h(listH2, "superDescriptor.original.valueParameters");
                for (XV4 xv4 : AbstractC15401jX0.v1(listH, listH2)) {
                    InterfaceC24919zQ7 interfaceC24919zQ7 = (InterfaceC24919zQ7) xv4.a();
                    InterfaceC24919zQ7 interfaceC24919zQ72 = (InterfaceC24919zQ7) xv4.b();
                    AbstractC13042fc3.h(interfaceC24919zQ7, "subParameter");
                    boolean z = c((AB2) interfaceC14592iA02, interfaceC24919zQ7) instanceof AbstractC8317Vl3.d;
                    AbstractC13042fc3.h(interfaceC24919zQ72, "superParameter");
                    if (z != (c(ab2, interfaceC24919zQ72) instanceof AbstractC8317Vl3.d)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private final boolean c(InterfaceC14592iA0 interfaceC14592iA0, InterfaceC14592iA0 interfaceC14592iA02, InterfaceC21331tU0 interfaceC21331tU0) {
        if ((interfaceC14592iA0 instanceof InterfaceC15194jA0) && (interfaceC14592iA02 instanceof AB2) && !AbstractC19738qr3.e0(interfaceC14592iA02)) {
            C17912nm0 c17912nm0 = C17912nm0.n;
            AB2 ab2 = (AB2) interfaceC14592iA02;
            C6432No4 name = ab2.getName();
            AbstractC13042fc3.h(name, "subDescriptor.name");
            if (!c17912nm0.l(name)) {
                C17321mm0 c17321mm0 = C17321mm0.n;
                C6432No4 name2 = ab2.getName();
                AbstractC13042fc3.h(name2, "subDescriptor.name");
                if (!c17321mm0.k(name2)) {
                    return false;
                }
            }
            InterfaceC15194jA0 interfaceC15194jA0E = AbstractC21886uI6.e((InterfaceC15194jA0) interfaceC14592iA0);
            Boolean boolValueOf = Boolean.valueOf(ab2.B0());
            boolean z = interfaceC14592iA0 instanceof AB2;
            if ((!AbstractC13042fc3.d(boolValueOf, (z ? (AB2) interfaceC14592iA0 : null) == null ? null : Boolean.valueOf(r5.B0()))) && (interfaceC15194jA0E == null || !ab2.B0())) {
                return true;
            }
            if ((interfaceC21331tU0 instanceof InterfaceC7811Th3) && ab2.s0() == null && interfaceC15194jA0E != null && !AbstractC21886uI6.f(interfaceC21331tU0, interfaceC15194jA0E)) {
                if ((interfaceC15194jA0E instanceof AB2) && z && C17912nm0.k((AB2) interfaceC15194jA0E) != null) {
                    String strC = AbstractC6597Oe4.c(ab2, false, false, 2, null);
                    AB2 ab2A = ((AB2) interfaceC14592iA0).a();
                    AbstractC13042fc3.h(ab2A, "superDescriptor.original");
                    if (AbstractC13042fc3.d(strC, AbstractC6597Oe4.c(ab2A, false, false, 2, null))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC8487We2
    public InterfaceC8487We2.b a(InterfaceC14592iA0 interfaceC14592iA0, InterfaceC14592iA0 interfaceC14592iA02, InterfaceC21331tU0 interfaceC21331tU0) {
        AbstractC13042fc3.i(interfaceC14592iA0, "superDescriptor");
        AbstractC13042fc3.i(interfaceC14592iA02, "subDescriptor");
        return c(interfaceC14592iA0, interfaceC14592iA02, interfaceC21331tU0) ? InterfaceC8487We2.b.INCOMPATIBLE : a.a(interfaceC14592iA0, interfaceC14592iA02) ? InterfaceC8487We2.b.INCOMPATIBLE : InterfaceC8487We2.b.UNKNOWN;
    }

    @Override // ir.nasim.InterfaceC8487We2
    public InterfaceC8487We2.a b() {
        return InterfaceC8487We2.a.CONFLICTS_ONLY;
    }
}
