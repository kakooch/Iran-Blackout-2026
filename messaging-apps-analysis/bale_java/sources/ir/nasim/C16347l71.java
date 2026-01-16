package ir.nasim;

import ir.nasim.C16347l71;

/* renamed from: ir.nasim.l71, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C16347l71 {
    public static final C16347l71 a = new C16347l71();
    public static InterfaceC15796kB2 b = AbstractC19242q11.c(-1824551060, false, a.a);

    /* renamed from: ir.nasim.l71$a */
    static final class a implements InterfaceC15796kB2 {
        public static final a a = new a();

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(InterfaceC15254jG6 interfaceC15254jG6, boolean z) {
            AbstractC13042fc3.i(interfaceC15254jG6, "$snackBar");
            interfaceC15254jG6.dismiss();
            return C19938rB7.a;
        }

        public final void b(final InterfaceC15254jG6 interfaceC15254jG6, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC15254jG6, "snackBar");
            if ((i & 6) == 0) {
                i |= interfaceC22053ub1.V(interfaceC15254jG6) ? 4 : 2;
            }
            if ((i & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            String strB = interfaceC15254jG6.a().b();
            interfaceC22053ub1.W(-1088637128);
            boolean z = (i & 14) == 4;
            Object objB = interfaceC22053ub1.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.k71
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C16347l71.a.c(interfaceC15254jG6, ((Boolean) obj).booleanValue());
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC10984cY.c(strB, null, null, 0, (UA2) objB, interfaceC22053ub1, 0, 14);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((InterfaceC15254jG6) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public final InterfaceC15796kB2 a() {
        return b;
    }
}
