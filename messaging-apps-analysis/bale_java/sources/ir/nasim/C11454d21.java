package ir.nasim;

/* renamed from: ir.nasim.d21, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C11454d21 {
    public static final C11454d21 a = new C11454d21();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(-1385019876, false, a.a);

    /* renamed from: ir.nasim.d21$a */
    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                QX.e(new C17720nS0(UD5.preview_title, true, false, null, null, 28, null), androidx.compose.foundation.b.d(androidx.compose.ui.e.a, G10.a.a(interfaceC22053ub1, 6).r(), null, 2, null), interfaceC22053ub1, 0, 0);
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
