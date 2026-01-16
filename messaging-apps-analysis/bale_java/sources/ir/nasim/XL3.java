package ir.nasim;

import java.security.GeneralSecurityException;

/* loaded from: classes3.dex */
public abstract class XL3 {
    public static final String a = new C23212wY2().d();
    public static final AM5 b;
    public static final AM5 c;
    public static final AM5 d;

    static {
        AM5 am5S = AM5.S();
        b = am5S;
        c = am5S;
        d = am5S;
        try {
            a();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void a() {
        b();
    }

    public static void b() {
        C10264bM3.d();
        ST0.d();
        C23212wY2.o(true);
        if (AbstractC5279Iq7.a()) {
            return;
        }
        C6134Mi.p(true);
    }
}
