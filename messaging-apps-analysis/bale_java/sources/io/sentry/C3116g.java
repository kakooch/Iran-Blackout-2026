package io.sentry;

import io.sentry.protocol.C3166a;
import io.sentry.protocol.C3167b;
import io.sentry.protocol.C3168c;
import io.sentry.protocol.C3170e;
import io.sentry.protocol.C3173h;
import java.util.Enumeration;
import java.util.Set;

/* renamed from: io.sentry.g, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3116g extends C3168c {
    private final C3168c c;
    private final C3168c d;
    private final C3168c e;
    private final F1 f;

    /* renamed from: io.sentry.g$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[F1.values().length];
            a = iArr;
            try {
                iArr[F1.CURRENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[F1.ISOLATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[F1.GLOBAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public C3116g(C3168c c3168c, C3168c c3168c2, C3168c c3168c3, F1 f1) {
        this.c = c3168c;
        this.d = c3168c2;
        this.e = c3168c3;
        this.f = f1;
    }

    private C3168c A() {
        C3168c c3168c = new C3168c();
        c3168c.l(this.c);
        c3168c.l(this.d);
        c3168c.l(this.e);
        return c3168c;
    }

    private C3168c z() {
        int i = a.a[this.f.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? this.e : this.c : this.d : this.e;
    }

    @Override // io.sentry.protocol.C3168c
    public boolean a(Object obj) {
        return this.c.a(obj) || this.d.a(obj) || this.e.a(obj);
    }

    @Override // io.sentry.protocol.C3168c
    public Set b() {
        return A().b();
    }

    @Override // io.sentry.protocol.C3168c
    public Object c(Object obj) {
        Object objC = this.e.c(obj);
        if (objC != null) {
            return objC;
        }
        Object objC2 = this.d.c(obj);
        return objC2 != null ? objC2 : this.c.c(obj);
    }

    @Override // io.sentry.protocol.C3168c
    public C3166a d() {
        C3166a c3166aD = this.e.d();
        if (c3166aD != null) {
            return c3166aD;
        }
        C3166a c3166aD2 = this.d.d();
        return c3166aD2 != null ? c3166aD2 : this.c.d();
    }

    @Override // io.sentry.protocol.C3168c
    public C3170e e() {
        C3170e c3170eE = this.e.e();
        if (c3170eE != null) {
            return c3170eE;
        }
        C3170e c3170eE2 = this.d.e();
        return c3170eE2 != null ? c3170eE2 : this.c.e();
    }

    @Override // io.sentry.protocol.C3168c
    public io.sentry.protocol.l g() {
        io.sentry.protocol.l lVarG = this.e.g();
        if (lVarG != null) {
            return lVarG;
        }
        io.sentry.protocol.l lVarG2 = this.d.g();
        return lVarG2 != null ? lVarG2 : this.c.g();
    }

    @Override // io.sentry.protocol.C3168c
    public io.sentry.protocol.x h() {
        io.sentry.protocol.x xVarH = this.e.h();
        if (xVarH != null) {
            return xVarH;
        }
        io.sentry.protocol.x xVarH2 = this.d.h();
        return xVarH2 != null ? xVarH2 : this.c.h();
    }

    @Override // io.sentry.protocol.C3168c
    public H3 i() {
        H3 h3I = this.e.i();
        if (h3I != null) {
            return h3I;
        }
        H3 h3I2 = this.d.i();
        return h3I2 != null ? h3I2 : this.c.i();
    }

    @Override // io.sentry.protocol.C3168c
    public Enumeration j() {
        return A().j();
    }

    @Override // io.sentry.protocol.C3168c
    public Object k(String str, Object obj) {
        return z().k(str, obj);
    }

    @Override // io.sentry.protocol.C3168c
    public void l(C3168c c3168c) {
        z().l(c3168c);
    }

    @Override // io.sentry.protocol.C3168c
    public Object m(Object obj) {
        return z().m(obj);
    }

    @Override // io.sentry.protocol.C3168c
    public void n(C3166a c3166a) {
        z().n(c3166a);
    }

    @Override // io.sentry.protocol.C3168c
    public void o(C3167b c3167b) {
        z().o(c3167b);
    }

    @Override // io.sentry.protocol.C3168c
    public void p(C3170e c3170e) {
        z().p(c3170e);
    }

    @Override // io.sentry.protocol.C3168c
    public void r(C3173h c3173h) {
        z().r(c3173h);
    }

    @Override // io.sentry.protocol.C3168c
    public void s(io.sentry.protocol.l lVar) {
        z().s(lVar);
    }

    @Override // io.sentry.protocol.C3168c, io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        A().serialize(interfaceC3123h1, iLogger);
    }

    @Override // io.sentry.protocol.C3168c
    public void u(io.sentry.protocol.n nVar) {
        z().u(nVar);
    }

    @Override // io.sentry.protocol.C3168c
    public void v(io.sentry.protocol.x xVar) {
        z().v(xVar);
    }

    @Override // io.sentry.protocol.C3168c
    public void w(io.sentry.protocol.D d) {
        z().w(d);
    }

    @Override // io.sentry.protocol.C3168c
    public void x(H3 h3) {
        z().x(h3);
    }
}
