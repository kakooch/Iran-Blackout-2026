package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.view.KeyEvent;
import androidx.compose.runtime.snapshots.g;
import androidx.compose.ui.e;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import ir.nasim.AbstractC21430te5;
import ir.nasim.InterfaceC16030kb1;
import java.util.List;

/* renamed from: ir.nasim.Tn1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC7865Tn1 {

    /* renamed from: ir.nasim.Tn1$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C6542Ny3 c;
        final /* synthetic */ InterfaceC9664aL6 d;
        final /* synthetic */ C7155Qm7 e;
        final /* synthetic */ C19101pm7 f;
        final /* synthetic */ T33 g;

        /* renamed from: ir.nasim.Tn1$b$a */
        static final class a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ InterfaceC9664aL6 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC9664aL6 interfaceC9664aL6) {
                super(0);
                this.e = interfaceC9664aL6;
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke() {
                return Boolean.valueOf(AbstractC7865Tn1.b(this.e));
            }
        }

        /* renamed from: ir.nasim.Tn1$b$b, reason: collision with other inner class name */
        static final class C0668b implements InterfaceC4806Gq2 {
            final /* synthetic */ C6542Ny3 a;
            final /* synthetic */ C7155Qm7 b;
            final /* synthetic */ C19101pm7 c;
            final /* synthetic */ T33 d;

            C0668b(C6542Ny3 c6542Ny3, C7155Qm7 c7155Qm7, C19101pm7 c19101pm7, T33 t33) {
                this.a = c6542Ny3;
                this.b = c7155Qm7;
                this.c = c19101pm7;
                this.d = t33;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            public /* bridge */ /* synthetic */ Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return b(((Boolean) obj).booleanValue(), interfaceC20295rm1);
            }

            public final Object b(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                if (z && this.a.f()) {
                    AbstractC7865Tn1.p(this.b, this.a, this.c.U(), this.d, this.c.N());
                } else {
                    AbstractC7865Tn1.m(this.a);
                }
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C6542Ny3 c6542Ny3, InterfaceC9664aL6 interfaceC9664aL6, C7155Qm7 c7155Qm7, C19101pm7 c19101pm7, T33 t33, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c6542Ny3;
            this.d = interfaceC9664aL6;
            this.e = c7155Qm7;
            this.f = c19101pm7;
            this.g = t33;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            try {
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4557Fq2 interfaceC4557Fq2R = AbstractC10222bH6.r(new a(this.d));
                    C0668b c0668b = new C0668b(this.c, this.e, this.f, this.g);
                    this.b = 1;
                    if (interfaceC4557Fq2R.b(c0668b, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                AbstractC7865Tn1.m(this.c);
                return C19938rB7.a;
            } catch (Throwable th) {
                AbstractC7865Tn1.m(this.c);
                throw th;
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Tn1$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C19101pm7 e;

        /* renamed from: ir.nasim.Tn1$c$a */
        public static final class a implements KV1 {
            final /* synthetic */ C19101pm7 a;

            public a(C19101pm7 c19101pm7) {
                this.a = c19101pm7;
            }

            @Override // ir.nasim.KV1
            public void dispose() {
                this.a.X();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C19101pm7 c19101pm7) {
            super(1);
            this.e = c19101pm7;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final KV1 invoke(LV1 lv1) {
            return new a(this.e);
        }
    }

    /* renamed from: ir.nasim.Tn1$f */
    static final class f extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ C23945xm7 e;
        final /* synthetic */ UA2 f;
        final /* synthetic */ androidx.compose.ui.e g;
        final /* synthetic */ C9348Zn7 h;
        final /* synthetic */ QY7 i;
        final /* synthetic */ UA2 j;
        final /* synthetic */ InterfaceC18507om4 k;
        final /* synthetic */ AbstractC12520el0 l;
        final /* synthetic */ boolean m;
        final /* synthetic */ int n;
        final /* synthetic */ int o;
        final /* synthetic */ T33 p;
        final /* synthetic */ C11329cp3 q;
        final /* synthetic */ boolean r;
        final /* synthetic */ boolean s;
        final /* synthetic */ InterfaceC15796kB2 t;
        final /* synthetic */ C18510om7 u;
        final /* synthetic */ int v;
        final /* synthetic */ int w;
        final /* synthetic */ int x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(C23945xm7 c23945xm7, UA2 ua2, androidx.compose.ui.e eVar, C9348Zn7 c9348Zn7, QY7 qy7, UA2 ua22, InterfaceC18507om4 interfaceC18507om4, AbstractC12520el0 abstractC12520el0, boolean z, int i, int i2, T33 t33, C11329cp3 c11329cp3, boolean z2, boolean z3, InterfaceC15796kB2 interfaceC15796kB2, C18510om7 c18510om7, int i3, int i4, int i5) {
            super(2);
            this.e = c23945xm7;
            this.f = ua2;
            this.g = eVar;
            this.h = c9348Zn7;
            this.i = qy7;
            this.j = ua22;
            this.k = interfaceC18507om4;
            this.l = abstractC12520el0;
            this.m = z;
            this.n = i;
            this.o = i2;
            this.p = t33;
            this.q = c11329cp3;
            this.r = z2;
            this.s = z3;
            this.t = interfaceC15796kB2;
            this.u = c18510om7;
            this.v = i3;
            this.w = i4;
            this.x = i5;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC7865Tn1.a(this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, interfaceC22053ub1, QJ5.a(this.v | 1), QJ5.a(this.w), this.x);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Tn1$g */
    static final class g extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C6542Ny3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(C6542Ny3 c6542Ny3) {
            super(1);
            this.e = c6542Ny3;
        }

        public final void a(InterfaceC11379cu3 interfaceC11379cu3) {
            C14367hn7 c14367hn7L = this.e.l();
            if (c14367hn7L == null) {
                return;
            }
            c14367hn7L.h(interfaceC11379cu3);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC11379cu3) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Tn1$h */
    static final class h extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C6542Ny3 e;
        final /* synthetic */ long f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(C6542Ny3 c6542Ny3, long j) {
            super(1);
            this.e = c6542Ny3;
            this.f = j;
        }

        public final void a(InterfaceC17460n02 interfaceC17460n02) {
            if (this.e.c() || this.e.i()) {
                InterfaceC17460n02.C1(interfaceC17460n02, this.f, 0L, 0L, 0.0f, null, null, 0, 126, null);
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC17460n02) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Tn1$i */
    static final class i extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C6542Ny3 e;
        final /* synthetic */ C23945xm7 f;
        final /* synthetic */ InterfaceC11600dH4 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(C6542Ny3 c6542Ny3, C23945xm7 c23945xm7, InterfaceC11600dH4 interfaceC11600dH4) {
            super(1);
            this.e = c6542Ny3;
            this.f = c23945xm7;
            this.g = interfaceC11600dH4;
        }

        public final void a(InterfaceC17460n02 interfaceC17460n02) {
            C14367hn7 c14367hn7L = this.e.l();
            if (c14367hn7L != null) {
                C23945xm7 c23945xm7 = this.f;
                C6542Ny3 c6542Ny3 = this.e;
                InterfaceC11600dH4 interfaceC11600dH4 = this.g;
                AbstractC9096Yl7.a.b(interfaceC17460n02.z1().e(), c23945xm7, c6542Ny3.s(), c6542Ny3.d(), interfaceC11600dH4, c14367hn7L.f(), c6542Ny3.g(), c6542Ny3.r());
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC17460n02) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Tn1$j */
    static final class j extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C6542Ny3 e;
        final /* synthetic */ boolean f;
        final /* synthetic */ boolean g;
        final /* synthetic */ C7155Qm7 h;
        final /* synthetic */ C23945xm7 i;
        final /* synthetic */ T33 j;
        final /* synthetic */ InterfaceC11600dH4 k;
        final /* synthetic */ C19101pm7 l;
        final /* synthetic */ InterfaceC20315ro1 m;
        final /* synthetic */ InterfaceC7598Sk0 n;

        /* renamed from: ir.nasim.Tn1$j$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceC7598Sk0 c;
            final /* synthetic */ C23945xm7 d;
            final /* synthetic */ C6542Ny3 e;
            final /* synthetic */ C14367hn7 f;
            final /* synthetic */ InterfaceC11600dH4 g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC7598Sk0 interfaceC7598Sk0, C23945xm7 c23945xm7, C6542Ny3 c6542Ny3, C14367hn7 c14367hn7, InterfaceC11600dH4 interfaceC11600dH4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceC7598Sk0;
                this.d = c23945xm7;
                this.e = c6542Ny3;
                this.f = c14367hn7;
                this.g = interfaceC11600dH4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, this.e, this.f, this.g, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC7598Sk0 interfaceC7598Sk0 = this.c;
                    C23945xm7 c23945xm7 = this.d;
                    C3342Al7 c3342Al7X = this.e.x();
                    C13774gn7 c13774gn7F = this.f.f();
                    InterfaceC11600dH4 interfaceC11600dH4 = this.g;
                    this.b = 1;
                    if (AbstractC7865Tn1.l(interfaceC7598Sk0, c23945xm7, c3342Al7X, c13774gn7F, interfaceC11600dH4, this) == objE) {
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
        j(C6542Ny3 c6542Ny3, boolean z, boolean z2, C7155Qm7 c7155Qm7, C23945xm7 c23945xm7, T33 t33, InterfaceC11600dH4 interfaceC11600dH4, C19101pm7 c19101pm7, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC7598Sk0 interfaceC7598Sk0) {
            super(1);
            this.e = c6542Ny3;
            this.f = z;
            this.g = z2;
            this.h = c7155Qm7;
            this.i = c23945xm7;
            this.j = t33;
            this.k = interfaceC11600dH4;
            this.l = c19101pm7;
            this.m = interfaceC20315ro1;
            this.n = interfaceC7598Sk0;
        }

        public final void a(InterfaceC5517Jr2 interfaceC5517Jr2) {
            C14367hn7 c14367hn7L;
            if (this.e.f() == interfaceC5517Jr2.a()) {
                return;
            }
            this.e.F(interfaceC5517Jr2.a());
            if (this.e.f() && this.f && !this.g) {
                AbstractC7865Tn1.p(this.h, this.e, this.i, this.j, this.k);
            } else {
                AbstractC7865Tn1.m(this.e);
            }
            if (interfaceC5517Jr2.a() && (c14367hn7L = this.e.l()) != null) {
                AbstractC10533bm0.d(this.m, null, null, new a(this.n, this.i, this.e, c14367hn7L, this.k, null), 3, null);
            }
            if (interfaceC5517Jr2.a()) {
                return;
            }
            C19101pm7.w(this.l, null, 1, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC5517Jr2) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Tn1$k */
    static final class k extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C6542Ny3 e;
        final /* synthetic */ boolean f;
        final /* synthetic */ InterfaceC19920r98 g;
        final /* synthetic */ C19101pm7 h;
        final /* synthetic */ C23945xm7 i;
        final /* synthetic */ InterfaceC11600dH4 j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(C6542Ny3 c6542Ny3, boolean z, InterfaceC19920r98 interfaceC19920r98, C19101pm7 c19101pm7, C23945xm7 c23945xm7, InterfaceC11600dH4 interfaceC11600dH4) {
            super(1);
            this.e = c6542Ny3;
            this.f = z;
            this.g = interfaceC19920r98;
            this.h = c19101pm7;
            this.i = c23945xm7;
            this.j = interfaceC11600dH4;
        }

        public final void a(InterfaceC11379cu3 interfaceC11379cu3) {
            this.e.J(interfaceC11379cu3);
            C14367hn7 c14367hn7L = this.e.l();
            if (c14367hn7L != null) {
                c14367hn7L.i(interfaceC11379cu3);
            }
            if (this.f) {
                if (this.e.e() == EnumC17140mT2.b) {
                    if (this.e.u() && this.g.a()) {
                        this.h.t0();
                    } else {
                        this.h.X();
                    }
                    this.e.Q(AbstractC19692qm7.c(this.h, true));
                    this.e.P(AbstractC19692qm7.c(this.h, false));
                    this.e.N(C4301En7.h(this.i.g()));
                } else if (this.e.e() == EnumC17140mT2.c) {
                    this.e.N(AbstractC19692qm7.c(this.h, true));
                }
                AbstractC7865Tn1.n(this.e, this.i, this.j);
                C14367hn7 c14367hn7L2 = this.e.l();
                if (c14367hn7L2 != null) {
                    C6542Ny3 c6542Ny3 = this.e;
                    C23945xm7 c23945xm7 = this.i;
                    InterfaceC11600dH4 interfaceC11600dH4 = this.j;
                    C8564Wm7 c8564Wm7H = c6542Ny3.h();
                    if (c8564Wm7H == null || !c6542Ny3.f()) {
                        return;
                    }
                    AbstractC9096Yl7.a.k(c8564Wm7H, c23945xm7, interfaceC11600dH4, c14367hn7L2);
                }
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC11379cu3) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Tn1$l */
    static final class l extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C6542Ny3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(C6542Ny3 c6542Ny3) {
            super(1);
            this.e = c6542Ny3;
        }

        public final void a(boolean z) {
            this.e.G(z);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Boolean) obj).booleanValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Tn1$m */
    static final class m extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C6542Ny3 e;
        final /* synthetic */ androidx.compose.ui.focus.m f;
        final /* synthetic */ boolean g;
        final /* synthetic */ boolean h;
        final /* synthetic */ C19101pm7 i;
        final /* synthetic */ InterfaceC11600dH4 j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(C6542Ny3 c6542Ny3, androidx.compose.ui.focus.m mVar, boolean z, boolean z2, C19101pm7 c19101pm7, InterfaceC11600dH4 interfaceC11600dH4) {
            super(1);
            this.e = c6542Ny3;
            this.f = mVar;
            this.g = z;
            this.h = z2;
            this.i = c19101pm7;
            this.j = interfaceC11600dH4;
        }

        public final void a(long j) {
            AbstractC7865Tn1.q(this.e, this.f, !this.g);
            if (this.e.f() && this.h) {
                if (this.e.e() == EnumC17140mT2.b) {
                    this.i.v(ZG4.d(j));
                    return;
                }
                C14367hn7 c14367hn7L = this.e.l();
                if (c14367hn7L != null) {
                    C6542Ny3 c6542Ny3 = this.e;
                    AbstractC9096Yl7.a.j(j, c14367hn7L, c6542Ny3.p(), this.j, c6542Ny3.o());
                    if (c6542Ny3.x().k().length() > 0) {
                        c6542Ny3.E(EnumC17140mT2.c);
                    }
                }
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((ZG4) obj).t());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Tn1$n */
    static final class n extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ EnumC24286yM4 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(EnumC24286yM4 enumC24286yM4) {
            super(0);
            this.e = enumC24286yM4;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C18510om7 invoke() {
            return new C18510om7(this.e, 0.0f, 2, null);
        }
    }

    /* renamed from: ir.nasim.Tn1$o */
    static final class o extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ boolean e;
        final /* synthetic */ AbstractC5581Jy3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o(boolean z, AbstractC5581Jy3 abstractC5581Jy3) {
            super(0);
            this.e = z;
            this.f = abstractC5581Jy3;
        }

        public final void a() {
            if (this.e) {
                this.f.k();
            }
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Tn1$p */
    static final class p extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e e;
        final /* synthetic */ C19101pm7 f;
        final /* synthetic */ InterfaceC14603iB2 g;
        final /* synthetic */ int h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        p(androidx.compose.ui.e eVar, C19101pm7 c19101pm7, InterfaceC14603iB2 interfaceC14603iB2, int i) {
            super(2);
            this.e = eVar;
            this.f = c19101pm7;
            this.g = interfaceC14603iB2;
            this.h = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC7865Tn1.c(this.e, this.f, this.g, interfaceC22053ub1, QJ5.a(this.h | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Tn1$q */
    static final class q extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ C19101pm7 e;
        final /* synthetic */ boolean f;
        final /* synthetic */ int g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        q(C19101pm7 c19101pm7, boolean z, int i) {
            super(2);
            this.e = c19101pm7;
            this.f = z;
            this.g = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC7865Tn1.d(this.e, this.f, interfaceC22053ub1, QJ5.a(this.g | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Tn1$r */
    static final class r implements InterfaceC12243eH4 {
        final /* synthetic */ long a;

        r(long j) {
            this.a = j;
        }

        @Override // ir.nasim.InterfaceC12243eH4
        public final long a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.Tn1$s */
    static final class s implements PointerInputEventHandler {
        final /* synthetic */ InterfaceC4766Gl7 a;
        final /* synthetic */ C19101pm7 b;

        /* renamed from: ir.nasim.Tn1$s$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ InterfaceC9049Yg5 d;
            final /* synthetic */ InterfaceC4766Gl7 e;
            final /* synthetic */ C19101pm7 f;

            /* renamed from: ir.nasim.Tn1$s$a$a, reason: collision with other inner class name */
            static final class C0672a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ InterfaceC9049Yg5 c;
                final /* synthetic */ InterfaceC4766Gl7 d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0672a(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC4766Gl7 interfaceC4766Gl7, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = interfaceC9049Yg5;
                    this.d = interfaceC4766Gl7;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C0672a(this.c, this.d, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC9049Yg5 interfaceC9049Yg5 = this.c;
                        InterfaceC4766Gl7 interfaceC4766Gl7 = this.d;
                        this.b = 1;
                        if (AbstractC15869kJ3.c(interfaceC9049Yg5, interfaceC4766Gl7, this) == objE) {
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
                    return ((C0672a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.Tn1$s$a$b */
            static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ InterfaceC9049Yg5 c;
                final /* synthetic */ C19101pm7 d;

                /* renamed from: ir.nasim.Tn1$s$a$b$a, reason: collision with other inner class name */
                static final class C0673a extends AbstractC8614Ws3 implements UA2 {
                    final /* synthetic */ C19101pm7 e;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C0673a(C19101pm7 c19101pm7) {
                        super(1);
                        this.e = c19101pm7;
                    }

                    public final void a(long j) {
                        this.e.t0();
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        a(((ZG4) obj).t());
                        return C19938rB7.a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                b(InterfaceC9049Yg5 interfaceC9049Yg5, C19101pm7 c19101pm7, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = interfaceC9049Yg5;
                    this.d = c19101pm7;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new b(this.c, this.d, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC9049Yg5 interfaceC9049Yg5 = this.c;
                        C0673a c0673a = new C0673a(this.d);
                        this.b = 1;
                        if (AbstractC20271rj7.k(interfaceC9049Yg5, null, null, null, c0673a, this, 7, null) == objE) {
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
                    return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC4766Gl7 interfaceC4766Gl7, C19101pm7 c19101pm7, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC9049Yg5;
                this.e = interfaceC4766Gl7;
                this.f = c19101pm7;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, this.f, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                EnumC23959xo1 enumC23959xo1 = EnumC23959xo1.UNDISPATCHED;
                AbstractC10533bm0.d(interfaceC20315ro1, null, enumC23959xo1, new C0672a(this.d, this.e, null), 1, null);
                AbstractC10533bm0.d(interfaceC20315ro1, null, enumC23959xo1, new b(this.d, this.f, null), 1, null);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        s(InterfaceC4766Gl7 interfaceC4766Gl7, C19101pm7 c19101pm7) {
            this.a = interfaceC4766Gl7;
            this.b = c19101pm7;
        }

        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
        public final Object invoke(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objE = AbstractC20906so1.e(new a(interfaceC9049Yg5, this.a, this.b, null), interfaceC20295rm1);
            return objE == AbstractC14862ic3.e() ? objE : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Tn1$t */
    static final class t extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ long e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        t(long j) {
            super(1);
            this.e = j;
        }

        public final void a(InterfaceC11943do6 interfaceC11943do6) {
            interfaceC11943do6.f(AbstractC3832Cn6.d(), new C3598Bn6(EnumC10942cT2.a, this.e, EnumC3359An6.b, true, null));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC11943do6) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Tn1$u */
    static final class u extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ C19101pm7 e;
        final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        u(C19101pm7 c19101pm7, int i) {
            super(2);
            this.e = c19101pm7;
            this.f = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC7865Tn1.e(this.e, interfaceC22053ub1, QJ5.a(this.f | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Tn1$v */
    static final class v extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C6542Ny3 e;
        final /* synthetic */ C19101pm7 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        v(C6542Ny3 c6542Ny3, C19101pm7 c19101pm7) {
            super(1);
            this.e = c6542Ny3;
            this.f = c19101pm7;
        }

        public final Boolean a(KeyEvent keyEvent) {
            boolean z;
            if (this.e.e() == EnumC17140mT2.b && AbstractC22185uo3.a(keyEvent)) {
                z = true;
                C19101pm7.w(this.f, null, 1, null);
            } else {
                z = false;
            }
            return Boolean.valueOf(z);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((C20908so3) obj).f());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0502  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0529  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x053e  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x0554  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x05b7  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x05b9  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x05c7  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x05c9  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x05d3  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x05d5  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x05e1  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x05ef  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x05fb A[PHI: r3 r38 r42
      0x05fb: PHI (r3v27 ir.nasim.T33) = (r3v18 ir.nasim.T33), (r3v28 ir.nasim.T33) binds: [B:345:0x05f9, B:342:0x05ea] A[DONT_GENERATE, DONT_INLINE]
      0x05fb: PHI (r38v7 int) = (r38v4 int), (r38v9 int) binds: [B:345:0x05f9, B:342:0x05ea] A[DONT_GENERATE, DONT_INLINE]
      0x05fb: PHI (r42v3 int) = (r42v1 int), (r42v4 int) binds: [B:345:0x05f9, B:342:0x05ea] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:347:0x05fd  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x0619  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x061f  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x064b  */
    /* JADX WARN: Removed duplicated region for block: B:364:0x067d  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x0685  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x068e  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x0694  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x06c1  */
    /* JADX WARN: Removed duplicated region for block: B:380:0x06db  */
    /* JADX WARN: Removed duplicated region for block: B:381:0x06dd  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x06e6  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x06e8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x0700  */
    /* JADX WARN: Removed duplicated region for block: B:393:0x0740  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x0742  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x0759  */
    /* JADX WARN: Removed duplicated region for block: B:404:0x0771  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x0773  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x0784  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x0786  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x0799  */
    /* JADX WARN: Removed duplicated region for block: B:423:0x07e8  */
    /* JADX WARN: Removed duplicated region for block: B:428:0x080b  */
    /* JADX WARN: Removed duplicated region for block: B:431:0x0826  */
    /* JADX WARN: Removed duplicated region for block: B:432:0x0828  */
    /* JADX WARN: Removed duplicated region for block: B:443:0x0844  */
    /* JADX WARN: Removed duplicated region for block: B:445:0x084a  */
    /* JADX WARN: Removed duplicated region for block: B:448:0x0866  */
    /* JADX WARN: Removed duplicated region for block: B:449:0x0869  */
    /* JADX WARN: Removed duplicated region for block: B:455:0x08a7  */
    /* JADX WARN: Removed duplicated region for block: B:460:0x08c8  */
    /* JADX WARN: Removed duplicated region for block: B:465:0x08fc  */
    /* JADX WARN: Removed duplicated region for block: B:475:0x095c  */
    /* JADX WARN: Removed duplicated region for block: B:477:0x0960  */
    /* JADX WARN: Removed duplicated region for block: B:478:0x0967  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:481:0x09c7  */
    /* JADX WARN: Removed duplicated region for block: B:483:0x09e9  */
    /* JADX WARN: Removed duplicated region for block: B:486:0x0a11  */
    /* JADX WARN: Removed duplicated region for block: B:488:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0120  */
    /* JADX WARN: Type inference failed for: r0v32, types: [androidx.compose.ui.e] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(ir.nasim.C23945xm7 r52, ir.nasim.UA2 r53, androidx.compose.ui.e r54, ir.nasim.C9348Zn7 r55, ir.nasim.QY7 r56, ir.nasim.UA2 r57, ir.nasim.InterfaceC18507om4 r58, ir.nasim.AbstractC12520el0 r59, boolean r60, int r61, int r62, ir.nasim.T33 r63, ir.nasim.C11329cp3 r64, boolean r65, boolean r66, ir.nasim.InterfaceC15796kB2 r67, ir.nasim.C18510om7 r68, ir.nasim.InterfaceC22053ub1 r69, int r70, int r71, int r72) {
        /*
            Method dump skipped, instructions count: 2605
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC7865Tn1.a(ir.nasim.xm7, ir.nasim.UA2, androidx.compose.ui.e, ir.nasim.Zn7, ir.nasim.QY7, ir.nasim.UA2, ir.nasim.om4, ir.nasim.el0, boolean, int, int, ir.nasim.T33, ir.nasim.cp3, boolean, boolean, ir.nasim.kB2, ir.nasim.om7, ir.nasim.ub1, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(androidx.compose.ui.e eVar, C19101pm7 c19101pm7, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-20551815);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(eVar) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.D(c19101pm7) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= interfaceC22053ub1J.D(interfaceC14603iB2) ? 256 : 128;
        }
        if (interfaceC22053ub1J.o((i3 & 147) != 146, i3 & 1)) {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-20551815, i3, -1, "androidx.compose.foundation.text.CoreTextFieldRootBox (CoreTextField.kt:668)");
            }
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.o(), true);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVar);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            int i4 = i3 >> 3;
            AbstractC14351hm1.a(c19101pm7, interfaceC14603iB2, interfaceC22053ub1J, (i4 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i4 & 14));
            interfaceC22053ub1J.u();
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        } else {
            interfaceC22053ub1J.L();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new p(eVar, c19101pm7, interfaceC14603iB2, i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(C19101pm7 c19101pm7, boolean z, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        int i3;
        C14367hn7 c14367hn7L;
        C13774gn7 c13774gn7F;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(626339208);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.D(c19101pm7) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.a(z) ? 32 : 16;
        }
        if (interfaceC22053ub1J.o((i3 & 19) != 18, i3 & 1)) {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(626339208, i3, -1, "androidx.compose.foundation.text.SelectionToolbarAndHandles (CoreTextField.kt:1018)");
            }
            if (z) {
                interfaceC22053ub1J.W(-1290924834);
                C6542Ny3 c6542Ny3P = c19101pm7.P();
                C13774gn7 c13774gn7 = null;
                if (c6542Ny3P != null && (c14367hn7L = c6542Ny3P.l()) != null && (c13774gn7F = c14367hn7L.f()) != null) {
                    if (!(c19101pm7.P() != null ? r4.B() : true)) {
                        c13774gn7 = c13774gn7F;
                    }
                }
                if (c13774gn7 == null) {
                    interfaceC22053ub1J.W(-1290601288);
                } else {
                    interfaceC22053ub1J.W(-1290601287);
                    if (C4301En7.h(c19101pm7.U().g())) {
                        interfaceC22053ub1J.W(-1684179174);
                        interfaceC22053ub1J.Q();
                    } else {
                        interfaceC22053ub1J.W(-1685230508);
                        int iB = c19101pm7.N().b(C4301En7.n(c19101pm7.U().g()));
                        int iB2 = c19101pm7.N().b(C4301En7.i(c19101pm7.U().g()));
                        AW5 aw5C = c13774gn7.c(iB);
                        AW5 aw5C2 = c13774gn7.c(Math.max(iB2 - 1, 0));
                        C6542Ny3 c6542Ny3P2 = c19101pm7.P();
                        if (c6542Ny3P2 == null || !c6542Ny3P2.w()) {
                            interfaceC22053ub1J.W(-1684548198);
                            interfaceC22053ub1J.Q();
                        } else {
                            interfaceC22053ub1J.W(-1684812473);
                            AbstractC19692qm7.a(true, aw5C, c19101pm7, interfaceC22053ub1J, ((i3 << 6) & 896) | 6);
                            interfaceC22053ub1J.Q();
                        }
                        C6542Ny3 c6542Ny3P3 = c19101pm7.P();
                        if (c6542Ny3P3 == null || !c6542Ny3P3.v()) {
                            interfaceC22053ub1J.W(-1684200998);
                            interfaceC22053ub1J.Q();
                        } else {
                            interfaceC22053ub1J.W(-1684464312);
                            AbstractC19692qm7.a(false, aw5C2, c19101pm7, interfaceC22053ub1J, ((i3 << 6) & 896) | 6);
                            interfaceC22053ub1J.Q();
                        }
                        interfaceC22053ub1J.Q();
                    }
                    C6542Ny3 c6542Ny3P4 = c19101pm7.P();
                    if (c6542Ny3P4 != null) {
                        if (c19101pm7.Y()) {
                            c6542Ny3P4.O(false);
                        }
                        if (c6542Ny3P4.f()) {
                            if (c6542Ny3P4.u()) {
                                c19101pm7.t0();
                            } else {
                                c19101pm7.X();
                            }
                        }
                        C19938rB7 c19938rB7 = C19938rB7.a;
                    }
                }
                interfaceC22053ub1J.Q();
                interfaceC22053ub1J.Q();
            } else {
                interfaceC22053ub1J.W(651160447);
                interfaceC22053ub1J.Q();
                c19101pm7.X();
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        } else {
            interfaceC22053ub1J.L();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new q(c19101pm7, z, i2));
        }
    }

    public static final void e(C19101pm7 c19101pm7, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        int i3;
        C13245fu c13245fuS;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1436003720);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.D(c19101pm7) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if (interfaceC22053ub1J.o((i3 & 3) != 2, i3 & 1)) {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1436003720, i3, -1, "androidx.compose.foundation.text.TextFieldCursorHandle (CoreTextField.kt:1065)");
            }
            C6542Ny3 c6542Ny3P = c19101pm7.P();
            if (c6542Ny3P == null || !c6542Ny3P.t() || (c13245fuS = c19101pm7.S()) == null || c13245fuS.length() <= 0) {
                interfaceC22053ub1J.W(-288632802);
                interfaceC22053ub1J.Q();
            } else {
                interfaceC22053ub1J.W(-289940723);
                boolean zV = interfaceC22053ub1J.V(c19101pm7);
                Object objB = interfaceC22053ub1J.B();
                if (zV || objB == InterfaceC22053ub1.a.a()) {
                    objB = c19101pm7.t();
                    interfaceC22053ub1J.s(objB);
                }
                InterfaceC4766Gl7 interfaceC4766Gl7 = (InterfaceC4766Gl7) objB;
                long jE = c19101pm7.E((WH1) interfaceC22053ub1J.H(AbstractC13040fc1.g()));
                boolean zF = interfaceC22053ub1J.f(jE);
                Object objB2 = interfaceC22053ub1J.B();
                if (zF || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new r(jE);
                    interfaceC22053ub1J.s(objB2);
                }
                InterfaceC12243eH4 interfaceC12243eH4 = (InterfaceC12243eH4) objB2;
                e.a aVar = androidx.compose.ui.e.a;
                boolean zD = interfaceC22053ub1J.D(interfaceC4766Gl7) | interfaceC22053ub1J.D(c19101pm7);
                Object objB3 = interfaceC22053ub1J.B();
                if (zD || objB3 == InterfaceC22053ub1.a.a()) {
                    objB3 = new s(interfaceC4766Gl7, c19101pm7);
                    interfaceC22053ub1J.s(objB3);
                }
                androidx.compose.ui.e eVarC = AbstractC21071t37.c(aVar, interfaceC4766Gl7, (PointerInputEventHandler) objB3);
                boolean zF2 = interfaceC22053ub1J.f(jE);
                Object objB4 = interfaceC22053ub1J.B();
                if (zF2 || objB4 == InterfaceC22053ub1.a.a()) {
                    objB4 = new t(jE);
                    interfaceC22053ub1J.s(objB4);
                }
                AbstractC6188Mo.a(interfaceC12243eH4, AbstractC6919Pn6.d(eVarC, false, (UA2) objB4, 1, null), 0L, interfaceC22053ub1J, 0, 4);
                interfaceC22053ub1J.Q();
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        } else {
            interfaceC22053ub1J.L();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new u(c19101pm7, i2));
        }
    }

    public static final Object l(InterfaceC7598Sk0 interfaceC7598Sk0, C23945xm7 c23945xm7, C3342Al7 c3342Al7, C13774gn7 c13774gn7, InterfaceC11600dH4 interfaceC11600dH4, InterfaceC20295rm1 interfaceC20295rm1) {
        int iB = interfaceC11600dH4.b(C4301En7.k(c23945xm7.g()));
        Object objA = interfaceC7598Sk0.a(iB < c13774gn7.l().j().length() ? c13774gn7.d(iB) : iB != 0 ? c13774gn7.d(iB - 1) : new CK5(0.0f, 0.0f, 1.0f, (int) (AbstractC9330Zl7.b(c3342Al7.j(), c3342Al7.a(), c3342Al7.b(), null, 0, 24, null) & 4294967295L)), interfaceC20295rm1);
        return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(C6542Ny3 c6542Ny3) {
        C8564Wm7 c8564Wm7H = c6542Ny3.h();
        if (c8564Wm7H != null) {
            AbstractC9096Yl7.a.f(c8564Wm7H, c6542Ny3.p(), c6542Ny3.o());
        }
        c6542Ny3.H(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(C6542Ny3 c6542Ny3, C23945xm7 c23945xm7, InterfaceC11600dH4 interfaceC11600dH4) {
        g.a aVar = androidx.compose.runtime.snapshots.g.e;
        androidx.compose.runtime.snapshots.g gVarD = aVar.d();
        UA2 ua2G = gVarD != null ? gVarD.g() : null;
        androidx.compose.runtime.snapshots.g gVarE = aVar.e(gVarD);
        try {
            C14367hn7 c14367hn7L = c6542Ny3.l();
            if (c14367hn7L == null) {
                return;
            }
            C8564Wm7 c8564Wm7H = c6542Ny3.h();
            if (c8564Wm7H == null) {
                return;
            }
            InterfaceC11379cu3 interfaceC11379cu3K = c6542Ny3.k();
            if (interfaceC11379cu3K == null) {
                return;
            }
            AbstractC9096Yl7.a.e(c23945xm7, c6542Ny3.x(), c14367hn7L.f(), interfaceC11379cu3K, c8564Wm7H, c6542Ny3.f(), interfaceC11600dH4);
            C19938rB7 c19938rB7 = C19938rB7.a;
        } finally {
            aVar.l(gVarD, gVarE, ua2G);
        }
    }

    private static final androidx.compose.ui.e o(androidx.compose.ui.e eVar, C6542Ny3 c6542Ny3, C19101pm7 c19101pm7) {
        return androidx.compose.ui.input.key.a.b(eVar, new v(c6542Ny3, c19101pm7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(C7155Qm7 c7155Qm7, C6542Ny3 c6542Ny3, C23945xm7 c23945xm7, T33 t33, InterfaceC11600dH4 interfaceC11600dH4) {
        c6542Ny3.H(AbstractC9096Yl7.a.h(c7155Qm7, c23945xm7, c6542Ny3.p(), t33, c6542Ny3.o(), c6542Ny3.n()));
        n(c6542Ny3, c23945xm7, interfaceC11600dH4);
    }

    public static final void q(C6542Ny3 c6542Ny3, androidx.compose.ui.focus.m mVar, boolean z) {
        InterfaceC20600sH6 interfaceC20600sH6J;
        if (!c6542Ny3.f()) {
            androidx.compose.ui.focus.m.g(mVar, 0, 1, null);
        } else {
            if (!z || (interfaceC20600sH6J = c6542Ny3.j()) == null) {
                return;
            }
            interfaceC20600sH6J.a();
        }
    }

    /* renamed from: ir.nasim.Tn1$d */
    static final class d extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C6542Ny3 e;
        final /* synthetic */ C7155Qm7 f;
        final /* synthetic */ C23945xm7 g;
        final /* synthetic */ T33 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(C6542Ny3 c6542Ny3, C7155Qm7 c7155Qm7, C23945xm7 c23945xm7, T33 t33) {
            super(1);
            this.e = c6542Ny3;
            this.f = c7155Qm7;
            this.g = c23945xm7;
            this.h = t33;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final KV1 invoke(LV1 lv1) {
            if (this.e.f()) {
                C6542Ny3 c6542Ny3 = this.e;
                c6542Ny3.H(AbstractC9096Yl7.a.i(this.f, this.g, c6542Ny3.p(), this.h, this.e.o(), this.e.n()));
            }
            return new a();
        }

        /* renamed from: ir.nasim.Tn1$d$a */
        public static final class a implements KV1 {
            @Override // ir.nasim.KV1
            public void dispose() {
            }
        }
    }

    /* renamed from: ir.nasim.Tn1$e */
    static final class e extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC15796kB2 e;
        final /* synthetic */ C6542Ny3 f;
        final /* synthetic */ C9348Zn7 g;
        final /* synthetic */ int h;
        final /* synthetic */ int i;
        final /* synthetic */ C18510om7 j;
        final /* synthetic */ C23945xm7 k;
        final /* synthetic */ QY7 l;
        final /* synthetic */ androidx.compose.ui.e m;
        final /* synthetic */ androidx.compose.ui.e n;
        final /* synthetic */ androidx.compose.ui.e o;
        final /* synthetic */ androidx.compose.ui.e p;
        final /* synthetic */ InterfaceC7598Sk0 q;
        final /* synthetic */ C19101pm7 r;
        final /* synthetic */ boolean s;
        final /* synthetic */ boolean t;
        final /* synthetic */ UA2 u;
        final /* synthetic */ InterfaceC11600dH4 v;
        final /* synthetic */ WH1 w;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(InterfaceC15796kB2 interfaceC15796kB2, C6542Ny3 c6542Ny3, C9348Zn7 c9348Zn7, int i, int i2, C18510om7 c18510om7, C23945xm7 c23945xm7, QY7 qy7, androidx.compose.ui.e eVar, androidx.compose.ui.e eVar2, androidx.compose.ui.e eVar3, androidx.compose.ui.e eVar4, InterfaceC7598Sk0 interfaceC7598Sk0, C19101pm7 c19101pm7, boolean z, boolean z2, UA2 ua2, InterfaceC11600dH4 interfaceC11600dH4, WH1 wh1) {
            super(2);
            this.e = interfaceC15796kB2;
            this.f = c6542Ny3;
            this.g = c9348Zn7;
            this.h = i;
            this.i = i2;
            this.j = c18510om7;
            this.k = c23945xm7;
            this.l = qy7;
            this.m = eVar;
            this.n = eVar2;
            this.o = eVar3;
            this.p = eVar4;
            this.q = interfaceC7598Sk0;
            this.r = c19101pm7;
            this.s = z;
            this.t = z2;
            this.u = ua2;
            this.v = interfaceC11600dH4;
            this.w = wh1;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-492537660, i, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:555)");
            }
            this.e.q(AbstractC19242q11.e(-1835647873, true, new a(this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w), interfaceC22053ub1, 54), interfaceC22053ub1, 6);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }

        /* renamed from: ir.nasim.Tn1$e$a */
        static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            final /* synthetic */ C6542Ny3 e;
            final /* synthetic */ C9348Zn7 f;
            final /* synthetic */ int g;
            final /* synthetic */ int h;
            final /* synthetic */ C18510om7 i;
            final /* synthetic */ C23945xm7 j;
            final /* synthetic */ QY7 k;
            final /* synthetic */ androidx.compose.ui.e l;
            final /* synthetic */ androidx.compose.ui.e m;
            final /* synthetic */ androidx.compose.ui.e n;
            final /* synthetic */ androidx.compose.ui.e o;
            final /* synthetic */ InterfaceC7598Sk0 p;
            final /* synthetic */ C19101pm7 q;
            final /* synthetic */ boolean r;
            final /* synthetic */ boolean s;
            final /* synthetic */ UA2 t;
            final /* synthetic */ InterfaceC11600dH4 u;
            final /* synthetic */ WH1 v;

            /* renamed from: ir.nasim.Tn1$e$a$b */
            static final class b extends AbstractC8614Ws3 implements SA2 {
                final /* synthetic */ C6542Ny3 e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                b(C6542Ny3 c6542Ny3) {
                    super(0);
                    this.e = c6542Ny3;
                }

                @Override // ir.nasim.SA2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final C14367hn7 invoke() {
                    return this.e.l();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C6542Ny3 c6542Ny3, C9348Zn7 c9348Zn7, int i, int i2, C18510om7 c18510om7, C23945xm7 c23945xm7, QY7 qy7, androidx.compose.ui.e eVar, androidx.compose.ui.e eVar2, androidx.compose.ui.e eVar3, androidx.compose.ui.e eVar4, InterfaceC7598Sk0 interfaceC7598Sk0, C19101pm7 c19101pm7, boolean z, boolean z2, UA2 ua2, InterfaceC11600dH4 interfaceC11600dH4, WH1 wh1) {
                super(2);
                this.e = c6542Ny3;
                this.f = c9348Zn7;
                this.g = i;
                this.h = i2;
                this.i = c18510om7;
                this.j = c23945xm7;
                this.k = qy7;
                this.l = eVar;
                this.m = eVar2;
                this.n = eVar3;
                this.o = eVar4;
                this.p = interfaceC7598Sk0;
                this.q = c19101pm7;
                this.r = z;
                this.s = z2;
                this.t = ua2;
                this.u = interfaceC11600dH4;
                this.v = wh1;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                    interfaceC22053ub1.L();
                    return;
                }
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.Q(-1835647873, i, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:558)");
                }
                androidx.compose.ui.e eVarA = AbstractC16567lV2.a(androidx.compose.foundation.layout.t.k(androidx.compose.ui.e.a, this.e.m(), 0.0f, 2, null), this.f, this.g, this.h);
                C18510om7 c18510om7 = this.i;
                C23945xm7 c23945xm7 = this.j;
                QY7 qy7 = this.k;
                boolean zD = interfaceC22053ub1.D(this.e);
                C6542Ny3 c6542Ny3 = this.e;
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new b(c6542Ny3);
                    interfaceC22053ub1.s(objB);
                }
                LC6.a(androidx.compose.foundation.relocation.b.b(AbstractC21579tm7.a(AbstractC17919nm7.a(eVarA, c18510om7, c23945xm7, qy7, (SA2) objB).i(this.l).i(this.m), this.f).i(this.n).i(this.o), this.p), AbstractC19242q11.e(-1172467467, true, new C0669a(this.q, this.e, this.r, this.s, this.t, this.j, this.u, this.v, this.h), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 0);
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.P();
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }

            /* renamed from: ir.nasim.Tn1$e$a$a, reason: collision with other inner class name */
            static final class C0669a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
                final /* synthetic */ C19101pm7 e;
                final /* synthetic */ C6542Ny3 f;
                final /* synthetic */ boolean g;
                final /* synthetic */ boolean h;
                final /* synthetic */ UA2 i;
                final /* synthetic */ C23945xm7 j;
                final /* synthetic */ InterfaceC11600dH4 k;
                final /* synthetic */ WH1 l;
                final /* synthetic */ int m;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0669a(C19101pm7 c19101pm7, C6542Ny3 c6542Ny3, boolean z, boolean z2, UA2 ua2, C23945xm7 c23945xm7, InterfaceC11600dH4 interfaceC11600dH4, WH1 wh1, int i) {
                    super(2);
                    this.e = c19101pm7;
                    this.f = c6542Ny3;
                    this.g = z;
                    this.h = z2;
                    this.i = ua2;
                    this.j = c23945xm7;
                    this.k = interfaceC11600dH4;
                    this.l = wh1;
                    this.m = i;
                }

                /* JADX WARN: Removed duplicated region for block: B:32:0x00cc  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final void a(ir.nasim.InterfaceC22053ub1 r13, int r14) {
                    /*
                        Method dump skipped, instructions count: 264
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC7865Tn1.e.a.C0669a.a(ir.nasim.ub1, int):void");
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    return C19938rB7.a;
                }

                /* renamed from: ir.nasim.Tn1$e$a$a$a, reason: collision with other inner class name */
                public static final class C0670a implements InterfaceC10970cW3 {
                    final /* synthetic */ C6542Ny3 a;
                    final /* synthetic */ UA2 b;
                    final /* synthetic */ C23945xm7 c;
                    final /* synthetic */ InterfaceC11600dH4 d;
                    final /* synthetic */ WH1 e;
                    final /* synthetic */ int f;

                    C0670a(C6542Ny3 c6542Ny3, UA2 ua2, C23945xm7 c23945xm7, InterfaceC11600dH4 interfaceC11600dH4, WH1 wh1, int i) {
                        this.a = c6542Ny3;
                        this.b = ua2;
                        this.c = c23945xm7;
                        this.d = interfaceC11600dH4;
                        this.e = wh1;
                        this.f = i;
                    }

                    @Override // ir.nasim.InterfaceC10970cW3
                    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, List list, long j) {
                        g.a aVar = androidx.compose.runtime.snapshots.g.e;
                        C6542Ny3 c6542Ny3 = this.a;
                        androidx.compose.runtime.snapshots.g gVarD = aVar.d();
                        UA2 ua2G = gVarD != null ? gVarD.g() : null;
                        androidx.compose.runtime.snapshots.g gVarE = aVar.e(gVarD);
                        try {
                            C14367hn7 c14367hn7L = c6542Ny3.l();
                            C13774gn7 c13774gn7F = c14367hn7L != null ? c14367hn7L.f() : null;
                            C17428mw7 c17428mw7D = AbstractC9096Yl7.a.d(this.a.x(), j, interfaceC12377eW3.getLayoutDirection(), c13774gn7F);
                            int iIntValue = ((Number) c17428mw7D.a()).intValue();
                            int iIntValue2 = ((Number) c17428mw7D.b()).intValue();
                            C13774gn7 c13774gn7 = (C13774gn7) c17428mw7D.c();
                            if (!AbstractC13042fc3.d(c13774gn7F, c13774gn7)) {
                                this.a.K(new C14367hn7(c13774gn7, null, c14367hn7L != null ? c14367hn7L.b() : null, 2, null));
                                this.b.invoke(c13774gn7);
                                AbstractC7865Tn1.n(this.a, this.c, this.d);
                            }
                            this.a.L(this.e.D(this.f == 1 ? AbstractC3815Cl7.a(c13774gn7.m(0)) : 0));
                            return interfaceC12377eW3.P1(iIntValue, iIntValue2, AbstractC20051rO3.n(AbstractC4616Fw7.a(AbstractC13756gm.a(), Integer.valueOf(Math.round(c13774gn7.h()))), AbstractC4616Fw7.a(AbstractC13756gm.b(), Integer.valueOf(Math.round(c13774gn7.k())))), C0671a.e);
                        } finally {
                            aVar.l(gVarD, gVarE, ua2G);
                        }
                    }

                    @Override // ir.nasim.InterfaceC10970cW3
                    public int d(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
                        this.a.x().m(interfaceC10436bc3.getLayoutDirection());
                        return this.a.x().c();
                    }

                    /* renamed from: ir.nasim.Tn1$e$a$a$a$a, reason: collision with other inner class name */
                    static final class C0671a extends AbstractC8614Ws3 implements UA2 {
                        public static final C0671a e = new C0671a();

                        C0671a() {
                            super(1);
                        }

                        @Override // ir.nasim.UA2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            a((AbstractC21430te5.a) obj);
                            return C19938rB7.a;
                        }

                        public final void a(AbstractC21430te5.a aVar) {
                        }
                    }
                }
            }
        }
    }

    /* renamed from: ir.nasim.Tn1$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C13774gn7) obj);
            return C19938rB7.a;
        }

        public final void a(C13774gn7 c13774gn7) {
        }
    }
}
