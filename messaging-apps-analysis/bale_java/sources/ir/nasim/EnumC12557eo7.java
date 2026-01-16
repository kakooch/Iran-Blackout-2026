package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.eo7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class EnumC12557eo7 {
    public static final EnumC12557eo7 a = new EnumC12557eo7("Shown", 0);
    public static final EnumC12557eo7 b = new EnumC12557eo7("Hidden", 1);
    private static final /* synthetic */ EnumC12557eo7[] c;
    private static final /* synthetic */ F92 d;

    static {
        EnumC12557eo7[] enumC12557eo7ArrA = a();
        c = enumC12557eo7ArrA;
        d = G92.a(enumC12557eo7ArrA);
    }

    private EnumC12557eo7(String str, int i) {
    }

    private static final /* synthetic */ EnumC12557eo7[] a() {
        return new EnumC12557eo7[]{a, b};
    }

    public static EnumC12557eo7 valueOf(String str) {
        return (EnumC12557eo7) Enum.valueOf(EnumC12557eo7.class, str);
    }

    public static EnumC12557eo7[] values() {
        return (EnumC12557eo7[]) c.clone();
    }
}
