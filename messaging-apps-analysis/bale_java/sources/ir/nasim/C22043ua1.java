package ir.nasim;

import ir.nasim.C22043ua1;

/* renamed from: ir.nasim.ua1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C22043ua1 {
    public static final C22043ua1 a = new C22043ua1();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(-945347009, false, a.a);
    public static InterfaceC14603iB2 c = AbstractC19242q11.c(-2135088385, false, b.a);

    /* renamed from: ir.nasim.ua1$a */
    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C23546x62 c(String str) {
            AbstractC13042fc3.i(str, "it");
            return new C23546x62(new C13245fu(str, null, 2, null), null, 2, null);
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null);
            int iF = C6399Nk7.b.f();
            G10 g10 = G10.a;
            C23283wf5 c23283wf5W = g10.d(interfaceC22053ub1, 6).a().w();
            AbstractC9998au2 abstractC9998au2J = g10.d(interfaceC22053ub1, 6).a().j();
            C4593Fu2 c4593Fu2O = g10.d(interfaceC22053ub1, 6).a().o();
            C9348Zn7 c9348Zn7 = new C9348Zn7(g10.a(interfaceC22053ub1, 6).F(), g10.d(interfaceC22053ub1, 6).a().l(), c4593Fu2O, (C3418Au2) null, (C3657Bu2) null, abstractC9998au2J, (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, (C24525yl7) null, (C5566Jw6) null, (AbstractC18051o02) null, iF, 0, g10.d(interfaceC22053ub1, 6).a().s(), (C5477Jm7) null, c23283wf5W, (C4888Gz3) null, 0, 0, (C22179un7) null, 16089048, (ED1) null);
            EnumC5594Jz7 enumC5594Jz7 = EnumC5594Jz7.e;
            interfaceC22053ub1.W(-1017910750);
            Object objB = interfaceC22053ub1.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.ta1
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C22043ua1.a.c((String) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC3707Bz7.f(eVarH, (UA2) objB, "لورم ایپسوم ساختگی با تولید سادگی.", c9348Zn7, 0, false, 0, 0, null, null, 7000L, enumC5594Jz7, true, false, false, false, null, null, null, interfaceC22053ub1, 438, 25014, 500720);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ua1$b */
    static final class b implements InterfaceC14603iB2 {
        public static final b a = new b();

        b() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.b), C22043ua1.a.a(), interfaceC22053ub1, C7252Qx5.i | 48);
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
