package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.sM, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC20638sM {
    public static final EnumC20638sM a = new EnumC20638sM("PLAYING", 0);
    public static final EnumC20638sM b = new EnumC20638sM("PAUSED", 1);
    private static final /* synthetic */ EnumC20638sM[] c;
    private static final /* synthetic */ F92 d;

    static {
        EnumC20638sM[] enumC20638sMArrA = a();
        c = enumC20638sMArrA;
        d = G92.a(enumC20638sMArrA);
    }

    private EnumC20638sM(String str, int i) {
    }

    private static final /* synthetic */ EnumC20638sM[] a() {
        return new EnumC20638sM[]{a, b};
    }

    public static EnumC20638sM valueOf(String str) {
        return (EnumC20638sM) Enum.valueOf(EnumC20638sM.class, str);
    }

    public static EnumC20638sM[] values() {
        return (EnumC20638sM[]) c.clone();
    }
}
