package j$.util.stream;

import java.util.Arrays;

/* loaded from: classes2.dex */
final class O3 extends C3 {
    private double[] c;
    private int d;

    O3(InterfaceC0192m3 interfaceC0192m3) {
        super(interfaceC0192m3);
    }

    @Override // j$.util.stream.InterfaceC0174j3, j$.util.stream.InterfaceC0192m3
    public void accept(double d) {
        double[] dArr = this.c;
        int i = this.d;
        this.d = i + 1;
        dArr[i] = d;
    }

    @Override // j$.util.stream.AbstractC0150f3, j$.util.stream.InterfaceC0192m3
    public void n() {
        int i = 0;
        Arrays.sort(this.c, 0, this.d);
        this.a.o(this.d);
        if (this.b) {
            while (i < this.d && !this.a.p()) {
                this.a.accept(this.c[i]);
                i++;
            }
        } else {
            while (i < this.d) {
                this.a.accept(this.c[i]);
                i++;
            }
        }
        this.a.n();
        this.c = null;
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public void o(long j) {
        if (j >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.c = new double[(int) j];
    }
}
