package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.oS, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC18310oS {
    public static final EnumC18310oS a = new EnumC18310oS("NEVER", 0);
    public static final EnumC18310oS b = new EnumC18310oS("ON_WIFI", 1);
    public static final EnumC18310oS c = new EnumC18310oS("ON_MOBILE", 2);
    public static final EnumC18310oS d = new EnumC18310oS("ALWAYS", 3);
    private static final /* synthetic */ EnumC18310oS[] e;
    private static final /* synthetic */ F92 f;

    static {
        EnumC18310oS[] enumC18310oSArrA = a();
        e = enumC18310oSArrA;
        f = G92.a(enumC18310oSArrA);
    }

    private EnumC18310oS(String str, int i) {
    }

    private static final /* synthetic */ EnumC18310oS[] a() {
        return new EnumC18310oS[]{a, b, c, d};
    }

    public static EnumC18310oS valueOf(String str) {
        return (EnumC18310oS) Enum.valueOf(EnumC18310oS.class, str);
    }

    public static EnumC18310oS[] values() {
        return (EnumC18310oS[]) e.clone();
    }
}
