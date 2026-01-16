package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.og5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class EnumC18448og5 {
    public static final EnumC18448og5 a = new EnumC18448og5("NORMAL", 0);
    public static final EnumC18448og5 b = new EnumC18448og5("FAST_FORWARD", 1);
    public static final EnumC18448og5 c = new EnumC18448og5("FAST_BACKWARD", 2);
    private static final /* synthetic */ EnumC18448og5[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC18448og5[] enumC18448og5ArrA = a();
        d = enumC18448og5ArrA;
        e = G92.a(enumC18448og5ArrA);
    }

    private EnumC18448og5(String str, int i) {
    }

    private static final /* synthetic */ EnumC18448og5[] a() {
        return new EnumC18448og5[]{a, b, c};
    }

    public static EnumC18448og5 valueOf(String str) {
        return (EnumC18448og5) Enum.valueOf(EnumC18448og5.class, str);
    }

    public static EnumC18448og5[] values() {
        return (EnumC18448og5[]) d.clone();
    }
}
