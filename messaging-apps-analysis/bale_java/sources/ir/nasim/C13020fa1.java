package ir.nasim;

/* renamed from: ir.nasim.fa1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C13020fa1 {
    public static final C13020fa1 a = new C13020fa1();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(-1799493836, false, a.a);

    /* renamed from: ir.nasim.fa1$a */
    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                Y07.m(interfaceC22053ub1, 0);
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
