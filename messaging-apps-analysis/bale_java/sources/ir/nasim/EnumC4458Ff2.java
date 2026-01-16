package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Ff2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class EnumC4458Ff2 {
    public static final EnumC4458Ff2 a = new EnumC4458Ff2("APPROVED", 0);
    public static final EnumC4458Ff2 b = new EnumC4458Ff2("BLOCKED", 1);
    public static final EnumC4458Ff2 c = new EnumC4458Ff2("UNKNOWN", 2);
    private static final /* synthetic */ EnumC4458Ff2[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC4458Ff2[] enumC4458Ff2ArrA = a();
        d = enumC4458Ff2ArrA;
        e = G92.a(enumC4458Ff2ArrA);
    }

    private EnumC4458Ff2(String str, int i) {
    }

    private static final /* synthetic */ EnumC4458Ff2[] a() {
        return new EnumC4458Ff2[]{a, b, c};
    }

    public static EnumC4458Ff2 valueOf(String str) {
        return (EnumC4458Ff2) Enum.valueOf(EnumC4458Ff2.class, str);
    }

    public static EnumC4458Ff2[] values() {
        return (EnumC4458Ff2[]) d.clone();
    }
}
