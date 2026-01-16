package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.g61, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C13364g61 {
    public static final C13364g61 a = new C13364g61();
    public static InterfaceC15796kB2 b = AbstractC19242q11.c(2137747990, false, a.a);
    public static InterfaceC15796kB2 c = AbstractC19242q11.c(998848070, false, b.a);
    public static InterfaceC14603iB2 d = AbstractC19242q11.c(519267596, false, c.a);

    /* renamed from: ir.nasim.g61$a */
    static final class a implements InterfaceC15796kB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(L66 l66, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(l66, "$this$SwipeToDismissBox");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((L66) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.g61$b */
    static final class b implements InterfaceC15796kB2 {
        public static final b a = new b();

        b() {
        }

        public final void a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            AbstractC13042fc3.i(eVar, "it");
            if ((i & 6) == 0) {
                i2 = i | (interfaceC22053ub1.V(eVar) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            String strC = UY6.c(UD5.install_description, interfaceC22053ub1, 0);
            G10 g10 = G10.a;
            int i3 = G10.b;
            AbstractC9339Zm7.b(strC, eVar, g10.a(interfaceC22053ub1, i3).F(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i3).d(), interfaceC22053ub1, (i2 << 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, 0, 65528);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.g61$c */
    static final class c implements InterfaceC14603iB2 {
        public static final c a = new c();

        c() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            EV4 ev4C = FV4.c(AbstractC24188yB5.icon_close, interfaceC22053ub1, 0);
            G10 g10 = G10.a;
            int i2 = G10.b;
            AbstractC24077y03.b(ev4C, UY6.c(UD5.close_content_description, interfaceC22053ub1, 0), androidx.compose.foundation.layout.t.t(androidx.compose.ui.e.a, g10.c(interfaceC22053ub1, i2).b().j()), g10.a(interfaceC22053ub1, i2).B(), interfaceC22053ub1, 0, 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public final InterfaceC15796kB2 a() {
        return b;
    }

    public final InterfaceC15796kB2 b() {
        return c;
    }

    public final InterfaceC14603iB2 c() {
        return d;
    }
}
