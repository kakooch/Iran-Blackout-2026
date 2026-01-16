package ir.nasim;

/* renamed from: ir.nasim.c57, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
abstract /* synthetic */ class AbstractC10726c57 {
    private static final int a = Runtime.getRuntime().availableProcessors();

    public static final int a() {
        return a;
    }

    public static final String b(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
