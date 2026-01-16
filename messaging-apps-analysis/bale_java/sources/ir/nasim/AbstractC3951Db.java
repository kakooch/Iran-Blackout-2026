package ir.nasim;

import androidx.compose.ui.platform.ComposeView;

/* renamed from: ir.nasim.Db, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC3951Db {

    /* renamed from: ir.nasim.Db$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ String a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ SA2 c;

        /* renamed from: ir.nasim.Db$a$a, reason: collision with other inner class name */
        static final class C0323a implements InterfaceC14603iB2 {
            final /* synthetic */ String a;
            final /* synthetic */ SA2 b;
            final /* synthetic */ SA2 c;

            C0323a(String str, SA2 sa2, SA2 sa22) {
                this.a = str;
                this.b = sa2;
                this.c = sa22;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    V03.c(androidx.compose.foundation.layout.c.b(androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.i(androidx.compose.ui.e.a, G10.a.c(interfaceC22053ub1, G10.b).b().e()), 0.0f, 1, null), 4.4186f, false, 2, null), this.a, null, this.b, this.c, null, null, interfaceC22053ub1, 0, 100);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a(String str, SA2 sa2, SA2 sa22) {
            this.a = str;
            this.b = sa2;
            this.c = sa22;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(-278009491, true, new C0323a(this.a, this.b, this.c), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void a(ComposeView composeView, String str, SA2 sa2, SA2 sa22) {
        AbstractC13042fc3.i(composeView, "<this>");
        AbstractC13042fc3.i(str, "bannerUrl");
        AbstractC13042fc3.i(sa2, "onBannerClick");
        composeView.setContent(AbstractC19242q11.c(-1368985528, true, new a(str, sa2, sa22)));
    }
}
