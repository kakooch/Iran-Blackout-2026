package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.lY4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class EnumC16596lY4 {
    public static final EnumC16596lY4 b = new EnumC16596lY4("ERROR", 0, LD5.error_received_info_toast_message);
    private static final /* synthetic */ EnumC16596lY4[] c;
    private static final /* synthetic */ F92 d;
    private final int a;

    static {
        EnumC16596lY4[] enumC16596lY4ArrA = a();
        c = enumC16596lY4ArrA;
        d = G92.a(enumC16596lY4ArrA);
    }

    private EnumC16596lY4(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ EnumC16596lY4[] a() {
        return new EnumC16596lY4[]{b};
    }

    public static EnumC16596lY4 valueOf(String str) {
        return (EnumC16596lY4) Enum.valueOf(EnumC16596lY4.class, str);
    }

    public static EnumC16596lY4[] values() {
        return (EnumC16596lY4[]) c.clone();
    }

    public final int j() {
        return this.a;
    }
}
