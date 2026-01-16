package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Gx3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class EnumC4870Gx3 {
    public static final EnumC4870Gx3 a = new EnumC4870Gx3("SYNCHRONIZED", 0);
    public static final EnumC4870Gx3 b = new EnumC4870Gx3("PUBLICATION", 1);
    public static final EnumC4870Gx3 c = new EnumC4870Gx3("NONE", 2);
    private static final /* synthetic */ EnumC4870Gx3[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC4870Gx3[] enumC4870Gx3ArrA = a();
        d = enumC4870Gx3ArrA;
        e = G92.a(enumC4870Gx3ArrA);
    }

    private EnumC4870Gx3(String str, int i) {
    }

    private static final /* synthetic */ EnumC4870Gx3[] a() {
        return new EnumC4870Gx3[]{a, b, c};
    }

    public static EnumC4870Gx3 valueOf(String str) {
        return (EnumC4870Gx3) Enum.valueOf(EnumC4870Gx3.class, str);
    }

    public static EnumC4870Gx3[] values() {
        return (EnumC4870Gx3[]) d.clone();
    }
}
