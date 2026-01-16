package io.sentry;

/* renamed from: io.sentry.u1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3199u1 {
    private io.sentry.protocol.v a;
    private M3 b;
    private M3 c;
    private Boolean d;
    private final C3101d e;

    public C3199u1() {
        this(new io.sentry.protocol.v(), new M3(), null, null, null);
    }

    public C3101d a() {
        return this.e;
    }

    public M3 b() {
        return this.c;
    }

    public Double c() {
        Double dI = this.e.i();
        return Double.valueOf(dI == null ? 0.0d : dI.doubleValue());
    }

    public M3 d() {
        return this.b;
    }

    public io.sentry.protocol.v e() {
        return this.a;
    }

    public Boolean f() {
        return this.d;
    }

    public H3 g() {
        H3 h3 = new H3(this.a, this.b, "default", null, null);
        h3.r("auto");
        return h3;
    }

    public T3 h() {
        return this.e.J();
    }

    public C3199u1(C3199u1 c3199u1) {
        this(c3199u1.e(), c3199u1.d(), c3199u1.b(), c3199u1.a(), c3199u1.f());
    }

    public C3199u1(io.sentry.protocol.v vVar, M3 m3, M3 m32, C3101d c3101d, Boolean bool) {
        this.a = vVar;
        this.b = m3;
        this.c = m32;
        this.e = io.sentry.util.F.e(c3101d, bool, null, null);
        this.d = bool;
    }
}
