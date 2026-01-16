package ir.nasim;

/* loaded from: classes2.dex */
public interface V05 {
    public static final a a = a.a;

    public static final class a {
        static final /* synthetic */ a a = new a();

        private a() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class b {
        public static final b a = new b("CounterClockwise", 0);
        public static final b b = new b("Clockwise", 1);
        private static final /* synthetic */ b[] c;
        private static final /* synthetic */ F92 d;

        static {
            b[] bVarArrA = a();
            c = bVarArrA;
            d = G92.a(bVarArrA);
        }

        private b(String str, int i) {
        }

        private static final /* synthetic */ b[] a() {
            return new b[]{a, b};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) c.clone();
        }
    }

    static /* synthetic */ void g(V05 v05, V05 v052, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addPath-Uv8p0NA");
        }
        if ((i & 2) != 0) {
            j = ZG4.b.c();
        }
        v05.r(v052, j);
    }

    static /* synthetic */ void o(V05 v05, CK5 ck5, b bVar, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addRect");
        }
        if ((i & 2) != 0) {
            bVar = b.a;
        }
        v05.k(ck5, bVar);
    }

    static /* synthetic */ void p(V05 v05, I46 i46, b bVar, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addRoundRect");
        }
        if ((i & 2) != 0) {
            bVar = b.a;
        }
        v05.l(i46, bVar);
    }

    void a(float f, float f2);

    void b(float f, float f2, float f3, float f4, float f5, float f6);

    void c(float f, float f2);

    void close();

    boolean d();

    void e(float f, float f2);

    void f(float f, float f2, float f3, float f4, float f5, float f6);

    CK5 getBounds();

    void h(int i);

    void i(float f, float f2, float f3, float f4);

    boolean isEmpty();

    void j(long j);

    void k(CK5 ck5, b bVar);

    void l(I46 i46, b bVar);

    boolean m(V05 v05, V05 v052, int i);

    void n(float f, float f2, float f3, float f4);

    int q();

    void r(V05 v05, long j);

    void reset();

    void s(float f, float f2);

    void t();
}
