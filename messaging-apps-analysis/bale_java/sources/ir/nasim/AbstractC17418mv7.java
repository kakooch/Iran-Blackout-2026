package ir.nasim;

/* renamed from: ir.nasim.mv7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC17418mv7 {

    /* renamed from: ir.nasim.mv7$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ androidx.lifecycle.s e;
        final /* synthetic */ C9663aL5 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(androidx.lifecycle.s sVar, C9663aL5 c9663aL5) {
            super(1);
            this.e = sVar;
            this.f = c9663aL5;
        }

        public final void a(Object obj) {
            Object objF = this.e.f();
            if (this.f.a || ((objF == null && obj != null) || !(objF == null || AbstractC13042fc3.d(objF, obj)))) {
                this.f.a = false;
                this.e.p(obj);
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.mv7$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ androidx.lifecycle.s e;
        final /* synthetic */ UA2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(androidx.lifecycle.s sVar, UA2 ua2) {
            super(1);
            this.e = sVar;
            this.f = ua2;
        }

        public final void a(Object obj) {
            this.e.p(this.f.invoke(obj));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.mv7$c */
    static final class c implements QG4, InterfaceC22409vB2 {
        private final /* synthetic */ UA2 a;

        c(UA2 ua2) {
            AbstractC13042fc3.i(ua2, "function");
            this.a = ua2;
        }

        @Override // ir.nasim.QG4
        public final /* synthetic */ void a(Object obj) {
            this.a.invoke(obj);
        }

        @Override // ir.nasim.InterfaceC22409vB2
        public final InterfaceC18751pB2 b() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof QG4) && (obj instanceof InterfaceC22409vB2)) {
                return AbstractC13042fc3.d(b(), ((InterfaceC22409vB2) obj).b());
            }
            return false;
        }

        public final int hashCode() {
            return b().hashCode();
        }
    }

    public static final androidx.lifecycle.r a(androidx.lifecycle.r rVar) {
        androidx.lifecycle.s sVar;
        AbstractC13042fc3.i(rVar, "<this>");
        C9663aL5 c9663aL5 = new C9663aL5();
        c9663aL5.a = true;
        if (rVar.i()) {
            c9663aL5.a = false;
            sVar = new androidx.lifecycle.s(rVar.f());
        } else {
            sVar = new androidx.lifecycle.s();
        }
        sVar.q(rVar, new c(new a(sVar, c9663aL5)));
        return sVar;
    }

    public static final androidx.lifecycle.r b(androidx.lifecycle.r rVar, UA2 ua2) {
        AbstractC13042fc3.i(rVar, "<this>");
        AbstractC13042fc3.i(ua2, "transform");
        androidx.lifecycle.s sVar = rVar.i() ? new androidx.lifecycle.s(ua2.invoke(rVar.f())) : new androidx.lifecycle.s();
        sVar.q(rVar, new c(new b(sVar, ua2)));
        return sVar;
    }
}
