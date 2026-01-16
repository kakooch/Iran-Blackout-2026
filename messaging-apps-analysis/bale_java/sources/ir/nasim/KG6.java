package ir.nasim;

/* loaded from: classes3.dex */
public abstract class KG6 {
    public static final IG6 a(LG6 lg6, InterfaceC10163bB1 interfaceC10163bB1, InterfaceC5766Kt interfaceC5766Kt, InterfaceC15796kB2 interfaceC15796kB2, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        AbstractC13042fc3.i(lg6, "layoutInfo");
        AbstractC13042fc3.i(interfaceC15796kB2, "snapIndex");
        interfaceC22053ub1.A(-632874525);
        int i3 = 0;
        if ((i2 & 2) != 0) {
            interfaceC10163bB1 = LI6.b(interfaceC22053ub1, 0);
        }
        if ((i2 & 4) != 0) {
            interfaceC5766Kt = JG6.a.b();
        }
        Object[] objArr = {lg6, interfaceC10163bB1, interfaceC5766Kt, interfaceC15796kB2};
        interfaceC22053ub1.A(-3685570);
        boolean zV = false;
        while (i3 < 4) {
            Object obj = objArr[i3];
            i3++;
            zV |= interfaceC22053ub1.V(obj);
        }
        Object objB = interfaceC22053ub1.B();
        if (zV || objB == InterfaceC22053ub1.a.a()) {
            objB = new IG6(lg6, interfaceC10163bB1, interfaceC5766Kt, interfaceC15796kB2);
            interfaceC22053ub1.s(objB);
        }
        interfaceC22053ub1.U();
        IG6 ig6 = (IG6) objB;
        interfaceC22053ub1.U();
        return ig6;
    }
}
