package ir.nasim;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.C2018a0;
import com.google.android.exoplayer2.InterfaceC2037k;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.a;
import ir.nasim.InterfaceC14190hV7;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Pn5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6918Pn5 {
    private final Cache a;
    private final EnumC8893Xt7 b;
    private final AbstractC13778go1 c;
    private final AbstractC13778go1 d;
    private final C14801iV7 e;
    private final PF2 f;
    private final Context g;

    /* renamed from: ir.nasim.Pn5$a */
    public interface a {
        C6918Pn5 a(EnumC8893Xt7 enumC8893Xt7);
    }

    /* renamed from: ir.nasim.Pn5$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC2037k c;
        final /* synthetic */ C6918Pn5 d;
        final /* synthetic */ InterfaceC14190hV7 e;
        final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC2037k interfaceC2037k, C6918Pn5 c6918Pn5, InterfaceC14190hV7 interfaceC14190hV7, String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC2037k;
            this.d = c6918Pn5;
            this.e = interfaceC14190hV7;
            this.f = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC2037k interfaceC2037k = this.c;
            C14801iV7 c14801iV7 = this.d.e;
            String strA = ((InterfaceC14190hV7.a) this.e).a();
            InterfaceC14190hV7.a aVar = (InterfaceC14190hV7.a) this.e;
            OT7 ot7 = new OT7();
            interfaceC2037k.z0(c14801iV7.a(strA, aVar, this.f, this.d.b, ot7), false);
            this.c.stop();
            this.c.r();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Pn5$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC14190hV7 c;
        final /* synthetic */ C6918Pn5 d;
        final /* synthetic */ InterfaceC2037k e;
        final /* synthetic */ String f;

        /* renamed from: ir.nasim.Pn5$c$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceC2037k c;
            final /* synthetic */ C6918Pn5 d;
            final /* synthetic */ InterfaceC14190hV7 e;
            final /* synthetic */ String f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC2037k interfaceC2037k, C6918Pn5 c6918Pn5, InterfaceC14190hV7 interfaceC14190hV7, String str, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceC2037k;
                this.d = c6918Pn5;
                this.e = interfaceC14190hV7;
                this.f = str;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, this.e, this.f, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.c.z0(C14801iV7.b(this.d.e, null, this.e, this.f, this.d.b, null, 16, null), false);
                this.c.stop();
                this.c.r();
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.Pn5$c$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C6918Pn5 d;
            final /* synthetic */ InterfaceC2037k e;
            final /* synthetic */ InterfaceC14190hV7 f;
            final /* synthetic */ String g;

            /* renamed from: ir.nasim.Pn5$c$b$a */
            static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ InterfaceC2037k c;
                final /* synthetic */ C6918Pn5 d;
                final /* synthetic */ InterfaceC14190hV7 e;
                final /* synthetic */ String f;
                final /* synthetic */ String g;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(InterfaceC2037k interfaceC2037k, C6918Pn5 c6918Pn5, InterfaceC14190hV7 interfaceC14190hV7, String str, String str2, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = interfaceC2037k;
                    this.d = c6918Pn5;
                    this.e = interfaceC14190hV7;
                    this.f = str;
                    this.g = str2;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new a(this.c, this.d, this.e, this.f, this.g, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    InterfaceC2037k interfaceC2037k = this.c;
                    C14801iV7 c14801iV7 = this.d.e;
                    InterfaceC14190hV7.b bVar = (InterfaceC14190hV7.b) this.e;
                    OT7 ot7 = new OT7();
                    interfaceC2037k.z0(c14801iV7.a(this.f, bVar, this.g, this.d.b, ot7), false);
                    this.c.stop();
                    this.c.r();
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C6918Pn5 c6918Pn5, InterfaceC2037k interfaceC2037k, InterfaceC14190hV7 interfaceC14190hV7, String str, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c6918Pn5;
                this.e = interfaceC2037k;
                this.f = interfaceC14190hV7;
                this.g = str;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.d, this.e, this.f, this.g, interfaceC20295rm1);
                bVar.c = obj;
                return bVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    String str = (String) this.c;
                    AbstractC13778go1 abstractC13778go1 = this.d.c;
                    a aVar = new a(this.e, this.d, this.f, str, this.g, null);
                    this.b = 1;
                    if (AbstractC9323Zl0.g(abstractC13778go1, aVar, this) == objE) {
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
            public final Object invoke(String str, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(str, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(InterfaceC14190hV7 interfaceC14190hV7, C6918Pn5 c6918Pn5, InterfaceC2037k interfaceC2037k, String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC14190hV7;
            this.d = c6918Pn5;
            this.e = interfaceC2037k;
            this.f = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i != 0) {
                if (i == 1) {
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return C19938rB7.a;
            }
            AbstractC10685c16.b(obj);
            ((InterfaceC14190hV7.b) this.c).a();
            if (((InterfaceC14190hV7.b) this.c).e()) {
                AbstractC13778go1 abstractC13778go1 = this.d.c;
                a aVar = new a(this.e, this.d, this.c, this.f, null);
                this.b = 1;
                if (AbstractC9323Zl0.g(abstractC13778go1, aVar, this) == objE) {
                    return objE;
                }
                return C19938rB7.a;
            }
            InterfaceC4557Fq2 interfaceC4557Fq2I = this.d.f.i(((InterfaceC14190hV7.b) this.c).c(), ((InterfaceC14190hV7.b) this.c).b());
            b bVar = new b(this.d, this.e, this.c, this.f, null);
            this.b = 2;
            if (AbstractC6459Nq2.l(interfaceC4557Fq2I, bVar, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Pn5$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC14190hV7 c;
        final /* synthetic */ C6918Pn5 d;
        final /* synthetic */ com.google.android.exoplayer2.E0 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(InterfaceC14190hV7 interfaceC14190hV7, C6918Pn5 c6918Pn5, com.google.android.exoplayer2.E0 e0, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC14190hV7;
            this.d = c6918Pn5;
            this.e = e0;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            ProgressiveMediaSource progressiveMediaSourceA;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC14190hV7 interfaceC14190hV7 = this.c;
            if (interfaceC14190hV7 instanceof InterfaceC14190hV7.a) {
                com.google.android.exoplayer2.upstream.d dVar = new com.google.android.exoplayer2.upstream.d(this.d.g, AbstractC9683aN7.l0(this.d.g, this.d.g.getPackageName()));
                C2018a0 c2018a0E = C2018a0.e(Uri.parse(((InterfaceC14190hV7.a) this.c).a()));
                AbstractC13042fc3.h(c2018a0E, "fromUri(...)");
                progressiveMediaSourceA = new ProgressiveMediaSource.Factory(dVar).c(new OT7()).a(c2018a0E);
            } else {
                if (!(interfaceC14190hV7 instanceof InterfaceC14190hV7.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                C2018a0 c2018a0A = new C2018a0.c().k("").b(((InterfaceC14190hV7.b) interfaceC14190hV7).a()).a();
                AbstractC13042fc3.h(c2018a0A, "build(...)");
                a.c cVarH = new a.c().h(this.d.a);
                AbstractC13042fc3.h(cVarH, "setCache(...)");
                progressiveMediaSourceA = new ProgressiveMediaSource.Factory(cVarH).c(new OT7()).a(c2018a0A);
            }
            AbstractC13042fc3.f(progressiveMediaSourceA);
            this.e.d(progressiveMediaSourceA);
            this.e.r();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C6918Pn5(Cache cache, EnumC8893Xt7 enumC8893Xt7, AbstractC13778go1 abstractC13778go1, AbstractC13778go1 abstractC13778go12, C14801iV7 c14801iV7, PF2 pf2, Context context) {
        AbstractC13042fc3.i(cache, "cache");
        AbstractC13042fc3.i(abstractC13778go1, "mainDispatcher");
        AbstractC13042fc3.i(abstractC13778go12, "ioDispatcher");
        AbstractC13042fc3.i(c14801iV7, "videoSourceToExoMediaSourceMapper");
        AbstractC13042fc3.i(pf2, "getDownloadUrlUseCase");
        AbstractC13042fc3.i(context, "context");
        this.a = cache;
        this.b = enumC8893Xt7;
        this.c = abstractC13778go1;
        this.d = abstractC13778go12;
        this.e = c14801iV7;
        this.f = pf2;
        this.g = context;
    }

    public static /* synthetic */ Object h(C6918Pn5 c6918Pn5, String str, InterfaceC14190hV7 interfaceC14190hV7, InterfaceC2037k interfaceC2037k, InterfaceC20295rm1 interfaceC20295rm1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        return c6918Pn5.g(str, interfaceC14190hV7, interfaceC2037k, interfaceC20295rm1);
    }

    public final Object g(String str, InterfaceC14190hV7 interfaceC14190hV7, InterfaceC2037k interfaceC2037k, InterfaceC20295rm1 interfaceC20295rm1) {
        if (interfaceC14190hV7 instanceof InterfaceC14190hV7.a) {
            Object objG = AbstractC9323Zl0.g(this.c, new b(interfaceC2037k, this, interfaceC14190hV7, str, null), interfaceC20295rm1);
            return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
        }
        if (!(interfaceC14190hV7 instanceof InterfaceC14190hV7.b)) {
            throw new NoWhenBranchMatchedException();
        }
        Object objG2 = AbstractC9323Zl0.g(this.d, new c(interfaceC14190hV7, this, interfaceC2037k, str, null), interfaceC20295rm1);
        return objG2 == AbstractC14862ic3.e() ? objG2 : C19938rB7.a;
    }

    public final Object i(InterfaceC14190hV7 interfaceC14190hV7, com.google.android.exoplayer2.E0 e0, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(this.c, new d(interfaceC14190hV7, this, e0, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }
}
