package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import android.util.Log;
import ir.nasim.AbstractC3795Cj5;

/* renamed from: com.google.android.gms.measurement.internal.d1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2227d1 extends AbstractC2218b2 {
    private char c;
    private long d;
    private String e;
    private final C2217b1 f;
    private final C2217b1 g;
    private final C2217b1 h;
    private final C2217b1 i;
    private final C2217b1 j;
    private final C2217b1 k;
    private final C2217b1 l;
    private final C2217b1 m;
    private final C2217b1 n;

    C2227d1(H1 h1) {
        super(h1);
        this.c = (char) 0;
        this.d = -1L;
        this.f = new C2217b1(this, 6, false, false);
        this.g = new C2217b1(this, 6, true, false);
        this.h = new C2217b1(this, 6, false, true);
        this.i = new C2217b1(this, 5, false, false);
        this.j = new C2217b1(this, 5, true, false);
        this.k = new C2217b1(this, 5, false, true);
        this.l = new C2217b1(this, 4, false, false);
        this.m = new C2217b1(this, 3, false, false);
        this.n = new C2217b1(this, 2, false, false);
    }

    static String A(boolean z, String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String strB = B(z, obj);
        String strB2 = B(z, obj2);
        String strB3 = B(z, obj3);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(strB)) {
            sb.append(str2);
            sb.append(strB);
            str2 = ", ";
        }
        if (TextUtils.isEmpty(strB2)) {
            str3 = str2;
        } else {
            sb.append(str2);
            sb.append(strB2);
        }
        if (!TextUtils.isEmpty(strB3)) {
            sb.append(str3);
            sb.append(strB3);
        }
        return sb.toString();
    }

    static String B(boolean z, Object obj) {
        String className;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        int i = 0;
        if (obj instanceof Long) {
            if (!z) {
                return obj.toString();
            }
            Long l = (Long) obj;
            if (Math.abs(l.longValue()) < 100) {
                return obj.toString();
            }
            String str = obj.toString().charAt(0) == '-' ? "-" : "";
            String strValueOf = String.valueOf(Math.abs(l.longValue()));
            return str + Math.round(Math.pow(10.0d, strValueOf.length() - 1)) + "..." + str + Math.round(Math.pow(10.0d, strValueOf.length()) - 1.0d);
        }
        if (obj instanceof Boolean) {
            return obj.toString();
        }
        if (!(obj instanceof Throwable)) {
            return obj instanceof C2222c1 ? ((C2222c1) obj).a : z ? "-" : obj.toString();
        }
        Throwable th = (Throwable) obj;
        StringBuilder sb = new StringBuilder(z ? th.getClass().getName() : th.toString());
        String strG = G(H1.class.getCanonicalName());
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        while (true) {
            if (i >= length) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i];
            if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && G(className).equals(strG)) {
                sb.append(": ");
                sb.append(stackTraceElement);
                break;
            }
            i++;
        }
        return sb.toString();
    }

    private static String G(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int iLastIndexOf = str.lastIndexOf(46);
        return iLastIndexOf == -1 ? str : str.substring(0, iLastIndexOf);
    }

    protected static Object z(String str) {
        if (str == null) {
            return null;
        }
        return new C2222c1(str);
    }

    protected final String C() {
        String str;
        synchronized (this) {
            try {
                if (this.e == null) {
                    if (this.a.Q() != null) {
                        this.e = this.a.Q();
                    } else {
                        this.e = this.a.z().w();
                    }
                }
                AbstractC3795Cj5.j(this.e);
                str = this.e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    protected final void F(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && Log.isLoggable(C(), i)) {
            Log.println(i, C(), A(false, str, obj, obj2, obj3));
        }
        if (z2 || i < 5) {
            return;
        }
        AbstractC3795Cj5.j(str);
        F1 f1G = this.a.G();
        if (f1G == null) {
            Log.println(6, C(), "Scheduler not set. Not logging error/warn");
        } else {
            if (!f1G.n()) {
                Log.println(6, C(), "Scheduler not initialized. Not logging error/warn");
                return;
            }
            if (i >= 9) {
                i = 8;
            }
            f1G.z(new RunnableC2212a1(this, i, str, obj, obj2, obj3));
        }
    }

    @Override // com.google.android.gms.measurement.internal.AbstractC2218b2
    protected final boolean j() {
        return false;
    }

    public final C2217b1 q() {
        return this.m;
    }

    public final C2217b1 r() {
        return this.f;
    }

    public final C2217b1 s() {
        return this.h;
    }

    public final C2217b1 t() {
        return this.g;
    }

    public final C2217b1 u() {
        return this.l;
    }

    public final C2217b1 v() {
        return this.n;
    }

    public final C2217b1 w() {
        return this.i;
    }

    public final C2217b1 x() {
        return this.k;
    }

    public final C2217b1 y() {
        return this.j;
    }
}
