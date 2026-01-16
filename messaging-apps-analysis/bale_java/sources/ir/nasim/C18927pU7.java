package ir.nasim;

import android.content.Context;
import com.google.android.exoplayer2.upstream.cache.Cache;
import ir.nasim.C18927pU7;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC15981kV7;
import ir.nasim.core.modules.file.entity.FileReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.pU7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C18927pU7 extends SS7 {
    private final C24440yd2 A;
    private boolean B;
    private InterfaceC13730gj3 D;
    private final String o;
    private final C12660ez3 p;
    private final EG2 q;
    private final EnumC8893Xt7 r;
    private final ArrayList s;
    private com.google.android.exoplayer2.E0 t;
    private final Cache u;
    private final InterfaceC12532em2 v;
    private final C11045ce2 w;
    private final PF2 x;
    private final IT7 y;
    private final C14801iV7 z;

    /* renamed from: ir.nasim.pU7$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ com.google.android.exoplayer2.E0 e;
        final /* synthetic */ FileReference f;

        /* renamed from: ir.nasim.pU7$a$a, reason: collision with other inner class name */
        static final class C1447a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceC10258bL6 c;
            final /* synthetic */ C18927pU7 d;

            /* renamed from: ir.nasim.pU7$a$a$a, reason: collision with other inner class name */
            static final class C1448a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;

                C1448a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C1448a c1448a = new C1448a(interfaceC20295rm1);
                    c1448a.c = obj;
                    return c1448a;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return AbstractC6392Nk0.a(((InterfaceC15981kV7) this.c).b());
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC15981kV7 interfaceC15981kV7, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C1448a) create(interfaceC15981kV7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1447a(InterfaceC10258bL6 interfaceC10258bL6, C18927pU7 c18927pU7, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceC10258bL6;
                this.d = c18927pU7;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C1447a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC10258bL6 interfaceC10258bL6 = this.c;
                    C1448a c1448a = new C1448a(null);
                    this.b = 1;
                    if (AbstractC6459Nq2.H(interfaceC10258bL6, c1448a, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                C9115Yo c9115Yo = new C9115Yo("");
                C18927pU7 c18927pU7 = this.d;
                Iterator it = c18927pU7.Y(c18927pU7.r()).iterator();
                while (it.hasNext()) {
                    ((AbstractC22597vW1) it.next()).d(c9115Yo);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1447a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.pU7$a$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceC10258bL6 c;
            final /* synthetic */ C18927pU7 d;

            /* renamed from: ir.nasim.pU7$a$b$a, reason: collision with other inner class name */
            static final class C1449a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;

                C1449a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C1449a c1449a = new C1449a(interfaceC20295rm1);
                    c1449a.c = obj;
                    return c1449a;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return AbstractC6392Nk0.a(((InterfaceC15981kV7) this.c).a());
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC15981kV7 interfaceC15981kV7, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C1449a) create(interfaceC15981kV7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(InterfaceC10258bL6 interfaceC10258bL6, C18927pU7 c18927pU7, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceC10258bL6;
                this.d = c18927pU7;
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
                    InterfaceC10258bL6 interfaceC10258bL6 = this.c;
                    C1449a c1449a = new C1449a(null);
                    this.b = 1;
                    if (AbstractC6459Nq2.H(interfaceC10258bL6, c1449a, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                C18927pU7 c18927pU7 = this.d;
                ArrayList arrayListR = c18927pU7.r();
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : arrayListR) {
                    if (obj2 instanceof InterfaceC20718sU7) {
                        arrayList.add(obj2);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((InterfaceC20718sU7) it.next()).onFirstFrameRendered();
                }
                Iterator it2 = c18927pU7.s.iterator();
                while (it2.hasNext()) {
                    ((InterfaceC20718sU7) it2.next()).onFirstFrameRendered();
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.pU7$a$c */
        static final class c implements InterfaceC4806Gq2 {
            final /* synthetic */ C18927pU7 a;

            c(C18927pU7 c18927pU7) {
                this.a = c18927pU7;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 h(InterfaceC15981kV7 interfaceC15981kV7, InterfaceC20718sU7 interfaceC20718sU7) {
                AbstractC13042fc3.i(interfaceC15981kV7, "$mediaState");
                AbstractC13042fc3.i(interfaceC20718sU7, "adapter");
                InterfaceC15981kV7.a aVar = (InterfaceC15981kV7.a) interfaceC15981kV7;
                interfaceC20718sU7.j(aVar.d(), aVar.c());
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 i(InterfaceC15981kV7 interfaceC15981kV7, InterfaceC20718sU7 interfaceC20718sU7) {
                AbstractC13042fc3.i(interfaceC15981kV7, "$mediaState");
                AbstractC13042fc3.i(interfaceC20718sU7, "adapter");
                InterfaceC15981kV7.b bVar = (InterfaceC15981kV7.b) interfaceC15981kV7;
                interfaceC20718sU7.h(bVar.c(), bVar.d());
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public final Object a(final InterfaceC15981kV7 interfaceC15981kV7, InterfaceC20295rm1 interfaceC20295rm1) {
                UA2 ua2;
                if (interfaceC15981kV7 instanceof InterfaceC15981kV7.a) {
                    ua2 = new UA2() { // from class: ir.nasim.qU7
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C18927pU7.a.c.h(interfaceC15981kV7, (InterfaceC20718sU7) obj);
                        }
                    };
                } else {
                    if (!(interfaceC15981kV7 instanceof InterfaceC15981kV7.b)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    ua2 = new UA2() { // from class: ir.nasim.rU7
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C18927pU7.a.c.i(interfaceC15981kV7, (InterfaceC20718sU7) obj);
                        }
                    };
                }
                C18927pU7 c18927pU7 = this.a;
                ArrayList arrayListR = c18927pU7.r();
                ArrayList arrayList = new ArrayList();
                for (Object obj : arrayListR) {
                    if (obj instanceof InterfaceC20718sU7) {
                        arrayList.add(obj);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ua2.invoke(it.next());
                }
                Iterator it2 = c18927pU7.s.iterator();
                while (it2.hasNext()) {
                    ua2.invoke(it2.next());
                }
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(com.google.android.exoplayer2.E0 e0, FileReference fileReference, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = e0;
            this.f = fileReference;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = C18927pU7.this.new a(this.e, this.f, interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC20315ro1 interfaceC20315ro1;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                InterfaceC4557Fq2 interfaceC4557Fq2K = C18927pU7.this.q.k(this.e, this.f);
                this.c = interfaceC20315ro1;
                this.b = 1;
                obj = AbstractC6459Nq2.p0(interfaceC4557Fq2K, interfaceC20315ro1, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    throw new KotlinNothingValueException();
                }
                interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                AbstractC10685c16.b(obj);
            }
            InterfaceC10258bL6 interfaceC10258bL6 = (InterfaceC10258bL6) obj;
            AbstractC10533bm0.d(interfaceC20315ro1, C12366eV1.c(), null, new C1447a(interfaceC10258bL6, C18927pU7.this, null), 2, null);
            AbstractC10533bm0.d(interfaceC20315ro1, C12366eV1.c(), null, new b(interfaceC10258bL6, C18927pU7.this, null), 2, null);
            c cVar = new c(C18927pU7.this);
            this.c = null;
            this.b = 2;
            if (interfaceC10258bL6.b(cVar, this) == objE) {
                return objE;
            }
            throw new KotlinNothingValueException();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public /* synthetic */ C18927pU7(Context context, AbstractC17757nW1 abstractC17757nW1, C14970in2 c14970in2, String str, C12660ez3 c12660ez3, EG2 eg2, EnumC8893Xt7 enumC8893Xt7, int i, ED1 ed1) {
        this(context, abstractC17757nW1, c14970in2, str, c12660ez3, (i & 32) != 0 ? new EG2(context) : eg2, enumC8893Xt7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List Y(List list) {
        if (!this.B) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!(((AbstractC22597vW1) obj) instanceof InterfaceC20718sU7)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final InterfaceC13730gj3 a0(com.google.android.exoplayer2.E0 e0, FileReference fileReference) {
        return this.p.c(C12366eV1.c(), new a(e0, fileReference, null));
    }

    private final com.google.android.exoplayer2.E0 b0() {
        com.google.android.exoplayer2.E0 e0C = this.t;
        if (e0C == null) {
            e0C = IC6.a.c();
        }
        e0C.g(0.0f);
        e0C.x(0L);
        e0C.Q0(1.0f);
        e0C.E(this.A);
        e0C.D(true);
        e0C.s(2);
        return e0C;
    }

    private final void d0(com.google.android.exoplayer2.E0 e0, FileReference fileReference) {
        if (this.B) {
            return;
        }
        this.B = true;
        InterfaceC13730gj3 interfaceC13730gj3 = this.D;
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        ArrayList arrayListR = r();
        ArrayList arrayList = new ArrayList();
        for (Object obj : arrayListR) {
            if (obj instanceof InterfaceC20718sU7) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((InterfaceC20718sU7) it.next()).l(e0, x());
        }
        Iterator it2 = this.s.iterator();
        while (it2.hasNext()) {
            ((InterfaceC20718sU7) it2.next()).l(e0, x());
        }
        this.D = a0(e0, fileReference);
        this.w.l(e0, this.o, fileReference, this.r);
    }

    private final boolean h0(EnumC18310oS enumC18310oS, FileReference fileReference) {
        return super.Q(enumC18310oS, fileReference) && fileReference.getFileSize() <= B().i3();
    }

    @Override // ir.nasim.C22007uW1
    public void H() {
        if (this.B) {
            return;
        }
        super.H();
    }

    @Override // ir.nasim.C22007uW1
    public void K(MW1 mw1) {
        AbstractC13042fc3.i(mw1, "documentState");
        InterfaceC7857Tm2 interfaceC7857Tm2U = u();
        if (interfaceC7857Tm2U != null) {
            interfaceC7857Tm2U.a(false);
        }
        M(null);
        C11603dH7 c11603dH7C = C();
        if (c11603dH7C != null) {
            c11603dH7C.a(false);
        }
        P(null);
        this.B = false;
        InterfaceC13730gj3 interfaceC13730gj3 = (InterfaceC13730gj3) this.p.getCoroutineContext().a(InterfaceC13730gj3.n0);
        if (interfaceC13730gj3 != null) {
            AbstractC20267rj3.k(interfaceC13730gj3, null, 1, null);
        }
        f0();
        l();
    }

    @Override // ir.nasim.C22007uW1
    public boolean Q(EnumC18310oS enumC18310oS, FileReference fileReference) {
        AbstractC13042fc3.i(enumC18310oS, "autoDownload");
        AbstractC13042fc3.i(fileReference, "fileReference");
        return super.Q(enumC18310oS, fileReference) && fileReference.getFileSize() > B().i3();
    }

    @Override // ir.nasim.SS7, ir.nasim.C22007uW1
    public void R() {
        this.B = false;
        InterfaceC13730gj3 interfaceC13730gj3 = (InterfaceC13730gj3) this.p.getCoroutineContext().a(InterfaceC13730gj3.n0);
        if (interfaceC13730gj3 != null) {
            AbstractC20267rj3.k(interfaceC13730gj3, null, 1, null);
        }
        com.google.android.exoplayer2.E0 e0 = this.t;
        if (e0 != null) {
            this.w.i(e0);
        }
        f0();
        super.R();
        Iterator it = this.s.iterator();
        while (it.hasNext()) {
            ((InterfaceC20718sU7) it.next()).a();
        }
        this.s.clear();
    }

    @Override // ir.nasim.SS7
    protected void U(EnumC18310oS enumC18310oS, FileReference fileReference) {
        AbstractC13042fc3.i(enumC18310oS, "autoDownload");
        AbstractC13042fc3.i(fileReference, "fileReference");
        if (!h0(enumC18310oS, fileReference)) {
            super.U(enumC18310oS, fileReference);
            return;
        }
        com.google.android.exoplayer2.E0 e0B0 = b0();
        this.t = e0B0;
        d0(e0B0, fileReference);
    }

    public final com.google.android.exoplayer2.E0 Z() {
        return this.t;
    }

    @Override // ir.nasim.C22007uW1, ir.nasim.InterfaceC12246eH7
    public void b() {
        Iterator it = Y(r()).iterator();
        while (it.hasNext()) {
            ((AbstractC22597vW1) it.next()).t(x());
        }
    }

    @Override // ir.nasim.C22007uW1, ir.nasim.InterfaceC8091Um2
    public void c(float f) {
        Iterator it = Y(r()).iterator();
        while (it.hasNext()) {
            ((AbstractC22597vW1) it.next()).q(f, x());
        }
    }

    public final com.google.android.exoplayer2.E0 c0() {
        FileReference fileReferenceB;
        InterfaceC13730gj3 interfaceC13730gj3A0 = null;
        if (!this.B) {
            return null;
        }
        com.google.android.exoplayer2.E0 e0 = this.t;
        if (e0 != null) {
            return e0;
        }
        com.google.android.exoplayer2.E0 e0F = IC6.a.f(this.o, this, true);
        this.t = e0F;
        if (e0F != null) {
            e0F.E(this.A);
        }
        if (e0F == null || e0F.p() == 1) {
            K(s().b());
        } else {
            InterfaceC13730gj3 interfaceC13730gj3 = this.D;
            if (interfaceC13730gj3 != null) {
                InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
            }
            e0F.Q0(1.0f);
            e0F.g(0.0f);
            e0F.q();
            InterfaceC18505om2 interfaceC18505om2A = s().b().a();
            C11920dm2 c11920dm2 = interfaceC18505om2A instanceof C11920dm2 ? (C11920dm2) interfaceC18505om2A : null;
            if (c11920dm2 != null && (fileReferenceB = c11920dm2.b()) != null) {
                interfaceC13730gj3A0 = a0(e0F, fileReferenceB);
            }
            this.D = interfaceC13730gj3A0;
        }
        return e0F == null ? this.t : e0F;
    }

    @Override // ir.nasim.C22007uW1, ir.nasim.InterfaceC8091Um2
    public void d(InterfaceC3346Am2 interfaceC3346Am2) {
        AbstractC13042fc3.i(interfaceC3346Am2, "reference");
        InterfaceC18505om2 interfaceC18505om2A = s().b().a();
        AbstractC13042fc3.g(interfaceC18505om2A, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.FileRemoteSource");
        FileReference fileReferenceB = ((C11920dm2) interfaceC18505om2A).b();
        if (fileReferenceB.getFileSize() <= B().i3()) {
            com.google.android.exoplayer2.E0 e0B0 = b0();
            this.t = e0B0;
            d0(e0B0, fileReferenceB);
        }
        Iterator it = Y(r()).iterator();
        while (it.hasNext()) {
            ((AbstractC22597vW1) it.next()).d(interfaceC3346Am2);
        }
    }

    public final void e0(InterfaceC20718sU7 interfaceC20718sU7) {
        AbstractC13042fc3.i(interfaceC20718sU7, "videoDocumentAdapter");
        this.s.add(interfaceC20718sU7);
    }

    @Override // ir.nasim.C22007uW1, ir.nasim.InterfaceC12246eH7
    public void f(float f, int i) {
        for (AbstractC22597vW1 abstractC22597vW1 : Y(r())) {
            N(i / 1024.0f);
            abstractC22597vW1.u(f, x());
        }
    }

    public final void f0() {
        com.google.android.exoplayer2.E0 e0 = this.t;
        if (e0 != null) {
            e0.stop();
            e0.x(0L);
            e0.D(false);
            IC6.a.g(e0);
            e0.V0(this.A);
        }
        this.t = null;
    }

    @Override // ir.nasim.C22007uW1, ir.nasim.InterfaceC8091Um2
    public void g(DX1 dx1) {
        Iterator it = Y(r()).iterator();
        while (it.hasNext()) {
            ((AbstractC22597vW1) it.next()).s(x(), dx1);
        }
    }

    public final void g0() {
        com.google.android.exoplayer2.E0 e0 = this.t;
        if (e0 == null || e0 == null) {
            return;
        }
        HC6.b(IC6.a, e0, null, 2, null);
        e0.V0(this.A);
        this.t = null;
    }

    @Override // ir.nasim.InterfaceC12246eH7
    public void k() {
        Iterator it = Y(r()).iterator();
        while (it.hasNext()) {
            ((AbstractC22597vW1) it.next()).k();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C18927pU7(Context context, AbstractC17757nW1 abstractC17757nW1, C14970in2 c14970in2, String str, C12660ez3 c12660ez3, EG2 eg2, EnumC8893Xt7 enumC8893Xt7) {
        super(c14970in2, abstractC17757nW1);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(abstractC17757nW1, "document");
        AbstractC13042fc3.i(c14970in2, "filesModule");
        AbstractC13042fc3.i(str, "mediaId");
        AbstractC13042fc3.i(c12660ez3, "coroutineScope");
        AbstractC13042fc3.i(eg2, "getVideoStateUseCase");
        this.o = str;
        this.p = c12660ez3;
        this.q = eg2;
        this.r = enumC8893Xt7;
        this.s = new ArrayList();
        InterfaceC19086pl2 interfaceC19086pl2 = (InterfaceC19086pl2) C92.a(context, InterfaceC19086pl2.class);
        this.A = ((InterfaceC8627Wt7) C92.a(context, InterfaceC8627Wt7.class)).l();
        this.u = interfaceC19086pl2.e1();
        this.v = interfaceC19086pl2.Q();
        this.y = interfaceC19086pl2.u();
        this.w = interfaceC19086pl2.c();
        this.x = interfaceC19086pl2.w0();
        this.z = interfaceC19086pl2.r();
    }
}
