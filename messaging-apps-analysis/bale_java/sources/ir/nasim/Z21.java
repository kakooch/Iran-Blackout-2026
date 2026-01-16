package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.os.Bundle;
import ir.nasim.Z21;

/* loaded from: classes4.dex */
public final class Z21 {
    public static final Z21 a = new Z21();
    public static InterfaceC18160oB2 b = AbstractC19242q11.c(1234147314, false, a.a);

    static final class a implements InterfaceC18160oB2 {
        public static final a a = new a();

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(UA2 ua2, UA2 ua22, InterfaceC4557Fq2 interfaceC4557Fq2, C6760Ow0 c6760Ow0) {
            AbstractC13042fc3.i(ua2, "$onListScroll");
            AbstractC13042fc3.i(ua22, "$getAppBarState");
            AbstractC13042fc3.i(interfaceC4557Fq2, "$appbarClickHandler");
            AbstractC13042fc3.i(c6760Ow0, "fragment");
            c6760Ow0.Xa(ua2);
            c6760Ow0.Ya(ua22);
            c6760Ow0.Za(interfaceC4557Fq2);
            return C19938rB7.a;
        }

        public final void b(final InterfaceC4557Fq2 interfaceC4557Fq2, final UA2 ua2, final UA2 ua22, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC4557Fq2, "appbarClickHandler");
            AbstractC13042fc3.i(ua2, "onListScroll");
            AbstractC13042fc3.i(ua22, "getAppBarState");
            boolean z = true;
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null);
            interfaceC22053ub1.W(1044728806);
            boolean z2 = (((i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) ^ 48) > 32 && interfaceC22053ub1.V(ua2)) || (i & 48) == 32;
            if ((((i & 896) ^ 384) <= 256 || !interfaceC22053ub1.V(ua22)) && (i & 384) != 256) {
                z = false;
            }
            boolean zD = z2 | z | interfaceC22053ub1.D(interfaceC4557Fq2);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.Y21
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return Z21.a.c(ua2, ua22, interfaceC4557Fq2, (C6760Ow0) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            interfaceC22053ub1.A(1765406104);
            AbstractC13786gp.a(C6760Ow0.class, eVarF, AbstractC21013sz2.b(interfaceC22053ub1, 0), Bundle.EMPTY, (UA2) objB, interfaceC22053ub1, 48, 0);
            interfaceC22053ub1.U();
        }

        @Override // ir.nasim.InterfaceC18160oB2
        public /* bridge */ /* synthetic */ Object s(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
            b((InterfaceC4557Fq2) obj, (UA2) obj2, (UA2) obj3, (InterfaceC22053ub1) obj4, ((Number) obj5).intValue());
            return C19938rB7.a;
        }
    }

    public final InterfaceC18160oB2 a() {
        return b;
    }
}
