package j$.util.stream;

import java.util.Arrays;

/* loaded from: classes2.dex */
final class G3 extends C3 {
    private U3 c;

    G3(InterfaceC0192m3 interfaceC0192m3) {
        super(interfaceC0192m3);
    }

    @Override // j$.util.stream.InterfaceC0174j3, j$.util.stream.InterfaceC0192m3
    public void accept(double d) {
        this.c.accept(d);
    }

    @Override // j$.util.stream.AbstractC0150f3, j$.util.stream.InterfaceC0192m3
    public void n() {
        double[] dArr = (double[]) this.c.g();
        Arrays.sort(dArr);
        this.a.o(dArr.length);
        int i = 0;
        if (this.b) {
            int length = dArr.length;
            while (i < length) {
                double d = dArr[i];
                if (this.a.p()) {
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
        this.a.n();
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public void o(long j) {
        if (j >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.c = j > 0 ? new U3((int) j) : new U3();
    }
}
