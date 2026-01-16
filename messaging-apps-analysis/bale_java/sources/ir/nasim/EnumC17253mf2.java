package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.mf2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC17253mf2 {
    public static final EnumC17253mf2 a = new EnumC17253mf2("SEND", 0);
    public static final EnumC17253mf2 b = new EnumC17253mf2("SHOW", 1);
    private static final /* synthetic */ EnumC17253mf2[] c;
    private static final /* synthetic */ F92 d;

    static {
        EnumC17253mf2[] enumC17253mf2ArrA = a();
        c = enumC17253mf2ArrA;
        d = G92.a(enumC17253mf2ArrA);
    }

    private EnumC17253mf2(String str, int i) {
    }

    private static final /* synthetic */ EnumC17253mf2[] a() {
        return new EnumC17253mf2[]{a, b};
    }

    public static EnumC17253mf2 valueOf(String str) {
        return (EnumC17253mf2) Enum.valueOf(EnumC17253mf2.class, str);
    }

    public static EnumC17253mf2[] values() {
        return (EnumC17253mf2[]) c.clone();
    }
}
