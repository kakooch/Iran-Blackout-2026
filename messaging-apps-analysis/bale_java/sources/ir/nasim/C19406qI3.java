package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.util.Log;
import java.util.Arrays;

/* renamed from: ir.nasim.qI3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19406qI3 {
    public static final C19406qI3 a = new C19406qI3();

    private C19406qI3() {
    }

    public static final void a(String str, String str2, Object... objArr) {
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        AbstractC13042fc3.i(objArr, "args");
        String strH = a.h(str2, new Object[0]);
        C6164Ml2.a.x(new C20606sI3(str, EnumC24843zI3.c, strH, null, 8, null));
        if (AbstractC21784u76.c()) {
            Log.d(str, strH);
        }
    }

    public static final void b(String str, String str2) {
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        c(str, str2, null);
    }

    public static final void c(String str, String str2, Throwable th) {
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        C6164Ml2.a.x(new C20606sI3(str, EnumC24843zI3.f, str2, th));
        if (AbstractC21784u76.c()) {
            if (th == null) {
                C19406qI3 c19406qI3 = a;
                if (str2 == null) {
                    str2 = "unknown message";
                }
                Log.e(str, c19406qI3.f(str2));
                return;
            }
            C19406qI3 c19406qI32 = a;
            if (str2 == null) {
                str2 = "unknown message";
            }
            Log.e(str, c19406qI32.f(str2), th);
        }
    }

    public static final void d(String str, Throwable th) {
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        c(str, null, th);
    }

    public static /* synthetic */ void e(String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            th = null;
        }
        c(str, str2, th);
    }

    private final String f(String str) {
        return Separators.LPAREN + Thread.currentThread().getName() + "): " + str;
    }

    public static final void g(String str, String str2, Object... objArr) {
        String strF;
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        AbstractC13042fc3.i(objArr, "args");
        if (!(!(objArr.length == 0)) || str2 == null) {
            C19406qI3 c19406qI3 = a;
            if (str2 == null) {
                str2 = "unknown message";
            }
            strF = c19406qI3.f(str2);
        } else {
            C19406qI3 c19406qI32 = a;
            DY6 dy6 = DY6.a;
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
            String str3 = String.format(str2, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
            AbstractC13042fc3.h(str3, "format(...)");
            strF = c19406qI32.f(str3);
        }
        C6164Ml2.a.x(new C20606sI3(str, EnumC24843zI3.d, strF, null, 8, null));
        if (AbstractC21784u76.c()) {
            Log.i(str, strF);
        }
    }

    private final String h(String str, Object... objArr) {
        if (!(!(objArr.length == 0)) || str == null || AbstractC20762sZ6.n0(str)) {
            C19406qI3 c19406qI3 = a;
            if (str == null) {
                str = "unknown message";
            }
            return c19406qI3.f(str);
        }
        C19406qI3 c19406qI32 = a;
        DY6 dy6 = DY6.a;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        String str2 = String.format(str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        AbstractC13042fc3.h(str2, "format(...)");
        return c19406qI32.f(str2);
    }

    public static final void i(String str, String str2, Object... objArr) {
        String strF;
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        AbstractC13042fc3.i(objArr, "args");
        if (!(!(objArr.length == 0)) || str2 == null) {
            C19406qI3 c19406qI3 = a;
            if (str2 == null) {
                str2 = "unknown message";
            }
            strF = c19406qI3.f(str2);
        } else {
            C19406qI3 c19406qI32 = a;
            DY6 dy6 = DY6.a;
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
            String str3 = String.format(str2, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
            AbstractC13042fc3.h(str3, "format(...)");
            strF = c19406qI32.f(str3);
        }
        C6164Ml2.a.x(new C20606sI3(str, EnumC24843zI3.b, strF, null, 8, null));
        if (AbstractC21784u76.c()) {
            Log.v(str, strF);
        }
    }

    public static final void j(String str, String str2, Object... objArr) {
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        AbstractC13042fc3.i(objArr, "args");
        String strH = a.h(str2, new Object[0]);
        C6164Ml2.a.x(new C20606sI3(str, EnumC24843zI3.e, strH, null, 8, null));
        if (AbstractC21784u76.c()) {
            Log.w(str, strH);
        }
    }

    public static final void k(String str, String str2, Object... objArr) {
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        AbstractC13042fc3.i(objArr, "args");
        a(str, str2, objArr);
        if (AbstractC21784u76.c()) {
            Log.wtf(str, a.h(str2, new Object[0]));
        }
    }
}
