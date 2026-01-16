package ir.nasim;

import java.security.GeneralSecurityException;

/* loaded from: classes3.dex */
public abstract class HJ1 {
    public static final String a = new C7354Rj().d();
    public static final AM5 b = AM5.S();
    public static final AM5 c = AM5.S();

    static {
        try {
            a();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void a() {
        KJ1.d();
        if (AbstractC5279Iq7.a()) {
            return;
        }
        C7354Rj.n(true);
    }
}
