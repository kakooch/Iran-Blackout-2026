package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class QZ0 extends AbstractC21707u0 implements D48 {
    private final C9057Yh4 b;
    private final InterfaceC9173Yu3 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZ0(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        this.b = c9057Yh4;
        this.c = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.PZ0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return QZ0.F();
            }
        });
    }

    private final void B(J44 j44, long j) {
        J44 j442;
        C8445Vz5 c8445Vz5Q = j44.Q();
        J44 j44E = j44.E((c8445Vz5Q == null || c8445Vz5Q.s() != j) ? j44.Q() : null);
        DB3 db3F0 = this.b.G().F0();
        if (db3F0 == null) {
            return;
        }
        db3F0.d(j44E);
        C3460Az c3460AzO = j44E.O();
        if (c3460AzO == null || (j442 = (J44) db3F0.a(c3460AzO.i())) == null) {
            return;
        }
        C3460Az c3460Az = new C3460Az(j44E.h(), j44E.i(), 0L);
        if (C3699Bz.a(j442.N(), c3460Az)) {
            return;
        }
        j442.j0(c3460Az);
        db3F0.d(j442);
    }

    private final void C(C11458d25 c11458d25, long j, AbstractC17457n0 abstractC17457n0) {
        J44 j44;
        DB3 db3F0 = this.b.G().F0();
        if (db3F0 == null || (j44 = (J44) db3F0.a(j)) == null) {
            return;
        }
        J44 j44U = j44.u(abstractC17457n0, false);
        List listD = K56.A.d(c11458d25, AbstractC9766aX0.e(Long.valueOf(j)), abstractC17457n0, db3F0);
        listD.add(j44U);
        db3F0.c(listD);
    }

    private final void D(FE7 fe7) {
        DB3 db3F0 = this.b.G().F0();
        if (db3F0 == null) {
            return;
        }
        Iterator it = fe7.c().iterator();
        while (it.hasNext()) {
            long jLongValue = ((Number) it.next()).longValue();
            J44 j44 = (J44) db3F0.a(jLongValue);
            if (j44 != null) {
                if (j44.F().m()) {
                    C24967zW1 c24967zW1H = j44.H();
                    if ((c24967zW1H != null ? c24967zW1H.z() : null) instanceof C11920dm2) {
                        InterfaceC18505om2 interfaceC18505om2Z = c24967zW1H.z();
                        AbstractC13042fc3.g(interfaceC18505om2Z, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.FileRemoteSource");
                        E().J0().c(((C11920dm2) interfaceC18505om2Z).b());
                    }
                }
                if (j44.d0() && j44.F().m()) {
                    this.b.D().S(jLongValue);
                }
                K56.A.b(fe7.b(), jLongValue, j44.h());
                db3F0.b(jLongValue);
            }
        }
    }

    private final InterfaceC24602yt4 E() {
        return (InterfaceC24602yt4) this.c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC24602yt4 F() {
        return (InterfaceC24602yt4) C92.a(C5721Ko.a.d(), InterfaceC24602yt4.class);
    }

    @Override // ir.nasim.D48
    public boolean d(AbstractC20556sC7 abstractC20556sC7, long j) {
        AbstractC13042fc3.i(abstractC20556sC7, "update");
        if (!(abstractC20556sC7 instanceof CE7)) {
            if (abstractC20556sC7 instanceof FE7) {
                D((FE7) abstractC20556sC7);
                return true;
            }
            if (!(abstractC20556sC7 instanceof DE7)) {
                return false;
            }
            DE7 de7 = (DE7) abstractC20556sC7;
            C11458d25 c11458d25C = de7.c();
            if (c11458d25C == null) {
                return true;
            }
            long jD = de7.d();
            AbstractC17457n0 abstractC17457n0H = AbstractC17457n0.h(de7.b());
            AbstractC13042fc3.h(abstractC17457n0H, "fromMessage(...)");
            C(c11458d25C, jD, abstractC17457n0H);
            return true;
        }
        if (this.b.G().F0() != null) {
            CE7 ce7 = (CE7) abstractC20556sC7;
            C7880To7 c7880To7J = ce7.j();
            C8445Vz5 c8445Vz5Y = null;
            Long lValueOf = c7880To7J != null ? Long.valueOf(c7880To7J.i()) : null;
            J44 j44A = F84.l.a();
            if (AbstractC13042fc3.d(lValueOf, j44A != null ? Long.valueOf(j44A.i()) : null)) {
                AbstractC17457n0 abstractC17457n0H2 = AbstractC17457n0.h(ce7.d());
                if (ce7.g() != null) {
                    boolean z = abstractC17457n0H2 instanceof C18121o72;
                    c8445Vz5Y = C8445Vz5.y(this.b, ce7.g(), z);
                    if (z) {
                        abstractC17457n0H2 = c8445Vz5Y.r();
                    }
                }
                AbstractC17457n0 abstractC17457n0 = abstractC17457n0H2;
                C8445Vz5 c8445Vz5 = c8445Vz5Y;
                long jH = ce7.h();
                long jA = ce7.a();
                long jA2 = ce7.a();
                int i = ce7.i();
                EnumC23558x74 enumC23558x74 = this.b.i0() == ce7.i() ? EnumC23558x74.SENT : EnumC23558x74.UNKNOWN;
                AbstractC13042fc3.f(abstractC17457n0);
                J44 j44 = new J44(jH, jA, jA2, i, enumC23558x74, abstractC17457n0, new ArrayList(), 0, c8445Vz5, null, 0L, ce7.f(), null, false, ce7.b(), null, false, ce7.j(), null, 360448, null);
                C7880To7 c7880To7J2 = ce7.j();
                B(j44, c7880To7J2 != null ? c7880To7J2.i() : 0L);
                return true;
            }
        }
        return true;
    }
}
