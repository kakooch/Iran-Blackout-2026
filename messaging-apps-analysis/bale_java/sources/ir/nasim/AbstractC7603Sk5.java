package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.AbstractC7603Sk5;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC22053ub1;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Sk5, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC7603Sk5 {

    /* renamed from: ir.nasim.Sk5$a */
    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final A98 a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(-767852286);
            A98 a98G = C8062Uj0.a.g(interfaceC22053ub1, 6);
            interfaceC22053ub1.Q();
            return a98G;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
        }
    }

    /* renamed from: ir.nasim.Sk5$b */
    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ C19818qz6 a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ UA2 c;
        final /* synthetic */ List d;

        /* renamed from: ir.nasim.Sk5$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C19818qz6 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C19818qz6 c19818qz6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c19818qz6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C19818qz6 c19818qz6 = this.c;
                    this.b = 1;
                    if (c19818qz6.j(this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        b(C19818qz6 c19818qz6, SA2 sa2, UA2 ua2, List list) {
            this.a = c19818qz6;
            this.b = sa2;
            this.c = ua2;
            this.d = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(InterfaceC20315ro1 interfaceC20315ro1, final C19818qz6 c19818qz6, final SA2 sa2, final UA2 ua2, final InterfaceC23352wm4 interfaceC23352wm4) {
            AbstractC13042fc3.i(interfaceC20315ro1, "$scope");
            AbstractC13042fc3.i(c19818qz6, "$sheetState");
            AbstractC13042fc3.i(sa2, "$onDismissRequest");
            AbstractC13042fc3.i(ua2, "$onSelectPackage");
            AbstractC13042fc3.i(interfaceC23352wm4, "$itemSelectedId$delegate");
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a(c19818qz6, null), 3, null).s(new UA2() { // from class: ir.nasim.Xk5
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return AbstractC7603Sk5.b.k(c19818qz6, sa2, ua2, interfaceC23352wm4, (Throwable) obj);
                }
            });
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 k(C19818qz6 c19818qz6, SA2 sa2, UA2 ua2, InterfaceC23352wm4 interfaceC23352wm4, Throwable th) {
            AbstractC13042fc3.i(c19818qz6, "$sheetState");
            AbstractC13042fc3.i(sa2, "$onDismissRequest");
            AbstractC13042fc3.i(ua2, "$onSelectPackage");
            AbstractC13042fc3.i(interfaceC23352wm4, "$itemSelectedId$delegate");
            if (!c19818qz6.k()) {
                sa2.invoke();
            }
            ua2.invoke(Long.valueOf(o(interfaceC23352wm4)));
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final InterfaceC23352wm4 n() {
            return WG6.a(-1L);
        }

        private static final long o(InterfaceC23352wm4 interfaceC23352wm4) {
            return interfaceC23352wm4.getLongValue();
        }

        private static final void p(InterfaceC23352wm4 interfaceC23352wm4, long j) {
            interfaceC23352wm4.w(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 t(InterfaceC23352wm4 interfaceC23352wm4, C6167Ml5 c6167Ml5) {
            AbstractC13042fc3.i(interfaceC23352wm4, "$itemSelectedId$delegate");
            AbstractC13042fc3.i(c6167Ml5, "it");
            p(interfaceC23352wm4, c6167Ml5.f());
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 v(InterfaceC23352wm4 interfaceC23352wm4, C6167Ml5 c6167Ml5) {
            AbstractC13042fc3.i(interfaceC23352wm4, "$itemSelectedId$delegate");
            AbstractC13042fc3.i(c6167Ml5, "it");
            p(interfaceC23352wm4, c6167Ml5.f());
            return C19938rB7.a;
        }

        public final void h(ZY0 zy0, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(zy0, "$this$ModalBottomSheet");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            final C19818qz6 c19818qz6 = this.a;
            final SA2 sa2 = this.b;
            final UA2 ua2 = this.c;
            List list = this.d;
            e.a aVar = androidx.compose.ui.e.a;
            C24254yJ.m mVarH = C24254yJ.a.h();
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(mVarH, aVar2.k(), interfaceC22053ub1, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, aVar);
            InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar3.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            String strC = UY6.c(QD5.base_premium_btn, interfaceC22053ub1, 0);
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(c9784aZ0.c(aVar, aVar2.g()), 0.0f, 1, null);
            G10 g10 = G10.a;
            int i2 = G10.b;
            AbstractC9339Zm7.b(strC, androidx.compose.foundation.layout.q.k(androidx.compose.foundation.layout.q.m(eVarH, 0.0f, 0.0f, 0.0f, g10.c(interfaceC22053ub1, i2).b().e(), 7, null), g10.c(interfaceC22053ub1, i2).b().b(), 0.0f, 2, null), g10.a(interfaceC22053ub1, i2).F(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i2).l(), interfaceC22053ub1, 0, 0, 65528);
            MY2.b(null, null, 0L, interfaceC22053ub1, 0, 7);
            interfaceC22053ub1.W(444230289);
            Object objB = interfaceC22053ub1.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : list) {
                    if (((C6167Ml5) obj).k()) {
                        arrayList.add(obj);
                    } else {
                        arrayList2.add(obj);
                    }
                }
                objB = new XV4(arrayList, arrayList2);
                interfaceC22053ub1.s(objB);
            }
            XV4 xv4 = (XV4) objB;
            interfaceC22053ub1.Q();
            List list2 = (List) xv4.a();
            List list3 = (List) xv4.b();
            Object[] objArr = new Object[0];
            interfaceC22053ub1.W(444233467);
            Object objB2 = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar4 = InterfaceC22053ub1.a;
            if (objB2 == aVar4.a()) {
                objB2 = new SA2() { // from class: ir.nasim.Tk5
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC7603Sk5.b.n();
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            final InterfaceC23352wm4 interfaceC23352wm4 = (InterfaceC23352wm4) AbstractC9681aN5.e(objArr, null, null, (SA2) objB2, interfaceC22053ub1, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 6);
            interfaceC22053ub1.W(444235269);
            if (!list3.isEmpty()) {
                long jO = o(interfaceC23352wm4);
                G10 g102 = G10.a;
                int i3 = G10.b;
                TS4 ts4D = androidx.compose.foundation.layout.q.d(g102.c(interfaceC22053ub1, i3).b().e(), g102.c(interfaceC22053ub1, i3).b().e(), g102.c(interfaceC22053ub1, i3).b().e(), g102.c(interfaceC22053ub1, i3).b().u());
                interfaceC22053ub1.W(444251003);
                boolean zV = interfaceC22053ub1.V(interfaceC23352wm4);
                Object objB3 = interfaceC22053ub1.B();
                if (zV || objB3 == aVar4.a()) {
                    objB3 = new UA2() { // from class: ir.nasim.Uk5
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj2) {
                            return AbstractC7603Sk5.b.t(interfaceC23352wm4, (C6167Ml5) obj2);
                        }
                    };
                    interfaceC22053ub1.s(objB3);
                }
                interfaceC22053ub1.Q();
                AbstractC17917nm5.b(c9784aZ0, list3, jO, ts4D, false, (UA2) objB3, interfaceC22053ub1, 24582);
            }
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(444252999);
            if (!list2.isEmpty()) {
                long jO2 = o(interfaceC23352wm4);
                TS4 ts4A = androidx.compose.foundation.layout.q.a(G10.a.c(interfaceC22053ub1, G10.b).b().e());
                interfaceC22053ub1.W(444260859);
                boolean zV2 = interfaceC22053ub1.V(interfaceC23352wm4);
                Object objB4 = interfaceC22053ub1.B();
                if (zV2 || objB4 == aVar4.a()) {
                    objB4 = new UA2() { // from class: ir.nasim.Vk5
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj2) {
                            return AbstractC7603Sk5.b.v(interfaceC23352wm4, (C6167Ml5) obj2);
                        }
                    };
                    interfaceC22053ub1.s(objB4);
                }
                interfaceC22053ub1.Q();
                AbstractC17917nm5.b(c9784aZ0, list2, jO2, ts4A, true, (UA2) objB4, interfaceC22053ub1, 24582);
            }
            interfaceC22053ub1.Q();
            MY2.b(null, null, 0L, interfaceC22053ub1, 0, 7);
            Object objB5 = interfaceC22053ub1.B();
            if (objB5 == aVar4.a()) {
                objB5 = AbstractC10721c52.k(C18712p72.a, interfaceC22053ub1);
                interfaceC22053ub1.s(objB5);
            }
            final InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) objB5;
            androidx.compose.ui.e eVarH2 = androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.i(androidx.compose.ui.e.a, G10.a.c(interfaceC22053ub1, G10.b).b().c()), 0.0f, 1, null);
            interfaceC22053ub1.W(444271130);
            boolean zD = interfaceC22053ub1.D(interfaceC20315ro1) | interfaceC22053ub1.V(c19818qz6) | interfaceC22053ub1.V(sa2) | interfaceC22053ub1.V(ua2) | interfaceC22053ub1.V(interfaceC23352wm4);
            Object objB6 = interfaceC22053ub1.B();
            if (zD || objB6 == aVar4.a()) {
                Object obj2 = new SA2() { // from class: ir.nasim.Wk5
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC7603Sk5.b.i(interfaceC20315ro1, c19818qz6, sa2, ua2, interfaceC23352wm4);
                    }
                };
                interfaceC22053ub1.s(obj2);
                objB6 = obj2;
            }
            SA2 sa22 = (SA2) objB6;
            interfaceC22053ub1.Q();
            AbstractC17932no0.y(eVarH2, sa22, o(interfaceC23352wm4) == -1 ? InterfaceC19114po0.a.C1453a.a : InterfaceC19114po0.b.a.a, null, UY6.c(QD5.premium_continue_button, interfaceC22053ub1, 0), null, interfaceC22053ub1, 0, 40);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            h((ZY0) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public static final void c(final SA2 sa2, final UA2 ua2, final List list, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(sa2, "onDismissRequest");
        AbstractC13042fc3.i(ua2, "onSelectPackage");
        AbstractC13042fc3.i(list, "packages");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1170685941);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(sa2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(ua2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(list) ? 256 : 128;
        }
        int i3 = i2;
        if ((i3 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            C19818qz6 c19818qz6L = AbstractC9273Zf4.l(true, null, interfaceC22053ub1J, 6, 2);
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC9273Zf4.a(sa2, AbstractC22640va8.c(androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null)), c19818qz6L, 0.0f, null, G10.a.a(interfaceC22053ub1J, G10.b).M(), 0L, 0.0f, 0L, C24145y71.a.b(), a.a, null, AbstractC19242q11.e(-1337591986, true, new b(c19818qz6L, sa2, ua2, list), interfaceC22053ub1J, 54), interfaceC22053ub12, (i3 & 14) | 805306368, 384, 2520);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Rk5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC7603Sk5.d(sa2, ua2, list, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 d(SA2 sa2, UA2 ua2, List list, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(sa2, "$onDismissRequest");
        AbstractC13042fc3.i(ua2, "$onSelectPackage");
        AbstractC13042fc3.i(list, "$packages");
        c(sa2, ua2, list, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void e(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1599965218);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, C24145y71.a.d(), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Qk5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC7603Sk5.f(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        e(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
