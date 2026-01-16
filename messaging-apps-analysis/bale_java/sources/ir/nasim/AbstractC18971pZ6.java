package ir.nasim;

/* renamed from: ir.nasim.pZ6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
abstract class AbstractC18971pZ6 extends AbstractC18380oZ6 {
    public static Double k(String str) {
        AbstractC13042fc3.i(str, "<this>");
        try {
            if (C3508Bd6.b.g(str)) {
                return Double.valueOf(Double.parseDouble(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Float l(String str) {
        AbstractC13042fc3.i(str, "<this>");
        try {
            if (C3508Bd6.b.g(str)) {
                return Float.valueOf(Float.parseFloat(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
