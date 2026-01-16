package ir.nasim;

/* renamed from: ir.nasim.b61, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C10114b61 {
    public static final C10114b61 a = new C10114b61();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(-174925394, false, a.a);

    /* renamed from: ir.nasim.b61$a */
    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
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
