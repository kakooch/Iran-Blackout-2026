package io.sentry;

/* renamed from: io.sentry.q3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C3179q3 implements D {
    private final String a;
    private final String b;

    public C3179q3(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    private AbstractC3099c2 d(AbstractC3099c2 abstractC3099c2) {
        if (abstractC3099c2.C().h() == null) {
            abstractC3099c2.C().v(new io.sentry.protocol.x());
        }
        io.sentry.protocol.x xVarH = abstractC3099c2.C().h();
        if (xVarH != null && xVarH.d() == null && xVarH.e() == null) {
            xVarH.f(this.b);
            xVarH.h(this.a);
        }
        return abstractC3099c2;
    }

    @Override // io.sentry.D
    public L2 b(L2 l2, I i) {
        return (L2) d(l2);
    }

    @Override // io.sentry.D
    public io.sentry.protocol.C c(io.sentry.protocol.C c, I i) {
        return (io.sentry.protocol.C) d(c);
    }

    public C3179q3() {
        this(System.getProperty("java.version"), System.getProperty("java.vendor"));
    }
}
