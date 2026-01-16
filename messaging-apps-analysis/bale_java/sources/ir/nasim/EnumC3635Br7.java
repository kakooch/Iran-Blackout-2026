package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Br7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC3635Br7 {
    public static final EnumC3635Br7 a = new EnumC3635Br7("DELETE", 0);
    public static final EnumC3635Br7 b = new EnumC3635Br7("CLOSE", 1);
    private static final /* synthetic */ EnumC3635Br7[] c;
    private static final /* synthetic */ F92 d;

    static {
        EnumC3635Br7[] enumC3635Br7ArrA = a();
        c = enumC3635Br7ArrA;
        d = G92.a(enumC3635Br7ArrA);
    }

    private EnumC3635Br7(String str, int i) {
    }

    private static final /* synthetic */ EnumC3635Br7[] a() {
        return new EnumC3635Br7[]{a, b};
    }

    public static EnumC3635Br7 valueOf(String str) {
        return (EnumC3635Br7) Enum.valueOf(EnumC3635Br7.class, str);
    }

    public static EnumC3635Br7[] values() {
        return (EnumC3635Br7[]) c.clone();
    }
}
