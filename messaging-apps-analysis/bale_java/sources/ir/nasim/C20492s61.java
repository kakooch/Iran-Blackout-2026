package ir.nasim;

import ir.nasim.C20492s61;
import ir.nasim.InterfaceC7975Tz3;

/* renamed from: ir.nasim.s61, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C20492s61 {
    public static final C20492s61 a = new C20492s61();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(27193370, false, a.a);
    public static InterfaceC14603iB2 c = AbstractC19242q11.c(729394010, false, b.a);

    /* renamed from: ir.nasim.s61$a */
    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(InterfaceC7975Tz3 interfaceC7975Tz3) {
            AbstractC13042fc3.i(interfaceC7975Tz3, "it");
            return C19938rB7.a;
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            InterfaceC7975Tz3.a aVar = new InterfaceC7975Tz3.a(null, 0, 3, null);
            interfaceC22053ub1.W(-1770984786);
            Object objB = interfaceC22053ub1.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.r61
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C20492s61.a.c((InterfaceC7975Tz3) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC7502Rz3.d(null, 0.5f, "18MB/20MB", aVar, (UA2) objB, interfaceC22053ub1, 25008, 1);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.s61$b */
    static final class b implements InterfaceC14603iB2 {
        public static final b a = new b();

        b() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.b), C20492s61.a.a(), interfaceC22053ub1, C7252Qx5.i | 48);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public final InterfaceC14603iB2 a() {
        return b;
    }

    public final InterfaceC14603iB2 b() {
        return c;
    }
}
