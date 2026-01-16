package ir.nasim;

import ir.nasim.AbstractC9998au2;

/* renamed from: ir.nasim.qn7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC19702qn7 {
    private static final int a = 8;

    public static final C19111pn7 a(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2, int i3) {
        boolean z = true;
        if ((i3 & 1) != 0) {
            i = a;
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1538166871, i2, -1, "androidx.compose.ui.text.rememberTextMeasurer (TextMeasurerHelper.kt:41)");
        }
        AbstractC9998au2.b bVar = (AbstractC9998au2.b) interfaceC22053ub1.H(AbstractC13040fc1.i());
        WH1 wh1 = (WH1) interfaceC22053ub1.H(AbstractC13040fc1.g());
        EnumC12613eu3 enumC12613eu3 = (EnumC12613eu3) interfaceC22053ub1.H(AbstractC13040fc1.n());
        boolean zV = interfaceC22053ub1.V(bVar) | interfaceC22053ub1.V(wh1) | interfaceC22053ub1.V(enumC12613eu3);
        if ((((i2 & 14) ^ 6) <= 4 || !interfaceC22053ub1.e(i)) && (i2 & 6) != 4) {
            z = false;
        }
        boolean z2 = zV | z;
        Object objB = interfaceC22053ub1.B();
        if (z2 || objB == InterfaceC22053ub1.a.a()) {
            objB = new C19111pn7(bVar, wh1, enumC12613eu3, i);
            interfaceC22053ub1.s(objB);
        }
        C19111pn7 c19111pn7 = (C19111pn7) objB;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return c19111pn7;
    }
}
