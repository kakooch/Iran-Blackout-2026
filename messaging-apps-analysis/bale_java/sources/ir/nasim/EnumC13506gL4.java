package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.gL4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class EnumC13506gL4 {
    public static final EnumC13506gL4 a = new EnumC13506gL4("PFM_DIAGRAM", 0);
    public static final EnumC13506gL4 b = new EnumC13506gL4("PFM_TEXT", 1);
    private static final /* synthetic */ EnumC13506gL4[] c;
    private static final /* synthetic */ F92 d;

    static {
        EnumC13506gL4[] enumC13506gL4ArrA = a();
        c = enumC13506gL4ArrA;
        d = G92.a(enumC13506gL4ArrA);
    }

    private EnumC13506gL4(String str, int i) {
    }

    private static final /* synthetic */ EnumC13506gL4[] a() {
        return new EnumC13506gL4[]{a, b};
    }

    public static EnumC13506gL4 valueOf(String str) {
        return (EnumC13506gL4) Enum.valueOf(EnumC13506gL4.class, str);
    }

    public static EnumC13506gL4[] values() {
        return (EnumC13506gL4[]) c.clone();
    }
}
