package ir.nasim;

import java.security.GeneralSecurityException;

/* renamed from: ir.nasim.Di, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC4014Di {
    public static final String a = new C8520Wi().d();
    public static final String b = new C23907xj().d();
    public static final String c = new C4974Hj().d();
    public static final String d = new C17290mj().d();
    public static final String e = new C15601jr3().d();
    public static final String f = new C19147pr3().d();
    public static final String g = new WH0().d();
    public static final String h = new C9821ac8().d();
    public static final AM5 i;
    public static final AM5 j;
    public static final AM5 k;

    static {
        AM5 am5S = AM5.S();
        i = am5S;
        j = am5S;
        k = am5S;
        try {
            a();
        } catch (GeneralSecurityException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }

    public static void a() {
        b();
    }

    public static void b() {
        C4731Gi.d();
        XL3.b();
        C8520Wi.n(true);
        C23907xj.n(true);
        if (AbstractC5279Iq7.a()) {
            return;
        }
        C17290mj.n(true);
        C4974Hj.o(true);
        WH0.n(true);
        C15601jr3.m(true);
        C19147pr3.m(true);
        C9821ac8.n(true);
    }
}
