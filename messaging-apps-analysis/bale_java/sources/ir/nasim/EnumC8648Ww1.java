package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Ww1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class EnumC8648Ww1 {
    public static final EnumC8648Ww1 a = new EnumC8648Ww1("None", 0);
    public static final EnumC8648Ww1 b = new EnumC8648Ww1("Cancelled", 1);
    public static final EnumC8648Ww1 c = new EnumC8648Ww1("Redirected", 2);
    public static final EnumC8648Ww1 d = new EnumC8648Ww1("RedirectCancelled", 3);
    private static final /* synthetic */ EnumC8648Ww1[] e;
    private static final /* synthetic */ F92 f;

    static {
        EnumC8648Ww1[] enumC8648Ww1ArrA = a();
        e = enumC8648Ww1ArrA;
        f = G92.a(enumC8648Ww1ArrA);
    }

    private EnumC8648Ww1(String str, int i) {
    }

    private static final /* synthetic */ EnumC8648Ww1[] a() {
        return new EnumC8648Ww1[]{a, b, c, d};
    }

    public static EnumC8648Ww1 valueOf(String str) {
        return (EnumC8648Ww1) Enum.valueOf(EnumC8648Ww1.class, str);
    }

    public static EnumC8648Ww1[] values() {
        return (EnumC8648Ww1[]) e.clone();
    }
}
