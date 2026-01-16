package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.InterfaceC16030kb1;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes4.dex */
public abstract class PB7 {

    static final class a implements InterfaceC15796kB2 {
        final /* synthetic */ Set a;

        a(Set set) {
            this.a = set;
        }

        public final void a(InterfaceC16782lr2 interfaceC16782lr2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC16782lr2, "$this$FlowRow");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            interfaceC22053ub1.W(703036245);
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                PB7.g(((Number) it.next()).intValue(), false, true, null, 0.0f, 0.0f, null, false, 0, interfaceC22053ub1, 432, 504);
            }
            interfaceC22053ub1.Q();
            Iterator it2 = this.a.iterator();
            while (it2.hasNext()) {
                PB7.g(((Number) it2.next()).intValue(), true, false, null, 0.0f, 0.0f, null, false, 0, interfaceC22053ub1, 432, 504);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC16782lr2) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ int a;
        final /* synthetic */ String b;
        final /* synthetic */ float c;

        b(int i, String str, float f) {
            this.a = i;
            this.b = str;
            this.c = f;
        }

        public final void a(L66 l66, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(l66, "$this$Badge");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else if (this.a > 0) {
                String strD = AbstractC12152e76.d(this.b, interfaceC22053ub1, 0);
                C9348Zn7 c9348Zn7P = G10.a.d(interfaceC22053ub1, 6).p();
                AbstractC9339Zm7.b(strD, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 1, 0, null, c9348Zn7P.b((16744447 & 1) != 0 ? c9348Zn7P.a.g() : 0L, (16744447 & 2) != 0 ? c9348Zn7P.a.k() : AbstractC18394ob1.l(this.c, interfaceC22053ub1, 0), (16744447 & 4) != 0 ? c9348Zn7P.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7P.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7P.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7P.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7P.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7P.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7P.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7P.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7P.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7P.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7P.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7P.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7P.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7P.b.h() : 0, (16744447 & 65536) != 0 ? c9348Zn7P.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7P.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7P.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7P.c : null, (16744447 & 1048576) != 0 ? c9348Zn7P.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7P.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7P.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7P.b.k() : null), interfaceC22053ub1, 0, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 57342);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((L66) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public static final void e(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1161227591);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            Set setI = AbstractC4597Fu6.i(0, 0, 9, 19, 20, 99, 999, 9999, Integer.valueOf(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT));
            e.a aVar = androidx.compose.ui.e.a;
            C24254yJ c24254yJ = C24254yJ.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(c24254yJ.h(), InterfaceC12529em.a.k(), interfaceC22053ub1J, 0);
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
            AbstractC12582er2.b(null, c24254yJ.o(C17784nZ1.q(8)), null, null, 0, 0, AbstractC19242q11.e(1331121534, true, new a(setI), interfaceC22053ub1J, 54), interfaceC22053ub1J, 1572912, 61);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.LB7
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return PB7.f(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        e(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:143:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0117  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void g(final int r22, final boolean r23, final boolean r24, androidx.compose.ui.e r25, float r26, float r27, ir.nasim.TS4 r28, boolean r29, int r30, ir.nasim.InterfaceC22053ub1 r31, final int r32, final int r33) {
        /*
            Method dump skipped, instructions count: 576
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.PB7.g(int, boolean, boolean, androidx.compose.ui.e, float, float, ir.nasim.TS4, boolean, int, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h(int i, boolean z, boolean z2, androidx.compose.ui.e eVar, float f, float f2, TS4 ts4, boolean z3, int i2, int i3, int i4, InterfaceC22053ub1 interfaceC22053ub1, int i5) {
        g(i, z, z2, eVar, f, f2, ts4, z3, i2, interfaceC22053ub1, QJ5.a(i3 | 1), i4);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i(InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(interfaceC11943do6, "$this$clearAndSetSemantics");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(int i, boolean z, boolean z2, androidx.compose.ui.e eVar, float f, float f2, TS4 ts4, boolean z3, int i2, int i3, int i4, InterfaceC22053ub1 interfaceC22053ub1, int i5) {
        g(i, z, z2, eVar, f, f2, ts4, z3, i2, interfaceC22053ub1, QJ5.a(i3 | 1), i4);
        return C19938rB7.a;
    }
}
