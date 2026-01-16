package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Az5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class EnumC3466Az5 {
    public static final EnumC3466Az5 b = new EnumC3466Az5("FINGERPRINT", 0, 1);
    public static final EnumC3466Az5 c = new EnumC3466Az5("PIN", 1, 2);
    private static final /* synthetic */ EnumC3466Az5[] d;
    private static final /* synthetic */ F92 e;
    private final int a;

    static {
        EnumC3466Az5[] enumC3466Az5ArrA = a();
        d = enumC3466Az5ArrA;
        e = G92.a(enumC3466Az5ArrA);
    }

    private EnumC3466Az5(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ EnumC3466Az5[] a() {
        return new EnumC3466Az5[]{b, c};
    }

    public static EnumC3466Az5 valueOf(String str) {
        return (EnumC3466Az5) Enum.valueOf(EnumC3466Az5.class, str);
    }

    public static EnumC3466Az5[] values() {
        return (EnumC3466Az5[]) d.clone();
    }

    public final int j() {
        return this.a;
    }
}
