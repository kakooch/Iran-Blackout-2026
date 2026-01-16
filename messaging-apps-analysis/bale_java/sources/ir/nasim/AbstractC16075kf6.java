package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.AbstractC16075kf6;
import ir.nasim.AbstractC17858ng6;
import ir.nasim.C24254yJ;
import ir.nasim.C4081Dp3;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;

/* renamed from: ir.nasim.kf6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC16075kf6 {

    /* renamed from: ir.nasim.kf6$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ AbstractC17858ng6 c;
        final /* synthetic */ InterfaceC3630Br2 d;
        final /* synthetic */ androidx.compose.ui.focus.m e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AbstractC17858ng6 abstractC17858ng6, InterfaceC3630Br2 interfaceC3630Br2, androidx.compose.ui.focus.m mVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = abstractC17858ng6;
            this.d = interfaceC3630Br2;
            this.e = mVar;
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
            AbstractC17858ng6 abstractC17858ng6 = this.c;
            if ((abstractC17858ng6 instanceof AbstractC17858ng6.a) && ((AbstractC17858ng6.a) abstractC17858ng6).c()) {
                InterfaceC3630Br2.m(this.d, false, 1, null);
            } else {
                AbstractC17858ng6 abstractC17858ng62 = this.c;
                if ((abstractC17858ng62 instanceof AbstractC17858ng6.a) && ((AbstractC17858ng6.a) abstractC17858ng62).d()) {
                    androidx.compose.ui.focus.m.g(this.e, 0, 1, null);
                }
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.kf6$b */
    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ boolean a;
        final /* synthetic */ androidx.compose.ui.e b;
        final /* synthetic */ String c;
        final /* synthetic */ UA2 d;
        final /* synthetic */ String e;
        final /* synthetic */ boolean f;
        final /* synthetic */ InterfaceC9664aL6 g;
        final /* synthetic */ androidx.compose.ui.focus.m h;
        final /* synthetic */ AbstractC17858ng6 i;
        final /* synthetic */ UA2 j;
        final /* synthetic */ UA2 k;
        final /* synthetic */ C21605tp3 l;
        final /* synthetic */ C11329cp3 m;
        final /* synthetic */ InterfaceC9102Ym4 n;

        /* renamed from: ir.nasim.kf6$b$a */
        static final class a implements InterfaceC15796kB2 {
            final /* synthetic */ String a;
            final /* synthetic */ String b;
            final /* synthetic */ InterfaceC9664aL6 c;

            a(String str, String str2, InterfaceC9664aL6 interfaceC9664aL6) {
                this.a = str;
                this.b = str2;
                this.c = interfaceC9664aL6;
            }

            public final void a(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                int i2;
                long jZ;
                AbstractC13042fc3.i(interfaceC14603iB2, "it");
                if ((i & 6) == 0) {
                    i2 = i | (interfaceC22053ub1.D(interfaceC14603iB2) ? 4 : 2);
                } else {
                    i2 = i;
                }
                if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                InterfaceC12529em interfaceC12529emH = InterfaceC12529em.a.h();
                String str = this.a;
                String str2 = this.b;
                InterfaceC9664aL6 interfaceC9664aL6 = this.c;
                e.a aVar = androidx.compose.ui.e.a;
                InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(interfaceC12529emH, false);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, aVar);
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
                DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar2.e());
                DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
                InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
                if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                    interfaceC22053ub1A.s(Integer.valueOf(iA));
                    interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                }
                DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
                androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
                interfaceC14603iB2.invoke(interfaceC22053ub1, Integer.valueOf(i2 & 14));
                interfaceC22053ub1.W(-1581177367);
                if (AbstractC20762sZ6.n0(str)) {
                    androidx.compose.ui.e eVarA = androidx.compose.ui.platform.t.a(androidx.compose.foundation.layout.q.m(aVar, C17784nZ1.q(2), 0.0f, 0.0f, 0.0f, 14, null), "SearchBar HintText");
                    C9348Zn7 c9348Zn7C = ((U10) interfaceC22053ub1.H(M10.m())).c();
                    if (AbstractC16075kf6.m(interfaceC9664aL6)) {
                        interfaceC22053ub1.W(-1581163019);
                        jZ = G10.a.a(interfaceC22053ub1, 6).x();
                    } else {
                        interfaceC22053ub1.W(-1581161931);
                        jZ = G10.a.a(interfaceC22053ub1, 6).z();
                    }
                    interfaceC22053ub1.Q();
                    AbstractC9339Zm7.b(str2, eVarA, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7C.b((16744447 & 1) != 0 ? c9348Zn7C.a.g() : jZ, (16744447 & 2) != 0 ? c9348Zn7C.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7C.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7C.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7C.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7C.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7C.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7C.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7C.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7C.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7C.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7C.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7C.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7C.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7C.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7C.b.h() : C6399Nk7.b.f(), (16744447 & 65536) != 0 ? c9348Zn7C.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7C.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7C.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7C.c : null, (16744447 & 1048576) != 0 ? c9348Zn7C.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7C.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7C.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7C.b.k() : null), interfaceC22053ub1, 48, 0, 65532);
                }
                interfaceC22053ub1.Q();
                interfaceC22053ub1.u();
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                a((InterfaceC14603iB2) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.kf6$b$b, reason: collision with other inner class name */
        static final class C1359b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ boolean c;
            final /* synthetic */ androidx.compose.ui.focus.m d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1359b(boolean z, androidx.compose.ui.focus.m mVar, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = z;
                this.d = mVar;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C1359b(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                if (this.c) {
                    androidx.compose.ui.focus.m.g(this.d, 0, 1, null);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1359b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        b(boolean z, androidx.compose.ui.e eVar, String str, UA2 ua2, String str2, boolean z2, InterfaceC9664aL6 interfaceC9664aL6, androidx.compose.ui.focus.m mVar, AbstractC17858ng6 abstractC17858ng6, UA2 ua22, UA2 ua23, C21605tp3 c21605tp3, C11329cp3 c11329cp3, InterfaceC9102Ym4 interfaceC9102Ym4) {
            this.a = z;
            this.b = eVar;
            this.c = str;
            this.d = ua2;
            this.e = str2;
            this.f = z2;
            this.g = interfaceC9664aL6;
            this.h = mVar;
            this.i = abstractC17858ng6;
            this.j = ua22;
            this.k = ua23;
            this.l = c21605tp3;
            this.m = c11329cp3;
            this.n = interfaceC9102Ym4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 o(long j, InterfaceC17460n02 interfaceC17460n02) {
            AbstractC13042fc3.i(interfaceC17460n02, "$this$drawBehind");
            float fW1 = interfaceC17460n02.w1(C17784nZ1.q(10));
            InterfaceC17460n02.b0(interfaceC17460n02, j, 0L, 0L, AbstractC8567Wn1.b((Float.floatToRawIntBits(fW1) << 32) | (Float.floatToRawIntBits(fW1) & 4294967295L)), null, 0.0f, null, 0, SetRpcStruct$ComposedRpc.LOAD_STICKER_COLLECTION_FIELD_NUMBER, null);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 p(UA2 ua2, AbstractC17858ng6 abstractC17858ng6, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC5517Jr2 interfaceC5517Jr2) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$focused$delegate");
            AbstractC13042fc3.i(interfaceC5517Jr2, "it");
            AbstractC16075kf6.r(interfaceC9102Ym4, interfaceC5517Jr2.a());
            if (interfaceC5517Jr2.a()) {
                ua2.invoke(new AbstractC17858ng6.a(false, (abstractC17858ng6 instanceof AbstractC17858ng6.a) && ((AbstractC17858ng6.a) abstractC17858ng6).e(), false, 4, null));
            } else {
                ua2.invoke(AbstractC17858ng6.b.b);
            }
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 t(InterfaceC11943do6 interfaceC11943do6) {
            AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
            AbstractC9939ao6.t(interfaceC11943do6);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 v(UA2 ua2) {
            ua2.invoke("");
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 w(UA2 ua2, String str, androidx.compose.ui.focus.m mVar) {
            AbstractC13042fc3.i(mVar, "$focusRequester");
            ua2.invoke(str);
            androidx.compose.ui.focus.m.g(mVar, 0, 1, null);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 x(long j, InterfaceC17460n02 interfaceC17460n02) {
            AbstractC13042fc3.i(interfaceC17460n02, "$this$drawBehind");
            InterfaceC17460n02.b0(interfaceC17460n02, j, 0L, 0L, 0L, null, 0.0f, null, 0, 254, null);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y(String str, InterfaceC11943do6 interfaceC11943do6) {
            AbstractC13042fc3.i(str, "$hint");
            AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
            AbstractC9939ao6.e0(interfaceC11943do6, str);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 z(androidx.compose.ui.focus.m mVar, UA2 ua2, String str) {
            AbstractC13042fc3.i(mVar, "$focusRequester");
            androidx.compose.ui.focus.m.g(mVar, 0, 1, null);
            ua2.invoke(str);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            n((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }

        public final void n(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            long jE;
            androidx.compose.ui.e eVarF;
            int i2;
            long jE2;
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            G10 g10 = G10.a;
            final long jR = g10.a(interfaceC22053ub1, 6).r();
            if (this.a) {
                interfaceC22053ub1.W(-34446165);
                androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(this.b, 0.0f, 1, null);
                float fQ = C17784nZ1.q(AbstractC16075kf6.m(this.g) ? 2 : 1);
                if (AbstractC16075kf6.m(this.g)) {
                    interfaceC22053ub1.W(-34265993);
                    jE2 = g10.a(interfaceC22053ub1, 6).I();
                    interfaceC22053ub1.Q();
                } else {
                    interfaceC22053ub1.W(-34173861);
                    jE2 = g10.a(interfaceC22053ub1, 6).E();
                    interfaceC22053ub1.Q();
                }
                androidx.compose.ui.e eVarB = androidx.compose.foundation.layout.t.b(AbstractC9287Zh0.f(eVarH, fQ, jE2, N46.d(C17784nZ1.q(10))), 0.0f, C17784nZ1.q(36), 1, null);
                interfaceC22053ub1.W(1800022492);
                boolean zF = interfaceC22053ub1.f(jR);
                Object objB = interfaceC22053ub1.B();
                if (zF || objB == InterfaceC22053ub1.a.a()) {
                    objB = new UA2() { // from class: ir.nasim.lf6
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return AbstractC16075kf6.b.o(jR, (InterfaceC17460n02) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                eVarF = androidx.compose.ui.platform.t.a(androidx.compose.ui.draw.b.b(eVarB, (UA2) objB), "SearchBar with top bar");
                interfaceC22053ub1.Q();
            } else {
                interfaceC22053ub1.W(-33508849);
                androidx.compose.ui.e eVarH2 = androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null);
                interfaceC22053ub1.W(1800037489);
                boolean zF2 = interfaceC22053ub1.f(jR);
                Object objB2 = interfaceC22053ub1.B();
                if (zF2 || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new UA2() { // from class: ir.nasim.mf6
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return AbstractC16075kf6.b.x(jR, (InterfaceC17460n02) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                interfaceC22053ub1.Q();
                androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(androidx.compose.ui.draw.b.b(eVarH2, (UA2) objB2), C17784nZ1.q(12));
                float fQ2 = C17784nZ1.q(AbstractC16075kf6.m(this.g) ? 2 : 1);
                if (AbstractC16075kf6.m(this.g)) {
                    interfaceC22053ub1.W(-33055753);
                    jE = g10.a(interfaceC22053ub1, 6).I();
                    interfaceC22053ub1.Q();
                } else {
                    interfaceC22053ub1.W(-32963621);
                    jE = g10.a(interfaceC22053ub1, 6).E();
                    interfaceC22053ub1.Q();
                }
                androidx.compose.ui.e eVarA = androidx.compose.ui.platform.t.a(androidx.compose.foundation.layout.t.b(AbstractC9287Zh0.f(eVarI, fQ2, jE, N46.d(C17784nZ1.q(10))), 0.0f, C17784nZ1.q(36), 1, null), "SearchBar with out top bar");
                interfaceC22053ub1.W(1800063293);
                boolean zV = interfaceC22053ub1.V(this.c);
                final String str = this.c;
                Object objB3 = interfaceC22053ub1.B();
                if (zV || objB3 == InterfaceC22053ub1.a.a()) {
                    objB3 = new UA2() { // from class: ir.nasim.nf6
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return AbstractC16075kf6.b.y(str, (InterfaceC11943do6) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB3);
                }
                interfaceC22053ub1.Q();
                androidx.compose.ui.e eVarC = AbstractC6919Pn6.c(eVarA, true, (UA2) objB3);
                interfaceC22053ub1.W(1800066706);
                boolean zV2 = interfaceC22053ub1.V(this.d) | interfaceC22053ub1.V(this.e);
                final androidx.compose.ui.focus.m mVar = this.h;
                final UA2 ua2 = this.d;
                final String str2 = this.e;
                Object objB4 = interfaceC22053ub1.B();
                if (zV2 || objB4 == InterfaceC22053ub1.a.a()) {
                    objB4 = new SA2() { // from class: ir.nasim.of6
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC16075kf6.b.z(mVar, ua2, str2);
                        }
                    };
                    interfaceC22053ub1.s(objB4);
                }
                interfaceC22053ub1.Q();
                eVarF = androidx.compose.foundation.e.f(eVarC, false, null, null, (SA2) objB4, 7, null);
                interfaceC22053ub1.Q();
            }
            C24254yJ.f fVarE = C24254yJ.a.e();
            InterfaceC12529em.c cVarI = InterfaceC12529em.a.i();
            final AbstractC17858ng6 abstractC17858ng6 = this.i;
            final UA2 ua22 = this.d;
            final String str3 = this.e;
            final UA2 ua23 = this.j;
            final androidx.compose.ui.focus.m mVar2 = this.h;
            final UA2 ua24 = this.k;
            C21605tp3 c21605tp3 = this.l;
            C11329cp3 c11329cp3 = this.m;
            final InterfaceC9102Ym4 interfaceC9102Ym4 = this.n;
            String str4 = this.c;
            InterfaceC9664aL6 interfaceC9664aL6 = this.g;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(fVarE, cVarI, interfaceC22053ub1, 54);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarF);
            InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            M66 m66 = M66.a;
            interfaceC22053ub1.W(-1112460711);
            boolean zV3 = interfaceC22053ub1.V(ua22) | interfaceC22053ub1.V(str3);
            Object objB5 = interfaceC22053ub1.B();
            if (zV3 || objB5 == InterfaceC22053ub1.a.a()) {
                objB5 = new SA2() { // from class: ir.nasim.pf6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC16075kf6.b.w(ua22, str3, mVar2);
                    }
                };
                interfaceC22053ub1.s(objB5);
            }
            interfaceC22053ub1.Q();
            AbstractC16075kf6.s(abstractC17858ng6, (SA2) objB5, interfaceC22053ub1, 0);
            e.a aVar2 = androidx.compose.ui.e.a;
            float f = 8;
            androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(androidx.compose.foundation.layout.t.b(L66.b(m66, aVar2, 1.0f, false, 2, null), 0.0f, C17784nZ1.q(22), 1, null), C17784nZ1.q(f), 0.0f, 0.0f, 0.0f, 14, null);
            interfaceC22053ub1.W(-1112449596);
            boolean zV4 = interfaceC22053ub1.V(ua23) | interfaceC22053ub1.V(abstractC17858ng6);
            Object objB6 = interfaceC22053ub1.B();
            if (zV4 || objB6 == InterfaceC22053ub1.a.a()) {
                objB6 = new UA2() { // from class: ir.nasim.qf6
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC16075kf6.b.p(ua23, abstractC17858ng6, interfaceC9102Ym4, (InterfaceC5517Jr2) obj);
                    }
                };
                interfaceC22053ub1.s(objB6);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarA2 = androidx.compose.ui.platform.t.a(androidx.compose.ui.focus.n.a(androidx.compose.ui.focus.e.a(eVarM, (UA2) objB6), mVar2), "SearchBar BasicTextField");
            interfaceC22053ub1.W(-1112426514);
            Object objB7 = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar3 = InterfaceC22053ub1.a;
            if (objB7 == aVar3.a()) {
                objB7 = new UA2() { // from class: ir.nasim.rf6
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC16075kf6.b.t((InterfaceC11943do6) obj);
                    }
                };
                interfaceC22053ub1.s(objB7);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarD = AbstractC6919Pn6.d(eVarA2, false, (UA2) objB7, 1, null);
            C9348Zn7 c9348Zn7C = ((U10) interfaceC22053ub1.H(M10.m())).c();
            AbstractC21415td0.b(str3, ua24, eVarD, true, false, c9348Zn7C.b((16744447 & 1) != 0 ? c9348Zn7C.a.g() : g10.a(interfaceC22053ub1, 6).F(), (16744447 & 2) != 0 ? c9348Zn7C.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7C.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7C.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7C.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7C.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7C.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7C.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7C.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7C.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7C.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7C.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7C.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7C.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7C.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7C.b.h() : C6399Nk7.b.f(), (16744447 & 65536) != 0 ? c9348Zn7C.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7C.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7C.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7C.c : null, (16744447 & 1048576) != 0 ? c9348Zn7C.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7C.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7C.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7C.b.k() : null), c21605tp3, c11329cp3, true, 0, 0, null, null, null, new CH6(g10.a(interfaceC22053ub1, 6).I(), null), AbstractC19242q11.e(-798607456, true, new a(str3, str4, interfaceC9664aL6), interfaceC22053ub1, 54), interfaceC22053ub1, 100690944, 196608, 15872);
            interfaceC22053ub1.W(-1112377013);
            if (str3.length() > 0) {
                androidx.compose.ui.e eVarT = androidx.compose.foundation.layout.t.t(androidx.compose.foundation.layout.q.m(aVar2, C17784nZ1.q(f), 0.0f, C17784nZ1.q(12), 0.0f, 10, null), C17784nZ1.q(14));
                interfaceC22053ub1.W(-1112370468);
                boolean zV5 = interfaceC22053ub1.V(ua24);
                Object objB8 = interfaceC22053ub1.B();
                if (zV5 || objB8 == aVar3.a()) {
                    objB8 = new SA2() { // from class: ir.nasim.sf6
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC16075kf6.b.v(ua24);
                        }
                    };
                    interfaceC22053ub1.s(objB8);
                }
                interfaceC22053ub1.Q();
                androidx.compose.ui.e eVarA3 = androidx.compose.ui.platform.t.a(androidx.compose.foundation.e.f(eVarT, false, null, null, (SA2) objB8, 7, null), "SearchBar CrossIcon");
                i2 = 0;
                AbstractC24077y03.b(FV4.c(AbstractC24188yB5.cross_search, interfaceC22053ub1, 0), null, eVarA3, g10.a(interfaceC22053ub1, 6).z(), interfaceC22053ub1, 48, 0);
            } else {
                i2 = 0;
            }
            interfaceC22053ub1.Q();
            interfaceC22053ub1.u();
            Boolean boolValueOf = Boolean.valueOf(this.f);
            interfaceC22053ub1.W(1800179802);
            boolean zA = interfaceC22053ub1.a(this.f);
            boolean z = this.f;
            androidx.compose.ui.focus.m mVar3 = this.h;
            Object objB9 = interfaceC22053ub1.B();
            if (zA || objB9 == aVar3.a()) {
                objB9 = new C1359b(z, mVar3, null);
                interfaceC22053ub1.s(objB9);
            }
            interfaceC22053ub1.Q();
            AbstractC10721c52.e(boolValueOf, (InterfaceC14603iB2) objB9, interfaceC22053ub1, i2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:189:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0115  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void j(final java.lang.String r29, java.lang.String r30, ir.nasim.UA2 r31, boolean r32, ir.nasim.UA2 r33, ir.nasim.AbstractC17858ng6 r34, boolean r35, androidx.compose.ui.e r36, ir.nasim.UA2 r37, ir.nasim.C21605tp3 r38, ir.nasim.C11329cp3 r39, ir.nasim.InterfaceC22053ub1 r40, final int r41, final int r42, final int r43) {
        /*
            Method dump skipped, instructions count: 826
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC16075kf6.j(java.lang.String, java.lang.String, ir.nasim.UA2, boolean, ir.nasim.UA2, ir.nasim.ng6, boolean, androidx.compose.ui.e, ir.nasim.UA2, ir.nasim.tp3, ir.nasim.cp3, ir.nasim.ub1, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k(String str) {
        AbstractC13042fc3.i(str, "it");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean l(InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$focused$delegate");
        return q(interfaceC9102Ym4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n(String str, String str2, UA2 ua2, boolean z, UA2 ua22, AbstractC17858ng6 abstractC17858ng6, boolean z2, androidx.compose.ui.e eVar, UA2 ua23, C21605tp3 c21605tp3, C11329cp3 c11329cp3, int i, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(str, "$hint");
        j(str, str2, ua2, z, ua22, abstractC17858ng6, z2, eVar, ua23, c21605tp3, c11329cp3, interfaceC22053ub1, QJ5.a(i | 1), QJ5.a(i2), i3);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o(AbstractC17858ng6 abstractC17858ng6) {
        AbstractC13042fc3.i(abstractC17858ng6, "it");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p(String str) {
        AbstractC13042fc3.i(str, "it");
        return C19938rB7.a;
    }

    private static final boolean q(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(final AbstractC17858ng6 abstractC17858ng6, final SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1567967419);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(abstractC17858ng6) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else if ((abstractC17858ng6 instanceof AbstractC17858ng6.a) && ((AbstractC17858ng6.a) abstractC17858ng6).e()) {
            interfaceC22053ub1J.W(937454914);
            C21097t63 c21097t63C = AbstractC22957w63.c("Loading", interfaceC22053ub1J, 6, 0);
            interfaceC22053ub1J.W(-1078129721);
            Object objB = interfaceC22053ub1J.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.gf6
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC16075kf6.t((C4081Dp3.b) obj);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            AbstractC11456d23.b(FV4.c(AbstractC24188yB5.loading, interfaceC22053ub1J, 0), null, androidx.compose.ui.platform.t.a(G46.a(androidx.compose.foundation.layout.t.t(androidx.compose.foundation.layout.q.m(androidx.compose.ui.e.a, C17784nZ1.q(12), 0.0f, 0.0f, 0.0f, 14, null), C17784nZ1.q(24)), u(AbstractC22957w63.a(c21097t63C, 0.0f, 360.0f, AbstractC5999Lt.e(AbstractC5999Lt.f((UA2) objB), null, 0L, 6, null), "Loading", interfaceC22053ub1J, C21097t63.f | 25008 | (C20494s63.d << 9), 0))), "SearchBar LoadingIcon"), null, null, 0.0f, null, interfaceC22053ub1J, 48, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
            interfaceC22053ub1J.Q();
        } else {
            interfaceC22053ub1J.W(938171944);
            androidx.compose.ui.e eVarA = androidx.compose.ui.platform.t.a(androidx.compose.foundation.layout.t.t(androidx.compose.foundation.layout.q.m(androidx.compose.ui.e.a, C17784nZ1.q(12), 0.0f, 0.0f, 0.0f, 14, null), C17784nZ1.q(24)), "SearchBar SearchIcon");
            interfaceC22053ub1J.W(-1078109114);
            boolean z = (i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32;
            Object objB2 = interfaceC22053ub1J.B();
            if (z || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.hf6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC16075kf6.v(sa2);
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarF = androidx.compose.foundation.e.f(eVarA, false, null, null, (SA2) objB2, 7, null);
            interfaceC22053ub1J.W(-1078106906);
            Object objB3 = interfaceC22053ub1J.B();
            if (objB3 == InterfaceC22053ub1.a.a()) {
                objB3 = new UA2() { // from class: ir.nasim.if6
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC16075kf6.w((InterfaceC11943do6) obj);
                    }
                };
                interfaceC22053ub1J.s(objB3);
            }
            interfaceC22053ub1J.Q();
            AbstractC24077y03.b(FV4.c(AbstractC24188yB5.search, interfaceC22053ub1J, 0), null, AbstractC6919Pn6.d(eVarF, false, (UA2) objB3, 1, null), G10.a.a(interfaceC22053ub1J, 6).z(), interfaceC22053ub1J, 48, 0);
            interfaceC22053ub1J.Q();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.jf6
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC16075kf6.x(abstractC17858ng6, sa2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t(C4081Dp3.b bVar) {
        AbstractC13042fc3.i(bVar, "$this$keyframes");
        bVar.d(SetRpcStruct$ComposedRpc.GET_JWT_TOKEN_FIELD_NUMBER);
        return C19938rB7.a;
    }

    private static final float u(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Number) interfaceC9664aL6.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 v(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$ocSearchIconClick");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 w(InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
        AbstractC9939ao6.t(interfaceC11943do6);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 x(AbstractC17858ng6 abstractC17858ng6, SA2 sa2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(abstractC17858ng6, "$isLoadingState");
        AbstractC13042fc3.i(sa2, "$ocSearchIconClick");
        s(abstractC17858ng6, sa2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
