package ir.nasim;

/* renamed from: ir.nasim.r91, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19913r91 {
    public static final C19913r91 a = new C19913r91();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(-719537850, false, a.a);
    public static InterfaceC14603iB2 c = AbstractC19242q11.c(-1419604220, false, b.a);
    public static InterfaceC14603iB2 d = AbstractC19242q11.c(-810993288, false, c.a);

    /* renamed from: ir.nasim.r91$a */
    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            AbstractC24667z03.b(FV4.c(KB5.alert, interfaceC22053ub1, 0), null, androidx.compose.foundation.layout.t.t(androidx.compose.ui.e.a, C17784nZ1.q(56)), G10.a.a(interfaceC22053ub1, G10.b).p(), interfaceC22053ub1, 432, 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.r91$b */
    static final class b implements InterfaceC14603iB2 {
        public static final b a = new b();

        b() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC19555qZ.c0(AbstractC12217eE5.shaparak_close_description, interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.r91$c */
    static final class c implements InterfaceC14603iB2 {
        public static final c a = new c();

        c() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC19555qZ.v0(UY6.c(AbstractC12217eE5.safe_connect_to_shaparak, interfaceC22053ub1, 0), null, FV4.c(KB5.blue_tick_old, interfaceC22053ub1, 0), null, C24381yX0.b.i(), interfaceC22053ub1, 27648, 2);
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

    public final InterfaceC14603iB2 c() {
        return d;
    }
}
