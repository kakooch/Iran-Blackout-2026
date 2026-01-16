package ir.nasim;

/* renamed from: ir.nasim.aL0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC9658aL0 {
    public static char a(long j) {
        char c = (char) j;
        AbstractC4029Dj5.g(((long) c) == j, "Out of range: %s", j);
        return c;
    }

    public static boolean b(char[] cArr, char c) {
        for (char c2 : cArr) {
            if (c2 == c) {
                return true;
            }
        }
        return false;
    }

    public static char c(byte b, byte b2) {
        return (char) ((b << 8) | (b2 & 255));
    }
}
