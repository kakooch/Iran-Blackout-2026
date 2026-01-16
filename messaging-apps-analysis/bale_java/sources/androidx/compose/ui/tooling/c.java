package androidx.compose.ui.tooling;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.AbstractC11024cc1;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC5138Ib1;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C19938rB7;
import ir.nasim.C7252Qx5;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC20208rd6;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.QJ5;
import ir.nasim.R93;
import ir.nasim.S93;
import java.util.Set;

/* loaded from: classes2.dex */
public abstract class c {

    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.tooling.a e;
        final /* synthetic */ InterfaceC14603iB2 f;
        final /* synthetic */ int g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(androidx.compose.ui.tooling.a aVar, InterfaceC14603iB2 interfaceC14603iB2, int i) {
            super(2);
            this.e = aVar;
            this.f = interfaceC14603iB2;
            this.g = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            c.a(this.e, this.f, interfaceC22053ub1, QJ5.a(this.g | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void a(androidx.compose.ui.tooling.a aVar, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1669497937);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? interfaceC22053ub1J.V(aVar) : interfaceC22053ub1J.D(aVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(interfaceC14603iB2) ? 32 : 16;
        }
        if (interfaceC22053ub1J.o((i2 & 19) != 18, i2 & 1)) {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1669497937, i2, -1, "androidx.compose.ui.tooling.Inspectable (Inspectable.android.kt:53)");
            }
            interfaceC22053ub1J.x();
            AbstractC13042fc3.g(aVar, "null cannot be cast to non-null type androidx.compose.ui.tooling.CompositionDataRecordImpl");
            Set setA = ((b) aVar).a();
            setA.add(interfaceC22053ub1J.C());
            AbstractC11024cc1.b(new C7252Qx5[]{R93.a().d(Boolean.TRUE), S93.a().d(setA)}, interfaceC14603iB2, interfaceC22053ub1J, (i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | C7252Qx5.i);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        } else {
            interfaceC22053ub1J.L();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new a(aVar, interfaceC14603iB2, i));
        }
    }
}
