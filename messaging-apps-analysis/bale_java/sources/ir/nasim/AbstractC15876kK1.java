package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import ir.nasim.AbstractC15876kK1;
import ir.nasim.AbstractC23236wa8;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC19114po0;
import java.util.List;

/* renamed from: ir.nasim.kK1, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC15876kK1 {

    /* renamed from: ir.nasim.kK1$a */
    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final A98 a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(1287090925);
            A98 a98G = C8062Uj0.a.g(interfaceC22053ub1, 6);
            AbstractC23236wa8.a aVar = AbstractC23236wa8.a;
            A98 a98G2 = AbstractC21393ta8.g(a98G, AbstractC23236wa8.l(aVar.g(), aVar.e()));
            interfaceC22053ub1.Q();
            return a98G2;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
        }
    }

    /* renamed from: ir.nasim.kK1$b */
    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ C17058mK1 a;

        b(C17058mK1 c17058mK1) {
            this.a = c17058mK1;
        }

        public final void a(ZY0 zy0, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(zy0, "$this$ModalBottomSheet");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            AbstractC15876kK1.q(this.a, interfaceC22053ub1, 0);
            MY2.b(null, null, 0L, interfaceC22053ub1, 0, 7);
            AbstractC15876kK1.n(this.a, interfaceC22053ub1, 0);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((ZY0) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.kK1$c */
    static final class c implements InterfaceC15796kB2 {
        final /* synthetic */ String a;

        c(String str) {
            this.a = str;
        }

        public final void a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            AbstractC13042fc3.i(eVar, "textModifier");
            if ((i & 6) == 0) {
                i2 = i | (interfaceC22053ub1.V(eVar) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            G10 g10 = G10.a;
            int i3 = G10.b;
            AbstractC9339Zm7.b(this.a, eVar, g10.a(interfaceC22053ub1, i3).z(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i3).d(), interfaceC22053ub1, (i2 << 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, 0, 65528);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.kK1$d */
    static final class d implements InterfaceC15796kB2 {
        final /* synthetic */ String a;

        d(String str) {
            this.a = str;
        }

        public final void a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            AbstractC13042fc3.i(eVar, "descriptionModifier");
            if ((i & 6) == 0) {
                i2 = i | (interfaceC22053ub1.V(eVar) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            G10 g10 = G10.a;
            int i3 = G10.b;
            AbstractC9339Zm7.b(this.a, eVar, g10.a(interfaceC22053ub1, i3).F(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i3).a(), interfaceC22053ub1, (i2 << 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, 0, 65528);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.kK1$e */
    static final class e implements InterfaceC15796kB2 {
        final /* synthetic */ C17058mK1 a;

        e(C17058mK1 c17058mK1) {
            this.a = c17058mK1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(C17058mK1 c17058mK1) {
            AbstractC13042fc3.i(c17058mK1, "$state");
            c17058mK1.a().invoke(Integer.valueOf(c17058mK1.b().b()));
            return C19938rB7.a;
        }

        public final void b(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(aVar, G10.a.c(interfaceC22053ub1, G10.b).b().c());
            InterfaceC12529em.c cVarI = InterfaceC12529em.a.i();
            C24254yJ.f fVarE = C24254yJ.a.e();
            final C17058mK1 c17058mK1 = this.a;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(fVarE, cVarI, interfaceC22053ub1, 54);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarI);
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
            androidx.compose.ui.e eVarB = L66.b(M66.a, aVar, 1.0f, false, 2, null);
            InterfaceC19114po0.c.a aVar3 = InterfaceC19114po0.c.a.a;
            String strC = UY6.c(QD5.terminate_session, interfaceC22053ub1, 0);
            interfaceC22053ub1.W(-478301420);
            boolean zV = interfaceC22053ub1.V(c17058mK1);
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.lK1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC15876kK1.e.c(c17058mK1);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC17932no0.A((SA2) objB, aVar3, strC, eVarB, null, null, interfaceC22053ub1, (InterfaceC19114po0.c.a.b << 3) | 24576, 32);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.kK1$f */
    public static final class f extends AbstractC8614Ws3 implements UA2 {
        public static final f e = new f();

        public f() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(Object obj) {
            return null;
        }
    }

    /* renamed from: ir.nasim.kK1$g */
    public static final class g extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;
        final /* synthetic */ List f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(UA2 ua2, List list) {
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

    /* renamed from: ir.nasim.kK1$h */
    public static final class h extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
        final /* synthetic */ List e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(List list) {
            super(4);
            this.e = list;
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            int i3;
            if ((i2 & 6) == 0) {
                i3 = (interfaceC22053ub1.V(interfaceC6988Pv3) ? 4 : 2) | i2;
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
            XV4 xv4 = (XV4) this.e.get(i);
            interfaceC22053ub1.W(2027587301);
            AbstractC15876kK1.k(UY6.c(((Number) xv4.e()).intValue(), interfaceC22053ub1, 0), (String) xv4.f(), interfaceC22053ub1, 0);
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

    /* JADX WARN: Removed duplicated region for block: B:51:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void h(androidx.compose.ui.e r23, final ir.nasim.C19818qz6 r24, final ir.nasim.C17058mK1 r25, ir.nasim.SA2 r26, ir.nasim.InterfaceC22053ub1 r27, final int r28, final int r29) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC15876kK1.h(androidx.compose.ui.e, ir.nasim.qz6, ir.nasim.mK1, ir.nasim.SA2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(androidx.compose.ui.e eVar, C19818qz6 c19818qz6, C17058mK1 c17058mK1, SA2 sa2, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c19818qz6, "$sheetState");
        AbstractC13042fc3.i(c17058mK1, "$deviceInfoBottomSheetState");
        h(eVar, c19818qz6, c17058mK1, sa2, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(final String str, final String str2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-391200217);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(str2) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            interfaceC22053ub1J.W(493445662);
            Object objB = interfaceC22053ub1J.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.dK1
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC15876kK1.l((InterfaceC11943do6) obj);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            AbstractC16797ls7.h(AbstractC19242q11.e(-276403992, true, new c(str), interfaceC22053ub1J, 54), AbstractC6919Pn6.c(aVar, true, (UA2) objB), null, AbstractC19242q11.e(-920891451, true, new d(str2), interfaceC22053ub1J, 54), null, null, null, null, null, interfaceC22053ub1J, 3078, SIPTransactionStack.BASE_TIMER_INTERVAL);
            MY2.b(androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), C17784nZ1.q(1)), null, G10.a.a(interfaceC22053ub1J, G10.b).A(), interfaceC22053ub1J, 6, 2);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.eK1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC15876kK1.m(str, str2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m(String str, String str2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(str, "$title");
        AbstractC13042fc3.i(str2, "$description");
        k(str, str2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(final C17058mK1 c17058mK1, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1183398201);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(c17058mK1) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            Context context = (Context) interfaceC22053ub1J.H(AndroidCompositionLocals_androidKt.g());
            Object objB = c17058mK1.b();
            interfaceC22053ub1J.W(-1887322412);
            boolean zV = interfaceC22053ub1J.V(objB) | interfaceC22053ub1J.V(context);
            Object objB2 = interfaceC22053ub1J.B();
            if (zV || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = v(c17058mK1.b(), context);
                interfaceC22053ub1J.s(objB2);
            }
            final List list = (List) objB2;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(-1887318384);
            boolean zD = ((i2 & 14) == 4) | interfaceC22053ub1J.D(list);
            Object objB3 = interfaceC22053ub1J.B();
            if (zD || objB3 == InterfaceC22053ub1.a.a()) {
                objB3 = new UA2() { // from class: ir.nasim.iK1
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC15876kK1.o(list, c17058mK1, (InterfaceC15069ix3) obj);
                    }
                };
                interfaceC22053ub1J.s(objB3);
            }
            interfaceC22053ub1J.Q();
            AbstractC12623ev3.b(null, null, null, false, null, null, null, false, null, (UA2) objB3, interfaceC22053ub1J, 0, 511);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.jK1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC15876kK1.p(c17058mK1, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o(List list, C17058mK1 c17058mK1, InterfaceC15069ix3 interfaceC15069ix3) {
        AbstractC13042fc3.i(list, "$deviceInfoList");
        AbstractC13042fc3.i(c17058mK1, "$state");
        AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
        interfaceC15069ix3.a(list.size(), null, new g(f.e, list), AbstractC19242q11.c(-632812321, true, new h(list)));
        InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(1387536196, true, new e(c17058mK1)), 3, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p(C17058mK1 c17058mK1, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c17058mK1, "$state");
        n(c17058mK1, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(final C17058mK1 c17058mK1, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-258182179);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(c17058mK1) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null);
            G10 g10 = G10.a;
            int i3 = G10.b;
            androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(eVarH, g10.c(interfaceC22053ub1J, i3).b().f(), g10.c(interfaceC22053ub1J, i3).b().d());
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar2.o(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarJ);
            InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar3.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            AbstractC9339Zm7.b(c17058mK1.b().c(), hVar.h(aVar, aVar2.e()), g10.a(interfaceC22053ub1J, i3).F(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.a()), 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1J, i3).l(), interfaceC22053ub1J, 0, 0, 65016);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.hK1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC15876kK1.r(c17058mK1, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r(C17058mK1 c17058mK1, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c17058mK1, "$deviceInfoBottomSheetState");
        q(c17058mK1, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    private static final List v(ZJ1 zj1, Context context) {
        return AbstractC10360bX0.p(new XV4(Integer.valueOf(QD5.application), zj1.e()), new XV4(Integer.valueOf(QD5.last_login), C14593iA1.k(context, zj1.d(), false)));
    }
}
