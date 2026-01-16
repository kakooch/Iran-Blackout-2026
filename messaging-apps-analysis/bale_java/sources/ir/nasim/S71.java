package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;

/* loaded from: classes7.dex */
public final class S71 {
    public static final S71 a = new S71();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(-440027230, false, a.a);
    public static InterfaceC14603iB2 c = AbstractC19242q11.c(1613131527, false, b.a);

    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                androidx.compose.foundation.layout.f.a(androidx.compose.foundation.layout.t.v(androidx.compose.ui.e.a, C17784nZ1.q(44), G10.a.c(interfaceC22053ub1, G10.b).b().n()), interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class b implements InterfaceC14603iB2 {
        public static final b a = new b();

        b() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            G10 g10 = G10.a;
            int i2 = G10.b;
            F27.a(androidx.compose.foundation.layout.q.m(aVar, 0.0f, g10.c(interfaceC22053ub1, i2).b().e(), 0.0f, g10.c(interfaceC22053ub1, i2).b().b(), 5, null), C15386jV3.a.b(interfaceC22053ub1, C15386jV3.b).a(), g10.a(interfaceC22053ub1, i2).E(), 0L, 0.0f, 0.0f, null, S71.a.a(), interfaceC22053ub1, 12582912, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
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
