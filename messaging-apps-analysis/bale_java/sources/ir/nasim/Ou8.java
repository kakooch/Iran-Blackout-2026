package ir.nasim;

/* loaded from: classes3.dex */
public abstract class Ou8 {
    private static final C16237kv8 a = new C16237kv8("SplitInstallInfoProvider");

    public static String a(String str) {
        return str.startsWith("config.") ? "" : str.split("\\.config\\.", 2)[0];
    }

    public static boolean b(String str) {
        return str.startsWith("config.");
    }

    public static boolean c(String str) {
        return str.startsWith("config.") || str.contains(".config.");
    }
}
