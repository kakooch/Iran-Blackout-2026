package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.oG6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC18209oG6 {

    /* renamed from: ir.nasim.oG6$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ InterfaceC15254jG6 e;
        final /* synthetic */ InterfaceC15254jG6 f;
        final /* synthetic */ List g;
        final /* synthetic */ C23870xf2 h;

        /* renamed from: ir.nasim.oG6$a$a, reason: collision with other inner class name */
        static final class C1422a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ InterfaceC15254jG6 e;

            /* renamed from: ir.nasim.oG6$a$a$a, reason: collision with other inner class name */
            static final class C1423a extends AbstractC8614Ws3 implements SA2 {
                final /* synthetic */ InterfaceC15254jG6 e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1423a(InterfaceC15254jG6 interfaceC15254jG6) {
                    super(0);
                    this.e = interfaceC15254jG6;
                }

                @Override // ir.nasim.SA2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Boolean invoke() {
                    this.e.dismiss();
                    return Boolean.TRUE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1422a(InterfaceC15254jG6 interfaceC15254jG6) {
                super(1);
                this.e = interfaceC15254jG6;
            }

            public final void a(InterfaceC11943do6 interfaceC11943do6) {
                AbstractC9939ao6.k0(interfaceC11943do6, CD3.b.b());
                AbstractC9939ao6.m(interfaceC11943do6, null, new C1423a(this.e), 1, null);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((InterfaceC11943do6) obj);
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.oG6$a$b */
        static final class b extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ InterfaceC15254jG6 e;
            final /* synthetic */ C23870xf2 f;

            /* renamed from: ir.nasim.oG6$a$b$a, reason: collision with other inner class name */
            static final class C1424a extends AbstractC8614Ws3 implements UA2 {
                final /* synthetic */ InterfaceC15254jG6 e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1424a(InterfaceC15254jG6 interfaceC15254jG6) {
                    super(1);
                    this.e = interfaceC15254jG6;
                }

                @Override // ir.nasim.UA2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Boolean invoke(C22684vf2 c22684vf2) {
                    return Boolean.valueOf(AbstractC13042fc3.d(c22684vf2.c(), this.e));
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(InterfaceC15254jG6 interfaceC15254jG6, C23870xf2 c23870xf2) {
                super(0);
                this.e = interfaceC15254jG6;
                this.f = c23870xf2;
            }

            public final void a() {
                if (AbstractC13042fc3.d(this.e, this.f.a())) {
                    return;
                }
                AbstractC13610gX0.K(this.f.b(), new C1424a(this.e));
                OJ5 oj5C = this.f.c();
                if (oj5C != null) {
                    oj5C.invalidate();
                }
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC15254jG6 interfaceC15254jG6, InterfaceC15254jG6 interfaceC15254jG62, List list, C23870xf2 c23870xf2) {
            super(3);
            this.e = interfaceC15254jG6;
            this.f = interfaceC15254jG62;
            this.g = list;
            this.h = c23870xf2;
        }

        public final void a(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            if ((i & 6) == 0) {
                i2 = i | (interfaceC22053ub1.D(interfaceC14603iB2) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1654683077, i2, -1, "androidx.compose.material3.FadeInFadeOutWithScale.<anonymous>.<anonymous> (SnackbarHost.kt:338)");
            }
            boolean zD = AbstractC13042fc3.d(this.e, this.f);
            int i3 = zD ? 150 : 75;
            int i4 = (!zD || AbstractC12806fC3.b(this.g).size() == 1) ? 0 : 75;
            C7479Rw7 c7479Rw7K = AbstractC5999Lt.k(i3, i4, T22.e());
            boolean zV = interfaceC22053ub1.V(this.e) | interfaceC22053ub1.D(this.h);
            InterfaceC15254jG6 interfaceC15254jG6 = this.e;
            C23870xf2 c23870xf2 = this.h;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new b(interfaceC15254jG6, c23870xf2);
                interfaceC22053ub1.s(objB);
            }
            InterfaceC9664aL6 interfaceC9664aL6F = AbstractC18209oG6.f(c7479Rw7K, zD, (SA2) objB, interfaceC22053ub1, 0, 0);
            InterfaceC9664aL6 interfaceC9664aL6G = AbstractC18209oG6.g(AbstractC5999Lt.k(i3, i4, T22.d()), zD, interfaceC22053ub1, 0);
            androidx.compose.ui.e eVarC = androidx.compose.ui.graphics.b.c(androidx.compose.ui.e.a, ((Number) interfaceC9664aL6G.getValue()).floatValue(), ((Number) interfaceC9664aL6G.getValue()).floatValue(), ((Number) interfaceC9664aL6F.getValue()).floatValue(), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131064, null);
            boolean zV2 = interfaceC22053ub1.V(this.e);
            InterfaceC15254jG6 interfaceC15254jG62 = this.e;
            Object objB2 = interfaceC22053ub1.B();
            if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new C1422a(interfaceC15254jG62);
                interfaceC22053ub1.s(objB2);
            }
            androidx.compose.ui.e eVarD = AbstractC6919Pn6.d(eVarC, false, (UA2) objB2, 1, null);
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.o(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarD);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            interfaceC14603iB2.invoke(interfaceC22053ub1, Integer.valueOf(i2 & 14));
            interfaceC22053ub1.u();
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC14603iB2) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.oG6$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC15796kB2 e;
        final /* synthetic */ InterfaceC15254jG6 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC15796kB2 interfaceC15796kB2, InterfaceC15254jG6 interfaceC15254jG6) {
            super(2);
            this.e = interfaceC15796kB2;
            this.f = interfaceC15254jG6;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1135367807, i, -1, "androidx.compose.material3.FadeInFadeOutWithScale.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SnackbarHost.kt:395)");
            }
            InterfaceC15796kB2 interfaceC15796kB2 = this.e;
            InterfaceC15254jG6 interfaceC15254jG6 = this.f;
            AbstractC13042fc3.f(interfaceC15254jG6);
            interfaceC15796kB2.q(interfaceC15254jG6, interfaceC22053ub1, 0);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.oG6$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC15254jG6 e;
        final /* synthetic */ androidx.compose.ui.e f;
        final /* synthetic */ InterfaceC15796kB2 g;
        final /* synthetic */ int h;
        final /* synthetic */ int i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(InterfaceC15254jG6 interfaceC15254jG6, androidx.compose.ui.e eVar, InterfaceC15796kB2 interfaceC15796kB2, int i, int i2) {
            super(2);
            this.e = interfaceC15254jG6;
            this.f = eVar;
            this.g = interfaceC15796kB2;
            this.h = i;
            this.i = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC18209oG6.a(this.e, this.f, this.g, interfaceC22053ub1, QJ5.a(this.h | 1), this.i);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.oG6$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC15254jG6 c;
        final /* synthetic */ A2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(InterfaceC15254jG6 interfaceC15254jG6, A2 a2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC15254jG6;
            this.d = a2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC15254jG6 interfaceC15254jG6 = this.c;
                if (interfaceC15254jG6 != null) {
                    long jH = AbstractC18209oG6.h(interfaceC15254jG6.a().f(), this.c.a().a() != null, this.d);
                    this.b = 1;
                    if (HG1.b(jH, this) == objE) {
                        return objE;
                    }
                }
                return C19938rB7.a;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            this.c.dismiss();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.oG6$e */
    static final class e extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ C19391qG6 e;
        final /* synthetic */ androidx.compose.ui.e f;
        final /* synthetic */ InterfaceC15796kB2 g;
        final /* synthetic */ int h;
        final /* synthetic */ int i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(C19391qG6 c19391qG6, androidx.compose.ui.e eVar, InterfaceC15796kB2 interfaceC15796kB2, int i, int i2) {
            super(2);
            this.e = c19391qG6;
            this.f = eVar;
            this.g = interfaceC15796kB2;
            this.h = i;
            this.i = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC18209oG6.b(this.e, this.f, this.g, interfaceC22053ub1, QJ5.a(this.h | 1), this.i);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.oG6$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C15607js c;
        final /* synthetic */ boolean d;
        final /* synthetic */ InterfaceC5766Kt e;
        final /* synthetic */ SA2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(C15607js c15607js, boolean z, InterfaceC5766Kt interfaceC5766Kt, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c15607js;
            this.d = z;
            this.e = interfaceC5766Kt;
            this.f = sa2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new g(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C15607js c15607js = this.c;
                Float fC = AbstractC6392Nk0.c(this.d ? 1.0f : 0.0f);
                InterfaceC5766Kt interfaceC5766Kt = this.e;
                this.b = 1;
                if (C15607js.h(c15607js, fC, interfaceC5766Kt, null, null, this, 12, null) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            this.f.invoke();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.oG6$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C15607js c;
        final /* synthetic */ boolean d;
        final /* synthetic */ InterfaceC5766Kt e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(C15607js c15607js, boolean z, InterfaceC5766Kt interfaceC5766Kt, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c15607js;
            this.d = z;
            this.e = interfaceC5766Kt;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new h(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C15607js c15607js = this.c;
                Float fC = AbstractC6392Nk0.c(this.d ? 1.0f : 0.8f);
                InterfaceC5766Kt interfaceC5766Kt = this.e;
                this.b = 1;
                if (C15607js.h(c15607js, fC, interfaceC5766Kt, null, null, this, 12, null) == objE) {
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

    /* renamed from: ir.nasim.oG6$i */
    public /* synthetic */ class i {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC17618nG6.values().length];
            try {
                iArr[EnumC17618nG6.Indefinite.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC17618nG6.Long.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC17618nG6.Short.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01ab A[LOOP:2: B:74:0x01a9->B:75:0x01ab, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(ir.nasim.InterfaceC15254jG6 r16, androidx.compose.ui.e r17, ir.nasim.InterfaceC15796kB2 r18, ir.nasim.InterfaceC22053ub1 r19, int r20, int r21) {
        /*
            Method dump skipped, instructions count: 515
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC18209oG6.a(ir.nasim.jG6, androidx.compose.ui.e, ir.nasim.kB2, ir.nasim.ub1, int, int):void");
    }

    public static final void b(C19391qG6 c19391qG6, androidx.compose.ui.e eVar, InterfaceC15796kB2 interfaceC15796kB2, InterfaceC22053ub1 interfaceC22053ub1, int i2, int i3) {
        int i4;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(464178177);
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (interfaceC22053ub1J.V(c19391qG6) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i5 = i3 & 2;
        if (i5 != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            i4 |= interfaceC22053ub1J.V(eVar) ? 32 : 16;
        }
        int i6 = i3 & 4;
        if (i6 != 0) {
            i4 |= 384;
        } else if ((i2 & 384) == 0) {
            i4 |= interfaceC22053ub1J.D(interfaceC15796kB2) ? 256 : 128;
        }
        if ((i4 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            if (i5 != 0) {
                eVar = androidx.compose.ui.e.a;
            }
            if (i6 != 0) {
                interfaceC15796kB2 = G91.a.a();
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(464178177, i4, -1, "androidx.compose.material3.SnackbarHost (SnackbarHost.kt:221)");
            }
            InterfaceC15254jG6 interfaceC15254jG6B = c19391qG6.b();
            A2 a2 = (A2) interfaceC22053ub1J.H(AbstractC13040fc1.c());
            boolean zV = interfaceC22053ub1J.V(interfaceC15254jG6B) | interfaceC22053ub1J.D(a2);
            Object objB = interfaceC22053ub1J.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new d(interfaceC15254jG6B, a2, null);
                interfaceC22053ub1J.s(objB);
            }
            AbstractC10721c52.e(interfaceC15254jG6B, (InterfaceC14603iB2) objB, interfaceC22053ub1J, 0);
            a(c19391qG6.b(), eVar, interfaceC15796kB2, interfaceC22053ub1J, (i4 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i4 & 896), 0);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }
        androidx.compose.ui.e eVar2 = eVar;
        InterfaceC15796kB2 interfaceC15796kB22 = interfaceC15796kB2;
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new e(c19391qG6, eVar2, interfaceC15796kB22, i2, i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC9664aL6 f(InterfaceC5766Kt interfaceC5766Kt, boolean z, SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, int i2, int i3) {
        if ((i3 & 4) != 0) {
            sa2 = f.e;
        }
        SA2 sa22 = sa2;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1431889134, i2, -1, "androidx.compose.material3.animatedOpacity (SnackbarHost.kt:418)");
        }
        Object objB = interfaceC22053ub1.B();
        InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
        if (objB == aVar.a()) {
            objB = AbstractC19153ps.b(!z ? 1.0f : 0.0f, 0.0f, 2, null);
            interfaceC22053ub1.s(objB);
        }
        C15607js c15607js = (C15607js) objB;
        Boolean boolValueOf = Boolean.valueOf(z);
        boolean zD = interfaceC22053ub1.D(c15607js) | ((((i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) ^ 48) > 32 && interfaceC22053ub1.a(z)) || (i2 & 48) == 32) | interfaceC22053ub1.D(interfaceC5766Kt) | ((((i2 & 896) ^ 384) > 256 && interfaceC22053ub1.V(sa22)) || (i2 & 384) == 256);
        Object objB2 = interfaceC22053ub1.B();
        if (zD || objB2 == aVar.a()) {
            Object gVar = new g(c15607js, z, interfaceC5766Kt, sa22, null);
            interfaceC22053ub1.s(gVar);
            objB2 = gVar;
        }
        AbstractC10721c52.e(boolValueOf, (InterfaceC14603iB2) objB2, interfaceC22053ub1, (i2 >> 3) & 14);
        InterfaceC9664aL6 interfaceC9664aL6I = c15607js.i();
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return interfaceC9664aL6I;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC9664aL6 g(InterfaceC5766Kt interfaceC5766Kt, boolean z, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1966809761, i2, -1, "androidx.compose.material3.animatedScale (SnackbarHost.kt:428)");
        }
        Object objB = interfaceC22053ub1.B();
        InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
        if (objB == aVar.a()) {
            objB = AbstractC19153ps.b(!z ? 1.0f : 0.8f, 0.0f, 2, null);
            interfaceC22053ub1.s(objB);
        }
        C15607js c15607js = (C15607js) objB;
        Boolean boolValueOf = Boolean.valueOf(z);
        boolean zD = interfaceC22053ub1.D(c15607js) | ((((i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) ^ 48) > 32 && interfaceC22053ub1.a(z)) || (i2 & 48) == 32) | interfaceC22053ub1.D(interfaceC5766Kt);
        Object objB2 = interfaceC22053ub1.B();
        if (zD || objB2 == aVar.a()) {
            objB2 = new h(c15607js, z, interfaceC5766Kt, null);
            interfaceC22053ub1.s(objB2);
        }
        AbstractC10721c52.e(boolValueOf, (InterfaceC14603iB2) objB2, interfaceC22053ub1, (i2 >> 3) & 14);
        InterfaceC9664aL6 interfaceC9664aL6I = c15607js.i();
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return interfaceC9664aL6I;
    }

    public static final long h(EnumC17618nG6 enumC17618nG6, boolean z, A2 a2) {
        long j;
        int i2 = i.a[enumC17618nG6.ordinal()];
        if (i2 == 1) {
            j = Long.MAX_VALUE;
        } else if (i2 == 2) {
            j = 10000;
        } else {
            if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            j = 4000;
        }
        long j2 = j;
        return a2 == null ? j2 : a2.a(j2, true, true, z);
    }

    /* renamed from: ir.nasim.oG6$f */
    static final class f extends AbstractC8614Ws3 implements SA2 {
        public static final f e = new f();

        f() {
            super(0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }

        public final void a() {
        }
    }
}
