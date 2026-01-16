package ir.nasim;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.Arrays;

/* renamed from: ir.nasim.vM6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C22512vM6 extends J22 {
    C14932ij4 d;

    C22512vM6(String str) {
        this.a = str;
        double[] dArr = new double[str.length() / 2];
        int iIndexOf = str.indexOf(40) + 1;
        int iIndexOf2 = str.indexOf(44, iIndexOf);
        int i = 0;
        while (iIndexOf2 != -1) {
            dArr[i] = Double.parseDouble(str.substring(iIndexOf, iIndexOf2).trim());
            iIndexOf = iIndexOf2 + 1;
            iIndexOf2 = str.indexOf(44, iIndexOf);
            i++;
        }
        dArr[i] = Double.parseDouble(str.substring(iIndexOf, str.indexOf(41, iIndexOf)).trim());
        this.d = d(Arrays.copyOf(dArr, i + 1));
    }

    private static C14932ij4 d(double[] dArr) {
        int length = (dArr.length * 3) - 2;
        int length2 = dArr.length - 1;
        double d = 1.0d / length2;
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, 1);
        double[] dArr3 = new double[length];
        for (int i = 0; i < dArr.length; i++) {
            double d2 = dArr[i];
            int i2 = i + length2;
            dArr2[i2][0] = d2;
            double d3 = i * d;
            dArr3[i2] = d3;
            if (i > 0) {
                int i3 = (length2 * 2) + i;
                dArr2[i3][0] = d2 + 1.0d;
                dArr3[i3] = d3 + 1.0d;
                int i4 = i - 1;
                dArr2[i4][0] = (d2 - 1.0d) - d;
                dArr3[i4] = (d3 - 1.0d) - d;
            }
        }
        C14932ij4 c14932ij4 = new C14932ij4(dArr3, dArr2);
        PrintStream printStream = System.out;
        printStream.println(" 0 " + c14932ij4.c(0.0d, 0));
        printStream.println(" 1 " + c14932ij4.c(1.0d, 0));
        return c14932ij4;
    }

    @Override // ir.nasim.J22
    public double a(double d) {
        return this.d.c(d, 0);
    }

    @Override // ir.nasim.J22
    public double b(double d) {
        return this.d.f(d, 0);
    }
}
