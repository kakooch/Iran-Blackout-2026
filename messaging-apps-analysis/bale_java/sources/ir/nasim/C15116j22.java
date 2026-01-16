package ir.nasim;

/* renamed from: ir.nasim.j22, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C15116j22 {
    public static final C15116j22 c = new C15116j22(0, 0);
    public static final C15116j22 d = new C15116j22(1, 8);
    public static final C15116j22 e = new C15116j22(2, 10);
    public static final C15116j22 f = new C15116j22(3, 10);
    public static final C15116j22 g = new C15116j22(4, 10);
    public static final C15116j22 h = new C15116j22(5, 10);
    public static final C15116j22 i = new C15116j22(6, 10);
    public static final C15116j22 j = new C15116j22(6, 8);
    private final int a;
    private final int b;

    public C15116j22(int i2, int i3) {
        this.a = i2;
        this.b = i3;
    }

    private static String c(int i2) {
        switch (i2) {
            case 0:
                return "UNSPECIFIED";
            case 1:
                return "SDR";
            case 2:
                return "HDR_UNSPECIFIED";
            case 3:
                return "HLG";
            case 4:
                return "HDR10";
            case 5:
                return "HDR10_PLUS";
            case 6:
                return "DOLBY_VISION";
            default:
                return "<Unknown>";
        }
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return this.a;
    }

    public boolean d() {
        return e() && b() != 1 && a() == 10;
    }

    public boolean e() {
        return (b() == 0 || b() == 2 || a() == 0) ? false : true;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C15116j22)) {
            return false;
        }
        C15116j22 c15116j22 = (C15116j22) obj;
        return this.a == c15116j22.b() && this.b == c15116j22.a();
    }

    public int hashCode() {
        return ((this.a ^ 1000003) * 1000003) ^ this.b;
    }

    public String toString() {
        return "DynamicRange@" + Integer.toHexString(System.identityHashCode(this)) + "{encoding=" + c(this.a) + ", bitDepth=" + this.b + "}";
    }
}
