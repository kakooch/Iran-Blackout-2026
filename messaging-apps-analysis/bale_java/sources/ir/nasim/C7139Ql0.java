package ir.nasim;

import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Build;
import android.os.ext.SdkExtensions;
import java.util.Locale;

/* renamed from: ir.nasim.Ql0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C7139Ql0 {
    public static final C7139Ql0 a = new C7139Ql0();
    public static final int b;
    public static final int c;
    public static final int d;
    public static final int e;

    /* renamed from: ir.nasim.Ql0$a */
    private static final class a {
        public static final a a = new a();

        private a() {
        }

        public final int a(int i) {
            return SdkExtensions.getExtensionVersion(i);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        b = i >= 30 ? a.a.a(30) : 0;
        c = i >= 30 ? a.a.a(31) : 0;
        d = i >= 30 ? a.a.a(33) : 0;
        e = i >= 30 ? a.a.a(1000000) : 0;
    }

    private C7139Ql0() {
    }

    public static final boolean a() {
        return Build.VERSION.SDK_INT >= 25;
    }

    public static final boolean b(String str, String str2) {
        AbstractC13042fc3.i(str, "codename");
        AbstractC13042fc3.i(str2, "buildCodename");
        if (AbstractC13042fc3.d("REL", str2)) {
            return false;
        }
        Locale locale = Locale.ROOT;
        String upperCase = str2.toUpperCase(locale);
        AbstractC13042fc3.h(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        String upperCase2 = str.toUpperCase(locale);
        AbstractC13042fc3.h(upperCase2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return upperCase.compareTo(upperCase2) >= 0;
    }

    public static final boolean c() {
        int i = Build.VERSION.SDK_INT;
        if (i < 31) {
            if (i >= 30) {
                String str = Build.VERSION.CODENAME;
                AbstractC13042fc3.h(str, "CODENAME");
                if (b(TokenNames.S, str)) {
                }
            }
            return false;
        }
        return true;
    }

    public static final boolean d() {
        int i = Build.VERSION.SDK_INT;
        if (i < 33) {
            if (i >= 32) {
                String str = Build.VERSION.CODENAME;
                AbstractC13042fc3.h(str, "CODENAME");
                if (b("Tiramisu", str)) {
                }
            }
            return false;
        }
        return true;
    }
}
