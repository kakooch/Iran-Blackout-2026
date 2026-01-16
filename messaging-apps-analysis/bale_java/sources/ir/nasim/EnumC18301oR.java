package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.oR, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class EnumC18301oR {
    public static final EnumC18301oR b = new EnumC18301oR("CREATE", 0, 1);
    public static final EnumC18301oR c = new EnumC18301oR("VALIDATE", 1, 2);
    public static final EnumC18301oR d = new EnumC18301oR("FORGET_REQUEST_OTP", 2, 3);
    public static final EnumC18301oR e = new EnumC18301oR("FORGET_SUBMIT_OTP", 3, 4);
    private static final /* synthetic */ EnumC18301oR[] f;
    private static final /* synthetic */ F92 g;
    private final int a;

    static {
        EnumC18301oR[] enumC18301oRArrA = a();
        f = enumC18301oRArrA;
        g = G92.a(enumC18301oRArrA);
    }

    private EnumC18301oR(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ EnumC18301oR[] a() {
        return new EnumC18301oR[]{b, c, d, e};
    }

    public static EnumC18301oR valueOf(String str) {
        return (EnumC18301oR) Enum.valueOf(EnumC18301oR.class, str);
    }

    public static EnumC18301oR[] values() {
        return (EnumC18301oR[]) f.clone();
    }

    public final int j() {
        return this.a;
    }
}
