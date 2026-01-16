package j$.util.stream;

import java.util.Arrays;

/* loaded from: classes2.dex */
final class Q3 extends E3 {
    private long[] c;
    private int d;

    Q3(InterfaceC0192m3 interfaceC0192m3) {
        super(interfaceC0192m3);
    }

    @Override // j$.util.stream.InterfaceC0186l3, j$.util.function.q
    public void accept(long j) {
        long[] jArr = this.c;
        int i = this.d;
        this.d = i + 1;
        jArr[i] = j;
    }

    @Override // j$.util.stream.AbstractC0162h3, j$.util.stream.InterfaceC0192m3
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
        this.c = new long[(int) j];
    }
}
