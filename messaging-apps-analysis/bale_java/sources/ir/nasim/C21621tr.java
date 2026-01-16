package ir.nasim;

import android.view.Choreographer;
import ir.nasim.C9475a16;
import ir.nasim.InterfaceC11938do1;
import ir.nasim.InterfaceC15522jj4;

/* renamed from: ir.nasim.tr, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C21621tr implements InterfaceC15522jj4 {
    private final Choreographer a;
    private final C20343rr b;

    /* renamed from: ir.nasim.tr$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C20343rr e;
        final /* synthetic */ Choreographer.FrameCallback f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C20343rr c20343rr, Choreographer.FrameCallback frameCallback) {
            super(1);
            this.e = c20343rr;
            this.f = frameCallback;
        }

        public final void a(Throwable th) {
            this.e.h1(this.f);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.tr$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ Choreographer.FrameCallback f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Choreographer.FrameCallback frameCallback) {
            super(1);
            this.f = frameCallback;
        }

        public final void a(Throwable th) {
            C21621tr.this.f().removeFrameCallback(this.f);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.tr$c */
    static final class c implements Choreographer.FrameCallback {
        final /* synthetic */ HE0 a;
        final /* synthetic */ C21621tr b;
        final /* synthetic */ UA2 c;

        c(HE0 he0, C21621tr c21621tr, UA2 ua2) {
            this.a = he0;
            this.b = c21621tr;
            this.c = ua2;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long j) {
            Object objB;
            HE0 he0 = this.a;
            UA2 ua2 = this.c;
            try {
                C9475a16.a aVar = C9475a16.b;
                objB = C9475a16.b(ua2.invoke(Long.valueOf(j)));
            } catch (Throwable th) {
                C9475a16.a aVar2 = C9475a16.b;
                objB = C9475a16.b(AbstractC10685c16.a(th));
            }
            he0.resumeWith(objB);
        }
    }

    public C21621tr(Choreographer choreographer, C20343rr c20343rr) {
        this.a = choreographer;
        this.b = c20343rr;
    }

    @Override // ir.nasim.InterfaceC15522jj4
    public Object G(UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
        C20343rr c20343rr = this.b;
        if (c20343rr == null) {
            InterfaceC11938do1.b bVarA = interfaceC20295rm1.getContext().a(InterfaceC22753vm1.g0);
            c20343rr = bVarA instanceof C20343rr ? (C20343rr) bVarA : null;
        }
        IE0 ie0 = new IE0(AbstractC14251hc3.c(interfaceC20295rm1), 1);
        ie0.w();
        c cVar = new c(ie0, this, ua2);
        if (c20343rr == null || !AbstractC13042fc3.d(c20343rr.R0(), f())) {
            f().postFrameCallback(cVar);
            ie0.J(new b(cVar));
        } else {
            c20343rr.d1(cVar);
            ie0.J(new a(c20343rr, cVar));
        }
        Object objT = ie0.t();
        if (objT == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objT;
    }

    @Override // ir.nasim.InterfaceC11938do1
    public InterfaceC11938do1 X(InterfaceC11938do1 interfaceC11938do1) {
        return InterfaceC15522jj4.a.d(this, interfaceC11938do1);
    }

    @Override // ir.nasim.InterfaceC11938do1.b, ir.nasim.InterfaceC11938do1
    public InterfaceC11938do1.b a(InterfaceC11938do1.c cVar) {
        return InterfaceC15522jj4.a.b(this, cVar);
    }

    public final Choreographer f() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC11938do1
    public Object f0(Object obj, InterfaceC14603iB2 interfaceC14603iB2) {
        return InterfaceC15522jj4.a.a(this, obj, interfaceC14603iB2);
    }

    @Override // ir.nasim.InterfaceC11938do1
    public InterfaceC11938do1 l(InterfaceC11938do1.c cVar) {
        return InterfaceC15522jj4.a.c(this, cVar);
    }
}
