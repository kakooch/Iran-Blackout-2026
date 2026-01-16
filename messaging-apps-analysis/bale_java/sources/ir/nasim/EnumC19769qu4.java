package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.qu4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC19769qu4 {
    public static final EnumC19769qu4 a = new EnumC19769qu4("SENT", 0);
    public static final EnumC19769qu4 b = new EnumC19769qu4("RECEIVED", 1);
    public static final EnumC19769qu4 c = new EnumC19769qu4("READ", 2);
    public static final EnumC19769qu4 d = new EnumC19769qu4("UNSUPPORTED_VALUE", 3);
    private static final /* synthetic */ EnumC19769qu4[] e;
    private static final /* synthetic */ F92 f;

    static {
        EnumC19769qu4[] enumC19769qu4ArrA = a();
        e = enumC19769qu4ArrA;
        f = G92.a(enumC19769qu4ArrA);
    }

    private EnumC19769qu4(String str, int i) {
    }

    private static final /* synthetic */ EnumC19769qu4[] a() {
        return new EnumC19769qu4[]{a, b, c, d};
    }

    public static EnumC19769qu4 valueOf(String str) {
        return (EnumC19769qu4) Enum.valueOf(EnumC19769qu4.class, str);
    }

    public static EnumC19769qu4[] values() {
        return (EnumC19769qu4[]) e.clone();
    }
}
