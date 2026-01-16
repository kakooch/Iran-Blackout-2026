package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.gov.nist.core.Separators;
import androidx.compose.ui.e;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC14472hy4;
import ir.nasim.C13245fu;
import ir.nasim.C24254yJ;
import ir.nasim.FP7;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.LP;
import ir.nasim.OA2;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class FP7 {

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ SQ c;
        final /* synthetic */ InterfaceC9102Ym4 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(SQ sq, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = sq;
            this.d = interfaceC9102Ym4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            if (this.c == SQ.j) {
                FP7.i(this.d, true);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class b implements PointerInputEventHandler {
        final /* synthetic */ InterfaceC3630Br2 a;

        b(InterfaceC3630Br2 interfaceC3630Br2) {
            this.a = interfaceC3630Br2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 b(InterfaceC3630Br2 interfaceC3630Br2, ZG4 zg4) {
            AbstractC13042fc3.i(interfaceC3630Br2, "$localFocusManager");
            InterfaceC3630Br2.m(interfaceC3630Br2, false, 1, null);
            return C19938rB7.a;
        }

        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
        public final Object invoke(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20295rm1 interfaceC20295rm1) {
            final InterfaceC3630Br2 interfaceC3630Br2 = this.a;
            Object objK = AbstractC20271rj7.k(interfaceC9049Yg5, null, null, null, new UA2() { // from class: ir.nasim.JP7
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return FP7.b.b(interfaceC3630Br2, (ZG4) obj);
                }
            }, interfaceC20295rm1, 7, null);
            return objK == AbstractC14862ic3.e() ? objK : C19938rB7.a;
        }
    }

    static final class c implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.navigation.e a;
        final /* synthetic */ SA2 b;

        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ androidx.navigation.e a;
            final /* synthetic */ SA2 b;

            /* renamed from: ir.nasim.FP7$c$a$a, reason: collision with other inner class name */
            static final class C0367a implements InterfaceC14603iB2 {
                final /* synthetic */ androidx.navigation.e a;

                C0367a(androidx.navigation.e eVar) {
                    this.a = eVar;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 c(androidx.navigation.e eVar) {
                    AbstractC13042fc3.i(eVar, "$navController");
                    eVar.V();
                    return C19938rB7.a;
                }

                public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    interfaceC22053ub1.W(-1349747714);
                    boolean zD = interfaceC22053ub1.D(this.a);
                    final androidx.navigation.e eVar = this.a;
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new SA2() { // from class: ir.nasim.KP7
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return FP7.c.a.C0367a.c(eVar);
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC20434s03.a((SA2) objB, null, false, null, null, C3710Ca1.a.b(), interfaceC22053ub1, 196608, 30);
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    return C19938rB7.a;
                }
            }

            static final class b implements InterfaceC15796kB2 {
                final /* synthetic */ SA2 a;

                b(SA2 sa2) {
                    this.a = sa2;
                }

                public final void a(L66 l66, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(l66, "$this$CenterAlignedTopAppBar");
                    if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                    } else {
                        AbstractC16288l12.f(this.a, false, false, interfaceC22053ub1, 0, 6);
                    }
                }

                @Override // ir.nasim.InterfaceC15796kB2
                public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                    a((L66) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                    return C19938rB7.a;
                }
            }

            a(androidx.navigation.e eVar, SA2 sa2) {
                this.a = eVar;
                this.b = sa2;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                C17388ms7 c17388ms7A = C17979ns7.a.a(interfaceC22053ub1, C17979ns7.g);
                ED.a(C3710Ca1.a.a(), null, AbstractC19242q11.e(234682832, true, new C0367a(this.a), interfaceC22053ub1, 54), AbstractC19242q11.e(159403321, true, new b(this.b), interfaceC22053ub1, 54), 0.0f, null, c17388ms7A.b((30 & 1) != 0 ? c17388ms7A.a : G10.a.a(interfaceC22053ub1, G10.b).r(), (30 & 2) != 0 ? c17388ms7A.b : 0L, (30 & 4) != 0 ? c17388ms7A.c : 0L, (30 & 8) != 0 ? c17388ms7A.d : 0L, (30 & 16) != 0 ? c17388ms7A.e : 0L), null, interfaceC22053ub1, 3462, SetRpcStruct$ComposedRpc.RESPONSE_INVITE_URL_FIELD_NUMBER);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        c(androidx.navigation.e eVar, SA2 sa2) {
            this.a = eVar;
            this.b = sa2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.a), AbstractC19242q11.e(-855745239, true, new a(this.a, this.b), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class d implements InterfaceC15796kB2 {
        final /* synthetic */ List a;
        final /* synthetic */ InterfaceC18160oB2 b;
        final /* synthetic */ W75 c;
        final /* synthetic */ long d;
        final /* synthetic */ InterfaceC20315ro1 e;
        final /* synthetic */ String f;
        final /* synthetic */ UA2 g;
        final /* synthetic */ boolean h;
        final /* synthetic */ Integer i;
        final /* synthetic */ String j;
        final /* synthetic */ androidx.navigation.e k;
        final /* synthetic */ SQ l;
        final /* synthetic */ LP m;
        final /* synthetic */ InterfaceC20600sH6 n;
        final /* synthetic */ UA2 o;
        final /* synthetic */ int p;
        final /* synthetic */ SA2 q;
        final /* synthetic */ InterfaceC9638aI7 r;
        final /* synthetic */ String s;
        final /* synthetic */ InterfaceC9102Ym4 t;
        final /* synthetic */ C19391qG6 u;
        final /* synthetic */ InterfaceC9102Ym4 v;
        final /* synthetic */ InterfaceC9102Ym4 w;
        final /* synthetic */ LP x;
        final /* synthetic */ SA2 y;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ SA2 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = sa2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            /* JADX WARN: Removed duplicated region for block: B:11:0x002a A[RETURN] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:12:0x002b). Please report as a decompilation issue!!! */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r6) {
                /*
                    r5 = this;
                    java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                    int r1 = r5.b
                    r2 = 1
                    if (r1 == 0) goto L17
                    if (r1 != r2) goto Lf
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L2b
                Lf:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r0)
                    throw r6
                L17:
                    ir.nasim.AbstractC10685c16.b(r6)
                L1a:
                    ir.nasim.Q12$a r6 = ir.nasim.Q12.b
                    ir.nasim.W12 r6 = ir.nasim.W12.e
                    long r3 = ir.nasim.T12.s(r2, r6)
                    r5.b = r2
                    java.lang.Object r6 = ir.nasim.HG1.c(r3, r5)
                    if (r6 != r0) goto L2b
                    return r0
                L2b:
                    ir.nasim.SA2 r6 = r5.c
                    r6.invoke()
                    goto L1a
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.FP7.d.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ androidx.navigation.e c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(androidx.navigation.e eVar, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = eVar;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.c.V();
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C19391qG6 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(C19391qG6 c19391qG6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c19391qG6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new c(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C19391qG6 c19391qG6 = this.c;
                    this.b = 1;
                    if (C19391qG6.f(c19391qG6, "", null, false, null, this, 14, null) == objE) {
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
                return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.FP7$d$d, reason: collision with other inner class name */
        static final class C0368d implements InterfaceC14603iB2 {
            final /* synthetic */ InterfaceC9638aI7 a;
            final /* synthetic */ String b;
            final /* synthetic */ W75 c;
            final /* synthetic */ androidx.navigation.e d;
            final /* synthetic */ InterfaceC9102Ym4 e;

            /* renamed from: ir.nasim.FP7$d$d$a */
            static final class a implements InterfaceC14603iB2 {
                final /* synthetic */ W75 a;
                final /* synthetic */ androidx.navigation.e b;
                final /* synthetic */ InterfaceC9102Ym4 c;

                a(W75 w75, androidx.navigation.e eVar, InterfaceC9102Ym4 interfaceC9102Ym4) {
                    this.a = w75;
                    this.b = eVar;
                    this.c = interfaceC9102Ym4;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 c(androidx.navigation.e eVar, InterfaceC9102Ym4 interfaceC9102Ym4) {
                    AbstractC13042fc3.i(eVar, "$navController");
                    AbstractC13042fc3.i(interfaceC9102Ym4, "$openDialog$delegate");
                    eVar.V();
                    FP7.i(interfaceC9102Ym4, false);
                    return C19938rB7.a;
                }

                public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    InterfaceC12529em.a aVar = InterfaceC12529em.a;
                    InterfaceC12529em.b bVarG = aVar.g();
                    C24254yJ c24254yJ = C24254yJ.a;
                    C24254yJ.f fVarB = c24254yJ.b();
                    W75 w75 = this.a;
                    final androidx.navigation.e eVar = this.b;
                    final InterfaceC9102Ym4 interfaceC9102Ym4 = this.c;
                    e.a aVar2 = androidx.compose.ui.e.a;
                    InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(fVarB, bVarG, interfaceC22053ub1, 54);
                    int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                    InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                    androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, aVar2);
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
                    G10 g10 = G10.a;
                    int i2 = G10.b;
                    androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(aVar2, 0.0f, g10.c(interfaceC22053ub1, i2).b().c(), 0.0f, 0.0f, 13, null);
                    InterfaceC10970cW3 interfaceC10970cW3B = J66.b(c24254yJ.g(), aVar.l(), interfaceC22053ub1, 0);
                    int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                    InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1.q();
                    androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarM);
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
                    DG7.c(interfaceC22053ub1A2, interfaceC10970cW3B, aVar3.e());
                    DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
                    InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
                    if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                        interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                        interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
                    }
                    DG7.c(interfaceC22053ub1A2, eVarE2, aVar3.f());
                    M66 m66 = M66.a;
                    AbstractC9339Zm7.b(AbstractC12152e76.b(w75.c() + AbstractC20762sZ6.C0(w75.f(), AbstractC12152e76.b("0"))), null, g10.a(interfaceC22053ub1, i2).F(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.a()), 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i2).b(), interfaceC22053ub1, 0, 0, 65018);
                    androidx.compose.ui.e eVarT = androidx.compose.foundation.layout.t.t(aVar2, g10.c(interfaceC22053ub1, i2).b().j());
                    interfaceC22053ub1.W(142988687);
                    boolean zD = interfaceC22053ub1.D(eVar);
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new SA2() { // from class: ir.nasim.VP7
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return FP7.d.C0368d.a.c(eVar, interfaceC9102Ym4);
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC24077y03.b(FV4.c(IB5.edit, interfaceC22053ub1, 0), null, androidx.compose.foundation.e.f(eVarT, false, null, null, (SA2) objB, 7, null), g10.a(interfaceC22053ub1, i2).I(), interfaceC22053ub1, 48, 0);
                    interfaceC22053ub1.u();
                    ZH6.a(androidx.compose.foundation.layout.t.i(aVar2, g10.c(interfaceC22053ub1, i2).b().j()), interfaceC22053ub1, 0);
                    AbstractC19555qZ.e0(UY6.c(AbstractC12217eE5.enter_bale_dialog_body, interfaceC22053ub1, 0), interfaceC22053ub1, 0);
                    interfaceC22053ub1.u();
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    return C19938rB7.a;
                }
            }

            C0368d(InterfaceC9638aI7 interfaceC9638aI7, String str, W75 w75, androidx.navigation.e eVar, InterfaceC9102Ym4 interfaceC9102Ym4) {
                this.a = interfaceC9638aI7;
                this.b = str;
                this.c = w75;
                this.d = eVar;
                this.e = interfaceC9102Ym4;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 d(InterfaceC9638aI7 interfaceC9638aI7, String str, InterfaceC9102Ym4 interfaceC9102Ym4) {
                AbstractC13042fc3.i(interfaceC9638aI7, "$uriHandler");
                AbstractC13042fc3.i(str, "$telegramBot");
                AbstractC13042fc3.i(interfaceC9102Ym4, "$openDialog$delegate");
                interfaceC9638aI7.a(str);
                FP7.i(interfaceC9102Ym4, false);
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 f(InterfaceC9102Ym4 interfaceC9102Ym4) {
                AbstractC13042fc3.i(interfaceC9102Ym4, "$openDialog$delegate");
                FP7.i(interfaceC9102Ym4, false);
                return C19938rB7.a;
            }

            public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                InterfaceC14603iB2 interfaceC14603iB2C = C3710Ca1.a.c();
                AbstractC10289bP1.b.C0905b c0905b = AbstractC10289bP1.b.C0905b.b;
                InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(-375914332, true, new a(this.c, this.d, this.e), interfaceC22053ub1, 54);
                AbstractC10289bP1.a.b bVar = AbstractC10289bP1.a.b.a;
                InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
                interfaceC22053ub1.W(-606983943);
                boolean zD = interfaceC22053ub1.D(this.a) | interfaceC22053ub1.V(this.b);
                final InterfaceC9638aI7 interfaceC9638aI7 = this.a;
                final String str = this.b;
                final InterfaceC9102Ym4 interfaceC9102Ym4 = this.e;
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.TP7
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return FP7.d.C0368d.d(interfaceC9638aI7, str, interfaceC9102Ym4);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                SA2 sa2 = (SA2) objB;
                interfaceC22053ub1.Q();
                String strC = UY6.c(AbstractC12217eE5.enter_bale_dialog_open_bot, interfaceC22053ub1, 0);
                InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
                interfaceC22053ub1.W(-606973195);
                final InterfaceC9102Ym4 interfaceC9102Ym42 = this.e;
                Object objB2 = interfaceC22053ub1.B();
                if (objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new SA2() { // from class: ir.nasim.UP7
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return FP7.d.C0368d.f(interfaceC9102Ym42);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                interfaceC22053ub1.Q();
                AbstractC19555qZ.F(interfaceC14603iB2C, c0905b, interfaceC18060o11E, bVar, aVar, sa2, strC, c1454b, (SA2) objB2, UY6.c(AbstractC12217eE5.Cancel, interfaceC22053ub1, 0), null, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 21) | (AbstractC10289bP1.b.C0905b.c << 3) | 100663686 | (AbstractC10289bP1.a.b.b << 9) | (InterfaceC19114po0.b.a.b << 12), 0, 1024);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C19391qG6 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            e(C19391qG6 c19391qG6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c19391qG6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new e(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C19391qG6 c19391qG6 = this.c;
                    this.b = 1;
                    if (C19391qG6.f(c19391qG6, "", null, false, null, this, 14, null) == objE) {
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
                return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class f implements InterfaceC15796kB2 {
            final /* synthetic */ LP a;
            final /* synthetic */ SA2 b;

            static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ SA2 c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = sa2;
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
                        this.b = 1;
                        if (HG1.b(2750L, this) == objE) {
                            return objE;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                    }
                    this.c.invoke();
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            f(LP lp, SA2 sa2) {
                this.a = lp;
                this.b = sa2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 c(InterfaceC15254jG6 interfaceC15254jG6, boolean z) {
                AbstractC13042fc3.i(interfaceC15254jG6, "$snackBar");
                interfaceC15254jG6.dismiss();
                return C19938rB7.a;
            }

            public final void b(final InterfaceC15254jG6 interfaceC15254jG6, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                AbstractC13042fc3.i(interfaceC15254jG6, "snackBar");
                if ((i & 6) == 0) {
                    i |= interfaceC22053ub1.V(interfaceC15254jG6) ? 4 : 2;
                }
                if ((i & 19) == 18 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                LP lp = this.a;
                if (lp instanceof LP.a) {
                    Integer numD = ((LP.a) lp).d();
                    interfaceC22053ub1.W(-1349345859);
                    String strC = numD == null ? null : UY6.c(numD.intValue(), interfaceC22053ub1, 0);
                    interfaceC22053ub1.Q();
                    if (strC == null) {
                        strC = ((LP.a) this.a).e();
                    }
                    String str = strC;
                    interfaceC22053ub1.W(-1349341216);
                    boolean z = (i & 14) == 4;
                    Object objB = interfaceC22053ub1.B();
                    if (z || objB == InterfaceC22053ub1.a.a()) {
                        objB = new UA2() { // from class: ir.nasim.WP7
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return FP7.d.f.c(interfaceC15254jG6, ((Boolean) obj).booleanValue());
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC10984cY.c(str, null, null, 0, (UA2) objB, interfaceC22053ub1, 0, 14);
                    C19938rB7 c19938rB7 = C19938rB7.a;
                    interfaceC22053ub1.W(-1349337504);
                    boolean zV = interfaceC22053ub1.V(this.b);
                    SA2 sa2 = this.b;
                    Object objB2 = interfaceC22053ub1.B();
                    if (zV || objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new a(sa2, null);
                        interfaceC22053ub1.s(objB2);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC10721c52.e(c19938rB7, (InterfaceC14603iB2) objB2, interfaceC22053ub1, 6);
                }
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                b((InterfaceC15254jG6) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        d(List list, InterfaceC18160oB2 interfaceC18160oB2, W75 w75, long j, InterfaceC20315ro1 interfaceC20315ro1, String str, UA2 ua2, boolean z, Integer num, String str2, androidx.navigation.e eVar, SQ sq, LP lp, InterfaceC20600sH6 interfaceC20600sH6, UA2 ua22, int i, SA2 sa2, InterfaceC9638aI7 interfaceC9638aI7, String str3, InterfaceC9102Ym4 interfaceC9102Ym4, C19391qG6 c19391qG6, InterfaceC9102Ym4 interfaceC9102Ym42, InterfaceC9102Ym4 interfaceC9102Ym43, LP lp2, SA2 sa22) {
            this.a = list;
            this.b = interfaceC18160oB2;
            this.c = w75;
            this.d = j;
            this.e = interfaceC20315ro1;
            this.f = str;
            this.g = ua2;
            this.h = z;
            this.i = num;
            this.j = str2;
            this.k = eVar;
            this.l = sq;
            this.m = lp;
            this.n = interfaceC20600sH6;
            this.o = ua22;
            this.p = i;
            this.q = sa2;
            this.r = interfaceC9638aI7;
            this.s = str3;
            this.t = interfaceC9102Ym4;
            this.u = c19391qG6;
            this.v = interfaceC9102Ym42;
            this.w = interfaceC9102Ym43;
            this.x = lp2;
            this.y = sa22;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 o(InterfaceC9638aI7 interfaceC9638aI7, String str) {
            AbstractC13042fc3.i(interfaceC9638aI7, "$uriHandler");
            AbstractC13042fc3.i(str, "$telegramBot");
            interfaceC9638aI7.a(str);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 p(InterfaceC20600sH6 interfaceC20600sH6, InterfaceC10566bp3 interfaceC10566bp3) {
            AbstractC13042fc3.i(interfaceC10566bp3, "$this$KeyboardActions");
            if (interfaceC20600sH6 != null) {
                interfaceC20600sH6.b();
            }
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 t(List list, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC18160oB2 interfaceC18160oB2, W75 w75, long j, androidx.navigation.e eVar, C19391qG6 c19391qG6, InterfaceC9102Ym4 interfaceC9102Ym4) {
            AbstractC13042fc3.i(interfaceC20315ro1, "$cScope");
            AbstractC13042fc3.i(interfaceC18160oB2, "$requestNewCode");
            AbstractC13042fc3.i(w75, "$phoneData");
            AbstractC13042fc3.i(eVar, "$navController");
            AbstractC13042fc3.i(c19391qG6, "$snackBarState");
            AbstractC13042fc3.i(interfaceC9102Ym4, "$showBottomSheet$delegate");
            if (list.size() == 1 && list.get(0) == SQ.a) {
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new b(eVar, null), 3, null);
            } else if (list.size() == 1) {
                interfaceC18160oB2.s(w75, Long.valueOf(j), null, list.get(0), Boolean.FALSE);
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new c(c19391qG6, null), 3, null);
            } else if (list.size() > 1) {
                FP7.e(interfaceC9102Ym4, true);
            }
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 v(InterfaceC11943do6 interfaceC11943do6) {
            AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
            AbstractC9939ao6.v0(interfaceC11943do6, "VALIDATION_CODE_CONFIRM_BUTTON_TAG");
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 w(String str, UA2 ua2, InterfaceC9102Ym4 interfaceC9102Ym4) {
            AbstractC13042fc3.i(str, "$code");
            AbstractC13042fc3.i(ua2, "$validateCode");
            AbstractC13042fc3.i(interfaceC9102Ym4, "$emptyCode$delegate");
            if (str.length() == 0) {
                FP7.g(interfaceC9102Ym4, true);
            } else {
                ua2.invoke(GY6.b(AbstractC20762sZ6.n1(str).toString()));
            }
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 x(InterfaceC9102Ym4 interfaceC9102Ym4) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$openDialog$delegate");
            FP7.i(interfaceC9102Ym4, false);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y(InterfaceC18160oB2 interfaceC18160oB2, W75 w75, long j, InterfaceC20315ro1 interfaceC20315ro1, C19391qG6 c19391qG6, SQ sq) {
            AbstractC13042fc3.i(interfaceC18160oB2, "$requestNewCode");
            AbstractC13042fc3.i(w75, "$phoneData");
            AbstractC13042fc3.i(interfaceC20315ro1, "$cScope");
            AbstractC13042fc3.i(c19391qG6, "$snackBarState");
            AbstractC13042fc3.i(sq, "it");
            interfaceC18160oB2.s(w75, Long.valueOf(j), null, sq, Boolean.FALSE);
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new e(c19391qG6, null), 3, null);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 z(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$showBottomSheet$delegate");
            FP7.e(interfaceC9102Ym4, z);
            return C19938rB7.a;
        }

        public final void n(TS4 ts4, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            int i3;
            long j;
            AbstractC14472hy4 dVar;
            e.a aVar;
            int i4;
            e.a aVar2;
            int i5;
            int i6;
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
            e.a aVar3 = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(aVar3, 0.0f, 1, null);
            G10 g10 = G10.a;
            int i7 = G10.b;
            androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(androidx.compose.foundation.b.d(eVarF, g10.a(interfaceC22053ub1, i7).r(), null, 2, null), 0.0f, ts4.c(), 0.0f, 0.0f, 13, null);
            C24254yJ c24254yJ = C24254yJ.a;
            C24254yJ.m mVarH = c24254yJ.h();
            InterfaceC12529em.a aVar4 = InterfaceC12529em.a;
            InterfaceC12529em.b bVarG = aVar4.g();
            final String str = this.f;
            final UA2 ua2 = this.g;
            boolean z = this.h;
            Integer num = this.i;
            String str2 = this.j;
            final androidx.navigation.e eVar = this.k;
            SQ sq = this.l;
            LP lp = this.m;
            final InterfaceC20600sH6 interfaceC20600sH6 = this.n;
            UA2 ua22 = this.o;
            int i8 = this.p;
            SA2 sa2 = this.q;
            final List list = this.a;
            final InterfaceC20315ro1 interfaceC20315ro1 = this.e;
            final InterfaceC18160oB2 interfaceC18160oB2 = this.b;
            final W75 w75 = this.c;
            long j2 = this.d;
            final InterfaceC9638aI7 interfaceC9638aI7 = this.r;
            final String str3 = this.s;
            final InterfaceC9102Ym4 interfaceC9102Ym4 = this.t;
            final C19391qG6 c19391qG6 = this.u;
            final InterfaceC9102Ym4 interfaceC9102Ym42 = this.v;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(mVarH, bVarG, interfaceC22053ub1, 54);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarM);
            InterfaceC16030kb1.a aVar5 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar5.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar5.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar5.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar5.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar5.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar3, g10.c(interfaceC22053ub1, i7).b().c()), interfaceC22053ub1, 0);
            androidx.compose.ui.e eVarG = AbstractC8014Ud6.g(ZY0.b(c9784aZ0, aVar3, 1.0f, false, 2, null), AbstractC8014Ud6.c(0, interfaceC22053ub1, 0, 1), false, null, false, 14, null);
            InterfaceC10970cW3 interfaceC10970cW3A2 = XY0.a(c24254yJ.h(), aVar4.g(), interfaceC22053ub1, 54);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarG);
            SA2 sa2A2 = aVar5.a();
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
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3A2, aVar5.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar5.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar5.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar5.f());
            interfaceC22053ub1.W(-1349699538);
            if (num == null) {
                i3 = 0;
                j = j2;
            } else {
                i3 = 0;
                j = j2;
                AbstractC11456d23.b(FV4.c(num.intValue(), interfaceC22053ub1, 0), null, androidx.compose.foundation.layout.t.t(aVar3, C17784nZ1.q(44)), null, null, 0.0f, null, interfaceC22053ub1, 432, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
            interfaceC22053ub1.Q();
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar3, g10.c(interfaceC22053ub1, i7).b().u()), interfaceC22053ub1, i3);
            AbstractC9339Zm7.b(UY6.c(AbstractC24206yD5.auth_code_base, interfaceC22053ub1, i3), null, g10.a(interfaceC22053ub1, i7).D(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i7).l(), interfaceC22053ub1, 0, 0, 65530);
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar3, g10.c(interfaceC22053ub1, i7).b().c()), interfaceC22053ub1, 0);
            AbstractC17400mu.f(str2, eVar, sq, interfaceC22053ub1, 0);
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar3, g10.c(interfaceC22053ub1, i7).b().c()), interfaceC22053ub1, 0);
            androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.q.k(androidx.compose.foundation.layout.t.h(aVar3, 0.0f, 1, null), g10.c(interfaceC22053ub1, i7).b().c(), 0.0f, 2, null);
            if (str.length() == 0 && FP7.f(interfaceC9102Ym4)) {
                interfaceC22053ub1.W(1110112398);
                dVar = new AbstractC14472hy4.a(Integer.valueOf(IB5.danger), UY6.c(AbstractC24206yD5.code_req, interfaceC22053ub1, 0), null, 4, null);
                interfaceC22053ub1.Q();
            } else if (lp instanceof LP.a) {
                interfaceC22053ub1.W(1110365885);
                LP.a aVar6 = (LP.a) lp;
                Integer numD = aVar6.d();
                String strC = numD == null ? null : UY6.c(numD.intValue(), interfaceC22053ub1, 0);
                if (strC == null) {
                    strC = aVar6.e();
                }
                dVar = new AbstractC14472hy4.a(Integer.valueOf(IB5.danger), strC, null, 4, null);
                interfaceC22053ub1.Q();
            } else {
                interfaceC22053ub1.W(1110719223);
                interfaceC22053ub1.Q();
                dVar = new AbstractC14472hy4.d(null, null, null, 7, null);
            }
            AbstractC14472hy4 abstractC14472hy4 = dVar;
            C21605tp3 c21605tp3 = new C21605tp3(0, null, C22785vp3.b.d(), S33.b.b(), null, null, null, 115, null);
            interfaceC22053ub1.W(-1349629488);
            boolean zV = interfaceC22053ub1.V(interfaceC20600sH6);
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.LP7
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return FP7.d.p(interfaceC20600sH6, (InterfaceC10566bp3) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC8426Vx4.e0(str, ua22, UY6.c(AbstractC24206yD5.auth_code_base, interfaceC22053ub1, 0), AbstractC12152e76.b("123456"), eVarK, null, false, false, null, null, abstractC14472hy4, c21605tp3, new C11329cp3((UA2) objB, null, null, null, null, null, 62, null), true, 0, 0, null, null, true, false, "VALIDATION_CODE_LOGIN_TEXT_FIELD_TAG", true, interfaceC22053ub1, 0, AbstractC14472hy4.a | 100666416, 54, 771040);
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar3, g10.c(interfaceC22053ub1, i7).b().u()), interfaceC22053ub1, 0);
            if (i8 > 0) {
                interfaceC22053ub1.W(1111731249);
                interfaceC22053ub1.W(-1349610126);
                C13245fu.b bVar = new C13245fu.b(0, 1, null);
                interfaceC22053ub1.W(-1349608895);
                int iN = bVar.n(new C12863fI6(g10.a(interfaceC22053ub1, i7).I(), 0L, (C4593Fu2) null, (C3418Au2) null, (C3657Bu2) null, (AbstractC9998au2) null, (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, (C24525yl7) null, (C5566Jw6) null, (C19620qf5) null, (AbstractC18051o02) null, 65534, (ED1) null));
                try {
                    bVar.h(AbstractC12152e76.b(UY6.d(AbstractC24206yD5.time_duration_seconds, new Object[]{Integer.valueOf(i8)}, interfaceC22053ub1, 0)) + Separators.SP);
                    C19938rB7 c19938rB72 = C19938rB7.a;
                    bVar.l(iN);
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(-1349595919);
                    iN = bVar.n(new C12863fI6(g10.a(interfaceC22053ub1, i7).B(), 0L, (C4593Fu2) null, (C3418Au2) null, (C3657Bu2) null, (AbstractC9998au2) null, (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, (C24525yl7) null, (C5566Jw6) null, (C19620qf5) null, (AbstractC18051o02) null, 65534, (ED1) null));
                    try {
                        bVar.h(UY6.c(AbstractC24206yD5.until_req_new_code, interfaceC22053ub1, 0));
                        bVar.l(iN);
                        interfaceC22053ub1.Q();
                        C13245fu c13245fuO = bVar.o();
                        interfaceC22053ub1.Q();
                        aVar = aVar3;
                        AbstractC9339Zm7.c(c13245fuO, null, g10.a(interfaceC22053ub1, i7).B(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, g10.d(interfaceC22053ub1, i7).p(), interfaceC22053ub1, 0, 0, 131066);
                        C19938rB7 c19938rB73 = C19938rB7.a;
                        interfaceC22053ub1.W(-1349580723);
                        boolean zV2 = interfaceC22053ub1.V(sa2);
                        Object objB2 = interfaceC22053ub1.B();
                        if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                            objB2 = new a(sa2, null);
                            interfaceC22053ub1.s(objB2);
                        }
                        interfaceC22053ub1.Q();
                        AbstractC10721c52.e(c19938rB73, (InterfaceC14603iB2) objB2, interfaceC22053ub1, 6);
                        interfaceC22053ub1.Q();
                        i4 = i7;
                    } finally {
                    }
                } finally {
                }
            } else {
                aVar = aVar3;
                interfaceC22053ub1.W(1112902863);
                interfaceC22053ub1.W(-1349570946);
                final long j3 = j;
                boolean zD = interfaceC22053ub1.D(list) | interfaceC22053ub1.D(interfaceC20315ro1) | interfaceC22053ub1.D(eVar) | interfaceC22053ub1.V(interfaceC18160oB2) | interfaceC22053ub1.V(w75) | interfaceC22053ub1.f(j3);
                Object objB3 = interfaceC22053ub1.B();
                if (zD || objB3 == InterfaceC22053ub1.a.a()) {
                    objB3 = new SA2() { // from class: ir.nasim.MP7
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return FP7.d.t(list, interfaceC20315ro1, interfaceC18160oB2, w75, j3, eVar, c19391qG6, interfaceC9102Ym42);
                        }
                    };
                    interfaceC22053ub1.s(objB3);
                }
                interfaceC22053ub1.Q();
                i4 = i7;
                AbstractC9339Zm7.b(UY6.c(AbstractC24206yD5.request_new_cede, interfaceC22053ub1, 0), androidx.compose.foundation.e.f(aVar, false, null, null, (SA2) objB3, 7, null), g10.a(interfaceC22053ub1, i7).I(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i7).p(), interfaceC22053ub1, 0, 0, 65528);
                interfaceC22053ub1.Q();
            }
            interfaceC22053ub1.W(-1349531758);
            if (sq != SQ.j || i8 <= 0) {
                aVar2 = aVar;
                i5 = i4;
            } else {
                int i9 = i4;
                e.a aVar7 = aVar;
                ZH6.a(androidx.compose.foundation.layout.t.t(aVar7, g10.c(interfaceC22053ub1, i9).b().c()), interfaceC22053ub1, 0);
                interfaceC22053ub1.W(-1349524747);
                boolean zD2 = interfaceC22053ub1.D(interfaceC9638aI7) | interfaceC22053ub1.V(str3);
                Object objB4 = interfaceC22053ub1.B();
                if (zD2 || objB4 == InterfaceC22053ub1.a.a()) {
                    objB4 = new SA2() { // from class: ir.nasim.NP7
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return FP7.d.o(interfaceC9638aI7, str3);
                        }
                    };
                    interfaceC22053ub1.s(objB4);
                }
                interfaceC22053ub1.Q();
                aVar2 = aVar7;
                i5 = i9;
                AbstractC9339Zm7.b(UY6.c(AbstractC12217eE5.open_telegram_bot_text, interfaceC22053ub1, 0), androidx.compose.foundation.e.f(aVar7, false, null, null, (SA2) objB4, 7, null), g10.a(interfaceC22053ub1, i9).I(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i9).p(), interfaceC22053ub1, 0, 0, 65528);
            }
            interfaceC22053ub1.Q();
            e.a aVar8 = aVar2;
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar8, C17784nZ1.q(ts4.c() + C17784nZ1.q(30))), interfaceC22053ub1, 0);
            interfaceC22053ub1.u();
            int i10 = i5;
            ZV1.b(androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.h(aVar8, 0.0f, 1, null), C17784nZ1.q(1)), 0.0f, g10.a(interfaceC22053ub1, i10).A(), interfaceC22053ub1, 6, 2);
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.i(aVar8, g10.c(interfaceC22053ub1, i10).b().c()), 0.0f, 1, null);
            interfaceC22053ub1.W(-607087973);
            Object objB5 = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar9 = InterfaceC22053ub1.a;
            if (objB5 == aVar9.a()) {
                objB5 = new UA2() { // from class: ir.nasim.OP7
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return FP7.d.v((InterfaceC11943do6) obj);
                    }
                };
                interfaceC22053ub1.s(objB5);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarD = AbstractC6919Pn6.d(eVarH, false, (UA2) objB5, 1, null);
            interfaceC22053ub1.W(-607084006);
            boolean zV3 = interfaceC22053ub1.V(str) | interfaceC22053ub1.V(ua2);
            Object objB6 = interfaceC22053ub1.B();
            if (zV3 || objB6 == aVar9.a()) {
                objB6 = new SA2() { // from class: ir.nasim.PP7
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return FP7.d.w(str, ua2, interfaceC9102Ym4);
                    }
                };
                interfaceC22053ub1.s(objB6);
            }
            SA2 sa22 = (SA2) objB6;
            interfaceC22053ub1.Q();
            AbstractC17932no0.y(eVarD, sa22, z ? OA2.a.b : str.length() == 0 ? OA2.b.a.c : OA2.b.C0545b.c, null, UY6.c(AbstractC24206yD5.create_group_button, interfaceC22053ub1, 0), null, interfaceC22053ub1, OA2.a << 6, 40);
            interfaceC22053ub1.u();
            interfaceC22053ub1.W(-855954622);
            if (FP7.h(this.w)) {
                interfaceC22053ub1.W(-855955914);
                final InterfaceC9102Ym4 interfaceC9102Ym43 = this.w;
                Object objB7 = interfaceC22053ub1.B();
                if (objB7 == aVar9.a()) {
                    objB7 = new SA2() { // from class: ir.nasim.QP7
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return FP7.d.x(interfaceC9102Ym43);
                        }
                    };
                    interfaceC22053ub1.s(objB7);
                }
                interfaceC22053ub1.Q();
                i6 = 54;
                AbstractC6687Oo.a((SA2) objB7, null, AbstractC19242q11.e(1613189826, true, new C0368d(this.r, this.s, this.c, this.k, this.w), interfaceC22053ub1, 54), interfaceC22053ub1, 390, 2);
            } else {
                i6 = 54;
            }
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-855857502);
            if (FP7.c(this.v)) {
                List list2 = this.a;
                interfaceC22053ub1.W(-855854660);
                boolean zV4 = interfaceC22053ub1.V(this.b) | interfaceC22053ub1.V(this.c) | interfaceC22053ub1.f(this.d) | interfaceC22053ub1.D(this.e);
                final InterfaceC18160oB2 interfaceC18160oB22 = this.b;
                final W75 w752 = this.c;
                final long j4 = this.d;
                final InterfaceC20315ro1 interfaceC20315ro12 = this.e;
                final C19391qG6 c19391qG62 = this.u;
                Object objB8 = interfaceC22053ub1.B();
                if (zV4 || objB8 == aVar9.a()) {
                    objB8 = new UA2() { // from class: ir.nasim.RP7
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return FP7.d.y(interfaceC18160oB22, w752, j4, interfaceC20315ro12, c19391qG62, (SQ) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB8);
                }
                UA2 ua23 = (UA2) objB8;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(-855843236);
                final InterfaceC9102Ym4 interfaceC9102Ym44 = this.v;
                Object objB9 = interfaceC22053ub1.B();
                if (objB9 == aVar9.a()) {
                    objB9 = new UA2() { // from class: ir.nasim.SP7
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return FP7.d.z(interfaceC9102Ym44, ((Boolean) obj).booleanValue());
                        }
                    };
                    interfaceC22053ub1.s(objB9);
                }
                interfaceC22053ub1.Q();
                AbstractC8796Xj0.b(list2, ua23, (UA2) objB9, interfaceC22053ub1, 384);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarF2 = androidx.compose.foundation.layout.t.f(aVar8, 0.0f, 1, null);
            C19391qG6 c19391qG63 = this.u;
            LP lp2 = this.x;
            SA2 sa23 = this.y;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar4.o(), false);
            int iA3 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q3 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarF2);
            SA2 sa2A3 = aVar5.a();
            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1.G();
            if (interfaceC22053ub1.h()) {
                interfaceC22053ub1.g(sa2A3);
            } else {
                interfaceC22053ub1.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A3 = DG7.a(interfaceC22053ub1);
            DG7.c(interfaceC22053ub1A3, interfaceC10970cW3G, aVar5.e());
            DG7.c(interfaceC22053ub1A3, interfaceC11819dc1Q3, aVar5.g());
            InterfaceC14603iB2 interfaceC14603iB2B3 = aVar5.b();
            if (interfaceC22053ub1A3.h() || !AbstractC13042fc3.d(interfaceC22053ub1A3.B(), Integer.valueOf(iA3))) {
                interfaceC22053ub1A3.s(Integer.valueOf(iA3));
                interfaceC22053ub1A3.v(Integer.valueOf(iA3), interfaceC14603iB2B3);
            }
            DG7.c(interfaceC22053ub1A3, eVarE3, aVar5.f());
            AbstractC18209oG6.b(c19391qG63, androidx.compose.foundation.layout.q.m(androidx.compose.foundation.layout.h.a.h(aVar8, aVar4.b()), 0.0f, 0.0f, 0.0f, C17784nZ1.q(78), 7, null), AbstractC19242q11.e(1530373889, true, new f(lp2, sa23), interfaceC22053ub1, i6), interfaceC22053ub1, 390, 0);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            n((TS4) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x045c  */
    /* JADX WARN: Removed duplicated region for block: B:239:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x017d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(final androidx.navigation.e r36, final java.lang.Integer r37, final java.lang.String r38, final java.lang.String r39, final ir.nasim.UA2 r40, final int r41, final ir.nasim.SA2 r42, final ir.nasim.InterfaceC18160oB2 r43, java.util.List r44, final ir.nasim.W75 r45, final long r46, final ir.nasim.LP r48, final ir.nasim.LP r49, final ir.nasim.SA2 r50, final boolean r51, final ir.nasim.UA2 r52, final ir.nasim.SQ r53, final java.lang.String r54, final ir.nasim.SA2 r55, ir.nasim.InterfaceC22053ub1 r56, final int r57, final int r58, final int r59) {
        /*
            Method dump skipped, instructions count: 1176
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.FP7.b(androidx.navigation.e, java.lang.Integer, java.lang.String, java.lang.String, ir.nasim.UA2, int, ir.nasim.SA2, ir.nasim.oB2, java.util.List, ir.nasim.W75, long, ir.nasim.LP, ir.nasim.LP, ir.nasim.SA2, boolean, ir.nasim.UA2, ir.nasim.SQ, java.lang.String, ir.nasim.SA2, ir.nasim.ub1, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 d(androidx.navigation.e eVar, Integer num, String str, String str2, UA2 ua2, int i, SA2 sa2, InterfaceC18160oB2 interfaceC18160oB2, List list, W75 w75, long j, LP lp, LP lp2, SA2 sa22, boolean z, UA2 ua22, SQ sq, String str3, SA2 sa23, int i2, int i3, int i4, InterfaceC22053ub1 interfaceC22053ub1, int i5) {
        AbstractC13042fc3.i(eVar, "$navController");
        AbstractC13042fc3.i(str, "$textTitle");
        AbstractC13042fc3.i(str2, "$code");
        AbstractC13042fc3.i(ua2, "$onCodeChanged");
        AbstractC13042fc3.i(sa2, "$onCountDown");
        AbstractC13042fc3.i(interfaceC18160oB2, "$requestNewCode");
        AbstractC13042fc3.i(w75, "$phoneData");
        AbstractC13042fc3.i(lp, "$error");
        AbstractC13042fc3.i(lp2, "$authError");
        AbstractC13042fc3.i(sa22, "$onErrorShown");
        AbstractC13042fc3.i(ua22, "$validateCode");
        AbstractC13042fc3.i(sq, "$sendCodeType");
        AbstractC13042fc3.i(str3, "$transitionHash");
        AbstractC13042fc3.i(sa23, "$onSaveLogsClicked");
        b(eVar, num, str, str2, ua2, i, sa2, interfaceC18160oB2, list, w75, j, lp, lp2, sa22, z, ua22, sq, str3, sa23, interfaceC22053ub1, QJ5.a(i2 | 1), QJ5.a(i3), i4);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }
}
