package ir.nasim;

/* renamed from: ir.nasim.i81, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14573i81 {
    public static final C14573i81 a = new C14573i81();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(688463557, false, a.a);

    /* renamed from: ir.nasim.i81$a */
    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC10623bv0.p(interfaceC22053ub1, 0);
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
}
