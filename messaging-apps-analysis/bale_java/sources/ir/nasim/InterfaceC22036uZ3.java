package ir.nasim;

/* renamed from: ir.nasim.uZ3, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public interface InterfaceC22036uZ3 {

    /* renamed from: ir.nasim.uZ3$a */
    public static final class a implements InterfaceC22036uZ3 {
        public static final a a = new a();

        private a() {
        }

        @Override // ir.nasim.InterfaceC22036uZ3
        public float a() {
            return 1.0f;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return 1542913302;
        }

        public String toString() {
            return "Max";
        }
    }

    /* renamed from: ir.nasim.uZ3$b */
    public static final class b implements InterfaceC22036uZ3 {
        public static final b a = new b();

        private b() {
        }

        @Override // ir.nasim.InterfaceC22036uZ3
        public float a() {
            return 0.0f;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return 1542913540;
        }

        public String toString() {
            return "Min";
        }
    }

    float a();
}
