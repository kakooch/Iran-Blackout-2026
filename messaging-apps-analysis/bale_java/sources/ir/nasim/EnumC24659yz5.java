package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.yz5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC24659yz5 {
    public static final EnumC24659yz5 a = new EnumC24659yz5("BACKWARD", 0);
    public static final EnumC24659yz5 b = new EnumC24659yz5("FORWARD", 1);
    private static final /* synthetic */ EnumC24659yz5[] c;
    private static final /* synthetic */ F92 d;

    static {
        EnumC24659yz5[] enumC24659yz5ArrA = a();
        c = enumC24659yz5ArrA;
        d = G92.a(enumC24659yz5ArrA);
    }

    private EnumC24659yz5(String str, int i) {
    }

    private static final /* synthetic */ EnumC24659yz5[] a() {
        return new EnumC24659yz5[]{a, b};
    }

    public static EnumC24659yz5 valueOf(String str) {
        return (EnumC24659yz5) Enum.valueOf(EnumC24659yz5.class, str);
    }

    public static EnumC24659yz5[] values() {
        return (EnumC24659yz5[]) c.clone();
    }
}
