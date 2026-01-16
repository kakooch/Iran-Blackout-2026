package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.wP1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC23130wP1 {
    public static final EnumC23130wP1 a = new EnumC23130wP1("SENT", 0);
    public static final EnumC23130wP1 b = new EnumC23130wP1("RECEIVED", 1);
    public static final EnumC23130wP1 c = new EnumC23130wP1("READ", 2);
    private static final /* synthetic */ EnumC23130wP1[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC23130wP1[] enumC23130wP1ArrA = a();
        d = enumC23130wP1ArrA;
        e = G92.a(enumC23130wP1ArrA);
    }

    private EnumC23130wP1(String str, int i) {
    }

    private static final /* synthetic */ EnumC23130wP1[] a() {
        return new EnumC23130wP1[]{a, b, c};
    }

    public static EnumC23130wP1 valueOf(String str) {
        return (EnumC23130wP1) Enum.valueOf(EnumC23130wP1.class, str);
    }

    public static EnumC23130wP1[] values() {
        return (EnumC23130wP1[]) d.clone();
    }
}
