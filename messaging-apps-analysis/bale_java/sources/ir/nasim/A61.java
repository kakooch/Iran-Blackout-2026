package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* loaded from: classes4.dex */
public final class A61 {
    public static final A61 a = new A61();
    public static InterfaceC15796kB2 b = AbstractC19242q11.c(-1593725657, false, a.a);
    public static InterfaceC15796kB2 c = AbstractC19242q11.c(233424753, false, b.a);

    static final class a implements InterfaceC15796kB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(InterfaceC22821vt interfaceC22821vt, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC22821vt, "$this$AnimatedVisibility");
            ZH6.a(androidx.compose.foundation.layout.t.t(androidx.compose.ui.e.a, C17784nZ1.q(12)), interfaceC22053ub1, 6);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC22821vt) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    static final class b implements InterfaceC15796kB2 {
        public static final b a = new b();

        b() {
        }

        public final void a(L66 l66, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(l66, "$this$TextButton");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC9339Zm7.b(UY6.c(AbstractC12217eE5.feedback_cancel, interfaceC22053ub1, 0), null, WX0.a(IA5.color8, interfaceC22053ub1, 0), AbstractC13784go7.g(16), null, null, M10.q(), 0L, null, null, 0L, 0, false, 1, 0, null, null, interfaceC22053ub1, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 122802);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((L66) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public final InterfaceC15796kB2 a() {
        return b;
    }

    public final InterfaceC15796kB2 b() {
        return c;
    }
}
