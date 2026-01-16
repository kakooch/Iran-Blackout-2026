package ir.nasim;

/* loaded from: classes3.dex */
public final class UE2 {
    public static final UE2 h = new UE2(4201, 4096, 1);
    public static final UE2 i = new UE2(1033, 1024, 1);
    public static final UE2 j;
    public static final UE2 k;
    public static final UE2 l;
    public static final UE2 m;
    public static final UE2 n;
    public static final UE2 o;
    private final int[] a;
    private final int[] b;
    private final VE2 c;
    private final VE2 d;
    private final int e;
    private final int f;
    private final int g;

    static {
        UE2 ue2 = new UE2(67, 64, 1);
        j = ue2;
        k = new UE2(19, 16, 1);
        l = new UE2(285, 256, 0);
        UE2 ue22 = new UE2(301, 256, 1);
        m = ue22;
        n = ue22;
        o = ue2;
    }

    public UE2(int i2, int i3, int i4) {
        this.f = i2;
        this.e = i3;
        this.g = i4;
        this.a = new int[i3];
        this.b = new int[i3];
        int i5 = 1;
        for (int i6 = 0; i6 < i3; i6++) {
            this.a[i6] = i5;
            i5 <<= 1;
            if (i5 >= i3) {
                i5 = (i5 ^ i2) & (i3 - 1);
            }
        }
        for (int i7 = 0; i7 < i3 - 1; i7++) {
            this.b[this.a[i7]] = i7;
        }
        this.c = new VE2(this, new int[]{0});
        this.d = new VE2(this, new int[]{1});
    }

    static int a(int i2, int i3) {
        return i2 ^ i3;
    }

    VE2 b(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        if (i3 == 0) {
            return this.c;
        }
        int[] iArr = new int[i2 + 1];
        iArr[0] = i3;
        return new VE2(this, iArr);
    }

    int c(int i2) {
        return this.a[i2];
    }

    public int d() {
        return this.g;
    }

    VE2 e() {
        return this.d;
    }

    public int f() {
        return this.e;
    }

    VE2 g() {
        return this.c;
    }

    int h(int i2) {
        if (i2 != 0) {
            return this.a[(this.e - this.b[i2]) - 1];
        }
        throw new ArithmeticException();
    }

    int i(int i2) {
        if (i2 != 0) {
            return this.b[i2];
        }
        throw new IllegalArgumentException();
    }

    int j(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        int[] iArr = this.a;
        int[] iArr2 = this.b;
        return iArr[(iArr2[i2] + iArr2[i3]) % (this.e - 1)];
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f) + ',' + this.e + ')';
    }
}
