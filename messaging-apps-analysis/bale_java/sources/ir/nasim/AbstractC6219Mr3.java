package ir.nasim;

import android.content.Context;
import java.io.File;

/* renamed from: ir.nasim.Mr3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC6219Mr3 {
    public static boolean a = false;
    private static boolean b = false;
    private static boolean c = true;
    private static boolean d = true;
    private static ZK3 f;
    private static YK3 g;
    private static volatile C12584er4 h;
    private static volatile C6461Nq4 i;
    private static ThreadLocal j;
    private static GL e = GL.AUTOMATIC;
    private static XK5 k = new C12133e57();

    public static void b(String str) {
        if (b) {
            g().a(str);
        }
    }

    public static float c(String str) {
        if (b) {
            return g().b(str);
        }
        return 0.0f;
    }

    public static GL d() {
        return e;
    }

    public static boolean e() {
        return d;
    }

    public static XK5 f() {
        return k;
    }

    private static C12278eL3 g() {
        C12278eL3 c12278eL3 = (C12278eL3) j.get();
        if (c12278eL3 != null) {
            return c12278eL3;
        }
        C12278eL3 c12278eL32 = new C12278eL3();
        j.set(c12278eL32);
        return c12278eL32;
    }

    public static boolean h() {
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ File i(Context context) {
        return new File(context.getCacheDir(), "lottie_network_cache");
    }

    public static C6461Nq4 j(Context context) {
        if (!c) {
            return null;
        }
        final Context applicationContext = context.getApplicationContext();
        C6461Nq4 c6461Nq4 = i;
        if (c6461Nq4 == null) {
            synchronized (C6461Nq4.class) {
                try {
                    c6461Nq4 = i;
                    if (c6461Nq4 == null) {
                        YK3 yk3 = g;
                        if (yk3 == null) {
                            yk3 = new YK3() { // from class: ir.nasim.Kr3
                                @Override // ir.nasim.YK3
                                public final File a() {
                                    return AbstractC6219Mr3.i(applicationContext);
                                }
                            };
                        }
                        c6461Nq4 = new C6461Nq4(yk3);
                        i = c6461Nq4;
                    }
                } finally {
                }
            }
        }
        return c6461Nq4;
    }

    public static C12584er4 k(Context context) {
        C12584er4 c12584er4 = h;
        if (c12584er4 == null) {
            synchronized (C12584er4.class) {
                try {
                    c12584er4 = h;
                    if (c12584er4 == null) {
                        C6461Nq4 c6461Nq4J = j(context);
                        ZK3 c18777pE1 = f;
                        if (c18777pE1 == null) {
                            c18777pE1 = new C18777pE1();
                        }
                        c12584er4 = new C12584er4(c6461Nq4J, c18777pE1);
                        h = c12584er4;
                    }
                } finally {
                }
            }
        }
        return c12584er4;
    }
}
