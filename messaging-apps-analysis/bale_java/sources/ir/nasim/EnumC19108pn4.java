package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.pn4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC19108pn4 {
    public static final EnumC19108pn4 c = new EnumC19108pn4("MUTE", 0, EnumC23487x03.i, FD5.chat_mute);
    public static final EnumC19108pn4 d = new EnumC19108pn4("UN_MUTE", 1, EnumC23487x03.j, FD5.chat_unmute);
    private static final /* synthetic */ EnumC19108pn4[] e;
    private static final /* synthetic */ F92 f;
    private final EnumC23487x03 a;
    private final int b;

    static {
        EnumC19108pn4[] enumC19108pn4ArrA = a();
        e = enumC19108pn4ArrA;
        f = G92.a(enumC19108pn4ArrA);
    }

    private EnumC19108pn4(String str, int i, EnumC23487x03 enumC23487x03, int i2) {
        this.a = enumC23487x03;
        this.b = i2;
    }

    private static final /* synthetic */ EnumC19108pn4[] a() {
        return new EnumC19108pn4[]{c, d};
    }

    public static EnumC19108pn4 valueOf(String str) {
        return (EnumC19108pn4) Enum.valueOf(EnumC19108pn4.class, str);
    }

    public static EnumC19108pn4[] values() {
        return (EnumC19108pn4[]) e.clone();
    }

    public final int j() {
        return this.b;
    }

    public final EnumC23487x03 p() {
        return this.a;
    }
}
