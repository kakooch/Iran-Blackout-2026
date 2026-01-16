package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.on4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC18517on4 {
    public static final EnumC18517on4 a = new EnumC18517on4("Mute", 0);
    public static final EnumC18517on4 b = new EnumC18517on4("UnMute", 1);
    private static final /* synthetic */ EnumC18517on4[] c;
    private static final /* synthetic */ F92 d;

    static {
        EnumC18517on4[] enumC18517on4ArrA = a();
        c = enumC18517on4ArrA;
        d = G92.a(enumC18517on4ArrA);
    }

    private EnumC18517on4(String str, int i) {
    }

    private static final /* synthetic */ EnumC18517on4[] a() {
        return new EnumC18517on4[]{a, b};
    }

    public static EnumC18517on4 valueOf(String str) {
        return (EnumC18517on4) Enum.valueOf(EnumC18517on4.class, str);
    }

    public static EnumC18517on4[] values() {
        return (EnumC18517on4[]) c.clone();
    }
}
