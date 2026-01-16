package j$.util.stream;

import j$.util.stream.U2;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class I2 extends E2 {
    private U2.b c;

    I2(C2 c2) {
        super(c2);
    }

    @Override // j$.util.stream.C2.e, j$.util.stream.C2
    public void accept(double d) {
        this.c.accept(d);
    }

    @Override // j$.util.stream.C2.a, j$.util.stream.C2
    public void l() {
        double[] dArr = (double[]) this.c.e();
        Arrays.sort(dArr);
        this.a.m(dArr.length);
        int i = 0;
        if (this.b) {
            int length = dArr.length;
            while (i < length) {
                double d = dArr[i];
                if (this.a.o()) {
                    break;
                }
                this.a.accept(d);
                i++;
            }
        } else {
            int length2 = dArr.length;
            while (i < length2) {
                this.a.accept(dArr[i]);
                i++;
            }
        }
        this.a.l();
    }

    @Override // j$.util.stream.C2.a, j$.util.stream.C2
    public void m(long j) {
        if (j >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.c = j > 0 ? new U2.b((int) j) : new U2.b();
    }
}
