package androidx.compose.foundation;

import ir.nasim.AbstractC10865cK6;
import ir.nasim.AbstractC5999Lt;
import ir.nasim.BU3;
import ir.nasim.C7479Rw7;
import ir.nasim.DU3;
import ir.nasim.InterfaceC5766Kt;
import ir.nasim.T22;
import ir.nasim.WH1;

/* loaded from: classes.dex */
public abstract class d {
    public static final androidx.compose.ui.e b(androidx.compose.ui.e eVar, int i, int i2, int i3, int i4, DU3 du3, float f) {
        return eVar.i(new MarqueeModifierElement(i, i2, i3, i4, du3, f, null));
    }

    public static /* synthetic */ androidx.compose.ui.e c(androidx.compose.ui.e eVar, int i, int i2, int i3, int i4, DU3 du3, float f, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = BU3.a.a();
        }
        if ((i5 & 2) != 0) {
            i2 = p.b.a();
        }
        int i6 = i2;
        if ((i5 & 4) != 0) {
            i3 = BU3.a.b();
        }
        int i7 = i3;
        if ((i5 & 8) != 0) {
            i4 = p.f(i6, p.b.a()) ? i7 : 0;
        }
        int i8 = i4;
        if ((i5 & 16) != 0) {
            du3 = BU3.a.c();
        }
        DU3 du32 = du3;
        if ((i5 & 32) != 0) {
            f = BU3.a.d();
        }
        return b(eVar, i, i6, i7, i8, du32, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC5766Kt d(int i, float f, int i2, int i3, float f2, WH1 wh1) {
        C7479Rw7 c7479Rw7E = e(Math.abs(wh1.w1(f2)), f, i3);
        long jC = AbstractC10865cK6.c((-i3) + i2, 0, 2, null);
        return i == Integer.MAX_VALUE ? AbstractC5999Lt.e(c7479Rw7E, null, jC, 2, null) : AbstractC5999Lt.h(i, c7479Rw7E, null, jC, 4, null);
    }

    private static final C7479Rw7 e(float f, float f2, int i) {
        return AbstractC5999Lt.k((int) Math.ceil(f2 / (f / 1000.0f)), i, T22.e());
    }
}
