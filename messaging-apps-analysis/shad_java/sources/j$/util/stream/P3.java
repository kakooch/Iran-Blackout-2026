package j$.util.stream;

import java.util.Arrays;

/* loaded from: classes2.dex */
final class P3 extends D3 {
    private int[] c;
    private int d;

    P3(InterfaceC0192m3 interfaceC0192m3) {
        super(interfaceC0192m3);
    }

    @Override // j$.util.stream.InterfaceC0180k3, j$.util.stream.InterfaceC0192m3
    public void accept(int i) {
        int[] iArr = this.c;
        int i2 = this.d;
        this.d = i2 + 1;
        iArr[i2] = i;
    }

    @Override // j$.util.stream.AbstractC0156g3, j$.util.stream.InterfaceC0192m3
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
        this.c = new int[(int) j];
    }
}
