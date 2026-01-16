package ir.nasim;

import ir.nasim.C22568vT;
import ir.nasim.V45;

/* loaded from: classes3.dex */
public abstract class W45 {
    public static W45 a = a().a();

    public static abstract class a {
        public abstract W45 a();

        public abstract a b(String str);

        public abstract a c(long j);

        public abstract a d(String str);

        public abstract a e(String str);

        public abstract a f(String str);

        public abstract a g(V45.a aVar);

        public abstract a h(long j);
    }

    public static a a() {
        return new C22568vT.b().h(0L).g(V45.a.ATTEMPT_MIGRATION).c(0L);
    }

    public abstract String b();

    public abstract long c();

    public abstract String d();

    public abstract String e();

    public abstract String f();

    public abstract V45.a g();

    public abstract long h();

    public boolean i() {
        return g() == V45.a.REGISTER_ERROR;
    }

    public boolean j() {
        return g() == V45.a.NOT_GENERATED || g() == V45.a.ATTEMPT_MIGRATION;
    }

    public boolean k() {
        return g() == V45.a.REGISTERED;
    }

    public boolean l() {
        return g() == V45.a.UNREGISTERED;
    }

    public boolean m() {
        return g() == V45.a.ATTEMPT_MIGRATION;
    }

    public abstract a n();

    public W45 o(String str, long j, long j2) {
        return n().b(str).c(j).h(j2).a();
    }

    public W45 p() {
        return n().b(null).a();
    }

    public W45 q(String str) {
        return n().e(str).g(V45.a.REGISTER_ERROR).a();
    }

    public W45 r() {
        return n().g(V45.a.NOT_GENERATED).a();
    }

    public W45 s(String str, String str2, long j, String str3, long j2) {
        return n().d(str).g(V45.a.REGISTERED).b(str3).f(str2).c(j2).h(j).a();
    }

    public W45 t(String str) {
        return n().d(str).g(V45.a.UNREGISTERED).a();
    }
}
