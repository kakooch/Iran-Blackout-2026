package ir.nasim;

import androidx.compose.foundation.ScrollingLayoutElement;

/* renamed from: ir.nasim.Ud6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC8014Ud6 {

    /* renamed from: ir.nasim.Ud6$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ int e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i) {
            super(0);
            this.e = i;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C9023Yd6 invoke() {
            return new C9023Yd6(this.e);
        }
    }

    public static final androidx.compose.ui.e a(androidx.compose.ui.e eVar, C9023Yd6 c9023Yd6, boolean z, InterfaceC7645Sp2 interfaceC7645Sp2, boolean z2) {
        return e(eVar, c9023Yd6, z2, interfaceC7645Sp2, z, false, true, null, 64, null);
    }

    public static /* synthetic */ androidx.compose.ui.e b(androidx.compose.ui.e eVar, C9023Yd6 c9023Yd6, boolean z, InterfaceC7645Sp2 interfaceC7645Sp2, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            interfaceC7645Sp2 = null;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        return a(eVar, c9023Yd6, z, interfaceC7645Sp2, z2);
    }

    public static final C9023Yd6 c(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2, int i3) {
        boolean z = true;
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1464256199, i2, -1, "androidx.compose.foundation.rememberScrollState (Scroll.kt:68)");
        }
        Object[] objArr = new Object[0];
        InterfaceC8230Vb6 interfaceC8230Vb6A = C9023Yd6.i.a();
        if ((((i2 & 14) ^ 6) <= 4 || !interfaceC22053ub1.e(i)) && (i2 & 6) != 4) {
            z = false;
        }
        Object objB = interfaceC22053ub1.B();
        if (z || objB == InterfaceC22053ub1.a.a()) {
            objB = new a(i);
            interfaceC22053ub1.s(objB);
        }
        C9023Yd6 c9023Yd6 = (C9023Yd6) AbstractC9681aN5.e(objArr, interfaceC8230Vb6A, null, (SA2) objB, interfaceC22053ub1, 0, 4);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return c9023Yd6;
    }

    private static final androidx.compose.ui.e d(androidx.compose.ui.e eVar, C9023Yd6 c9023Yd6, boolean z, InterfaceC7645Sp2 interfaceC7645Sp2, boolean z2, boolean z3, boolean z4, InterfaceC14124hO4 interfaceC14124hO4) {
        return androidx.compose.foundation.r.a(eVar, c9023Yd6, z3 ? EnumC24286yM4.a : EnumC24286yM4.b, z2, z, interfaceC7645Sp2, c9023Yd6.m(), z4, interfaceC14124hO4, (256 & 256) != 0 ? null : null).i(new ScrollingLayoutElement(c9023Yd6, z, z3));
    }

    static /* synthetic */ androidx.compose.ui.e e(androidx.compose.ui.e eVar, C9023Yd6 c9023Yd6, boolean z, InterfaceC7645Sp2 interfaceC7645Sp2, boolean z2, boolean z3, boolean z4, InterfaceC14124hO4 interfaceC14124hO4, int i, Object obj) {
        return d(eVar, c9023Yd6, z, interfaceC7645Sp2, z2, z3, z4, (i & 64) != 0 ? null : interfaceC14124hO4);
    }

    public static final androidx.compose.ui.e f(androidx.compose.ui.e eVar, C9023Yd6 c9023Yd6, boolean z, InterfaceC7645Sp2 interfaceC7645Sp2, boolean z2) {
        return e(eVar, c9023Yd6, z2, interfaceC7645Sp2, z, true, true, null, 64, null);
    }

    public static /* synthetic */ androidx.compose.ui.e g(androidx.compose.ui.e eVar, C9023Yd6 c9023Yd6, boolean z, InterfaceC7645Sp2 interfaceC7645Sp2, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            interfaceC7645Sp2 = null;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        return f(eVar, c9023Yd6, z, interfaceC7645Sp2, z2);
    }
}
