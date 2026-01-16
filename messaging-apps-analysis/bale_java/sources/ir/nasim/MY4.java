package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class MY4 {
    public static final MY4 b = new MY4("OPERATION_ERROR", 0, LD5.operation_error_snack_bar_message);
    private static final /* synthetic */ MY4[] c;
    private static final /* synthetic */ F92 d;
    private final int a;

    static {
        MY4[] my4ArrA = a();
        c = my4ArrA;
        d = G92.a(my4ArrA);
    }

    private MY4(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ MY4[] a() {
        return new MY4[]{b};
    }

    public static MY4 valueOf(String str) {
        return (MY4) Enum.valueOf(MY4.class, str);
    }

    public static MY4[] values() {
        return (MY4[]) c.clone();
    }

    public final int j() {
        return this.a;
    }
}
