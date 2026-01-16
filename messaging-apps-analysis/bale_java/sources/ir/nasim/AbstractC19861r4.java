package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.AbstractC12520el0;
import ir.nasim.AbstractC19861r4;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.features.call.ui.AvatarAsyncImagePainterKt;
import java.util.List;

/* renamed from: ir.nasim.r4, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC19861r4 {

    /* renamed from: ir.nasim.r4$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C19391qG6 c;
        final /* synthetic */ String d;
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C19391qG6 c19391qG6, String str, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c19391qG6;
            this.d = str;
            this.e = sa2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C19391qG6 c19391qG6 = this.c;
                String str = this.d;
                this.b = 1;
                if (C19391qG6.f(c19391qG6, str, null, false, null, this, 14, null) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            this.e.invoke();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.r4$b */
    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ C19391qG6 a;

        b(C19391qG6 c19391qG6) {
            this.a = c19391qG6;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC18209oG6.b(this.a, null, C20442s11.a.a(), interfaceC22053ub1, 390, 2);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.r4$c */
    static final class c implements InterfaceC15796kB2 {
        final /* synthetic */ C23523x4 a;
        final /* synthetic */ InterfaceC20315ro1 b;
        final /* synthetic */ GT4 c;
        final /* synthetic */ SA2 d;
        final /* synthetic */ SA2 e;
        final /* synthetic */ I3 f;
        final /* synthetic */ UA2 g;
        final /* synthetic */ UA2 h;
        final /* synthetic */ UA2 i;
        final /* synthetic */ SA2 j;
        final /* synthetic */ UA2 k;
        final /* synthetic */ UA2 l;

        /* renamed from: ir.nasim.r4$c$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C23523x4 c;
            final /* synthetic */ InterfaceC20315ro1 d;
            final /* synthetic */ GT4 e;

            /* renamed from: ir.nasim.r4$c$a$a, reason: collision with other inner class name */
            static final class C1488a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ GT4 c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1488a(GT4 gt4, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = gt4;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C1488a(this.c, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        GT4 gt4 = this.c;
                        this.b = 1;
                        if (GT4.n(gt4, 0, 0.0f, null, this, 6, null) == objE) {
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
                    return ((C1488a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C23523x4 c23523x4, InterfaceC20315ro1 interfaceC20315ro1, GT4 gt4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c23523x4;
                this.d = interfaceC20315ro1;
                this.e = gt4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                if (!this.c.h()) {
                    AbstractC10533bm0.d(this.d, null, null, new C1488a(this.e, null), 3, null);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        c(C23523x4 c23523x4, InterfaceC20315ro1 interfaceC20315ro1, GT4 gt4, SA2 sa2, SA2 sa22, I3 i3, UA2 ua2, UA2 ua22, UA2 ua23, SA2 sa23, UA2 ua24, UA2 ua25) {
            this.a = c23523x4;
            this.b = interfaceC20315ro1;
            this.c = gt4;
            this.d = sa2;
            this.e = sa22;
            this.f = i3;
            this.g = ua2;
            this.h = ua22;
            this.i = ua23;
            this.j = sa23;
            this.k = ua24;
            this.l = ua25;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(InterfaceC11943do6 interfaceC11943do6) {
            AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
            AbstractC9939ao6.F0(interfaceC11943do6, 1.0f);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(InterfaceC11943do6 interfaceC11943do6) {
            AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
            AbstractC9939ao6.F0(interfaceC11943do6, 0.0f);
            return C19938rB7.a;
        }

        public final void c(TS4 ts4, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            AbstractC13042fc3.i(ts4, "paddingValues");
            if ((i & 6) == 0) {
                i2 = i | (interfaceC22053ub1.V(ts4) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            interfaceC22053ub1.W(-2090778721);
            if (this.a.h()) {
                CG3.g(null, null, null, interfaceC22053ub1, 0, 7);
            }
            interfaceC22053ub1.Q();
            Boolean boolValueOf = Boolean.valueOf(this.a.h());
            interfaceC22053ub1.W(-2090775725);
            boolean zD = interfaceC22053ub1.D(this.a) | interfaceC22053ub1.D(this.b) | interfaceC22053ub1.V(this.c);
            C23523x4 c23523x4 = this.a;
            InterfaceC20315ro1 interfaceC20315ro1 = this.b;
            GT4 gt4 = this.c;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new a(c23523x4, interfaceC20315ro1, gt4, null);
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC10721c52.e(boolValueOf, (InterfaceC14603iB2) objB, interfaceC22053ub1, 0);
            e.a aVar = androidx.compose.ui.e.a;
            interfaceC22053ub1.W(-2090767506);
            Object objB2 = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar2 = InterfaceC22053ub1.a;
            if (objB2 == aVar2.a()) {
                objB2 = new UA2() { // from class: ir.nasim.s4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC19861r4.c.d((InterfaceC11943do6) obj);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19861r4.y0(this.c, this.a, this.b, this.d, this.e, this.f, this.g, this.h, this.i, AbstractC6919Pn6.d(aVar, false, (UA2) objB2, 1, null), interfaceC22053ub1, 0, 0);
            interfaceC22053ub1.W(-2090750386);
            Object objB3 = interfaceC22053ub1.B();
            if (objB3 == aVar2.a()) {
                objB3 = new UA2() { // from class: ir.nasim.t4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC19861r4.c.f((InterfaceC11943do6) obj);
                    }
                };
                interfaceC22053ub1.s(objB3);
            }
            interfaceC22053ub1.Q();
            AbstractC19861r4.A0(ts4, this.a, this.c, this.j, this.d, this.e, this.k, this.l, AbstractC6919Pn6.d(aVar, false, (UA2) objB3, 1, null), interfaceC22053ub1, i2 & 14, 0);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((TS4) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.r4$d */
    static final class d implements InterfaceC16978mB2 {
        final /* synthetic */ C23523x4 a;

        d(C23523x4 c23523x4) {
            this.a = c23523x4;
        }

        public final void a(InterfaceC22573vT4 interfaceC22573vT4, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            AbstractC13042fc3.i(interfaceC22573vT4, "$this$HorizontalPager");
            AbstractC11456d23.b(AvatarAsyncImagePainterKt.h((Avatar) AbstractC15401jX0.t0(this.a.e(), i), null, true, 0, interfaceC22053ub1, 384, 10), UY6.c(QD5.avatar_title_person, interfaceC22053ub1, 0), androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null), null, InterfaceC13157fl1.a.a(), 0.0f, null, interfaceC22053ub1, 24960, 104);
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            a((InterfaceC22573vT4) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.r4$e */
    static final class e implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;
        final /* synthetic */ C23523x4 b;
        final /* synthetic */ SA2 c;
        final /* synthetic */ SA2 d;
        final /* synthetic */ UA2 e;
        final /* synthetic */ GT4 f;
        final /* synthetic */ UA2 g;

        e(SA2 sa2, C23523x4 c23523x4, SA2 sa22, SA2 sa23, UA2 ua2, GT4 gt4, UA2 ua22) {
            this.a = sa2;
            this.b = c23523x4;
            this.c = sa22;
            this.d = sa23;
            this.e = ua2;
            this.f = gt4;
            this.g = ua22;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(UA2 ua2, C23523x4 c23523x4, GT4 gt4) {
            AbstractC13042fc3.i(ua2, "$saveAvatarToGallery");
            AbstractC13042fc3.i(c23523x4, "$state");
            AbstractC13042fc3.i(gt4, "$pagerState");
            ua2.invoke(c23523x4.e().get(gt4.v()));
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 h(C23523x4 c23523x4, GT4 gt4, UA2 ua2) {
            AbstractC13042fc3.i(c23523x4, "$state");
            AbstractC13042fc3.i(gt4, "$pagerState");
            AbstractC13042fc3.i(ua2, "$removeAvatar");
            Long id = ((Avatar) c23523x4.e().get(gt4.v())).getId();
            if (id != null) {
                ua2.invoke(id);
            }
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(InterfaceC9102Ym4 interfaceC9102Ym4) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$isMoreMenuVisible");
            interfaceC9102Ym4.setValue(Boolean.TRUE);
            return C19938rB7.a;
        }

        public final void d(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null);
            SA2 sa2 = this.a;
            final C23523x4 c23523x4 = this.b;
            SA2 sa22 = this.c;
            SA2 sa23 = this.d;
            final UA2 ua2 = this.e;
            final GT4 gt4 = this.f;
            final UA2 ua22 = this.g;
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar2.o(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarH);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            float f = 36;
            androidx.compose.ui.e eVarH2 = hVar.h(androidx.compose.foundation.layout.t.t(aVar, C17784nZ1.q(f)), aVar2.f());
            C20442s11 c20442s11 = C20442s11.a;
            AbstractC20434s03.a(sa2, eVarH2, false, null, null, c20442s11.c(), interfaceC22053ub1, 196608, 28);
            interfaceC22053ub1.W(-339750402);
            if (!c23523x4.e().isEmpty()) {
                InterfaceC10970cW3 interfaceC10970cW3G2 = androidx.compose.foundation.layout.f.g(aVar2.o(), false);
                int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1, aVar);
                SA2 sa2A2 = aVar3.a();
                if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1.G();
                if (interfaceC22053ub1.h()) {
                    interfaceC22053ub1.g(sa2A2);
                } else {
                    interfaceC22053ub1.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A2 = DG7.a(interfaceC22053ub1);
                DG7.c(interfaceC22053ub1A2, interfaceC10970cW3G2, aVar3.e());
                DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
                InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
                if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                    interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                    interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
                }
                DG7.c(interfaceC22053ub1A2, eVarE2, aVar3.f());
                interfaceC22053ub1.W(1410716975);
                Object objB = interfaceC22053ub1.B();
                InterfaceC22053ub1.a aVar4 = InterfaceC22053ub1.a;
                if (objB == aVar4.a()) {
                    objB = AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
                    interfaceC22053ub1.s(objB);
                }
                final InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(1410719430);
                if (((Boolean) interfaceC9102Ym4.getValue()).booleanValue()) {
                    interfaceC22053ub1.W(1410729031);
                    boolean zV = interfaceC22053ub1.V(ua2) | interfaceC22053ub1.D(c23523x4) | interfaceC22053ub1.V(gt4);
                    Object objB2 = interfaceC22053ub1.B();
                    if (zV || objB2 == aVar4.a()) {
                        objB2 = new SA2() { // from class: ir.nasim.u4
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return AbstractC19861r4.e.f(ua2, c23523x4, gt4);
                            }
                        };
                        interfaceC22053ub1.s(objB2);
                    }
                    SA2 sa24 = (SA2) objB2;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(1410734447);
                    boolean zD = interfaceC22053ub1.D(c23523x4) | interfaceC22053ub1.V(gt4) | interfaceC22053ub1.V(ua22);
                    Object objB3 = interfaceC22053ub1.B();
                    if (zD || objB3 == aVar4.a()) {
                        objB3 = new SA2() { // from class: ir.nasim.v4
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return AbstractC19861r4.e.h(c23523x4, gt4, ua22);
                            }
                        };
                        interfaceC22053ub1.s(objB3);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC19861r4.X(interfaceC9102Ym4, sa22, sa23, sa24, (SA2) objB3, interfaceC22053ub1, 6);
                }
                interfaceC22053ub1.Q();
                androidx.compose.ui.e eVarH3 = hVar.h(androidx.compose.foundation.layout.t.t(aVar, C17784nZ1.q(f)), aVar2.h());
                interfaceC22053ub1.W(1410748867);
                Object objB4 = interfaceC22053ub1.B();
                if (objB4 == aVar4.a()) {
                    objB4 = new SA2() { // from class: ir.nasim.w4
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC19861r4.e.i(interfaceC9102Ym4);
                        }
                    };
                    interfaceC22053ub1.s(objB4);
                }
                interfaceC22053ub1.Q();
                AbstractC20434s03.a((SA2) objB4, eVarH3, false, null, null, c20442s11.d(), interfaceC22053ub1, 196614, 28);
                interfaceC22053ub1.u();
            }
            interfaceC22053ub1.Q();
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            d((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.r4$f */
    static final class f implements InterfaceC15796kB2 {
        final /* synthetic */ I3 a;

        f(I3 i3) {
            this.a = i3;
        }

        public final void a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(eVar, "it");
            if ((i & 6) == 0) {
                i |= interfaceC22053ub1.V(eVar) ? 4 : 2;
            }
            if ((i & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC20434s03.a(this.a.e(), androidx.compose.foundation.layout.t.t(eVar, G10.a.c(interfaceC22053ub1, G10.b).b().m()), false, null, null, C20442s11.a.b(), interfaceC22053ub1, 196608, 28);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.r4$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ GT4 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(GT4 gt4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = gt4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new g(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GT4 gt4 = this.c;
                int iV = gt4.v() + 1;
                this.b = 1;
                if (GT4.n(gt4, iV, 0.0f, null, this, 6, null) == objE) {
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
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.r4$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ GT4 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(GT4 gt4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = gt4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new h(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GT4 gt4 = this.c;
                int iV = gt4.v() - 1;
                this.b = 1;
                if (GT4.n(gt4, iV, 0.0f, null, this, 6, null) == objE) {
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
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void A0(final ir.nasim.TS4 r17, final ir.nasim.C23523x4 r18, final ir.nasim.GT4 r19, final ir.nasim.SA2 r20, final ir.nasim.SA2 r21, final ir.nasim.SA2 r22, final ir.nasim.UA2 r23, final ir.nasim.UA2 r24, androidx.compose.ui.e r25, ir.nasim.InterfaceC22053ub1 r26, final int r27, final int r28) {
        /*
            Method dump skipped, instructions count: 546
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC19861r4.A0(ir.nasim.TS4, ir.nasim.x4, ir.nasim.GT4, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.UA2, ir.nasim.UA2, androidx.compose.ui.e, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 B0(TS4 ts4, C23523x4 c23523x4, GT4 gt4, SA2 sa2, SA2 sa22, SA2 sa23, UA2 ua2, UA2 ua22, androidx.compose.ui.e eVar, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(ts4, "$paddingValues");
        AbstractC13042fc3.i(c23523x4, "$state");
        AbstractC13042fc3.i(gt4, "$pagerState");
        AbstractC13042fc3.i(sa2, "$onBackPress");
        AbstractC13042fc3.i(sa22, "$pickAvatarOfGallery");
        AbstractC13042fc3.i(sa23, "$pickAvatarByCamera");
        AbstractC13042fc3.i(ua2, "$saveAvatarToGallery");
        AbstractC13042fc3.i(ua22, "$removeAvatar");
        A0(ts4, c23523x4, gt4, sa2, sa22, sa23, ua2, ua22, eVar, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    private static final String G0(String str) {
        return XY6.v("\u200e+" + str);
    }

    private static final String H0(String str) {
        return "\u200e@" + str;
    }

    public static final void I(final C23523x4 c23523x4, final I3 i3, final UA2 ua2, final UA2 ua22, final SA2 sa2, final SA2 sa22, final UA2 ua23, final UA2 ua24, final UA2 ua25, final SA2 sa23, final SA2 sa24, InterfaceC22053ub1 interfaceC22053ub1, final int i, final int i2) {
        int i4;
        int i5;
        int i6;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(c23523x4, "state");
        AbstractC13042fc3.i(i3, "navigationCallback");
        AbstractC13042fc3.i(ua2, "copyAction");
        AbstractC13042fc3.i(ua22, "shareText");
        AbstractC13042fc3.i(sa2, "pickAvatarOfGallery");
        AbstractC13042fc3.i(sa22, "pickAvatarByCamera");
        AbstractC13042fc3.i(ua23, "saveAvatarToGallery");
        AbstractC13042fc3.i(ua24, "removeAvatar");
        AbstractC13042fc3.i(ua25, "showCopyActionSnackBar");
        AbstractC13042fc3.i(sa23, "resetSnackBar");
        AbstractC13042fc3.i(sa24, "onBackPress");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1635201276);
        if ((i & 6) == 0) {
            i4 = (interfaceC22053ub1J.D(c23523x4) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= interfaceC22053ub1J.V(i3) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i4 |= interfaceC22053ub1J.D(ua2) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i4 |= interfaceC22053ub1J.D(ua22) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i4 |= interfaceC22053ub1J.D(sa2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i4 |= interfaceC22053ub1J.D(sa22) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i4 |= interfaceC22053ub1J.D(ua23) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i4 |= interfaceC22053ub1J.D(ua24) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i4 |= interfaceC22053ub1J.D(ua25) ? 67108864 : 33554432;
        }
        if ((805306368 & i) == 0) {
            i4 |= interfaceC22053ub1J.D(sa23) ? 536870912 : 268435456;
        }
        if ((i2 & 6) == 0) {
            i5 = i2 | (interfaceC22053ub1J.D(sa24) ? 4 : 2);
        } else {
            i5 = i2;
        }
        if ((i4 & 306783379) == 306783378 && (i5 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            int size = c23523x4.e().size();
            interfaceC22053ub1J.W(1008816716);
            boolean zD = interfaceC22053ub1J.D(c23523x4);
            Object objB = interfaceC22053ub1J.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.f4
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return Integer.valueOf(AbstractC19861r4.J(c23523x4));
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            GT4 gt4K = IT4.k(size, 0.0f, (SA2) objB, interfaceC22053ub1J, 0, 2);
            Object objB2 = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB2 == aVar.a()) {
                objB2 = AbstractC10721c52.k(C18712p72.a, interfaceC22053ub1J);
                interfaceC22053ub1J.s(objB2);
            }
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) objB2;
            interfaceC22053ub1J.W(1008819670);
            Object objB3 = interfaceC22053ub1J.B();
            if (objB3 == aVar.a()) {
                objB3 = new C19391qG6();
                interfaceC22053ub1J.s(objB3);
            }
            C19391qG6 c19391qG6 = (C19391qG6) objB3;
            interfaceC22053ub1J.Q();
            String strJ = c23523x4.j();
            interfaceC22053ub1J.W(1008821715);
            if (strJ == null) {
                i6 = 0;
            } else {
                interfaceC22053ub1J.W(-2090800437);
                boolean zV = ((i4 & 1879048192) == 536870912) | interfaceC22053ub1J.V(strJ);
                Object objB4 = interfaceC22053ub1J.B();
                if (zV || objB4 == aVar.a()) {
                    objB4 = new a(c19391qG6, strJ, sa23, null);
                    interfaceC22053ub1J.s(objB4);
                }
                interfaceC22053ub1J.Q();
                i6 = 0;
                AbstractC10721c52.e(strJ, (InterfaceC14603iB2) objB4, interfaceC22053ub1J, 0);
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
            interfaceC22053ub1J.Q();
            final String strC = UY6.c(QD5.account_info_title, interfaceC22053ub1J, i6);
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null);
            interfaceC22053ub1J.W(1008830699);
            boolean zV2 = interfaceC22053ub1J.V(strC);
            Object objB5 = interfaceC22053ub1J.B();
            if (zV2 || objB5 == aVar.a()) {
                objB5 = new UA2() { // from class: ir.nasim.k4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC19861r4.K(strC, (InterfaceC11943do6) obj);
                    }
                };
                interfaceC22053ub1J.s(objB5);
            }
            interfaceC22053ub1J.Q();
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC11029cc6.a(AbstractC6919Pn6.d(eVarF, false, (UA2) objB5, 1, null), null, null, AbstractC19242q11.e(-124646794, true, new b(c19391qG6), interfaceC22053ub1J, 54), null, 0, G10.a.a(interfaceC22053ub1J, G10.b).r(), 0L, null, AbstractC19242q11.e(-1567321331, true, new c(c23523x4, interfaceC20315ro1, gt4K, sa2, sa22, i3, ua2, ua25, ua22, sa24, ua23, ua24), interfaceC22053ub12, 54), interfaceC22053ub12, 805309440, 438);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.l4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC19861r4.L(c23523x4, i3, ua2, ua22, sa2, sa22, ua23, ua24, ua25, sa23, sa24, i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int I0() {
        return JF5.g() ? AbstractC21822uB5.simple_arrow_left : AbstractC21822uB5.simple_arrow_right;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int J(C23523x4 c23523x4) {
        AbstractC13042fc3.i(c23523x4, "$state");
        return c23523x4.e().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 K(String str, InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(str, "$title");
        AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
        AbstractC9939ao6.l0(interfaceC11943do6, str);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 L(C23523x4 c23523x4, I3 i3, UA2 ua2, UA2 ua22, SA2 sa2, SA2 sa22, UA2 ua23, UA2 ua24, UA2 ua25, SA2 sa23, SA2 sa24, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(c23523x4, "$state");
        AbstractC13042fc3.i(i3, "$navigationCallback");
        AbstractC13042fc3.i(ua2, "$copyAction");
        AbstractC13042fc3.i(ua22, "$shareText");
        AbstractC13042fc3.i(sa2, "$pickAvatarOfGallery");
        AbstractC13042fc3.i(sa22, "$pickAvatarByCamera");
        AbstractC13042fc3.i(ua23, "$saveAvatarToGallery");
        AbstractC13042fc3.i(ua24, "$removeAvatar");
        AbstractC13042fc3.i(ua25, "$showCopyActionSnackBar");
        AbstractC13042fc3.i(sa23, "$resetSnackBar");
        AbstractC13042fc3.i(sa24, "$onBackPress");
        I(c23523x4, i3, ua2, ua22, sa2, sa22, ua23, ua24, ua25, sa23, sa24, interfaceC22053ub1, QJ5.a(i | 1), QJ5.a(i2));
        return C19938rB7.a;
    }

    private static final void M(final GT4 gt4, final C23523x4 c23523x4, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub12;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1731290342);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(gt4) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(c23523x4) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC17142mT4.a(gt4, null, null, null, 0, 0.0f, null, null, false, false, null, null, null, null, AbstractC19242q11.e(1351126119, true, new d(c23523x4), interfaceC22053ub1J, 54), interfaceC22053ub12, i2 & 14, 24576, 16382);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.j4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC19861r4.N(gt4, c23523x4, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 N(GT4 gt4, C23523x4 c23523x4, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(gt4, "$pagerState");
        AbstractC13042fc3.i(c23523x4, "$state");
        M(gt4, c23523x4, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    private static final void O(final C23523x4 c23523x4, final GT4 gt4, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        long jO;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(230838034);
        int i2 = (i & 6) == 0 ? (interfaceC22053ub1J.D(c23523x4) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(gt4) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else if (c23523x4.e().size() > 1) {
            androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.q.k(androidx.compose.ui.e.a, C17784nZ1.q(12), 0.0f, 2, null);
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(C24254yJ.a.g(), InterfaceC12529em.a.l(), interfaceC22053ub1J, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarK);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            M66 m66 = M66.a;
            interfaceC22053ub1J.W(-840528026);
            int size = c23523x4.e().size();
            for (int i3 = 0; i3 < size; i3++) {
                androidx.compose.ui.e eVarB = L66.b(m66, androidx.compose.foundation.layout.q.k(androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.t.h(FV0.a(androidx.compose.ui.e.a, N46.d(C17784nZ1.q(8))), 0.0f, 1, null), C17784nZ1.q(2)), C17784nZ1.q(1), 0.0f, 2, null), 1.0f, false, 2, null);
                if (gt4.v() == i3) {
                    interfaceC22053ub1J.W(-286178892);
                    jO = G10.a.b(interfaceC22053ub1J, G10.b).i();
                    interfaceC22053ub1J.Q();
                } else {
                    interfaceC22053ub1J.W(-286072934);
                    jO = C24381yX0.o(G10.a.b(interfaceC22053ub1J, G10.b).i(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null);
                    interfaceC22053ub1J.Q();
                }
                androidx.compose.foundation.layout.f.a(androidx.compose.foundation.b.d(eVarB, jO, null, 2, null), interfaceC22053ub1J, 0);
            }
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Z3
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC19861r4.P(c23523x4, gt4, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 P(C23523x4 c23523x4, GT4 gt4, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c23523x4, "$state");
        AbstractC13042fc3.i(gt4, "$pagerState");
        O(c23523x4, gt4, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    private static final void Q(final InterfaceC9102Ym4 interfaceC9102Ym4, final SA2 sa2, final SA2 sa22, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1980505746);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(interfaceC9102Ym4) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(sa22) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            String strC = UY6.c(QD5.account_info_phone_menu_copy, interfaceC22053ub1J, 0);
            int i3 = AbstractC21822uB5.copy;
            interfaceC22053ub1J.W(-360937544);
            boolean z = (i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32;
            Object objB = interfaceC22053ub1J.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.c4
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC19861r4.R(sa2);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            C7847Tl1 c7847Tl1 = new C7847Tl1(strC, i3, 0, (SA2) objB, 4, null);
            String strC2 = UY6.c(AbstractC12217eE5.phone_menu_change_number, interfaceC22053ub1J, 0);
            int i4 = AbstractC21822uB5.repeat;
            interfaceC22053ub1J.W(-360930215);
            boolean z2 = (i2 & 896) == 256;
            Object objB2 = interfaceC22053ub1J.B();
            if (z2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.d4
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC19861r4.S(sa22);
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            List listS = AbstractC10360bX0.s(c7847Tl1, new C7847Tl1(strC2, i4, 0, (SA2) objB2, 4, null));
            boolean zBooleanValue = ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
            interfaceC22053ub1J.W(-360924601);
            boolean z3 = (i2 & 14) == 4;
            Object objB3 = interfaceC22053ub1J.B();
            if (z3 || objB3 == InterfaceC22053ub1.a.a()) {
                objB3 = new SA2() { // from class: ir.nasim.e4
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC19861r4.T(interfaceC9102Ym4);
                    }
                };
                interfaceC22053ub1J.s(objB3);
            }
            interfaceC22053ub1J.Q();
            AbstractC9090Yl1.b(0L, listS, zBooleanValue, (SA2) objB3, 0L, 0L, 0L, interfaceC22053ub1J, 0, 113);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.g4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC19861r4.U(interfaceC9102Ym4, sa2, sa22, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 R(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$copyAction");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 S(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$changePhone");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 T(InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$isVisible");
        interfaceC9102Ym4.setValue(Boolean.FALSE);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 U(InterfaceC9102Ym4 interfaceC9102Ym4, SA2 sa2, SA2 sa22, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$isVisible");
        AbstractC13042fc3.i(sa2, "$copyAction");
        AbstractC13042fc3.i(sa22, "$changePhone");
        Q(interfaceC9102Ym4, sa2, sa22, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    private static final void V(final SA2 sa2, final C23523x4 c23523x4, final SA2 sa22, final SA2 sa23, final UA2 ua2, final GT4 gt4, final UA2 ua22, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(2135226249);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(sa2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(c23523x4) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(sa22) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.D(sa23) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= interfaceC22053ub1J.D(ua2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= interfaceC22053ub1J.V(gt4) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= interfaceC22053ub1J.D(ua22) ? 1048576 : 524288;
        }
        if ((i2 & 599187) == 599186 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.b), AbstractC19242q11.e(-846058423, true, new e(sa2, c23523x4, sa22, sa23, ua2, gt4, ua22), interfaceC22053ub1J, 54), interfaceC22053ub1J, C7252Qx5.i | 48);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.a4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC19861r4.W(sa2, c23523x4, sa22, sa23, ua2, gt4, ua22, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 W(SA2 sa2, C23523x4 c23523x4, SA2 sa22, SA2 sa23, UA2 ua2, GT4 gt4, UA2 ua22, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(sa2, "$onBackPress");
        AbstractC13042fc3.i(c23523x4, "$state");
        AbstractC13042fc3.i(sa22, "$pickAvatarOfGallery");
        AbstractC13042fc3.i(sa23, "$pickAvatarByCamera");
        AbstractC13042fc3.i(ua2, "$saveAvatarToGallery");
        AbstractC13042fc3.i(gt4, "$pagerState");
        AbstractC13042fc3.i(ua22, "$removeAvatar");
        V(sa2, c23523x4, sa22, sa23, ua2, gt4, ua22, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(final InterfaceC9102Ym4 interfaceC9102Ym4, final SA2 sa2, final SA2 sa22, final SA2 sa23, final SA2 sa24, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1578427767);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(interfaceC9102Ym4) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(sa22) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.D(sa23) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= interfaceC22053ub1J.D(sa24) ? 16384 : 8192;
        }
        if ((i2 & 9363) == 9362 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            List listP = AbstractC10360bX0.p(new C7847Tl1(UY6.c(QD5.pick_photo_gallery, interfaceC22053ub1J, 0), AbstractC21822uB5.image, 0, sa2, 4, null), new C7847Tl1(UY6.c(QD5.pick_photo_camera, interfaceC22053ub1J, 0), AbstractC21822uB5.camera, 0, sa22, 4, null), new C7847Tl1(UY6.c(QD5.avatar_save_to_gallery, interfaceC22053ub1J, 0), AbstractC21822uB5.download, 0, sa23, 4, null), new C7847Tl1(UY6.c(QD5.avatar_delete, interfaceC22053ub1J, 0), AbstractC21822uB5.delete, 0, sa24, 4, null));
            boolean zBooleanValue = ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
            interfaceC22053ub1J.W(-2007017565);
            boolean z = (i2 & 14) == 4;
            Object objB = interfaceC22053ub1J.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.J3
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC19861r4.Y(interfaceC9102Ym4);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            AbstractC9090Yl1.b(0L, listP, zBooleanValue, (SA2) objB, 0L, 0L, 0L, interfaceC22053ub1J, 0, 113);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.U3
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC19861r4.Z(interfaceC9102Ym4, sa2, sa22, sa23, sa24, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Y(InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$isVisible");
        interfaceC9102Ym4.setValue(Boolean.FALSE);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Z(InterfaceC9102Ym4 interfaceC9102Ym4, SA2 sa2, SA2 sa22, SA2 sa23, SA2 sa24, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$isVisible");
        AbstractC13042fc3.i(sa2, "$pickAvatarOfGallery");
        AbstractC13042fc3.i(sa22, "$pickAvatarByCamera");
        AbstractC13042fc3.i(sa23, "$saveToGallery");
        AbstractC13042fc3.i(sa24, "$removeAvatar");
        X(interfaceC9102Ym4, sa2, sa22, sa23, sa24, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    private static final void a0(final I3 i3, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-942802031);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(i3) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
            String strC = UY6.c(QD5.passport_name, interfaceC22053ub1J, 0);
            G10 g10 = G10.a;
            int i4 = G10.b;
            AbstractC16797ls7.j(strC, null, androidx.compose.foundation.layout.q.d(g10.c(interfaceC22053ub1J, i4).b().c(), g10.c(interfaceC22053ub1J, i4).b().e(), g10.c(interfaceC22053ub1J, i4).b().r(), g10.c(interfaceC22053ub1J, i4).b().e()), null, AbstractC19242q11.e(1852240846, true, new f(i3), interfaceC22053ub1J, 54), null, null, i3.e(), null, interfaceC22053ub1J, 24576, 362);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.b4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC19861r4.b0(i3, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 b0(I3 i3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(i3, "$navigationCallback");
        a0(i3, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    private static final void c0(final InterfaceC9102Ym4 interfaceC9102Ym4, final SA2 sa2, final SA2 sa22, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub12;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(2069164279);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(interfaceC9102Ym4) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(sa22) ? 256 : 128;
        }
        int i3 = i2;
        if ((i3 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            List listP = AbstractC10360bX0.p(new C7847Tl1(UY6.c(QD5.pick_photo_gallery, interfaceC22053ub1J, 0), AbstractC21822uB5.image, 0, sa2, 4, null), new C7847Tl1(UY6.c(QD5.pick_photo_camera, interfaceC22053ub1J, 0), AbstractC21822uB5.camera, 0, sa22, 4, null));
            boolean zBooleanValue = ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
            interfaceC22053ub1J.W(673982077);
            boolean z = (i3 & 14) == 4;
            Object objB = interfaceC22053ub1J.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.h4
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC19861r4.d0(interfaceC9102Ym4);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            SA2 sa23 = (SA2) objB;
            interfaceC22053ub1J.Q();
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC9090Yl1.b(0L, listP, zBooleanValue, sa23, 0L, 0L, 0L, interfaceC22053ub12, 0, 113);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.i4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC19861r4.e0(interfaceC9102Ym4, sa2, sa22, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 d0(InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$isVisible");
        interfaceC9102Ym4.setValue(Boolean.FALSE);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 e0(InterfaceC9102Ym4 interfaceC9102Ym4, SA2 sa2, SA2 sa22, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$isVisible");
        AbstractC13042fc3.i(sa2, "$pickAvatarOfGallery");
        AbstractC13042fc3.i(sa22, "$pickAvatarByCamera");
        c0(interfaceC9102Ym4, sa2, sa22, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    private static final void f0(final GT4 gt4, final C23523x4 c23523x4, final InterfaceC20315ro1 interfaceC20315ro1, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(617143241);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(gt4) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(c23523x4) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(interfaceC20315ro1) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarB = androidx.compose.foundation.b.b(androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.t.i(aVar, C17784nZ1.q(360)), 0.0f, 1, null), C5495Jo7.a.J2() ? AbstractC12520el0.a.e(AbstractC12520el0.b, AbstractC10360bX0.p(C24381yX0.k(DX0.e(54.0f, 55.0f, 59.0f, 0.3f, null, 16, null)), C24381yX0.k(DX0.e(54.0f, 55.0f, 59.0f, 0.6f, null, 16, null)), C24381yX0.k(DX0.e(54.0f, 55.0f, 59.0f, 0.3f, null, 16, null))), 0L, 0L, 0, 14, null) : AbstractC12520el0.a.e(AbstractC12520el0.b, AbstractC10360bX0.p(C24381yX0.k(DX0.e(9.0f, 30.0f, 66.0f, 0.1f, null, 16, null)), C24381yX0.k(DX0.e(9.0f, 30.0f, 66.0f, 0.04f, null, 16, null)), C24381yX0.k(DX0.e(9.0f, 30.0f, 66.0f, 0.1f, null, 16, null))), 0L, 0L, 0, 14, null), null, 0.0f, 6, null);
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar2.o(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarB);
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
            int i3 = i2 & 14;
            M(gt4, c23523x4, interfaceC22053ub1J, (i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | i3);
            interfaceC22053ub1J.W(-2141879048);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar4 = InterfaceC22053ub1.a;
            if (objB == aVar4.a()) {
                objB = new UA2() { // from class: ir.nasim.o4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC19861r4.g0((InterfaceC11943do6) obj);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            float f2 = 60;
            androidx.compose.ui.e eVarH = hVar.h(androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.t.h(AbstractC6919Pn6.a(aVar, (UA2) objB), 0.0f, 1, null), C17784nZ1.q(f2)), aVar2.m());
            AbstractC12520el0.a aVar5 = AbstractC12520el0.b;
            androidx.compose.foundation.layout.f.a(androidx.compose.foundation.b.b(eVarH, AbstractC12520el0.a.j(aVar5, AbstractC10360bX0.p(C24381yX0.k(DX0.e(0.0f, 0.0f, 0.0f, 0.4f, null, 16, null)), C24381yX0.k(DX0.e(0.0f, 0.0f, 0.0f, 0.3f, null, 16, null)), C24381yX0.k(DX0.e(0.0f, 0.0f, 0.0f, 0.2f, null, 16, null)), C24381yX0.k(DX0.e(0.0f, 0.0f, 0.0f, 0.1f, null, 16, null)), C24381yX0.k(DX0.e(0.0f, 0.0f, 0.0f, 0.08f, null, 16, null)), C24381yX0.k(DX0.e(0.0f, 0.0f, 0.0f, 0.05f, null, 16, null)), C24381yX0.k(DX0.e(0.0f, 0.0f, 0.0f, 0.02f, null, 16, null)), C24381yX0.k(DX0.e(0.0f, 0.0f, 0.0f, 0.01f, null, 16, null)), C24381yX0.k(DX0.e(0.0f, 0.0f, 0.0f, 0.0f, null, 16, null)), C24381yX0.k(DX0.e(0.0f, 0.0f, 0.0f, 0.0f, null, 16, null))), 0.0f, 0.0f, 0, 14, null), null, 0.0f, 6, null), interfaceC22053ub1J, 0);
            interfaceC22053ub1J.W(-2141848904);
            Object objB2 = interfaceC22053ub1J.B();
            if (objB2 == aVar4.a()) {
                objB2 = new UA2() { // from class: ir.nasim.p4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC19861r4.h0((InterfaceC11943do6) obj);
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            androidx.compose.foundation.layout.f.a(androidx.compose.foundation.b.b(hVar.h(androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.t.h(AbstractC6919Pn6.a(aVar, (UA2) objB2), 0.0f, 1, null), C17784nZ1.q(f2)), aVar2.b()), AbstractC12520el0.a.j(aVar5, AbstractC10360bX0.p(C24381yX0.k(DX0.e(0.0f, 0.0f, 0.0f, 0.0f, null, 16, null)), C24381yX0.k(DX0.e(0.0f, 0.0f, 0.0f, 0.0f, null, 16, null)), C24381yX0.k(DX0.e(0.0f, 0.0f, 0.0f, 0.01f, null, 16, null)), C24381yX0.k(DX0.e(0.0f, 0.0f, 0.0f, 0.02f, null, 16, null)), C24381yX0.k(DX0.e(0.0f, 0.0f, 0.0f, 0.05f, null, 16, null)), C24381yX0.k(DX0.e(0.0f, 0.0f, 0.0f, 0.08f, null, 16, null)), C24381yX0.k(DX0.e(0.0f, 0.0f, 0.0f, 0.1f, null, 16, null)), C24381yX0.k(DX0.e(0.0f, 0.0f, 0.0f, 0.2f, null, 16, null)), C24381yX0.k(DX0.e(0.0f, 0.0f, 0.0f, 0.3f, null, 16, null))), 0.0f, 0.0f, 0, 14, null), null, 0.0f, 6, null), interfaceC22053ub1J, 0);
            float f3 = 48;
            androidx.compose.ui.e eVarY = androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.d(hVar.h(aVar, aVar2.f()), 0.0f, 1, null), C17784nZ1.q(f3));
            interfaceC22053ub1J.W(-2141816936);
            Object objB3 = interfaceC22053ub1J.B();
            if (objB3 == aVar4.a()) {
                objB3 = new UA2() { // from class: ir.nasim.q4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC19861r4.i0((InterfaceC11943do6) obj);
                    }
                };
                interfaceC22053ub1J.s(objB3);
            }
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarA = AbstractC6919Pn6.a(eVarY, (UA2) objB3);
            interfaceC22053ub1J.W(-2141807972);
            Object objB4 = interfaceC22053ub1J.B();
            if (objB4 == aVar4.a()) {
                objB4 = AbstractC23831xb3.a();
                interfaceC22053ub1J.s(objB4);
            }
            InterfaceC18507om4 interfaceC18507om4 = (InterfaceC18507om4) objB4;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(-2141814780);
            boolean zD = interfaceC22053ub1J.D(interfaceC20315ro1) | (i3 == 4);
            Object objB5 = interfaceC22053ub1J.B();
            if (zD || objB5 == aVar4.a()) {
                objB5 = new SA2() { // from class: ir.nasim.K3
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC19861r4.j0(interfaceC20315ro1, gt4);
                    }
                };
                interfaceC22053ub1J.s(objB5);
            }
            interfaceC22053ub1J.Q();
            androidx.compose.foundation.layout.f.a(androidx.compose.foundation.e.d(eVarA, interfaceC18507om4, null, false, null, null, (SA2) objB5, 28, null), interfaceC22053ub1J, 0);
            androidx.compose.ui.e eVarY2 = androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.d(hVar.h(aVar, aVar2.h()), 0.0f, 1, null), C17784nZ1.q(f3));
            interfaceC22053ub1J.W(-2141798696);
            Object objB6 = interfaceC22053ub1J.B();
            if (objB6 == aVar4.a()) {
                objB6 = new UA2() { // from class: ir.nasim.L3
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC19861r4.k0((InterfaceC11943do6) obj);
                    }
                };
                interfaceC22053ub1J.s(objB6);
            }
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarA2 = AbstractC6919Pn6.a(eVarY2, (UA2) objB6);
            interfaceC22053ub1J.W(-2141789732);
            Object objB7 = interfaceC22053ub1J.B();
            if (objB7 == aVar4.a()) {
                objB7 = AbstractC23831xb3.a();
                interfaceC22053ub1J.s(objB7);
            }
            InterfaceC18507om4 interfaceC18507om42 = (InterfaceC18507om4) objB7;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(-2141796540);
            boolean zD2 = interfaceC22053ub1J.D(interfaceC20315ro1) | (i3 == 4);
            Object objB8 = interfaceC22053ub1J.B();
            if (zD2 || objB8 == aVar4.a()) {
                objB8 = new SA2() { // from class: ir.nasim.M3
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC19861r4.l0(interfaceC20315ro1, gt4);
                    }
                };
                interfaceC22053ub1J.s(objB8);
            }
            interfaceC22053ub1J.Q();
            androidx.compose.foundation.layout.f.a(androidx.compose.foundation.e.d(eVarA2, interfaceC18507om42, null, false, null, null, (SA2) objB8, 28, null), interfaceC22053ub1J, 0);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.N3
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC19861r4.m0(gt4, c23523x4, interfaceC20315ro1, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g0(InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(interfaceC11943do6, "$this$clearAndSetSemantics");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h0(InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(interfaceC11943do6, "$this$clearAndSetSemantics");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i0(InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(interfaceC11943do6, "$this$clearAndSetSemantics");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j0(InterfaceC20315ro1 interfaceC20315ro1, GT4 gt4) {
        AbstractC13042fc3.i(interfaceC20315ro1, "$scope");
        AbstractC13042fc3.i(gt4, "$pagerState");
        AbstractC10533bm0.d(interfaceC20315ro1, null, null, new g(gt4, null), 3, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k0(InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(interfaceC11943do6, "$this$clearAndSetSemantics");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l0(InterfaceC20315ro1 interfaceC20315ro1, GT4 gt4) {
        AbstractC13042fc3.i(interfaceC20315ro1, "$scope");
        AbstractC13042fc3.i(gt4, "$pagerState");
        AbstractC10533bm0.d(interfaceC20315ro1, null, null, new h(gt4, null), 3, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m0(GT4 gt4, C23523x4 c23523x4, InterfaceC20315ro1 interfaceC20315ro1, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(gt4, "$pagerState");
        AbstractC13042fc3.i(c23523x4, "$state");
        AbstractC13042fc3.i(interfaceC20315ro1, "$scope");
        f0(gt4, c23523x4, interfaceC20315ro1, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    private static final void n0(final SA2 sa2, final SA2 sa22, final C23523x4 c23523x4, final I3 i3, final UA2 ua2, final UA2 ua22, final UA2 ua23, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        int i4;
        boolean z;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(212120558);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(sa2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(sa22) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(c23523x4) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.V(i3) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= interfaceC22053ub1J.D(ua2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= interfaceC22053ub1J.D(ua22) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= interfaceC22053ub1J.D(ua23) ? 1048576 : 524288;
        }
        int i5 = i2;
        if ((i5 & 599187) == 599186 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar2.o(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, aVar);
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
            interfaceC22053ub1J.W(1319350185);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar4 = InterfaceC22053ub1.a;
            if (objB == aVar4.a()) {
                objB = AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
                interfaceC22053ub1J.s(objB);
            }
            final InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(1319351736);
            if (((Boolean) interfaceC9102Ym4.getValue()).booleanValue()) {
                int i6 = i5 << 3;
                c0(interfaceC9102Ym4, sa2, sa22, interfaceC22053ub1J, (i6 & 896) | (i6 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | 6);
            }
            interfaceC22053ub1J.Q();
            String strC = UY6.c(QD5.add_profile_photo, interfaceC22053ub1J, 0);
            int i7 = AbstractC21822uB5.add_photo;
            interfaceC22053ub1J.W(1319363535);
            Object objB2 = interfaceC22053ub1J.B();
            if (objB2 == aVar4.a()) {
                objB2 = new SA2() { // from class: ir.nasim.O3
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC19861r4.o0(interfaceC9102Ym4);
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            AbstractC16797ls7.i(strC, i7, null, null, null, null, null, (SA2) objB2, null, false, interfaceC22053ub1J, 12582912, 892);
            interfaceC22053ub1J.u();
            MY2.b(null, EnumC10352bW1.a, 0L, interfaceC22053ub1J, 48, 5);
            String strC2 = UY6.c(QD5.name, interfaceC22053ub1J, 0);
            String strF = c23523x4.f();
            int iI0 = I0();
            SA2 sa2B = i3.b();
            interfaceC22053ub1J.W(-760588000);
            int i8 = i5 & 57344;
            boolean zD = (i8 == 16384) | interfaceC22053ub1J.D(c23523x4);
            int i9 = i5 & 458752;
            boolean z2 = zD | (i9 == 131072);
            Object objB3 = interfaceC22053ub1J.B();
            if (z2 || objB3 == aVar4.a()) {
                objB3 = new SA2() { // from class: ir.nasim.P3
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC19861r4.p0(ua2, c23523x4, ua22);
                    }
                };
                interfaceC22053ub1J.s(objB3);
            }
            interfaceC22053ub1J.Q();
            I00.c(strC2, strF, iI0, null, null, sa2B, (SA2) objB3, null, false, null, null, interfaceC22053ub1J, 0, 0, 1944);
            MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
            interfaceC22053ub1J.W(-760582038);
            Object objB4 = interfaceC22053ub1J.B();
            if (objB4 == aVar4.a()) {
                objB4 = AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
                interfaceC22053ub1J.s(objB4);
            }
            final InterfaceC9102Ym4 interfaceC9102Ym42 = (InterfaceC9102Ym4) objB4;
            interfaceC22053ub1J.Q();
            InterfaceC10970cW3 interfaceC10970cW3G2 = androidx.compose.foundation.layout.f.g(aVar2.o(), false);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1J, aVar);
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
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3G2, aVar3.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar3.f());
            String strC3 = UY6.c(QD5.account_info_click_to_edit_phone, interfaceC22053ub1J, 0);
            String strG0 = G0(c23523x4.g());
            int i10 = AbstractC21822uB5.copy;
            String strC4 = UY6.c(QD5.account_info_copy_phone_content_description, interfaceC22053ub1J, 0);
            interfaceC22053ub1J.W(1319392750);
            Object objB5 = interfaceC22053ub1J.B();
            if (objB5 == aVar4.a()) {
                objB5 = new SA2() { // from class: ir.nasim.Q3
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC19861r4.q0(interfaceC9102Ym42);
                    }
                };
                interfaceC22053ub1J.s(objB5);
            }
            SA2 sa23 = (SA2) objB5;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(1319396262);
            boolean zD2 = (i8 == 16384) | interfaceC22053ub1J.D(c23523x4) | (i9 == 131072);
            Object objB6 = interfaceC22053ub1J.B();
            if (zD2 || objB6 == aVar4.a()) {
                objB6 = new SA2() { // from class: ir.nasim.R3
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC19861r4.r0(ua2, c23523x4, ua22);
                    }
                };
                interfaceC22053ub1J.s(objB6);
            }
            SA2 sa24 = (SA2) objB6;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(1319402502);
            boolean zD3 = (i8 == 16384) | interfaceC22053ub1J.D(c23523x4) | (i9 == 131072);
            Object objB7 = interfaceC22053ub1J.B();
            if (zD3 || objB7 == aVar4.a()) {
                objB7 = new SA2() { // from class: ir.nasim.S3
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC19861r4.s0(ua2, c23523x4, ua22);
                    }
                };
                interfaceC22053ub1J.s(objB7);
            }
            interfaceC22053ub1J.Q();
            I00.c(strC3, strG0, i10, null, strC4, sa23, sa24, (SA2) objB7, false, null, null, interfaceC22053ub1J, 196608, 0, 1800);
            interfaceC22053ub1J.W(1319411238);
            if (i9 == 131072) {
                z = true;
                i4 = 16384;
            } else {
                i4 = 16384;
                z = false;
            }
            boolean zD4 = (i8 == i4) | z | interfaceC22053ub1J.D(c23523x4);
            Object objB8 = interfaceC22053ub1J.B();
            if (zD4 || objB8 == aVar4.a()) {
                objB8 = new SA2() { // from class: ir.nasim.T3
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC19861r4.t0(ua22, ua2, c23523x4);
                    }
                };
                interfaceC22053ub1J.s(objB8);
            }
            interfaceC22053ub1J.Q();
            Q(interfaceC9102Ym42, (SA2) objB8, i3.c(), interfaceC22053ub1J, 6);
            interfaceC22053ub1J.u();
            MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
            String strC5 = UY6.c(QD5.account_info_user_id, interfaceC22053ub1J, 0);
            interfaceC22053ub1J.W(-760539402);
            String strH0 = c23523x4.k().length() > 0 ? H0(c23523x4.k()) : UY6.c(QD5.account_info_edit_user_id_place_holder, interfaceC22053ub1J, 0);
            interfaceC22053ub1J.Q();
            boolean z3 = c23523x4.k().length() == 0;
            int i11 = AbstractC21822uB5.share;
            String strC6 = UY6.c(QD5.account_info_share_username_content_description, interfaceC22053ub1J, 0);
            SA2 sa2D = i3.d();
            interfaceC22053ub1J.W(-760524681);
            boolean zD5 = interfaceC22053ub1J.D(c23523x4) | (i8 == 16384) | (i9 == 131072);
            Object objB9 = interfaceC22053ub1J.B();
            if (zD5 || objB9 == aVar4.a()) {
                objB9 = new SA2() { // from class: ir.nasim.V3
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC19861r4.u0(c23523x4, ua2, ua22);
                    }
                };
                interfaceC22053ub1J.s(objB9);
            }
            SA2 sa25 = (SA2) objB9;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(-760517179);
            boolean zD6 = ((i5 & 3670016) == 1048576) | interfaceC22053ub1J.D(c23523x4);
            Object objB10 = interfaceC22053ub1J.B();
            if (zD6 || objB10 == aVar4.a()) {
                objB10 = new SA2() { // from class: ir.nasim.W3
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC19861r4.v0(ua23, c23523x4);
                    }
                };
                interfaceC22053ub1J.s(objB10);
            }
            interfaceC22053ub1J.Q();
            I00.c(strC5, strH0, i11, null, strC6, sa2D, sa25, (SA2) objB10, z3, null, null, interfaceC22053ub1J, 0, 0, 1544);
            MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
            String strC7 = UY6.c(QD5.account_info_about_me, interfaceC22053ub1J, 0);
            interfaceC22053ub1J.W(-760510543);
            String strD = c23523x4.d();
            if (strD.length() == 0) {
                strD = UY6.c(QD5.account_info_edit_about_place_holder, interfaceC22053ub1J, 0);
            }
            interfaceC22053ub1J.Q();
            boolean z4 = c23523x4.d().length() == 0;
            int iI02 = I0();
            SA2 sa2A3 = i3.a();
            interfaceC22053ub1J.W(-760502489);
            boolean zD7 = interfaceC22053ub1J.D(c23523x4) | (i8 == 16384) | (i9 == 131072);
            Object objB11 = interfaceC22053ub1J.B();
            if (zD7 || objB11 == aVar4.a()) {
                objB11 = new SA2() { // from class: ir.nasim.X3
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC19861r4.w0(c23523x4, ua2, ua22);
                    }
                };
                interfaceC22053ub1J.s(objB11);
            }
            interfaceC22053ub1J.Q();
            I00.c(strC7, strD, iI02, null, null, sa2A3, (SA2) objB11, null, z4, null, null, interfaceC22053ub1J, 0, 0, 1688);
            if (c23523x4.i()) {
                a0(i3, interfaceC22053ub1J, (i5 >> 9) & 14);
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Y3
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC19861r4.x0(sa2, sa22, c23523x4, i3, ua2, ua22, ua23, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o0(InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$isPickAvatarMenuVisible");
        interfaceC9102Ym4.setValue(Boolean.TRUE);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p0(UA2 ua2, C23523x4 c23523x4, UA2 ua22) {
        AbstractC13042fc3.i(ua2, "$copyAction");
        AbstractC13042fc3.i(c23523x4, "$state");
        AbstractC13042fc3.i(ua22, "$showCopyActionSnackBar");
        ua2.invoke(c23523x4.f());
        String strC = FH3.C(QD5.toast_name_copied);
        AbstractC13042fc3.h(strC, "getString(...)");
        ua22.invoke(strC);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 q0(InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$isChangePhoneNumberVisible");
        interfaceC9102Ym4.setValue(Boolean.TRUE);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r0(UA2 ua2, C23523x4 c23523x4, UA2 ua22) {
        AbstractC13042fc3.i(ua2, "$copyAction");
        AbstractC13042fc3.i(c23523x4, "$state");
        AbstractC13042fc3.i(ua22, "$showCopyActionSnackBar");
        ua2.invoke(G0(c23523x4.g()));
        String strC = FH3.C(QD5.toast_phone_copied);
        AbstractC13042fc3.h(strC, "getString(...)");
        ua22.invoke(strC);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 s0(UA2 ua2, C23523x4 c23523x4, UA2 ua22) {
        AbstractC13042fc3.i(ua2, "$copyAction");
        AbstractC13042fc3.i(c23523x4, "$state");
        AbstractC13042fc3.i(ua22, "$showCopyActionSnackBar");
        ua2.invoke(G0(c23523x4.g()));
        String strC = FH3.C(QD5.toast_phone_copied);
        AbstractC13042fc3.h(strC, "getString(...)");
        ua22.invoke(strC);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t0(UA2 ua2, UA2 ua22, C23523x4 c23523x4) {
        AbstractC13042fc3.i(ua2, "$showCopyActionSnackBar");
        AbstractC13042fc3.i(ua22, "$copyAction");
        AbstractC13042fc3.i(c23523x4, "$state");
        String strC = FH3.C(QD5.toast_phone_copied);
        AbstractC13042fc3.h(strC, "getString(...)");
        ua2.invoke(strC);
        ua22.invoke(G0(c23523x4.g()));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u0(C23523x4 c23523x4, UA2 ua2, UA2 ua22) {
        AbstractC13042fc3.i(c23523x4, "$state");
        AbstractC13042fc3.i(ua2, "$copyAction");
        AbstractC13042fc3.i(ua22, "$showCopyActionSnackBar");
        if (c23523x4.k().length() > 0) {
            ua2.invoke(H0(c23523x4.k()));
            String strC = FH3.C(QD5.toast_nickname_copied);
            AbstractC13042fc3.h(strC, "getString(...)");
            ua22.invoke(strC);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 v0(UA2 ua2, C23523x4 c23523x4) {
        AbstractC13042fc3.i(ua2, "$shareText");
        AbstractC13042fc3.i(c23523x4, "$state");
        ua2.invoke(H0(c23523x4.k()));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 w0(C23523x4 c23523x4, UA2 ua2, UA2 ua22) {
        AbstractC13042fc3.i(c23523x4, "$state");
        AbstractC13042fc3.i(ua2, "$copyAction");
        AbstractC13042fc3.i(ua22, "$showCopyActionSnackBar");
        if (c23523x4.d().length() > 0) {
            ua2.invoke(c23523x4.d());
            String strC = FH3.C(QD5.toast_about_me_copied);
            AbstractC13042fc3.h(strC, "getString(...)");
            ua22.invoke(strC);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 x0(SA2 sa2, SA2 sa22, C23523x4 c23523x4, I3 i3, UA2 ua2, UA2 ua22, UA2 ua23, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(sa2, "$pickAvatarOfGallery");
        AbstractC13042fc3.i(sa22, "$pickAvatarByCamera");
        AbstractC13042fc3.i(c23523x4, "$state");
        AbstractC13042fc3.i(i3, "$navigationCallback");
        AbstractC13042fc3.i(ua2, "$copyAction");
        AbstractC13042fc3.i(ua22, "$showCopyActionSnackBar");
        AbstractC13042fc3.i(ua23, "$shareText");
        n0(sa2, sa22, c23523x4, i3, ua2, ua22, ua23, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void y0(final ir.nasim.GT4 r23, final ir.nasim.C23523x4 r24, final ir.nasim.InterfaceC20315ro1 r25, final ir.nasim.SA2 r26, final ir.nasim.SA2 r27, final ir.nasim.I3 r28, final ir.nasim.UA2 r29, final ir.nasim.UA2 r30, final ir.nasim.UA2 r31, androidx.compose.ui.e r32, ir.nasim.InterfaceC22053ub1 r33, final int r34, final int r35) {
        /*
            Method dump skipped, instructions count: 573
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC19861r4.y0(ir.nasim.GT4, ir.nasim.x4, ir.nasim.ro1, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.I3, ir.nasim.UA2, ir.nasim.UA2, ir.nasim.UA2, androidx.compose.ui.e, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 z0(GT4 gt4, C23523x4 c23523x4, InterfaceC20315ro1 interfaceC20315ro1, SA2 sa2, SA2 sa22, I3 i3, UA2 ua2, UA2 ua22, UA2 ua23, androidx.compose.ui.e eVar, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(gt4, "$pagerState");
        AbstractC13042fc3.i(c23523x4, "$state");
        AbstractC13042fc3.i(interfaceC20315ro1, "$scope");
        AbstractC13042fc3.i(sa2, "$pickAvatarOfGallery");
        AbstractC13042fc3.i(sa22, "$pickAvatarByCamera");
        AbstractC13042fc3.i(i3, "$navigationCallback");
        AbstractC13042fc3.i(ua2, "$copyAction");
        AbstractC13042fc3.i(ua22, "$showCopyActionSnackBar");
        AbstractC13042fc3.i(ua23, "$shareText");
        y0(gt4, c23523x4, interfaceC20315ro1, sa2, sa22, i3, ua2, ua22, ua23, eVar, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }
}
