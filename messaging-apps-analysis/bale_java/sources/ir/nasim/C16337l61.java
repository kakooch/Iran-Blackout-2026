package ir.nasim;

/* renamed from: ir.nasim.l61, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C16337l61 {
    public static final C16337l61 a = new C16337l61();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(893651987, false, a.a);
    public static InterfaceC14603iB2 c = AbstractC19242q11.c(-1895524830, false, b.a);

    /* renamed from: ir.nasim.l61$a */
    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC24077y03.b(FV4.c(KB5.ic_call_close, interfaceC22053ub1, 0), "Clear", null, WX0.a(TA5.color8, interfaceC22053ub1, 0), interfaceC22053ub1, 48, 4);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.l61$b */
    static final class b implements InterfaceC14603iB2 {
        public static final b a = new b();

        b() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC24077y03.b(FV4.c(KB5.ic_back_voice_call_new, interfaceC22053ub1, 0), "", null, WX0.a(TA5.color8, interfaceC22053ub1, 0), interfaceC22053ub1, 48, 4);
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
