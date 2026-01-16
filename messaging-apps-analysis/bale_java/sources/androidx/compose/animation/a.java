package androidx.compose.animation;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.animation.AnimatedContentTransitionScopeImpl;
import androidx.compose.ui.e;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC10721c52;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC19242q11;
import ir.nasim.AbstractC21430te5;
import ir.nasim.AbstractC22231ut;
import ir.nasim.AbstractC5138Ib1;
import ir.nasim.AbstractC5999Lt;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C14063hH6;
import ir.nasim.C17312ml1;
import ir.nasim.C17833ne1;
import ir.nasim.C18827pJ6;
import ir.nasim.C19938rB7;
import ir.nasim.C21669tv7;
import ir.nasim.C23417wt;
import ir.nasim.C4414Fa3;
import ir.nasim.C7386Rm4;
import ir.nasim.EnumC17550n92;
import ir.nasim.IY7;
import ir.nasim.InterfaceC10195bE6;
import ir.nasim.InterfaceC11734dW3;
import ir.nasim.InterfaceC12377eW3;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC16978mB2;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC22821vt;
import ir.nasim.KV1;
import ir.nasim.LV1;
import ir.nasim.QJ5;
import ir.nasim.UA2;
import ir.nasim.ZV3;

/* loaded from: classes.dex */
public abstract class a {
    private static final long a;

    /* renamed from: androidx.compose.animation.a$a, reason: collision with other inner class name */
    static final class C0021a extends AbstractC8614Ws3 implements UA2 {
        public static final C0021a e = new C0021a();

        C0021a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C17312ml1 invoke(androidx.compose.animation.d dVar) {
            return a.e(f.o(AbstractC5999Lt.l(SetRpcStruct$ComposedRpc.MESSAGE_REMOVE_REACTION_FIELD_NUMBER, 90, null, 4, null), 0.0f, 2, null).c(f.s(AbstractC5999Lt.l(SetRpcStruct$ComposedRpc.MESSAGE_REMOVE_REACTION_FIELD_NUMBER, 90, null, 4, null), 0.92f, 0L, 4, null)), f.q(AbstractC5999Lt.l(90, 0, null, 6, null), 0.0f, 2, null));
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public final Object invoke(Object obj) {
            return obj;
        }
    }

    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ C21669tv7 e;
        final /* synthetic */ Object f;
        final /* synthetic */ UA2 g;
        final /* synthetic */ AnimatedContentTransitionScopeImpl h;
        final /* synthetic */ C14063hH6 i;
        final /* synthetic */ InterfaceC16978mB2 j;

        /* renamed from: androidx.compose.animation.a$c$a, reason: collision with other inner class name */
        static final class C0022a extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
            final /* synthetic */ C17312ml1 e;

            /* renamed from: androidx.compose.animation.a$c$a$a, reason: collision with other inner class name */
            static final class C0023a extends AbstractC8614Ws3 implements UA2 {
                final /* synthetic */ AbstractC21430te5 e;
                final /* synthetic */ C17312ml1 f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0023a(AbstractC21430te5 abstractC21430te5, C17312ml1 c17312ml1) {
                    super(1);
                    this.e = abstractC21430te5;
                    this.f = c17312ml1;
                }

                public final void a(AbstractC21430te5.a aVar) {
                    aVar.g(this.e, 0, 0, this.f.d());
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((AbstractC21430te5.a) obj);
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0022a(C17312ml1 c17312ml1) {
                super(3);
                this.e = c17312ml1;
            }

            public final InterfaceC11734dW3 a(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j) {
                AbstractC21430te5 abstractC21430te5L0 = zv3.l0(j);
                return InterfaceC12377eW3.Q1(interfaceC12377eW3, abstractC21430te5L0.P0(), abstractC21430te5L0.A0(), null, new C0023a(abstractC21430te5L0, this.e), 4, null);
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                return a((InterfaceC12377eW3) obj, (ZV3) obj2, ((C17833ne1) obj3).r());
            }
        }

        static final class b extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ Object e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(Object obj) {
                super(1);
                this.e = obj;
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(Object obj) {
                return Boolean.valueOf(AbstractC13042fc3.d(obj, this.e));
            }
        }

        /* renamed from: androidx.compose.animation.a$c$c, reason: collision with other inner class name */
        static final class C0024c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            final /* synthetic */ j e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0024c(j jVar) {
                super(2);
                this.e = jVar;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(EnumC17550n92 enumC17550n92, EnumC17550n92 enumC17550n922) {
                EnumC17550n92 enumC17550n923 = EnumC17550n92.c;
                return Boolean.valueOf(enumC17550n92 == enumC17550n923 && enumC17550n922 == enumC17550n923 && !this.e.b().d());
            }
        }

        static final class d extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
            final /* synthetic */ C14063hH6 e;
            final /* synthetic */ Object f;
            final /* synthetic */ AnimatedContentTransitionScopeImpl g;
            final /* synthetic */ InterfaceC16978mB2 h;

            /* renamed from: androidx.compose.animation.a$c$d$a, reason: collision with other inner class name */
            static final class C0025a extends AbstractC8614Ws3 implements UA2 {
                final /* synthetic */ C14063hH6 e;
                final /* synthetic */ Object f;
                final /* synthetic */ AnimatedContentTransitionScopeImpl g;

                /* renamed from: androidx.compose.animation.a$c$d$a$a, reason: collision with other inner class name */
                public static final class C0026a implements KV1 {
                    final /* synthetic */ C14063hH6 a;
                    final /* synthetic */ Object b;
                    final /* synthetic */ AnimatedContentTransitionScopeImpl c;

                    public C0026a(C14063hH6 c14063hH6, Object obj, AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl) {
                        this.a = c14063hH6;
                        this.b = obj;
                        this.c = animatedContentTransitionScopeImpl;
                    }

                    @Override // ir.nasim.KV1
                    public void dispose() {
                        this.a.remove(this.b);
                        this.c.h().u(this.b);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0025a(C14063hH6 c14063hH6, Object obj, AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl) {
                    super(1);
                    this.e = c14063hH6;
                    this.f = obj;
                    this.g = animatedContentTransitionScopeImpl;
                }

                @Override // ir.nasim.UA2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final KV1 invoke(LV1 lv1) {
                    return new C0026a(this.e, this.f, this.g);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(C14063hH6 c14063hH6, Object obj, AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl, InterfaceC16978mB2 interfaceC16978mB2) {
                super(3);
                this.e = c14063hH6;
                this.f = obj;
                this.g = animatedContentTransitionScopeImpl;
                this.h = interfaceC16978mB2;
            }

            public final void a(InterfaceC22821vt interfaceC22821vt, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 6) == 0) {
                    i |= (i & 8) == 0 ? interfaceC22053ub1.V(interfaceC22821vt) : interfaceC22053ub1.D(interfaceC22821vt) ? 4 : 2;
                }
                if (!interfaceC22053ub1.o((i & 19) != 18, i & 1)) {
                    interfaceC22053ub1.L();
                    return;
                }
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.Q(-616195562, i, -1, "androidx.compose.animation.AnimatedContent.<anonymous>.<anonymous>.<anonymous> (AnimatedContent.kt:853)");
                }
                boolean zV = interfaceC22053ub1.V(this.e) | interfaceC22053ub1.D(this.f) | interfaceC22053ub1.D(this.g);
                C14063hH6 c14063hH6 = this.e;
                Object obj = this.f;
                AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl = this.g;
                Object objB = interfaceC22053ub1.B();
                if (zV || objB == InterfaceC22053ub1.a.a()) {
                    objB = new C0025a(c14063hH6, obj, animatedContentTransitionScopeImpl);
                    interfaceC22053ub1.s(objB);
                }
                AbstractC10721c52.a(interfaceC22821vt, (UA2) objB, interfaceC22053ub1, i & 14);
                C7386Rm4 c7386Rm4H = this.g.h();
                Object obj2 = this.f;
                AbstractC13042fc3.g(interfaceC22821vt, "null cannot be cast to non-null type androidx.compose.animation.AnimatedVisibilityScopeImpl");
                c7386Rm4H.x(obj2, ((C23417wt) interfaceC22821vt).a());
                Object objB2 = interfaceC22053ub1.B();
                if (objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new androidx.compose.animation.c(interfaceC22821vt);
                    interfaceC22053ub1.s(objB2);
                }
                this.h.e((androidx.compose.animation.c) objB2, this.f, interfaceC22053ub1, 0);
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.P();
                }
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                a((InterfaceC22821vt) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C21669tv7 c21669tv7, Object obj, UA2 ua2, AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl, C14063hH6 c14063hH6, InterfaceC16978mB2 interfaceC16978mB2) {
            super(2);
            this.e = c21669tv7;
            this.f = obj;
            this.g = ua2;
            this.h = animatedContentTransitionScopeImpl;
            this.i = c14063hH6;
            this.j = interfaceC16978mB2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(885640742, i, -1, "androidx.compose.animation.AnimatedContent.<anonymous>.<anonymous> (AnimatedContent.kt:817)");
            }
            UA2 ua2 = this.g;
            AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl = this.h;
            Object objB = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = (C17312ml1) ua2.invoke(animatedContentTransitionScopeImpl);
                interfaceC22053ub1.s(objB);
            }
            C17312ml1 c17312ml1 = (C17312ml1) objB;
            boolean zA = interfaceC22053ub1.a(AbstractC13042fc3.d(this.e.m().a(), this.f));
            C21669tv7 c21669tv7 = this.e;
            Object obj = this.f;
            UA2 ua22 = this.g;
            AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl2 = this.h;
            Object objB2 = interfaceC22053ub1.B();
            if (zA || objB2 == aVar.a()) {
                objB2 = AbstractC13042fc3.d(c21669tv7.m().a(), obj) ? j.a.a() : ((C17312ml1) ua22.invoke(animatedContentTransitionScopeImpl2)).a();
                interfaceC22053ub1.s(objB2);
            }
            j jVar = (j) objB2;
            Object obj2 = this.f;
            C21669tv7 c21669tv72 = this.e;
            Object objB3 = interfaceC22053ub1.B();
            if (objB3 == aVar.a()) {
                objB3 = new AnimatedContentTransitionScopeImpl.a(AbstractC13042fc3.d(obj2, c21669tv72.o()));
                interfaceC22053ub1.s(objB3);
            }
            AnimatedContentTransitionScopeImpl.a aVar2 = (AnimatedContentTransitionScopeImpl.a) objB3;
            h hVarC = c17312ml1.c();
            e.a aVar3 = androidx.compose.ui.e.a;
            boolean zD = interfaceC22053ub1.D(c17312ml1);
            Object objB4 = interfaceC22053ub1.B();
            if (zD || objB4 == aVar.a()) {
                objB4 = new C0022a(c17312ml1);
                interfaceC22053ub1.s(objB4);
            }
            androidx.compose.ui.e eVarA = androidx.compose.ui.layout.b.a(aVar3, (InterfaceC15796kB2) objB4);
            aVar2.k(AbstractC13042fc3.d(this.f, this.e.o()));
            androidx.compose.ui.e eVarI = eVarA.i(aVar2);
            C21669tv7 c21669tv73 = this.e;
            boolean zD2 = interfaceC22053ub1.D(this.f);
            Object obj3 = this.f;
            Object objB5 = interfaceC22053ub1.B();
            if (zD2 || objB5 == aVar.a()) {
                objB5 = new b(obj3);
                interfaceC22053ub1.s(objB5);
            }
            UA2 ua23 = (UA2) objB5;
            boolean zV = interfaceC22053ub1.V(jVar);
            Object objB6 = interfaceC22053ub1.B();
            if (zV || objB6 == aVar.a()) {
                objB6 = new C0024c(jVar);
                interfaceC22053ub1.s(objB6);
            }
            AbstractC22231ut.a(c21669tv73, ua23, eVarI, hVarC, jVar, (InterfaceC14603iB2) objB6, null, AbstractC19242q11.e(-616195562, true, new d(this.i, this.f, this.h, this.j), interfaceC22053ub1, 54), interfaceC22053ub1, 12582912, 64);
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

    static final class d extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ C21669tv7 e;
        final /* synthetic */ androidx.compose.ui.e f;
        final /* synthetic */ UA2 g;
        final /* synthetic */ InterfaceC12529em h;
        final /* synthetic */ UA2 i;
        final /* synthetic */ InterfaceC16978mB2 j;
        final /* synthetic */ int k;
        final /* synthetic */ int l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(C21669tv7 c21669tv7, androidx.compose.ui.e eVar, UA2 ua2, InterfaceC12529em interfaceC12529em, UA2 ua22, InterfaceC16978mB2 interfaceC16978mB2, int i, int i2) {
            super(2);
            this.e = c21669tv7;
            this.f = eVar;
            this.g = ua2;
            this.h = interfaceC12529em;
            this.i = ua22;
            this.j = interfaceC16978mB2;
            this.k = i;
            this.l = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            a.a(this.e, this.f, this.g, this.h, this.i, this.j, interfaceC22053ub1, QJ5.a(this.k | 1), this.l);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final class e extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final e e = new e();

        e() {
            super(2);
        }

        public final C18827pJ6 a(long j, long j2) {
            return AbstractC5999Lt.j(0.0f, 400.0f, C4414Fa3.b(IY7.d(C4414Fa3.b)), 1, null);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a(((C4414Fa3) obj).j(), ((C4414Fa3) obj2).j());
        }
    }

    static {
        long j = RecyclerView.UNDEFINED_DURATION;
        a = C4414Fa3.c((j & 4294967295L) | (j << 32));
    }

    /* JADX WARN: Removed duplicated region for block: B:187:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:198:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(ir.nasim.C21669tv7 r20, androidx.compose.ui.e r21, ir.nasim.UA2 r22, ir.nasim.InterfaceC12529em r23, ir.nasim.UA2 r24, ir.nasim.InterfaceC16978mB2 r25, ir.nasim.InterfaceC22053ub1 r26, int r27, int r28) {
        /*
            Method dump skipped, instructions count: 935
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.a.a(ir.nasim.tv7, androidx.compose.ui.e, ir.nasim.UA2, ir.nasim.em, ir.nasim.UA2, ir.nasim.mB2, ir.nasim.ub1, int, int):void");
    }

    public static final InterfaceC10195bE6 b(boolean z, InterfaceC14603iB2 interfaceC14603iB2) {
        return new m(z, interfaceC14603iB2);
    }

    public static /* synthetic */ InterfaceC10195bE6 c(boolean z, InterfaceC14603iB2 interfaceC14603iB2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            interfaceC14603iB2 = e.e;
        }
        return b(z, interfaceC14603iB2);
    }

    public static final C17312ml1 e(h hVar, j jVar) {
        return new C17312ml1(hVar, jVar, 0.0f, null, 12, null);
    }
}
