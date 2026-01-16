package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.Xl7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC8821Xl7 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC9664aL6 b(boolean z, boolean z2, InterfaceC23241wb3 interfaceC23241wb3, InterfaceC7614Sl7 interfaceC7614Sl7, float f, float f2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        InterfaceC9664aL6 interfaceC9664aL6Q;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1097899920, i, -1, "androidx.compose.material.animateBorderStrokeAsState (TextFieldDefaults.kt:970)");
        }
        InterfaceC9664aL6 interfaceC9664aL6A = AbstractC24580yr2.a(interfaceC23241wb3, interfaceC22053ub1, (i >> 6) & 14);
        InterfaceC9664aL6 interfaceC9664aL6B = interfaceC7614Sl7.b(z, z2, interfaceC23241wb3, interfaceC22053ub1, (i & 14) | (i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i & 896) | (i & 7168));
        float f3 = c(interfaceC9664aL6A) ? f : f2;
        if (z) {
            interfaceC22053ub1.W(773088894);
            interfaceC9664aL6Q = AbstractC4572Fs.c(f3, AbstractC5999Lt.l(150, 0, null, 6, null), null, null, interfaceC22053ub1, 48, 12);
            interfaceC22053ub1.Q();
        } else {
            interfaceC22053ub1.W(773193116);
            interfaceC9664aL6Q = AbstractC10222bH6.q(C17784nZ1.j(f2), interfaceC22053ub1, (i >> 15) & 14);
            interfaceC22053ub1.Q();
        }
        InterfaceC9664aL6 interfaceC9664aL6Q2 = AbstractC10222bH6.q(new C10493bi0(((C17784nZ1) interfaceC9664aL6Q.getValue()).v(), new CH6(((C24381yX0) interfaceC9664aL6B.getValue()).y(), null), null), interfaceC22053ub1, 0);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return interfaceC9664aL6Q2;
    }

    private static final boolean c(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
    }
}
