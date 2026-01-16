package ir.nasim;

import android.gov.nist.core.Separators;
import com.google.android.exoplayer2.C2018a0;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.a;
import ir.nasim.C16007kY6;
import ir.nasim.C9785aZ1;
import ir.nasim.EX1;
import ir.nasim.InterfaceC9905al2;
import ir.nasim.MX1;
import ir.nasim.MY1;
import ir.nasim.SY1;
import java.util.NavigableSet;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.kY6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C16007kY6 implements InterfaceC11759dZ1 {
    private static final a f = new a(null);
    private final Cache a;
    private final AbstractC13778go1 b;
    private final a.c c;
    private final C9785aZ1.d d;
    private final InterfaceC14123hO3 e;

    /* renamed from: ir.nasim.kY6$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.kY6$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ C9785aZ1 d;
        final /* synthetic */ C16007kY6 e;
        final /* synthetic */ MX1.b f;

        /* renamed from: ir.nasim.kY6$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C17416mv5 c;
            final /* synthetic */ MX1.b d;
            final /* synthetic */ InterfaceC16204ks5 e;
            final /* synthetic */ C16007kY6 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C17416mv5 c17416mv5, MX1.b bVar, InterfaceC16204ks5 interfaceC16204ks5, C16007kY6 c16007kY6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c17416mv5;
                this.d = bVar;
                this.e = interfaceC16204ks5;
                this.f = c16007kY6;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void y(MX1.b bVar, InterfaceC16204ks5 interfaceC16204ks5, C16007kY6 c16007kY6, long j, long j2, float f) {
                if (j2 < bVar.b()) {
                    interfaceC16204ks5.h(new SY1.b(AbstractC23053wG5.l(j2 / bVar.b(), 0.0f, 1.0f)));
                    return;
                }
                long jB = bVar.b();
                NavigableSet navigableSetM = c16007kY6.a.m(bVar.d());
                AbstractC13042fc3.h(navigableSetM, "getCachedSpans(...)");
                interfaceC16204ks5.h(new SY1.a(new InterfaceC9905al2.b(jB, navigableSetM)));
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
                C17416mv5 c17416mv5 = this.c;
                final MX1.b bVar = this.d;
                final InterfaceC16204ks5 interfaceC16204ks5 = this.e;
                final C16007kY6 c16007kY6 = this.f;
                c17416mv5.d(new InterfaceC10995cZ1() { // from class: ir.nasim.mY6
                    @Override // ir.nasim.InterfaceC10995cZ1
                    public final void a(long j, long j2, float f) {
                        C16007kY6.b.a.y(bVar, interfaceC16204ks5, c16007kY6, j, j2, f);
                    }
                });
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C9785aZ1 c9785aZ1, C16007kY6 c16007kY6, MX1.b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c9785aZ1;
            this.e = c16007kY6;
            this.f = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y(C17416mv5 c17416mv5) {
            c17416mv5.c();
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(this.d, this.e, this.f, interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC16204ks5 interfaceC16204ks5;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
                C9785aZ1 c9785aZ1 = this.d;
                this.c = interfaceC16204ks5;
                this.b = 1;
                obj = c9785aZ1.c(this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i == 2) {
                        AbstractC10685c16.b(obj);
                        return C19938rB7.a;
                    }
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
                AbstractC10685c16.b(obj);
            }
            MY1 my1 = (MY1) obj;
            if (my1 instanceof MY1.a) {
                SY1.c cVar = new SY1.c(((MY1.a) my1).a());
                this.c = null;
                this.b = 2;
                if (interfaceC16204ks5.o(cVar, this) == objE) {
                    return objE;
                }
                return C19938rB7.a;
            }
            if (!(my1 instanceof MY1.b)) {
                throw new NoWhenBranchMatchedException();
            }
            final C17416mv5 c17416mv5 = new C17416mv5(this.e.f(this.f, (String) ((MY1.b) my1).a()), this.e.c);
            InterfaceC16204ks5 interfaceC16204ks52 = interfaceC16204ks5;
            AbstractC10533bm0.d(interfaceC16204ks52, null, null, new a(c17416mv5, this.f, interfaceC16204ks5, this.e, null), 3, null);
            SA2 sa2 = new SA2() { // from class: ir.nasim.lY6
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C16007kY6.b.y(c17416mv5);
                }
            };
            this.c = null;
            this.b = 3;
            if (AbstractC13822gs5.a(interfaceC16204ks5, sa2, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.kY6$c */
    static final class c extends AbstractC19859r37 implements InterfaceC16978mB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ Object d;
        final /* synthetic */ FY1 f;
        final /* synthetic */ C23270we2 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(FY1 fy1, C23270we2 c23270we2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(4, interfaceC20295rm1);
            this.f = fy1;
            this.g = c23270we2;
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            return n((InterfaceC4806Gq2) obj, (Throwable) obj2, ((Number) obj3).longValue(), (InterfaceC20295rm1) obj4);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i != 0) {
                if (i == 1) {
                    AbstractC10685c16.b(obj);
                    return AbstractC6392Nk0.a(true);
                }
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return AbstractC6392Nk0.a(false);
            }
            AbstractC10685c16.b(obj);
            InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
            Throwable th = (Throwable) this.d;
            EX1 eVar = (EX1) C16007kY6.this.e.a(th);
            if (eVar == null) {
                eVar = new EX1.e(th);
            }
            C19406qI3.c("StreamableDownloader", "Download failed with exception(" + th.getClass().getSimpleName() + ") that is detected as error(" + eVar + Separators.RPAREN, th);
            if (eVar.a() && ((Boolean) this.f.a().a().invoke(eVar)).booleanValue()) {
                long jA = this.g.a();
                this.c = null;
                this.b = 1;
                if (HG1.b(jA, this) == objE) {
                    return objE;
                }
                return AbstractC6392Nk0.a(true);
            }
            SY1.c cVar = new SY1.c(eVar);
            this.c = null;
            this.b = 2;
            if (interfaceC4806Gq2.a(cVar, this) == objE) {
                return objE;
            }
            return AbstractC6392Nk0.a(false);
        }

        public final Object n(InterfaceC4806Gq2 interfaceC4806Gq2, Throwable th, long j, InterfaceC20295rm1 interfaceC20295rm1) {
            c cVar = C16007kY6.this.new c(this.f, this.g, interfaceC20295rm1);
            cVar.c = interfaceC4806Gq2;
            cVar.d = th;
            return cVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.kY6$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;
        final /* synthetic */ MX1.b d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(MX1.b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = bVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            d dVar = new d(this.d, interfaceC20295rm1);
            dVar.c = obj;
            return dVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            SY1 sy1 = (SY1) this.c;
            C19406qI3.a("StreamableDownloader", "DownloadState of " + this.d.d() + ": " + sy1, new Object[0]);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(SY1 sy1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(sy1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C16007kY6(Cache cache, AbstractC13778go1 abstractC13778go1, a.c cVar, C9785aZ1.d dVar, InterfaceC14123hO3 interfaceC14123hO3) {
        AbstractC13042fc3.i(cache, "cache");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(cVar, "cacheDataSourceFactory");
        AbstractC13042fc3.i(dVar, "downloadUrlProviderFactory");
        AbstractC13042fc3.i(interfaceC14123hO3, "throwableToDownloadErrorMapper");
        this.a = cache;
        this.b = abstractC13778go1;
        this.c = cVar;
        this.d = dVar;
        this.e = interfaceC14123hO3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C2018a0 f(MX1.b bVar, String str) {
        C2018a0 c2018a0A = new C2018a0.c().k(str).b(bVar.d()).a();
        AbstractC13042fc3.h(c2018a0A, "build(...)");
        return c2018a0A;
    }

    private final InterfaceC4557Fq2 g(MX1.b bVar, FY1 fy1) {
        return AbstractC6459Nq2.V(AbstractC6459Nq2.i0(AbstractC6459Nq2.j(new b(this.d.a(bVar.c(), fy1.a()), this, bVar, null)), new c(fy1, new C23270we2(0L, 0L, 0.0d, 0.0f, 15, null), null)), this.b);
    }

    @Override // ir.nasim.InterfaceC11759dZ1
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public InterfaceC4557Fq2 a(MX1.b bVar, FY1 fy1) {
        AbstractC13042fc3.i(bVar, "input");
        AbstractC13042fc3.i(fy1, "downloadPolicy");
        return AbstractC6459Nq2.q(AbstractC6459Nq2.b0(g(bVar, fy1), new d(bVar, null)));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C16007kY6(Cache cache, AbstractC13778go1 abstractC13778go1, a.c cVar, C9785aZ1.d dVar) {
        this(cache, abstractC13778go1, cVar, dVar, C19131pp7.a);
        AbstractC13042fc3.i(cache, "cache");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(cVar, "cacheDataSourceFactory");
        AbstractC13042fc3.i(dVar, "downloadUrlProviderFactory");
    }
}
