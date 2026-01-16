package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.view.View;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.ComposeView;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import ir.nasim.AbstractC12520el0;
import ir.nasim.AbstractC13463gG6;
import ir.nasim.C17468n10;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.List;

/* renamed from: ir.nasim.n10, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C17468n10 {
    public static final a g = new a(null);
    public static final int h = 8;
    private final View a;
    private View b;
    private int c;
    private boolean d;
    private boolean e;
    private final InterfaceC9173Yu3 f;

    /* renamed from: ir.nasim.n10$a */
    public static final class a {

        /* renamed from: ir.nasim.n10$a$a, reason: collision with other inner class name */
        static final class C1403a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C15607js c;
            final /* synthetic */ int d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1403a(C15607js c15607js, int i, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c15607js;
                this.d = i;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C1403a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C15607js c15607js = this.c;
                    Float fC = AbstractC6392Nk0.c(0.0f);
                    C7479Rw7 c7479Rw7L = AbstractC5999Lt.l(this.d, 0, T22.e(), 2, null);
                    this.b = 1;
                    if (C15607js.h(c15607js, fC, c7479Rw7L, null, null, this, 12, null) == objE) {
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
                return ((C1403a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.n10$a$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceC17916nm4 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(InterfaceC17916nm4 interfaceC17916nm4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceC17916nm4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, interfaceC20295rm1);
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0022  */
            /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x002a -> B:14:0x002d). Please report as a decompilation issue!!! */
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
                    goto L2d
                Lf:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r0)
                    throw r6
                L17:
                    ir.nasim.AbstractC10685c16.b(r6)
                L1a:
                    ir.nasim.nm4 r6 = r5.c
                    int r6 = ir.nasim.C17468n10.a.h(r6)
                    if (r6 <= 0) goto L3b
                    r5.b = r2
                    r3 = 1000(0x3e8, double:4.94E-321)
                    java.lang.Object r6 = ir.nasim.HG1.b(r3, r5)
                    if (r6 != r0) goto L2d
                    return r0
                L2d:
                    ir.nasim.nm4 r6 = r5.c
                    int r6 = ir.nasim.C17468n10.a.h(r6)
                    ir.nasim.nm4 r1 = r5.c
                    int r6 = r6 + (-1)
                    ir.nasim.C17468n10.a.i(r1, r6)
                    goto L1a
                L3b:
                    ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C17468n10.a.b.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(long j, long j2, float f, float f2, C15607js c15607js, long j3, InterfaceC17460n02 interfaceC17460n02) {
            AbstractC13042fc3.i(c15607js, "$animateFloat");
            AbstractC13042fc3.i(interfaceC17460n02, "$this$Canvas");
            AbstractC12520el0.a aVar = AbstractC12520el0.b;
            List listP = AbstractC10360bX0.p(C24381yX0.k(j), C24381yX0.k(j2));
            float f3 = 2;
            float fIntBitsToFloat = Float.intBitsToFloat((int) (interfaceC17460n02.d() >> 32)) / f3;
            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (interfaceC17460n02.d() & 4294967295L)) / f3;
            AbstractC12520el0 abstractC12520el0G = AbstractC12520el0.a.g(aVar, listP, ZG4.e((Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L)), Float.intBitsToFloat((int) (interfaceC17460n02.d() & 4294967295L)) / f3, 0, 8, null);
            float fIntBitsToFloat3 = Float.intBitsToFloat((int) (interfaceC17460n02.d() & 4294967295L)) / f3;
            float fIntBitsToFloat4 = Float.intBitsToFloat((int) (interfaceC17460n02.d() >> 32)) / f3;
            float fIntBitsToFloat5 = Float.intBitsToFloat((int) (interfaceC17460n02.d() & 4294967295L)) / f3;
            InterfaceC17460n02.J0(interfaceC17460n02, abstractC12520el0G, fIntBitsToFloat3, ZG4.e((Float.floatToRawIntBits(fIntBitsToFloat4) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat5) & 4294967295L)), 0.0f, null, null, 0, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER, null);
            float fW1 = interfaceC17460n02.w1(C17784nZ1.q(C17784nZ1.q(f / f3) - f2));
            float fIntBitsToFloat6 = Float.intBitsToFloat((int) (interfaceC17460n02.d() >> 32)) / f3;
            float fIntBitsToFloat7 = Float.intBitsToFloat((int) (interfaceC17460n02.d() & 4294967295L)) / f3;
            InterfaceC17460n02.L(interfaceC17460n02, j2, fW1, ZG4.e((Float.floatToRawIntBits(fIntBitsToFloat7) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat6) << 32)), 0.0f, null, null, 0, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER, null);
            float fFloatValue = ((Number) c15607js.q()).floatValue() * 360.0f;
            C23815xZ6 c23815xZ6 = new C23815xZ6(interfaceC17460n02.w1(f2), 0.0f, AbstractC24405yZ6.a.b(), 0, null, 26, null);
            float f4 = f - f2;
            float fW12 = interfaceC17460n02.w1(C17784nZ1.q(f4));
            float fW13 = interfaceC17460n02.w1(C17784nZ1.q(f4));
            long jD = OD6.d((Float.floatToRawIntBits(fW12) << 32) | (Float.floatToRawIntBits(fW13) & 4294967295L));
            float f5 = f2 / f3;
            float fW14 = interfaceC17460n02.w1(C17784nZ1.q(f5));
            float fW15 = interfaceC17460n02.w1(C17784nZ1.q(f5));
            InterfaceC17460n02.u1(interfaceC17460n02, j3, -90.0f, fFloatValue, false, ZG4.e((Float.floatToRawIntBits(fW14) << 32) | (Float.floatToRawIntBits(fW15) & 4294967295L)), jD, 0.0f, c23815xZ6, null, 0, 832, null);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int e(InterfaceC17916nm4 interfaceC17916nm4) {
            return interfaceC17916nm4.d();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(InterfaceC17916nm4 interfaceC17916nm4, int i) {
            interfaceC17916nm4.h(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 g(a aVar, int i, float f, long j, long j2, long j3, float f2, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
            AbstractC13042fc3.i(aVar, "$tmp2_rcvr");
            aVar.c(i, f, j, j2, j3, f2, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
            return C19938rB7.a;
        }

        /* JADX WARN: Removed duplicated region for block: B:113:0x0192  */
        /* JADX WARN: Removed duplicated region for block: B:116:0x01b2  */
        /* JADX WARN: Removed duplicated region for block: B:117:0x01b4  */
        /* JADX WARN: Removed duplicated region for block: B:122:0x01c2  */
        /* JADX WARN: Removed duplicated region for block: B:125:0x0204  */
        /* JADX WARN: Removed duplicated region for block: B:128:0x0210  */
        /* JADX WARN: Removed duplicated region for block: B:129:0x0214  */
        /* JADX WARN: Removed duplicated region for block: B:134:0x0241  */
        /* JADX WARN: Removed duplicated region for block: B:137:0x0268  */
        /* JADX WARN: Removed duplicated region for block: B:138:0x026a  */
        /* JADX WARN: Removed duplicated region for block: B:149:0x028b  */
        /* JADX WARN: Removed duplicated region for block: B:151:0x0291  */
        /* JADX WARN: Removed duplicated region for block: B:157:0x02a2  */
        /* JADX WARN: Removed duplicated region for block: B:159:0x02a8  */
        /* JADX WARN: Removed duplicated region for block: B:165:0x02bd  */
        /* JADX WARN: Removed duplicated region for block: B:167:0x02c3  */
        /* JADX WARN: Removed duplicated region for block: B:173:0x02d4  */
        /* JADX WARN: Removed duplicated region for block: B:175:0x02da  */
        /* JADX WARN: Removed duplicated region for block: B:178:0x0309  */
        /* JADX WARN: Removed duplicated region for block: B:179:0x0315  */
        /* JADX WARN: Removed duplicated region for block: B:182:0x0334  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void c(int r39, float r40, long r41, long r43, long r45, float r47, ir.nasim.InterfaceC22053ub1 r48, final int r49, final int r50) {
            /*
                Method dump skipped, instructions count: 952
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C17468n10.a.c(int, float, long, long, long, float, ir.nasim.ub1, int, int):void");
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.n10$b */
    public static final class b extends BaseTransientBottomBar.r {
        final /* synthetic */ UA2 b;

        b(UA2 ua2) {
            this.b = ua2;
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.r
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(Snackbar snackbar, int i) {
            if (!C17468n10.this.i()) {
                C17468n10.this.l(true);
                this.b.invoke(Boolean.valueOf(C17468n10.this.d));
            }
            C17468n10.this.d = false;
        }
    }

    /* renamed from: ir.nasim.n10$c */
    static final class c implements InterfaceC14603iB2 {
        final /* synthetic */ AbstractC13463gG6 a;
        final /* synthetic */ C17468n10 b;
        final /* synthetic */ String c;

        /* renamed from: ir.nasim.n10$c$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ AbstractC13463gG6 a;
            final /* synthetic */ C17468n10 b;
            final /* synthetic */ String c;

            /* renamed from: ir.nasim.n10$c$a$a, reason: collision with other inner class name */
            static final class C1404a implements InterfaceC14603iB2 {
                final /* synthetic */ AbstractC13463gG6 a;
                final /* synthetic */ C17468n10 b;
                final /* synthetic */ String c;

                C1404a(AbstractC13463gG6 abstractC13463gG6, C17468n10 c17468n10, String str) {
                    this.a = abstractC13463gG6;
                    this.b = c17468n10;
                    this.c = str;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 d(C17468n10 c17468n10, AbstractC13463gG6 abstractC13463gG6) {
                    AbstractC13042fc3.i(c17468n10, "this$0");
                    AbstractC13042fc3.i(abstractC13463gG6, "$snackBarStyle");
                    c17468n10.d = true;
                    ((AbstractC13463gG6.a) abstractC13463gG6).e().invoke();
                    c17468n10.h().t();
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 f(C17468n10 c17468n10, AbstractC13463gG6 abstractC13463gG6) {
                    AbstractC13042fc3.i(c17468n10, "this$0");
                    AbstractC13042fc3.i(abstractC13463gG6, "$snackBarStyle");
                    c17468n10.d = true;
                    ((AbstractC13463gG6.a) abstractC13463gG6).e().invoke();
                    c17468n10.h().t();
                    return C19938rB7.a;
                }

                public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    String str;
                    C17468n10 c17468n10;
                    AbstractC13463gG6 abstractC13463gG6;
                    G10 g10;
                    int i2;
                    e.a aVar;
                    final C17468n10 c17468n102;
                    long jI;
                    if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    e.a aVar2 = androidx.compose.ui.e.a;
                    androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(aVar2, 0.0f, 1, null);
                    G10 g102 = G10.a;
                    androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(androidx.compose.foundation.b.c(eVarH, g102.a(interfaceC22053ub1, 6).D(), N46.d(g102.c(interfaceC22053ub1, 6).a().b())), g102.c(interfaceC22053ub1, 6).b().c());
                    C24254yJ c24254yJ = C24254yJ.a;
                    float fU = g102.c(interfaceC22053ub1, 6).b().u();
                    InterfaceC12529em.a aVar3 = InterfaceC12529em.a;
                    C24254yJ.e eVarP = c24254yJ.p(fU, aVar3.k());
                    InterfaceC12529em.c cVarI = aVar3.i();
                    AbstractC13463gG6 abstractC13463gG62 = this.a;
                    C17468n10 c17468n103 = this.b;
                    String str2 = this.c;
                    InterfaceC10970cW3 interfaceC10970cW3B = J66.b(eVarP, cVarI, interfaceC22053ub1, 48);
                    int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                    InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                    androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarI);
                    InterfaceC16030kb1.a aVar4 = InterfaceC16030kb1.d0;
                    SA2 sa2A = aVar4.a();
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
                    DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar4.e());
                    DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar4.g());
                    InterfaceC14603iB2 interfaceC14603iB2B = aVar4.b();
                    if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                        interfaceC22053ub1A.s(Integer.valueOf(iA));
                        interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                    }
                    DG7.c(interfaceC22053ub1A, eVarE, aVar4.f());
                    M66 m66 = M66.a;
                    if (abstractC13463gG62 instanceof AbstractC13463gG6.b) {
                        interfaceC22053ub1.W(807293265);
                        AbstractC24077y03.b(FV4.c(((AbstractC13463gG6.b) abstractC13463gG62).b(), interfaceC22053ub1, 0), null, androidx.compose.foundation.layout.t.t(aVar2, g102.c(interfaceC22053ub1, 6).b().j()), g102.a(interfaceC22053ub1, 6).r(), interfaceC22053ub1, 48, 0);
                        interfaceC22053ub1.Q();
                        str = str2;
                        c17468n10 = c17468n103;
                        abstractC13463gG6 = abstractC13463gG62;
                        g10 = g102;
                    } else if ((abstractC13463gG62 instanceof AbstractC13463gG6.a) && ((AbstractC13463gG6.a) abstractC13463gG62).f() && c17468n103.g() != -2) {
                        interfaceC22053ub1.W(807939522);
                        a aVar5 = C17468n10.g;
                        int iG = c17468n103.g();
                        str = str2;
                        c17468n10 = c17468n103;
                        abstractC13463gG6 = abstractC13463gG62;
                        g10 = g102;
                        aVar5.c(iG != -1 ? iG != 0 ? c17468n103.g() : 2750 : 1500, 0.0f, 0L, 0L, 0L, 0.0f, interfaceC22053ub1, 1572864, 62);
                        interfaceC22053ub1.Q();
                    } else {
                        str = str2;
                        c17468n10 = c17468n103;
                        abstractC13463gG6 = abstractC13463gG62;
                        g10 = g102;
                        interfaceC22053ub1.W(808330649);
                        interfaceC22053ub1.Q();
                    }
                    AbstractC9339Zm7.b(str, L66.b(m66, aVar2, 1.0f, false, 2, null), g10.a(interfaceC22053ub1, 6).r(), 0L, null, null, null, 0L, null, C6399Nk7.h(abstractC13463gG6.a()), 0L, 0, false, 2, 0, null, g10.d(interfaceC22053ub1, 6).m(), interfaceC22053ub1, 0, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 56824);
                    interfaceC22053ub1.W(-1220834064);
                    final AbstractC13463gG6 abstractC13463gG63 = abstractC13463gG6;
                    if (abstractC13463gG63 instanceof AbstractC13463gG6.a) {
                        AbstractC13463gG6.a aVar6 = (AbstractC13463gG6.a) abstractC13463gG63;
                        Integer numD = aVar6.d();
                        interfaceC22053ub1.W(-1220831713);
                        if (numD == null) {
                            c17468n102 = c17468n10;
                            aVar = aVar2;
                            i2 = 6;
                        } else {
                            int iIntValue = numD.intValue();
                            i2 = 6;
                            aVar = aVar2;
                            androidx.compose.ui.e eVarT = androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1, 6).b().j());
                            interfaceC22053ub1.W(-1644999143);
                            c17468n102 = c17468n10;
                            boolean zD = interfaceC22053ub1.D(c17468n102) | interfaceC22053ub1.V(abstractC13463gG63);
                            Object objB = interfaceC22053ub1.B();
                            if (zD || objB == InterfaceC22053ub1.a.a()) {
                                objB = new SA2() { // from class: ir.nasim.o10
                                    @Override // ir.nasim.SA2
                                    public final Object invoke() {
                                        return C17468n10.c.a.C1404a.d(c17468n102, abstractC13463gG63);
                                    }
                                };
                                interfaceC22053ub1.s(objB);
                            }
                            interfaceC22053ub1.Q();
                            androidx.compose.ui.e eVarF = androidx.compose.foundation.e.f(eVarT, false, null, null, (SA2) objB, 7, null);
                            EV4 ev4C = FV4.c(iIntValue, interfaceC22053ub1, 0);
                            if (aVar6.g() == null) {
                                interfaceC22053ub1.W(-1644982542);
                                jI = g10.a(interfaceC22053ub1, 6).r();
                            } else {
                                interfaceC22053ub1.W(-1644981265);
                                jI = g10.a(interfaceC22053ub1, 6).I();
                            }
                            interfaceC22053ub1.Q();
                            AbstractC24077y03.b(ev4C, null, eVarF, jI, interfaceC22053ub1, 48, 0);
                        }
                        interfaceC22053ub1.Q();
                        String strG = aVar6.g();
                        if (strG != null) {
                            interfaceC22053ub1.W(-1644972791);
                            boolean zD2 = interfaceC22053ub1.D(c17468n102) | interfaceC22053ub1.V(abstractC13463gG63);
                            Object objB2 = interfaceC22053ub1.B();
                            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                                objB2 = new SA2() { // from class: ir.nasim.p10
                                    @Override // ir.nasim.SA2
                                    public final Object invoke() {
                                        return C17468n10.c.a.C1404a.f(c17468n102, abstractC13463gG63);
                                    }
                                };
                                interfaceC22053ub1.s(objB2);
                            }
                            interfaceC22053ub1.Q();
                            AbstractC9339Zm7.b(strG, androidx.compose.foundation.e.f(aVar, false, null, null, (SA2) objB2, 7, null), g10.a(interfaceC22053ub1, i2).I(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i2).l(), interfaceC22053ub1, 0, 0, 65528);
                        }
                    }
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.u();
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    return C19938rB7.a;
                }
            }

            a(AbstractC13463gG6 abstractC13463gG6, C17468n10 c17468n10, String str) {
                this.a = abstractC13463gG6;
                this.b = c17468n10;
                this.c = str;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                AbstractC6535Nx5 abstractC6535Nx5N;
                EnumC12613eu3 enumC12613eu3;
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                if (JF5.g()) {
                    abstractC6535Nx5N = AbstractC13040fc1.n();
                    enumC12613eu3 = EnumC12613eu3.b;
                } else {
                    abstractC6535Nx5N = AbstractC13040fc1.n();
                    enumC12613eu3 = EnumC12613eu3.a;
                }
                AbstractC11024cc1.a(abstractC6535Nx5N.d(enumC12613eu3), AbstractC19242q11.e(-1195019075, true, new C1404a(this.a, this.b, this.c), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        c(AbstractC13463gG6 abstractC13463gG6, C17468n10 c17468n10, String str) {
            this.a = abstractC13463gG6;
            this.b = c17468n10;
            this.c = str;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(-651341827, true, new a(this.a, this.b, this.c), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C17468n10(View view) {
        this(view, null, 0, 6, null);
        AbstractC13042fc3.i(view, "view");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Snackbar h() {
        Object value = this.f.getValue();
        AbstractC13042fc3.h(value, "getValue(...)");
        return (Snackbar) value;
    }

    public static /* synthetic */ C17468n10 p(C17468n10 c17468n10, String str, AbstractC13463gG6 abstractC13463gG6, UA2 ua2, int i, Object obj) {
        if ((i & 2) != 0) {
            abstractC13463gG6 = AbstractC13463gG6.c.b;
        }
        if ((i & 4) != 0) {
            ua2 = new UA2() { // from class: ir.nasim.k10
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj2) {
                    return C17468n10.q(((Boolean) obj2).booleanValue());
                }
            };
        }
        return c17468n10.n(str, abstractC13463gG6, ua2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 q(boolean z) {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Snackbar r(C17468n10 c17468n10) {
        AbstractC13042fc3.i(c17468n10, "this$0");
        Snackbar snackbarI0 = Snackbar.i0(c17468n10.a, "", c17468n10.c);
        View view = c17468n10.b;
        if (view != null) {
            snackbarI0.Q(view);
        }
        snackbarI0.R(1);
        snackbarI0.k0(AbstractC4043Dl1.c(c17468n10.a.getContext(), IA5.transparent));
        return snackbarI0;
    }

    public final void f() {
        h().t();
    }

    public final int g() {
        return this.c;
    }

    public final boolean i() {
        return this.e;
    }

    public final boolean j() {
        return h().H();
    }

    public final void k(View view) {
        this.b = view;
    }

    public final void l(boolean z) {
        this.e = z;
    }

    public final void m(int i) {
        this.c = i;
    }

    public final C17468n10 n(String str, AbstractC13463gG6 abstractC13463gG6, UA2 ua2) {
        AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(abstractC13463gG6, "snackBarStyle");
        AbstractC13042fc3.i(ua2, "onDismissListener");
        this.e = false;
        Context context = this.a.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        ComposeView composeView = new ComposeView(context, null, 0, 6, null);
        composeView.setContent(AbstractC19242q11.c(1721205826, true, new c(abstractC13463gG6, this, str)));
        h().p(new b(ua2));
        View viewD = h().D();
        AbstractC13042fc3.g(viewD, "null cannot be cast to non-null type com.google.android.material.snackbar.Snackbar.SnackbarLayout");
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) viewD;
        snackbarLayout.setBackground(AbstractC4043Dl1.f(this.a.getContext(), AbstractC24188yB5.bale_snackbar));
        if (AbstractC24379yW7.a(snackbarLayout, snackbarLayout.getChildCount() - 1) instanceof ComposeView) {
            snackbarLayout.removeViewAt(snackbarLayout.getChildCount() - 1);
        }
        snackbarLayout.addView(composeView);
        h().W();
        return this;
    }

    public final void o(String str) {
        AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
        p(this, str, AbstractC13463gG6.c.b, null, 4, null);
    }

    public C17468n10(View view, View view2, int i) {
        AbstractC13042fc3.i(view, "view");
        this.a = view;
        this.b = view2;
        this.c = i;
        this.f = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.j10
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C17468n10.r(this.a);
            }
        });
    }

    public /* synthetic */ C17468n10(View view, View view2, int i, int i2, ED1 ed1) {
        this(view, (i2 & 2) != 0 ? null : view2, (i2 & 4) != 0 ? 0 : i);
    }
}
