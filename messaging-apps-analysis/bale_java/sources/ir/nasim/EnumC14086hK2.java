package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.hK2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class EnumC14086hK2 {
    public static final EnumC14086hK2 a = new EnumC14086hK2("THIN", 0);
    public static final EnumC14086hK2 b = new EnumC14086hK2("THICK", 1);
    private static final /* synthetic */ EnumC14086hK2[] c;
    private static final /* synthetic */ F92 d;

    static {
        EnumC14086hK2[] enumC14086hK2ArrA = a();
        c = enumC14086hK2ArrA;
        d = G92.a(enumC14086hK2ArrA);
    }

    private EnumC14086hK2(String str, int i) {
    }

    private static final /* synthetic */ EnumC14086hK2[] a() {
        return new EnumC14086hK2[]{a, b};
    }

    public static EnumC14086hK2 valueOf(String str) {
        return (EnumC14086hK2) Enum.valueOf(EnumC14086hK2.class, str);
    }

    public static EnumC14086hK2[] values() {
        return (EnumC14086hK2[]) c.clone();
    }
}
