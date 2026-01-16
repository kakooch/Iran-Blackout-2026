package ir.nasim;

/* renamed from: ir.nasim.fL4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC12888fL4 {
    private final int a;

    /* renamed from: ir.nasim.fL4$a */
    public static final class a extends AbstractC12888fL4 {
        public static final a b = new a();

        private a() {
            super(1, null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return 1400324094;
        }

        public String toString() {
            return "Bubble";
        }
    }

    /* renamed from: ir.nasim.fL4$b */
    public static final class b extends AbstractC12888fL4 {
        public static final b b = new b();

        private b() {
            super(4, null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return -639942152;
        }

        public String toString() {
            return "DeepLink";
        }
    }

    /* renamed from: ir.nasim.fL4$c */
    public static final class c extends AbstractC12888fL4 {
        public static final c b = new c();

        private c() {
            super(3, null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return 1378036579;
        }

        public String toString() {
            return "Pin";
        }
    }

    /* renamed from: ir.nasim.fL4$d */
    public static final class d extends AbstractC12888fL4 {
        public static final d b = new d();

        private d() {
            super(2, null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof d);
        }

        public int hashCode() {
            return -73241481;
        }

        public String toString() {
            return "Profile";
        }
    }

    public /* synthetic */ AbstractC12888fL4(int i, ED1 ed1) {
        this(i);
    }

    public final int a() {
        return this.a;
    }

    private AbstractC12888fL4(int i) {
        this.a = i;
    }
}
