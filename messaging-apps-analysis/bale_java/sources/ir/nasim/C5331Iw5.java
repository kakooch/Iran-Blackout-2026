package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.Iw5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5331Iw5 extends AbstractC17457n0 {
    public static final a d = new a(null);
    public static final int e = 8;
    private final AbstractC17457n0 c;

    /* renamed from: ir.nasim.Iw5$a */
    public static final class a {
        private a() {
        }

        private final boolean b(AbstractC17457n0 abstractC17457n0) {
            return abstractC17457n0.m() && C8386Vt0.t9();
        }

        private final boolean d(AbstractC17457n0 abstractC17457n0) {
            return (abstractC17457n0 instanceof C13388g85) && C8386Vt0.x9();
        }

        private final boolean e(AbstractC17457n0 abstractC17457n0) {
            return (abstractC17457n0 instanceof C22149uk7) && C8386Vt0.z9();
        }

        private final boolean f(AbstractC17457n0 abstractC17457n0) {
            return (abstractC17457n0 instanceof C23345wl7) && C8386Vt0.B9();
        }

        public final boolean a(AbstractC17457n0 abstractC17457n0) {
            AbstractC13042fc3.i(abstractC17457n0, "<this>");
            return C8386Vt0.v9() && (f(abstractC17457n0) || d(abstractC17457n0) || b(abstractC17457n0) || e(abstractC17457n0));
        }

        public final boolean c(AbstractC24063xz abstractC24063xz) {
            AbstractC13042fc3.i(abstractC24063xz, "<this>");
            AbstractC17457n0 abstractC17457n0H = AbstractC17457n0.h(abstractC24063xz);
            AbstractC13042fc3.h(abstractC17457n0H, "fromMessage(...)");
            return a(abstractC17457n0H);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5331Iw5(C11909dl1 c11909dl1) {
        super(c11909dl1);
        AbstractC13042fc3.i(c11909dl1, "contentRemoteContainer");
        AbstractC24063xz abstractC24063xzC = c11909dl1.c();
        AbstractC13042fc3.g(abstractC24063xzC, "null cannot be cast to non-null type ir.nasim.core.api.ApiProtectedMessage");
        AbstractC17457n0 abstractC17457n0H = AbstractC17457n0.h(((C12793fB) abstractC24063xzC).u());
        AbstractC17457n0 c11558dC7 = null;
        abstractC17457n0H = abstractC17457n0H instanceof C18121o72 ? null : abstractC17457n0H;
        if (abstractC17457n0H != null) {
            c11558dC7 = d.a(abstractC17457n0H) ? abstractC17457n0H : new C11558dC7(new C11909dl1(new C14622iD()));
        }
        this.c = c11558dC7;
    }

    @Override // ir.nasim.InterfaceC25103zk1
    public String b(Context context, int i, String str, boolean z) {
        AbstractC13042fc3.i(context, "context");
        return InterfaceC25103zk1.a.a(context);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC13042fc3.d(C5331Iw5.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.ProtectedContent");
        C5331Iw5 c5331Iw5 = (C5331Iw5) obj;
        return AbstractC13042fc3.d(this.c, c5331Iw5.c) && s() == c5331Iw5.s();
    }

    public int hashCode() {
        AbstractC17457n0 abstractC17457n0 = this.c;
        return ((abstractC17457n0 != null ? abstractC17457n0.hashCode() : 0) * 31) + Boolean.hashCode(s());
    }

    @Override // ir.nasim.AbstractC17457n0
    public C23345wl7 l() {
        AbstractC17457n0 abstractC17457n0 = this.c;
        if (abstractC17457n0 != null) {
            return abstractC17457n0.l();
        }
        return null;
    }

    public final AbstractC17457n0 r() {
        return this.c;
    }

    public final boolean s() {
        return this.c == null;
    }
}
