package ir.nasim;

import com.skydoves.balloon.compose.BalloonComposeView;

/* renamed from: ir.nasim.z21, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C24685z21 {
    public static final C24685z21 a = new C24685z21();
    public static InterfaceC15796kB2 b = AbstractC19242q11.c(-1734990613, false, a.e);

    /* renamed from: ir.nasim.z21$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        public static final a e = new a();

        a() {
            super(3);
        }

        public final void a(BalloonComposeView balloonComposeView, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(balloonComposeView, "it");
            if ((i & 81) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1734990613, i, -1, "com.skydoves.balloon.compose.ComposableSingletons$BalloonComposeViewKt.lambda-1.<anonymous> (BalloonComposeView.kt:78)");
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((BalloonComposeView) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public final InterfaceC15796kB2 a() {
        return b;
    }
}
