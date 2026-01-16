package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* loaded from: classes.dex */
public abstract class E52 {
    private static final K22 a;
    private static final C7479Rw7 b;
    private static final C7479Rw7 c;
    private static final C7479Rw7 d;

    static {
        C11397cw1 c11397cw1 = new C11397cw1(0.4f, 0.0f, 0.6f, 1.0f);
        a = c11397cw1;
        b = new C7479Rw7(SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER, 0, T22.d(), 2, null);
        c = new C7479Rw7(150, 0, c11397cw1, 2, null);
        d = new C7479Rw7(SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER, 0, c11397cw1, 2, null);
    }

    public static final Object d(C15607js c15607js, float f, InterfaceC22645vb3 interfaceC22645vb3, InterfaceC22645vb3 interfaceC22645vb32, InterfaceC20295rm1 interfaceC20295rm1) {
        InterfaceC5766Kt interfaceC5766KtA = interfaceC22645vb32 != null ? C52.a.a(interfaceC22645vb32) : interfaceC22645vb3 != null ? C52.a.b(interfaceC22645vb3) : null;
        if (interfaceC5766KtA != null) {
            Object objH = C15607js.h(c15607js, C17784nZ1.j(f), interfaceC5766KtA, null, null, interfaceC20295rm1, 12, null);
            return objH == AbstractC14862ic3.e() ? objH : C19938rB7.a;
        }
        Object objX = c15607js.x(C17784nZ1.j(f), interfaceC20295rm1);
        return objX == AbstractC14862ic3.e() ? objX : C19938rB7.a;
    }
}
