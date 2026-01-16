package ir.nasim;

/* loaded from: classes8.dex */
public interface VI1 {

    public static final class a implements VI1 {
        public static final a a = new a();

        private a() {
        }

        @Override // ir.nasim.VI1
        public boolean a() {
            return b.b(this);
        }

        @Override // ir.nasim.VI1
        public boolean b() {
            return b.f(this);
        }

        @Override // ir.nasim.VI1
        public boolean c() {
            return b.g(this);
        }

        @Override // ir.nasim.VI1
        public boolean d() {
            return b.a(this);
        }

        @Override // ir.nasim.VI1
        public boolean e() {
            return b.e(this);
        }

        @Override // ir.nasim.VI1
        public boolean f() {
            return b.d(this);
        }

        @Override // ir.nasim.VI1
        public boolean g() {
            return b.c(this);
        }
    }

    public static final class b {
        public static boolean a(VI1 vi1) {
            AbstractC13042fc3.i(vi1, "this");
            return false;
        }

        public static boolean b(VI1 vi1) {
            AbstractC13042fc3.i(vi1, "this");
            return false;
        }

        public static boolean c(VI1 vi1) {
            AbstractC13042fc3.i(vi1, "this");
            return false;
        }

        public static boolean d(VI1 vi1) {
            AbstractC13042fc3.i(vi1, "this");
            return false;
        }

        public static boolean e(VI1 vi1) {
            AbstractC13042fc3.i(vi1, "this");
            return false;
        }

        public static boolean f(VI1 vi1) {
            AbstractC13042fc3.i(vi1, "this");
            return false;
        }

        public static boolean g(VI1 vi1) {
            AbstractC13042fc3.i(vi1, "this");
            return true;
        }
    }

    boolean a();

    boolean b();

    boolean c();

    boolean d();

    boolean e();

    boolean f();

    boolean g();
}
