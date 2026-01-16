package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.cM2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC10879cM2 {
    public static final EnumC10879cM2 a = new EnumC10879cM2("UNKNOWN", 0);
    public static final EnumC10879cM2 b = new EnumC10879cM2("JOINED", 1);
    public static final EnumC10879cM2 c = new EnumC10879cM2("MISSED", 2);
    private static final /* synthetic */ EnumC10879cM2[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC10879cM2[] enumC10879cM2ArrA = a();
        d = enumC10879cM2ArrA;
        e = G92.a(enumC10879cM2ArrA);
    }

    private EnumC10879cM2(String str, int i) {
    }

    private static final /* synthetic */ EnumC10879cM2[] a() {
        return new EnumC10879cM2[]{a, b, c};
    }

    public static EnumC10879cM2 valueOf(String str) {
        return (EnumC10879cM2) Enum.valueOf(EnumC10879cM2.class, str);
    }

    public static EnumC10879cM2[] values() {
        return (EnumC10879cM2[]) d.clone();
    }
}
