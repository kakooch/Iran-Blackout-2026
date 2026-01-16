package ir.nasim;

/* renamed from: ir.nasim.tV3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC21343tV3 {
    static int a(String str, int i) {
        if (i >= 0) {
            return i;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 27);
        sb.append(str);
        sb.append(" (");
        sb.append(i);
        sb.append(") must be >= 0");
        throw new IllegalArgumentException(sb.toString());
    }

    static void b(boolean z) {
        if (!z) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
