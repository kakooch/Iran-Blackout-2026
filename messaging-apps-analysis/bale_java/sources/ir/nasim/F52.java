package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* loaded from: classes.dex */
public abstract class F52 {
    private static final C7479Rw7 a = new C7479Rw7(SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER, 0, T22.d(), 2, null);
    private static final C7479Rw7 b = new C7479Rw7(150, 0, new C11397cw1(0.4f, 0.0f, 0.6f, 1.0f), 2, null);
    private static final C7479Rw7 c = new C7479Rw7(SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER, 0, new C11397cw1(0.4f, 0.0f, 0.6f, 1.0f), 2, null);

    public static final Object d(C15607js c15607js, float f, InterfaceC22645vb3 interfaceC22645vb3, InterfaceC22645vb3 interfaceC22645vb32, InterfaceC20295rm1 interfaceC20295rm1) {
        InterfaceC5766Kt interfaceC5766KtA = interfaceC22645vb32 != null ? D52.a.a(interfaceC22645vb32) : interfaceC22645vb3 != null ? D52.a.b(interfaceC22645vb3) : null;
        if (interfaceC5766KtA != null) {
            Object objH = C15607js.h(c15607js, C17784nZ1.j(f), interfaceC5766KtA, null, null, interfaceC20295rm1, 12, null);
            return objH == AbstractC14862ic3.e() ? objH : C19938rB7.a;
        }
        Object objX = c15607js.x(C17784nZ1.j(f), interfaceC20295rm1);
        return objX == AbstractC14862ic3.e() ? objX : C19938rB7.a;
    }
}
