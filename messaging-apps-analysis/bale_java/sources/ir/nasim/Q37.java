package ir.nasim;

/* loaded from: classes4.dex */
public interface Q37 {

    public static final class a implements Q37 {
        public static final a a = new a();

        private a() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return 235617469;
        }

        public String toString() {
            return "ActiveAccount";
        }
    }

    public static final class b implements Q37 {
        public static final b a = new b();

        private b() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return -1769185768;
        }

        public String toString() {
            return "InActiveAccount";
        }
    }
}
