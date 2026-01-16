package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.at3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC9989at3 {
    public static final EnumC9989at3 a = new EnumC9989at3("FARSI", 0);
    public static final EnumC9989at3 b = new EnumC9989at3("ENGLISH", 1);
    public static final EnumC9989at3 c = new EnumC9989at3("ARABIC", 2);
    public static final EnumC9989at3 d = new EnumC9989at3("AZARI", 3);
    private static final /* synthetic */ EnumC9989at3[] e;
    private static final /* synthetic */ F92 f;

    static {
        EnumC9989at3[] enumC9989at3ArrA = a();
        e = enumC9989at3ArrA;
        f = G92.a(enumC9989at3ArrA);
    }

    private EnumC9989at3(String str, int i) {
    }

    private static final /* synthetic */ EnumC9989at3[] a() {
        return new EnumC9989at3[]{a, b, c, d};
    }

    public static EnumC9989at3 valueOf(String str) {
        return (EnumC9989at3) Enum.valueOf(EnumC9989at3.class, str);
    }

    public static EnumC9989at3[] values() {
        return (EnumC9989at3[]) e.clone();
    }
}
