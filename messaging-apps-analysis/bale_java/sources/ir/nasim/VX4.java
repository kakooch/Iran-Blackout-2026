package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class VX4 {
    public static final VX4 a = new VX4("NEED_TO_UPDATE", 0);
    private static final /* synthetic */ VX4[] b;
    private static final /* synthetic */ F92 c;

    static {
        VX4[] vx4ArrA = a();
        b = vx4ArrA;
        c = G92.a(vx4ArrA);
    }

    private VX4(String str, int i) {
    }

    private static final /* synthetic */ VX4[] a() {
        return new VX4[]{a};
    }

    public static VX4 valueOf(String str) {
        return (VX4) Enum.valueOf(VX4.class, str);
    }

    public static VX4[] values() {
        return (VX4[]) b.clone();
    }
}
