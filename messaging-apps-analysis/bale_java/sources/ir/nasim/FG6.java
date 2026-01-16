package ir.nasim;

/* loaded from: classes.dex */
public interface FG6 {

    public static final class a implements FG6 {
        public static final a a = new a();

        private a() {
        }

        @Override // ir.nasim.FG6
        public int a(int i, int i2, int i3, int i4, int i5, int i6) {
            return (((i - i3) - i4) / 2) - (i2 / 2);
        }

        public String toString() {
            return "Center";
        }
    }

    public static final class b implements FG6 {
        public static final b a = new b();

        private b() {
        }

        @Override // ir.nasim.FG6
        public int a(int i, int i2, int i3, int i4, int i5, int i6) {
            return 0;
        }

        public String toString() {
            return "Start";
        }
    }

    int a(int i, int i2, int i3, int i4, int i5, int i6);
}
