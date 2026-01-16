package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.Yw3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC9191Yw3 {
    public static final C18024nx3 a(C19206px3 c19206px3, InterfaceC14603iB2 interfaceC14603iB2, float f, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        AbstractC13042fc3.i(c19206px3, "lazyListState");
        interfaceC22053ub1.A(-1050829263);
        if ((i2 & 2) != 0) {
            interfaceC14603iB2 = DG6.a.a();
        }
        InterfaceC14603iB2 interfaceC14603iB22 = interfaceC14603iB2;
        if ((i2 & 4) != 0) {
            f = C17784nZ1.q(0);
        }
        interfaceC22053ub1.A(-3686552);
        boolean zV = interfaceC22053ub1.V(c19206px3) | interfaceC22053ub1.V(interfaceC14603iB22);
        Object objB = interfaceC22053ub1.B();
        if (zV || objB == InterfaceC22053ub1.a.a()) {
            objB = new C18024nx3(c19206px3, interfaceC14603iB22, 0, 4, null);
            interfaceC22053ub1.s(objB);
        }
        interfaceC22053ub1.U();
        C18024nx3 c18024nx3 = (C18024nx3) objB;
        c18024nx3.o(((WH1) interfaceC22053ub1.H(AbstractC13040fc1.g())).B0(f));
        interfaceC22053ub1.U();
        return c18024nx3;
    }

    public static final IG6 b(C19206px3 c19206px3, InterfaceC14603iB2 interfaceC14603iB2, float f, InterfaceC10163bB1 interfaceC10163bB1, InterfaceC5766Kt interfaceC5766Kt, InterfaceC15796kB2 interfaceC15796kB2, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        AbstractC13042fc3.i(c19206px3, "lazyListState");
        AbstractC13042fc3.i(interfaceC15796kB2, "snapIndex");
        interfaceC22053ub1.A(-632875458);
        IG6 ig6A = KG6.a(a(c19206px3, (i2 & 2) != 0 ? DG6.a.a() : interfaceC14603iB2, (i2 & 4) != 0 ? C17784nZ1.q(0) : f, interfaceC22053ub1, (i & 14) | (i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i & 896), 0), (i2 & 8) != 0 ? LI6.b(interfaceC22053ub1, 0) : interfaceC10163bB1, (i2 & 16) != 0 ? JG6.a.b() : interfaceC5766Kt, interfaceC15796kB2, interfaceC22053ub1, ((i >> 6) & 7168) | 576, 0);
        interfaceC22053ub1.U();
        return ig6A;
    }
}
