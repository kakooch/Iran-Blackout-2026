package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.fK, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class EnumC12874fK {
    public static final EnumC12874fK a = new EnumC12874fK("ALIGN_BALLOON", 0);
    public static final EnumC12874fK b = new EnumC12874fK("ALIGN_ANCHOR", 1);
    private static final /* synthetic */ EnumC12874fK[] c;
    private static final /* synthetic */ F92 d;

    static {
        EnumC12874fK[] enumC12874fKArrA = a();
        c = enumC12874fKArrA;
        d = G92.a(enumC12874fKArrA);
    }

    private EnumC12874fK(String str, int i) {
    }

    private static final /* synthetic */ EnumC12874fK[] a() {
        return new EnumC12874fK[]{a, b};
    }

    public static EnumC12874fK valueOf(String str) {
        return (EnumC12874fK) Enum.valueOf(EnumC12874fK.class, str);
    }

    public static EnumC12874fK[] values() {
        return (EnumC12874fK[]) c.clone();
    }
}
