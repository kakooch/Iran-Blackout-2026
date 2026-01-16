package j$.util.stream;

import j$.util.stream.U2;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class J2 extends F2 {
    private U2.c c;

    J2(C2 c2) {
        super(c2);
    }

    @Override // j$.util.stream.C2.f, j$.util.stream.C2, j$.util.function.y
    public void accept(int i) {
        this.c.accept(i);
    }

    @Override // j$.util.stream.C2.b, j$.util.stream.C2
    public void l() {
        int[] iArr = (int[]) this.c.e();
        Arrays.sort(iArr);
        this.a.m(iArr.length);
        int i = 0;
        if (this.b) {
            int length = iArr.length;
            while (i < length) {
                int i2 = iArr[i];
                if (this.a.o()) {
                    break;
                }
                this.a.accept(i2);
                i++;
            }
        } else {
            int length2 = iArr.length;
            while (i < length2) {
                this.a.accept(iArr[i]);
                i++;
            }
        }
        this.a.l();
    }

    @Override // j$.util.stream.C2.b, j$.util.stream.C2
    public void m(long j) {
        if (j >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.c = j > 0 ? new U2.c((int) j) : new U2.c();
    }
}
