package ir.nasim;

import androidx.compose.ui.e;

/* renamed from: ir.nasim.Qk0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC7130Qk0 {

    /* renamed from: ir.nasim.Qk0$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC11379cu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(SA2 sa2, InterfaceC11379cu3 interfaceC11379cu3) {
            super(0);
            this.e = sa2;
            this.f = interfaceC11379cu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CK5 invoke() {
            CK5 ck5;
            SA2 sa2 = this.e;
            if (sa2 != null && (ck5 = (CK5) sa2.invoke()) != null) {
                return ck5;
            }
            InterfaceC11379cu3 interfaceC11379cu3 = this.f;
            if (!interfaceC11379cu3.b()) {
                interfaceC11379cu3 = null;
            }
            if (interfaceC11379cu3 != null) {
                return UD6.c(AbstractC4663Ga3.d(interfaceC11379cu3.a()));
            }
            return null;
        }
    }

    public static final Object a(JG1 jg1, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object obj;
        VA4 va4T0;
        if (!jg1.h().b2()) {
            return C19938rB7.a;
        }
        int iA = AbstractC9572aB4.a(524288);
        if (!jg1.h().b2()) {
            M73.b("visitAncestors called on an unattached node");
        }
        e.c cVarY1 = jg1.h().Y1();
        C3419Au3 c3419Au3O = KG1.o(jg1);
        loop0: while (true) {
            obj = null;
            if (c3419Au3O == null) {
                break;
            }
            if ((c3419Au3O.t0().k().R1() & iA) != 0) {
                while (cVarY1 != null) {
                    if ((cVarY1.W1() & iA) != 0) {
                        e.c cVarH = cVarY1;
                        C12544en4 c12544en4 = null;
                        while (cVarH != null) {
                            if (cVarH instanceof InterfaceC6886Pk0) {
                                obj = cVarH;
                                break loop0;
                            }
                            if ((cVarH.W1() & iA) != 0 && (cVarH instanceof RG1)) {
                                int i = 0;
                                for (e.c cVarW2 = ((RG1) cVarH).w2(); cVarW2 != null; cVarW2 = cVarW2.S1()) {
                                    if ((cVarW2.W1() & iA) != 0) {
                                        i++;
                                        if (i == 1) {
                                            cVarH = cVarW2;
                                        } else {
                                            if (c12544en4 == null) {
                                                c12544en4 = new C12544en4(new e.c[16], 0);
                                            }
                                            if (cVarH != null) {
                                                AbstractC6392Nk0.a(c12544en4.d(cVarH));
                                                cVarH = null;
                                            }
                                            AbstractC6392Nk0.a(c12544en4.d(cVarW2));
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            cVarH = KG1.h(c12544en4);
                        }
                    }
                    cVarY1 = cVarY1.Y1();
                }
            }
            c3419Au3O = c3419Au3O.A0();
            cVarY1 = (c3419Au3O == null || (va4T0 = c3419Au3O.t0()) == null) ? null : va4T0.p();
        }
        InterfaceC6886Pk0 interfaceC6886Pk0 = (InterfaceC6886Pk0) obj;
        if (interfaceC6886Pk0 == null) {
            return C19938rB7.a;
        }
        InterfaceC11379cu3 interfaceC11379cu3M = KG1.m(jg1);
        Object objQ1 = interfaceC6886Pk0.q1(interfaceC11379cu3M, new a(sa2, interfaceC11379cu3M), interfaceC20295rm1);
        return objQ1 == AbstractC14862ic3.e() ? objQ1 : C19938rB7.a;
    }

    public static /* synthetic */ Object b(JG1 jg1, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1, int i, Object obj) {
        if ((i & 1) != 0) {
            sa2 = null;
        }
        return a(jg1, sa2, interfaceC20295rm1);
    }
}
