package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.AbstractC12520el0;
import ir.nasim.AbstractC7329Rg1;
import ir.nasim.InterfaceC22053ub1;
import java.util.List;

/* renamed from: ir.nasim.Rg1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC7329Rg1 {

    /* renamed from: ir.nasim.Rg1$a */
    static final class a implements InterfaceC15796kB2 {
        public static final a a = new a();

        a() {
        }

        private static final long c(InterfaceC9102Ym4 interfaceC9102Ym4) {
            return ((C4414Fa3) interfaceC9102Ym4.getValue()).j();
        }

        private static final void d(InterfaceC9102Ym4 interfaceC9102Ym4, long j) {
            interfaceC9102Ym4.setValue(C4414Fa3.b(j));
        }

        private static final float f(InterfaceC9664aL6 interfaceC9664aL6) {
            return ((Number) interfaceC9664aL6.getValue()).floatValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 h(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC11379cu3 interfaceC11379cu3) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$size$delegate");
            AbstractC13042fc3.i(interfaceC11379cu3, "it");
            d(interfaceC9102Ym4, interfaceC11379cu3.a());
            return C19938rB7.a;
        }

        public final androidx.compose.ui.e b(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(eVar, "$this$composed");
            interfaceC22053ub1.W(-879834604);
            interfaceC22053ub1.W(1882841009);
            Object objB = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = AbstractC13472gH6.d(C4414Fa3.b(C4414Fa3.b.a()), null, 2, null);
                interfaceC22053ub1.s(objB);
            }
            final InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
            interfaceC22053ub1.Q();
            InterfaceC9664aL6 interfaceC9664aL6A = AbstractC22957w63.a(AbstractC22957w63.c("shimmerTransition", interfaceC22053ub1, 6, 0), (-2) * ((int) (c(interfaceC9102Ym4) >> 32)), 2 * ((int) (c(interfaceC9102Ym4) >> 32)), AbstractC5999Lt.e(AbstractC5999Lt.l(2000, 0, null, 6, null), null, 0L, 6, null), "shimmer", interfaceC22053ub1, C21097t63.f | 24576 | (C20494s63.d << 9), 0);
            AbstractC12520el0.a aVar2 = AbstractC12520el0.b;
            G10 g10 = G10.a;
            List listP = AbstractC10360bX0.p(C24381yX0.k(g10.a(interfaceC22053ub1, 6).A()), C24381yX0.k(C24381yX0.o(g10.a(interfaceC22053ub1, 6).A(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null)), C24381yX0.k(g10.a(interfaceC22053ub1, 6).A()));
            long jE = ZG4.e((Float.floatToRawIntBits(f(interfaceC9664aL6A)) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L));
            float f = f(interfaceC9664aL6A) + ((int) (c(interfaceC9102Ym4) >> 32));
            float fC = (int) (c(interfaceC9102Ym4) & 4294967295L);
            androidx.compose.ui.e eVarB = androidx.compose.foundation.b.b(eVar, AbstractC12520el0.a.e(aVar2, listP, jE, ZG4.e((Float.floatToRawIntBits(fC) & 4294967295L) | (Float.floatToRawIntBits(f) << 32)), 0, 8, null), null, 0.0f, 6, null);
            interfaceC22053ub1.W(1882867714);
            Object objB2 = interfaceC22053ub1.B();
            if (objB2 == aVar.a()) {
                objB2 = new UA2() { // from class: ir.nasim.Qg1
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC7329Rg1.a.h(interfaceC9102Ym4, (InterfaceC11379cu3) obj);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarA = androidx.compose.ui.layout.c.a(eVarB, (UA2) objB2);
            interfaceC22053ub1.Q();
            return eVarA;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return b((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    public static final void c(androidx.compose.ui.e eVar, final int i, final boolean z, final InterfaceC15796kB2 interfaceC15796kB2, InterfaceC22053ub1 interfaceC22053ub1, final int i2, final int i3) {
        androidx.compose.ui.e eVar2;
        int i4;
        final androidx.compose.ui.e eVar3;
        AbstractC13042fc3.i(interfaceC15796kB2, "contentAfterLoading");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1787458153);
        int i5 = i3 & 1;
        if (i5 != 0) {
            i4 = i2 | 6;
            eVar2 = eVar;
        } else if ((i2 & 6) == 0) {
            eVar2 = eVar;
            i4 = (interfaceC22053ub1J.V(eVar2) ? 4 : 2) | i2;
        } else {
            eVar2 = eVar;
            i4 = i2;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            i4 |= interfaceC22053ub1J.e(i) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i2 & 384) == 0) {
            i4 |= interfaceC22053ub1J.a(z) ? 256 : 128;
        }
        if ((i3 & 8) != 0) {
            i4 |= SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER;
        } else if ((i2 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i4 |= interfaceC22053ub1J.D(interfaceC15796kB2) ? 2048 : 1024;
        }
        if ((i4 & 1171) == 1170 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            eVar3 = eVar2;
        } else {
            eVar3 = i5 != 0 ? androidx.compose.ui.e.a : eVar2;
            if (z) {
                interfaceC22053ub1J.W(-873045672);
                interfaceC22053ub1J.W(1772953850);
                boolean z2 = (i4 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32;
                Object objB = interfaceC22053ub1J.B();
                if (z2 || objB == InterfaceC22053ub1.a.a()) {
                    objB = new UA2() { // from class: ir.nasim.Og1
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return AbstractC7329Rg1.d(i, (InterfaceC15069ix3) obj);
                        }
                    };
                    interfaceC22053ub1J.s(objB);
                }
                interfaceC22053ub1J.Q();
                AbstractC12623ev3.b(eVar3, null, null, false, null, null, null, false, null, (UA2) objB, interfaceC22053ub1J, i4 & 14, 510);
                interfaceC22053ub1J.Q();
            } else {
                interfaceC22053ub1J.W(-870528193);
                interfaceC15796kB2.q(eVar3, interfaceC22053ub1J, Integer.valueOf((i4 & 14) | ((i4 >> 6) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER)));
                interfaceC22053ub1J.Q();
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Pg1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC7329Rg1.e(eVar3, i, z, interfaceC15796kB2, i2, i3, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 d(int i, InterfaceC15069ix3 interfaceC15069ix3) {
        AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
        InterfaceC15069ix3.g(interfaceC15069ix3, i, null, null, C24105y31.a.a(), 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 e(androidx.compose.ui.e eVar, int i, boolean z, InterfaceC15796kB2 interfaceC15796kB2, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(interfaceC15796kB2, "$contentAfterLoading");
        c(eVar, i, z, interfaceC15796kB2, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    public static final androidx.compose.ui.e f(androidx.compose.ui.e eVar) {
        AbstractC13042fc3.i(eVar, "<this>");
        return androidx.compose.ui.c.c(eVar, null, a.a, 1, null);
    }
}
