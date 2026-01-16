package ir.nasim;

import ir.nasim.C9530a71;

/* renamed from: ir.nasim.a71, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C9530a71 {
    public static final C9530a71 a = new C9530a71();
    public static InterfaceC15796kB2 b = AbstractC19242q11.c(460478830, false, a.a);
    public static InterfaceC15796kB2 c = AbstractC19242q11.c(-1563983620, false, b.a);
    public static InterfaceC15796kB2 d = AbstractC19242q11.c(-527520319, false, c.a);
    public static InterfaceC15796kB2 e = AbstractC19242q11.c(1148087075, false, d.a);

    /* renamed from: ir.nasim.a71$a */
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
            interfaceC22053ub1.W(433872350);
            boolean z = (i & 14) == 4;
            Object objB = interfaceC22053ub1.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.Z61
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C9530a71.a.c(interfaceC15254jG6, ((Boolean) obj).booleanValue());
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

    /* renamed from: ir.nasim.a71$b */
    static final class b implements InterfaceC15796kB2 {
        public static final b a = new b();

        b() {
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC9459a00.c(null, UY6.c(QD5.new_setting_notif_chats, interfaceC22053ub1, 0), null, interfaceC22053ub1, 0, 5);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.a71$c */
    static final class c implements InterfaceC15796kB2 {
        public static final c a = new c();

        c() {
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC9459a00.c(null, UY6.c(QD5.new_setting_notif_story, interfaceC22053ub1, 0), null, interfaceC22053ub1, 0, 5);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.a71$d */
    static final class d implements InterfaceC15796kB2 {
        public static final d a = new d();

        d() {
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC9459a00.c(null, UY6.c(QD5.new_setting_personalize_notif, interfaceC22053ub1, 0), null, interfaceC22053ub1, 0, 5);
                MY2.b(null, null, 0L, interfaceC22053ub1, 0, 7);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public final InterfaceC15796kB2 a() {
        return b;
    }

    public final InterfaceC15796kB2 b() {
        return c;
    }

    public final InterfaceC15796kB2 c() {
        return d;
    }

    public final InterfaceC15796kB2 d() {
        return e;
    }
}
