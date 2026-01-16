package ir.nasim;

import java.text.DecimalFormat;
import java.util.Arrays;

/* loaded from: classes2.dex */
public abstract class MI6 {
    protected AbstractC6522Nw1 a;
    protected int[] b = new int[10];
    protected float[] c = new float[10];
    private int d;
    private String e;

    private static class a {
        static void a(int[] iArr, float[] fArr, int i, int i2) {
            int[] iArr2 = new int[iArr.length + 10];
            iArr2[0] = i2;
            iArr2[1] = i;
            int i3 = 2;
            while (i3 > 0) {
                int i4 = iArr2[i3 - 1];
                int i5 = i3 - 2;
                int i6 = iArr2[i5];
                if (i4 < i6) {
                    int iB = b(iArr, fArr, i4, i6);
                    iArr2[i5] = iB - 1;
                    iArr2[i3 - 1] = i4;
                    int i7 = i3 + 1;
                    iArr2[i3] = i6;
                    i3 += 2;
                    iArr2[i7] = iB + 1;
                } else {
                    i3 = i5;
                }
            }
        }

        private static int b(int[] iArr, float[] fArr, int i, int i2) {
            int i3 = iArr[i2];
            int i4 = i;
            while (i < i2) {
                if (iArr[i] <= i3) {
                    c(iArr, fArr, i4, i);
                    i4++;
                }
                i++;
            }
            c(iArr, fArr, i4, i2);
            return i4;
        }

        private static void c(int[] iArr, float[] fArr, int i, int i2) {
            int i3 = iArr[i];
            iArr[i] = iArr[i2];
            iArr[i2] = i3;
            float f = fArr[i];
            fArr[i] = fArr[i2];
            fArr[i2] = f;
        }
    }

    public float a(float f) {
        return (float) this.a.c(f, 0);
    }

    public float b(float f) {
        return (float) this.a.f(f, 0);
    }

    public void c(int i, float f) {
        int[] iArr = this.b;
        if (iArr.length < this.d + 1) {
            this.b = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.c;
            this.c = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.b;
        int i2 = this.d;
        iArr2[i2] = i;
        this.c[i2] = f;
        this.d = i2 + 1;
    }

    public void d(String str) {
        this.e = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e(int r10) {
        /*
            r9 = this;
            int r0 = r9.d
            if (r0 != 0) goto L5
            return
        L5:
            int[] r1 = r9.b
            float[] r2 = r9.c
            r3 = 1
            int r0 = r0 - r3
            r4 = 0
            ir.nasim.MI6.a.a(r1, r2, r4, r0)
            r0 = r3
            r1 = r0
        L11:
            int r2 = r9.d
            if (r0 >= r2) goto L24
            int[] r2 = r9.b
            int r5 = r0 + (-1)
            r5 = r2[r5]
            r2 = r2[r0]
            if (r5 == r2) goto L21
            int r1 = r1 + 1
        L21:
            int r0 = r0 + 1
            goto L11
        L24:
            double[] r0 = new double[r1]
            r2 = 2
            int[] r2 = new int[r2]
            r2[r3] = r3
            r2[r4] = r1
            java.lang.Class r1 = java.lang.Double.TYPE
            java.lang.Object r1 = java.lang.reflect.Array.newInstance(r1, r2)
            double[][] r1 = (double[][]) r1
            r2 = r4
            r3 = r2
        L37:
            int r5 = r9.d
            if (r2 >= r5) goto L63
            if (r2 <= 0) goto L48
            int[] r5 = r9.b
            r6 = r5[r2]
            int r7 = r2 + (-1)
            r5 = r5[r7]
            if (r6 != r5) goto L48
            goto L60
        L48:
            int[] r5 = r9.b
            r5 = r5[r2]
            double r5 = (double) r5
            r7 = 4576918229304087675(0x3f847ae147ae147b, double:0.01)
            double r5 = r5 * r7
            r0[r3] = r5
            r5 = r1[r3]
            float[] r6 = r9.c
            r6 = r6[r2]
            double r6 = (double) r6
            r5[r4] = r6
            int r3 = r3 + 1
        L60:
            int r2 = r2 + 1
            goto L37
        L63:
            ir.nasim.Nw1 r10 = ir.nasim.AbstractC6522Nw1.a(r10, r0, r1)
            r9.a = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.MI6.e(int):void");
    }

    public String toString() {
        String str = this.e;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i = 0; i < this.d; i++) {
            str = str + "[" + this.b[i] + " , " + decimalFormat.format(this.c[i]) + "] ";
        }
        return str;
    }
}
