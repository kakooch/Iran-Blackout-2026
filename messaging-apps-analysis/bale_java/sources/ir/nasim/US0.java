package ir.nasim;

import androidx.compose.ui.e;
import ir.nasim.InterfaceC16030kb1;
import java.util.List;

/* loaded from: classes6.dex */
public abstract class US0 {

    static final class a implements SA2 {
        final /* synthetic */ UA2 a;
        final /* synthetic */ HS0 b;

        a(UA2 ua2, HS0 hs0) {
            this.a = ua2;
            this.b = hs0;
        }

        public final void a() {
            this.a.invoke(this.b.a());
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    public static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        public b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(Object obj) {
            return null;
        }
    }

    public static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;
        final /* synthetic */ List f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(UA2 ua2, List list) {
            super(1);
            this.e = ua2;
            this.f = list;
        }

        public final Object a(int i) {
            return this.e.invoke(this.f.get(i));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    public static final class d extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
        final /* synthetic */ List e;
        final /* synthetic */ UA2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(List list, UA2 ua2) {
            super(4);
            this.e = list;
            this.f = ua2;
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            int i3;
            long jA;
            long jW;
            if ((i2 & 6) == 0) {
                i3 = i2 | (interfaceC22053ub1.V(interfaceC6988Pv3) ? 4 : 2);
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                i3 |= interfaceC22053ub1.e(i) ? 32 : 16;
            }
            if (!interfaceC22053ub1.o((i3 & 147) != 146, i3 & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-632812321, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
            }
            HS0 hs0 = (HS0) this.e.get(i);
            interfaceC22053ub1.W(-2092335669);
            e.a aVar = androidx.compose.ui.e.a;
            float fQ = C17784nZ1.q(hs0.b() ? 2 : 1);
            if (hs0.b()) {
                interfaceC22053ub1.W(-1037319199);
                jA = G10.a.a(interfaceC22053ub1, G10.b).I();
            } else {
                interfaceC22053ub1.W(-1037318019);
                jA = G10.a.a(interfaceC22053ub1, G10.b).A();
            }
            interfaceC22053ub1.Q();
            C10493bi0 c10493bi0A = AbstractC11256ci0.a(fQ, jA);
            float f = 100;
            androidx.compose.ui.e eVarA = FV0.a(AbstractC9287Zh0.e(aVar, c10493bi0A, N46.d(C17784nZ1.q(f))), N46.d(C17784nZ1.q(f)));
            if (hs0.b()) {
                interfaceC22053ub1.W(-1037310428);
                jW = G10.a.a(interfaceC22053ub1, G10.b).r();
            } else {
                interfaceC22053ub1.W(-1037309155);
                jW = G10.a.a(interfaceC22053ub1, G10.b).w();
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(eVarA, jW, null, 2, null);
            interfaceC22053ub1.W(-1037307978);
            boolean zV = interfaceC22053ub1.V(this.f) | interfaceC22053ub1.V(hs0);
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new a(this.f, hs0);
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarF = androidx.compose.foundation.e.f(eVarD, false, null, null, (SA2) objB, 7, null);
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(C24254yJ.a.g(), InterfaceC12529em.a.l(), interfaceC22053ub1, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarF);
            InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar2.a();
            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1.G();
            if (interfaceC22053ub1.h()) {
                interfaceC22053ub1.g(sa2A);
            } else {
                interfaceC22053ub1.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            M66 m66 = M66.a;
            androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(aVar, C17784nZ1.q(12), C17784nZ1.q(6));
            String strA = hs0.a();
            G10 g10 = G10.a;
            int i4 = G10.b;
            AbstractC9339Zm7.b(strA, eVarJ, g10.a(interfaceC22053ub1, i4).F(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.a()), 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i4).c(), interfaceC22053ub1, 48, 0, 65016);
            interfaceC22053ub1.u();
            interfaceC22053ub1.Q();
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            a((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void e(androidx.compose.ui.e r18, final java.util.List r19, ir.nasim.UA2 r20, ir.nasim.InterfaceC22053ub1 r21, final int r22, final int r23) {
        /*
            Method dump skipped, instructions count: 279
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.US0.e(androidx.compose.ui.e, java.util.List, ir.nasim.UA2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(String str) {
        AbstractC13042fc3.i(str, "it");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g(List list, UA2 ua2, InterfaceC15069ix3 interfaceC15069ix3) {
        AbstractC13042fc3.i(list, "$items");
        AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyRow");
        interfaceC15069ix3.a(list.size(), null, new c(b.e, list), AbstractC19242q11.c(-632812321, true, new d(list, ua2)));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h(androidx.compose.ui.e eVar, List list, UA2 ua2, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(list, "$items");
        e(eVar, list, ua2, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    public static final void i(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-374002191);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            e(null, AbstractC10360bX0.p(new HS0("همه", false), new HS0("کسب و کار", true), new HS0("فروشگاهی", false)), null, interfaceC22053ub1J, 0, 5);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.QS0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return US0.j(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        i(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
