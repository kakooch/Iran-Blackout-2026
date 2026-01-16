package ir.nasim;

import android.gov.nist.core.Separators;
import android.os.Build;

/* loaded from: classes5.dex */
public final class Y66 implements X66 {
    public static final Y66 a;
    private static final int b;
    private static final int c;
    private static String d;
    private static volatile long e;

    static {
        Y66 y66 = new Y66();
        a = y66;
        b = Build.VERSION.SDK_INT;
        String strR = AbstractC20507s76.r();
        AbstractC13042fc3.h(strR, "getVersion(...)");
        c = y66.c(strR);
        String str = Build.VERSION.RELEASE;
        AbstractC13042fc3.h(str, "RELEASE");
        d = str;
        e = -1L;
    }

    private Y66() {
    }

    private final long b() {
        Long lValueOf = Long.valueOf(e);
        if (lValueOf.longValue() == -1) {
            lValueOf = null;
        }
        if (lValueOf != null) {
            return lValueOf.longValue();
        }
        synchronized (this) {
            if (e != -1) {
                return e;
            }
            long jO = AbstractC20507s76.o();
            e = jO;
            return jO;
        }
    }

    private final int c(String str) {
        try {
            String strSubstring = str.substring(AbstractC20762sZ6.l0(str, Separators.LPAREN, 0, false, 6, null) + 1, AbstractC20762sZ6.l0(str, Separators.RPAREN, 0, false, 6, null));
            AbstractC13042fc3.h(strSubstring, "substring(...)");
            return Integer.parseInt(strSubstring);
        } catch (Exception e2) {
            C19406qI3.c("MetaDataProviderImpl", "Error in parsing version number", e2);
            return -1;
        }
    }

    @Override // ir.nasim.X66
    public C19018pe4 a() {
        return new C19018pe4(b, c, b(), "Android", d);
    }

    public void d() {
        e = -1L;
    }
}
