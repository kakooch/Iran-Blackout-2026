package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import androidx.compose.ui.input.pointer.SuspendPointerInputElement;
import ir.nasim.AbstractC12407eZ6;
import ir.nasim.AbstractC21071t37;
import ir.nasim.InterfaceC16030kb1;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Zf4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC9273Zf4 {
    private static final float a = C17784nZ1.q(48);
    private static final float b = C17784nZ1.q(24);
    private static final long c = AbstractC13854gv7.a(0.5f, 0.0f);

    /* renamed from: ir.nasim.Zf4$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final a e = new a();

        a() {
            super(2);
        }

        public final A98 a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(58488196);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(58488196, i, -1, "androidx.compose.material3.ModalBottomSheet.<anonymous> (ModalBottomSheet.kt:129)");
            }
            A98 a98G = C8062Uj0.a.g(interfaceC22053ub1, 6);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            interfaceC22053ub1.Q();
            return a98G;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
        }
    }

    /* renamed from: ir.nasim.Zf4$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ C19818qz6 e;
        final /* synthetic */ InterfaceC20315ro1 f;
        final /* synthetic */ C15607js g;
        final /* synthetic */ SA2 h;

        /* renamed from: ir.nasim.Zf4$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C15607js c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C15607js c15607js, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c15607js;
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
                    C15607js c15607js = this.c;
                    Float fC = AbstractC6392Nk0.c(0.0f);
                    this.b = 1;
                    if (C15607js.h(c15607js, fC, null, null, null, this, 14, null) == objE) {
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

        /* renamed from: ir.nasim.Zf4$b$b, reason: collision with other inner class name */
        static final class C0804b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C19818qz6 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0804b(C19818qz6 c19818qz6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c19818qz6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C0804b(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C19818qz6 c19818qz6 = this.c;
                    this.b = 1;
                    if (c19818qz6.l(this) == objE) {
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
                return ((C0804b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.Zf4$b$c */
        static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C19818qz6 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(C19818qz6 c19818qz6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c19818qz6;
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
                return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.Zf4$b$d */
        static final class d extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ SA2 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(SA2 sa2) {
                super(1);
                this.e = sa2;
            }

            public final void a(Throwable th) {
                this.e.invoke();
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((Throwable) obj);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C19818qz6 c19818qz6, InterfaceC20315ro1 interfaceC20315ro1, C15607js c15607js, SA2 sa2) {
            super(0);
            this.e = c19818qz6;
            this.f = interfaceC20315ro1;
            this.g = c15607js;
            this.h = sa2;
        }

        public final void a() {
            if (this.e.e() != EnumC20427rz6.Expanded || !this.e.g()) {
                AbstractC10533bm0.d(this.f, null, null, new c(this.e, null), 3, null).s(new d(this.h));
            } else {
                AbstractC10533bm0.d(this.f, null, null, new a(this.g, null), 3, null);
                AbstractC10533bm0.d(this.f, null, null, new C0804b(this.e, null), 3, null);
            }
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Zf4$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ long e;
        final /* synthetic */ SA2 f;
        final /* synthetic */ C19818qz6 g;
        final /* synthetic */ C15607js h;
        final /* synthetic */ InterfaceC20315ro1 i;
        final /* synthetic */ UA2 j;
        final /* synthetic */ androidx.compose.ui.e k;
        final /* synthetic */ float l;
        final /* synthetic */ InterfaceC10031ax6 m;
        final /* synthetic */ long n;
        final /* synthetic */ long o;
        final /* synthetic */ float p;
        final /* synthetic */ InterfaceC14603iB2 q;
        final /* synthetic */ InterfaceC14603iB2 r;
        final /* synthetic */ InterfaceC15796kB2 s;

        /* renamed from: ir.nasim.Zf4$c$a */
        static final class a extends AbstractC8614Ws3 implements UA2 {
            public static final a e = new a();

            a() {
                super(1);
            }

            public final void a(InterfaceC11943do6 interfaceC11943do6) {
                AbstractC9939ao6.E0(interfaceC11943do6, true);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((InterfaceC11943do6) obj);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(long j, SA2 sa2, C19818qz6 c19818qz6, C15607js c15607js, InterfaceC20315ro1 interfaceC20315ro1, UA2 ua2, androidx.compose.ui.e eVar, float f, InterfaceC10031ax6 interfaceC10031ax6, long j2, long j3, float f2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC15796kB2 interfaceC15796kB2) {
            super(2);
            this.e = j;
            this.f = sa2;
            this.g = c19818qz6;
            this.h = c15607js;
            this.i = interfaceC20315ro1;
            this.j = ua2;
            this.k = eVar;
            this.l = f;
            this.m = interfaceC10031ax6;
            this.n = j2;
            this.o = j3;
            this.p = f2;
            this.q = interfaceC14603iB2;
            this.r = interfaceC14603iB22;
            this.s = interfaceC15796kB2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-314673510, i, -1, "androidx.compose.material3.ModalBottomSheet.<anonymous> (ModalBottomSheet.kt:168)");
            }
            androidx.compose.ui.e eVarD = AbstractC6919Pn6.d(AbstractC22640va8.a(androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null)), false, a.e, 1, null);
            long j = this.e;
            SA2 sa2 = this.f;
            C19818qz6 c19818qz6 = this.g;
            C15607js c15607js = this.h;
            InterfaceC20315ro1 interfaceC20315ro1 = this.i;
            UA2 ua2 = this.j;
            androidx.compose.ui.e eVar = this.k;
            float f = this.l;
            InterfaceC10031ax6 interfaceC10031ax6 = this.m;
            long j2 = this.n;
            long j3 = this.o;
            float f2 = this.p;
            InterfaceC14603iB2 interfaceC14603iB2 = this.q;
            InterfaceC14603iB2 interfaceC14603iB22 = this.r;
            InterfaceC15796kB2 interfaceC15796kB2 = this.s;
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
            AbstractC9273Zf4.c(j, sa2, c19818qz6.i() != EnumC20427rz6.Hidden, interfaceC22053ub1, 0);
            AbstractC9273Zf4.b(hVar, c15607js, interfaceC20315ro1, sa2, ua2, eVar, c19818qz6, f, interfaceC10031ax6, j2, j3, f2, interfaceC14603iB2, interfaceC14603iB22, interfaceC15796kB2, interfaceC22053ub1, 6 | (C15607js.o << 3), 0, 0);
            interfaceC22053ub1.u();
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

    /* renamed from: ir.nasim.Zf4$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C19818qz6 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(C19818qz6 c19818qz6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c19818qz6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C19818qz6 c19818qz6 = this.c;
                this.b = 1;
                if (c19818qz6.o(this) == objE) {
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
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Zf4$e */
    static final class e extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ androidx.compose.ui.e f;
        final /* synthetic */ C19818qz6 g;
        final /* synthetic */ float h;
        final /* synthetic */ InterfaceC10031ax6 i;
        final /* synthetic */ long j;
        final /* synthetic */ long k;
        final /* synthetic */ float l;
        final /* synthetic */ long m;
        final /* synthetic */ InterfaceC14603iB2 n;
        final /* synthetic */ InterfaceC14603iB2 o;
        final /* synthetic */ C9857ag4 p;
        final /* synthetic */ InterfaceC15796kB2 q;
        final /* synthetic */ int r;
        final /* synthetic */ int s;
        final /* synthetic */ int t;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(SA2 sa2, androidx.compose.ui.e eVar, C19818qz6 c19818qz6, float f, InterfaceC10031ax6 interfaceC10031ax6, long j, long j2, float f2, long j3, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, C9857ag4 c9857ag4, InterfaceC15796kB2 interfaceC15796kB2, int i, int i2, int i3) {
            super(2);
            this.e = sa2;
            this.f = eVar;
            this.g = c19818qz6;
            this.h = f;
            this.i = interfaceC10031ax6;
            this.j = j;
            this.k = j2;
            this.l = f2;
            this.m = j3;
            this.n = interfaceC14603iB2;
            this.o = interfaceC14603iB22;
            this.p = c9857ag4;
            this.q = interfaceC15796kB2;
            this.r = i;
            this.s = i2;
            this.t = i3;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC9273Zf4.a(this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, interfaceC22053ub1, QJ5.a(this.r | 1), QJ5.a(this.s), this.t);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Zf4$f */
    static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ C19818qz6 e;
        final /* synthetic */ InterfaceC20315ro1 f;
        final /* synthetic */ SA2 g;

        /* renamed from: ir.nasim.Zf4$f$a */
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

        /* renamed from: ir.nasim.Zf4$f$b */
        static final class b extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ C19818qz6 e;
            final /* synthetic */ SA2 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C19818qz6 c19818qz6, SA2 sa2) {
                super(1);
                this.e = c19818qz6;
                this.f = sa2;
            }

            public final void a(Throwable th) {
                if (this.e.k()) {
                    return;
                }
                this.f.invoke();
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((Throwable) obj);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(C19818qz6 c19818qz6, InterfaceC20315ro1 interfaceC20315ro1, SA2 sa2) {
            super(0);
            this.e = c19818qz6;
            this.f = interfaceC20315ro1;
            this.g = sa2;
        }

        public final void a() {
            if (((Boolean) this.e.d().r().invoke(EnumC20427rz6.Hidden)).booleanValue()) {
                AbstractC10533bm0.d(this.f, null, null, new a(this.e, null), 3, null).s(new b(this.e, this.g));
            }
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Zf4$g */
    static final class g extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC20315ro1 e;
        final /* synthetic */ C19818qz6 f;
        final /* synthetic */ SA2 g;

        /* renamed from: ir.nasim.Zf4$g$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C19818qz6 c;
            final /* synthetic */ float d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C19818qz6 c19818qz6, float f, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c19818qz6;
                this.d = f;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C19818qz6 c19818qz6 = this.c;
                    float f = this.d;
                    this.b = 1;
                    if (c19818qz6.n(f, this) == objE) {
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

        /* renamed from: ir.nasim.Zf4$g$b */
        static final class b extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ C19818qz6 e;
            final /* synthetic */ SA2 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C19818qz6 c19818qz6, SA2 sa2) {
                super(1);
                this.e = c19818qz6;
                this.f = sa2;
            }

            public final void a(Throwable th) {
                if (this.e.k()) {
                    return;
                }
                this.f.invoke();
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((Throwable) obj);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(InterfaceC20315ro1 interfaceC20315ro1, C19818qz6 c19818qz6, SA2 sa2) {
            super(1);
            this.e = interfaceC20315ro1;
            this.f = c19818qz6;
            this.g = sa2;
        }

        public final void a(float f) {
            AbstractC10533bm0.d(this.e, null, null, new a(this.f, f, null), 3, null).s(new b(this.f, this.g));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Number) obj).floatValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Zf4$h */
    static final class h extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final h e = new h();

        h() {
            super(2);
        }

        public final A98 a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(-11444670);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-11444670, i, -1, "androidx.compose.material3.ModalBottomSheetContent.<anonymous> (ModalBottomSheet.kt:212)");
            }
            A98 a98G = C8062Uj0.a.g(interfaceC22053ub1, 6);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            interfaceC22053ub1.Q();
            return a98G;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
        }
    }

    /* renamed from: ir.nasim.Zf4$i */
    static final class i extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ C19818qz6 e;

        /* renamed from: ir.nasim.Zf4$i$a */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[EnumC20427rz6.values().length];
                try {
                    iArr[EnumC20427rz6.Hidden.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC20427rz6.PartiallyExpanded.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[EnumC20427rz6.Expanded.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                a = iArr;
            }
        }

        /* renamed from: ir.nasim.Zf4$i$b */
        static final class b extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ float e;
            final /* synthetic */ long f;
            final /* synthetic */ C19818qz6 g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(float f, long j, C19818qz6 c19818qz6) {
                super(1);
                this.e = f;
                this.f = j;
                this.g = c19818qz6;
            }

            public final void a(LZ1 lz1) {
                lz1.a(EnumC20427rz6.Hidden, this.e);
                if (C4414Fa3.f(this.f) > this.e / 2 && !this.g.h()) {
                    lz1.a(EnumC20427rz6.PartiallyExpanded, this.e / 2.0f);
                }
                if (C4414Fa3.f(this.f) != 0) {
                    lz1.a(EnumC20427rz6.Expanded, Math.max(0.0f, this.e - C4414Fa3.f(this.f)));
                }
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((LZ1) obj);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(C19818qz6 c19818qz6) {
            super(2);
            this.e = c19818qz6;
        }

        public final XV4 a(long j, long j2) {
            EnumC20427rz6 enumC20427rz6;
            JZ1 jz1A = androidx.compose.material3.internal.b.a(new b(C17833ne1.k(j2), j, this.e));
            int i = a.a[((EnumC20427rz6) this.e.d().x()).ordinal()];
            if (i == 1) {
                enumC20427rz6 = EnumC20427rz6.Hidden;
            } else {
                if (i != 2 && i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                enumC20427rz6 = EnumC20427rz6.PartiallyExpanded;
                if (!jz1A.c(enumC20427rz6)) {
                    enumC20427rz6 = EnumC20427rz6.Expanded;
                    if (!jz1A.c(enumC20427rz6)) {
                        enumC20427rz6 = EnumC20427rz6.Hidden;
                    }
                }
            }
            return AbstractC4616Fw7.a(jz1A, enumC20427rz6);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a(((C4414Fa3) obj).j(), ((C17833ne1) obj2).r());
        }
    }

    /* renamed from: ir.nasim.Zf4$j */
    static final class j extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ float c;
        final /* synthetic */ UA2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
            this.d = ua2;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            this.d.invoke(AbstractC6392Nk0.c(this.c));
            return C19938rB7.a;
        }

        public final Object n(InterfaceC20315ro1 interfaceC20315ro1, float f, InterfaceC20295rm1 interfaceC20295rm1) {
            j jVar = new j(this.d, interfaceC20295rm1);
            jVar.c = f;
            return jVar.invokeSuspend(C19938rB7.a);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return n((InterfaceC20315ro1) obj, ((Number) obj2).floatValue(), (InterfaceC20295rm1) obj3);
        }
    }

    /* renamed from: ir.nasim.Zf4$k */
    static final class k extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(String str) {
            super(1);
            this.e = str;
        }

        public final void a(InterfaceC11943do6 interfaceC11943do6) {
            AbstractC9939ao6.l0(interfaceC11943do6, this.e);
            AbstractC9939ao6.F0(interfaceC11943do6, 0.0f);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC11943do6) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Zf4$l */
    static final class l extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C19818qz6 e;
        final /* synthetic */ C15607js f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(C19818qz6 c19818qz6, C15607js c15607js) {
            super(1);
            this.e = c19818qz6;
            this.f = c15607js;
        }

        public final void a(androidx.compose.ui.graphics.c cVar) {
            float fW = this.e.d().w();
            float fG = OD6.g(cVar.d());
            if (Float.isNaN(fW) || Float.isNaN(fG) || fG == 0.0f) {
                return;
            }
            float fFloatValue = ((Number) this.f.q()).floatValue();
            cVar.g(AbstractC9273Zf4.j(cVar, fFloatValue));
            cVar.m(AbstractC9273Zf4.k(cVar, fFloatValue));
            cVar.C0(AbstractC13854gv7.a(0.5f, (fW + fG) / fG));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((androidx.compose.ui.graphics.c) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Zf4$m */
    static final class m extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC14603iB2 e;
        final /* synthetic */ C15607js f;
        final /* synthetic */ InterfaceC14603iB2 g;
        final /* synthetic */ C19818qz6 h;
        final /* synthetic */ SA2 i;
        final /* synthetic */ InterfaceC20315ro1 j;
        final /* synthetic */ InterfaceC15796kB2 k;

        /* renamed from: ir.nasim.Zf4$m$a */
        static final class a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ C15607js e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C15607js c15607js) {
                super(1);
                this.e = c15607js;
            }

            public final void a(androidx.compose.ui.graphics.c cVar) {
                float fFloatValue = ((Number) this.e.q()).floatValue();
                float fJ = AbstractC9273Zf4.j(cVar, fFloatValue);
                float fK = AbstractC9273Zf4.k(cVar, fFloatValue);
                cVar.m(fK == 0.0f ? 1.0f : fJ / fK);
                cVar.C0(AbstractC9273Zf4.c);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((androidx.compose.ui.graphics.c) obj);
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.Zf4$m$b */
        static final class b extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ C19818qz6 e;
            final /* synthetic */ String f;
            final /* synthetic */ String g;
            final /* synthetic */ String h;
            final /* synthetic */ SA2 i;
            final /* synthetic */ InterfaceC20315ro1 j;

            /* renamed from: ir.nasim.Zf4$m$b$a */
            static final class a extends AbstractC8614Ws3 implements SA2 {
                final /* synthetic */ SA2 e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(SA2 sa2) {
                    super(0);
                    this.e = sa2;
                }

                @Override // ir.nasim.SA2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Boolean invoke() {
                    this.e.invoke();
                    return Boolean.TRUE;
                }
            }

            /* renamed from: ir.nasim.Zf4$m$b$b, reason: collision with other inner class name */
            static final class C0805b extends AbstractC8614Ws3 implements SA2 {
                final /* synthetic */ C19818qz6 e;
                final /* synthetic */ InterfaceC20315ro1 f;
                final /* synthetic */ C19818qz6 g;

                /* renamed from: ir.nasim.Zf4$m$b$b$a */
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
                            if (c19818qz6.c(this) == objE) {
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

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0805b(C19818qz6 c19818qz6, InterfaceC20315ro1 interfaceC20315ro1, C19818qz6 c19818qz62) {
                    super(0);
                    this.e = c19818qz6;
                    this.f = interfaceC20315ro1;
                    this.g = c19818qz62;
                }

                @Override // ir.nasim.SA2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Boolean invoke() {
                    if (((Boolean) this.e.d().r().invoke(EnumC20427rz6.Expanded)).booleanValue()) {
                        AbstractC10533bm0.d(this.f, null, null, new a(this.g, null), 3, null);
                    }
                    return Boolean.TRUE;
                }
            }

            /* renamed from: ir.nasim.Zf4$m$b$c */
            static final class c extends AbstractC8614Ws3 implements SA2 {
                final /* synthetic */ C19818qz6 e;
                final /* synthetic */ InterfaceC20315ro1 f;

                /* renamed from: ir.nasim.Zf4$m$b$c$a */
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
                            if (c19818qz6.l(this) == objE) {
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

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                c(C19818qz6 c19818qz6, InterfaceC20315ro1 interfaceC20315ro1) {
                    super(0);
                    this.e = c19818qz6;
                    this.f = interfaceC20315ro1;
                }

                @Override // ir.nasim.SA2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Boolean invoke() {
                    if (((Boolean) this.e.d().r().invoke(EnumC20427rz6.PartiallyExpanded)).booleanValue()) {
                        AbstractC10533bm0.d(this.f, null, null, new a(this.e, null), 3, null);
                    }
                    return Boolean.TRUE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C19818qz6 c19818qz6, String str, String str2, String str3, SA2 sa2, InterfaceC20315ro1 interfaceC20315ro1) {
                super(1);
                this.e = c19818qz6;
                this.f = str;
                this.g = str2;
                this.h = str3;
                this.i = sa2;
                this.j = interfaceC20315ro1;
            }

            public final void a(InterfaceC11943do6 interfaceC11943do6) {
                C19818qz6 c19818qz6 = this.e;
                String str = this.f;
                String str2 = this.g;
                String str3 = this.h;
                SA2 sa2 = this.i;
                InterfaceC20315ro1 interfaceC20315ro1 = this.j;
                AbstractC9939ao6.l(interfaceC11943do6, str, new a(sa2));
                if (c19818qz6.e() == EnumC20427rz6.PartiallyExpanded) {
                    AbstractC9939ao6.o(interfaceC11943do6, str2, new C0805b(c19818qz6, interfaceC20315ro1, c19818qz6));
                } else if (c19818qz6.g()) {
                    AbstractC9939ao6.e(interfaceC11943do6, str3, new c(c19818qz6, interfaceC20315ro1));
                }
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((InterfaceC11943do6) obj);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(InterfaceC14603iB2 interfaceC14603iB2, C15607js c15607js, InterfaceC14603iB2 interfaceC14603iB22, C19818qz6 c19818qz6, SA2 sa2, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC15796kB2 interfaceC15796kB2) {
            super(2);
            this.e = interfaceC14603iB2;
            this.f = c15607js;
            this.g = interfaceC14603iB22;
            this.h = c19818qz6;
            this.i = sa2;
            this.j = interfaceC20315ro1;
            this.k = interfaceC15796kB2;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r5v20 ??, still in use, count: 1, list:
              (r5v20 ?? I:java.lang.Object) from 0x014d: INVOKE (r18v0 ?? I:ir.nasim.ub1), (r5v20 ?? I:java.lang.Object) INTERFACE call: ir.nasim.ub1.s(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:334)
            	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
            	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
            	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
            	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
            	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
            	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
            */
        public final void a(
        /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r5v20 ??, still in use, count: 1, list:
              (r5v20 ?? I:java.lang.Object) from 0x014d: INVOKE (r18v0 ?? I:ir.nasim.ub1), (r5v20 ?? I:java.lang.Object) INTERFACE call: ir.nasim.ub1.s(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:334)
            	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
            	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
            	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
            	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
            	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
            */
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r18v0 ??
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:405)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            */

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Zf4$n */
    static final class n extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC5452Jk0 e;
        final /* synthetic */ C15607js f;
        final /* synthetic */ InterfaceC20315ro1 g;
        final /* synthetic */ SA2 h;
        final /* synthetic */ UA2 i;
        final /* synthetic */ androidx.compose.ui.e j;
        final /* synthetic */ C19818qz6 k;
        final /* synthetic */ float l;
        final /* synthetic */ InterfaceC10031ax6 m;
        final /* synthetic */ long n;
        final /* synthetic */ long o;
        final /* synthetic */ float p;
        final /* synthetic */ InterfaceC14603iB2 q;
        final /* synthetic */ InterfaceC14603iB2 r;
        final /* synthetic */ InterfaceC15796kB2 s;
        final /* synthetic */ int t;
        final /* synthetic */ int u;
        final /* synthetic */ int v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(InterfaceC5452Jk0 interfaceC5452Jk0, C15607js c15607js, InterfaceC20315ro1 interfaceC20315ro1, SA2 sa2, UA2 ua2, androidx.compose.ui.e eVar, C19818qz6 c19818qz6, float f, InterfaceC10031ax6 interfaceC10031ax6, long j, long j2, float f2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC15796kB2 interfaceC15796kB2, int i, int i2, int i3) {
            super(2);
            this.e = interfaceC5452Jk0;
            this.f = c15607js;
            this.g = interfaceC20315ro1;
            this.h = sa2;
            this.i = ua2;
            this.j = eVar;
            this.k = c19818qz6;
            this.l = f;
            this.m = interfaceC10031ax6;
            this.n = j;
            this.o = j2;
            this.p = f2;
            this.q = interfaceC14603iB2;
            this.r = interfaceC14603iB22;
            this.s = interfaceC15796kB2;
            this.t = i;
            this.u = i2;
            this.v = i3;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC9273Zf4.b(this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, interfaceC22053ub1, QJ5.a(this.t | 1), QJ5.a(this.u), this.v);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Zf4$o */
    static final class o extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ long e;
        final /* synthetic */ InterfaceC9664aL6 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o(long j, InterfaceC9664aL6 interfaceC9664aL6) {
            super(1);
            this.e = j;
            this.f = interfaceC9664aL6;
        }

        public final void a(InterfaceC17460n02 interfaceC17460n02) {
            InterfaceC17460n02.C1(interfaceC17460n02, this.e, 0L, 0L, AbstractC23053wG5.l(AbstractC9273Zf4.d(this.f), 0.0f, 1.0f), null, null, 0, SetRpcStruct$ComposedRpc.LOAD_HISTORY_FIELD_NUMBER, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC17460n02) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Zf4$p */
    static final class p extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ long e;
        final /* synthetic */ SA2 f;
        final /* synthetic */ boolean g;
        final /* synthetic */ int h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        p(long j, SA2 sa2, boolean z, int i) {
            super(2);
            this.e = j;
            this.f = sa2;
            this.g = z;
            this.h = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC9273Zf4.c(this.e, this.f, this.g, interfaceC22053ub1, QJ5.a(this.h | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Zf4$q */
    static final class q extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ SA2 d;

        /* renamed from: ir.nasim.Zf4$q$a */
        static final class a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ SA2 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(SA2 sa2) {
                super(1);
                this.e = sa2;
            }

            public final void a(long j) {
                this.e.invoke();
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a(((ZG4) obj).t());
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        q(SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = sa2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            q qVar = new q(this.d, interfaceC20295rm1);
            qVar.c = obj;
            return qVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9049Yg5 interfaceC9049Yg5 = (InterfaceC9049Yg5) this.c;
                a aVar = new a(this.d);
                this.b = 1;
                if (AbstractC20271rj7.k(interfaceC9049Yg5, null, null, null, aVar, this, 7, null) == objE) {
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
        public final Object invoke(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((q) create(interfaceC9049Yg5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Zf4$r */
    static final class r extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ String e;
        final /* synthetic */ SA2 f;

        /* renamed from: ir.nasim.Zf4$r$a */
        static final class a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ SA2 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(SA2 sa2) {
                super(0);
                this.e = sa2;
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke() {
                this.e.invoke();
                return Boolean.TRUE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        r(String str, SA2 sa2) {
            super(1);
            this.e = str;
            this.f = sa2;
        }

        public final void a(InterfaceC11943do6 interfaceC11943do6) {
            AbstractC9939ao6.F0(interfaceC11943do6, 1.0f);
            AbstractC9939ao6.e0(interfaceC11943do6, this.e);
            AbstractC9939ao6.B(interfaceC11943do6, null, new a(this.f), 1, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC11943do6) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Zf4$s */
    static final class s extends AbstractC8614Ws3 implements UA2 {
        public static final s e = new s();

        s() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(EnumC20427rz6 enumC20427rz6) {
            return Boolean.TRUE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0416  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x044c  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0464  */
    /* JADX WARN: Removed duplicated region for block: B:298:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(ir.nasim.SA2 r46, androidx.compose.ui.e r47, ir.nasim.C19818qz6 r48, float r49, ir.nasim.InterfaceC10031ax6 r50, long r51, long r53, float r55, long r56, ir.nasim.InterfaceC14603iB2 r58, ir.nasim.InterfaceC14603iB2 r59, ir.nasim.C9857ag4 r60, ir.nasim.InterfaceC15796kB2 r61, ir.nasim.InterfaceC22053ub1 r62, int r63, int r64, int r65) {
        /*
            Method dump skipped, instructions count: 1157
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC9273Zf4.a(ir.nasim.SA2, androidx.compose.ui.e, ir.nasim.qz6, float, ir.nasim.ax6, long, long, float, long, ir.nasim.iB2, ir.nasim.iB2, ir.nasim.ag4, ir.nasim.kB2, ir.nasim.ub1, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0423  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x048d  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x04a3  */
    /* JADX WARN: Removed duplicated region for block: B:303:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(ir.nasim.InterfaceC5452Jk0 r48, ir.nasim.C15607js r49, ir.nasim.InterfaceC20315ro1 r50, ir.nasim.SA2 r51, ir.nasim.UA2 r52, androidx.compose.ui.e r53, ir.nasim.C19818qz6 r54, float r55, ir.nasim.InterfaceC10031ax6 r56, long r57, long r59, float r61, ir.nasim.InterfaceC14603iB2 r62, ir.nasim.InterfaceC14603iB2 r63, ir.nasim.InterfaceC15796kB2 r64, ir.nasim.InterfaceC22053ub1 r65, int r66, int r67, int r68) {
        /*
            Method dump skipped, instructions count: 1226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC9273Zf4.b(ir.nasim.Jk0, ir.nasim.js, ir.nasim.ro1, ir.nasim.SA2, ir.nasim.UA2, androidx.compose.ui.e, ir.nasim.qz6, float, ir.nasim.ax6, long, long, float, ir.nasim.iB2, ir.nasim.iB2, ir.nasim.kB2, ir.nasim.ub1, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(long j2, SA2 sa2, boolean z, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        int i3;
        androidx.compose.ui.e eVarC;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(951870469);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.f(j2) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.D(sa2) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= interfaceC22053ub1J.a(z) ? 256 : 128;
        }
        int i4 = i3;
        if ((i4 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(951870469, i4, -1, "androidx.compose.material3.Scrim (ModalBottomSheet.kt:407)");
            }
            if (j2 != 16) {
                InterfaceC9664aL6 interfaceC9664aL6D = AbstractC4572Fs.d(z ? 1.0f : 0.0f, new C7479Rw7(0, 0, null, 7, null), 0.0f, null, null, interfaceC22053ub1J, 48, 28);
                AbstractC12407eZ6.a aVar = AbstractC12407eZ6.a;
                String strA = AbstractC22629vZ6.a(AbstractC12407eZ6.a(AbstractC9600aE5.close_sheet), interfaceC22053ub1J, 0);
                interfaceC22053ub1J.W(-1785653838);
                if (z) {
                    e.a aVar2 = androidx.compose.ui.e.a;
                    int i5 = i4 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER;
                    boolean z2 = i5 == 32;
                    Object objB = interfaceC22053ub1J.B();
                    if (z2 || objB == InterfaceC22053ub1.a.a()) {
                        objB = new q(sa2, null);
                        interfaceC22053ub1J.s(objB);
                    }
                    androidx.compose.ui.e eVarI = aVar2.i(new SuspendPointerInputElement(sa2, null, null, new AbstractC21071t37.a((InterfaceC14603iB2) objB), 6, null));
                    boolean zV = interfaceC22053ub1J.V(strA) | (i5 == 32);
                    Object objB2 = interfaceC22053ub1J.B();
                    if (zV || objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new r(strA, sa2);
                        interfaceC22053ub1J.s(objB2);
                    }
                    eVarC = AbstractC6919Pn6.c(eVarI, true, (UA2) objB2);
                } else {
                    eVarC = androidx.compose.ui.e.a;
                }
                interfaceC22053ub1J.Q();
                androidx.compose.ui.e eVarI2 = androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null).i(eVarC);
                boolean zV2 = interfaceC22053ub1J.V(interfaceC9664aL6D) | ((i4 & 14) == 4);
                Object objB3 = interfaceC22053ub1J.B();
                if (zV2 || objB3 == InterfaceC22053ub1.a.a()) {
                    objB3 = new o(j2, interfaceC9664aL6D);
                    interfaceC22053ub1J.s(objB3);
                }
                AbstractC22443vF0.a(eVarI2, (UA2) objB3, interfaceC22053ub1J, 0);
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new p(j2, sa2, z, i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float d(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Number) interfaceC9664aL6.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float j(androidx.compose.ui.graphics.c cVar, float f2) {
        float fI = OD6.i(cVar.d());
        if (Float.isNaN(fI) || fI == 0.0f) {
            return 1.0f;
        }
        return 1.0f - (AbstractC18932pV3.b(0.0f, Math.min(cVar.w1(a), fI), f2) / fI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float k(androidx.compose.ui.graphics.c cVar, float f2) {
        float fG = OD6.g(cVar.d());
        if (Float.isNaN(fG) || fG == 0.0f) {
            return 1.0f;
        }
        return 1.0f - (AbstractC18932pV3.b(0.0f, Math.min(cVar.w1(b), fG), f2) / fG);
    }

    public static final C19818qz6 l(boolean z, UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, int i2, int i3) {
        if ((i3 & 1) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i3 & 2) != 0) {
            ua2 = s.e;
        }
        UA2 ua22 = ua2;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-778250030, i2, -1, "androidx.compose.material3.rememberModalBottomSheetState (ModalBottomSheet.kt:400)");
        }
        C19818qz6 c19818qz6D = AbstractC19227pz6.d(z2, ua22, EnumC20427rz6.Hidden, false, interfaceC22053ub1, (i2 & 14) | 384 | (i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER), 8);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return c19818qz6D;
    }
}
