package ir.nasim;

import coil.compose.AsyncImagePainter;
import io.appmetrica.analytics.AppMetricaDefaultValues;

/* renamed from: ir.nasim.x71, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C23555x71 {
    public static final C23555x71 a = new C23555x71();
    public static InterfaceC16978mB2 b = AbstractC19242q11.c(1830142075, false, a.a);

    /* renamed from: ir.nasim.x71$a */
    static final class a implements InterfaceC16978mB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(RZ6 rz6, AsyncImagePainter.State.Loading loading, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(rz6, "$this$SubcomposeAsyncImage");
            AbstractC13042fc3.i(loading, "it");
            if ((i & 129) == 128 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                androidx.compose.foundation.layout.f.a(AbstractC21704tz6.a(androidx.compose.foundation.layout.t.f(FV0.a(androidx.compose.ui.e.a, N46.d(G10.a.c(interfaceC22053ub1, G10.b).a().b())), 0.0f, 1, null), (255 & 1) != 0 ? AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT : 0, (255 & 2) != 0 ? 0 : 0, (255 & 4) == 0 ? 0 : 0, (255 & 8) != 0 ? C19938rB7.a : null, (255 & 16) != 0 ? null : null, (255 & 32) != 0 ? EnumC14086hK2.b : null, (255 & 64) != 0 ? AbstractC4553Fp7.a.a() : 0, (255 & 128) != 0), interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            a((RZ6) obj, (AsyncImagePainter.State.Loading) obj2, (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    public final InterfaceC16978mB2 a() {
        return b;
    }
}
