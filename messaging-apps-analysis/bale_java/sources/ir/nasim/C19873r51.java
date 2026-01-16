package ir.nasim;

import androidx.compose.ui.e;

/* renamed from: ir.nasim.r51, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C19873r51 {
    public static final C19873r51 a = new C19873r51();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(-1882373716, false, a.a);

    /* renamed from: ir.nasim.r51$a */
    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            G10 g10 = G10.a;
            int i2 = G10.b;
            AbstractC24077y03.b(FV4.c(IB5.more_menu, interfaceC22053ub1, 0), UY6.c(AbstractC24206yD5.more_items_content_description, interfaceC22053ub1, 0), androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1, i2).b().j()), g10.a(interfaceC22053ub1, i2).D(), interfaceC22053ub1, 0, 0);
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
