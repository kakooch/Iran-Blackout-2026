package ir.nasim;

import ir.nasim.C13245fu;

/* renamed from: ir.nasim.Rk7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C7371Rk7 {
    private final C13245fu a;
    private C13245fu b;

    /* renamed from: ir.nasim.Rk7$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C9663aL5 e;
        final /* synthetic */ C13245fu.d f;
        final /* synthetic */ C12863fI6 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C9663aL5 c9663aL5, C13245fu.d dVar, C12863fI6 c12863fI6) {
            super(1);
            this.e = c9663aL5;
            this.f = dVar;
            this.g = c12863fI6;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C13245fu.d invoke(C13245fu.d dVar) {
            C13245fu.d dVar2;
            if (this.e.a && (dVar.g() instanceof C12863fI6) && dVar.h() == this.f.h() && dVar.f() == this.f.f()) {
                C12863fI6 c12863fI6 = this.g;
                if (c12863fI6 == null) {
                    c12863fI6 = new C12863fI6(0L, 0L, (C4593Fu2) null, (C3418Au2) null, (C3657Bu2) null, (AbstractC9998au2) null, (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, (C24525yl7) null, (C5566Jw6) null, (C19620qf5) null, (AbstractC18051o02) null, 65535, (ED1) null);
                }
                dVar2 = new C13245fu.d(c12863fI6, dVar.h(), dVar.f());
            } else {
                dVar2 = dVar;
            }
            this.e.a = AbstractC13042fc3.d(this.f, dVar);
            return dVar2;
        }
    }

    public C7371Rk7(C13245fu c13245fu) {
        this.a = c13245fu;
        this.b = c13245fu;
    }

    public final C13245fu a() {
        return this.b;
    }

    public final void b(C13245fu.d dVar, C12863fI6 c12863fI6) {
        this.b = this.a.q(new a(new C9663aL5(), dVar, c12863fI6));
    }
}
