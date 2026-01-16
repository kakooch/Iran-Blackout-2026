package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.eK, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class EnumC12265eK {
    public static final EnumC12265eK a = new EnumC12265eK("ALIGN_ANCHOR", 0);
    public static final EnumC12265eK b = new EnumC12265eK("ALIGN_FIXED", 1);
    private static final /* synthetic */ EnumC12265eK[] c;
    private static final /* synthetic */ F92 d;

    static {
        EnumC12265eK[] enumC12265eKArrA = a();
        c = enumC12265eKArrA;
        d = G92.a(enumC12265eKArrA);
    }

    private EnumC12265eK(String str, int i) {
    }

    private static final /* synthetic */ EnumC12265eK[] a() {
        return new EnumC12265eK[]{a, b};
    }

    public static EnumC12265eK valueOf(String str) {
        return (EnumC12265eK) Enum.valueOf(EnumC12265eK.class, str);
    }

    public static EnumC12265eK[] values() {
        return (EnumC12265eK[]) c.clone();
    }
}
