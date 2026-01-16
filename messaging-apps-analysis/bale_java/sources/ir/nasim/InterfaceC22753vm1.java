package ir.nasim;

import ir.nasim.InterfaceC11938do1;

/* renamed from: ir.nasim.vm1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public interface InterfaceC22753vm1 extends InterfaceC11938do1.b {
    public static final b g0 = b.a;

    /* renamed from: ir.nasim.vm1$a */
    public static final class a {
        public static InterfaceC11938do1.b a(InterfaceC22753vm1 interfaceC22753vm1, InterfaceC11938do1.c cVar) {
            AbstractC13042fc3.i(cVar, "key");
            if (!(cVar instanceof M0)) {
                if (InterfaceC22753vm1.g0 != cVar) {
                    return null;
                }
                AbstractC13042fc3.g(interfaceC22753vm1, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return interfaceC22753vm1;
            }
            M0 m0 = (M0) cVar;
            if (!m0.a(interfaceC22753vm1.getKey())) {
                return null;
            }
            InterfaceC11938do1.b bVarB = m0.b(interfaceC22753vm1);
            if (bVarB instanceof InterfaceC11938do1.b) {
                return bVarB;
            }
            return null;
        }

        public static InterfaceC11938do1 b(InterfaceC22753vm1 interfaceC22753vm1, InterfaceC11938do1.c cVar) {
            AbstractC13042fc3.i(cVar, "key");
            if (!(cVar instanceof M0)) {
                return InterfaceC22753vm1.g0 == cVar ? C18712p72.a : interfaceC22753vm1;
            }
            M0 m0 = (M0) cVar;
            return (!m0.a(interfaceC22753vm1.getKey()) || m0.b(interfaceC22753vm1) == null) ? interfaceC22753vm1 : C18712p72.a;
        }
    }

    /* renamed from: ir.nasim.vm1$b */
    public static final class b implements InterfaceC11938do1.c {
        static final /* synthetic */ b a = new b();

        private b() {
        }
    }

    InterfaceC20295rm1 m0(InterfaceC20295rm1 interfaceC20295rm1);

    void u(InterfaceC20295rm1 interfaceC20295rm1);
}
