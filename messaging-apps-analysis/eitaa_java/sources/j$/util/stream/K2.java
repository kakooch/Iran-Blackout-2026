package j$.util.stream;

import j$.util.stream.U2;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class K2 extends G2 {
    private U2.d c;

    K2(C2 c2) {
        super(c2);
    }

    @Override // j$.util.stream.C2.g, j$.util.stream.C2
    public void accept(long j) {
        this.c.accept(j);
    }

    @Override // j$.util.stream.C2.c, j$.util.stream.C2
    public void l() {
        long[] jArr = (long[]) this.c.e();
        Arrays.sort(jArr);
        this.a.m(jArr.length);
        int i = 0;
        if (this.b) {
            int length = jArr.length;
            while (i < length) {
                long j = jArr[i];
                if (this.a.o()) {
                    break;
                }
                this.a.accept(j);
                i++;
            }
        } else {
            int length2 = jArr.length;
            while (i < length2) {
                this.a.accept(jArr[i]);
                i++;
            }
        }
        this.a.l();
    }

    @Override // j$.util.stream.C2.c, j$.util.stream.C2
    public void m(long j) {
        if (j >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.c = j > 0 ? new U2.d((int) j) : new U2.d();
    }
}
