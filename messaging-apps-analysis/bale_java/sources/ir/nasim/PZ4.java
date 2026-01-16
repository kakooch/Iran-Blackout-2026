package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class PZ4 {
    public static final PZ4 b = new PZ4("OPERATION_ERROR", 0, LD5.operation_error_snack_bar_message);
    private static final /* synthetic */ PZ4[] c;
    private static final /* synthetic */ F92 d;
    private final int a;

    static {
        PZ4[] pz4ArrA = a();
        c = pz4ArrA;
        d = G92.a(pz4ArrA);
    }

    private PZ4(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ PZ4[] a() {
        return new PZ4[]{b};
    }

    public static PZ4 valueOf(String str) {
        return (PZ4) Enum.valueOf(PZ4.class, str);
    }

    public static PZ4[] values() {
        return (PZ4[]) c.clone();
    }

    public final int j() {
        return this.a;
    }
}
