package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.kO1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC15912kO1 {
    public static final EnumC15912kO1 a = new EnumC15912kO1("OLD", 0);
    public static final EnumC15912kO1 b = new EnumC15912kO1("NEW", 1);
    private static final /* synthetic */ EnumC15912kO1[] c;
    private static final /* synthetic */ F92 d;

    static {
        EnumC15912kO1[] enumC15912kO1ArrA = a();
        c = enumC15912kO1ArrA;
        d = G92.a(enumC15912kO1ArrA);
    }

    private EnumC15912kO1(String str, int i) {
    }

    private static final /* synthetic */ EnumC15912kO1[] a() {
        return new EnumC15912kO1[]{a, b};
    }

    public static EnumC15912kO1 valueOf(String str) {
        return (EnumC15912kO1) Enum.valueOf(EnumC15912kO1.class, str);
    }

    public static EnumC15912kO1[] values() {
        return (EnumC15912kO1[]) c.clone();
    }
}
