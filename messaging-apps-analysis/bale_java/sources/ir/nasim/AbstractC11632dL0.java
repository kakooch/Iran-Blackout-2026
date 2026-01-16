package ir.nasim;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ir.nasim.dL0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC11632dL0 extends AbstractC10868cL0 {
    public static int g(char c) {
        int iB = AbstractC10868cL0.b(c, 10);
        if (iB >= 0) {
            return iB;
        }
        throw new IllegalArgumentException("Char " + c + " is not a decimal digit");
    }

    public static final boolean h(char c, char c2, boolean z) {
        if (c == c2) {
            return true;
        }
        if (!z) {
            return false;
        }
        char upperCase = Character.toUpperCase(c);
        char upperCase2 = Character.toUpperCase(c2);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    public static String i(char c) {
        return AbstractC10451bd8.a(c);
    }
}
