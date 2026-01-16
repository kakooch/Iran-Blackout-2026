package ir.nasim;

/* renamed from: ir.nasim.i51, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C14543i51 {
    public static final C14543i51 a = new C14543i51();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(-1643961025, false, a.a);

    /* renamed from: ir.nasim.i51$a */
    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC19555qZ.O(interfaceC22053ub1, 0);
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
