package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class NY4 {
    public static final NY4 b = new NY4("UPDATE_INFORMATION", 0, LD5.information_updated_successfully);
    public static final NY4 c = new NY4("ERROR", 1, LD5.error_received_info_toast_message);
    private static final /* synthetic */ NY4[] d;
    private static final /* synthetic */ F92 e;
    private final int a;

    static {
        NY4[] ny4ArrA = a();
        d = ny4ArrA;
        e = G92.a(ny4ArrA);
    }

    private NY4(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ NY4[] a() {
        return new NY4[]{b, c};
    }

    public static NY4 valueOf(String str) {
        return (NY4) Enum.valueOf(NY4.class, str);
    }

    public static NY4[] values() {
        return (NY4[]) d.clone();
    }

    public final int j() {
        return this.a;
    }
}
