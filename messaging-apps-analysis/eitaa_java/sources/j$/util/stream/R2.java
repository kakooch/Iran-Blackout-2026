package j$.util.stream;

import java.util.Arrays;

/* loaded from: classes2.dex */
final class R2 extends F2 {
    private int[] c;
    private int d;

    R2(C2 c2) {
        super(c2);
    }

    @Override // j$.util.stream.C2.f, j$.util.stream.C2, j$.util.function.y
    public void accept(int i) {
        int[] iArr = this.c;
        int i2 = this.d;
        this.d = i2 + 1;
        iArr[i2] = i;
    }

    @Override // j$.util.stream.C2.b, j$.util.stream.C2
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

    @Override // j$.util.stream.C2.b, j$.util.stream.C2
    public void m(long j) {
        if (j >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.c = new int[(int) j];
    }
}
