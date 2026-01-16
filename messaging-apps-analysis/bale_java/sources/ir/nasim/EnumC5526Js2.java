package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Js2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC5526Js2 {
    public static final EnumC5526Js2 a = new EnumC5526Js2("ADD", 0);
    public static final EnumC5526Js2 b = new EnumC5526Js2("DELETE", 1);
    public static final EnumC5526Js2 c = new EnumC5526Js2("CREATE", 2);
    private static final /* synthetic */ EnumC5526Js2[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC5526Js2[] enumC5526Js2ArrA = a();
        d = enumC5526Js2ArrA;
        e = G92.a(enumC5526Js2ArrA);
    }

    private EnumC5526Js2(String str, int i) {
    }

    private static final /* synthetic */ EnumC5526Js2[] a() {
        return new EnumC5526Js2[]{a, b, c};
    }

    public static EnumC5526Js2 valueOf(String str) {
        return (EnumC5526Js2) Enum.valueOf(EnumC5526Js2.class, str);
    }

    public static EnumC5526Js2[] values() {
        return (EnumC5526Js2[]) d.clone();
    }
}
