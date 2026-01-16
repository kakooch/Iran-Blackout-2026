package ir.nasim;

/* loaded from: classes6.dex */
public abstract class R08 {
    public static final a a = new a(null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static abstract class b {
        public static /* synthetic */ void c(b bVar, long j, Long l, Throwable th, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onCanceled");
            }
            if ((i & 4) != 0) {
                th = null;
            }
            bVar.b(j, l, th);
        }

        public abstract void a(Long l, Throwable th);

        public void b(long j, Long l, Throwable th) {
            a(l, th);
        }

        public abstract void d();

        public void e(long j) {
            d();
        }

        public abstract void f(long j);

        public void g(long j, long j2) {
            f(j2);
        }

        public abstract void h(long j);

        public void i(long j, long j2) {
            h(j2);
        }

        public abstract void j();

        public void k(long j) {
            j();
        }

        public abstract void l(long j);

        public void m(long j, long j2) {
            l(j2);
        }
    }

    public abstract void a();

    public abstract void b();

    public abstract void c();

    public abstract void d();

    public final void e() {
        f();
    }

    public abstract long f();

    public abstract void g();
}
