package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC12520el0;
import java.util.List;

/* renamed from: ir.nasim.Qq7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC7191Qq7 {
    public static final void b(final androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(eVar, "modifier");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-608179537);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(eVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            InterfaceC9664aL6 interfaceC9664aL6A = AbstractC22957w63.a(AbstractC22957w63.c(null, interfaceC22053ub1J, 0, 1), 0.0f, ((WH1) interfaceC22053ub1J.H(AbstractC13040fc1.g())).w1(C17784nZ1.q(16)) * 2, AbstractC5999Lt.e(AbstractC5999Lt.l(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, 0, T22.e(), 2, null), null, 0L, 6, null), null, interfaceC22053ub1J, C21097t63.f | 48 | (C20494s63.d << 9), 8);
            List listP = AbstractC10360bX0.p(C24381yX0.k(DX0.d(4278255615L)), C24381yX0.k(DX0.d(4289583334L)), C24381yX0.k(DX0.d(4288684272L)));
            AbstractC12520el0.a aVar = AbstractC12520el0.b;
            float fC = c(interfaceC9664aL6A);
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC9105Ym7.b("Hello Developer ❤️", eVar, 0L, AbstractC13784go7.g(22), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, new C9348Zn7(aVar.c(listP, ZG4.e((Float.floatToRawIntBits(c(interfaceC9664aL6A)) & 4294967295L) | (Float.floatToRawIntBits(fC) << 32)), ZG4.e((Float.floatToRawIntBits(c(interfaceC9664aL6A) + r10) << 32) | (Float.floatToRawIntBits(c(interfaceC9664aL6A) + r10) & 4294967295L)), AbstractC4553Fp7.a.c()), 0.0f, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 33554430, null), interfaceC22053ub12, ((i2 << 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | 3078, 0, 65524);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Pq7
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC7191Qq7.d(eVar, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float c(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Number) interfaceC9664aL6.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 d(androidx.compose.ui.e eVar, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(eVar, "$modifier");
        b(eVar, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
