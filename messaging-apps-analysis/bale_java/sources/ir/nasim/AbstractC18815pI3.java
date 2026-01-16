package ir.nasim;

import android.gov.nist.core.Separators;
import android.text.TextUtils;
import android.util.Log;
import java.net.UnknownHostException;

/* renamed from: ir.nasim.pI3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC18815pI3 {
    private static int b = 0;
    private static boolean c = true;
    private static final Object a = new Object();
    private static a d = a.a;

    /* renamed from: ir.nasim.pI3$a */
    public interface a {
        public static final a a = new C1442a();

        /* renamed from: ir.nasim.pI3$a$a, reason: collision with other inner class name */
        class C1442a implements a {
            C1442a() {
            }

            @Override // ir.nasim.AbstractC18815pI3.a
            public void a(String str, String str2) {
                Log.d(str, str2);
            }

            @Override // ir.nasim.AbstractC18815pI3.a
            public void b(String str, String str2) {
                Log.w(str, str2);
            }

            @Override // ir.nasim.AbstractC18815pI3.a
            public void c(String str, String str2) {
                Log.e(str, str2);
            }

            @Override // ir.nasim.AbstractC18815pI3.a
            public void d(String str, String str2) {
                Log.i(str, str2);
            }
        }

        void a(String str, String str2);

        void b(String str, String str2);

        void c(String str, String str2);

        void d(String str, String str2);
    }

    private static String a(String str, Throwable th) {
        String strE = e(th);
        if (TextUtils.isEmpty(strE)) {
            return str;
        }
        return str + "\n  " + strE.replace(Separators.RETURN, "\n  ") + '\n';
    }

    public static void b(String str, String str2) {
        synchronized (a) {
            try {
                if (b == 0) {
                    d.a(str, str2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void c(String str, String str2) {
        synchronized (a) {
            try {
                if (b <= 3) {
                    d.c(str, str2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void d(String str, String str2, Throwable th) {
        c(str, a(str2, th));
    }

    public static String e(Throwable th) {
        synchronized (a) {
            try {
                if (th == null) {
                    return null;
                }
                if (h(th)) {
                    return "UnknownHostException (no network)";
                }
                if (c) {
                    return Log.getStackTraceString(th).trim().replace(Separators.HT, "    ");
                }
                return th.getMessage();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void f(String str, String str2) {
        synchronized (a) {
            try {
                if (b <= 1) {
                    d.d(str, str2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void g(String str, String str2, Throwable th) {
        f(str, a(str2, th));
    }

    private static boolean h(Throwable th) {
        while (th != null) {
            if (th instanceof UnknownHostException) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }

    public static void i(int i) {
        synchronized (a) {
            b = i;
        }
    }

    public static void j(a aVar) {
        synchronized (a) {
            d = aVar;
        }
    }

    public static void k(String str, String str2) {
        synchronized (a) {
            try {
                if (b <= 2) {
                    d.b(str, str2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void l(String str, String str2, Throwable th) {
        k(str, a(str2, th));
    }
}
