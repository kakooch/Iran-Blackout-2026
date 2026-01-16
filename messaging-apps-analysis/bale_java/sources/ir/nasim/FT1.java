package ir.nasim;

/* loaded from: classes2.dex */
public abstract class FT1 {

    public static final class a extends FT1 {
        public final int a;

        public a(int i) {
            super(null);
            this.a = i;
            if (i <= 0) {
                throw new IllegalArgumentException("px must be > 0.".toString());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && this.a == ((a) obj).a;
        }

        public int hashCode() {
            return this.a;
        }

        public String toString() {
            return String.valueOf(this.a);
        }
    }

    public static final class b extends FT1 {
        public static final b a = new b();

        private b() {
            super(null);
        }

        public String toString() {
            return "Dimension.Undefined";
        }
    }

    private FT1() {
    }

    public /* synthetic */ FT1(ED1 ed1) {
        this();
    }
}
