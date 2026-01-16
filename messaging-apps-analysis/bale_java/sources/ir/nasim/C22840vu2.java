package ir.nasim;

import java.util.Arrays;

/* renamed from: ir.nasim.vu2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C22840vu2 implements InterfaceC21654tu2 {
    public static final a c = new a(null);
    public static final int d = 8;
    private final float[] a;
    private final float[] b;

    /* renamed from: ir.nasim.vu2$a */
    public static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float b(float f, float[] fArr, float[] fArr2) {
            float f2;
            float f3;
            float f4;
            float fA;
            float fAbs = Math.abs(f);
            float fSignum = Math.signum(f);
            int iBinarySearch = Arrays.binarySearch(fArr, fAbs);
            if (iBinarySearch >= 0) {
                fA = fArr2[iBinarySearch];
            } else {
                int i = -(iBinarySearch + 1);
                int i2 = i - 1;
                float f5 = 0.0f;
                if (i2 >= fArr.length - 1) {
                    float f6 = fArr[fArr.length - 1];
                    float f7 = fArr2[fArr.length - 1];
                    if (f6 == 0.0f) {
                        return 0.0f;
                    }
                    return f * (f7 / f6);
                }
                if (i2 == -1) {
                    float f8 = fArr[0];
                    f4 = fArr2[0];
                    f3 = f8;
                    f2 = 0.0f;
                } else {
                    float f9 = fArr[i2];
                    float f10 = fArr[i];
                    f2 = fArr2[i2];
                    f5 = f9;
                    f3 = f10;
                    f4 = fArr2[i];
                }
                fA = C24960zV3.a.a(f2, f4, f5, f3, fAbs);
            }
            return fSignum * fA;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C22840vu2(float[] fArr, float[] fArr2) {
        if (fArr.length != fArr2.length || fArr.length == 0) {
            throw new IllegalArgumentException("Array lengths must match and be nonzero".toString());
        }
        this.a = fArr;
        this.b = fArr2;
    }

    @Override // ir.nasim.InterfaceC21654tu2
    public float a(float f) {
        return c.b(f, this.b, this.a);
    }

    @Override // ir.nasim.InterfaceC21654tu2
    public float b(float f) {
        return c.b(f, this.a, this.b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof C22840vu2)) {
            return false;
        }
        C22840vu2 c22840vu2 = (C22840vu2) obj;
        return Arrays.equals(this.a, c22840vu2.a) && Arrays.equals(this.b, c22840vu2.b);
    }

    public int hashCode() {
        return (Arrays.hashCode(this.a) * 31) + Arrays.hashCode(this.b);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontScaleConverter{fromSpValues=");
        String string = Arrays.toString(this.a);
        AbstractC13042fc3.h(string, "toString(...)");
        sb.append(string);
        sb.append(", toDpValues=");
        String string2 = Arrays.toString(this.b);
        AbstractC13042fc3.h(string2, "toString(...)");
        sb.append(string2);
        sb.append('}');
        return sb.toString();
    }
}
