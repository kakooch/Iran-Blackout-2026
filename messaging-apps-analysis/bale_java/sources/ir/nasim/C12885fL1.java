package ir.nasim;

import android.gov.nist.core.Separators;
import android.os.Build;
import java.util.Locale;

/* renamed from: ir.nasim.fL1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C12885fL1 {
    public static final C12885fL1 a = new C12885fL1();

    private C12885fL1() {
    }

    public static final String a() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        AbstractC13042fc3.f(str2);
        AbstractC13042fc3.f(str);
        if (AbstractC20153rZ6.S(str2, str, false, 2, null)) {
            Locale locale = Locale.getDefault();
            AbstractC13042fc3.h(locale, "getDefault(...)");
            String upperCase = str2.toUpperCase(locale);
            AbstractC13042fc3.h(upperCase, "toUpperCase(...)");
            return upperCase;
        }
        String str3 = str + Separators.SP + str2;
        Locale locale2 = Locale.getDefault();
        AbstractC13042fc3.h(locale2, "getDefault(...)");
        String upperCase2 = str3.toUpperCase(locale2);
        AbstractC13042fc3.h(upperCase2, "toUpperCase(...)");
        return upperCase2;
    }

    public static final float b(float f, boolean z) {
        return (f / 2.54f) * (z ? AbstractC7426Rr.a.l().xdpi : AbstractC7426Rr.a.l().ydpi);
    }

    public static final boolean c() {
        return AbstractC20762sZ6.X(a(), "HUAWEI", false, 2, null) || AbstractC20762sZ6.X(a(), "XIAOMI", false, 2, null);
    }
}
