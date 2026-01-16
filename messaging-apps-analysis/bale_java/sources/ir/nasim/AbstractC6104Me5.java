package ir.nasim;

import java.util.logging.Logger;

/* renamed from: ir.nasim.Me5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC6104Me5 {
    private static final Logger a = Logger.getLogger(AbstractC6104Me5.class.getName());
    private static final D15 b = b();

    /* renamed from: ir.nasim.Me5$b */
    private static final class b implements D15 {
        private b() {
        }
    }

    static String a(String str) {
        if (c(str)) {
            return null;
        }
        return str;
    }

    private static D15 b() {
        return new b();
    }

    static boolean c(String str) {
        return str == null || str.isEmpty();
    }
}
