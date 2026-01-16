package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Sd6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class EnumC7541Sd6 {
    public static final EnumC7541Sd6 a = new EnumC7541Sd6("HORIZONTAL", 0);
    public static final EnumC7541Sd6 b = new EnumC7541Sd6("VERTICAL", 1);
    private static final /* synthetic */ EnumC7541Sd6[] c;
    private static final /* synthetic */ F92 d;

    static {
        EnumC7541Sd6[] enumC7541Sd6ArrA = a();
        c = enumC7541Sd6ArrA;
        d = G92.a(enumC7541Sd6ArrA);
    }

    private EnumC7541Sd6(String str, int i) {
    }

    private static final /* synthetic */ EnumC7541Sd6[] a() {
        return new EnumC7541Sd6[]{a, b};
    }

    public static EnumC7541Sd6 valueOf(String str) {
        return (EnumC7541Sd6) Enum.valueOf(EnumC7541Sd6.class, str);
    }

    public static EnumC7541Sd6[] values() {
        return (EnumC7541Sd6[]) c.clone();
    }
}
