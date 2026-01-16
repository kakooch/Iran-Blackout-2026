package ir.nasim;

/* renamed from: ir.nasim.em1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C12531em1 {
    private final InterfaceC9102Ym4 a;

    /* renamed from: ir.nasim.em1$a */
    public static abstract class a {

        /* renamed from: ir.nasim.em1$a$a, reason: collision with other inner class name */
        public static final class C1060a extends a {
            public static final C1060a a = new C1060a();

            private C1060a() {
                super(null);
            }

            public String toString() {
                return "Closed";
            }
        }

        /* renamed from: ir.nasim.em1$a$b */
        public static final class b extends a {
            private final long a;

            public /* synthetic */ b(long j, ED1 ed1) {
                this(j);
            }

            public final long a() {
                return this.a;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof b) {
                    return ZG4.j(this.a, ((b) obj).a);
                }
                return false;
            }

            public int hashCode() {
                return ZG4.o(this.a);
            }

            public String toString() {
                return "Open(offset=" + ((Object) ZG4.s(this.a)) + ')';
            }

            private b(long j) {
                super(null);
                this.a = j;
                if ((j & 9223372034707292159L) != 9205357640488583168L) {
                    return;
                }
                P73.c("ContextMenuState.Status should never be open with an unspecified offset. Use ContextMenuState.Status.Closed instead.");
            }
        }

        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C12531em1(a aVar) {
        this.a = AbstractC13472gH6.d(aVar, null, 2, null);
    }

    public final a a() {
        return (a) this.a.getValue();
    }

    public final void b(a aVar) {
        this.a.setValue(aVar);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C12531em1) {
            return AbstractC13042fc3.d(((C12531em1) obj).a(), a());
        }
        return false;
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return "ContextMenuState(status=" + a() + ')';
    }

    public /* synthetic */ C12531em1(a aVar, int i, ED1 ed1) {
        this((i & 1) != 0 ? a.C1060a.a : aVar);
    }
}
