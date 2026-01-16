package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.AbstractC10642bx0;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.features.call.ui.AvatarAsyncImagePainterKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.bx0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC10642bx0 {

    /* renamed from: ir.nasim.bx0$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;
        final /* synthetic */ List b;

        /* renamed from: ir.nasim.bx0$a$a, reason: collision with other inner class name */
        static final class C0923a implements InterfaceC15796kB2 {
            final /* synthetic */ List a;

            /* renamed from: ir.nasim.bx0$a$a$a, reason: collision with other inner class name */
            public static final class C0924a extends AbstractC8614Ws3 implements UA2 {
                public static final C0924a e = new C0924a();

                public C0924a() {
                    super(1);
                }

                @Override // ir.nasim.UA2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Void invoke(Object obj) {
                    return null;
                }
            }

            /* renamed from: ir.nasim.bx0$a$a$b */
            public static final class b extends AbstractC8614Ws3 implements UA2 {
                final /* synthetic */ UA2 e;
                final /* synthetic */ List f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public b(UA2 ua2, List list) {
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

            /* renamed from: ir.nasim.bx0$a$a$c */
            public static final class c extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
                final /* synthetic */ List e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public c(List list) {
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
                    C17637nI7 c17637nI7 = (C17637nI7) this.e.get(i);
                    interfaceC22053ub1.W(992227790);
                    AbstractC10642bx0.f(c17637nI7, interfaceC22053ub1, 0);
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

            C0923a(List list) {
                this.a = list;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 c(List list, InterfaceC15069ix3 interfaceC15069ix3) {
                AbstractC13042fc3.i(list, "$participantStates");
                AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
                interfaceC15069ix3.a(list.size(), null, new b(C0924a.e, list), AbstractC19242q11.c(-632812321, true, new c(list)));
                return C19938rB7.a;
            }

            public final void b(ZY0 zy0, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                AbstractC13042fc3.i(zy0, "$this$ModalBottomSheet");
                if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                interfaceC22053ub1.W(-1068283576);
                boolean zD = interfaceC22053ub1.D(this.a);
                final List list = this.a;
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new UA2() { // from class: ir.nasim.ax0
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return AbstractC10642bx0.a.C0923a.c(list, (InterfaceC15069ix3) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                AbstractC12623ev3.b(null, null, null, false, null, null, null, false, null, (UA2) objB, interfaceC22053ub1, 0, 511);
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                b((ZY0) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        a(SA2 sa2, List list) {
            this.a = sa2;
            this.b = list;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC9273Zf4.a(this.a, null, null, 0.0f, null, G10.a.a(interfaceC22053ub1, G10.b).r(), 0L, 0.0f, 0L, C9490a31.a.a(), null, null, AbstractC19242q11.e(-1524739316, true, new C0923a(this.b), interfaceC22053ub1, 54), interfaceC22053ub1, 805306368, 384, 3550);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.bx0$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;
        final /* synthetic */ C12767fA0 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C12767fA0 c12767fA0, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c12767fA0;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(this.d, interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws NumberFormatException {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return this.d.c2(Long.parseLong((String) AbstractC15401jX0.q0(AbstractC20762sZ6.N0(((M26) this.c).j(), new String[]{"_"}, false, 0, 6, null))));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(M26 m26, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(m26, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final void c(final C12767fA0 c12767fA0, final SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(c12767fA0, "viewModel");
        AbstractC13042fc3.i(sa2, "onDismissRequest");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(146677604);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? interfaceC22053ub1J.V(c12767fA0) : interfaceC22053ub1J.D(c12767fA0) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            InterfaceC9664aL6 interfaceC9664aL6A = AbstractC10222bH6.a(c12767fA0.O1(), AbstractC10360bX0.m(), null, interfaceC22053ub1J, 48, 2);
            interfaceC22053ub1J.W(-837226694);
            List listD = d(interfaceC9664aL6A);
            ArrayList arrayList = new ArrayList();
            Iterator it = listD.iterator();
            while (true) {
                boolean z = false;
                if (!it.hasNext()) {
                    break;
                }
                InterfaceC10258bL6 interfaceC10258bL6 = (InterfaceC10258bL6) it.next();
                interfaceC22053ub1J.W(-175801775);
                if ((i2 & 14) == 4 || ((i2 & 8) != 0 && interfaceC22053ub1J.D(c12767fA0))) {
                    z = true;
                }
                Object objB = interfaceC22053ub1J.B();
                if (z || objB == InterfaceC22053ub1.a.a()) {
                    objB = new b(c12767fA0, null);
                    interfaceC22053ub1J.s(objB);
                }
                interfaceC22053ub1J.Q();
                C17637nI7 c17637nI7 = (C17637nI7) AbstractC10222bH6.a(AbstractC6459Nq2.M(interfaceC10258bL6, (InterfaceC14603iB2) objB), null, null, interfaceC22053ub1J, 48, 2).getValue();
                if (c17637nI7 != null) {
                    arrayList.add(c17637nI7);
                }
            }
            interfaceC22053ub1J.Q();
            M10.f(false, AbstractC19242q11.e(-797858295, true, new a(sa2, arrayList), interfaceC22053ub1J, 54), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Yw0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC10642bx0.e(c12767fA0, sa2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final List d(InterfaceC9664aL6 interfaceC9664aL6) {
        return (List) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 e(C12767fA0 c12767fA0, SA2 sa2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c12767fA0, "$viewModel");
        AbstractC13042fc3.i(sa2, "$onDismissRequest");
        c(c12767fA0, sa2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(final C17637nI7 c17637nI7, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1403672867);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(c17637nI7) ? 4 : 2) | i;
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
            androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(eVarH, g10.a(interfaceC22053ub1J, i3).r(), null, 2, null);
            C24254yJ c24254yJ = C24254yJ.a;
            C24254yJ.m mVarH = c24254yJ.h();
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(mVarH, aVar2.k(), interfaceC22053ub1J, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarD);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            EV4 ev4H = AvatarAsyncImagePainterKt.h(c17637nI7.S(), null, false, 0, interfaceC22053ub1J, 0, 14);
            androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.q.k(androidx.compose.foundation.layout.t.f(aVar, 0.0f, 1, null), 0.0f, g10.c(interfaceC22053ub1J, i3).b().b(), 1, null);
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(c24254yJ.c(), aVar2.i(), interfaceC22053ub1J, 54);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarK);
            SA2 sa2A2 = aVar3.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A2);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A2 = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3B, aVar3.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar3.f());
            M66 m66 = M66.a;
            androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(aVar, 0.0f, 0.0f, g10.c(interfaceC22053ub1J, i3).b().c(), 0.0f, 11, null);
            String name = c17637nI7.getName();
            AbstractC13042fc3.h(name, "getName(...)");
            AbstractC9339Zm7.b(name, eVarM, g10.a(interfaceC22053ub1J, i3).F(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1J, i3).l(), interfaceC22053ub1J, 0, 0, 65528);
            AbstractC11456d23.b(ev4H, null, androidx.compose.foundation.layout.t.t(FV0.a(androidx.compose.foundation.layout.q.m(aVar, 0.0f, 0.0f, g10.c(interfaceC22053ub1J, i3).b().c(), 0.0f, 11, null), N46.g()), C17784nZ1.q(50)), null, null, 0.0f, null, interfaceC22053ub1J, 48, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
            interfaceC22053ub1J.u();
            ZV1.b(androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.q.m(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), 0.0f, 0.0f, C17784nZ1.q(74), 0.0f, 11, null), C17784nZ1.q(1)), 0.0f, g10.a(interfaceC22053ub1J, i3).A(), interfaceC22053ub1J, 6, 2);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Zw0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC10642bx0.g(c17637nI7, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g(C17637nI7 c17637nI7, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c17637nI7, "$user");
        f(c17637nI7, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
