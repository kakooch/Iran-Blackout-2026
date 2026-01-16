package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.pV, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class EnumC18928pV {
    public static final EnumC18928pV a = new EnumC18928pV("UNSEEN", 0);
    public static final EnumC18928pV b = new EnumC18928pV("SEEN", 1);
    public static final EnumC18928pV c = new EnumC18928pV("NORMAL", 2);
    public static final EnumC18928pV d = new EnumC18928pV("CALLING", 3);
    public static final EnumC18928pV e = new EnumC18928pV("STREAMING", 4);
    private static final /* synthetic */ EnumC18928pV[] f;
    private static final /* synthetic */ F92 g;

    static {
        EnumC18928pV[] enumC18928pVArrA = a();
        f = enumC18928pVArrA;
        g = G92.a(enumC18928pVArrA);
    }

    private EnumC18928pV(String str, int i) {
    }

    private static final /* synthetic */ EnumC18928pV[] a() {
        return new EnumC18928pV[]{a, b, c, d, e};
    }

    public static EnumC18928pV valueOf(String str) {
        return (EnumC18928pV) Enum.valueOf(EnumC18928pV.class, str);
    }

    public static EnumC18928pV[] values() {
        return (EnumC18928pV[]) f.clone();
    }
}
