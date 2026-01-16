package ir.nasim;

import android.graphics.Rect;
import ir.nasim.InterfaceC7920Tt2;

/* renamed from: ir.nasim.pU2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C18922pU2 implements InterfaceC7920Tt2 {
    public static final a d = new a(null);
    private final C3565Bk0 a;
    private final b b;
    private final InterfaceC7920Tt2.b c;

    /* renamed from: ir.nasim.pU2$a */
    public static final class a {
        private a() {
        }

        public final void a(C3565Bk0 c3565Bk0) {
            AbstractC13042fc3.i(c3565Bk0, "bounds");
            if (c3565Bk0.d() == 0 && c3565Bk0.a() == 0) {
                throw new IllegalArgumentException("Bounds must be non zero".toString());
            }
            if (c3565Bk0.b() != 0 && c3565Bk0.c() != 0) {
                throw new IllegalArgumentException("Bounding rectangle must start at the top or left window edge for folding features".toString());
            }
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.pU2$b */
    public static final class b {
        public static final a b = new a(null);
        private static final b c = new b("FOLD");
        private static final b d = new b("HINGE");
        private final String a;

        /* renamed from: ir.nasim.pU2$b$a */
        public static final class a {
            private a() {
            }

            public final b a() {
                return b.c;
            }

            public final b b() {
                return b.d;
            }

            public /* synthetic */ a(ED1 ed1) {
                this();
            }
        }

        private b(String str) {
            this.a = str;
        }

        public String toString() {
            return this.a;
        }
    }

    public C18922pU2(C3565Bk0 c3565Bk0, b bVar, InterfaceC7920Tt2.b bVar2) {
        AbstractC13042fc3.i(c3565Bk0, "featureBounds");
        AbstractC13042fc3.i(bVar, "type");
        AbstractC13042fc3.i(bVar2, "state");
        this.a = c3565Bk0;
        this.b = bVar;
        this.c = bVar2;
        d.a(c3565Bk0);
    }

    @Override // ir.nasim.InterfaceC7920Tt2
    public InterfaceC7920Tt2.a a() {
        return this.a.d() > this.a.a() ? InterfaceC7920Tt2.a.d : InterfaceC7920Tt2.a.c;
    }

    @Override // ir.nasim.InterfaceC7920Tt2
    public boolean b() {
        b bVar = this.b;
        b.a aVar = b.b;
        if (AbstractC13042fc3.d(bVar, aVar.b())) {
            return true;
        }
        return AbstractC13042fc3.d(this.b, aVar.a()) && AbstractC13042fc3.d(c(), InterfaceC7920Tt2.b.d);
    }

    public InterfaceC7920Tt2.b c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC13042fc3.d(C18922pU2.class, obj == null ? null : obj.getClass())) {
            return false;
        }
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.window.layout.HardwareFoldingFeature");
        }
        C18922pU2 c18922pU2 = (C18922pU2) obj;
        return AbstractC13042fc3.d(this.a, c18922pU2.a) && AbstractC13042fc3.d(this.b, c18922pU2.b) && AbstractC13042fc3.d(c(), c18922pU2.c());
    }

    @Override // ir.nasim.InterfaceC20721sV1
    public Rect getBounds() {
        return this.a.f();
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + c().hashCode();
    }

    public String toString() {
        return ((Object) C18922pU2.class.getSimpleName()) + " { " + this.a + ", type=" + this.b + ", state=" + c() + " }";
    }
}
