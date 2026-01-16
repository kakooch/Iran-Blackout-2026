package j$.util.stream;

import java.util.Arrays;

/* loaded from: classes2.dex */
final class S2 extends G2 {
    private long[] c;
    private int d;

    S2(C2 c2) {
        super(c2);
    }

    @Override // j$.util.stream.C2.g, j$.util.stream.C2
    public void accept(long j) {
        long[] jArr = this.c;
        int i = this.d;
        this.d = i + 1;
        jArr[i] = j;
    }

    @Override // j$.util.stream.C2.c, j$.util.stream.C2
    public void l() {
        int i = 0;
        Arrays.sort(this.c, 0, this.d);
        this.a.m(this.d);
        if (this.b) {
            while (i < this.d && !this.a.o()) {
                this.a.accept(this.c[i]);
                i++;
            }
        } else {
            while (i < this.d) {
                this.a.accept(this.c[i]);
                i++;
            }
        }
        this.a.l();
        this.c = null;
    }

    @Override // j$.util.stream.C2.c, j$.util.stream.C2
    public void m(long j) {
        if (j >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.c = new long[(int) j];
    }
}
