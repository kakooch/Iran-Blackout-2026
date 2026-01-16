package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.hf2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC14280hf2 {
    public static final EnumC14280hf2 a = new EnumC14280hf2("FAB_UP", 0);
    public static final EnumC14280hf2 b = new EnumC14280hf2("FAB_DOWN", 1);
    private static final /* synthetic */ EnumC14280hf2[] c;
    private static final /* synthetic */ F92 d;

    static {
        EnumC14280hf2[] enumC14280hf2ArrA = a();
        c = enumC14280hf2ArrA;
        d = G92.a(enumC14280hf2ArrA);
    }

    private EnumC14280hf2(String str, int i) {
    }

    private static final /* synthetic */ EnumC14280hf2[] a() {
        return new EnumC14280hf2[]{a, b};
    }

    public static EnumC14280hf2 valueOf(String str) {
        return (EnumC14280hf2) Enum.valueOf(EnumC14280hf2.class, str);
    }

    public static EnumC14280hf2[] values() {
        return (EnumC14280hf2[]) c.clone();
    }
}
