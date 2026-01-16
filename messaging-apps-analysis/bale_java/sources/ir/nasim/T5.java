package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC16030kb1;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes4.dex */
public abstract class T5 {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC18228oI7.values().length];
            try {
                iArr[EnumC18228oI7.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC18228oI7.a.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC18228oI7.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC18228oI7.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    public static final void f(final EnumC18228oI7 enumC18228oI7, androidx.compose.ui.e eVar, float f, InterfaceC22053ub1 interfaceC22053ub1, final int i, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-416262568);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(enumC18228oI7) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= interfaceC22053ub1J.V(eVar) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= interfaceC22053ub1J.c(f) ? 256 : 128;
        }
        if ((i3 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            if (i4 != 0) {
                eVar = androidx.compose.ui.e.a;
            }
            if (i5 != 0) {
                f = C17784nZ1.q(24);
            }
            int i6 = enumC18228oI7 == null ? -1 : a.a[enumC18228oI7.ordinal()];
            if (i6 == -1) {
                interfaceC22053ub1J.W(1037076427);
                interfaceC22053ub1J.Q();
            } else if (i6 == 1) {
                interfaceC22053ub1J.W(864730013);
                int i7 = i3 >> 3;
                h(eVar, f, interfaceC22053ub1J, (i7 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i7 & 14));
                interfaceC22053ub1J.Q();
            } else if (i6 != 2) {
                if (i6 != 3 && i6 != 4) {
                    interfaceC22053ub1J.W(864728250);
                    interfaceC22053ub1J.Q();
                    throw new NoWhenBranchMatchedException();
                }
                interfaceC22053ub1J.W(1037076427);
                interfaceC22053ub1J.Q();
            } else {
                interfaceC22053ub1J.W(864732891);
                k(eVar, C17784nZ1.q(16), interfaceC22053ub1J, ((i3 >> 3) & 14) | 48);
                interfaceC22053ub1J.Q();
            }
        }
        final androidx.compose.ui.e eVar2 = eVar;
        final float f2 = f;
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.P5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return T5.g(enumC18228oI7, eVar2, f2, i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g(EnumC18228oI7 enumC18228oI7, androidx.compose.ui.e eVar, float f, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        f(enumC18228oI7, eVar, f, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    private static final void h(final androidx.compose.ui.e eVar, final float f, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(446673);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(eVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.c(f) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            final long jI = G10.a.a(interfaceC22053ub1J, 6).I();
            final float fQ = C17784nZ1.q(16);
            androidx.compose.ui.e eVarC = androidx.compose.foundation.b.c(androidx.compose.foundation.layout.t.t(eVar, f), C24381yX0.b.j(), N46.g());
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.e(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarC);
            InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.q.k(androidx.compose.foundation.layout.t.t(androidx.compose.ui.e.a, fQ), 0.0f, 0.0f, 3, null);
            interfaceC22053ub1J.W(2024252452);
            boolean zF = interfaceC22053ub1J.f(jI);
            Object objB = interfaceC22053ub1J.B();
            if (zF || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.Q5
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return T5.i(fQ, jI, (InterfaceC17460n02) obj);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            AbstractC22443vF0.a(eVarK, (UA2) objB, interfaceC22053ub1J, 6);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.R5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return T5.j(eVar, f, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i(float f, long j, InterfaceC17460n02 interfaceC17460n02) {
        AbstractC13042fc3.i(interfaceC17460n02, "$this$Canvas");
        float f2 = 3;
        float fW1 = interfaceC17460n02.w1(C17784nZ1.q(f2));
        float f3 = 2;
        float fIntBitsToFloat = (Float.intBitsToFloat((int) (interfaceC17460n02.d() >> 32)) - (f2 * fW1)) / f3;
        float fW12 = interfaceC17460n02.w1(C17784nZ1.q(fW1));
        long jB = AbstractC8567Wn1.b((Float.floatToRawIntBits(fW12) << 32) | (Float.floatToRawIntBits(fW12) & 4294967295L));
        float fIntBitsToFloat2 = (Float.intBitsToFloat((int) (interfaceC17460n02.d() & 4294967295L)) - interfaceC17460n02.w1(C17784nZ1.q(f - C17784nZ1.q(4)))) / f3;
        InterfaceC17460n02.b0(interfaceC17460n02, j, ZG4.e((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L)), OD6.d((Float.floatToRawIntBits(fW1) << 32) | (Float.floatToRawIntBits(r23) & 4294967295L)), jB, null, 0.0f, null, 0, SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER, null);
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (interfaceC17460n02.d() & 4294967295L));
        float f4 = fW1 + fIntBitsToFloat;
        InterfaceC17460n02.b0(interfaceC17460n02, j, ZG4.e((Float.floatToRawIntBits(f4) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L)), OD6.d((Float.floatToRawIntBits(fW1) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat3) & 4294967295L)), jB, null, 0.0f, null, 0, SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER, null);
        InterfaceC17460n02.b0(interfaceC17460n02, j, ZG4.e((Float.floatToRawIntBits(f4 * f3) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L)), OD6.d((Float.floatToRawIntBits(fW1) << 32) | (Float.floatToRawIntBits(r23) & 4294967295L)), jB, null, 0.0f, null, 0, SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(androidx.compose.ui.e eVar, float f, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(eVar, "$modifier");
        h(eVar, f, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    private static final void k(final androidx.compose.ui.e eVar, final float f, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1106249091);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(eVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.c(f) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            AbstractC11456d23.b(FV4.c(AbstractC24188yB5.ic_live_badge, interfaceC22053ub1J, 0), "", androidx.compose.foundation.layout.t.t(eVar, f), null, InterfaceC13157fl1.a.f(), 0.0f, null, interfaceC22053ub1J, 24624, 104);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.S5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return T5.l(eVar, f, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(androidx.compose.ui.e eVar, float f, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(eVar, "$modifier");
        k(eVar, f, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void m(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-684586718);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            C24254yJ.f fVarO = C24254yJ.a.o(G10.a.c(interfaceC22053ub1J, 6).b().u());
            e.a aVar = androidx.compose.ui.e.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(fVarO, InterfaceC12529em.a.k(), interfaceC22053ub1J, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, aVar);
            InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar2.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            interfaceC22053ub1J.W(1272460858);
            Iterator it = EnumC18228oI7.j().iterator();
            while (it.hasNext()) {
                f((EnumC18228oI7) it.next(), null, 0.0f, interfaceC22053ub1J, 0, 6);
            }
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.O5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return T5.n(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        m(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
