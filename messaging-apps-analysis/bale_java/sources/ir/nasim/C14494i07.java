package ir.nasim;

import ir.nasim.C14494i07;
import ir.nasim.DX1;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC9905al2;
import ir.nasim.LY1;
import ir.nasim.MX1;
import ir.nasim.OY1;
import ir.nasim.RY1;
import ir.nasim.SY1;
import ir.nasim.core.modules.file.entity.FileReference;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.i07, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14494i07 {
    private final C20748sY1 a;
    private final C14970in2 b;
    private final C11298cm2 c;
    private final C10535bm2 d;
    private final InterfaceC20315ro1 e;
    private final AbstractC13778go1 f;
    private final C9847af4 g;
    private final ConcurrentHashMap h;

    /* renamed from: ir.nasim.i07$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ FileReference d;
        final /* synthetic */ boolean e;
        final /* synthetic */ boolean f;
        final /* synthetic */ InterfaceC8091Um2 g;

        /* renamed from: ir.nasim.i07$a$a, reason: collision with other inner class name */
        static final class C1288a implements InterfaceC4806Gq2 {
            final /* synthetic */ C14494i07 a;
            final /* synthetic */ InterfaceC8091Um2 b;

            C1288a(C14494i07 c14494i07, InterfaceC8091Um2 interfaceC8091Um2) {
                this.a = c14494i07;
                this.b = interfaceC8091Um2;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(SY1 sy1, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objU = this.a.u(sy1, this.b, interfaceC20295rm1);
                return objU == AbstractC14862ic3.e() ? objU : C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(FileReference fileReference, boolean z, boolean z2, InterfaceC8091Um2 interfaceC8091Um2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = fileReference;
            this.e = z;
            this.f = z2;
            this.g = interfaceC8091Um2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C14494i07.this.new a(this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2I = C14494i07.this.i(this.d, this.e, this.f);
                C1288a c1288a = new C1288a(C14494i07.this, this.g);
                this.b = 1;
                if (interfaceC4557Fq2I.b(c1288a, this) == objE) {
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

    /* renamed from: ir.nasim.i07$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ FileReference e;
        final /* synthetic */ boolean f;
        final /* synthetic */ boolean g;

        /* renamed from: ir.nasim.i07$b$a */
        public static final class a implements InterfaceC8091Um2 {
            final /* synthetic */ InterfaceC16204ks5 a;

            a(InterfaceC16204ks5 interfaceC16204ks5) {
                this.a = interfaceC16204ks5;
            }

            @Override // ir.nasim.InterfaceC8091Um2
            public void c(float f) {
                this.a.h(new RY1.b(f));
            }

            @Override // ir.nasim.InterfaceC8091Um2
            public void d(InterfaceC3346Am2 interfaceC3346Am2) {
                AbstractC13042fc3.i(interfaceC3346Am2, "reference");
                this.a.h(new RY1.a(interfaceC3346Am2));
            }

            @Override // ir.nasim.InterfaceC8091Um2
            public void e() {
                this.a.h(new RY1.c(null, 1, null));
            }

            @Override // ir.nasim.InterfaceC8091Um2
            public void g(DX1 dx1) {
                this.a.h(new RY1.c(dx1));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(FileReference fileReference, boolean z, boolean z2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = fileReference;
            this.f = z;
            this.g = z2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y(InterfaceC7857Tm2 interfaceC7857Tm2) {
            interfaceC7857Tm2.b();
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = C14494i07.this.new b(this.e, this.f, this.g, interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC16204ks5 interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
                a aVar = new a(interfaceC16204ks5);
                final InterfaceC7857Tm2 interfaceC7857Tm2M = C14494i07.this.g.b() ? C14494i07.this.m(this.e, false, aVar, this.f) : C14494i07.this.b.D(this.e, false, aVar, (56 & 8) != 0 ? false : this.f, (56 & 16) != 0, (56 & 32) != 0 ? false : this.g);
                SA2 sa2 = new SA2() { // from class: ir.nasim.j07
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C14494i07.b.y(interfaceC7857Tm2M);
                    }
                };
                this.b = 1;
                if (AbstractC13822gs5.a(interfaceC16204ks5, sa2, this) == objE) {
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
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.i07$c */
    public static final class c implements InterfaceC8091Um2 {
        final /* synthetic */ InterfaceC8807Xk2 a;

        c(InterfaceC8807Xk2 interfaceC8807Xk2) {
            this.a = interfaceC8807Xk2;
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void c(float f) {
            this.a.c(f);
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            this.a.d(interfaceC3346Am2);
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void e() {
            this.a.e();
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void g(DX1 dx1) {
            this.a.g(dx1);
        }
    }

    /* renamed from: ir.nasim.i07$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ SY1 c;
        final /* synthetic */ InterfaceC8091Um2 d;
        final /* synthetic */ C14494i07 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(SY1 sy1, InterfaceC8091Um2 interfaceC8091Um2, C14494i07 c14494i07, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = sy1;
            this.d = interfaceC8091Um2;
            this.e = c14494i07;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            SY1 sy1 = this.c;
            if (sy1 instanceof SY1.c) {
                InterfaceC8091Um2 interfaceC8091Um2 = this.d;
                EX1 ex1A = ((SY1.c) this.c).a();
                interfaceC8091Um2.g(new DX1.d(ex1A != null ? HX1.a(ex1A) : null));
            } else if (sy1 instanceof SY1.b) {
                this.d.c(((SY1.b) sy1).a());
            } else {
                if (!(sy1 instanceof SY1.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                this.d.d(this.e.t(((SY1.a) sy1).a()));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C14494i07(C20748sY1 c20748sY1, C14970in2 c14970in2, C11298cm2 c11298cm2, C10535bm2 c10535bm2, InterfaceC20315ro1 interfaceC20315ro1, AbstractC13778go1 abstractC13778go1, C9847af4 c9847af4) {
        AbstractC13042fc3.i(c20748sY1, "newDownloadManager");
        AbstractC13042fc3.i(c14970in2, "filesModule");
        AbstractC13042fc3.i(c11298cm2, "fileReferenceToStreamableDownloadInputMapper");
        AbstractC13042fc3.i(c10535bm2, "fileReferenceToStandardDownloadInputMapper");
        AbstractC13042fc3.i(interfaceC20315ro1, "applicationScope");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(c9847af4, "migrationChecker");
        this.a = c20748sY1;
        this.b = c14970in2;
        this.c = c11298cm2;
        this.d = c10535bm2;
        this.e = interfaceC20315ro1;
        this.f = abstractC13778go1;
        this.g = c9847af4;
        this.h = new ConcurrentHashMap();
    }

    private final void h(FileReference fileReference, boolean z) {
        XV4 xv4 = (XV4) this.h.remove(Long.valueOf(fileReference.getFileId()));
        if (xv4 != null) {
            InterfaceC7857Tm2 interfaceC7857Tm2 = (InterfaceC7857Tm2) xv4.a();
            InterfaceC13730gj3 interfaceC13730gj3 = (InterfaceC13730gj3) xv4.b();
            if (interfaceC13730gj3 != null) {
                InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
            }
            interfaceC7857Tm2.a(z);
            if (z && this.g.b()) {
                this.a.i(new C4995Hl2(fileReference.getFileId(), fileReference.getAccessHash()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC4557Fq2 i(FileReference fileReference, boolean z, boolean z2) {
        return z2 ? k(fileReference, z) : j(fileReference, z);
    }

    private final InterfaceC4557Fq2 j(FileReference fileReference, boolean z) {
        MX1.a aVarA = this.d.a(fileReference);
        return z ? this.a.v(aVarA, new FY1(OY1.a.a), new LY1.a(null, 1, null)) : this.a.r(aVarA);
    }

    private final InterfaceC4557Fq2 k(FileReference fileReference, boolean z) {
        MX1.b bVarA = this.c.a(fileReference);
        return z ? this.a.w(bVarA, new FY1(OY1.a.a), new LY1.a(null, 1, null)) : this.a.s(bVarA);
    }

    private final InterfaceC7857Tm2 l(FileReference fileReference, boolean z, InterfaceC8091Um2 interfaceC8091Um2, boolean z2, boolean z3) {
        return this.b.D(fileReference, z, interfaceC8091Um2, (56 & 8) != 0 ? false : z2, (56 & 16) != 0 ? true : z3, (56 & 32) != 0 ? false : false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC7857Tm2 m(final FileReference fileReference, boolean z, InterfaceC8091Um2 interfaceC8091Um2, boolean z2) {
        InterfaceC13730gj3 interfaceC13730gj3D = AbstractC10533bm0.d(this.e, null, null, new a(fileReference, z, z2, interfaceC8091Um2, null), 3, null);
        C3884Ct4 c3884Ct4 = new C3884Ct4(new UA2() { // from class: ir.nasim.h07
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C14494i07.n(this.a, fileReference, ((Boolean) obj).booleanValue());
            }
        });
        this.h.put(Long.valueOf(fileReference.getFileId()), AbstractC4616Fw7.a(c3884Ct4, interfaceC13730gj3D));
        return c3884Ct4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n(C14494i07 c14494i07, FileReference fileReference, boolean z) {
        AbstractC13042fc3.i(c14494i07, "this$0");
        AbstractC13042fc3.i(fileReference, "$reference");
        c14494i07.h(fileReference, z);
        return C19938rB7.a;
    }

    public static /* synthetic */ InterfaceC7857Tm2 r(C14494i07 c14494i07, FileReference fileReference, InterfaceC8807Xk2 interfaceC8807Xk2, boolean z, boolean z2, boolean z3, int i, Object obj) {
        boolean z4 = (i & 4) != 0 ? false : z;
        boolean z5 = (i & 8) != 0 ? false : z2;
        if ((i & 16) != 0) {
            z3 = true;
        }
        return c14494i07.o(fileReference, interfaceC8807Xk2, z4, z5, z3);
    }

    public static /* synthetic */ InterfaceC4557Fq2 s(C14494i07 c14494i07, boolean z, FileReference fileReference, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        return c14494i07.q(z, fileReference, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC3346Am2 t(InterfaceC9905al2 interfaceC9905al2) {
        if (interfaceC9905al2 instanceof InterfaceC9905al2.a) {
            return new C9115Yo(((InterfaceC9905al2.a) interfaceC9905al2).a());
        }
        if (interfaceC9905al2 instanceof InterfaceC9905al2.b) {
            return new C9115Yo("");
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object u(SY1 sy1, InterfaceC8091Um2 interfaceC8091Um2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(C12366eV1.c(), new d(sy1, interfaceC8091Um2, this, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    public final InterfaceC7857Tm2 o(FileReference fileReference, InterfaceC8807Xk2 interfaceC8807Xk2, boolean z, boolean z2, boolean z3) {
        AbstractC13042fc3.i(fileReference, "reference");
        AbstractC13042fc3.i(interfaceC8807Xk2, "fileCallback");
        return p(fileReference, new c(interfaceC8807Xk2), z, z2, z3);
    }

    public final InterfaceC7857Tm2 p(FileReference fileReference, InterfaceC8091Um2 interfaceC8091Um2, boolean z, boolean z2, boolean z3) {
        AbstractC13042fc3.i(fileReference, "reference");
        AbstractC13042fc3.i(interfaceC8091Um2, "fileVmCallback");
        return this.g.b() ? m(fileReference, z2, interfaceC8091Um2, z) : l(fileReference, z2, interfaceC8091Um2, z, z3);
    }

    public final InterfaceC4557Fq2 q(boolean z, FileReference fileReference, boolean z2) {
        AbstractC13042fc3.i(fileReference, "reference");
        return AbstractC6459Nq2.V(AbstractC6459Nq2.f(new b(fileReference, z2, z, null)), this.f);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C14494i07(C20748sY1 c20748sY1, C14970in2 c14970in2, InterfaceC20315ro1 interfaceC20315ro1, AbstractC13778go1 abstractC13778go1, C11298cm2 c11298cm2, C9847af4 c9847af4) {
        this(c20748sY1, c14970in2, c11298cm2, C10535bm2.a, interfaceC20315ro1, abstractC13778go1, c9847af4);
        AbstractC13042fc3.i(c20748sY1, "newDownloadManager");
        AbstractC13042fc3.i(c14970in2, "filesModule");
        AbstractC13042fc3.i(interfaceC20315ro1, "applicationScope");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(c11298cm2, "fileReferenceToStreamableDownloadInputMapper");
        AbstractC13042fc3.i(c9847af4, "migrationChecker");
    }
}
