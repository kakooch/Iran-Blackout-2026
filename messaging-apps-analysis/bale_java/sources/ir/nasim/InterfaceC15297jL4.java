package ir.nasim;

/* renamed from: ir.nasim.jL4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC15297jL4 {
    public static final b.c a;
    public static final b.C1313b b;

    /* renamed from: ir.nasim.jL4$b */
    public static abstract class b {

        /* renamed from: ir.nasim.jL4$b$a */
        public static final class a extends b {
            private final Throwable a;

            public a(Throwable th) {
                this.a = th;
            }

            public Throwable a() {
                return this.a;
            }

            public String toString() {
                return String.format("FAILURE (%s)", this.a.getMessage());
            }
        }

        /* renamed from: ir.nasim.jL4$b$b, reason: collision with other inner class name */
        public static final class C1313b extends b {
            public String toString() {
                return "IN_PROGRESS";
            }

            private C1313b() {
            }
        }

        /* renamed from: ir.nasim.jL4$b$c */
        public static final class c extends b {
            public String toString() {
                return "SUCCESS";
            }

            private c() {
            }
        }

        b() {
        }
    }

    static {
        a = new b.c();
        b = new b.C1313b();
    }
}
