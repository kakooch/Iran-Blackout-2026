package io.sentry;

/* loaded from: classes3.dex */
public final class W3 extends H3 {
    private static final io.sentry.protocol.F r = io.sentry.protocol.F.CUSTOM;
    private String n;
    private io.sentry.protocol.F o;
    private V3 p;
    private boolean q;

    public W3(String str, String str2) {
        this(str, str2, (V3) null);
    }

    public static W3 v(C3199u1 c3199u1) {
        Boolean boolF = c3199u1.f();
        C3101d c3101dA = c3199u1.a();
        return new W3(c3199u1.e(), c3199u1.d(), c3199u1.b(), boolF == null ? null : new V3(boolF, c3101dA.j(), c3199u1.c()), c3101dA);
    }

    public String w() {
        return this.n;
    }

    public V3 x() {
        return this.p;
    }

    public io.sentry.protocol.F y() {
        return this.o;
    }

    public void z(boolean z) {
        this.q = z;
    }

    public W3(String str, io.sentry.protocol.F f, String str2) {
        this(str, f, str2, null);
    }

    public W3(String str, String str2, V3 v3) {
        this(str, io.sentry.protocol.F.CUSTOM, str2, v3);
    }

    public W3(String str, io.sentry.protocol.F f, String str2, V3 v3) {
        super(str2);
        this.q = false;
        this.n = (String) io.sentry.util.u.c(str, "name is required");
        this.o = f;
        s(v3);
        this.m = io.sentry.util.F.d(null, v3);
    }

    public W3(io.sentry.protocol.v vVar, M3 m3, M3 m32, V3 v3, C3101d c3101d) {
        super(vVar, m3, "default", m32, null);
        this.q = false;
        this.n = "<unlabeled transaction>";
        this.p = v3;
        this.o = r;
        this.m = io.sentry.util.F.d(c3101d, v3);
    }
}
